package display;

/**
 * @version 1.0 Final
 * @author YellowLineSoftworks
 */

import java.awt.Image;
import java.io.File;
import java.net.URL;
import javax.imageio.ImageIO;

public class ImageRetriever {
    
    public Image getImage(String image) {
        
        URL url = getClass().getResource(image);
        try {File file = new File(url.toURI());
            Image finalImage = ImageIO.read(file);
            return finalImage;
        } catch(Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
        
    }
    
}