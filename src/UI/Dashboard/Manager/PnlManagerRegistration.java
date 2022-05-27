package UI.Dashboard.Manager;

import UI.BaseComponents.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class PnlManagerRegistration extends BasePanel {
    private final BaseTextField txtUN;
    private final BaseTextField txtName;
    private final BaseTextField txtEmail;
    private final BasePasswordField txtPassword;
    private final BaseTextField txtMobileNo;
    private final BaseComboBox cmbRole;
    private final BaseCheckBox cbShowPassword;
    public PnlManagerRegistration(boolean opaque) {
        super(opaque);
        setLayout(new GridBagLayout());

        BasePanel pnlTitle = new BasePanel(false);
        BaseLabel lblTitle = new BaseLabel("Manager registration", 40);
        pnlTitle.add(lblTitle); //Adding the title label to the title panel


        BasePanel pnlUN = new BasePanel(false);
        pnlUN.setLayout(new FlowLayout(FlowLayout.TRAILING));
        BaseLabel lblUN = new BaseLabel("Username:    ", 20);
        pnlUN.add(lblUN);


        //Creating the text field for the Username.
        txtUN = new BaseTextField(24, 400,40);



        BasePanel pnlName = new BasePanel(false);
        pnlName.setLayout(new FlowLayout(FlowLayout.TRAILING));
        BaseLabel lblName = new BaseLabel("Name:    ", 20);
        pnlName.add(lblName);


        txtName = new BaseTextField(24, 400,40);


        BasePanel pnlEmail = new BasePanel(false);
        pnlEmail.setLayout(new FlowLayout(FlowLayout.TRAILING));
        BaseLabel lblEmail = new BaseLabel("Email:    ", 20);
        pnlEmail.add(lblEmail);


        txtEmail = new BaseTextField(24, 400,40);



        BasePanel pnlPassword = new BasePanel(false);
        pnlPassword.setLayout(new FlowLayout(FlowLayout.TRAILING));
        BaseLabel lblPassword = new BaseLabel("Password:    ", 20);
        pnlPassword.add(lblPassword);


        txtPassword = new BasePasswordField(24, 400,40);



        BasePanel pnlMobileNo = new BasePanel(false);
        pnlMobileNo.setLayout(new FlowLayout(FlowLayout.TRAILING));
        BaseLabel lblMobileNo = new BaseLabel("Mobile Number:    ", 20);
        pnlMobileNo.add(lblMobileNo);


        txtMobileNo = new BaseTextField(24, 400,40);





        BasePanel pnlRole = new BasePanel(false);
        pnlRole.setLayout(new FlowLayout(FlowLayout.TRAILING));
        BaseLabel lblRole = new BaseLabel("Role:    ");
        pnlRole.add(lblRole);


        String[] strRole = {"Manager", "Trainer", "Customer"};
        cmbRole = new BaseComboBox(strRole, 20, 200, 40);
        cmbRole.setEditable(false);


        cbShowPassword = new BaseCheckBox("Show Password");
        cbShowPassword.addActionListener(e -> {
            if (PnlManagerRegistration.this.cbShowPassword.isSelected()){
                PnlManagerRegistration.this.txtPassword.setEchoChar((char) 0);
            }
            else{
                PnlManagerRegistration.this.txtPassword.setEchoChar(('*'));
            }

        });
        if(cbShowPassword.isSelected()){
            txtPassword.setEchoChar((char) 0);
        } else {
            txtPassword.setEchoChar('*');
        }



        BasePanel pnlRegister = new BasePanel(false);
        pnlRegister.setLayout(new FlowLayout(FlowLayout.RIGHT));

        //Creating the book button:
        BaseButton btnRegister = new BaseButton("Register", 200, 40);
        pnlRegister.add(btnRegister);



        Component[] loginLabels = new Component[6];
        loginLabels[0] = pnlUN;
        loginLabels[1] = pnlName;
        loginLabels[2] = pnlEmail;
        loginLabels[3] = pnlPassword;
        loginLabels[4] = pnlMobileNo;
        loginLabels[5] = pnlRole;

        Component[] loginTextFields = new Component[6];
        loginTextFields[0] = txtUN;
        loginTextFields[1] = txtName;
        loginTextFields[2] = txtEmail;
        loginTextFields[3] = txtPassword;
        loginTextFields[4] = txtMobileNo;
        loginTextFields[5] = cmbRole;

        GridBagConstraints GBCRegister = new GridBagConstraints();
        GBCRegister.weightx = 0.5;
        GBCRegister.weighty = 0.5;
        GBCRegister.fill= GridBagConstraints.HORIZONTAL;



        GBCRegister.gridx = 0;
        GBCRegister.gridy = 0;
        GBCRegister.gridwidth = 2;
        this.add(pnlTitle, GBCRegister);



        for(int lblRows = 0; lblRows < loginLabels.length; lblRows++){
            GBCRegister.gridx = 0;
            GBCRegister.gridy = lblRows + 1;
            GBCRegister.gridwidth = 1;
            this.add(loginLabels[lblRows], GBCRegister);
        }

        for(int txtRows = 0; txtRows < loginLabels.length; txtRows++){
            GBCRegister.gridx = 1;
            GBCRegister.gridy = txtRows + 1;
            GBCRegister.gridwidth = 1;
            this.add(loginTextFields[txtRows], GBCRegister);
        }

        GBCRegister.gridx = 1;
        GBCRegister.gridy = 7;
        GBCRegister.gridwidth = 1;
        this.add(cbShowPassword, GBCRegister);

        GBCRegister.gridx = 1;
        GBCRegister.gridy = 8;
        GBCRegister.gridwidth = 1;
        this.add(pnlRegister, GBCRegister);


        btnRegister.addActionListener(new PnlManagerRegistration.RegisterUser());
    }
    protected BaseTextField getTxtUN(){
        return txtUN;
    }
    protected BaseTextField getTxtName(){
        return txtName;
    }
    protected BaseTextField getTxtEmail(){
        return txtEmail;
    }
    protected BasePasswordField getTxtPassword(){
        return txtPassword;
    }
    protected BaseTextField getTxtMobileNo(){
        return txtMobileNo;
    }
    protected BaseComboBox getCmbRole(){
        return cmbRole;
    }


    public class RegisterUser implements ActionListener {
        boolean userExist = false;
        public void actionPerformed(ActionEvent event) {
            ArrayList<String> arrUserInfo = new ArrayList<>();
            arrUserInfo.add(getTxtUN().getText());
            arrUserInfo.add(getTxtName().getText());
            arrUserInfo.add(getTxtEmail().getText());
            arrUserInfo.add(String.valueOf(getTxtPassword().getPassword()));
            arrUserInfo.add(getTxtMobileNo().getText());
            arrUserInfo.add(String.valueOf(getCmbRole().getSelectedItem()));


            try {
                Scanner scUserInfo = new Scanner(new File("src/DataBase/UserInfo.txt"));
                while (scUserInfo.hasNextLine()) {
                    String strThisLine = scUserInfo.nextLine();
                    String[] arUserLine = strThisLine.split(",");

                    if (arrUserInfo.get(0).equals(arUserLine[0])) {
                        userExist = true;
                        break;
                    } else {
                        userExist = false;
                    }
                }
                scUserInfo.close();

            } catch (FileNotFoundException e) {
                try {
                    new BufferedWriter(new FileWriter("src/DataBase/UserInfo.txt", true));
                } catch (IOException ex) {
                    e.printStackTrace();
                }
            }


            ArrayList<String> errorList = new ArrayList<>();

            if (arrUserInfo.get(0).equals("") || arrUserInfo.get(1).equals("") || arrUserInfo.get(2).equals("") ||
                arrUserInfo.get(3).equals("") || arrUserInfo.get(4).equals("")){
                JOptionPane.showMessageDialog(null,
                        "Please fill in all the text fields!", "Error",
                        JOptionPane.INFORMATION_MESSAGE);
            } else if (userExist) {
                JOptionPane.showMessageDialog(null,
                        "This user already exists!", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else if (!(arrUserInfo.get(1).matches("^[ A-Za-z]+$"))) {
                JOptionPane.showMessageDialog(null,
                        "Name should only contain alphabet characters!", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else if (!arrUserInfo.get(2).contains("@") || !arrUserInfo.get(2).contains(".")) {
                JOptionPane.showMessageDialog(null,
                        "Please enter a valid email address!", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else if (!arrUserInfo.get(4).matches("^\\d{10}$")) {
                JOptionPane.showMessageDialog(null,
                        "Please enter a valid Mobile number made of 10 numeric characters!", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else if (!isPassValid(arrUserInfo.get(3), errorList)){
                String strPasswordErrors = "";
                for (String error : errorList) {
                    strPasswordErrors += error +"\n";
                }
                JOptionPane.showMessageDialog(null,
                        "This password is not valid\n" + strPasswordErrors, "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    BufferedWriter bwUserInfo = new BufferedWriter(
                            new FileWriter("src/DataBase/UserInfo.txt", true));
                    int i;
                    for(i = 0; i < arrUserInfo.size() - 1; i++ ){
                        bwUserInfo.write(arrUserInfo.get(i) + ",");
                    }
                    bwUserInfo.write(arrUserInfo.get(i));
                    bwUserInfo.newLine();
                    bwUserInfo.close();


                    //writing to the login record to be able to log in later
                    BufferedWriter bwLoginInfo = new BufferedWriter(
                            new FileWriter("src/DataBase/LoginInfo.txt", true));
                    bwLoginInfo.write(arrUserInfo.get(0) + "," +
                                            arrUserInfo.get(3) + "," +
                                            arrUserInfo.get(5));
                    bwLoginInfo.newLine();
                    bwLoginInfo.close();

                    JOptionPane.showMessageDialog(null,
                            "User has been registered!", "Update",
                            JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        public boolean isPassValid(String strUserPassword, ArrayList<String> errorList) {

            Pattern patSpecialChar = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
            Pattern ptnUpperCase = Pattern.compile("[A-Z ]");
            Pattern ptnLowerCase = Pattern.compile("[a-z ]");
            Pattern ptnDigitCase = Pattern.compile("[0-9 ]");
            errorList.clear();

            boolean passValid=true;

            if (strUserPassword.length() < 8) {
                errorList.add("Password length must be at least 8 characters long!");
                passValid=false;
            }
            if (!patSpecialChar.matcher(strUserPassword).find()) {
                errorList.add("Password must contain at least one special character!");
                passValid=false;
            }
            if (!ptnUpperCase.matcher(strUserPassword).find()) {
                errorList.add("Password must contain at least one uppercase character!");
                passValid=false;
            }
            if (!ptnLowerCase.matcher(strUserPassword).find()) {
                errorList.add("Password must contain at least one lowercase character!");
                passValid=false;
            }
            if (!ptnDigitCase.matcher(strUserPassword).find()) {
                errorList.add("Password must contain at least one digit character!");
                passValid=false;
            }
            return passValid;
        }
    }
}
