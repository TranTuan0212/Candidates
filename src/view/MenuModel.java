package view;

public class MenuModel {
    private String[] menuItems = {
        "Create Experience Candidate",
        "Create Fresher Candidate",
        "Create Internship Candidate",
        "Search Candidates",
        "Exit"
    };

    private int selectedMenuItem;

    public String[] getMenuItems() {
        return menuItems;
    }

    public void setSelectedMenuItem(int selectedMenuItem) {
        this.selectedMenuItem = selectedMenuItem;
    }

    public int getSelectedMenuItem() {
        return selectedMenuItem;
    }
}