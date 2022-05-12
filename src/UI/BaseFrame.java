package UI;

import UI.BaseComponents.BaseButton;
import UI.BaseComponents.BasePanel;

import javax.swing.*;
import java.awt.*;

/**
 * <code>BaseFrame</code> class is the base building block of the program.
 * every other class inside the program either extends <code>BaseFrame</code> or extends a frame that is extending <code>BaseFrame</code>.
 * <P>
 * It contains two main areas, Left side and Right side.
 * The left side is contained inside <code>pnlLeftSide</code> has the logo and any buttons that will change the right side of the frame.
 * The right side is contained inside <code>pnlRightSide</code> and it has the heart GUI components of the frame that makes to all the
 * functionalities of the program possible.
 * <p>
 * The <code>pnlRightSide</code> is inside the center border of the <code>BaseFrame</code> and it doesn't contain any components but is
 * just initialized to be overridden and get more components from other classes.
 * The <code>pnlLeftSide</code> contains the <code>pnlSettings</code>, this is because <code>pnlSettings</code> is present in all the frames
 * across the program.
 *
 * @author Hussein Abdullah Mohammed Ba Ragaa
 * @since 1.0
 */
public class BaseFrame extends JFrame{
    /**
     * <code>pnlLeftSide</code> is an instance of the BasePanel class, it is a panel that will contain all the components
     * that will be on the sidebar of the program.
     */
    private BasePanel pnlLeftSide;

    /**
     * <code>pnlRightSide</code> will contain the components that will be on the main part of the program
     */
    private BasePanel pnlRightSide;

    /**
     * <code>pnlSettings</code> has the setting button that is located at the bottom of <code>pnlLeftSide</code>
     */
    private BasePanel pnlSettings;


    /**
     * <code>BaseFrame()</code> Constructs a new JFrame that has pre-set values which will be
     * the basis of the entire program.
     * <p>
     * The frame will exit the program when closed and the program will be terminated. The size
     * of the window is 1280*720, the window can be resized and the location of the window is in
     * the middle of the screen. The logo of the program will be set as the Icon instead of the
     * default java icon.
     * <p>
     * Finally, both <code>setPnlLeftSide()</code> and <code>setPnlRightSide()</code> would be set
     * in order to appear inside the frame.
     *
     * @see BasePanel
     */
    public BaseFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280,720);
        this.setResizable(true);
        this.setLocationRelativeTo(null);

        this.setIconImage(new ImageIcon("src/Resources/Logo.png").getImage());

        setPnlLeftSide();
        setPnlRightSide();
        this.setVisible(true);
    }


    /**
     * <code>setPnlLeftSide()</code> is a setter that performs changes to the <code>pnlLeftSide</code>
     * field.
     * <p>
     * <code>pnlLeftSide</code> is initialized with a dark gray background and a width of 290. The layout
     * used here is the {@link java.awt.BorderLayout} because it will be split into two sections,
     * top (<code>BorderLayout.CENTER</code>) and bottom (<code>BorderLayout.SOUTH</code>). There is a white
     * border to the right side of <code>pnlLeftSide</code> to act as a divider between the two sides of the
     * frame.
     * <p>
     * The <code>setPnlSettings()</code> is called to initialize the setting panel, and it gets added to the
     * bottom part of <code>pnlLeftSide</code>.
     * <p>
     * In the end, <code>getPnlLeftSide()</code> is added to the left side of the frame.
     *
     * @see BasePanel
     */
    public void setPnlLeftSide(){
        pnlLeftSide = new BasePanel(0x1E2022,290,720);
        pnlLeftSide.setLayout(new BorderLayout());
        pnlLeftSide.setBorder(BorderFactory.createMatteBorder(0,0,0,1,new Color(0xFFFFFF)));

        setPnlSettings();
        this.getPnlLeftSide().add(getPnlSettings(), BorderLayout.SOUTH);

        this.add(getPnlLeftSide(), BorderLayout.WEST);
    }

    /**
     * <code>getPnlLeftSide()</code> is a getter for <code>pnlLeftSide</code> to prevent it from being accessed directly.
     * @return <code>pnlLeftSide</code> which is the sidebar of the program.
     */
    public BasePanel getPnlLeftSide(){
        return pnlLeftSide;
    }


    /**
     * <code>setPnlSettings()</code> is a panel container for the settings button.
     * <p>
     * <code>pnlSettings</code> is initialized with a transparent background, a width of 280 px and a height
     * of 100 px. It has left alignment using the {@link java.awt.BorderLayout} to make its components get
     * painted from the left of the container.
     * There is a top border to act as a divider between the top and bottom of the sidebar.
     * <p>
     * <code>btnSettings</code> is created with the settings.png image added to it. It has a left horizontal
     * alignment and has 3 copies of the settings image with different colors to be changed when the button is
     * interacted with.
     * <p>
     * <code>btnSettings</code> is added to the bottom of <code>pnlSettings</code>
     *
     *
     * @see BasePanel
     * @see BaseButton
     */
    public void setPnlSettings(){
        //Creating the Settings panel
        pnlSettings = new BasePanel(false,280,100);
        pnlSettings.setLayout(new FlowLayout(FlowLayout.LEADING));

        //Creating a top white divider
        pnlSettings.setBorder(BorderFactory.createMatteBorder(1,0,0,0,new Color(0xFFFFFF)));


        //Creating the Settings button:
        BaseButton btnSettings = new BaseButton("General Settings", 20, 280, 40);
        btnSettings.setImage("src/Resources/Settings/settings.png");
        btnSettings.setHorizontalAlignment(JButton.LEFT); //aligning the content of the label to the left.

        btnSettings.setImageOnEvent("src/Resources/Settings/settings.png",
                                    "src/Resources/Settings/lightSettings.png",
                                    "src/Resources/Settings/darkSettings.png");

        //Add button to the Settings panel which is in the bottom of the sidebar
        pnlSettings.add(btnSettings);
    }

    /**
     * <code>getPnlSettings()</code> is a getter for <code>pnlSettings</code> to prevent it from being accessed directly.
     * @return <code>pnlSettings</code> which contains the settings button.
     */
    public JPanel getPnlSettings(){
        return pnlSettings;
    }


    /**
     * <code>setPnlRightSide()</code> is a setter that performs changes to the <code>pnlRightSide</code>
     * field.
     * <p>
     * <code>pnlRightSide</code> is initialized with a gray background and a width of 290. It uses the
     * {@link java.awt.BorderLayout} layout in order to be manipulated in a different extended frame.
     * <p>
     * In the end, <code>setPnlRightSide()</code> is added to the right side of the frame.
     *
     * @see BasePanel
     */
    public void setPnlRightSide(){
        pnlRightSide = new BasePanel(0x2B2E31);
        pnlRightSide.setLayout(new BorderLayout());

        this.add(getPnlRightSide(), BorderLayout.CENTER);
    }

    /**
     * <code>getPnlRightSide()</code> is a getter for <code>pnlRightSide</code> to prevent it from being accessed directly.
     * @return <code>pnlRightSide</code> which will include other components in other classes.
     */
    public JPanel getPnlRightSide(){
        return pnlRightSide;
    }
}
