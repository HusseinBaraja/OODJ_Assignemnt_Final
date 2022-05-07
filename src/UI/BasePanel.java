package UI;

import javax.swing.*;
import java.awt.*;

public class BasePanel extends JPanel {
    public BasePanel(int backGroundColor) {
        setBackground(new Color(backGroundColor));
    }
    public BasePanel(int backGroundColor, int width, int height) {
        setBackground(new Color(backGroundColor));
        setPreferredSize(new Dimension(width,height));
    }
    public BasePanel(boolean opaque) {
        setOpaque(opaque);
    }
    public BasePanel(boolean opaque, int width, int height) {
        setPreferredSize(new Dimension(width,height));
        setOpaque(opaque);
    }
}
