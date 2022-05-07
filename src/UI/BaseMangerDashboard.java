package UI;

import javax.swing.*;
import java.awt.*;

public class BaseMangerDashboard extends BaseDashboard {
    public BasePanel pnlUserRegistration;
    public BasePanel pnlBookSession;

    public BaseMangerDashboard(){
        setTitle("Base Manger Dashboard Template");
    }
    @Override
    public void setPnlTopSideBar(){
        super.setPnlTopSideBar();
        setPnlUserRegistration();
        PnlTopSideBar.add(getPnlUserRegistration());
        setPnlBookSession();
        PnlTopSideBar.add(getPnlBookSession());
    }

    public void setPnlUserRegistration() {
        pnlUserRegistration = new BasePanel(false,250,50);
        pnlDashboard.setLayout(new FlowLayout(FlowLayout.LEADING));

        BaseButton btnUserRegistration = new BaseButton("User Registration", 20, 0xFFFFFF, 250, 40);
        btnUserRegistration.setImage("src/Resources/Manager/UserRegistration/baseUserRegistration.png");
        btnUserRegistration.setHorizontalAlignment(JButton.LEFT);

        btnUserRegistration.setImageOnEvent("src/Resources/Manager/UserRegistration/baseUserRegistration.png",
                                            "src/Resources/Manager/UserRegistration/lightUserRegistration.png",
                                            "src/Resources/Manager/UserRegistration/darkUserRegistration.png");


        pnlUserRegistration.add(btnUserRegistration);
    }
    public BasePanel getPnlUserRegistration(){
        return pnlUserRegistration;
    }


    public void setPnlBookSession() {
        pnlBookSession = new BasePanel(false,250,50);
        pnlDashboard.setLayout(new FlowLayout(FlowLayout.LEADING));

        BaseButton btnBookSession = new BaseButton("Book training session", 20, 0xFFFFFF, 250, 40);
        btnBookSession.setImage("src/Resources/Manager/BookSession/baseBookSession.png");
        btnBookSession.setHorizontalAlignment(JButton.LEFT);

        btnBookSession.setImageOnEvent("src/Resources/Manager/BookSession/baseBookSession.png",
                                       "src/Resources/Manager/BookSession/lightBookSession.png",
                                       "src/Resources/Manager/BookSession/darkBookSession.png");


        pnlBookSession.add(btnBookSession);
    }
    public BasePanel getPnlBookSession(){
        return pnlBookSession;
    }
}
