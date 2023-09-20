import view.CandidateManagement;
import view.MenuModel;
import view.Menu;

public class Main {

    public static void main(String[] args) {
        MenuModel model = new MenuModel();
        Menu view = new Menu(model);
        CandidateManagement manager = new CandidateManagement(model, view);

        manager.startMenu();
    }
}