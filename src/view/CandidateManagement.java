package view;

import controller.Validate;
import controller.Validate;
import model.Intern;
import model.Fresher;
import model.Experience;
import model.Candidate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class CandidateManagement {

    private MenuModel model;
    private Menu view;

    public CandidateManagement(MenuModel model, Menu view) {
        this.model = model;
        this.view = view;
    }


        public void startMenu() {
        ArrayList<Candidate> candidates = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            view.displayMenu();
            int choice = view.getUserChoice();

            switch (choice) {
                case 1:
                    createCandidate(candidates, 0);
                    break;
                case 2:
                   createCandidate(candidates, 1);
                    break;
                case 3:
                    createCandidate(candidates, 2);
                    break;
                case 4:
                    searchCandidate(candidates);
                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void createCandidate(ArrayList<Candidate> candidates,
            int type) {

        while (true) {
            System.out.print("Enter id: ");
            String id = Validate.checkString();
            System.out.print("Enter first name: ");
            String firstName = Validate.checkString();
            System.out.print("Enter last name: ");
            String lastName = Validate.checkString();
            System.out.print("Enter birth date: ");
            int birthDate = Validate.checkInputIntLimit(1900,
                    Calendar.getInstance().get(Calendar.YEAR));
            System.out.print("Enter address: ");
            String address = Validate.checkString();
            System.out.print("Enter phone: ");
            String phone = Validate.checkPhone();
            System.out.print("Enter email: ");
            String email = Validate.checkEmail();

            Candidate candidate = new Candidate(id, firstName, lastName,
                    birthDate, address, phone, email, type);

            if (Validate.checkIdExist(candidates, id)) {
                switch (type) {
                    case 0:
                        createExperience(candidates, candidate);
                        break;
                    case 1:
                        createFresher(candidates, candidate);
                        break;
                    case 2:
                        createInternship(candidates, candidate);
                        break;
                }
            } else {
                return;
            }
            System.out.print("Do you want to continue (Y/N): ");

            if (!Validate.checkvalidiinput()) {
                return;
            }
        }
    }

    public static void createExperience(ArrayList<Candidate> candidates,
            Candidate candidate) {
        System.out.print("Enter year of experience: ");
        int yearExperience = Validate.checkInputExprience(candidate.getBirthDate());
        System.out.print("Enter professional skill: ");
        String professionalSkill = Validate.checkString();
        candidates.add(new Experience(yearExperience, professionalSkill,
                candidate.getId(), candidate.getFirstName(), candidate.getLastName(),
                candidate.getBirthDate(), candidate.getAddress(),
                candidate.getPhone(), candidate.getEmail(), candidate.getTypeCandidate()));
        System.err.println("Create success.");
    }

    public static void createFresher(ArrayList<Candidate> candidates,
            Candidate candidate) {
        System.out.print("Enter graduation date: ");
        String graduationDate = Validate.checkString();
        System.out.print("Enter graduation rank: ");
        String graduationRank = Validate.checkRank();
        candidates.add(new Fresher(graduationDate, graduationRank, candidate.getId(),
                candidate.getFirstName(), candidate.getLastName(),
                candidate.getBirthDate(), candidate.getAddress(),
                candidate.getPhone(), candidate.getEmail(),
                candidate.getTypeCandidate()));
        System.err.println("Create success.");
    }

    public static void createInternship(ArrayList<Candidate> candidates,
            Candidate candidate) {
        System.out.print("Enter major: ");
        String major = Validate.checkString();
        System.out.print("Enter semester: ");
        String semester = Validate.checkString();
        System.out.print("Enter university: ");
        String university = Validate.checkString();
        candidates.add(new Intern(major, semester, university, candidate.getId(),
                candidate.getFirstName(), candidate.getLastName(),
                candidate.getBirthDate(), candidate.getAddress(),
                candidate.getPhone(), candidate.getEmail(),
                candidate.getTypeCandidate()));
        System.err.println("Create success.");
    }

    public static void searchCandidate(ArrayList<Candidate> candidates) {
        printListNameCandidate(candidates);
        System.out.print("Enter candidate name (First name or Last name): ");
        String nameSearch = Validate.checkString();
        System.out.print("Input type of candidate: ");
        int type = Validate.checkInputIntLimit(0, 2);

        boolean found = false; // Track if any candidates are found

        for (Candidate candidate : candidates) {
            if (candidate.getTypeCandidate() == type
                    && (candidate.getFirstName().toLowerCase().contains(nameSearch.toLowerCase())
                    || candidate.getLastName().toLowerCase().contains(nameSearch.toLowerCase()))) {
                System.out.println("The candidates found:");
                System.out.println(candidate.toString());
                found = true; // Set to true if at least one candidate is found
            }
        }

        if (!found) {
            System.out.println("No candidates found.");
        }
    }

    public static void printListNameCandidate(ArrayList<Candidate> candidates) {
        System.out.println("List of candidate:");
        System.out.println("===========EXPERIENCE CANDIDATE============");
        for (Candidate candidate : candidates) {
            if (candidate.getTypeCandidate() == 0) { // 0 là kiểu dành cho Experience
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
            }
        }
        System.out.println("==========FRESHER CANDIDATE==============");
        for (Candidate candidate : candidates) {
            if (candidate.getTypeCandidate() == 1) { // 1 là kiểu dành cho Fresher
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
            }
        }
        System.out.println("===========INTERN CANDIDATE==============");
        for (Candidate candidate : candidates) {
            if (candidate.getTypeCandidate() == 2) { // 2 là kiểu dành cho Internship
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
            }
        }
    }
}