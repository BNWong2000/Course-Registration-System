package Client.View;

import javax.swing.*;
import java.awt.*;

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
        centerPanel.add()



    }


}
