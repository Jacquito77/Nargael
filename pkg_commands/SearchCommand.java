package pkg_commands; 

import pkg_engine.Player;
import pkg_engine.UserInterface;
import pkg_engine.GameEngine;
import pkg_items.Item;

/**
 * Write a description of class SearchCommand here.
 * 
 * @author Baptiste HULIN 
 * @version (a version number or a date)
 */
public class SearchCommand extends Command
{
    /**
     *  Fonction booléenne execute de la Classe qui permet d'exécuter la commande associé au nom de celle-ci
     */
    @Override public boolean execute(final Player pPlayer)
    {
        if (!this.hasSecondWord())
        {
            GameEngine.aGUI.println ("Search what ?");
            return false;
        }

        String vN = this.getSecondWord();
        Item vLeather = new Item("Leather", 50, "A piece of leather, you should be able" +
                "to do something with it");
        
        Item vItem = pPlayer.getCurrentRoom().getRoomItem(vN);

        if (vItem == null)
        {
            GameEngine.aGUI.println ("This item doesn't exist in this place.");
        }

        else if(vN.equals("Straw"))
        {
            pPlayer.addItemPlayer("Leather", vLeather);
            GameEngine.aGUI.println("You have found Leather !");
        }
        return false;
    }
}
