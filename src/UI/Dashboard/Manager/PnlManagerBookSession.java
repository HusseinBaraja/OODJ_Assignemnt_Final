package UI.Dashboard.Manager;

import UI.BaseComponents.*;

import javax.swing.*;
import java.awt.*;

public class PnlManagerBookSession extends BasePanel {
    public PnlManagerBookSession(boolean opaque) {
        super(opaque);
        setLayout(new GridBagLayout());
        BasePanel pnlTitle = new BasePanel(false, 750, 100);

        //Creating the label for the page title.
        BaseLabel lblTitle = new BaseLabel("Book Training Session", 54, "Arial", 0xFFFFFF);

        //Centring the title label horizontally and vertically inside title panel.
        lblTitle.setAlignment(JLabel.CENTER, JLabel.CENTER);

//        lblTitle.requestFocusInWindow(); //To move the Focus from the text field at the start of the program.
        pnlTitle.add(lblTitle); //Adding the title label to the title panel



        BasePanel pnlCustomerUN = new BasePanel(false,750,100);
        pnlCustomerUN.setLayout(new FlowLayout(FlowLayout.LEADING));

        //Creating the label for the Username field.
        BaseLabel lblCustomerUN = new BaseLabel("Customer Username", 24, "Arial", 0xFFFFFF);

        //Creating the text field for the Username.
        BaseTextField txtCustomerUN = new BaseTextField("", 24, 400,50);

        pnlCustomerUN.add(lblCustomerUN);
        pnlCustomerUN.add(txtCustomerUN);



        BasePanel pnlTrainerUN = new BasePanel(false,750,100);
        pnlTrainerUN.setLayout(new FlowLayout(FlowLayout.LEADING));

        BaseLabel lblTrainerUN = new BaseLabel("Trainer Username", 24, "Arial", 0xFFFFFF);

        BaseTextField txtTrainerUN = new BaseTextField("",24, 400,50);

        pnlTrainerUN.add(lblTrainerUN);
        pnlTrainerUN.add(txtTrainerUN);



        BasePanel pnlExerciseType = new BasePanel(false,750,100);
        pnlExerciseType.setLayout(new FlowLayout(FlowLayout.LEADING));

        BaseLabel lblExerciseType = new BaseLabel("Exercise Type", 24, "Arial", 0xFFFFFF);

        BaseTextField txtExerciseType = new BaseTextField("",24, 400,50);

        pnlExerciseType.add(lblExerciseType);
        pnlExerciseType.add(txtExerciseType);



        BasePanel pnlHallNo = new BasePanel(false,750,100);
        pnlHallNo.setLayout(new FlowLayout(FlowLayout.LEADING));

        BaseLabel lblHallNo = new BaseLabel("Hall No.", 24, "Arial", 0xFFFFFF);

        BaseTextField txtHallNo = new BaseTextField("",24, 400,50);

        pnlHallNo.add(lblHallNo);
        pnlHallNo.add(txtHallNo);

        

        BasePanel pnlDuration = new BasePanel(false,750,100);
        pnlDuration.setLayout(new FlowLayout(FlowLayout.LEADING));

        BaseLabel lblDuration = new BaseLabel("Duration", 24, "Arial", 0xFFFFFF);

        BaseTextField txtDuration = new BaseTextField("",24, 400,50);

        pnlDuration.add(lblDuration);
        pnlDuration.add(txtDuration);



        BasePanel pnlDateTime = new BasePanel(false,750,100);
        pnlDateTime.setLayout(new FlowLayout(FlowLayout.LEADING));

        BaseLabel lblDateTime = new BaseLabel("Date & Time", 24, "Arial", 0xFFFFFF);

        BaseTextField txtDateTime = new BaseTextField("",24, 400,50);

        pnlDateTime.add(lblDateTime);
        pnlDateTime.add(txtDateTime);



        BasePanel pnlPrice = new BasePanel(false,750,100);
        pnlPrice.setLayout(new FlowLayout(FlowLayout.LEADING));

        BaseLabel lblPrice = new BaseLabel("Price", 24, "Arial", 0xFFFFFF);

        BaseTextField txtPrice = new BaseTextField("",24, 400,50);

        pnlPrice.add(lblPrice);
        pnlPrice.add(txtPrice);



        BasePanel pnlBook = new BasePanel(false, 750, 100);

        //Creating the Settings button:
        BaseButton btnBook = new BaseButton("Sign in", 24, 0xFFFFFF, 400, 40);
        pnlBook.add(btnBook); //Adding the sign-in button to the sign-in panel which is in the bottom of the right side of the frame.




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

        BaseLabel[] loginLabels = new BaseLabel[7];
        loginLabels[0] = lblCustomerUN;
        loginLabels[1] = lblTrainerUN;
        loginLabels[2] = lblExerciseType;
        loginLabels[3] = lblHallNo;
        loginLabels[4] = lblDuration;
        loginLabels[5] = lblDateTime;
        loginLabels[6] = lblPrice;

        BaseTextField[] loginTextFields = new BaseTextField[7];
        loginTextFields[0] = txtCustomerUN;
        loginTextFields[1] = txtTrainerUN;
        loginTextFields[2] = txtExerciseType;
        loginTextFields[3] = txtHallNo;
        loginTextFields[4] = txtDuration;
        loginTextFields[5] = txtDateTime;
        loginTextFields[6] = txtPrice;

        GridBagConstraints GBCLogin = new GridBagConstraints();
//        GBCLogin.gridx = x;
//        GBCLogin.gridy = y;
        GBCLogin.weightx = 1;
        GBCLogin.weighty = 1;
        GBCLogin.fill= GridBagConstraints.HORIZONTAL;

        GBCLogin.gridx = 0;
        GBCLogin.gridy = 0;
        GBCLogin.gridwidth = 2;
        this.add(lblTitle, GBCLogin);

        for(int lblRows = 0; lblRows < loginLabels.length; lblRows++){
            GBCLogin.gridx = 0;
            GBCLogin.gridy = lblRows + 1;
            GBCLogin.gridwidth = 1;
            this.add(loginLabels[lblRows], GBCLogin);
        }
        for(int txtRows = 0; txtRows < loginLabels.length; txtRows++){
            GBCLogin.gridx = 1;
            GBCLogin.gridy = txtRows + 1;
            GBCLogin.gridwidth = 1;
            this.add(loginTextFields[txtRows], GBCLogin);
        }

        GBCLogin.gridx = 0;
        GBCLogin.gridy = 8;
        GBCLogin.gridwidth = 2;
        this.add(btnBook, GBCLogin);
    }


}
