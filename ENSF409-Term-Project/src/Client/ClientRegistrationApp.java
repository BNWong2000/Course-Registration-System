package Client;

import Client.Controller.*;
import Client.View.*;

/**
 * Runs the client-side Application.
 *
 * @author Branden Wong - 30040675
 * @author Savipal Jessel - 30039257
 */
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
        EnrollController enrollController = new EnrollController(enrollView, communicate);
        mainView.setVisible(true);
    }
}
