package Client.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * A class for the view/window which opens up from clicking the search button.
 * @author Branden Wong - 30040675
 * @author Savipal Jessel - 30039257
 * @version 1.0
 */
public class SearchView extends JFrame {

    /**
     * A label for the title of the search view window
     */
    private JLabel title;

    /**
     * A label for the course name input prompt
     */
    private JLabel courseName;

    /**
     * A label for the course num input prompt
     */
    private JLabel courseNum;

    /**
     * A button to search for the given course
     */
    private JButton search;

    /**
     * A button to cancel the operation
     */
    private JButton cancel;

    /**
     * A text input field to obtain the course name from the user.
     */
    private JTextField nameField;

    /**
     * A text input field to obtain the course number from the user.
     */
    private JTextField numField;

    /**
     * A panel to organize the north side of the window
     */
    private JPanel northPanel;

    /**
     * A panel to organize the middle of the window
     */
    private JPanel centerPanel;

    /**
     * A panel to organize the south side of the window
     */
    private JPanel southPanel;

    /**
     * A constructor which generates the window and formats all the components.
     */
    public SearchView(){
        super();
        setSize(250,150);

        setLayout(new BorderLayout());

        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();

        title = new JLabel("Search for a Course");
        courseName = new JLabel("Course Name: ");
        courseNum = new JLabel("Course Number: ");
        search = new JButton("Search");
        cancel = new JButton("Cancel");
        nameField = new JTextField(5);
        numField = new JTextField(5);

        northPanel.add(title);
        centerPanel.add(courseName);
        centerPanel.add(nameField);
        centerPanel.add(courseNum);
        centerPanel.add(numField);
        southPanel.add(search);
        southPanel.add(cancel);

        getContentPane().add(BorderLayout.NORTH, northPanel);
        getContentPane().add(BorderLayout.CENTER, centerPanel);
        getContentPane().add(BorderLayout.SOUTH, southPanel);
    }

    /**
     * A function to clear all the text fields of the input boxes.
     */
    public void clearTextFields(){
        nameField.setText("");
        numField.setText("");
    }

    /**
     * A function which gets the input from all of the text fields
     * @return A list of the inputs received from the text fields on the window
     */
    public ArrayList<String> getFields(){
        ArrayList<String> courseInfo = new ArrayList<>();
        courseInfo.add(nameField.getText());
        courseInfo.add(numField.getText());
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
     * Adds a listener to the search button
     * @param a the listener to add to the search button
     */
    public void addSearchListener(ActionListener a){
        search.addActionListener(a);
    }

    /**
     * Adds a listener to the cancel button
     * @param a the listener to add to the cancel button
     */
    public void addCancelListener(ActionListener a){
        cancel.addActionListener(a);
    }


}
