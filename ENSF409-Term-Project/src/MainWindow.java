import javax.swing.*;
import java.awt.*;

/**
 * A class used for generating the main window for the program.
 * adds GUI implements for getting data from the user.
 * @author Branden Wong - 30040675
 *         Savipal Jessel -
 * @since April 4, 2020
 * @version 1.0
 */
public class MainWindow extends javax.swing.JFrame{

    /**
     * Opens a dialog box for adding a new student to the data
     */
    private JButton insertButton;

    /**
     * Opens a prompt for the user to search for a student through their student id.
     */
    private JButton findButton;

    /**
     * Displays the information from the tree onto the main window.
     */
    private JButton browseButton;

    /**
     * Opens a prompt to request a text file input from the user.
     */
    private JButton createTreeButton;

    /**
     * A panel used to house all the buttons on the bottom of the main window.
     */
    private JPanel buttonsPanel;


    public MainWindow(){
        super("Main Window");
        super.setVisible(true);
        setSize(600,600);

        insertButton = new JButton("Insert");
        findButton = new JButton("Find");
        browseButton = new JButton("Browse");
        createTreeButton = new JButton("Create Tree From File");

        setLayout(new BorderLayout());
        JLabel topLabel = new JLabel("An Application to maintain Student Records");
        topLabel.setVerticalAlignment(SwingConstants.CENTER);
        topLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add("North", topLabel);

        generateButtonsPanel();
        add("South", buttonsPanel);


    }

    private void generateButtonsPanel(){
        buttonsPanel = new JPanel();
        buttonsPanel.add(insertButton);
        buttonsPanel.add(findButton);
        buttonsPanel.add(browseButton);
        buttonsPanel.add(createTreeButton);
    }
}
