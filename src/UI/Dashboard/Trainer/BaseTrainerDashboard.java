package UI.Dashboard.Trainer;

import UI.BaseComponents.BaseButton;
import UI.BaseComponents.BasePanel;
import UI.Dashboard.BaseDashboard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BaseTrainerDashboard extends BaseDashboard {
    private BasePanel PnlTrainerCheckTrainingSessions;
    private BasePanel PnlTrainerCollectPayment;
    private BasePanel PnlTrainerFeedback;
    private PnlTrainerDashboard pnlTrainerDashboard;
    private PnlTrainerCheckTrainingSessions pnlTrainerCheckTrainingSessions;
    private PnlTrainerCollectPayment pnlTrainerCollectPayment;
    private int chosenPanel = 0;


    public BaseTrainerDashboard() {
        setTitle("Trainer");
    }

    public void setPnlRightSide() {
        super.setPnlRightSide();
        rightSideBorders();

        //we set the panels here so that setVisible(true || false) works without throwing a null exception
        setPnlTrainerDashboard();
        setPnlTrainerCheckTrainingSessions();
        setPnlTrainerCollectPayment();


        setPanel();
    }

    private void setPanel() {
        switch (chosenPanel) {
            case 0 -> {
                setPnlTrainerDashboard();
                this.getPnlRightSide().add(getPnlTrainerDashboard(), BorderLayout.CENTER);
            }
            case 1 -> {
                setPnlTrainerCheckTrainingSessions();
                this.getPnlRightSide().add(getPnlTrainerCheckTrainingSessions(), BorderLayout.CENTER);
            }
            case 2 -> {
                setPnlTrainerCollectPayment();
                this.getPnlRightSide().add(getPnlTrainerCollectPayment(), BorderLayout.CENTER);
            }
        }
    }

    public void setPnlTrainerDashboard() {
        pnlTrainerDashboard = new PnlTrainerDashboard(false);
    }

    public PnlTrainerDashboard getPnlTrainerDashboard() {
        return pnlTrainerDashboard;
    }

    public void setPnlTrainerCheckTrainingSessions() {
        pnlTrainerCheckTrainingSessions = new PnlTrainerCheckTrainingSessions(false);
    }

    public UI.Dashboard.Trainer.PnlTrainerCheckTrainingSessions getPnlTrainerCheckTrainingSessions() {
        return pnlTrainerCheckTrainingSessions;
    }

    public void setPnlTrainerCollectPayment() {
        pnlTrainerCollectPayment = new PnlTrainerCollectPayment(false);
    }

    public PnlTrainerCollectPayment getPnlTrainerCollectPayment() {
        return pnlTrainerCollectPayment;
    }


    @Override
    public void setPnlTopSideBar(){
        super.setPnlTopSideBar();

        setPnlTrainerCheckTrainingSessionsButton();
        getPnlTopSideBar().add(getPnlTrainerCheckTrainingSessionsButton());

        setPnlTrainerCollectPaymentButton();
        getPnlTopSideBar().add(getPnlTrainerCollectPaymentButton());

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
                    pnlTrainerCollectPayment.setVisible(false);
                    pnlTrainerCheckTrainingSessions.setVisible(false);
                    pnlTrainerDashboard.setVisible(true);
                }
            }
        });
        getPnlDashboard().add(getBtnDashboard());
    }
    public void setPnlTrainerCheckTrainingSessionsButton() {
        PnlTrainerCheckTrainingSessions = new BasePanel(false,280,50);
//        pnlDashboard.setLayout(new FlowLayout(FlowLayout.LEADING));

        BaseButton btnTrainerCheckTrainingSessions = new BaseButton("Training Sessions", 20, 280, 40);
        btnTrainerCheckTrainingSessions.setImage("src/Resources/Trainer/BaseCalender21.png");
        btnTrainerCheckTrainingSessions.setHorizontalAlignment(JButton.LEFT);
//        btnTrainerCheckTrainingSessions.setPreviousFrame(currentFrame);

        btnTrainerCheckTrainingSessions.setImageOnEvent("src/Resources/Trainer/BaseCalender21.png",
                "src/Resources/Trainer/LightCalender21.png",
                "src/Resources/Trainer/DarkCalender21.png");

//        btnTrainerCheckTrainingSessions.setFrameName("TrainerCheckTrainingSessions");


        btnTrainerCheckTrainingSessions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnTrainerCheckTrainingSessions){
                    chosenPanel = 1;
                    setPanel();
                    pnlTrainerDashboard.setVisible(false);
                    pnlTrainerCollectPayment.setVisible(false);
                    pnlTrainerCheckTrainingSessions.setVisible(true);
                }
            }
        });

        PnlTrainerCheckTrainingSessions.add(btnTrainerCheckTrainingSessions);
    }
    public BasePanel getPnlTrainerCheckTrainingSessionsButton(){
        return PnlTrainerCheckTrainingSessions;
    }

    public void setPnlTrainerCollectPaymentButton() {
        PnlTrainerCollectPayment = new BasePanel(false,280,50);
//        pnlDashboard.setLayout(new FlowLayout(FlowLayout.LEADING));

        BaseButton btnTrainerCollectPayment = new BaseButton("Collect Payment", 20, 280, 40);
        btnTrainerCollectPayment.setImage("src/Resources/Trainer/BaseCardSecurity.png");
        btnTrainerCollectPayment.setHorizontalAlignment(JButton.LEFT);
//        btnTrainerCollectPayment.setPreviousFrame(currentFrame);

        btnTrainerCollectPayment.setImageOnEvent("src/Resources/Trainer/BaseCardSecurity.png",
                "src/Resources/Trainer/LightCardSecurity.png",
                "src/Resources/Trainer/DarkCardSecurity.png");


//        btnTrainerCollectPayment.setFrameName("TrainerCollectPayment");
        btnTrainerCollectPayment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnTrainerCollectPayment){
                    chosenPanel = 2;
                    setPanel();
                    pnlTrainerDashboard.setVisible(false);
                    pnlTrainerCheckTrainingSessions.setVisible(false);
                    pnlTrainerCollectPayment.setVisible(true);
                }

            }
        });
        PnlTrainerCollectPayment.add(btnTrainerCollectPayment);
    }
    public BasePanel getPnlTrainerCollectPaymentButton(){
        return PnlTrainerCollectPayment;
    }

}

