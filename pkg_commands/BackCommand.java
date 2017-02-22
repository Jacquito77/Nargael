package pkg_commands;

import pkg_engine.Player;
import pkg_engine.UserInterface;
import pkg_engine.GameEngine;
import pkg_rooms.Room;

/**
 * Write a description of class BackCommand here.
 * 
 * @author Baptiste HULIN 
 * @version (a version number or a date)
 */
public class BackCommand extends Command
{
    /**
     *  Fonction booléenne execute de la Classe qui permet d'exécuter la commande associé au nom de celle-ci
     */
    @Override public boolean execute(Player pPlayer)
    {
        Room vRoom = pPlayer.getPreviousRoom();
        if (pPlayer.hasNoPreviousRoom() || vRoom == null)
            GameEngine.aGUI.println("You can't go back anymore !");

        else
        {
            //             aCurrentRoom = aStack.pop();
            pPlayer.moveBack();
            GameEngine.aGUI.println( pPlayer.getCurrentRoom().getLongDescription());
            
            String vDoor = pPlayer.getCurrentRoom().getDoor(vRoom);
            if (vDoor == null)
            {
                GameEngine.aGUI.println("It's locked, you have been trapped");
            }

            if(pPlayer.getCurrentRoom().getImageName() != null)

                GameEngine.aGUI.showImage(pPlayer.getCurrentRoom().getImageName());
        
        }
        
        return false;
    }
}
