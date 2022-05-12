package UI.Dashboard.Trainer;

import UI.Dashboard.BaseDashboard;
import UI.Dashboard.Manager.PnlManagerBookSession;
import java.awt.*;

public class BaseTrainerDashboard extends BaseDashboard {
    private PnlManagerBookSession pnlManagerBookSession;
    public BaseTrainerDashboard(){
        setTitle("Trainer");
    }
    public void setPnlRightSide(){
        super.setPnlRightSide();
        rightSideBorders();

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
//        super.btnDashboard.setFrameName("ManagerDashboard");

    }

    public void setPnlBookSession(){
        pnlManagerBookSession = new PnlManagerBookSession(false);
    }
    public PnlManagerBookSession getPnlManagerBookSession(){
        return pnlManagerBookSession;
    }
}


































































