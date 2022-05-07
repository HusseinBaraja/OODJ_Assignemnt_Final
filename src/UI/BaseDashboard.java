package UI;

import javax.swing.*;
import java.awt.*;

public class BaseDashboard extends BaseFrame{
    public BasePanel PnlTopSideBar;
    public BasePanel pnlLogo;
    public BasePanel pnlDashboard;

    public BaseDashboard(){
        setTitle("Base Dashboard Template");
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
        lblLogo.setImage("src/Resources/logo.png");

        pnlLogo.add(lblLogo);
    }
    public BasePanel getPnlLogo(){
        return pnlLogo;
    }

    public void setPnlDashboard() {
        pnlDashboard = new BasePanel(false,250,50);
        pnlDashboard.setLayout(new FlowLayout(FlowLayout.LEADING));

        BaseLabel lblDashboard = new BaseLabel("Dashboard", 20, "Arial", 0xFFFFFF);
        lblDashboard.setImage("src/Resources/Dashboard/baseDashboard.png");
        lblDashboard.setAlignment(JLabel.LEFT, JLabel.CENTER);


        pnlDashboard.add(lblDashboard);
    }
    public BasePanel getPnlDashboard(){
        return pnlDashboard;
    }



}
