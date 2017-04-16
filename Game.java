import pkg_engine.UserInterface;
import pkg_engine.GameEngine;
import pkg_engine.Player;


/**
 * Moteur du jeu
 * 
 * @author Baptiste HULIN 
 * @version final
 */
public class Game
{
    private UserInterface aGUI;
    private GameEngine aGE;
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        aGE = new GameEngine();
        aGUI = new UserInterface(aGE);
        new Player();
        aGE.setGUI(aGUI);
    }
    
    public static void main(final String[] pArgs)
    {
        new Game();
    }
   
   
    
    } // Game
