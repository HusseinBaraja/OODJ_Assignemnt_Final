package UI;

import Model.LoginModel;
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
    private BaseLabel lblTitle;
    private BaseTextField txtUserName;
    private BasePasswordField txtPassword;
    private BaseCheckBox cbKeepSignIn;
    private BaseButton btnSignIn;


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
        lblTitle = new BaseLabel("Login", 64);

        //Centring the title label horizontally and vertically inside title panel.
        lblTitle.setAlignment(JLabel.CENTER, JLabel.CENTER);

//        lblTitle.requestFocusInWindow(); //To move the Focus from the text field at the start of the program.
        pnlTitle.add(lblTitle); //Adding the title label to the title panel



        BasePanel pnlUserName = new BasePanel(false,750,100);
        pnlUserName.setLayout(new FlowLayout(FlowLayout.LEADING));

        //Creating the label for the Username field.
        BaseLabel lblUserName = new BaseLabel("Username or Email Address");

        //Creating the text field for the Username.
        txtUserName = new BaseTextField("Enter your Username or Email here", 750,50);

        pnlUserName.add(lblUserName);
        pnlUserName.add(txtUserName);



        BasePanel pnlPassword = new BasePanel(false,750,100);
        pnlPassword.setLayout(new FlowLayout(FlowLayout.LEADING));

        BaseLabel lblPassword = new BaseLabel("Password");

        txtPassword = new BasePasswordField(24, 750,50);

        pnlPassword.add(lblPassword);
        pnlPassword.add(txtPassword);



        BasePanel pnlKeepSignIn = new BasePanel(false, 750, 40);
        pnlKeepSignIn.setLayout(new FlowLayout(FlowLayout.LEADING));

        cbKeepSignIn = new BaseCheckBox("Keep me signed in");

        pnlKeepSignIn.add(cbKeepSignIn);


        BasePanel pnlSignIn = new BasePanel(false, 750, 100);

        //Creating the Settings button:
        btnSignIn = new BaseButton("Sign in", 400, 40);
        pnlSignIn.add(btnSignIn); //Adding the sign-in button to the sign-in panel which is in the bottom of the right side of the frame.




        BasePanel[] loginPanels = new BasePanel[5];
        loginPanels[0] = pnlTitle;
        loginPanels[1] = pnlUserName;
        loginPanels[2] = pnlPassword;
        loginPanels[3] = pnlKeepSignIn;
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
        ActionListener loginListener = new ClickListener1();
        btnSignIn.addActionListener(loginListener);

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

    public void ApplyActionListener(){
        ActionListener loginListener = new ClickListener1();
        btnSignIn.addActionListener(loginListener);
    }
    public class ClickListener1 implements ActionListener {
        boolean foundPassword;
        public void actionPerformed(ActionEvent event) {
            //File inputFile = new File("src/DataBase/LoginRecord");

            String userNameInput = txtUserName.getText();
            String passwordInput = String.valueOf(txtPassword.getPassword());
            foundPassword = false;

            try {
                Scanner in = new Scanner(new File("src/DataBase/LoginRecord"));
                if(!foundPassword){
                    while (in.hasNextLine()) {
                        String s = in.nextLine();
                        String[] sArray = s.split(",");

                        System.out.println(sArray[0]); //Just to verify that file is being read
                        System.out.println(sArray[1]);
                        System.out.println(sArray[2]);


                        if (userNameInput.equals(sArray[0]) && passwordInput.equals(sArray[1])) {
                            JOptionPane.showMessageDialog(null,
                                    "Welcome back " + sArray[0] , "Success",
                                    JOptionPane.INFORMATION_MESSAGE);
                            switch (sArray[2]) {
                                case "Manager" -> new BaseManagerDashboard();
                                case "Trainer" -> new BaseTrainerDashboard();
                                case "Customer" -> new BaseFrame();
                            }
                            foundPassword = true;
                        }
                    }
                }else {
                    JOptionPane.showMessageDialog(null,
                            "Invalid Username / Password Combo", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }

                in.close();

            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(null,
                        "User Database Not Found", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}