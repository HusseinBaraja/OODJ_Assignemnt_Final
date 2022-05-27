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

public class PnlTrainerCollectPayment extends BasePanel {


    private BaseTextField txtSessionNo;

    private BaseTextField txtPaid;
    private BaseTextField txtAmount;


    public PnlTrainerCollectPayment(boolean opaque) {
        super(opaque);
        setLayout(new GridBagLayout());


        BasePanel pnlTitle = new BasePanel(false);
        BaseLabel lblTitle = new BaseLabel("Payment", 40);
        pnlTitle.add(lblTitle); //Adding the title label to the title panel


        BasePanel pnlSessionNo = new BasePanel(false);
        pnlSessionNo.setLayout(new FlowLayout(FlowLayout.TRAILING));
        BaseLabel lblSessionNo = new BaseLabel("Service No:    ");
        pnlSessionNo.add(lblSessionNo);

        txtSessionNo = new BaseTextField(24, 400, 50);


        BasePanel pnlAmount = new BasePanel(false);
        pnlAmount.setLayout(new FlowLayout(FlowLayout.TRAILING));
        BaseLabel lblAmountUN = new BaseLabel("Amount:    ");
        pnlAmount.add(lblAmountUN);

        txtAmount = new BaseTextField(24, 400, 50);
        txtAmount.setFocusable(false);


        BasePanel pnlPaid = new BasePanel(false);
        pnlPaid.setLayout(new FlowLayout(FlowLayout.TRAILING));
        BaseLabel lblPaidUN = new BaseLabel("Paid?:    ");
        pnlPaid.add(lblPaidUN);

        txtPaid = new BaseTextField(24, 400, 50);
        txtPaid.setFocusable(false);


        BasePanel pnlPayment = new BasePanel(false);
        pnlPayment.setLayout(new FlowLayout(FlowLayout.RIGHT));
        BaseButton btnPaymentInfo = new BaseButton("Payment Info", 200, 40);
        pnlPayment.add(btnPaymentInfo);

        BaseButton btnPayment = new BaseButton("Pay", 200, 40);
        pnlPayment.add(btnPayment);


        Component[] loginLabels = new Component[3];
        loginLabels[0] = pnlSessionNo;
        loginLabels[1] = pnlAmount;
        loginLabels[2] = pnlPaid;

        Component[] loginTextFields = new Component[3];
        loginTextFields[0] = txtSessionNo;
        loginTextFields[1] = txtAmount;
        loginTextFields[2] = txtPaid;


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
        this.add(pnlPayment, GBCCheckSession);

        btnPaymentInfo.addActionListener(new PnlTrainerCollectPayment.PaymentInfo());
    }

    public BaseTextField getTxtSessionNo() {
        return txtSessionNo;
    }

    public void setTxtSessionNo(BaseTextField txtSessionNo) {
        this.txtSessionNo = txtSessionNo;
    }

    public BaseTextField getTxtPaid() {
        return txtPaid;
    }

    public void setTxtPaid(BaseTextField txtPaid) {
        this.txtPaid = txtPaid;
    }

    public BaseTextField getTxtAmount() {
        return txtAmount;
    }

    public void setTxtAmount(BaseTextField txtAmount) {
        this.txtAmount = txtAmount;
    }

    public class PaymentInfo implements ActionListener {
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
                        getTxtPaid().setText(arUserLine[7]);
                        getTxtAmount().setText(arUserLine[6]);
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