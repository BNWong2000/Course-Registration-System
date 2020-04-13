package Client.Controller;

import Client.View.EnrollView;
import Client.View.RemoveView;
import Util.Course;
import Util.Student;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
/**
 * Controller for the Enroll View
 *
 * @author Branden Wong - 30040675
 * @author Savipal Jessel - 30039257
 *
 * @version 1.0
 */
public class EnrollController {
    /**
     * The command number associated with the enroll student function
     */
    private final String commandNum = "5";

    /**
     * The enroll view
     */
    private EnrollView enrollView;

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
     * Constructs the Enroll Controller, assigns the Enroll View, and adds the listeners for the enroll and cancel buttons.
     * @param enrollView the enroll view
     * @param communication the communication object to be used for data transfer
     */
    public EnrollController(EnrollView enrollView, Communication communication){
        this.enrollView = enrollView;
        enrollView.addEnrollListener(new EnrollController.EnrollListener());
        enrollView.addCancelListener(new EnrollController.CancelListener());
        this.communication = communication;
    }

    /**
     * The listener for the enroll button.
     */
    public class EnrollListener implements ActionListener {
        @Override

        public void actionPerformed(ActionEvent e) {


            ArrayList<String> fields = new ArrayList<String>(enrollView.getFields());
            // check if any of the fields are empty
            for (String s : fields) {
                if (s.equals("")) {
                    enrollView.sendDialogueMessage("One or more of the fields is empty");
                    return;
                }
            }
            int courseNum;
            int studentNum;
            Integer sectionNum;
            try{
                courseNum = Integer.parseInt(fields.get(3));
                studentNum = Integer.parseInt(fields.get(1));
                sectionNum = Integer.parseInt(fields.get(4));
            }catch(NumberFormatException ex){
                enrollView.sendDialogueMessage("please enter a proper course or student number");
                return;
            }catch(Exception ex){
                enrollView.sendDialogueMessage("something went wrong, please try again.");
                return;
            }

            course = new Course(fields.get(2), courseNum);
            student = new Student(fields.get(0), studentNum);
            // Engage communications between client and server
            String output = (String) communication.communicate(student,course,sectionNum,commandNum);
            enrollView.sendDialogueMessage(output);

        }

    }

    /**
     * The listener for the cancel button.
     */
    public class CancelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            enrollView.clearTextFields();
            enrollView.setVisible(false);

        }
        //
    }
}
