package UI.Dashboard.Manager;

import UI.BaseComponents.BaseLabel;
import UI.BaseComponents.BasePanel;

import java.awt.*;

public class PnlManagerDashboard extends BasePanel {
    public PnlManagerDashboard(boolean opaque) {
        super(opaque);
        setLayout(new GridBagLayout());

        BaseLabel label = new BaseLabel("hi");

        GridBagConstraints GBCLogin = new GridBagConstraints();
        GBCLogin.weightx = 1;
        GBCLogin.weighty = 1;
        GBCLogin.fill= GridBagConstraints.HORIZONTAL;

        GBCLogin.gridx = 0;
        GBCLogin.gridy = 0;
        GBCLogin.gridwidth = 2;

        this.add(label,GBCLogin);
    }
}
