package Client.Controller;

import Client.View.SearchView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SearchController {

    private SearchView searchView;

    public SearchController(SearchView searchView){
        this.searchView = searchView;
        searchView.addSearchListener(new SearchListener());
        searchView.addCancelListener(new CancelListener());
    }

    public class SearchListener implements ActionListener {
        @Override

        public void actionPerformed(ActionEvent e) {
            // List to contain the id, faculty, major, and year
            ArrayList<String> fields = new ArrayList<String>(searchView.getFields());
            // check if any of the fields are empty
            for (String s : fields) {
                if (s.equals("")) {
                    searchView.sendDialogueMessage("One or more of the fields is empty");
                    return
                }
            }


        }
        //
    }

    public class CancelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //searchView.clearTextFields();
            searchView.setVisible(false);

        }
        //
    }


}
