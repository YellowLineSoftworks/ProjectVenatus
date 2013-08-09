package display;

import display.gui.MainGUI;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Window;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import res.SuperImage;

/**
 *
 * @author smiley-penis
 */
public class Display {
    
    private BufferedImage image;
    private Graphics g;
    private List<SuperImage> images = new ArrayList<>();
    
    public Display() {
        image = new BufferedImage(721, 511, BufferedImage.TYPE_4BYTE_ABGR_PRE);
        g = image.createGraphics();
    }
    
    private void updateIcon() {
        MainGUI.jLabel9.setIcon(new ImageIcon(image));
    }
    
    public int drawImage(Image i, int x, int y) {
        if (!imageExists(i)){
        SuperImage img = new SuperImage(i, x, y);
        images.add(img);
        g.setColor(Color.white);
        g.fillRect(0, 0, 726, 539);
        for(int c = 0; c < images.size(); c++) {
            g.drawImage(images.get(c).image, images.get(c).dispx, images.get(c).dispy, null);
        }
        updateIcon();
        return img.id;
        } else {
            moveImage(i, x, y);
            int ret = 0;
            for (int z = 0; z < images.size();z++) {
                if (images.get(z).image == i) {
                    ret = images.get(z).id;
                }
            }
            return ret;
        }
    }
    
    public int drawImage(Image i, int startx, int starty, int endx, int endy, int destx, int desty) {
        if (!imageExists(i)){
        SuperImage img = new SuperImage(i, startx, starty, endx, endy, destx, desty);
        images.add(img);
        g.setColor(Color.white);
        g.fillRect(0, 0, 726, 539);
        for(int c = 0; c < images.size(); c++) {
            SuperImage s = images.get(c);
            //g.drawImage(images.get(c).image, images.get(c).dispx, images.get(c).dispy, null);
            g.drawImage(s.image, s.dispx, s.dispy, s.dispx + s.endx - s.startx, s.dispy + s.endy - s.starty, s.startx, s.starty, s.endx, s.endy, null);
        }
        updateIcon();
        return img.id;
        } else {
            moveImage(i, destx, desty);
            int ret = 0;
            for (int z = 0; z < images.size();z++) {
                if (images.get(z).image == i) {
                    ret = images.get(z).id;
                }
            }
            return ret;
        }
    }
    
    public void removeImage(int ids) {
        for (int x = 0; x < images.size(); x++) {
            if (images.get(x).id == ids) {
                images.remove(x);
            }
        }
        g.fillRect(0, 0, 726, 539);
        for(int c = 0; c < images.size(); c++) {
            g.drawImage(images.get(c).image, images.get(c).dispx, images.get(c).dispy, null);
        }
        updateIcon();
    }
       
    public void removeImage(Image img) {
        for (int x = 0; x < images.size(); x++) {
            if (images.get(x).image == img) {
                images.remove(x);
            }
        }
        g.fillRect(0, 0, 726, 539);
        for(int c = 0; c < images.size(); c++) {
            g.drawImage(images.get(c).image, images.get(c).dispx, images.get(c).dispy, null);
        }
        updateIcon();
    }
    
    public void moveImage(int id, int x, int y) {
        for (int z = 0; z < images.size(); z++) {
            if (images.get(z).id == id) {
                images.get(z).dispx = x;
                images.get(z).dispy = y;
            }
        }
        g.fillRect(0, 0, 726, 539);
        for(int c = 0; c < images.size(); c++) {
            SuperImage s = images.get(c);
            //g.drawImage(images.get(c).image, images.get(c).dispx, images.get(c).dispy, null);
            g.drawImage(s.image, s.dispx, s.dispy, s.dispx + s.endx - s.startx, s.dispy + s.endy - s.starty, s.startx, s.starty, s.endx, s.endy, null);
        }
        updateIcon();  
    }
    
    public void moveImage(Image img, int x, int y) {
        for (int z = 0; z < images.size(); z++) {
            if (images.get(z).image == img) {
                images.get(z).dispx = x;
                images.get(z).dispy = y;
            }
        }
        g.fillRect(0, 0, 726, 539);
        for(int c = 0; c < images.size(); c++) {
            SuperImage s = images.get(c);
            //g.drawImage(images.get(c).image, images.get(c).dispx, images.get(c).dispy, null);
            g.drawImage(s.image, s.dispx, s.dispy, s.dispx + s.endx - s.startx, s.dispy + s.endy - s.starty, s.startx, s.starty, s.endx, s.endy, null);
        }
        updateIcon();  
    }
    
    public boolean imageExists(Image img) {
        for (int z = 0; z < images.size(); z++) {
            if (images.get(z).image == img) {
                return true;
            }
        }
        return false;
    }
    
    public boolean imageExists(int id) {
        for (int z = 0; z < images.size(); z++) {
            if (images.get(z).id == id) {
                return true;
            }
        }
        return false;
    }
    
    public void removeAllImages(){
        images = new ArrayList<>();
        DisplayHandler.moveCharacter("up");
    }
    
}