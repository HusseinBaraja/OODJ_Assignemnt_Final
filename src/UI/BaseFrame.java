package UI;

import javax.swing.*;
import java.awt.*;

public class BaseFrame extends JFrame{
    private BasePanel pnlLeftSide;
    private BasePanel pnlRightSide;
    private BasePanel pnlSettings;

    public BaseFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280,720);
        this.setResizable(true);
        this.setLocationRelativeTo(null);

        ImageIcon logo = new ImageIcon("src/Resources/Dumbbell.png");
        this.setIconImage(logo.getImage());

        setPnlLeftSide();
        setPnlRightSide();
        this.setVisible(true);
    }

    public void setPnlLeftSide(){

        pnlLeftSide = new BasePanel(0x1E2022,400,720);
        pnlLeftSide.setLayout(new BorderLayout());
        pnlLeftSide.setBorder(BorderFactory.createMatteBorder(0,0,0,1,Color.white));

        setPnlSettings();
        this.getPnlLeftSide().add(getPnlSettings(), BorderLayout.SOUTH);

        this.add(getPnlLeftSide(), BorderLayout.WEST);
    }
    public JPanel getPnlLeftSide(){
        return pnlLeftSide;
    }


    public void setPnlSettings(){
        //Creating the Settings panel
        pnlSettings = new BasePanel(false,400,100);
        pnlSettings.setLayout(new FlowLayout(FlowLayout.LEFT));

        //Creating a top white divider
        pnlSettings.setBorder(BorderFactory.createMatteBorder(1,0,0,0,Color.white));


        //Creating the Settings button:
        BaseButton btnSettings = new BaseButton("General Settings", 20, 0xFFFFFF, 300, 35);
        btnSettings.setImage("src/Resources/settings.png");
        btnSettings.setHorizontalAlignment(JButton.LEFT); //aligning the content of the label to the left.

        btnSettings.setImageOnEvent("src/Resources/settings.png",
                "src/Resources/lightGreenSettings.png",
                "src/Resources/greenSettings.png");

        //Add button to the Settings panel which is in the bottom of the sidebar
        pnlSettings.add(btnSettings);
    }
    public JPanel getPnlSettings(){
        return pnlSettings;
    }


    public void setPnlRightSide(){
        pnlRightSide = new BasePanel(0x2B2E31);
        pnlRightSide.setLayout(new BorderLayout());

        this.add(getPnlRightSide(), BorderLayout.CENTER);
    }
    public JPanel getPnlRightSide(){
        return pnlRightSide;
    }
}
