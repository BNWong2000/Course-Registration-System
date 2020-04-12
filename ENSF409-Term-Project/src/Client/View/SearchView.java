package Client.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SearchView extends JFrame {
    private JLabel title;
    private JLabel courseName;
    private JLabel courseNum;
    private JButton search;
    private JButton cancel;
    private JTextField nameField;
    private JTextField numField;
    private JPanel northPanel;
    private JPanel centerPanel;
    private JPanel southPanel;

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

    public void clearTextFields(){
        nameField.setText("");
        numField.setText("");
    }

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

    public void addSearchListener(ActionListener a){
        search.addActionListener(a);
    }

    public void addCancelListener(ActionListener a){
        cancel.addActionListener(a);
    }


}
