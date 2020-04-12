package Client.Controller;

import Client.View.SearchView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SearchController {

    private SearchView searchView;
    private Communication communication;


    public SearchController(SearchView searchView, Communication communication){
        this.searchView = searchView;
        searchView.addSearchListener(new SearchListener());
        searchView.addCancelListener(new CancelListener());
        this.communication = communication;

    }

    public class SearchListener implements ActionListener {
        @Override

        public void actionPerformed(ActionEvent e) {

            ArrayList<String> fields = new ArrayList<String>(searchView.getFields());
            // check if any of the fields are empty
            for (String s : fields) {
                if (s.equals("")) {
                    searchView.sendDialogueMessage("One or more of the fields is empty");
                    return;
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
