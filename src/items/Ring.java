/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

import java.lang.reflect.Method;


public class Ring extends Item{
    
    Item.Buff buff;
    
    public Ring(Rng r){
        
    }
    public Ring(Item.Buff b){
        buff = b;
    }
    
    public enum Rng{
        WARRIORS_BAND(10,0,5,5);
        
        int strength;
        int intelegence;
        int vitality;
        int dexterity;
        Method method;
        Method emethod;
        Rng(int s, int i, int v, int d){
            strength = s;
            intelegence = i;
            vitality = v;
            dexterity = d;
        }
        Rng(int s, int i, int v, int d, String methodname, String emethodname){
            strength = s;
            intelegence = i;
            vitality = v;
            dexterity = d;
            try{
                method = Ring.Rng.class.getMethod(methodname);
                emethod = Item.Buff.class.getMethod(emethodname);
            }catch (Exception e){
                
            }
        }
    }
}
