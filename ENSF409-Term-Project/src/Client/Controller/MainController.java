package Client.Controller;

import Client.View.*;
import Util.Course;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController {
    private final String catCommandNum = "2";
    private final String stuCommandNum = "4";
    private MainView mainView;
    private EnrollView enrollView;
    private RemoveView removeView;
    private SearchView searchView;
    private Communication communication;

    public MainController(MainView mainView, EnrollView enrollView, RemoveView removeView, SearchView searchView,Communication communication){

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


    public class EnrollListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            enrollView.setVisible(true);
        }
        //
    }

    public class RemoveListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            removeView.setVisible(true);
        }
        //
    }

    public class SearchListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            searchView.setVisible(true);

        }
        //
    }

    public class ViewStuListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String studentID = mainView.getStudentID();

            String student = (String)communication.communicate(studentID, stuCommandNum);
            if (student == null){
                mainView.sendDialogueMessage("There is no student with this ID!");
            }
            mainView.setInfo(student);







        }
        //
    }

    public class ViewCatListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

            mainView.setInfo(communication.communicate(catCommandNum));

        }

    }
}