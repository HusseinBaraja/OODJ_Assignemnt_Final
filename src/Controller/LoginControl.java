package Controller;

import Model.LoginModel;
import UI.LoginPage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginControl {
//    private LoginPage loginView;
//    private LoginModel loginModel;
//
//    public LoginControl(LoginPage loginView, LoginModel loginModel){
//        this.loginView = loginView;
//        this.loginModel = loginModel;
//
//
//        this.loginView.addLoginListener(new LoginListener());
//    }
//
//    class LoginListener implements ActionListener {
//
//        public void actionPerformed(ActionEvent e) {
//
//            String strUserName, strPassword;
//
//            // Surround interactions with the view with
//            // a try block in case numbers weren't
//            // properly entered
//
//            try{
//
//                strUserName = loginView.getTxtUserName().getText();
//                strPassword = String.valueOf(loginView.getTxtPassword().getPassword());
//
//                loginModel.AllowLogin(strUserName, strPassword);
//
//                ActionListener loginListener = new LoginModel();
//                loginView.ApplyActionListener(loginListener);
//                //loginView.setCalcSolution(loginModel.getCalculationValue());
//            }
//
//            catch(Exception ex){
//
//                System.out.println(ex);
//
//                loginView.displayErrorMessage("Please fill in the text boxes!!");
//
//            }
//
//        }
//
//    }
}
