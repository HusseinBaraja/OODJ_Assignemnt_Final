import Controller.LoginControl;
import Model.LoginModel;
import UI.BaseFrame;
import UI.Dashboard.BaseDashboard;
import UI.Dashboard.Manager.BaseManagerDashboard;
import UI.Dashboard.Trainer.BaseTrainerDashboard;
import UI.LoginPage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.cert.TrustAnchor;

public class Main {
    public static void main(String[] args){
        new BaseManagerDashboard();


//        LoginPage theView = new LoginPage();
//
//        LoginModel theModel = new LoginModel();
//
//        LoginControl theController = new LoginControl(theView,theModel);
//
//        theView.setVisible(true);



        //new LoginPage();
//        try {
//            BufferedWriter bw = new BufferedWriter(new FileWriter("temp.txt", true)); //The file can get appended
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}
