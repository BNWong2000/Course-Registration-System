package Client.Controller;

import Client.View.RemoveView;
import Util.Course;
import Util.Student;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Controller for the Remove View
 *
 * @author Branden Wong - 30040675
 * @author Savipal Jessel - 30039257
 * @version 1.0
 */

public class RemoveController {
    /**
     * The command number associated with the remove student from course function
     */
    private final String commandNum = "3";

    /**
     * The remove view
     */
    private RemoveView removeView;

    /**
     * The communication object to be used for send data to the server
     */
    private Communication communication;

    /**
     * A course object for the course the student will be enrolled in
     */
    private Course course;

    /**
     * A student object for the student that will be enrolled
     */
    private Student student;

    /**
     * Constructs the remove controller, assigns the Remove View, and adds the listeners for the remove and cancel buttons.
     *
     * @param removeView    the Remove View
     * @param communication the communication object to be used for send data to the server
     */
    public RemoveController(RemoveView removeView, Communication communication) {
        this.removeView = removeView;
        removeView.addRemoveListener(new RemoveListener());
        removeView.addCancelListener(new CancelListener());
        this.communication = communication;
    }

    /**
     * The listener for the remove button
     */
    public class RemoveListener implements ActionListener {
        @Override

        public void actionPerformed(ActionEvent e) {


            ArrayList<String> fields = new ArrayList<String>(removeView.getFields());
            // check if any of the fields are empty
            for (String s : fields) {
                if (s.equals("")) {
                    removeView.sendDialogueMessage("One or more of the fields is empty");
                    return;
                }
            }
            int courseNum;
            int studentNum;
            try {
                courseNum = Integer.parseInt(fields.get(3));
                studentNum = Integer.parseInt(fields.get(1));
            } catch (NumberFormatException ex) {
                removeView.sendDialogueMessage("please enter a proper course or student number");
                return;
            } catch (Exception ex) {
                removeView.sendDialogueMessage("something went wrong, please try again.");
                return;
            }

            course = new Course(fields.get(2), courseNum);
            student = new Student(fields.get(0), studentNum);
            // Engage communication between the client and server
            String output = (String) communication.communicate(student, course, commandNum);
            removeView.sendDialogueMessage(output);

        }
        //
    }

    /**
     * The listener for the cancel button
     */
    public class CancelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            removeView.clearTextFields();
            removeView.setVisible(false);

        }
        //
    }
}
