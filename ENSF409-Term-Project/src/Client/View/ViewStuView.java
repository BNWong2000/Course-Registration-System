package Client.View;

import javax.swing.*;

public class ViewStuView extends JFrame {


    /**
     * Display the given message to the user.
     * @param message the message to be displayed.
     */
    public void sendDialogueMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
