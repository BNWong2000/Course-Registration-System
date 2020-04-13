package Client.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The main view/window for the application
 * @author Branden Wong - 30040675
 * @author Savipal Jessel - 30039257
 * @version 1.0
 */
public class MainView extends JFrame{

    /**
     * A label for the title of the window
     */
    private JLabel title;

    /**
     * A button to enroll in a class
     */
    private JButton enroll;

    /**
     * A button to remove a student from a class
     */
    private JButton remove;

    /**
     * A button to search for a course
     */
    private JButton search;

    /**
     * A button to view a student
     */
    private JButton viewStu;

    /**
     * A button to view the course catalogue
     */
    private JButton viewCat;

    /**
     * A text area to display information after clicking certain buttons
     */
    private JTextArea info;

    /**
     * A panel for formatting the north portion of the window
     */
    private JPanel northPanel;

    /**
     * A pane for formatting the center of the window
     */
    private JScrollPane centerPane;

    /**
     * A panel for formatting the south portion of the window
     */
    private JPanel southPanel;

    /**
     * A constructor for creating the main window view.
     */
    public MainView(){
        super();
        setSize(800,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        enroll = new JButton("Enroll in Class");
        remove = new JButton("Remove from Class");
        search = new JButton("Search for Class");
        viewStu = new JButton("View Student");
        viewCat = new JButton("View Course Catalogue");
        info = new JTextArea();
        info.setEditable(false);

        northPanel = new JPanel();
        centerPane = new JScrollPane(info);
        southPanel = new JPanel();

        title = new JLabel("Course Registration App");


        northPanel.add(title);
        //centerPane.add(info);
        southPanel.add(enroll);
        southPanel.add(remove);
        southPanel.add(search);
        southPanel.add(viewStu);
        southPanel.add(viewCat);

        getContentPane().add(BorderLayout.NORTH, northPanel);
        getContentPane().add(BorderLayout.CENTER, centerPane);
        getContentPane().add(BorderLayout.SOUTH, southPanel);
    }

    /**
     * Sets the info shown in the center text area.
     * @param text the text to set the info inside to.
     */
    public void setInfo(String text) {
        info.setText(text);
    }

    /**
     * Opens up a dialog box to get the student ID
     * @return the student ID received from the dialog box.
     */
    public String getStudentID() {
        return JOptionPane.showInputDialog("Enter the Student ID:");
    }

    /**
     * Sends a message in a dialogue box
     * @param message the message to send
     */
    public void sendDialogueMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    /**
     * adds a listener to the enroll button
     * @param a the listener to add to the enroll button
     */
    public void addEnrollListener(ActionListener a){
        enroll.addActionListener(a);
    }

    /**
     * adds a listener to the remove button
     * @param a the listener to add to the remove button
     */
    public void addRemoveListener(ActionListener a){
        remove.addActionListener(a);
    }

    /**
     * Adds a listener to the search button
     * @param a the listener to add to the search button
     */
    public void addSearchListener(ActionListener a){
        search.addActionListener(a);
    }

    /**
     * Adds a listener to the view student button
     * @param a the listener to add to the view student button
     */
    public void addViewStuListener(ActionListener a){
        viewStu.addActionListener(a);
    }

    /**
     * Adds a lsitener to the view catalogue button
     * @param a the listener to add to the view catalogue button.
     */
    public void addViewCatListener(ActionListener a){
        viewCat.addActionListener(a);
    }

}
