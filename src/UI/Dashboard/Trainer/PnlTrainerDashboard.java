package UI.Dashboard.Trainer;

import UI.BaseComponents.BaseLabel;
import UI.BaseComponents.BasePanel;

import javax.swing.*;
import java.awt.*;

public class PnlTrainerDashboard extends BasePanel {
    public PnlTrainerDashboard(boolean opaque) {
        super(opaque);
        setLayout(new BorderLayout());

        BaseLabel label = new BaseLabel("Welcome back to the Trainer interface", 36, "Arial Black" );
        label.setHorizontalAlignment(JLabel.CENTER);
        add(label, BorderLayout.CENTER);


    }
}