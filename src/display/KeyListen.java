
package display;

import display.gui.MainGUI;
import java.awt.Point;
import main.Objects.ActivatableObject;
import java.awt.event.KeyEvent;
import resources.listener.Keylistener;
import main.Objects.AttackableObject;
import main.Player;
import main.Macro;
import main.Tile;



public class KeyListen extends Keylistener {
    
    public static boolean isMoving = false;
    
    @Override
    public void KeyTyped(KeyEvent e) {
        
    }

    @Override
    public void KeyPressed(KeyEvent e) {
        if (MainGUI.MainTabbedPane.getSelectedIndex() == 0) {
            int keyCode = e.getKeyCode();
            isMoving = true;
            if (keyCode == KeyEvent.VK_UP) {
                main.Player.mainchar.currentDirection = "up";
                DisplayHandler.weaponSprite = DisplayHandler.weapUp;
            }
            if (keyCode == KeyEvent.VK_DOWN) {
                main.Player.mainchar.currentDirection = "down";
                DisplayHandler.weaponSprite = DisplayHandler.weapDown;
            }
            if (keyCode == KeyEvent.VK_RIGHT) {
                main.Player.mainchar.currentDirection = "right";
                DisplayHandler.weaponSprite = DisplayHandler.weapRight;
            }
            if (keyCode == KeyEvent.VK_LEFT) {
                main.Player.mainchar.currentDirection = "left";
                DisplayHandler.weaponSprite = DisplayHandler.weapLeft;
            } 
            if(keyCode == KeyEvent.VK_E){

                //Maximum and minimum x and y values for attacking something
                int maX = DisplayHandler.charx + Player.mainchar.imgup.getWidth(null);
                int maY = DisplayHandler.chary +Player.mainchar.imgup.getHeight(null);
                int miX = DisplayHandler.charx;
                int miY = DisplayHandler.chary;
                for(int i = 0; i<Tile.currentTile.objects.size(); i++){
                    if(Tile.currentTile.objects.get(i) instanceof ActivatableObject){
                        ActivatableObject obj = (ActivatableObject)Tile.currentTile.objects.get(i);

                        Point center = Macro.center(maX, miX, maY, miY);
                        if(Macro.within(center.x, obj.maX, obj.miX) && Macro.within(center.y, obj.maY, obj.miY)){
                            obj.activate();
                        }
                    }

                }
            }
            if(keyCode == KeyEvent.VK_A){
                //Maximum and minimum x and y values for attacking something
                int maX = -1;
                int maY = -1;
                int miX = -1;
                int miY = -1;
                //Establish the hitbox based on the player's direction.
                switch (Player.mainchar.currentDirection) {
                    case "up" :
                        maX = DisplayHandler.charx + 40;
                        maY = DisplayHandler.chary + 40;
                        miX = DisplayHandler.charx;
                        miY = DisplayHandler.chary - 20;
                        DisplayHandler.moveWeapon(DisplayHandler.charx+12, DisplayHandler.chary-18);
                        break;
                    case "down" :
                        maX = DisplayHandler.charx + 40;
                        maY = DisplayHandler.chary + 40 + 15;
                        miX = DisplayHandler.charx;
                        miY = DisplayHandler.chary + 40;
                        DisplayHandler.moveWeapon(DisplayHandler.charx+12, DisplayHandler.chary+26);
                        break;
                    case "right" :
                        maX = DisplayHandler.charx + 40 + 10;
                        maY = DisplayHandler.chary;
                        miX = DisplayHandler.charx + 40;
                        miY = DisplayHandler.chary + 40;
                        DisplayHandler.moveWeapon(DisplayHandler.charx+18, DisplayHandler.chary+12);
                        break;
                    case "left" :
                        maX = DisplayHandler.charx;
                        maY = DisplayHandler.chary + 40;
                        miX = DisplayHandler.charx - 25;
                        miY = DisplayHandler.chary;
                        DisplayHandler.moveWeapon(DisplayHandler.charx-26, DisplayHandler.chary+12);
                        break;
                }
                //Loop through all attackable objects and test if any are within range of the player
                for(int i = 0; i<AttackableObject.attackableObjects.size(); i++){
                    AttackableObject obj = AttackableObject.attackableObjects.get(i);
                    //Test if the object's hitbox intersects with the player's hitbox or vice versa.
                    //This works by testing if any of the corners of each hitbox are within the other box.
                    boolean intersect = false;
                    if (Macro.within(obj.maX, maX, miX) || Macro.within(obj.miX, maX, miX)) {
                        if (Macro.within(obj.maY, maY, miY) || Macro.within(obj.miY, maY, miY)) {
                            intersect = true;
                        }
                    } 
                    if (!intersect) {
                        if (Macro.within(maX, obj.maX, obj.miX) || Macro.within(miX, obj.maX, obj.miX)) {
                            if (Macro.within(maY, obj.maY, obj.miY) || Macro.within(miY, obj.maY, obj.miY)) {
                                intersect = true;
                            }
                        }
                    } 
                    if (!intersect) {
                        Point objCenter = Macro.center(obj.maX, obj.miX, obj.maY, obj.miY);
                        Point center = Macro.center(maX, miX, maY, miY);
                        if (Macro.within(objCenter.x, maX, miX) && Macro.within(objCenter.y, maY, miY)) {
                            intersect = true;
                        } else if (Macro.within(center.x, obj.maX, obj.miX) && Macro.within(center.y, obj.maY, obj.miY)) {
                            intersect = true;
                        }
                    }
                    if (intersect) {
                        obj.attacked();
                    }
                    //This code just tests if the top left corner of the object is within the player's attack hitbox. Whoops.
                    /*if (obj.x >= miX && obj.x <= maX && obj.y >= miY && obj.y <= maY) {
                        obj.attacked();
                    }*/

                }
            }
        }
    }

    @Override
    public void KeyReleased(KeyEvent e) {
        isMoving = false;
        if(e.getKeyCode() == KeyEvent.VK_A){
            switch(Player.mainchar.currentDirection) {
                case "up":
                    DisplayHandler.moveWeapon(DisplayHandler.charx+12, DisplayHandler.chary-12);
                    break;
                case "down":
                    DisplayHandler.moveWeapon(DisplayHandler.charx+12, DisplayHandler.chary+20);
                    break;
                case "right":
                    DisplayHandler.moveWeapon(DisplayHandler.charx+12, DisplayHandler.chary+12);
                    break;
                case "left":
                    DisplayHandler.moveWeapon(DisplayHandler.charx-20, DisplayHandler.chary+12);
            }
        }
    }
    
}