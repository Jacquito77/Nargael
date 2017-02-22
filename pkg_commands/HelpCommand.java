package pkg_commands;
import pkg_engine.Player;
import pkg_engine.UserInterface;
import pkg_engine.GameEngine;
/**
 * Write a description of class HelpCommand here.
 * 
 * @author Baptiste HULIN
 * @version (a version number or a date)
 */
public class HelpCommand extends Command
{
    /**
     *  Fonction booléenne execute de la Classe qui permet d'exécuter la commande associé au nom de celle-ci
     */
    @Override public boolean execute(final Player pPlayer)
    {
        GameEngine.aGUI.println ("Your commandwords are :");
        GameEngine.aGUI.println (GameEngine.aParser.showCommands());
        GameEngine.aGUI.println ("First, try to speak to Durothan at the Forge !");
        return false;
    }//aide au joueur
}
