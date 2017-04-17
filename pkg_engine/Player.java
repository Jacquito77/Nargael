package pkg_engine;

import java.util.Stack;

import pkg_items.Item;
import pkg_items.ItemList;
import pkg_rooms.Room;
/**
 * Write a description of class Player here.
 * 
 * @author Baptiste HULIN 
 * @version (a version number or a date)
 */
public class Player
{
    private Room aCurrentRoom;
    private Stack<Room> aStack;
    private ItemList aInventory;
    private int aMaxWeight;

    /**
     * Constructeur par défaut de la classe Player
     */
    public Player()
    {
        this.aStack = new Stack<Room>();
        //         this.aItems = new HashMap<String, Item>();
        this.aInventory = new ItemList();
        this.aMaxWeight = 1000;
    }

    /**
     * Accesseur qui retourne la salle actuelle
     */
    public Room getCurrentRoom()
    {
        return this.aCurrentRoom;
    }

    /**
     * Méthode pour établir ce que vaut aCurrenRoom
     */public void setCurrentRoom(final Room pCurrentRoom)
    {
        this.aCurrentRoom = pCurrentRoom;
    }

    /**
     * Fonction permettant de savoir si la Stack est vide ou non
     */public boolean hasNoPreviousRoom()
    {
        return this.aStack.empty();
    }

    /**
     * Procédure permettant le déplacement en arrière
     */
    public void moveBack()
    {
        this.aCurrentRoom = this.aStack.pop();
    }

    /**
     * Accesseur de l'attribut de type Stack 
     */
    public Room getPreviousRoom()
    {
        if (this.aStack.empty())
            return null; 
        return this.aStack.peek();
    }

    /**
     * Procédure permettant d'ajouter la salle précédente à la Stack
     */public void addPreviousRoom(final Room pRoom)
    {
        this.aStack.push(pRoom);
    }

    /**
     * Procédure permettant d'effectuer le déplacement et l'ajout des 
     * salles traversées à la Stack
     */public void move(final Room pRoom)
    {
        this.aStack.push(this.aCurrentRoom);
        this.aCurrentRoom = pRoom;
    }

    /**
     * Ajoute un Item dans l'inventaire du joueur
     */
    public void addItemPlayer(final String pNitem, final Item pItem)
    {
        this.aInventory.addItem(pNitem, pItem);
    }

    /**
     * Retourne l'inventaire du joueur (ItemList)
     */
    public ItemList getInventory()
    {   
        return this.aInventory;
    }

    /**
     * Permet de fixer le poids max du joueur.
     * @param pMaxWeight Le nouveau poids max.
     */
    public void setMaxWeight(final int pMaxWeight)
    {
        this.aMaxWeight = pMaxWeight;
    }

    /**
     * Permet de retourner le poids que le joueur porte actuellement.
     * @return Le poids actuel que le joueur transporte.
     */
    public int getCurrentWeight()
    {
        int vWeight = 0;
        for (Item vItem : this.aInventory.getAllItems().values()) 
        {   
            vWeight += vItem.getWeight();
        }

        return vWeight; 
    }

    /**
     * Retourne le poids max que le joueur peut porter
     */
    public int getMaxWeight()
    {
        return this.aMaxWeight;
    }

    /**
     * Retourne la chaine de caractère des objets disponibles dans l'inventaire du joueur
     */
    public String getInventoryList()
    {
        if(!this.getInventory().isEmpty())
            return "Inventory: " + this.getInventory().getItemString();
        else
            return "You don't have any items in your inventory !";
    }
}

