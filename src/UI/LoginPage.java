package UI;

import javax.swing.*;
import java.awt.*;

public class LoginPage extends BaseFrame {
    private JPanel pnlLogoContainer;
    private JLabel lblLogo;

    public LoginPage(){
        setPnlLeftSide();

        this.setVisible(true);
    }
    public void setPnlLeftSide(){
        super.setPnlLeftSide();
        setPnlLogoContainer();
        this.getPnlLeftSide().add(getPnlLogoContainer(), BorderLayout.CENTER);
    }

    public void setPnlLogoContainer(){
        //Creating the Logo Container panel
        pnlLogoContainer = new JPanel();
        pnlLogoContainer.setBackground(new Color(0x1E2022));
        pnlLogoContainer.setLayout(new BorderLayout());

        //Importing the Logo image
        ImageIcon logoIcon = new ImageIcon("src/Resources/Dumbbell.png");

        //Creating the Label that Contains Both the Logo and the Logo image
        lblLogo = new JLabel("<html><center>APU Gym Centre<br>Management System</html>");//Using HTML to be able to go to the next line
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
}