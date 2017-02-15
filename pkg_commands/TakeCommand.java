 package pkg_commands;
 
import pkg_engine.Player;
import pkg_engine.UserInterface;
import pkg_engine.GameEngine;
import pkg_items.Item;

/**
 * Write a description of class TakeCommand here.
 * 
 * @author Baptiste HULIN 
 * @version (a version number or a date)
 */
public class TakeCommand extends Command
{
    /**
     * Procédure qui permet de prendre un objet
     */
    @Override public boolean execute(final Player pPlayer)
    {
        if (this.getSecondWord()== null)
        {
            GameEngine.aGUI.println ("Take what ?");
            return false;
        }

        String vItemName = this.getSecondWord();
        Item vItem = pPlayer.getCurrentRoom().getRoomItem(vItemName);

        if (vItem == null)
        {
            GameEngine.aGUI.println ("This item doesn't exist in this place.");
        }
        else if (pPlayer.getCurrentWeight() + vItem.getWeight() > pPlayer.getMaxWeight())
        {
            GameEngine.aGUI.println("You can't carry this item, you excess the maximum weight !");
        }

        else 
        {
            pPlayer.addItemPlayer(vItemName, pPlayer.getCurrentRoom().getItemList().getAllItems().get(vItemName));
            pPlayer.getCurrentRoom().getItemList().itemTaken(vItemName);
            GameEngine.aGUI.println("You have taken "+ vItemName);
        }
        
        return false;
    }
}
