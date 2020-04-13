package Client.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Secondary view class that creates the menu for the Remove feature and provides methods for access and dialog.
 *
 * @author Branden Wong - 30040675
 * @author Savipal Jessel - 30039257
 * @version 1.0
 */

public class RemoveView extends JFrame {
    /**
     * The label for the title for the enroll view
     */
    private JLabel title;

    /**
     * The label for the name of the course
     */
    private JLabel courseName;

    /**
     * The label for the course number
     */
    private JLabel courseNum;

    /**
     * The label for the name of the student
     */
    private JLabel studentName;

    /**
     * The label for the student number
     */
    private JLabel studentNum;

    /**
     * The remove button
     */
    private JButton remove;

    /**
     * The cancel button
     */
    private JButton cancel;
    /**
     * The text field for the name of the course
     */
    private JTextField courseNameField;

    /**
     * The text field for the course number
     */
    private JTextField courseNumField;

    /**
     * The text field for the name of the student
     */
    private JTextField studentNameField;

    /**
     * The text field for the student number
     */
    private JTextField studentNumField;

    /**
     * The north side panel
     */
    private JPanel northPanel;

    /**
     * The center panel
     */
    private JPanel centerPanel;

    /**
     * The south side panel
     */
    private JPanel southPanel;


    /**
     * Sets-up the frame, populates the panels, and adds the frames to the panel for the remove view
     */
    public RemoveView(){
        super();
        setSize(250,150);

        setLayout(new BorderLayout());

        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();

        title = new JLabel("Remove Student From Course");
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
        GridLayout centerLayout = new GridLayout(2, 4);
        centerPanel.setLayout(centerLayout);
        centerPanel.add(courseName);
        centerPanel.add(courseNameField);
        centerPanel.add(courseNum);
        centerPanel.add(courseNumField);
        centerPanel.add(studentName);
        centerPanel.add(studentNameField);
        centerPanel.add(studentNum);
        centerPanel.add(studentNumField);
        centerPanel.setLayout(centerLayout);
        southPanel.add(remove);
        southPanel.add(cancel);

        getContentPane().add(BorderLayout.NORTH, northPanel);
        getContentPane().add(BorderLayout.CENTER, centerPanel);
        getContentPane().add(BorderLayout.SOUTH, southPanel);
    }

    /**
     * Clears all of the text fields
     */
    public void clearTextFields(){
        studentNameField.setText("");
        studentNumField.setText("");
        courseNameField.setText("");
        courseNumField.setText("");
    }

    /**
     * Gets a list of the contents for all of the text fields
     * @return a list containing the contents of each text field
     */
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

    /**
     * Adds an Action Listener for the remove button
     * @param a the Action Listener
     */
    public void addRemoveListener(ActionListener a){
        remove.addActionListener(a);
    }

    /**
     * Adds an Action Listener for the cancel button
     * @param a the Action Listener
     */
    public void addCancelListener(ActionListener a){
        cancel.addActionListener(a);
    }
}
