package UI.Dashboard.Trainer;

import UI.BaseComponents.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class PnlTrainerCheckTrainingSessions extends BasePanel {

    private BaseTextField txtSessionNo;
    private BaseTextField txtDate;
    private BaseTextField txtUsername;
    private BaseTextField txtExerciseType;
    private BaseTextField txtDuration;
    private BaseTextField txtFeedback;


    public PnlTrainerCheckTrainingSessions(boolean opaque) {
        super(opaque);
        setLayout(new GridBagLayout());

        BasePanel pnlTitle = new BasePanel(false);
        BaseLabel lblTitle = new BaseLabel("Training Session Details", 40);
        pnlTitle.add(lblTitle); //Adding the title label to the title panel


        //Creating the text field for the Username.
        BasePanel pnlSessionNo = new BasePanel(false);
        pnlSessionNo.setLayout(new FlowLayout(FlowLayout.TRAILING));
        BaseLabel lblSessionNo = new BaseLabel("Session No:    ");
        pnlSessionNo.add(lblSessionNo);


        txtSessionNo = new BaseTextField(24, 400, 50);


        BasePanel pnlDate = new BasePanel(false);
        pnlDate.setLayout(new FlowLayout(FlowLayout.TRAILING));
        BaseLabel lblDate = new BaseLabel("Date:    ");
        pnlDate.add(lblDate);


        txtDate = new BaseTextField("DD/MM/YYYY", 24, 400, 50);
        txtDate.setFocusable(false);


        BasePanel pnlUsername = new BasePanel(false);
        pnlUsername.setLayout(new FlowLayout(FlowLayout.TRAILING));
        BaseLabel lblUsernameUN = new BaseLabel("Username:    ");
        pnlUsername.add(lblUsernameUN);

        txtUsername = new BaseTextField(24, 400, 50);
        txtUsername.setFocusable(false);

        BasePanel pnlExerciseType = new BasePanel(false);
        pnlExerciseType.setLayout(new FlowLayout(FlowLayout.TRAILING));
        BaseLabel lblExerciseType = new BaseLabel("Exercise Type:    ");
        pnlExerciseType.add(lblExerciseType);


        txtExerciseType = new BaseTextField(24, 400, 50);
        txtExerciseType.setFocusable(false);


        BasePanel pnlDuration = new BasePanel(false);
        pnlDuration.setLayout(new FlowLayout(FlowLayout.TRAILING));
        BaseLabel lblDuration = new BaseLabel("Duration:    ");
        pnlDuration.add(lblDuration);


        txtDuration = new BaseTextField(24, 400, 50);
        txtDuration.setFocusable(false);


        BasePanel pnlCheckSession = new BasePanel(false);
        pnlCheckSession.setLayout(new FlowLayout(FlowLayout.RIGHT));


        //Creating the book button:
        BaseButton btnCheckSession = new BaseButton("Check", 200, 40);
        pnlCheckSession.add(btnCheckSession);

        BaseButton btnGenReport = new BaseButton("Generate Report", 300, 40);
        pnlCheckSession.add(btnGenReport);



        BasePanel pnlFeedback = new BasePanel(false);
        pnlFeedback.setLayout(new FlowLayout(FlowLayout.TRAILING));
        BaseLabel lblFeedbackUN = new BaseLabel("Feedback:    ");
        pnlFeedback.add(lblFeedbackUN);


        txtFeedback = new BaseTextField(24, 400, 50);
        txtFeedback.setFocusable(false);


        Component[] loginLabels = new Component[6];
        loginLabels[0] = pnlSessionNo;
        loginLabels[1] = pnlUsername;
        loginLabels[2] = pnlExerciseType;
        loginLabels[3] = pnlDuration;
        loginLabels[4] = pnlDate;
        loginLabels[5] = pnlFeedback;

        Component[] loginTextFields = new Component[6];
        loginTextFields[0] = txtSessionNo;
        loginTextFields[1] = txtUsername;
        loginTextFields[2] = txtExerciseType;
        loginTextFields[3] = txtDuration;
        loginTextFields[4] = txtDate;
        loginTextFields[5] = txtFeedback;

        GridBagConstraints GBCCheckSession = new GridBagConstraints();
        GBCCheckSession.weightx = 0.5;
        GBCCheckSession.weighty = 0.5;
        GBCCheckSession.fill = GridBagConstraints.HORIZONTAL;


        GBCCheckSession.gridx = 0;
        GBCCheckSession.gridy = 0;
        GBCCheckSession.gridwidth = 2;
        this.add(pnlTitle, GBCCheckSession);


        for (int lblRows = 0; lblRows < loginLabels.length; lblRows++) {
            GBCCheckSession.gridx = 0;
            GBCCheckSession.gridy = lblRows + 1;
            GBCCheckSession.gridwidth = 1;
            this.add(loginLabels[lblRows], GBCCheckSession);
        }

        for (int txtRows = 0; txtRows < loginLabels.length; txtRows++) {
            GBCCheckSession.gridx = 1;
            GBCCheckSession.gridy = txtRows + 1;
            GBCCheckSession.gridwidth = 1;
            this.add(loginTextFields[txtRows], GBCCheckSession);
        }

        GBCCheckSession.gridx = 0;
        GBCCheckSession.gridy = 8;
        GBCCheckSession.gridwidth = 2;
        this.add(pnlCheckSession, GBCCheckSession);


        btnCheckSession.addActionListener(new PnlTrainerCheckTrainingSessions.SessionInfo());
    }



    public BaseTextField getTxtSessionNo() {
        return txtSessionNo;
    }

    public BaseTextField getTxtDate() {
        return txtDate;
    }

    public BaseTextField getTxtUsername() {
        return txtUsername;
    }

    public BaseTextField getTxtExerciseType() {
        return txtExerciseType;
    }

    public BaseTextField getTxtDuration() {
        return txtDuration;
    }

    public BaseTextField getTxtFeedback() {
        return txtFeedback;
    }

    public void setTxtSessionNo(BaseTextField txtSessionNo) {
        this.txtSessionNo = txtSessionNo;
    }

    public void setTxtDate(BaseTextField txtDate) {
        this.txtDate = txtDate;
    }

    public void setTxtUsername(BaseTextField txtUsername) {
        this.txtUsername = txtUsername;
    }

    public void setTxtExerciseType(BaseTextField txtExerciseType) {
        this.txtExerciseType = txtExerciseType;
    }

    public void setTxtDuration(BaseTextField txtDuration) {
        this.txtDuration = txtDuration;
    }

    public void setTxtFeedback(BaseTextField txtFeedback) {
        this.txtFeedback = txtFeedback;
    }

    public class SessionInfo implements ActionListener {
        boolean customerExist = false;
        boolean trainerExist = false;

        public void actionPerformed(ActionEvent event) {
            ArrayList<String> arrSessionInfo = new ArrayList<>();
            arrSessionInfo.add(getTxtSessionNo().getText());

            try {
                Scanner scCustomerInfo = new Scanner(new File("src/DataBase/BookedSessions.txt"));
                while (scCustomerInfo.hasNextLine()) {
                    String strThisLine = scCustomerInfo.nextLine();
                    String[] arUserLine = strThisLine.split(",");

                    if (arrSessionInfo.get(0).equals(arUserLine[0]) && arUserLine[5].equals("Customer")) {
                        customerExist = true;
                        break;
                    } else {
                        customerExist = false;
                    }
                }
                scCustomerInfo.close();
                Scanner scTrainerInfo = new Scanner(new File("src/DataBase/BookedSessions.txt"));
                while (scTrainerInfo.hasNextLine()) {
                    String strThisLine = scTrainerInfo.nextLine();
                    String[] arUserLine = strThisLine.split(",");

                    if (arrSessionInfo.get(0).equals(arUserLine[0])) {
                        getTxtUsername().setText(arUserLine[1]);
                        getTxtExerciseType().setText(arUserLine[3]);
                        getTxtDate().setText(arUserLine[4]);
                        getTxtDuration().setText(arUserLine[5]);
                        break;
                    }
                }
                scTrainerInfo.close();

            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(null,
                        "There is no database to fetch the data from!", "Error",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}