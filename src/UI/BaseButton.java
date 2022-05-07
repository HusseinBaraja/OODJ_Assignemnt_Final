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
    public BaseButton(String text, int rgb, int width, int height, int fontSize){
        setText(text);
        setFont(new Font("Arial", Font.PLAIN, fontSize)); //changing Font settings of the button.
        setForeground(new Color(rgb)); //changing the button's text color.

        setPreferredSize(new Dimension(width,height)); //Changing the size of the button.
        setFocusable(false); //removing the annoying focus highlight around the button.

        //Remove the button's original border
        setBorder(BorderFactory.createEmptyBorder());
//        setBackground(new Color(0xFFFFFF));
        setContentAreaFilled(false);

        setBorder(new RoundedBorder(15)); //Add new border radius.

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
