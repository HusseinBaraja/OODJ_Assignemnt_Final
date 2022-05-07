package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BasePasswordField extends JPasswordField {
    public BasePasswordField(int fontSize, int width, int height) {
        setFont(new Font("Arial", Font.PLAIN, fontSize)); //changing font settings of the password field.
        setForeground(new Color(0x60FF22)); //changing the password field's text color. (pre-set template)
        setBackground(new Color(0x2B2E31)); //changing the password field's background color. (pre-set template)

        setEchoChar('*');

        setPreferredSize(new Dimension(width, height)); //Changing the size of the password field.

        setBorder(BorderFactory.createEmptyBorder()); //(pre-set template)
        setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.white)); //(pre-set template)

        setCaretColor(new Color(0x60FF22)); //(pre-set template)
    }
}
