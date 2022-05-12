package UI.BaseComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class BaseComboBox extends JComboBox implements ActionListener{
    public BaseComboBox(Object[] names) {
        super(names);

        setFont(new Font("Arial", Font.PLAIN, 24)); //changing font settings of the button.

        setCommonPreSet();
    }
    public BaseComboBox(Object[] names, int width, int height) {
        super(names);

        setFont(new Font("Arial", Font.PLAIN, 24)); //changing font settings of the button.

        setPreferredSize(new Dimension(width,height)); //Changing the size of the button.

        setCommonPreSet();
    }
    public BaseComboBox(Object[] names, int fonSize) {
        super(names);

        setFont(new Font("Arial", Font.PLAIN, fonSize)); //changing font settings of the button.

        setCommonPreSet();
    }
    public BaseComboBox(Object[] names, int fonSize, int width, int height) {
        super(names);

        setFont(new Font("Arial", Font.PLAIN, fonSize)); //changing font settings of the button.

        setPreferredSize(new Dimension(width,height)); //Changing the size of the button.

        setCommonPreSet();
    }
    public void setCommonPreSet(){
        setEditable(true);

        setForeground(new Color(0x000000)); //changing the button's text color.

        this.setUI(ColorArrowUI.createUI(this));

//        addActionListener(this);
    }
}
