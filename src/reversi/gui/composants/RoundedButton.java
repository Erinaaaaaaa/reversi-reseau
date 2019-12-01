package reversi.gui.etc;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedButton extends JButton
{
    private int borderRadius;

    public RoundedButton(int borderRadius)
    {
        super();
        this.borderRadius = borderRadius;
        Dimension size = getPreferredSize();
        size.width = size.height = Math.max(size.width, size.height);
        setPreferredSize(size);
        setContentAreaFilled(false);
        setBackground(new Color(230,253,255));
    }

    public RoundedButton(String label, int borderRadius)
    {
        super(label);
        this.borderRadius = borderRadius;
        Dimension size = getPreferredSize();
        size.width = size.height = Math.max(size.width, size.height);
        setPreferredSize(size);
        setContentAreaFilled(false);
        setBackground(new Color(230,253,255));
    }

    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(Color.CYAN);
        } else {
            g.setColor(getBackground());
        }
        g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, this.borderRadius, this.borderRadius);
        super.paintComponent(g);
    }
    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, this.borderRadius, this.borderRadius);
    }
    Shape shape;
    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, this.borderRadius, this.borderRadius);
        }
        return shape.contains(x, y);
    }
}
