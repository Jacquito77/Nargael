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
    private Player aPlayer;

    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        aGE = new GameEngine();
        aGUI = new UserInterface(aGE);
        aPlayer = new Player();
        aGE.setGUI(aGUI);
    }
    
    public static void main(final String[] pArgs)
    {
        new Game();
    }
   
   
    
    } // Game
