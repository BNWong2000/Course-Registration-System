package Client;

import Client.Controller.*;
import Client.View.*;

public class ClientRegistrationApp {
    public static void main(String[] args){
        EnrollView enrollView = new EnrollView();
        SearchView searchView = new SearchView();
        RemoveView removeView = new RemoveView();
        MainView mainView = new MainView();
        mainView.setVisible(true);
        Communication communicate =  new Communication("localhost", 8099);
        MainController mainController = new MainController(mainView, enrollView, removeView, searchView,communicate);
        SearchController searchController = new SearchController(searchView, communicate);
        RemoveController removeController = new RemoveController(removeView, communicate);
        mainView.setVisible(true);
    }
}
