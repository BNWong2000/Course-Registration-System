package Client;

import Client.Controller.*;
import Client.View.*;

public class ClientRegistrationApp {
    public static void main(String[] args){
        EnrollView enrollView = new EnrollView();
        SearchView searchView = new SearchView();
        RemoveView removeView = new RemoveView();
        ViewCatView viewCatView = new ViewCatView();
        ViewStuView viewStuView = new ViewStuView();
        MainView mainView = new MainView();
        MainController mainController = new MainController(mainView, enrollView, removeView, searchView, viewStuView, viewCatView);
        SearchController searchController = new SearchController(searchView);
        mainView.setVisible(true);
    }
}
