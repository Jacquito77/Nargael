package pkg_commands;

import pkg_engine.Player;
import pkg_engine.UserInterface;
import pkg_engine.GameEngine;
import pkg_rooms.Room;
import pkg_items.Item; 
import pkg_rooms.NPC; 

/**
 * Write a description of class GiveCommand here.
 * 
 * @author Baptiste HULIN
 * @version (a version number or a date)
 */
public class GiveCommand extends Command
{
    /**
     *  Fonction booléenne execute de la Classe qui permet d'exécuter la commande associé au nom de celle-ci
     */
    @Override public boolean execute(Player pPlayer)
    {
        String vItemName = this.getSecondWord (); 
        Item vItem = pPlayer.getInventory().getAllItems().get(vItemName); 
        
      if (vItem == null)
        {
            GameEngine.aGUI.println ("You don't have this item !");
       }
       
       else {
           
           for (NPC vNPC : pPlayer.getCurrentRoom().getNPCList().getNPCList().values()) {
               if (vNPC.onGive(vItem)) {
                    pPlayer.getInventory().itemTaken(vItemName);
                    vNPC.getAllItemsPNJ().addItem(vItemName, vItem); 
                    GameEngine.aGUI.println("You have given "+ vItemName + " to " + vNPC.getNPCName());
                    break; 
               }
           }
        }
        
        return false;
    }
}
