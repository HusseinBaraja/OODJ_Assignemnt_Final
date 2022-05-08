package UI.BaseComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BaseTextField extends JTextField {
    public BaseTextField(String text, int fontSize, int width, int height){
        setText(text);
        setFont(new Font("Arial", Font.PLAIN, fontSize)); //changing font settings of the text field.
        setForeground(new Color(0x60FF22)); //changing the text field's text color. (pre-set template)
        setBackground(new Color(0x2B2E31)); //changing the text field's background color. (pre-set template)

        setPreferredSize(new Dimension(width,height)); //Changing the size of the text field.

        setBorder(BorderFactory.createEmptyBorder()); //(pre-set template)
        setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.white)); //(pre-set template)

        setCaretColor(new Color(0x60FF22)); //(pre-set template)

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(BaseTextField.this.getText().equals(text)){
                    BaseTextField.this.setText("");
                }
            }
        });
    }
}
