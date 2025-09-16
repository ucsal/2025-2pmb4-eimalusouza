package br.com.mariojp.figureeditor;

import javax.swing.*;
import java.awt.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) {}

            JFrame frame = new JFrame("Figure Editor — Clique para inserir figuras");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            DrawingPanel panel = new DrawingPanel(new CircleFactory());
            JMenuBar menubar = new JMenuBar();
            JMenu menu = new JMenu("Formas");
            
            JMenuItem circleItem = new JMenuItem("Circulo");
            circleItem.addActionListener(e -> panel.setShapeFactory(new CircleFactory()));
            
            JMenuItem reccleItem = new JMenuItem("Retângulo");
            circleItem.addActionListener(e -> panel.setShapeFactory(new RectangleFactory()));
            
            JMenuItem clearcleItem = new JMenuItem("Limpas Tela");
            circleItem.addActionListener(e -> panel.clear());
            
            menu.add(circleItem);
            JMenuItem rectItem = null;
			menu.add(rectItem);
            menu.addSeparator();
            JMenuItem clearItem = null;
			menu.add(clearItem);
            menubar.add(menu);
            frame.setJMenuBar(menubar);
            
            frame.setLayout(new BorderLayout());
            frame.add(panel, BorderLayout.CENTER);

            frame.setSize(900, 600);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
