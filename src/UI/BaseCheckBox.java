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

        setPreferredSize(new Dimension(750,40));

        this.setIcon(new ImageIcon("src/Resources/checkBox/baseCheckBox.png"));
        this.setSelectedIcon(new ImageIcon("src/Resources/checkBox/baseCheckedCheckBox.png"));

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
        this.setIcon(new ImageIcon("src/Resources/checkBox/darkCheckBox.png"));
        this.setSelectedIcon(new ImageIcon("src/Resources/checkBox/darkCheckedCheckBox.png"));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.setIcon(new ImageIcon("src/Resources/checkBox/lightCheckBox.png"));
        this.setSelectedIcon(new ImageIcon("src/Resources/checkBox/lightCheckedCheckBox.png"));
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.setIcon(new ImageIcon("src/Resources/checkBox/lightCheckBox.png"));
        this.setSelectedIcon(new ImageIcon("src/Resources/checkBox/lightCheckedCheckBox.png"));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setIcon(new ImageIcon("src/Resources/checkBox/baseCheckBox.png"));
        this.setSelectedIcon(new ImageIcon("src/Resources/checkBox/baseCheckedCheckBox.png"));
    }
}
