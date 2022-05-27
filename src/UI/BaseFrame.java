package UI;
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
 *
 * @author Hussein Abdullah Mohammed Ba Ragaa
 * @since 1.0
 */
public abstract class BaseFrame extends JFrame{
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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280,720);
        setResizable(true);
        setLocationRelativeTo(null);

        setIconImage(new ImageIcon("src/Resources/Logo.png").getImage());

        setPnlLeftSide();
        setPnlRightSide();
        setVisible(true);
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
     * In the end, <code>getPnlLeftSide()</code> is added to the left side of the frame.
     *
     * @see BasePanel
     */
    public void setPnlLeftSide(){
        pnlLeftSide = new BasePanel(0x1E2022,290,720);
        pnlLeftSide.setLayout(new BorderLayout());
        pnlLeftSide.setBorder(BorderFactory.createMatteBorder(0,0,0,1,new Color(0xFFFFFF)));

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
