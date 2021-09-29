package projet;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class TP1 {
    public static final int FRAME_WIDTH = 938;
    public static final int FRAME_HEIGHT = 650;
    public static final int MENU_HEIGHT = 500;
    public static final int MENU_WIDTH = 200;

    private JFrame frame;
    private BackgroundComponent centerZone;

    /**
     * Constructor.
     */
    public TP1() {
        // Set the aplication window :
        frame = new JFrame("3iL - Graphic interfaces & 3D - TP1");
        frame.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set horizontal menu :
        JMenuBar horizontalMenu = new JMenuBar();
        frame.setJMenuBar(horizontalMenu);
        JMenu fileMenu = new JMenu("File");
        JMenuItem closeMenuItem = new JMenuItem("Close", new ImageIcon("images/logo-icon.png"));
        fileMenu.add(closeMenuItem);
        horizontalMenu.add(fileMenu);
        JMenu menuEdition = new JMenu("About");
        JMenuItem helpMenuItem = new JMenuItem("Help", new ImageIcon("images/botbtn2low.png"));
        menuEdition.add(helpMenuItem);
        horizontalMenu.add(menuEdition);

        // Set listeners on horizontal menu items :
        closeMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        helpMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "This is the TP1 about Java and Swing.");
            }
        });

        // Set lateral menu :
        JPanel lateralMenu = new JPanel();
        lateralMenu.setPreferredSize(new Dimension(MENU_WIDTH, MENU_HEIGHT));
        lateralMenu.setBorder(BorderFactory.createEtchedBorder());
        frame.add(lateralMenu, BorderLayout.EAST);

        // Set buttons in lateral menu :
        JButton addImageButton = new JButton("Add image");
        lateralMenu.add(addImageButton);
        JButton moveImageButton = new JButton("Move image");
        lateralMenu.add(moveImageButton);
        JButton removeImageButton = new JButton("Remove image");
        lateralMenu.add(removeImageButton);

        // Set listeners on lateral menu buttons :
        addImageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                centerZone.setImageVisible(true);
            }
        });
        moveImageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                centerZone.setImagePosition(230, 400);
            }
        });
        removeImageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                centerZone.setImageVisible(false);
            }
        });

        // Set central zone :
        centerZone = new BackgroundComponent();
        frame.add(centerZone, BorderLayout.WEST);

        // Show the JFrame :
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * Entry point.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TP1();
            }
        });
    }
}
