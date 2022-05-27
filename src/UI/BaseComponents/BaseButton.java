package UI.BaseComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BaseButton extends JButton implements MouseListener{
    private String baseFileName;
    private String lightFileName;
    private String darkFileName;
    private boolean hasImage;
    private String frameName;
    public BaseButton(String text, int width, int height){
        setCommonPreSet();

        setText(text);

        setPreferredSize(new Dimension(width,height)); //Changing the size of the button.
    }
    public BaseButton(String text, int fontSize , int width, int height){
        setCommonPreSet();

        setText(text);
        setFont(new Font("Arial", Font.PLAIN, fontSize)); //changing font settings of the button.

        setPreferredSize(new Dimension(width,height)); //Changing the size of the button.
    }
    public BaseButton(String text,String fontName, int fontSize , int fontColor, int width, int height){
        setCommonPreSet();

        setText(text);
        setFont(new Font(fontName, Font.PLAIN, fontSize)); //changing font settings of the button.
        setForeground(new Color(fontColor)); //changing the button's text color.

        setPreferredSize(new Dimension(width,height)); //Changing the size of the button.
    }

    public void setCommonPreSet(){
        setFont(new Font("Arial", Font.PLAIN, 24)); //changing font settings of the button.
        setForeground(new Color(0xFFFFFF)); //changing the button's text color.

        setIconTextGap(20);
        setFocusable(false); //removing the annoying focus highlight around the button. (pre-set template)

        //Remove the button's original border
        setBorder(BorderFactory.createEmptyBorder()); //(pre-set template)
        setContentAreaFilled(false); //(pre-set template)

        setBorder(new RoundedBorder(15)); //Add new border radius. (pre-set template)

        //addActionListener(this);
        //Adding a mouse listener change the button's behaviour depending on the mouse status above the button.
        addMouseListener(this);
    }
    public void setImage(String filename){
        //Importing the image
        ImageIcon logoIcon = new ImageIcon(filename);

        //setting the image inside the button
        setIcon(logoIcon);
    }

    //make it a list somehow;
    public void setFrameName(String frameName){
        this.frameName = frameName;
    }
    public String getFrameName(){
        return frameName;
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
