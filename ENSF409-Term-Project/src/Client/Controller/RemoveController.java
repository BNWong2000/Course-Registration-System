package Client.Controller;

import Client.View.RemoveView;
import Util.Course;
import Util.Student;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RemoveController {
    private final String commandNum = "3";
    private RemoveView removeView;
    private Communication communication;
    private Course course;
    private Student student;

    public RemoveController(RemoveView removeView, Communication communication){
        this.removeView = removeView;
        removeView.addRemoveListener(new RemoveListener());
        removeView.addCancelListener(new CancelListener());
        this.communication = communication;
    }

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
            try{
                courseNum = Integer.parseInt(fields.get(3));
                studentNum = Integer.parseInt(fields.get(1));
            }catch(NumberFormatException ex){
                removeView.sendDialogueMessage("please enter a proper course or student number");
                return;
            }catch(Exception ex){
                removeView.sendDialogueMessage("something went wrong, please try again.");
                return;
            }

            course = new Course(fields.get(2), courseNum);
            student = new Student(fields.get(0), studentNum);
            String output = (String)communication.communicate(student, course, commandNum);
            removeView.sendDialogueMessage(output);

        }
        //
    }

    public class CancelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            removeView.clearTextFields();
            removeView.setVisible(false);

        }
        //
    }
}
