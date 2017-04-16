package pkg_commands;
import java.io.File; 
import java.util.Scanner; 

import pkg_engine.Player;
import pkg_engine.GameEngine;

/**
 * Write a description of class TestCommand here.
 * 
 * @author Baptiste HULIN 
 * @version (a version number or a date)
 */
public class TestCommand extends Command
{
    /**
     * Procédure qui permet de tester les commandes du jeu
     */
    @Override public boolean execute(final Player pPlayer) 
    {
        if (!this.hasSecondWord())
        {    
            GameEngine.aGUI.println("Test what?");
            return false;
        }

        String vFichier = this.getSecondWord();
        Scanner sr;

        try 
        {
            sr = new Scanner(new File (vFichier+".txt"));
            //(this.getClass().getClassLoader().getResourceAsStream("" +vFichier +".txt"));}

            //System.out.println(sr);

            while (sr.hasNextLine()) 
            {
                String vLigne = sr.nextLine();
                GameEngine.interpretCommand(vLigne);
            }

        }

        catch (java.io.FileNotFoundException pException)
        {
            GameEngine.aGUI.println("File not found");
        }
        return false;
    }
    
}
