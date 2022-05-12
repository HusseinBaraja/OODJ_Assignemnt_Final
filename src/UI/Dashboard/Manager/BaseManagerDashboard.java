package UI.Dashboard.Manager;

import UI.BaseComponents.BaseButton;
import UI.BaseComponents.BasePanel;
import UI.Dashboard.BaseDashboard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BaseManagerDashboard extends BaseDashboard {
    private BasePanel pnlUserRegistration;
    private BasePanel pnlBookSession;
    private PnlManagerDashboard pnlManagerDashboard;
    private PnlManagerRegistration pnlManagerRegistration;
    private PnlManagerBookSession pnlManagerBookSession;
    private int chosenPanel = 0;


    public BaseManagerDashboard(){
        setTitle("Manger");
    }
    public void setPnlRightSide(){
        super.setPnlRightSide();
        rightSideBorders();

        //we set the panels here so that setVisible(true || false) works without throwing a null exception
        setPnlManagerDashboard();
        setPnlUserRegistration();
        setPnlBookSession();

        setPanel();
    }

    private void setPanel(){
        switch (chosenPanel) {
            case 0 -> {
                setPnlManagerDashboard();
                this.getPnlRightSide().add(getPnlManagerDashboard(), BorderLayout.CENTER);
            }
            case 1 -> {
                setPnlUserRegistration();
                this.getPnlRightSide().add(getPnlManagerRegistration(), BorderLayout.CENTER);
            }
            case 2 -> {
                setPnlBookSession();
                this.getPnlRightSide().add(getPnlManagerBookSession(), BorderLayout.CENTER);
            }
        }
    }
    public void setPnlManagerDashboard(){
        pnlManagerDashboard = new PnlManagerDashboard(false);
    }
    public PnlManagerDashboard getPnlManagerDashboard(){
        return pnlManagerDashboard;
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

    @Override
    public void setPnlDashboard() {
        super.setPnlDashboard();
        super.getBtnDashboard().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == getBtnDashboard()){
                    chosenPanel = 0;
                    setPanel();
                    pnlManagerBookSession.setVisible(false);
                    pnlManagerRegistration.setVisible(false);
                    pnlManagerDashboard.setVisible(true);
                }
            }
        });
        getPnlDashboard().add(getBtnDashboard());
    }
    public void setPnlUserRegistrationButton() {
        pnlUserRegistration = new BasePanel(false,280,50);
//        pnlDashboard.setLayout(new FlowLayout(FlowLayout.LEADING));

        BaseButton btnUserRegistration = new BaseButton("User Registration", 20, 280, 40);
        btnUserRegistration.setImage("src/Resources/Manager/UserRegistration/baseUserRegistration.png");
        btnUserRegistration.setHorizontalAlignment(JButton.LEFT);
//        btnUserRegistration.setPreviousFrame(currentFrame);

        btnUserRegistration.setImageOnEvent("src/Resources/Manager/UserRegistration/baseUserRegistration.png",
                                            "src/Resources/Manager/UserRegistration/lightUserRegistration.png",
                                            "src/Resources/Manager/UserRegistration/darkUserRegistration.png");

//        btnUserRegistration.setFrameName("ManagerRegistration");


        btnUserRegistration.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnUserRegistration){
                    chosenPanel = 1;
                    setPanel();
                    pnlManagerDashboard.setVisible(false);
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

        BaseButton btnBookSession = new BaseButton("Book training session", 20, 280, 40);
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
                    chosenPanel = 2;
                    setPanel();
                    pnlManagerDashboard.setVisible(false);
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
