package UI.Dashboard.Manager;

import UI.BaseComponents.*;

import javax.swing.*;
import java.awt.*;

public class PnlManagerRegistration extends BasePanel {
    public PnlManagerRegistration(boolean opaque) {
        super(opaque);
        setLayout(new GridBagLayout());

        BasePanel pnlTitle = new BasePanel(false);
        BaseLabel lblTitle = new BaseLabel("Manager registration", 40);
        pnlTitle.add(lblTitle); //Adding the title label to the title panel


        BasePanel pnlUN = new BasePanel(false);
        pnlUN.setLayout(new FlowLayout(FlowLayout.TRAILING));
        BaseLabel lblUN = new BaseLabel("Customer Username:    ", 20);
        pnlUN.add(lblUN);


        ///Creating the text field for the Username.
        BaseTextField txtUN = new BaseTextField(24, 400,40);



        BasePanel pnlFullName = new BasePanel(false);
        pnlFullName.setLayout(new FlowLayout(FlowLayout.TRAILING));
        BaseLabel lblFullName = new BaseLabel("Full name:    ", 20);
        pnlFullName.add(lblFullName);


        BaseTextField txtFullName = new BaseTextField(24, 400,40);


        BasePanel pnlPassword = new BasePanel(false);
        pnlPassword.setLayout(new FlowLayout(FlowLayout.TRAILING));
        BaseLabel lblPassword = new BaseLabel("Password:    ", 20);
        pnlPassword.add(lblPassword);


        BaseTextField txtPassword = new BaseTextField(24, 400,40);



        BasePanel pnlConfirmPassword = new BasePanel(false);
        pnlConfirmPassword.setLayout(new FlowLayout(FlowLayout.TRAILING));
        BaseLabel lblHallNo = new BaseLabel("Confirm Password:    ", 20);
        pnlConfirmPassword.add(lblHallNo);


        BaseTextField txtConfirmPassword = new BaseTextField(24, 400,40);



        BasePanel pnlMobileNo = new BasePanel(false);
        pnlMobileNo.setLayout(new FlowLayout(FlowLayout.TRAILING));
        BaseLabel lblDuration = new BaseLabel("Mobile Number:    ", 20);
        pnlMobileNo.add(lblDuration);


        BaseTextField txtMobileNo = new BaseTextField(24, 400,40);


        BasePanel pnlDateTime = new BasePanel(false);
        pnlDateTime.setLayout(new FlowLayout(FlowLayout.TRAILING));
        BaseLabel lblDateTime = new BaseLabel("D.O.B:    ", 20);
        pnlDateTime.add(lblDateTime);


        BaseTextField txtDateTime = new BaseTextField("DD/MM/YYYY",20, 400,40);



        BasePanel pnlGender = new BasePanel(false);
        pnlGender.setLayout(new FlowLayout(FlowLayout.TRAILING));
        BaseLabel lblGender = new BaseLabel("Price:    ", 20);
        pnlGender.add(lblGender);


        String[] strGender = {"Male", "Female"};
        BaseComboBox cmbGender = new BaseComboBox(strGender, 20, 200, 40);



        BasePanel pnlRole = new BasePanel(false);
        pnlRole.setLayout(new FlowLayout(FlowLayout.TRAILING));
        BaseLabel lblRole = new BaseLabel("Role:    ");
        pnlRole.add(lblRole);


        String[] strRole = {"Manager", "Trainer", "Customer"};
        BaseComboBox cmbRole = new BaseComboBox(strRole, 20, 200, 40);

        BasePanel pnlRegister = new BasePanel(false);
        pnlRegister.setLayout(new FlowLayout(FlowLayout.RIGHT));

        //Creating the book button:
        BaseButton btnBook = new BaseButton("Register", 200, 40);
        pnlRegister.add(btnBook);

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

        Component[] loginLabels = new Component[8];
        loginLabels[0] = pnlUN;
        loginLabels[1] = pnlFullName;
        loginLabels[2] = pnlPassword;
        loginLabels[3] = pnlConfirmPassword;
        loginLabels[4] = pnlMobileNo;
        loginLabels[5] = pnlDateTime;
        loginLabels[6] = pnlGender;
        loginLabels[7] = pnlRole;

        Component[] loginTextFields = new Component[8];
        loginTextFields[0] = txtUN;
        loginTextFields[1] = txtFullName;
        loginTextFields[2] = txtPassword;
        loginTextFields[3] = txtConfirmPassword;
        loginTextFields[4] = txtMobileNo;
        loginTextFields[5] = txtDateTime;
        loginTextFields[6] = cmbGender;
        loginTextFields[7] = cmbRole;

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
        GBCBookSession.gridy = 10;
        GBCBookSession.gridwidth = 2;
        this.add(pnlRegister, GBCBookSession);
    }
}
