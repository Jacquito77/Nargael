package pkg_commands;
import pkg_engine.Player;
import pkg_engine.UserInterface;
import pkg_engine.GameEngine;
/**
 * Write a description of class ItemsCommand here.
 * 
 * @author Baptiste HULIN
 * @version (a version number or a date)
 */
public class ItemsCommand extends Command
{
    /**
     *  Fonction booléenne execute de la Classe qui permet d'exécuter la commande associé au nom de celle-ci
     */
    @Override public boolean execute(final Player pPlayer)
    {
        GameEngine.aGUI.println(pPlayer.getInventoryList());
        return false;
    }
}
