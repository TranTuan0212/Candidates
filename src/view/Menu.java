package view;

import java.util.Scanner;

public class Menu {
    private MenuModel model;
    private Scanner scanner;

    public Menu(MenuModel model) {
        this.model = model;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        String[] menuItems = model.getMenuItems();

        System.out.println("===== Menu =====");
        for (int i = 0; i < menuItems.length; i++) {
            System.out.println((i + 1) + ". " + menuItems[i]);
        }
    }

    public int getUserChoice() {
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }
}