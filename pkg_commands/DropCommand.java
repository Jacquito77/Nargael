package pkg_commands;

import pkg_engine.Player;
import pkg_engine.GameEngine;
import pkg_items.Item;

/**
 * Write a description of class DropCommand here.
 * 
 * @author Baptiste HULIN 
 * @version (a version number or a date)
 */
public class DropCommand extends Command
{
   /**
     *  Fonction booléenne execute de la Classe qui permet d'exécuter la commande associé au nom de celle-ci
     */
    @Override public boolean execute(final Player pPlayer)
   {
        if (this.getSecondWord()==null)
       {
           GameEngine.aGUI.println ("Drop what ?");
           return false;
        }
       
        
       String vItemName = this.getSecondWord();
       Item vItem = pPlayer.getInventory().getAllItems().get(vItemName);

        
       if (vItem == null)
        {
            GameEngine.aGUI.println ("You don't have this item !");
       }
       
       else {
           //if (this.aPlayer.getCurrentWeight + vIte
           pPlayer.getInventory().itemTaken(vItemName);
           pPlayer.getCurrentRoom().addItemRoom(vItemName, vItem);

           GameEngine.aGUI.println("You have dropped "+ vItemName);
        }
  
       
        return false;
    }
}
