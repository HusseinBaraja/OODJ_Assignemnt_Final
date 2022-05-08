package UI.Dashboard.Manager;

import UI.BaseComponents.BaseLabel;
import UI.BaseComponents.BasePanel;

import javax.swing.*;
import java.awt.*;

public class PnlManagerRegistration extends BasePanel {
    public PnlManagerRegistration(boolean opaque) {
        super(opaque);
        JPanel panel = new JPanel();
        JLabel label = new JLabel("This is manager Registration");
        panel.add(label);
        this.add(panel);
    }
}
