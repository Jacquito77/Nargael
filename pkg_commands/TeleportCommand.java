package pkg_commands; 

import pkg_engine.Player;
import pkg_engine.UserInterface;
import pkg_engine.GameEngine;
import pkg_items.Beamer;
import pkg_rooms.Room;
/**
 * Write a description of class TeleportCommand here.
 * 
 * @author Baptiste HULIN 
 * @version (a version number or a date)
 */
public class TeleportCommand extends Command
{
    /**
     *  Fonction booléenne execute de la Classe qui permet d'exécuter la commande associé au nom de celle-ci
     */
    @Override public boolean execute(final Player pPlayer)
    {
        if (!pPlayer.getInventory().hasItem("Beamer"))
        {
            GameEngine.aGUI.println("You can't teleport without a Beamer.");
            return false;
        }

        Beamer vBeamer = (Beamer) pPlayer.getInventory().getItem("Beamer");
        if (vBeamer.isCharged())
        {
            Room vRoom = vBeamer.getSavedRoom();
            if(!vRoom.equals(pPlayer.getCurrentRoom()))
            {
                GameEngine.aGUI.println("You are now teleporting");
                pPlayer.move(vRoom);
                if(pPlayer.getCurrentRoom().getImageName() != null)

                    GameEngine.aGUI.showImage(pPlayer.getCurrentRoom().getImageName());

                vBeamer.setCharged(false);
            }
            else 
            {
                GameEngine.aGUI.println("You are already in the saved room.");
            }
        }

        else
        {
            GameEngine.aGUI.println("You saved the current room with your beamer.");
            vBeamer.setCharged(true);
            vBeamer.setSavedRoom(pPlayer.getCurrentRoom());
        }
        return false;
    }
}
