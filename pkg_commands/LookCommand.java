package pkg_commands;

import pkg_engine.Player;
import pkg_engine.GameEngine;

/**
 * Write a description of class LookCommand here.
 * 
 * @author Baptiste HULIN 
 * @version (a version number or a date)
 */
public class LookCommand extends Command
{
   /**
     * Permet au joueur d'observer
     */
    @Override public boolean execute(final Player pPlayer)
    {
        GameEngine.aGUI.println(pPlayer.getCurrentRoom().getLongDescription());
        return false;
    }//permet d'observer l'environnement dans lequel le joueur se trouve
}
