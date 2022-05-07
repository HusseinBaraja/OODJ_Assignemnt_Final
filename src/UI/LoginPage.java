package UI;

import javax.swing.*;
import java.awt.*;

public class LoginPage extends BaseFrame {
    private JPanel pnlLogoContainer;
    private JPanel pnlSettings;
    private JPanel pnlLogin;
    private JCheckBox cbKeepSignIn;
    public LoginPage(){
        setPnlLeftSide();
        setPnlRightSide();
        this.setVisible(true);
    }

    @Override
    public void setPnlLeftSide(){
        super.setPnlLeftSide();
        setPnlLogoContainer();
        this.getPnlLeftSide().add(getPnlLogoContainer(), BorderLayout.CENTER);
        setPnlSettings();
        this.getPnlLeftSide().add(getPnlSettings(), BorderLayout.SOUTH);
    }

    public void setPnlLogoContainer(){
        //Creating the Logo Container panel
        pnlLogoContainer = new JPanel();
        pnlLogoContainer.setOpaque(false);
        pnlLogoContainer.setLayout(new BorderLayout());

        //Importing the Logo image
        ImageIcon logoIcon = new ImageIcon("src/Resources/Dumbbell.png");

        //Creating the Label that Contains Both the Logo and the Logo image
        JLabel lblLogo = new JLabel("<html><center>APU Gym Centre<br>Management System</html>");//Using HTML to be able to go to the next line
        lblLogo.setForeground(new Color(0xFFFFFF));
        lblLogo.setFont(new Font("Bernard MT Condensed", Font.PLAIN,32));

        lblLogo.setIcon(logoIcon);//setting the logo inside the Logo label
        lblLogo.setHorizontalAlignment(JLabel.CENTER);//Centring the Logo label horizontally inside the logo container panel
        lblLogo.setVerticalAlignment(JLabel.CENTER);//Centring the Logo label vertically inside the logo container panel
        lblLogo.setHorizontalTextPosition(JLabel.CENTER);//positioning the name of the company in the center of the logo label
        lblLogo.setVerticalTextPosition(JLabel.BOTTOM);//positioning the name of the company at the bottom of the logo in the logo label
        pnlLogoContainer.add(lblLogo, BorderLayout.CENTER);//Adding the logo label to the logo container panel
    }
    public JPanel getPnlLogoContainer(){
        return pnlLogoContainer;
    }


    public void setPnlSettings(){
        //Creating the Settings panel
        pnlSettings = new JPanel();
        pnlSettings.setLayout(new FlowLayout(FlowLayout.LEFT));
        pnlSettings.setOpaque(false);
        pnlSettings.setPreferredSize(new Dimension(400,100));

        //Creating a top white divider
        pnlSettings.setBorder(BorderFactory.createMatteBorder(1,0,0,0,Color.white));


        //Creating the Settings button:
        //Selecting the image of the settings button from the project resources.
        ImageIcon imgSettings = new ImageIcon("src/Resources/settings.png");

        BaseButton btnSettings = new BaseButton("General Settings", 20, 0xFFFFFF, 300, 35);
        btnSettings.setIcon(imgSettings); //Adding the selected image to show in the button.
        btnSettings.setHorizontalAlignment(JButton.LEFT); //aligning the content of the label to the left.

        btnSettings.setImageOnEvent("src/Resources/settings.png",
                                    "src/Resources/lightGreenSettings.png",
                                    "src/Resources/greenSettings.png");

        //Add button to the Settings panel which is in the bottom of the sidebar
        pnlSettings.add(btnSettings);
    }
    public JPanel getPnlSettings(){
        return pnlSettings;
    }


    @Override
    public void setPnlRightSide(){
        super.setPnlRightSide();
        setPnlLogin();
        this.getPnlRightSide().add(getPnlLogin(), BorderLayout.CENTER);
    }

    public void setPnlLogin(){
        pnlLogin = new JPanel();
        pnlLogin.setLayout(new GridBagLayout());
        pnlLogin.setOpaque(false);


        JPanel pnlTitle = new JPanel();
        pnlTitle.setOpaque(false);
        pnlTitle.setPreferredSize(new Dimension(200,100));

        JLabel lblTitle = new JLabel("Login");
        lblTitle.setForeground(new Color(0xFFFFFF));
        lblTitle.setFont(new Font("Arial", Font.PLAIN, 64));
        lblTitle.setHorizontalAlignment(JLabel.CENTER);
        lblTitle.setVerticalAlignment(JLabel.CENTER);
        lblTitle.requestFocusInWindow(); //To move the Focus from the text field at the start of the program.
        pnlTitle.add(lblTitle);



        JPanel pnlUserName = new JPanel(new FlowLayout(FlowLayout.LEADING));
        pnlUserName.setOpaque(false);
        pnlUserName.setPreferredSize(new Dimension(750,100));

        JLabel lblUserName = new JLabel("Username or Email Address");
        lblUserName.setForeground(new Color(0xFFFFFF));
        lblUserName.setFont(new Font("Arial", Font.PLAIN, 20));

        BaseTextField txtUserName = new BaseTextField("Enter your Username or Email here", 24, 750,50);

        pnlUserName.add(lblUserName);
        pnlUserName.add(txtUserName);



        JPanel pnlPassword = new JPanel(new FlowLayout(FlowLayout.LEADING));
        pnlPassword.setOpaque(false);
        pnlPassword.setPreferredSize(new Dimension(750,100));

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setForeground(new Color(0xFFFFFF));
        lblPassword.setFont(new Font("Arial", Font.PLAIN, 24));

        BasePasswordField txtPassword = new BasePasswordField(24, 750,50);

        pnlPassword.add(lblPassword);
        pnlPassword.add(txtPassword);



        JPanel pnlKeepSignin = new JPanel(new FlowLayout(FlowLayout.LEADING));
        pnlKeepSignin.setOpaque(false);
        pnlKeepSignin.setPreferredSize(new Dimension(750,30));

        cbKeepSignIn = new JCheckBox("Keep me signed in");
        cbKeepSignIn.setFocusable(false);
        cbKeepSignIn.setFont(new Font("Arial", Font.PLAIN,16));
        cbKeepSignIn.setForeground(new Color(0xFFFFFF));
        cbKeepSignIn.setOpaque(false);
        pnlKeepSignin.add(cbKeepSignIn);


        JPanel pnlSignIn = new JPanel();
        pnlSignIn.setOpaque(false);
        pnlSignIn.setPreferredSize(new Dimension(750,100));

        //Creating the Settings button:
        BaseButton btnSignIn = new BaseButton("Sign in", 24, 0xFFFFFF, 400, 40);
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


        GridBagConstraints GBCLogin = new GridBagConstraints();

        GBCLogin.weightx = 0;
        GBCLogin.weighty = 0;
        GBCLogin.fill= GridBagConstraints.BOTH;


        GBCLogin.gridx = 0;
        GBCLogin.gridy = 0;
//        GBCLogin.gridwidth = 2;
        pnlLogin.add(pnlTitle, GBCLogin);

        GBCLogin.gridx = 0;
        GBCLogin.gridy = 2;
//        GBCLogin.gridwidth = 3;
        pnlLogin.add(pnlUserName, GBCLogin);

        GBCLogin.gridx = 0;
        GBCLogin.gridy = 4;
//        GBCLogin.gridwidth = 3;
        pnlLogin.add(pnlPassword, GBCLogin);

        GBCLogin.gridx = 0;
        GBCLogin.gridy = 5;
//        GBCLogin.gridwidth = 3;
        pnlLogin.add(pnlKeepSignin, GBCLogin);

        GBCLogin.gridx = 0;
        GBCLogin.gridy = 6;
//        GBCLogin.gridwidth = 3;
        pnlLogin.add(pnlSignIn, GBCLogin);
    }
    public JPanel getPnlLogin(){
        return pnlLogin;
    }

}