package pkg_commands;

import pkg_engine.Player;
import pkg_engine.UserInterface;
import pkg_engine.GameEngine;
import pkg_items.Item;

/**
 * Write a description of class EatCommand here.
 * 
 * @author Baptiste HULIN 
 * @version (a version number or a date)
 */
public class EatCommand extends Command
{
    /**
     * Permet au joueur de manger
     */
    @Override public boolean execute(final Player pPlayer)
    {
        if (this.getSecondWord() == null)
        {
            GameEngine.aGUI.println ("Eat what ?");
            return false;
        }

        String vName = this.getSecondWord();

        if(!pPlayer.getInventory().hasItem(vName))
        {
            GameEngine.aGUI.println("You haven't any " + vName + ", you can't eat it !");
            return false;
        }

        Item vItem = pPlayer.getInventory().getItem(vName);
        
        
        if (!vItem.getEatable())
        {
            GameEngine.aGUI.println("You can't eat " + vName);
            
        }
        else if(vItem.getEatable())
        {
            pPlayer.getInventory().itemTaken(vName);
            GameEngine.aGUI.println("You have eaten " + vName);
        }

        if (vName.equals("Magic_Cookie"))
        {
            pPlayer.setMaxWeight(pPlayer.getMaxWeight() + 200);
            GameEngine.aGUI.println("You can now carry more items !");
        }
        
        if (vName.equals("Beer"))
        {
            GameEngine.aGUI.println("You have drunk some beer, that was delicous !");
        }
        
        SaveCommand test = new SaveCommand("un string"); 
        test.execute(pPlayer);
        
        return false;
    }
}
