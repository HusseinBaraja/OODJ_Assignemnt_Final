package UI;

import javax.swing.*;
import java.awt.*;

public class ManagerRegistration extends BaseManagerDashboard {
    private BaseLabel lblTest1;
    public ManagerRegistration(){
        setTitle("Manager Registration");
//        hideCurrentFrame();
    }
    public void setPnlRightSide(){
        super.setPnlRightSide();
        setLblTest1();
        getPnlRightSide().add(getLblTest1(), BorderLayout.CENTER);
    }
    public void setLblTest1(){
        lblTest1 = new BaseLabel("this is manager registration", 36, "Arial", 0xFFFFFF);
    }
    public JLabel getLblTest1(){
        return lblTest1;
    }
}
