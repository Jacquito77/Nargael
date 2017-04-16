package pkg_commands;
 import pkg_engine.Player;
/**
 * Abstract class AbstractCommand - write a description of the class here
 * 
 * @author Baptiste HULIN
 * @version (version number or date here)
 */
public abstract class Command
{

    //private CommandWord aCommandWord;
    private String aSecondWord;
    private String aWord;

    /** 
     * Initialise les mots de commandes, à savoir le premier et le deuxième 
     */
    public Command ()
    {
    } // Command (pCommandWord, pSecondWord)

//     /**
//      * Retourne le premier mot de commande
//      */
//     public CommandWord getCommandWord()
//     {
//         return this.aCommandWord;
// 
//     } // getCommandWord

    /**
     * Retourne le second mot de commande 
     */
    public String getSecondWord()
    {
        return this.aSecondWord;
    } // getSecondWord()

    public void setSecondWord(final String pSecondWord)
    {
        this.aSecondWord = pSecondWord;
    }

    /**
     * Permet de savoir si il existe ou non un second mot de commande
     */
    public boolean hasSecondWord ()
    {
        return (this.aSecondWord!= null);
    } // hasSecondWord
    // 
    //     /**
    //      * Retourne l'abscence de mot de commande
    //      */
    //     public boolean isUnknown ()
    //     {
    //         return (this.aCommandWord== CommandWord.UNKNOWN);   
    // 
    //     } // CommandWord isUnknown

    public abstract boolean execute(Player pPlayer)
    ;

	public String getWord() {
		return aWord;
	}

	public void setWord(String vWord1) {
		String vWord = null;
		this.aWord = vWord;
	}


}
