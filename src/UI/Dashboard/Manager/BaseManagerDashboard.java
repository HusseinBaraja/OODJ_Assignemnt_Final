package UI.Dashboard.Manager;

import UI.BaseComponents.BaseButton;
import UI.BaseComponents.BaseLabel;
import UI.BaseComponents.BasePanel;
import UI.Dashboard.BaseDashboard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BaseManagerDashboard extends BaseDashboard {
    private BasePanel pnlUserRegistration;
    private BasePanel pnlBookSession;
//    private String currentFrame;
    private boolean isShown = false;
    private PnlManagerRegistration pnlManagerRegistration;
    private PnlManagerBookSession pnlManagerBookSession;


    public BaseManagerDashboard(){
        setTitle("Base Manger Dashboard Template");
    }

    public void setPnlRightSide(){
        super.setPnlRightSide();
        this.getPnlRightSide().add(new BasePanel(false), BorderLayout.NORTH);
        this.getPnlRightSide().add(new BasePanel(false, 100,500), BorderLayout.EAST);
        this.getPnlRightSide().add(new BasePanel(false), BorderLayout.SOUTH);
        this.getPnlRightSide().add(new BasePanel(false, 100,500), BorderLayout.WEST);

        setPnlUserRegistration();
        this.getPnlRightSide().add(getPnlManagerRegistration(), BorderLayout.CENTER);
        getPnlManagerRegistration().setVisible(false);



        setPnlBookSession();
        this.getPnlRightSide().add(getPnlManagerBookSession(), BorderLayout.CENTER);
        getPnlManagerBookSession().setVisible(false);
    }

    public void setPnlUserRegistration(){
        pnlManagerRegistration = new PnlManagerRegistration(false);
    }
    public PnlManagerRegistration getPnlManagerRegistration(){
        return pnlManagerRegistration;
    }

    public void setPnlBookSession(){
        pnlManagerBookSession = new PnlManagerBookSession(false);
    }
    public PnlManagerBookSession getPnlManagerBookSession(){
        return pnlManagerBookSession;
    }
    @Override
    public void setPnlTopSideBar(){
        super.setPnlTopSideBar();
        setPnlUserRegistrationButton();
        getPnlTopSideBar().add(getPnlUserRegistrationButton());

        setPnlBookSessionButton();
        getPnlTopSideBar().add(getPnlBookSessionButton());
    }

    public void setPnlUserRegistrationButton() {
        pnlUserRegistration = new BasePanel(false,280,50);
//        pnlDashboard.setLayout(new FlowLayout(FlowLayout.LEADING));

        BaseButton btnUserRegistration = new BaseButton("User Registration", 20, 0xFFFFFF, 280, 40);
        btnUserRegistration.setImage("src/Resources/Manager/UserRegistration/baseUserRegistration.png");
        btnUserRegistration.setHorizontalAlignment(JButton.LEFT);
//        btnUserRegistration.setPreviousFrame(currentFrame);

        btnUserRegistration.setImageOnEvent("src/Resources/Manager/UserRegistration/baseUserRegistration.png",
                                            "src/Resources/Manager/UserRegistration/lightUserRegistration.png",
                                            "src/Resources/Manager/UserRegistration/darkUserRegistration.png");

        btnUserRegistration.setFrameName("ManagerRegistration");


        btnUserRegistration.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnUserRegistration){
                    pnlManagerBookSession.setVisible(false);
                    pnlManagerRegistration.setVisible(true);
                }
            }
        });
        
        pnlUserRegistration.add(btnUserRegistration);
    }
    public BasePanel getPnlUserRegistrationButton(){
        return pnlUserRegistration;
    }

    public void setPnlBookSessionButton() {
        pnlBookSession = new BasePanel(false,280,50);
//        pnlDashboard.setLayout(new FlowLayout(FlowLayout.LEADING));

        BaseButton btnBookSession = new BaseButton("Book training session", 20, 0xFFFFFF, 280, 40);
        btnBookSession.setImage("src/Resources/Manager/BookSession/baseBookSession.png");
        btnBookSession.setHorizontalAlignment(JButton.LEFT);
//        btnBookSession.setPreviousFrame(currentFrame);

        btnBookSession.setImageOnEvent("src/Resources/Manager/BookSession/baseBookSession.png",
                                       "src/Resources/Manager/BookSession/lightBookSession.png",
                                       "src/Resources/Manager/BookSession/darkBookSession.png");


//        btnBookSession.setFrameName("ManagerBookSession");
        btnBookSession.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnBookSession){
                    pnlManagerRegistration.setVisible(false);
                    pnlManagerBookSession.setVisible(true);
                }

            }
        });
        pnlBookSession.add(btnBookSession);
    }
    public BasePanel getPnlBookSessionButton(){
        return pnlBookSession;
    }


}
