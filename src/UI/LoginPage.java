package UI;

import UI.BaseComponents.*;

import javax.swing.*;
import java.awt.*;

public class LoginPage extends BaseFrame {
    private BasePanel pnlLogoContainer;
    private BasePanel pnlLogin;

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
        BaseLabel lblUserName = new BaseLabel("Username or Email Address");

        //Creating the text field for the Username.
        BaseTextField txtUserName = new BaseTextField("Enter your Username or Email here", 750,50);

        pnlUserName.add(lblUserName);
        pnlUserName.add(txtUserName);



        BasePanel pnlPassword = new BasePanel(false,750,100);
        pnlPassword.setLayout(new FlowLayout(FlowLayout.LEADING));

        BaseLabel lblPassword = new BaseLabel("Password");

        BasePasswordField txtPassword = new BasePasswordField(24, 750,50);

        pnlPassword.add(lblPassword);
        pnlPassword.add(txtPassword);



        BasePanel pnlKeepSignIn = new BasePanel(false, 750, 40);
        pnlKeepSignIn.setLayout(new FlowLayout(FlowLayout.LEADING));

        BaseCheckBox cbKeepSignIn = new BaseCheckBox("Keep me signed in");

        pnlKeepSignIn.add(cbKeepSignIn);


        BasePanel pnlSignIn = new BasePanel(false, 750, 100);

        //Creating the Settings button:
        BaseButton btnSignIn = new BaseButton("Sign in", 400, 40);
        pnlSignIn.add(btnSignIn); //Adding the sign-in button to the sign-in panel which is in the bottom of the right side of the frame.




        /* How to add change listener
        btnSignIn.addChangeListener(new ChangeListener()
        {
            public void stateChanged(ChangeEvent e) {
                ButtonModel model = btnSignIn.getModel();

                if (model.isPressed()) { btnSignIn.setForeground(Color.gray); }
                else { btnSignIn.setForeground(Color.white); }
            }
        });
        */


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
        /* GridBag Layout use
        GBCLogin.gridx = 0;
        GBCLogin.gridy = 0;
//        GBCLogin.gridwidth = 2;
        pnlLogin.add(pnlTitle, GBCLogin);

        GBCLogin.gridx = 0;
        GBCLogin.gridy = 1;
//        GBCLogin.gridwidth = 3;
        pnlLogin.add(pnlUserName, GBCLogin);

        GBCLogin.gridx = 0;
        GBCLogin.gridy = 2;
//        GBCLogin.gridwidth = 3;
        pnlLogin.add(pnlPassword, GBCLogin);

        GBCLogin.gridx = 0;
        GBCLogin.gridy = 3;
//        GBCLogin.gridwidth = 3;
        pnlLogin.add(pnlKeepSignIn, GBCLogin);

        GBCLogin.gridx = 0;
        GBCLogin.gridy = 4;
//        GBCLogin.gridwidth = 3;
        pnlLogin.add(pnlSignIn, GBCLogin);
         */
    }
    public JPanel getPnlLogin(){
        return pnlLogin;
    }

}