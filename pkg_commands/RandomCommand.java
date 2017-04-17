package pkg_commands; 

import pkg_engine.Player;
import pkg_engine.GameEngine;
import pkg_rooms.RoomRandomizer;

/**
 * Write a description of class RandomCommand here.
 * 
 * @author Baptiste HULIN 
 * @version (a version number or a date)
 */
public class RandomCommand extends Command
{
    /**
     *  Fonction booléenne execute de la Classe qui permet d'exécuter la commande associé au nom de celle-ci
     */
    @Override public boolean execute(final Player pPlayer)
    {
        if(GameEngine.aTestMode)
        GameEngine.aTR.setSavedRoom(this.getSecondWord());
        
        else GameEngine.aGUI.println("This command can only be used in TestMode");
        
        if(!this.hasSecondWord())
        {
            GameEngine.aGUI.println("Random enabled.");
            RoomRandomizer.setSeed(null);
        }
        else
        {
            try
            {
                RoomRandomizer.setSeed( Long.parseLong(this.getSecondWord(), 10));
            }
            catch (NumberFormatException E)
            {
                GameEngine.aGUI.println("Wrong seed.");
                return false;
            }
            GameEngine.aGUI.println("You changed the seed.");
        }

   
        
        return false;
    }
}
