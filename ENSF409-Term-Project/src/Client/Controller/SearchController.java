package Client.Controller;

import Client.Model.Course;
import Client.View.SearchView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SearchController {
    private final String commandNum = "1";
    private SearchView searchView;
    private Communication communication;
    private Course course;

    public SearchController(SearchView searchView, Communication communication){
        this.searchView = searchView;
        searchView.addSearchListener(new SearchListener());
        searchView.addCancelListener(new CancelListener());
        this.communication = communication;

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
                    return;
                }
            }
            int courseNum;
            try{
                courseNum = Integer.parseInt(fields.get(1));
            }catch(NumberFormatException ex){
                searchView.sendDialogueMessage("please enter a proper course number");
                return;
            }catch(Exception ex){
                searchView.sendDialogueMessage("something went wrong, please try again.");
                return;
            }

            course = new Course(fields.get(0), courseNum);
            communication.communicate(course, commandNum);

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
