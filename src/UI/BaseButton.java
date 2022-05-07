package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BaseButton extends JButton implements MouseListener {
    private String baseFileName;
    private String lightFileName;
    private String darkFileName;
    private boolean hasImage;
    public BaseButton(String text, int fontSize, int fontColor, int width, int height){
        setText(text);
        setFont(new Font("Arial", Font.PLAIN, fontSize)); //changing font settings of the button.
        setForeground(new Color(fontColor)); //changing the button's text color.

        setPreferredSize(new Dimension(width,height)); //Changing the size of the button.
        setFocusable(false); //removing the annoying focus highlight around the button. (pre-set template)

        //Remove the button's original border
        setBorder(BorderFactory.createEmptyBorder()); //(pre-set template)
        setContentAreaFilled(false); //(pre-set template)

        setBorder(new RoundedBorder(15)); //Add new border radius. (pre-set template)

        //Adding a mouse listener change the button's behaviour depending on the mouse status above the button.
        addMouseListener(this);
    }

    public void setImageOnEvent(String baseFileName, String lightFileName, String darkFileName){
        hasImage = true;
        this.baseFileName = baseFileName;
        this.lightFileName = lightFileName;
        this.darkFileName = darkFileName;
    }
    public String getBaseFileName(){
        return this.baseFileName;
    }
    public String getLightFileName(){
        return this.lightFileName;
    }
    public String getDarkFileName(){
        return this.darkFileName;
    }


    public void setImage(String filename){
        //Importing the image
        ImageIcon logoIcon = new ImageIcon(filename);

        //setting the image inside the button
        setIcon(logoIcon);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.setForeground(new Color(0x60FF22));
        if(hasImage){
            this.setIcon(new ImageIcon(getDarkFileName()));
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.setForeground(new Color(0xC9FFB4));
        if(hasImage){
            this.setIcon(new ImageIcon(getLightFileName()));
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.setForeground(new Color(0xC9FFB4));
        if(hasImage){
            this.setIcon(new ImageIcon(getLightFileName()));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setForeground(new Color(0xFFFFFF));
        if(hasImage){
            this.setIcon(new ImageIcon(getBaseFileName()));
        }
    }
}
