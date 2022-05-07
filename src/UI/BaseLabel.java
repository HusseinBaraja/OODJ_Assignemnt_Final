package UI;

import javax.swing.*;
import java.awt.*;

public class BaseLabel extends JLabel {
    public BaseLabel() {
    }
    public BaseLabel(String text, int fontSize, String fontName, int fontColor) {
        setText(text);
        setFont(new Font(fontName, Font.PLAIN, fontSize)); //changing font settings of the button.
        setForeground(new Color(fontColor)); //changing the button's text color.
    }

    public void setImage(String filename){
        //Importing the image
        ImageIcon logoIcon = new ImageIcon(filename);

        //setting the image inside the label
        setIcon(logoIcon);
    }

    public void setAlignment(int horizontal, int vertical){
        //JLabel.Position
        setHorizontalAlignment(horizontal); //Aligning the label horizontally inside its container.
        setVerticalAlignment(vertical); //Aligning the label vertically inside its container.
    }

    public void setTextPosition(int horizontal, int vertical){
        //JLabel.TextPosition
        setHorizontalTextPosition(horizontal); //positioning the text horizontally inside the label ignoring the icon of the label.
        setVerticalTextPosition(vertical); //positioning the text vertically inside the label relative to the icon of the label.
    }
}
