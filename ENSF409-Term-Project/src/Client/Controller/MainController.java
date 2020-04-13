package Client.Controller;

import Client.View.*;
import Util.Course;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controller for the Main View
 *
 * @author Branden Wong - 30040675
 * @author Savipal Jessel - 30039257
 * @version 1.0
 */
public class MainController {
    /**
     * The command number associated with the view catalogue function
     */
    private final String catCommandNum = "2";

    /**
     * The command number associated with the view student function
     */
    private final String stuCommandNum = "4";

    /**
     * The main view
     */
    private MainView mainView;

    /**
     * The enroll view
     */
    private EnrollView enrollView;

    /**
     * The remove view
     */
    private RemoveView removeView;

    /**
     * The search view
     */
    private SearchView searchView;

    /**
     * The communication object to be used for send data to the server
     */
    private Communication communication;

    /**
     * Constructs the main controller, assigns the Main, Enroll, Remove, and Search Views, and adds the listeners for the Enroll,
     * Remove, Search, View Catalogue, and View Student buttons.
     *
     * @param mainView      the main view
     * @param enrollView    the enroll view
     * @param removeView    the remove view
     * @param searchView    the search view
     * @param communication the communication object to be used for send data to the server
     */
    public MainController(MainView mainView, EnrollView enrollView, RemoveView removeView, SearchView searchView, Communication communication) {

        this.mainView = mainView;
        this.enrollView = enrollView;
        this.removeView = removeView;
        this.searchView = searchView;
        this.communication = communication;
        mainView.addEnrollListener(new EnrollListener());
        mainView.addRemoveListener(new RemoveListener());
        mainView.addSearchListener(new SearchListener());
        mainView.addViewCatListener(new ViewCatListener());
        mainView.addViewStuListener(new ViewStuListener());

    }

    /**
     * The listener for the enroll button.
     */
    public class EnrollListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            enrollView.setVisible(true);
        }
        //
    }

    /**
     * The listener for the remove button.
     */
    public class RemoveListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            removeView.setVisible(true);
        }
        //
    }

    /**
     * The listener for the search button.
     */
    public class SearchListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            searchView.setVisible(true);

        }
        //
    }

    /**
     * The listener for the View Student button
     */
    public class ViewStuListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String studentID = mainView.getStudentID();

            String student = (String) communication.communicate(studentID, stuCommandNum);
            if (student == null) {
                mainView.sendDialogueMessage("There is no student with this ID!");
            }
            mainView.setInfo(student);
        }
        //
    }

    /**
     * The listener for the View Catalogue button
     */
    public class ViewCatListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            mainView.setInfo(communication.communicate(catCommandNum));

        }

    }
}