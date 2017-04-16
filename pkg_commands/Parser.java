package pkg_commands;
import java.util.StringTokenizer;

import pkg_engine.UserInterface;
/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This parser reads user input and tries to interpret it as an "Adventure"
 * command. Every time it is called it reads a line from the terminal and
 * tries to interpret the line as a two word command. It returns the command
 * as an object of class Command.
 *
 * The parser has a set of known command words. It checks user input against
 * the known commands, and if the input is not one of the known commands, it
 * returns a command object that is marked as an unknown command.
 * 
 * @author  Michael Kolling and David J. Barnes + D.Bureau
 * @version 2008.03.30 + 2013.09.15
 */
public class Parser 
{
    private CommandWords aValidCommands;  // (voir la classe CommandWords)
    private UserInterface aGUI;
    /**
     * Constructeur par defaut qui cree les 2 objets prevus pour les attributs
     */
    public Parser() 
    {
        this.aValidCommands = new CommandWords();

        // System.in designe le clavier, comme System.out designe l'ecran
    } // Parser()

    /**
     * @return The next command from the user.
     */
    public Command getCommand(String vInputLine) 
    {
        // contiendra toute la ligne tapee
        String vWord1 = null;
        String vWord2 = null;

        StringTokenizer vTokenizer = new StringTokenizer (vInputLine);

        if ( vTokenizer.hasMoreTokens() ) {
            vWord1 = vTokenizer.nextToken();      // recupere le premier mot
        } 
        if ( vTokenizer.hasMoreTokens())
            vWord2 = vTokenizer.nextToken();
        else
            vWord2= null;

        // Veifie si le premier mot est une commande connue. Si oui, cree une Command avec.
        // Sinon, cree une commande vide avec "null" (pour dire 'commande inconnue').
        CommandWord vCommandWord = this.aValidCommands.getCommandWord(vWord1);
        Command vCommand = this.aValidCommands.getCommand(vCommandWord);
        if(vCommand != null)
        {
        	vCommand.setWord(vWord1+" "+vWord2);
            vCommand.setSecondWord(vWord2);
        }
        return vCommand;

        //         if ( this.aValidCommands.isCommand( vWord1 ) ) {
        //             return new Command( aValidCommands.getCommandWord(vWord1), vWord2 );
        //         }
        //         else {
        //             return new Command( CommandWord.UNKNOWN, vWord2 ); 
        //         }
    } // getCommand()

    /**
     * Fait appel à la méthode getCommandList de CommandWords pour afficher la liste des commandes
     */
    public String showCommands()
    {
        return aValidCommands.getCommandList();
    }
} // Parser

