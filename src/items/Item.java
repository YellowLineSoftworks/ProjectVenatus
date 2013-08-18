
package items;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.swing.ImageIcon;
import java.util.List;
import java.util.ArrayList;


public class Item {
    public Type itemtype;
    public String name;
    public ImageIcon img;
    public List<Buff> buffs = new ArrayList();
    
    public String display(){
        String finals = "";
        if(buffs.size()!=0){
            finals = "\tBuffs\n";

            for(int i = 0; i<buffs.size(); i++){
                finals += "\n   "+buffs.get(i).name();
            }

            finals += "\n\n\tStats\n\n";
        }else{
            finals += "\n\tStats\n\n";
        }
            
        
        return finals;
    }
    
    public void equip(Buff b){
        name = "*" + name;
        buffs.add(b);
        if(b.img!=null){
            img = b.img;
        }
        
        if(b.method != null){
            try {
                b.method.invoke(this);
            } catch (Exception ex) {
                System.err.println(ex);
            }
        }
        
        
        display.DisplayHandler.itemInfoPrinter();
    }
    
    public enum Buff{
        FIRE_DAMAGE(10, 0, 0,0,0,0, new Type[] {Type.WEAPON},null),
        ICE_DEFENCE(0, 10, 0,0,0,0, new Type[] {Type.SHIELD, Type.ARMOR},null),
        EPIC_BUFF(10, 10, 0,0,0,0, new Type[] {Type.ALL},  "sBuff", "esBuff", null);
        
        int damage;
        int defence;
        int strength;
        int intelegence;
        int vitality;
        int dexterity;
        Method method;
        Method emethod;
        Type[] types;
        ImageIcon img;
        Object[] params;
        Buff(int dmg, int def, int srtngth, int intell, int vital, int dexter, Type[] t,ImageIcon i){
            damage = dmg;
            defence = def;
            types = t;
            img = i;
        }
        Buff(int dmg, int def, int srtngth, int intell, int vital, int dexter, Type[] t, String methodname,String emethodname, ImageIcon i){
            damage = dmg;
            defence = def;
            types = t;
            img = i;
            try{
                method = Item.Buff.class.getMethod(methodname);
                emethod = Item.Buff.class.getMethod(emethodname);
            }catch (Exception e){
                
            }
        }
        
        void sBuff(){
           System.out.println("you aheva a buffffff"); 
        }
        void esBuff(){
           System.out.println("you lost your buff a buffffff"); 
        }
                
    }
    
    
    public enum Type{
        SHIELD,WEAPON,CONSUMEABLE,ARMOR,ALL,RING, RESOURCE;
    }
}
