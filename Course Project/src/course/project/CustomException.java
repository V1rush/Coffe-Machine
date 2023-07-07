package course.project;

import javax.swing.JOptionPane;

public class CustomException extends Exception {
    public CustomException(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
}
