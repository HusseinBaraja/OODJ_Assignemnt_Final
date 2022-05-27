package UI.Dashboard.Manager;

import UI.BaseComponents.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class PnlManagerBookSession extends BasePanel {
    private BaseTextField txtCustomerUN;
    private BaseTextField txtTrainerUN;
    private BaseComboBox cmbExerciseType;
    private BaseTextField txtDate;
    private BaseComboBox cmbDuration;
    private BaseComboBox cmbPrice;
    public PnlManagerBookSession(boolean opaque) {
        super(opaque);
        setLayout(new GridBagLayout());

        BasePanel pnlTitle = new BasePanel(false);
        BaseLabel lblTitle = new BaseLabel("Book Training Session", 40);
        pnlTitle.add(lblTitle); //Adding the title label to the title panel



        BasePanel pnlCustomerUN = new BasePanel(false);
        pnlCustomerUN.setLayout(new FlowLayout(FlowLayout.TRAILING));
        BaseLabel lblCustomerUN = new BaseLabel("Customer Username:    ");
        pnlCustomerUN.add(lblCustomerUN);




        //Creating the text field for the Username.
        txtCustomerUN = new BaseTextField(24, 400,50);



        BasePanel pnlTrainerUN = new BasePanel(false);
        pnlTrainerUN.setLayout(new FlowLayout(FlowLayout.TRAILING));
        BaseLabel lblTrainerUN = new BaseLabel("Trainer Username:    ");
        pnlTrainerUN.add(lblTrainerUN);


        txtTrainerUN = new BaseTextField(24, 400,50);



        BasePanel pnlExerciseType = new BasePanel(false);
        pnlExerciseType.setLayout(new FlowLayout(FlowLayout.TRAILING));
        BaseLabel lblExerciseType = new BaseLabel("Exercise Type:    ");
        pnlExerciseType.add(lblExerciseType);



        String[] strExercises = { "Weightlifting", "Resistance band", "Bicep curls", "Bicep curls", "Pull-ups","Dips" };
        cmbExerciseType = new BaseComboBox(strExercises, 400, 50);


        BasePanel pnlDate = new BasePanel(false);
        pnlDate.setLayout(new FlowLayout(FlowLayout.TRAILING));
        BaseLabel lblDate = new BaseLabel("Date:    ");
        pnlDate.add(lblDate);


        txtDate = new BaseTextField("DD/MM/YYYY",24, 400,50);


        BasePanel pnlDuration = new BasePanel(false);
        pnlDuration.setLayout(new FlowLayout(FlowLayout.TRAILING));
        BaseLabel lblDuration = new BaseLabel("Duration:    ");
        pnlDuration.add(lblDuration);



        String[] strDuration = { "8am - 9am", "9am - 10am", "10am - 11am", "11am - 12pm", "2pm - 3pm","3pm - 4pm" };
        cmbDuration = new BaseComboBox(strDuration, 400, 50);



        BasePanel pnlPrice = new BasePanel(false);
        pnlPrice.setLayout(new FlowLayout(FlowLayout.TRAILING));
        BaseLabel lblPrice = new BaseLabel("Price:    ");
        pnlPrice.add(lblPrice);


        String[] PriceOptions = {"100 RM","250 RM", "500 RM"};
        cmbPrice = new BaseComboBox(PriceOptions, 200, 50);




        BasePanel pnlBook = new BasePanel(false);
        pnlBook.setLayout(new FlowLayout(FlowLayout.RIGHT));
        //Creating the book button:
        BaseButton btnBook = new BaseButton("Book", 200, 40);
        pnlBook.add(btnBook);

        /* How to add change listener
        btnBook.addChangeListener(new ChangeListener()
        {
            public void stateChanged(ChangeEvent e) {
                ButtonModel model = btnBook.getModel();

                if (model.isPressed()) { btnBook.setForeground(Color.gray); }
                else { btnBook.setForeground(Color.white); }
            }
        });
        */

        Component[] loginLabels = new Component[6];
        loginLabels[0] = pnlCustomerUN;
        loginLabels[1] = pnlTrainerUN;
        loginLabels[2] = pnlExerciseType;
        loginLabels[3] = pnlDuration;
        loginLabels[4] = pnlDate;
        loginLabels[5] = pnlPrice;

        Component[] loginTextFields = new Component[6];
        loginTextFields[0] = txtCustomerUN;
        loginTextFields[1] = txtTrainerUN;
        loginTextFields[2] = cmbExerciseType;
        loginTextFields[3] = cmbDuration;
        loginTextFields[4] = txtDate;
        loginTextFields[5] = cmbPrice;

        GridBagConstraints GBCBookSession = new GridBagConstraints();
        GBCBookSession.weightx = 0.5;
        GBCBookSession.weighty = 0.5;
        GBCBookSession.fill= GridBagConstraints.HORIZONTAL;



        GBCBookSession.gridx = 0;
        GBCBookSession.gridy = 0;
        GBCBookSession.gridwidth = 2;
        this.add(pnlTitle, GBCBookSession);



        for(int lblRows = 0; lblRows < loginLabels.length; lblRows++){
            GBCBookSession.gridx = 0;
            GBCBookSession.gridy = lblRows + 1;
            GBCBookSession.gridwidth = 1;
            this.add(loginLabels[lblRows], GBCBookSession);
        }

        for(int txtRows = 0; txtRows < loginLabels.length; txtRows++){
            GBCBookSession.gridx = 1;
            GBCBookSession.gridy = txtRows + 1;
            GBCBookSession.gridwidth = 1;
            this.add(loginTextFields[txtRows], GBCBookSession);
        }

        GBCBookSession.gridx = 0;
        GBCBookSession.gridy = 8;
        GBCBookSession.gridwidth = 2;
        this.add(pnlBook, GBCBookSession);


        btnBook.addActionListener(new PnlManagerBookSession.BookSession());
    }
    public BaseTextField getTxtCustomerUN(){
        return txtCustomerUN;
    }

    public BaseTextField getTxtTrainerUN(){
        return txtTrainerUN;
    }

    public BaseComboBox getCmbExerciseType() {
        return cmbExerciseType;
    }

    public BaseTextField getTxtDate() {
        return txtDate;
    }

    public BaseComboBox getCmbDuration() {
        return cmbDuration;
    }

    public BaseComboBox getCmbPrice() {
        return cmbPrice;
    }





    public class BookSession implements ActionListener {
        boolean customerExist = false;
        boolean trainerExist = false;
        public void actionPerformed(ActionEvent event) {
            ArrayList<String> arrBookedSession = new ArrayList<>();
            arrBookedSession.add(getTxtCustomerUN().getText());
            arrBookedSession.add(getTxtTrainerUN().getText());
            arrBookedSession.add(String.valueOf(getCmbExerciseType().getSelectedItem()));
            arrBookedSession.add(getTxtDate().getText());
            arrBookedSession.add(String.valueOf(getCmbDuration().getSelectedItem()));
            arrBookedSession.add(String.valueOf(getCmbPrice().getSelectedItem()));


            try {
                Scanner scCustomerInfo = new Scanner(new File("src/DataBase/UserInfo.txt"));
                while (scCustomerInfo.hasNextLine()) {
                    String strThisLine = scCustomerInfo.nextLine();
                    String[] arUserLine = strThisLine.split(",");

                    if (arrBookedSession.get(0).equals(arUserLine[0]) && arUserLine[5].equals("Customer")) {
                        customerExist = true;
                        break;
                    } else {
                        customerExist = false;
                    }
                }
                scCustomerInfo.close();
                Scanner scTrainerInfo = new Scanner(new File("src/DataBase/UserInfo.txt"));
                while (scTrainerInfo.hasNextLine()) {
                    String strThisLine = scTrainerInfo.nextLine();
                    String[] arUserLine = strThisLine.split(",");

                    if (arrBookedSession.get(1).equals(arUserLine[0]) && arUserLine[5].equals("Trainer")) {
                        trainerExist = true;
                        break;
                    } else {
                        trainerExist = false;
                    }
                }
                scTrainerInfo.close();

            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(null,
                        "There is no database to fetch the data from!", "Error",
                        JOptionPane.INFORMATION_MESSAGE);
            }


            if (arrBookedSession.get(0).equals("") || arrBookedSession.get(1).equals("") || arrBookedSession.get(3).equals("")){
                JOptionPane.showMessageDialog(null,
                        "Please fill in all the text fields!", "Error",
                        JOptionPane.INFORMATION_MESSAGE);
            } else if (!customerExist) {
                JOptionPane.showMessageDialog(null,
                        "This customer doesn't exists!", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }else if (!trainerExist) {
                JOptionPane.showMessageDialog(null,
                        "This trainer doesn't exists!", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    BufferedWriter bwUserInfo = new BufferedWriter(
                            new FileWriter("src/DataBase/BookedSessions.txt", true));

                    int iLastNumber = 1;
                    try {
                        Scanner scCustomerInfo = new Scanner(new File("src/DataBase/BookedSessions.txt"));
                        while (scCustomerInfo.hasNextLine()) {
                            String strThisLine = scCustomerInfo.nextLine();
                            String[] arUserLine = strThisLine.split(",");

                            iLastNumber = Integer.parseInt(arUserLine[0]) + 1;


                        }
                    } catch (FileNotFoundException e) {
                        JOptionPane.showMessageDialog(null,
                                "There is no database to fetch the data from!", "Error",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                    bwUserInfo.write(String.valueOf(iLastNumber) + ",");

                    int i;
                    for(i = 0; i < arrBookedSession.size() - 1; i++ ){
                        bwUserInfo.write(arrBookedSession.get(i) + ",");
                    }
                    bwUserInfo.write(arrBookedSession.get(i));
                    bwUserInfo.newLine();
                    bwUserInfo.close();

                    JOptionPane.showMessageDialog(null,
                            "This session has been booked", "Update",
                            JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}

