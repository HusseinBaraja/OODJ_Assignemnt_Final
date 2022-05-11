package UI.Dashboard.Trainer;

import UI.BaseComponents.BaseButton;
import UI.BaseComponents.BasePanel;
import UI.Dashboard.BaseDashboard;
import UI.Dashboard.Manager.PnlManagerBookSession;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BaseTrainerDashboard extends BaseDashboard {
    private PnlManagerBookSession pnlManagerBookSession;
    public BaseTrainerDashboard(){

    }
    public void setPnlRightSide(){
        super.setPnlRightSide();


        setPnlBookSession();
        this.getPnlRightSide().add(getPnlManagerBookSession(), BorderLayout.CENTER);

    }
    public void setPnlLeftSide(){
        super.setPnlLeftSide();
        setPnlTopSideBar();
        this.getPnlLeftSide().add(getPnlTopSideBar(), BorderLayout.CENTER);
    }

    public void setPnlDashboard() {
        super.setPnlDashboard();
        getSomething("TrainerDashboard");
//        super.btnDashboard.setFrameName("ManagerDashboard");

    }

    public void setPnlBookSession(){
        pnlManagerBookSession = new PnlManagerBookSession(false);
    }
    public PnlManagerBookSession getPnlManagerBookSession(){
        return pnlManagerBookSession;
    }
}
