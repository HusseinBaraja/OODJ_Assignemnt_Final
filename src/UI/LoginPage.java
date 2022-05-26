package UI;

import UI.BaseComponents.*;
import UI.Dashboard.Manager.BaseManagerDashboard;
import UI.Dashboard.Trainer.BaseTrainerDashboard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoginPage extends BaseFrame {
    private BasePanel pnlLogoContainer;
    private BasePanel pnlLogin;
    private BaseTextField txtUserName;
    private BasePasswordField txtPassword;
    private BaseCheckBox cbShowPassword;


    public LoginPage(){
        this.setTitle("Login");
    }

    @Override
    public void setPnlLeftSide(){
        super.setPnlLeftSide();
        super.getPnlLeftSide().setPreferredSize(new Dimension(400, 720));
        setPnlLogoContainer();
        this.getPnlLeftSide().add(getPnlLogoContainer(), BorderLayout.CENTER);
    }

    public void setPnlLogoContainer(){
        //Creating the Logo Container panel
        pnlLogoContainer = new BasePanel(false);
        pnlLogoContainer.setLayout(new BorderLayout());

        //Creating the Label that Contains Both the Logo and the Logo image. By using HTML the label can go to the next line.
        BaseLabel lblLogo = new BaseLabel("<html><center>APU Gym Centre<br>Management System</html>",
                                            32,"Bernard MT Condensed");

        lblLogo.setImage("src/Resources/Logo.png"); //setting the logo image inside the label.

        //Centring the Logo label horizontally and vertically inside the logo container panel.
        lblLogo.setAlignment(JLabel.CENTER, JLabel.CENTER);

        //positioning the name of the company in the center bottom of the logo label
        lblLogo.setTextPosition(JLabel.CENTER,JLabel.BOTTOM);

        pnlLogoContainer.add(lblLogo, BorderLayout.CENTER); //Adding the logo label to the logo container panel

    }
    public JPanel getPnlLogoContainer(){
        return pnlLogoContainer;
    }

    @Override
    public void setPnlRightSide(){
        super.setPnlRightSide();
        setPnlLogin();
        this.getPnlRightSide().add(getPnlLogin(), BorderLayout.CENTER);
    }

    public void setPnlLogin(){
        pnlLogin = new BasePanel(false);
        pnlLogin.setLayout(new GridBagLayout());


        BasePanel pnlTitle = new BasePanel(false, 200, 100);

        //Creating the label for the page title.
        BaseLabel lblTitle = new BaseLabel("Login", 64);

        //Centring the title label horizontally and vertically inside title panel.
        lblTitle.setAlignment(JLabel.CENTER, JLabel.CENTER);

//        lblTitle.requestFocusInWindow(); //To move the Focus from the text field at the start of the program.
        pnlTitle.add(lblTitle); //Adding the title label to the title panel



        BasePanel pnlUserName = new BasePanel(false,750,100);
        pnlUserName.setLayout(new FlowLayout(FlowLayout.LEADING));

        //Creating the label for the Username field.
        BaseLabel lblUserName = new BaseLabel("Username");

        //Creating the text field for the Username.
        txtUserName = new BaseTextField("Enter your Username here", 750,50);

        pnlUserName.add(lblUserName);
        pnlUserName.add(txtUserName);



        BasePanel pnlPassword = new BasePanel(false,750,100);
        pnlPassword.setLayout(new FlowLayout(FlowLayout.LEADING));

        BaseLabel lblPassword = new BaseLabel("Password");

        txtPassword = new BasePasswordField(24, 750,50);

        pnlPassword.add(lblPassword);
        pnlPassword.add(txtPassword);



        BasePanel pnlShowPassword = new BasePanel(false, 750, 40);
        pnlShowPassword.setLayout(new FlowLayout(FlowLayout.LEADING));

        cbShowPassword = new BaseCheckBox("Show Password");
        cbShowPassword.addActionListener(e -> {
            if (LoginPage.this.cbShowPassword.isSelected()){
                LoginPage.this.txtPassword.setEchoChar((char) 0);
            }
            else{
                LoginPage.this.txtPassword.setEchoChar(('*'));
            }

        });
        if(cbShowPassword.isSelected()){
            txtPassword.setEchoChar((char) 0);
        } else {
            txtPassword.setEchoChar('*');
        }

        pnlShowPassword.add(cbShowPassword);


        BasePanel pnlSignIn = new BasePanel(false, 750, 100);

        //Creating the Login button:
        BaseButton btnSignIn = new BaseButton("Log in", 400, 40);

        pnlSignIn.add(btnSignIn); //Adding the sign-in button to the sign-in panel which is in the bottom of the right side of the frame.




        BasePanel[] loginPanels = new BasePanel[5];
        loginPanels[0] = pnlTitle;
        loginPanels[1] = pnlUserName;
        loginPanels[2] = pnlPassword;
        loginPanels[3] = pnlShowPassword;
        loginPanels[4] = pnlSignIn;

        GridBagConstraints GBCLogin = new GridBagConstraints();

        GBCLogin.weightx = 0;
        GBCLogin.weighty = 0;
        GBCLogin.fill= GridBagConstraints.BOTH;


        for(int rows = 0; rows < loginPanels.length; rows++){
            GBCLogin.gridx = 0;
            GBCLogin.gridy = rows;
            pnlLogin.add(loginPanels[rows], GBCLogin);
        }
        btnSignIn.addActionListener(new LoginListener());

    }
    public JPanel getPnlLogin(){
        return pnlLogin;
    }

    public BaseTextField getTxtUserName(){
        return txtUserName;
    }
    public BasePasswordField getTxtPassword(){
        return txtPassword;
    }

    public class LoginListener implements ActionListener {
        boolean foundPassword;
        public void actionPerformed(ActionEvent event) {
            String strInputUserName = getTxtUserName().getText();
            String strInputPassword = String.valueOf(getTxtPassword().getPassword());
            foundPassword = false;

            try {
                Scanner scUserRecords = new Scanner(new File("src/DataBase/LoginRecord.txt"));
                while (scUserRecords.hasNextLine()) {
                    String strThisLine = scUserRecords.nextLine();
                    String[] arUserLine = strThisLine.split(",");

                    if (strInputUserName.equals(arUserLine[0]) && strInputPassword.equals(arUserLine[1])) {
                        JOptionPane.showMessageDialog(null,
                                "Welcome back " + arUserLine[0] , "Login Successful",
                                JOptionPane.INFORMATION_MESSAGE);
                        switch (arUserLine[2]) {
                            case "Manager" -> new BaseManagerDashboard();
                            case "Trainer" -> new BaseTrainerDashboard();
                            case "Customer" -> new BaseFrame();
                        }
                        LoginPage.this.dispose();
                        foundPassword = true;
                        break;
                    }
                }
                if (!foundPassword){
                    JOptionPane.showMessageDialog(null,
                            "Incorrect Username / Password", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }

                scUserRecords.close();

            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(null,
                        "User Database Not Found", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}