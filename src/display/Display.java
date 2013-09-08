package display;

import display.gui.MainGUI;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import res.SuperImage;


public class Display {
    
    public BufferedImage imageMerge;
    private BufferedImage image;
    private BufferedImage layer2;
    private BufferedImage background;
    private Graphics backg;
    private Graphics g;
    private Graphics g2;
    private Graphics imageMergeGraphics;
    private List<SuperImage> images = new ArrayList<>();
    private List<SuperImage> movableimages = new ArrayList<>();
    private int[] movableImagesIDs = {};
    public boolean isDev = false;
    
    public Display() {
        imageMerge = new BufferedImage(772, 518, BufferedImage.TYPE_4BYTE_ABGR_PRE);
        imageMergeGraphics = imageMerge.createGraphics();
        image = new BufferedImage(772, 518, BufferedImage.TYPE_4BYTE_ABGR_PRE);
        g = image.createGraphics();
        layer2 = new BufferedImage(772, 518, BufferedImage.TYPE_4BYTE_ABGR_PRE);
        g2 = layer2.createGraphics();
        background = new BufferedImage(772, 518, BufferedImage.TYPE_4BYTE_ABGR_PRE);
        backg = background.createGraphics();
    }
    
    public int drawMovableImage(Image i, int x, int y) {
        SuperImage img = new SuperImage(i, x, y);
        movableimages.add(img);
        redrawMovableLayer();
        return img.id;
    }
    
    public void updateIcon() {
        if (MainGUI.MainTabbedPane.getSelectedIndex() == 0) {
        imageMergeGraphics.drawImage(background, 0, 0, null);
        imageMergeGraphics.drawImage(image, 0, 0, null);
        imageMergeGraphics.drawImage(layer2, 0, 0, null);
        if(!isDev){
            MainGUI.MainPanel.getGraphics().drawImage(imageMerge, 0, 0, null);
        }else{
            display.gui.LevelMaker.MainLabel.setIcon(new ImageIcon(imageMerge));
        }
        }
    }
    
    public int drawMovableImage(Image i, int startx, int starty, int endx, int endy, int destx, int desty) {
        SuperImage img = new SuperImage(i, startx, starty, endx, endy, destx, desty);
        movableimages.add(img);
        redrawMovableLayer();
        return img.id;
    }
    
    public int drawImage(Image i, int x, int y) {
        SuperImage img = new SuperImage(i, x, y);
        images.add(img);
        g.drawImage(i, x, y, null);
        updateIcon();
        return img.id;
    }
    
    public int drawImage(Image i, int startx, int starty, int endx, int endy, int destx, int desty) {
        SuperImage img = new SuperImage(i, startx, starty, endx, endy, destx, desty);
        images.add(img);
        g.drawImage(img.image, img.dispx, img.dispy, img.dispx + img.endx - img.startx, img.dispy + img.endy - img.starty, img.startx, img.starty, img.endx, img.endy, null);
        updateIcon();
        return img.id;
    }
    
    public void removeImage(int id) {
        boolean removed = false;
        for (int x = 0; x < images.size(); x++) {
            if (images.get(x).id == id) {
                images.remove(x);
                removed = true;
                refreshLayer1();
            }
        }
        if (!removed) {
            for (int x = 0; x < movableimages.size(); x++) {
                if (movableimages.get(x).id == id) {
                    removeMovableImage(id);
                    movableimages.remove(x);
                }
            }
        }
        updateIcon();
    }
    
    public void removeImage(Image img) {
        boolean removed = false;
        for (int x = 0; x < images.size(); x++) {
            if (images.get(x).image == img) {
                images.remove(x);
                removed = true;
                refreshLayer1();
            }
        }
        if (!removed) {
            for (int x = 0; x < movableimages.size(); x++) {
                if (movableimages.get(x).image == img) {
                    removeMovableImage(movableimages.get(x).id);
                    movableimages.remove(x);
                }
            }
        }
        updateIcon();
    }
    
    public void setBackground(Image background) {
        backg.drawImage(background, 0, 0, null);
        updateIcon();
    }
    
    public void addMovableImage (int id) {
        int[] temp = new int[movableImagesIDs.length + 1];
        for (int x = 0; x < movableImagesIDs.length; x++) {
            temp[x] = movableImagesIDs[x];
        }
        temp[movableImagesIDs.length] = id;
        movableImagesIDs = temp;
    }
    
    public void removeMovableImage (int id) {
        int[] temp = new int[movableImagesIDs.length - 1];
        int tempCounter = 0;
        for (int x = 0; x < movableImagesIDs.length; x++) {
            if (movableImagesIDs[x] != id) {
                temp[tempCounter] = movableImagesIDs[x];
                tempCounter++;
            }
        }
        movableImagesIDs = temp;
    }
    
    private boolean isMovable (int id) {
        for (int x = 0; x < movableImagesIDs.length; x++) {
            if (movableImagesIDs[x] == id) {
                return true;
            }
        }
        return false;
    }
    
    private void redrawMovableLayer() {
        layer2 = new BufferedImage(772, 518, BufferedImage.TYPE_4BYTE_ABGR_PRE);
        g2 = layer2.createGraphics();
        for (int x = 0; x < movableimages.size(); x++) {
            SuperImage img = movableimages.get(x);
            g2.drawImage(img.image, img.dispx, img.dispy, img.dispx + img.endx - img.startx, img.dispy + img.endy - img.starty, img.startx, img.starty, img.endx, img.endy, null);
        }
        updateIcon();
    }
    
    public void moveImage(int id, int x, int y) {
        if (!isMovable(id)) {
        for (int c = 0; c < images.size(); c++) {
            if (images.get(c).id == id) {
                images.get(c).dispx = x;
                images.get(c).dispy = y;
                movableimages.add(images.get(c));
                removeImage(id);
                addMovableImage(id);
                redrawMovableLayer();
                refreshLayer1();
            }
        }
        } else {
            for (int c = 0; c < movableimages.size(); c++) {
                if (movableimages.get(c).id == id) {
                    movableimages.get(c).dispx = x;
                    movableimages.get(c).dispy = y;
                    redrawMovableLayer();
                }
            }
        }
        updateIcon();
    }
    
    public void moveImage(int id, int startx, int starty, int endx, int endy, int destx, int desty) {
        if (!isMovable(id)) {
        for (int c = 0; c < images.size(); c++) {
            if (images.get(c).id == id) {
                images.get(c).startx = startx;
                images.get(c).starty = starty;
                images.get(c).dispx = destx;
                images.get(c).dispy = desty;
                images.get(c).endx = endx;
                images.get(c).endy = endy;
                movableimages.add(images.get(c));
                removeImage(id);
                addMovableImage(id);
                redrawMovableLayer();
                refreshLayer1();
            }
        }
        } else {
            for (int c = 0; c < movableimages.size(); c++) {
                if (movableimages.get(c).id == id) {
                    movableimages.get(c).startx = startx;
                    movableimages.get(c).starty = starty;
                    movableimages.get(c).dispx = destx;
                    movableimages.get(c).dispy = desty;
                    movableimages.get(c).endx = endx;
                    movableimages.get(c).endy = endy;
                    redrawMovableLayer();
                }
            }
        }
        updateIcon();
    }
    
    public void resetBufferedImage() {
        image = new BufferedImage(772, 518, BufferedImage.TYPE_4BYTE_ABGR_PRE);
        g = image.createGraphics();
        images = new ArrayList<>();
        movableimages = new ArrayList<>();
        updateIcon();
    }
    
    public void refreshLayer1() {
        image = new BufferedImage(772, 518, BufferedImage.TYPE_4BYTE_ABGR_PRE);
        g = image.createGraphics();
        for (int x = 0; x < images.size(); x++) {
            SuperImage img = images.get(x);
            g.drawImage(img.image, img.dispx, img.dispy, img.dispx + img.endx - img.startx, img.dispy + img.endy - img.starty, img.startx, img.starty, img.endx, img.endy, null);
        }
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
    
}