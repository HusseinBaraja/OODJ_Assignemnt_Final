package UI.Dashboard.Manager;

import UI.BaseComponents.*;

import javax.swing.*;
import java.awt.*;

public class PnlManagerRegistration extends BasePanel {
    public PnlManagerRegistration(boolean opaque) {
        super(opaque);
        setLayout(new GridBagLayout());

        BasePanel pnlTitle = new BasePanel(false);
        BaseLabel lblTitle = new BaseLabel("REG EDIT", 54);
        pnlTitle.add(lblTitle); //Adding the title label to the title panel



        BasePanel pnlCustomerUN = new BasePanel(false);
        pnlCustomerUN.setLayout(new FlowLayout(FlowLayout.TRAILING));
        BaseLabel lblCustomerUN = new BaseLabel("Customer Username:    ");
        pnlCustomerUN.add(lblCustomerUN);


        String[] petStrings = { "Bird", "Cat", "Dog", "Rabbit", "Pig","Dog2" };
        BaseComboBox cmbCustomerUN = new BaseComboBox(petStrings, 400, 50);

        //Creating the text field for the Username.
        BaseTextField txtCustomerUN = new BaseTextField(24, 400,50);



        BasePanel pnlTrainerUN = new BasePanel(false);
        pnlTrainerUN.setLayout(new FlowLayout(FlowLayout.TRAILING));
        BaseLabel lblTrainerUN = new BaseLabel("Trainer Username:    ");
        pnlTrainerUN.add(lblTrainerUN);


        BaseTextField txtTrainerUN = new BaseTextField(24, 400,50);



        BasePanel pnlExerciseType = new BasePanel(false);
        pnlExerciseType.setLayout(new FlowLayout(FlowLayout.TRAILING));
        BaseLabel lblExerciseType = new BaseLabel("Exercise Type:    ");
        pnlExerciseType.add(lblExerciseType);


        BaseTextField txtExerciseType = new BaseTextField(24, 400,50);



        BasePanel pnlHallNo = new BasePanel(false);
        pnlHallNo.setLayout(new FlowLayout(FlowLayout.TRAILING));
        BaseLabel lblHallNo = new BaseLabel("Hall No:    ");
        pnlHallNo.add(lblHallNo);


        BaseTextField txtHallNo = new BaseTextField(24, 400,50);



        BasePanel pnlDuration = new BasePanel(false);
        pnlDuration.setLayout(new FlowLayout(FlowLayout.TRAILING));
        BaseLabel lblDuration = new BaseLabel("Duration:    ");
        pnlDuration.add(lblDuration);


        BaseTextField txtDuration = new BaseTextField(24, 400,50);



        BasePanel pnlDateTime = new BasePanel(false);
        pnlDateTime.setLayout(new FlowLayout(FlowLayout.TRAILING));
        BaseLabel lblDateTime = new BaseLabel("Date & Time:    ");
        pnlDateTime.add(lblDateTime);


        BaseTextField txtDateTime = new BaseTextField(24, 400,50);



        BasePanel pnlPrice = new BasePanel(false);
        pnlPrice.setLayout(new FlowLayout(FlowLayout.TRAILING));
        BaseLabel lblPrice = new BaseLabel("Price:    ");
        pnlPrice.add(lblPrice);


        String[] PriceOptions = {"100 RM","250 RM", "500 RM"};
        BaseComboBox cmbPrice = new BaseComboBox(PriceOptions, 200, 50);

        BaseTextField txtPrice = new BaseTextField(24, 400,50);



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

        Component[] loginLabels = new Component[7];
        loginLabels[0] = pnlCustomerUN;
        loginLabels[1] = pnlTrainerUN;
        loginLabels[2] = pnlExerciseType;
        loginLabels[3] = pnlHallNo;
        loginLabels[4] = pnlDuration;
        loginLabels[5] = pnlDateTime;
        loginLabels[6] = pnlPrice;

        Component[] loginTextFields = new Component[7];
        loginTextFields[0] = cmbCustomerUN;
        loginTextFields[1] = txtTrainerUN;
        loginTextFields[2] = txtExerciseType;
        loginTextFields[3] = txtHallNo;
        loginTextFields[4] = txtDuration;
        loginTextFields[5] = txtDateTime;
        loginTextFields[6] = cmbPrice;

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
    }
}
