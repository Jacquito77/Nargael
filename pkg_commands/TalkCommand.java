package pkg_commands;

import pkg_rooms.NPC;
import pkg_engine.Player;
import pkg_engine.UserInterface;
import pkg_engine.GameEngine;
import pkg_rooms.Room;
import pkg_rooms.NPCList;


/**
 * Write a description of class TalkCommand here.
 * 
 * @author Baptiste HULIN
 * @version (a version number or a date)
 */
public class TalkCommand extends Command
{
    /**
     *  Fonction booléenne execute de la Classe qui permet d'exécuter la commande associé au nom de celle-ci
     */
    @Override public boolean execute(final Player pPlayer)
    {
        if (this.getSecondWord()== null)
        {
            GameEngine.aGUI.println ("Who to talk with ? #Juju");
            return false;
        }
        
        String vNPCName = this.getSecondWord();
        NPC vNPC = pPlayer.getCurrentRoom().getNPCRoom(vNPCName);
        
        if (vNPC == null)
        {
            GameEngine.aGUI.println ("This NPC isn't here.");
        }
        
        else {
            GameEngine.aGUI.println (" "+ vNPC.getText());
            vNPC.onTalk(); 
        }
        
        return false;
    }
}
