package Client.Controller;

import Client.View.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController {

    private MainView mainView;
    private EnrollView enrollView;
    private RemoveView removeView;
    private SearchView searchView;
    private ViewStuView viewStuView;
    private ViewCatView viewCatView;


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
            viewStuView.setVisible(true);
        }
        //
    }

    public class ViewCatListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            viewCatView.setVisible(true);
        }
        //
    }
}
