package Client.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RemoveView extends JFrame {
    private JLabel title;
    private JLabel courseName;
    private JLabel courseNum;
    private JLabel studentName;
    private JLabel studentNum;
    private JButton remove;
    private JButton cancel;
    private JTextField courseNameField;
    private JTextField courseNumField;
    private JTextField studentNameField;
    private JTextField studentNumField;
    private JPanel northPanel;
    private JPanel centerPanel;
    private JPanel southPanel;


    public RemoveView(){
        super();
        setSize(250,150);

        setLayout(new BorderLayout());

        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();

        title = new JLabel("Search for a Course");
        courseName = new JLabel("Course Name: ");
        courseNum = new JLabel("Course Number: ");
        studentName = new JLabel("Student Name: ");
        studentNum = new JLabel("Student Number: ");
        remove = new JButton("Remove");
        cancel = new JButton("Cancel");
        courseNameField = new JTextField(5);
        courseNumField = new JTextField(5);
        studentNameField = new JTextField(5);
        studentNumField = new JTextField(5);

        northPanel.add(title);
        centerPanel.add(courseName);
        centerPanel.add(courseNameField);
        centerPanel.add(courseNum);
        centerPanel.add(courseNumField);
        centerPanel.add(studentName);
        centerPanel.add(studentNameField);
        centerPanel.add(courseNum);
        centerPanel.add(studentNumField);
        southPanel.add(remove);
        southPanel.add(cancel);

        getContentPane().add(BorderLayout.NORTH, northPanel);
        getContentPane().add(BorderLayout.CENTER, centerPanel);
        getContentPane().add(BorderLayout.SOUTH, southPanel);
    }

    public void clearTextFields(){
        studentNameField.setText("");
        studentNumField.setText("");
        courseNameField.setText("");
        courseNumField.setText("");
    }

    public ArrayList<String> getFields(){
        ArrayList<String> courseInfo = new ArrayList<>();
        courseInfo.add(studentNameField.getText());
        courseInfo.add(studentNumField.getText());
        courseInfo.add(courseNameField.getText());
        courseInfo.add(courseNumField.getText());
        return courseInfo;
    }

    /**
     * Display the given message to the user.
     * @param message the message to be displayed.
     */
    public void sendDialogueMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public void addSearchListener(ActionListener a){
        remove.addActionListener(a);
    }

    public void addCancelListener(ActionListener a){
        cancel.addActionListener(a);
    }
}
