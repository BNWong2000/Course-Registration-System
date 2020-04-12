package Client.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainView extends JFrame{

    private JLabel title;
    private JButton enroll;
    private JButton remove;
    private JButton search;
    private JButton viewStu;
    private JButton viewCat;

    private JTextArea info;

    private JPanel northPanel;
    private JScrollPane centerPane;
    private JPanel southPanel;

    public MainView(){
        super();
        setSize(800,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        northPanel = new JPanel();
        centerPane = new JScrollPane();
        southPanel = new JPanel();

        title = new JLabel("Course Registration App");

        enroll = new JButton("Enroll in Class");
        remove = new JButton("Remove from Class");
        search = new JButton("Search for Class");
        viewStu = new JButton("View Student");
        viewCat = new JButton("View Course Catalogue");
        info = new JTextArea();

        northPanel.add(title);
        centerPane.add(info);
        southPanel.add(enroll);
        southPanel.add(remove);
        southPanel.add(search);
        southPanel.add(viewStu);
        southPanel.add(viewCat);

        getContentPane().add(BorderLayout.NORTH, northPanel);
        getContentPane().add(BorderLayout.CENTER, centerPane);
        getContentPane().add(BorderLayout.SOUTH, southPanel);
    }

    public void addEnrollListener(ActionListener a){
        enroll.addActionListener(a);
    }

    public void addRemoveListener(ActionListener a){
        remove.addActionListener(a);
    }

    public void addSearchListener(ActionListener a){
        search.addActionListener(a);
    }

    public void addViewStuListener(ActionListener a){
        viewStu.addActionListener(a);
    }

    public void addViewCatListener(ActionListener a){
        viewCat.addActionListener(a);
    }

}
