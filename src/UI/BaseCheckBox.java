package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BaseCheckBox extends JCheckBox implements MouseListener {
    public BaseCheckBox(String text, int fontSize, int fontColor) {
        setText(text);
        setFont(new Font("Arial", Font.PLAIN, fontSize)); //changing font settings of the button.
        setForeground(new Color(fontColor)); //changing the button's text color.

        setFocusable(false); //removing the annoying focus highlight around the button. (pre-set template)
        setOpaque(false);
        //Adding a mouse listener change the button's behaviour depending on the mouse status above the button.
        addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
