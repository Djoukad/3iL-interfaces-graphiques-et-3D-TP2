package projet;

import java.awt.Graphics;
import java.awt.Dimension;
import javax.swing.JComponent;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BackgroundComponent extends JComponent {
    public boolean isImageVisible;
    public int imageX;
    public int imageY;

    public BackgroundComponent() {
        setPreferredSize(new Dimension(738, 650));
        isImageVisible = false;
        imageX = 230;
        imageY = 50;
    }

    @Override
    public void paintComponent(Graphics g) {
        try {
            // Set image as backgroung of this component :
            BufferedImage backgroungImage = ImageIO.read(new File("images/robot-feminin.jpg"));
            g.drawImage(backgroungImage, 0, 0, null);

            // Set an other image, hidden by default :
            BufferedImage image = ImageIO.read(new File("images/logo-3il-part.png"));
            if (isImageVisible) {
                g.drawImage(image, imageX, imageY, null);
            }
        } catch (IOException ex) {
        }
    }

    /**
     * Set image visible param to given value.
     */
    public boolean setImageVisible(boolean isVisible) {
        boolean isOk = true;

        this.isImageVisible = isVisible;
        this.repaint();

        return isOk;
    }

    /**
     * Set position of image.
     */
    public boolean setImagePosition(int imageX, int imageY) {
        boolean isOk = true;

        this.imageX = imageX;
        this.imageY = imageY;
        this.repaint();
        
        return isOk;
    }
}
