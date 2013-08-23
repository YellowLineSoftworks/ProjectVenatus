/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package display.displayslaves;

import display.DisplayHandler;
import homestead.Altar;
import java.util.ArrayList;
import java.util.List;
import display.gui.AltarGUI;
import homestead.MainBase;
import java.awt.Image;
import javax.swing.ImageIcon;



public class AltarDisplaySlave {
    static AltarGUI cgui;
    public static Altar currentAltar;
    public static void displayChestGUI(Altar altar){
        cgui = new AltarGUI();
        cgui.setVisible(true);
        currentAltar = altar;
        DisplayList();
        
    }
    //Display list of all belifes
    public static void DisplayList() {
        cgui.listModel.clear();
        for(int i = 0; i<currentAltar.beliefs.size();i ++){
            cgui.listModel.addElement(currentAltar.beliefs.get(i).getName());        
        }
    }
    //Display belife info
    public static void itemInfoPrinter(){
        int index = cgui.ListDisplay.getSelectedIndex();
        cgui.InfoDisplay.setText("\t"+currentAltar.beliefs.get(index).getName()+"\n"+currentAltar.beliefs.get(index).getDescription());
        cgui.AltarImageDisplay.setIcon(new ImageIcon(currentAltar.beliefs.get(index).getImg()));
    }
    
    public static void convert(){
        currentAltar.setBelief(currentAltar.beliefs.get(cgui.ListDisplay.getSelectedIndex()));
        cgui.dispose();
        MainBase.mainbase.drawElements();
    }
    
    public static void main(String[] args){
        displayChestGUI(new Altar());
    }
}
