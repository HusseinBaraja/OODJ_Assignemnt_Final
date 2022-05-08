package UI.Dashboard.Manager;

import UI.BaseComponents.BaseLabel;
import UI.Dashboard.Manager.BaseManagerDashboard;

import javax.swing.*;
import java.awt.*;

public class ManagerDashboard extends BaseManagerDashboard {
    private BaseLabel lblTest2;
    public ManagerDashboard(){
        setTitle("Manager Dashboard");
    }

    public void setPnlRightSide(){
        super.setPnlRightSide();
        setLblTest2();
        getPnlRightSide().add(getLblTest2(), BorderLayout.CENTER);
    }
    public void setLblTest2(){
        lblTest2 = new BaseLabel("this is manager Dashboard", 36, "Arial", 0xFFFFFF);
    }
    public JLabel getLblTest2(){
        return lblTest2;
    }
    public void setPnlDashboard(){
        super.setPnlDashboard();
        getBtnDashboard().setFrameName("ManagerDashboard");
    }

}
