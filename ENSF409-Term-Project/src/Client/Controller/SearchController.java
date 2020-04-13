package Client.Controller;

import Client.View.SearchView;
import Util.Course;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Controller for the Search View
 *
 * @author Branden Wong - 30040675
 * @author Savipal Jessel - 30039257
 * @version 1.0
 */
public class SearchController {
    /**
     * The command number associated with the search student function
     */
    private final String commandNum = "1";

    /**
     * The search view
     */
    private SearchView searchView;

    /**
     * The communication object to be used for send data to the server
     */
    private Communication communication;

    /**
     * A course object for the course the student will be enrolled in
     */
    private Course course;

    /**
     * Constructs the search controller, assigns the Search view, and adds the listeners for the search and cancel buttons.
     * @param searchView the Search View
     * @param communication the communication object to be used for send data to the server
     */
    public SearchController(SearchView searchView, Communication communication){
        this.searchView = searchView;
        searchView.addSearchListener(new SearchListener());
        searchView.addCancelListener(new CancelListener());
        this.communication = communication;

    }

    /**
     * The listener for the search button
     */
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
            // engage communications between the client and server
            course = (Course)communication.communicate(course, commandNum);
            if(course != null){
                searchView.sendDialogueMessage(course.toString());
            }else{
                searchView.sendDialogueMessage("Course Not Found!");
            }

        }
        //
    }


    /**
     * The listener for the cancel button
     */
    public class CancelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            searchView.clearTextFields();
            searchView.setVisible(false);

        }
        //
    }


}
