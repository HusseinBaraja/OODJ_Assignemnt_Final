package UI;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;


public class BaseFrame extends JFrame {
    private JPanel pnlLeftSide;
    private JPanel pnlRightSide;
    private JPanel pnlLogoContainer;
    private JLabel lblLogo;
    private JPanel pnlSettings;
    private JPanel pnlLogin;


    public BaseFrame(){
        this.setTitle("Login");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280,720);
        this.setResizable(true);


        this.add(getPnlLeftSide(), BorderLayout.WEST);
        this.add(getPnlRightSide(), BorderLayout.CENTER);
        this.setVisible(true);
    }


    public JPanel getPnlLeftSide(){
        pnlLeftSide = new JPanel();
        pnlLeftSide.setBackground(new Color(0x1E2022));
        pnlLeftSide.setPreferredSize(new Dimension(400,720));
        pnlLeftSide.setLayout(new BorderLayout());
        pnlLeftSide.setBorder(BorderFactory.createMatteBorder(0,0,0,1,Color.white));


        pnlLeftSide.add(getPnlSettings(), BorderLayout.SOUTH);
        pnlLeftSide.add(getPnlLogoContainer(), BorderLayout.CENTER);
        return pnlLeftSide;
    }
    public JPanel getPnlLogoContainer(){
        pnlLogoContainer = new JPanel();
        pnlLogoContainer.setBackground(new Color(0x1E2022));
        pnlLogoContainer.setLayout(new BorderLayout());
        //logoContainer.setBounds(0,0,200,200);

        ImageIcon logoIcon = new ImageIcon("src/Resources/Dumbbell.png");
        lblLogo = new JLabel("<html><center>APU Gym Centre<br>Management System</html>");
        lblLogo.setForeground(new Color(0xFFFFFF));
        lblLogo.setFont(new Font("Bernard MT Condensed", Font.PLAIN,32));

        lblLogo.setIcon(logoIcon);
        lblLogo.setHorizontalAlignment(JLabel.CENTER);
        lblLogo.setVerticalAlignment(JLabel.CENTER);
        lblLogo.setHorizontalTextPosition(JLabel.CENTER);
        lblLogo.setVerticalTextPosition(JLabel.BOTTOM);
        pnlLogoContainer.add(lblLogo, BorderLayout.CENTER);

        return pnlLogoContainer;
    }
    public JPanel getPnlSettings(){
        //Creating the Settings panel
        pnlSettings = new JPanel();
        pnlSettings.setLayout(new FlowLayout(FlowLayout.LEFT));
        pnlSettings.setBackground((new Color(0x1E2022)));
        pnlSettings.setPreferredSize(new Dimension(400,100));

        //Creating a top white divider
        pnlSettings.setBorder(BorderFactory.createMatteBorder(1,0,0,0,Color.white));


        //Creating the Settings button:
            //Selecting the image of the Settings button
            ImageIcon imgSettings = new ImageIcon("src/Resources/settings.png");

            JButton btnSettings = new JButton("General Settings");
            btnSettings.setFont(new Font("Roboto", Font.PLAIN,20)); //changing Font settings of the button.

            btnSettings.setForeground(Color.white); //changing the button's text color to white.

            btnSettings.setPreferredSize(new Dimension(300,35)); //Changing the size of the button.

            btnSettings.setFocusable(false); //removing the annoying focus highlight around the button.

            btnSettings.setIcon(imgSettings); //Adding the selected image to show in the button.

            btnSettings.setHorizontalAlignment(JButton.LEFT); //aligning the content of the label to the left.

            //Remove Button Border
            btnSettings.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
            btnSettings.setBackground(new Color(0xFFFFFF));
            btnSettings.setContentAreaFilled(false);

            btnSettings.setBorder(new RoundedBorder(10));
            btnSettings.addChangeListener(new ChangeListener()
            {
                public void stateChanged(ChangeEvent e)
                {
                    ButtonModel model = btnSettings.getModel();
                    if (model.isPressed())
                    {
                        btnSettings.setForeground(Color.gray);
                        btnSettings.setIcon(new ImageIcon("src/Resources/graySettings.png"));
                    }
                    else
                    {
                        btnSettings.setForeground(Color.white);
                        btnSettings.setIcon(new ImageIcon("src/Resources/settings.png"));
                    }
                }
            });

        //Add button to the Settings panel which is in the bottom of the sidebar
        pnlSettings.add(btnSettings);

        return pnlSettings;
    }


    public JPanel getPnlRightSide(){
        pnlRightSide = new JPanel();
        pnlRightSide.setBackground(new Color(0x2B2E31));
        pnlRightSide.setLayout(new BorderLayout());

        pnlRightSide.add(getPnlLogin(), BorderLayout.CENTER);
        return pnlRightSide;
    }
    public JPanel getPnlLogin(){
        pnlLogin = new JPanel();
        pnlLogin.setLayout(new GridBagLayout());
        pnlLogin.setBackground(new Color(0x2B2E31));

        GridBagConstraints GBCLogin = new GridBagConstraints();
        GBCLogin.weightx = 0;
        GBCLogin.weighty = 0;
        GBCLogin.fill= GridBagConstraints.HORIZONTAL;


        JPanel pnlTitle = new JPanel();
        pnlTitle.setBackground(new Color(0x2B2E31));
        pnlTitle.setPreferredSize(new Dimension(200,100));
        GBCLogin.gridx = 0;
        GBCLogin.gridy = 0;
        GBCLogin.gridwidth = 2;

        JLabel lblTitle = new JLabel("Login");
        lblTitle.setForeground(new Color(0xFFFFFF));
        lblTitle.setFont(new Font("Arial", Font.PLAIN, 64));
        lblTitle.setHorizontalAlignment(JLabel.CENTER);
        lblTitle.setVerticalAlignment(JLabel.CENTER);
        pnlTitle.add(lblTitle);

        pnlLogin.add(pnlTitle, GBCLogin);



        JPanel pnlUserName = new JPanel(new FlowLayout(FlowLayout.LEADING));
        pnlUserName.setBackground(new Color(0x2B2E31));
        pnlUserName.setPreferredSize(new Dimension(750,100));
        GBCLogin.gridx = 0;
        GBCLogin.gridy = 1;
        GBCLogin.gridwidth = 3;

        JLabel lblUserName = new JLabel("Username or Email Address");
        lblUserName.setForeground(new Color(0xFFFFFF));
        lblUserName.setFont(new Font("Arial", Font.PLAIN, 20));



        JTextField txtUserName = new JTextField();
        txtUserName.setPreferredSize(new Dimension(750,50));
        txtUserName.setForeground(new Color(0xFFFFFF));
        txtUserName.setFont(new Font("Arial", Font.PLAIN, 20));
        pnlUserName.add(lblUserName);
        pnlUserName.add(txtUserName);

        pnlLogin.add(pnlUserName, GBCLogin);


        JPanel pnlPassword = new JPanel(new FlowLayout(FlowLayout.LEADING));
        pnlPassword.setBackground(new Color(0x2B2E31));
        pnlPassword.setPreferredSize(new Dimension(750,100));
        GBCLogin.gridx = 0;
        GBCLogin.gridy = 2;
        GBCLogin.gridwidth = 3;


        JLabel lblPassword = new JLabel("Password");
        lblPassword.setForeground(new Color(0xFFFFFF));
        lblPassword.setFont(new Font("Arial", Font.PLAIN, 20));

        JTextField txtPassword = new JTextField();
        txtPassword.setPreferredSize(new Dimension(750,50));
        txtPassword.setForeground(new Color(0xFFFFFF));
        txtPassword.setFont(new Font("Arial", Font.PLAIN, 20));
        pnlPassword.add(lblUserName);
        pnlPassword.add(txtUserName);

        pnlLogin.add(pnlPassword, GBCLogin);




        return pnlLogin;
    }



}
