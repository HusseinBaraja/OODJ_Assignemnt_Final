package UI.Dashboard;

import UI.BaseComponents.BaseButton;
import UI.BaseComponents.BaseLabel;
import UI.BaseComponents.BasePanel;
import UI.BaseFrame;
import UI.LoginPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class BaseDashboard extends BaseFrame {
    private BasePanel PnlTopSideBar;
    private BasePanel pnlLogo;
    private BasePanel pnlDashboard;
    private BaseButton btnDashboard;

    /**
     * <code>pnlLogout</code> has the Logout button that is located at the bottom of <code>pnlLeftSide</code>
     */
    private BasePanel pnlLogout;

    public BaseDashboard(){
        setTitle("Base Dashboard Template");
    }
    public void rightSideBorders(){
        this.getPnlRightSide().add(new BasePanel(false), BorderLayout.NORTH);
        this.getPnlRightSide().add(new BasePanel(false, 100,500), BorderLayout.EAST);
        this.getPnlRightSide().add(new BasePanel(false), BorderLayout.SOUTH);
        this.getPnlRightSide().add(new BasePanel(false), BorderLayout.WEST);
    }
    @Override
    public void setPnlLeftSide(){
        super.setPnlLeftSide();
        setPnlTopSideBar();
        this.getPnlLeftSide().add(getPnlTopSideBar(), BorderLayout.CENTER);

        setPnlLogout();
        this.getPnlLeftSide().add(getPnlLogout(), BorderLayout.SOUTH);
    }
    public void setPnlTopSideBar(){
        PnlTopSideBar = new BasePanel(false);
        setPnlLogo();
        PnlTopSideBar.add(getPnlLogo());
        setPnlDashboard();
        PnlTopSideBar.add(getPnlDashboard());
    }
    public BasePanel getPnlTopSideBar(){
        return PnlTopSideBar;
    }
    /**
     * <code>setPnlLogout()</code> is a panel container for the Logout button.
     * <p>
     * <code>pnlLogout</code> is initialized with a transparent background, a width of 280 px and a height
     * of 100 px. It has left alignment using the {@link java.awt.BorderLayout} to make its components get
     * painted from the left of the container.
     * There is a top border to act as a divider between the top and bottom of the sidebar.
     * <p>
     * <code>btnLogout</code> is created with the Logout.png image added to it. It has a left horizontal
     * alignment and has 3 copies of the Logout image with different colors to be changed when the button is
     * interacted with.
     * <p>
     * <code>btnLogout</code> is added to the bottom of <code>pnlLogout</code>
     *
     *
     * @see BasePanel
     * @see BaseButton
     */
    public void setPnlLogout(){
        //Creating the Logout panel
        pnlLogout = new BasePanel(false,280,100);
        pnlLogout.setLayout(new FlowLayout(FlowLayout.LEADING));

        //Creating a top white divider
        pnlLogout.setBorder(BorderFactory.createMatteBorder(1,0,0,0,new Color(0xFFFFFF)));


        //Creating the Logout button:
        BaseButton btnLogout = new BaseButton("Logout", 20, 280, 40);
        btnLogout.setImage("src/Resources/Logout/logout.png");
        btnLogout.setHorizontalAlignment(JButton.LEFT); //aligning the content of the label to the left.

        btnLogout.setImageOnEvent("src/Resources/Logout/logout.png",
                "src/Resources/Logout/lightLogout.png",
                "src/Resources/Logout/darkLogout.png");

        //Add button to the Logout panel which is in the bottom of the sidebar
        pnlLogout.add(btnLogout);

        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BaseDashboard.this.dispose();
                new LoginPage();
            }
        });
    }

    /**
     * <code>getPnlLogout()</code> is a getter for <code>pnlLogout</code> to prevent it from being accessed directly.
     * @return <code>pnlLogout</code> which contains the Logout button.
     */
    public JPanel getPnlLogout(){
        return pnlLogout;
    }
    public void setPnlLogo(){
        pnlLogo = new BasePanel(false);

        BaseLabel lblLogo = new BaseLabel();
        lblLogo.setImage("src/Resources/Logo.png");

        pnlLogo.add(lblLogo);
    }
    public BasePanel getPnlLogo(){
        return pnlLogo;
    }

    public void setPnlDashboard() {
        pnlDashboard = new BasePanel(false);
//        pnlDashboard.setLayout(new FlowLayout(FlowLayout.LEADING));

        btnDashboard = new BaseButton("Dashboard", 20, 280, 40);
        btnDashboard.setImage("src/Resources/Dashboard/baseDashboard.png");
        btnDashboard.setHorizontalAlignment(JButton.LEFT);

        btnDashboard.setImageOnEvent("src/Resources/Dashboard/baseDashboard.png",
                                     "src/Resources/Dashboard/lightDashboard.png",
                                     "src/Resources/Dashboard/darkDashboard.png");


//        btnDashboard.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                BaseDashboard.this.dispose();
//            }
//        });

        pnlDashboard.add(btnDashboard);
    }
    public BasePanel getPnlDashboard(){
        return pnlDashboard;
    }

    public BaseButton getBtnDashboard(){
        return btnDashboard;
    }



}
