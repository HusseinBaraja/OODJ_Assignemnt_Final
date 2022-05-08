package UI;

import javax.swing.*;

public class BaseManagerDashboard extends BaseDashboard {
    private BasePanel pnlUserRegistration;
    private BasePanel pnlBookSession;
//    private String currentFrame;
    private boolean isShown = false;


    public BaseManagerDashboard(){
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
//    public void setCurrentFrame(){
//        this.currentFrame = "BaseManagerDashboard";
//    }
    public void hideCurrentFrame(){
        super.dispose();
    }

    public void setPnlUserRegistration() {
        pnlUserRegistration = new BasePanel(false,280,50);
//        pnlDashboard.setLayout(new FlowLayout(FlowLayout.LEADING));

        BaseButton btnUserRegistration = new BaseButton("User Registration", 20, 0xFFFFFF, 280, 40);
        btnUserRegistration.setImage("src/Resources/Manager/UserRegistration/baseUserRegistration.png");
        btnUserRegistration.setHorizontalAlignment(JButton.LEFT);
//        btnUserRegistration.setPreviousFrame(currentFrame);

        btnUserRegistration.setImageOnEvent("src/Resources/Manager/UserRegistration/baseUserRegistration.png",
                                            "src/Resources/Manager/UserRegistration/lightUserRegistration.png",
                                            "src/Resources/Manager/UserRegistration/darkUserRegistration.png");


        btnUserRegistration.setFrameOnClick("ManagerRegistration");
        
        pnlUserRegistration.add(btnUserRegistration);
    }
    public BasePanel getPnlUserRegistration(){
        return pnlUserRegistration;
    }


    public void setPnlBookSession() {
        pnlBookSession = new BasePanel(false,280,50);
//        pnlDashboard.setLayout(new FlowLayout(FlowLayout.LEADING));

        BaseButton btnBookSession = new BaseButton("Book training session", 20, 0xFFFFFF, 280, 40);
        btnBookSession.setImage("src/Resources/Manager/BookSession/baseBookSession.png");
        btnBookSession.setHorizontalAlignment(JButton.LEFT);
//        btnBookSession.setPreviousFrame(currentFrame);

        btnBookSession.setImageOnEvent("src/Resources/Manager/BookSession/baseBookSession.png",
                                       "src/Resources/Manager/BookSession/lightBookSession.png",
                                       "src/Resources/Manager/BookSession/darkBookSession.png");


        btnBookSession.setFrameOnClick("ManagerBookSession");

        pnlBookSession.add(btnBookSession);
    }
    public BasePanel getPnlBookSession(){
        return pnlBookSession;
    }
}
