package Client.Controller;

import Client.View.EnrollView;
import Client.View.RemoveView;
import Util.Course;
import Util.Student;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EnrollController {
    private final String commandNum = "5";
    private EnrollView enrollView;
    private Communication communication;
    private Course course;
    private Student student;

    public EnrollController(EnrollView enrollView, Communication communication){
        this.enrollView = enrollView;
        enrollView.addEnrollListener(new EnrollController.EnrollListener());
        enrollView.addCancelListener(new EnrollController.CancelListener());
        this.communication = communication;
    }

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
            String output = (String)communication.communicate(student, course, sectionNum, commandNum);
            enrollView.sendDialogueMessage(output);

        }
        //
    }

    public class CancelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            enrollView.clearTextFields();
            enrollView.setVisible(false);

        }
        //
    }
}
