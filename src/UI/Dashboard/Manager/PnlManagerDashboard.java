package UI.Dashboard.Manager;

import UI.BaseComponents.BaseLabel;
import UI.BaseComponents.BasePanel;

import javax.swing.*;
import java.awt.*;

public class PnlManagerDashboard extends BasePanel {
    public PnlManagerDashboard(boolean opaque) {
        super(opaque);
        setLayout(new BorderLayout());

        BaseLabel label = new BaseLabel("Welcome back to the manager interface", 36, "Arial Black" );
        label.setHorizontalAlignment(JLabel.CENTER);
        add(label, BorderLayout.CENTER);


    }
}
