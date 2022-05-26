package Model;

import UI.BaseFrame;
import UI.Dashboard.Manager.BaseManagerDashboard;
import UI.Dashboard.Trainer.BaseTrainerDashboard;
import UI.LoginPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

public class LoginModel{
//    String strUserName;
//    String strPassword;
//    public void AllowLogin(String strUserName, String strPassword){
//        this.strUserName = strUserName;
//        this.strPassword = strPassword;
//    }

//    public void actionPerformed(ActionEvent event) {
//        //File inputFile = new File("src/DataBase/LoginRecord");
//
//        String userNameInput = strUserName;
//        String passwordInput = strPassword;
//
//        try {
//            Scanner in = new Scanner(new File("src/DataBase/LoginRecord"));
//            while (in.hasNextLine()) {
//                String s = in.nextLine();
//                String[] sArray = s.split(",");
//
//                System.out.println(sArray[0]); //Just to verify that file is being read
//                System.out.println(sArray[1]);
//                System.out.println(sArray[2]);
//
//
//                if (userNameInput.equals(sArray[0]) && passwordInput.equals(sArray[1])) {
//                    JOptionPane.showMessageDialog(null,
//                            "Welcome back " + sArray[0] , "Success",
//                            JOptionPane.INFORMATION_MESSAGE);
//                    switch (sArray[2]){
//                        case "Manager":
//                            new BaseManagerDashboard();
//                            break;
//                        case "Trainer":
//                            new BaseTrainerDashboard();
//                            break;
//                        case "Customer":
//                            new BaseFrame();
//                            break;
//                    }
//
//                } else {
//                    JOptionPane.showMessageDialog(null,
//                            "Invalid Username / Password Combo", "Error",
//                            JOptionPane.ERROR_MESSAGE);
//                }
//            }
//
//            in.close();
//
//        } catch (FileNotFoundException e) {
//            JOptionPane.showMessageDialog(null,
//                    "User Database Not Found", "Error",
//                    JOptionPane.ERROR_MESSAGE);
//        }
//    }
}
