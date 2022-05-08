package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerBookSession extends BaseManagerDashboard implements ActionListener {
    private BaseLabel lblTest2;
    public ManagerBookSession(){
        setTitle("Manager Book training session");
//        hideCurrentFrame();
    }
    public void setPnlRightSide(){
        super.setPnlRightSide();
        setLblTest2();
        getPnlRightSide().add(getLblTest2(), BorderLayout.CENTER);
    }
    public void setLblTest2(){
        lblTest2 = new BaseLabel("this is manager Book Session", 36, "Arial", 0xFFFFFF);
    }
    public JLabel getLblTest2(){
        return lblTest2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
