package UI.BaseComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class BaseComboBox extends JComboBox implements ActionListener{
    public BaseComboBox(Object[] names, int width, int height) {
        super(names);
        setEditable(true);

        setFont(new Font("Arial", Font.PLAIN, 24)); //changing font settings of the button.
        setForeground(new Color(0x000000)); //changing the button's text color.

        setPreferredSize(new Dimension(width,height)); //Changing the size of the button.
//        setFocusable(false); //removing the annoying focus highlight around the button. (pre-set template)

        this.setUI(ColorArrowUI.createUI(this));

//        addActionListener(this);

    }
}
