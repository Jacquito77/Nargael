package pkg_commands;
import pkg_engine.*;
import pkg_engine.UserInterface;
import pkg_engine.GameEngine;
import pkg_rooms.Room;
import pkg_rooms.MovingNPC;

import java.util.Set;
import java.util.Collection;
import java.util.HashMap;

/**
 * Abstract class GoCommand - write a description of the class here
 * 
 * @author Baptiste HULIN
 * @version (version number or date here)
 */
public class GoCommand extends Command
{
    private Audio2 aAudio2;
    private Room aR;
    
    /**
     *  Fonction booléenne execute de la Classe qui permet d'exécuter la commande associé au nom de celle-ci
     */
    @Override public boolean execute(final Player pPlayer)
    {
        if(!this.hasSecondWord()) {  
            
            GameEngine.aGUI.println("Go where?");  
            return false;  
        }  

        
        String vDirection = this.getSecondWord();   
        Room nextRoom = pPlayer.getCurrentRoom().getExit(vDirection);

        if (nextRoom == null)  
            GameEngine.aGUI.println("There is no door!");  
        else {  
            pPlayer.move(nextRoom); 

            
            int vLimit = GameEngine.getLimit();
            vLimit = vLimit -1;
            
            GameEngine.setLimit(vLimit);
            GameEngine.aGUI.println(pPlayer.getCurrentRoom().getLongDescription());  
            if(pPlayer.getCurrentRoom().getImageName() != null)  
                GameEngine.aGUI.showImage(pPlayer.getCurrentRoom().getImageName());  
                
                
            if (vLimit == 40)
                GameEngine.aGUI.println("THE DAY ENDS (40 steps remaining)");

            if (vLimit == 20)
                GameEngine.aGUI.println("NIGHT FALLS (20 steps remaining)");

            if (vLimit == 10)
                GameEngine.aGUI.println("IT WILL BE DARK NIGHT SOON, HURRY (10 steps remaining)");
            if (vLimit == 0)
            {
                GameEngine.aGUI.println("YOU HAVE LOST.");
                GameEngine.aGUI.enable(false);
            }
        }  

        GameEngine.getMovingNPC().moveNPC();
        
//         if (getZone1().containsvalue(pPlayer.getCurrentRoom)
//         {
//                     aAudio2.playLoop("kvk.wav");
//                  }
        
//         if (GameEngine.getZone2().containsValue(pPlayer.getCurrentRoom()))
//         {
//                 GameEngine.aGUI.println("ok");
//                 aAudio2.playLoop("assembly.wav");
//                  }
                 
        return false;
    }
}
