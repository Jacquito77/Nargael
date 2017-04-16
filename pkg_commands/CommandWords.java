package pkg_commands; 
import java.util.HashMap;
 
/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class holds an enumeration table of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kolling and David J. Barnes + D.Bureau
 * @version 2008.03.30 + 2013.09.15
 */
public class CommandWords
{
    // tableau constant qui contient tous les mots de commande valides
    private HashMap<String, CommandWord> aValidCommands;
    private HashMap<CommandWord, Command> aCommands;
    
    /**
     * Constructeur par defaut
     */
    public CommandWords()
    {
        aValidCommands = new HashMap<String, CommandWord>();
        aCommands = new HashMap<CommandWord, Command>();
        for(CommandWord vCommand : CommandWord.values()) 
        {
            if(vCommand != CommandWord.UNKNOWN)
            {
                aValidCommands.put(vCommand.toString(), vCommand);
            }
        }
        
        this.aCommands.put(CommandWord.GO, new GoCommand());
        this.aCommands.put(CommandWord.HELP , new HelpCommand());
        this.aCommands.put(CommandWord.QUIT, new QuitCommand());
        this.aCommands.put(CommandWord.BACK, new BackCommand());
        this.aCommands.put(CommandWord.LOOK, new LookCommand());
        this.aCommands.put(CommandWord.EAT, new EatCommand());
        this.aCommands.put(CommandWord.TEST, new TestCommand());
        this.aCommands.put(CommandWord.TAKE, new TakeCommand());
        this.aCommands.put(CommandWord.DROP, new DropCommand());
        this.aCommands.put(CommandWord.ITEMS, new ItemsCommand());
        this.aCommands.put(CommandWord.TELEPORT, new TeleportCommand());
        this.aCommands.put(CommandWord.RANDOM, new RandomCommand());
        this.aCommands.put(CommandWord.TALK, new TalkCommand());
        this.aCommands.put(CommandWord.SEARCH, new SearchCommand());
        this.aCommands.put(CommandWord.GIVE, new GiveCommand()); 
        this.aCommands.put(CommandWord.SAVE, new SaveCommand("")); 
    } // CommandWords()

    /**
     * Verifie si une String donnee fait partie des commandes valides. 
     * @param pString la String a tester
     * @return true si pString est une comande valide, false sinon
     */
    public boolean isCommand( final String pString )
    {
       return aValidCommands.containsKey(pString);
    } // isCommand()
    
    /**
     * Permet d'obtenir la liste des commandes
     * Retourne chaque commande supplémentaire ajoutée
     */
    public String getCommandList()
    {
        String vString = "";
        
        for(String command : aValidCommands.keySet())
        {
            vString += command + " ";
        }
        return vString;
    }
    
    public CommandWord getCommandWord(final String pCommandW)
    {
        CommandWord vCommand = aValidCommands.get(pCommandW);
        if(vCommand != null)
        {
            return vCommand;
        }
        else
        {
            return CommandWord.UNKNOWN;
        }
    }
    
    public Command getCommand(final CommandWord pCommandWord)
    {
        Command vCommand = this.aCommands.get(pCommandWord);
        return vCommand;
    }
} // CommandWords
