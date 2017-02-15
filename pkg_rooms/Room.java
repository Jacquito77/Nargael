package pkg_rooms; 
import java.util.HashMap;
import java.util.Set;

import pkg_items.ItemList;
import pkg_items.Item;
import pkg_engine.UserInterface;

/**
 * Classe Room faisant partie intégrante du projet Zuul
 */
public class Room
{
    private String aDescription;
    private HashMap<String, Room> aExits;
    //     private HashMap<String, Item> aItems;
    private NPC aNPC;
    private NPCList aNPCList;
    private ItemList aItemList;
    private String aImageName;
    //     private Item aItem;
    private String aName;
    private UserInterface aGUI;

    /**
     * Constructeur de la classe
     */
    public Room (final String pDescription, final String pImg )
    {
        this.aDescription = pDescription;
        this.aExits = new HashMap<String, Room>();
        //      aItems = new HashMap<String, Item>();
        this.aItemList = new ItemList();
        this.aNPCList = new NPCList();
        
        this.aImageName = pImg;

    }

    /**
     * Petite description
     */
    public String getShortDescription()
    {
        return aDescription;
    }

    /**
     * Retourne les sorties possibles des salles
     */
    public Room getExit(final String pDir)
    {
        return aExits.get(pDir); 
    }

    /**
     * Retourne les sorties disponibles
     */
    public String getExitString ()
    {
        String vString="Exits: ";
        Set<String> vKeys = aExits.keySet();
        for(String vS : vKeys)
        {
            vString+= " " + vS;
        }

        return vString;
    }

    /**
     * Initialise les sorties avec leur direction et leur arrivée
     */
    public void setExit (final String pDir, final Room pRoom)
    {
        aExits.put(pDir, pRoom);
    }//

    /**
     * Retourne le nom de l'image
     */

    public String getImageName()
    {
        return aImageName;
    }

    /**
     * Procédure ajoutant un ou des objets à une salle
     */public void addItemRoom(final String pI, final Item pItem)
    {
        this.aItemList.addItem(pI, pItem);
    }

    /**
     * Retourne l'ItemList de la Room
     */
    public ItemList getItemList()
    {   
        return this.aItemList;
    }
   
    /**
     * Fournie une description préçise des alentours
     */
    public String getLongDescription()
    {
        String vS = "You are " + this.aDescription + ".\n" + getExitString();
        if (!aItemList.isEmpty())
            vS +=  "\n" + this.getItemList().getItemString();
        
        if (!aNPCList.isEmpty())
            vS += "\n" + this.getNPCList().getNPCString();
            
        return vS;
    } // getDescription()

    /**
     * Retourne l'Item associé à la String entrée en paramètre
     */
    public Item getRoomItem(final String pItemName)
    {   
        return this.aItemList.getItem(pItemName);
    }

    /**
     * Procédure ajoutant un ou des NPC à une salle
     */
    public void addNPCRoom(final String pI, final NPC pNPC)
    {
        this.aNPCList.addNPC(pI, pNPC);
    }
    
     /**
     * Retourne la liste de NPC
     */
    public NPCList getNPCList()
    {
        return this.aNPCList;
    }
    
    /**
     * Retourne le NPC associé à la String passée en paramètre
     */
    public NPC getNPCRoom(final String pNPCName)
    {
        return this.aNPCList.getNPC(pNPCName);
    }
    
    /**
     * Retourne la HashMap des sorties de la Room
     */
    public HashMap<String, Room> getExits()
    {
        return this.aExits;
    }
    
    /**
     * Retourne la sortie correspondante de la salle passée en paramètre
     */
    public String getDoor(final Room pRoom)
    {
        String vDoor = null;
        for(String vS : aExits.keySet())
        {
            if(pRoom.equals(aExits.get(vS)));
            vDoor = vS;
        }

        return vDoor;
    }
} // Room

