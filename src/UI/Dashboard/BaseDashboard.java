package UI.Dashboard;

import UI.BaseComponents.BaseButton;
import UI.BaseComponents.BaseLabel;
import UI.BaseComponents.BasePanel;
import UI.BaseFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BaseDashboard extends BaseFrame {
    private BasePanel PnlTopSideBar;
    private BasePanel pnlLogo;
    private BasePanel pnlDashboard;
    private BaseButton btnDashboard;
    String something;

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

    public void setPnlLogo(){
        pnlLogo = new BasePanel(false);
//        pnlLogo.setBorder(BorderFactory.createMatteBorder(0,0,1,0,new Color(0xFFFFFF)));

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
