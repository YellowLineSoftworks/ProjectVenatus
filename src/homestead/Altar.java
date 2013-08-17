

package homestead;

import display.displayslaves.AltarDisplaySlave;
import display.ImageRetriever;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;


public class Altar extends AddOn{
    public List<Belief> beliefs = new ArrayList();
    public Image altarImg;
    public Belief currentBelief;
    
    public Altar(){
        addBelief(Belief.SECULARISM);
        setBelief(Belief.SECULARISM);
        addBelief(Belief.BROTHERHOOD_OF_THE_LEAF);
        addBelief(Belief.BLOOD_HORDE);
        addBelief(Belief.FELLOWSHIP);
        x = 200;
        y = 200;
        init();
        name = "Altar";
    }
    
    public void addBelief(Belief b){
        beliefs.add(b);
    }
    
    public boolean setBelief(Belief b){
        if(beliefs.contains(b)){
            currentBelief = b;
            image = currentBelief.img;
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void activate() {
        AltarDisplaySlave.displayChestGUI(this);
    }
    
    public enum Belief{
        SECULARISM("Secularism",new ImageRetriever().getImage("/res/Home Stead/Add Ons/Basic Altar.png"), "The default belief and \nthe general lack of one.\n\n"
                + "No statistical disadvantages"),
        BROTHERHOOD_OF_THE_LEAF("BotL",new ImageRetriever().getImage("/res/Home Stead/Add Ons/Brotherhood Altar.png"), "The belief that the \ngreat tree gods control"
                + "nature and \nall wild life. \n\n Gives bonuses to poisen magic \nand buffs as well.\n\n "
                + "Also unlocking certain granoly \nweapons and clothes"),
        BLOOD_HORDE("Blood Horde", new ImageRetriever().getImage("/res/Home Stead/Add Ons/BloodHorde Altar.png"),"Don't ask questions\nand you won't"
                + "\nmysteriously fade from\nexiistence...."
                + "\n\nUnlocks dark magic \nand allows dark enchantments"),
        FELLOWSHIP("Fellowship", new ImageRetriever().getImage("/res/Home Stead/Add Ons/Fellowship Altar.png"),"This is the light\nat the end of\nthe tunell... gives "
                + "healing buffs\nand unlocks new weapons\nand clothes.");
        Image img;

        public Image getImg() {
            return img;
        }
        String name;
        String description;

        public String getDescription() {
            return description;
        }
        public String getName() {
            return name;
        }
        Belief(String name, Image i, String description){
            this.description = description;
            img = i;
            this.name = name;
        }
    }
}
