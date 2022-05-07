package UI;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;


public class BaseFrame extends JFrame{
    private JPanel pnlLeftSide;
    private JPanel pnlRightSide;



    public BaseFrame(){
        this.setTitle("Login");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280,720);
        this.setResizable(true);
        this.setLocationRelativeTo(null);


        setPnlLeftSide();
        setPnlRightSide();
        this.setVisible(true);
    }

    public void setPnlLeftSide(){
        pnlLeftSide = new JPanel();
        pnlLeftSide.setBackground(new Color(0x1E2022));
        pnlLeftSide.setPreferredSize(new Dimension(400,720));
        pnlLeftSide.setLayout(new BorderLayout());
        pnlLeftSide.setBorder(BorderFactory.createMatteBorder(0,0,0,1,Color.white));

        this.add(getPnlLeftSide(), BorderLayout.WEST);
    }
    public JPanel getPnlLeftSide(){
        return pnlLeftSide;
    }


    public void setPnlRightSide(){
        pnlRightSide = new JPanel();
        pnlRightSide.setBackground(new Color(0x2B2E31));
        pnlRightSide.setLayout(new BorderLayout());

        this.add(getPnlRightSide(), BorderLayout.CENTER);
    }
    public JPanel getPnlRightSide(){
        return pnlRightSide;
    }
}
