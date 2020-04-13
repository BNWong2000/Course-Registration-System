package Client.Controller;

import Client.View.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController {

    private MainView mainView;
    private EnrollView enrollView;
    private RemoveView removeView;
    private SearchView searchView;

    public MainController(MainView mainView, EnrollView enrollView, RemoveView removeView, SearchView searchView){

        this.mainView = mainView;
        this.enrollView = enrollView;
        this.removeView = removeView;
        this.searchView = searchView;
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
            //
        }
        //
    }

    public class ViewCatListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            //
        }
        //
    }
}
