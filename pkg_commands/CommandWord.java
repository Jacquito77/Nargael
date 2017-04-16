package pkg_commands; 
/**
 * Enumeration class CommandWord - write a description of the enum class here
 * 
 * @author Baptiste HULIN
 * @version (version number or date here)
 */
public enum CommandWord
{
    //GO("go"), QUIT("quit"), HELP("help"), UNKNOWN("?"), LOOK("look"), EAT("eat"), BACK("back"), TEST("test"), TAKE("take"), DROP("drop"), ITEMS("items"), TELEPORT("teleport"), SEARCH("search"), RANDOM("random");;
    GO("go"),
    QUIT("quit"),   
    HELP("help"),
	UNKNOWN("?"),  
 	LOOK("look"),   
 	EAT("eat"),   
 	BACK("back"),   
 	TEST("test"),   
	TAKE("take"),   
 	DROP("drop"),
	ITEMS("items"),  
  	TELEPORT("teleport"),   
  	RANDOM("random"), 
  	TALK("talk"),
  	GIVE("give"),
  	SEARCH("search"),
	SAVE("save");
	
 	private String aCommandString;
    
 
    /**
     * Constructeur de la classe avec une String passée en paramètre
     */
    CommandWord(final String pCommandString)
    {
        this.aCommandString = pCommandString;
    }

    /**
     *  Fonction qui retourne la String associée à la commande
     */
    public String toString()
    {
        return this.aCommandString;
    }
}
