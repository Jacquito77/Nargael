package pkg_items;
import java.util.HashMap;
import java.util.Set;
 
/**
 * Write a description of class ItemList here.
 * 
 * @author Baptiste HULIN 
 * @version (a version number or a date)
 */
public class ItemList
 {
    private HashMap<String, Item> aList ;
     
    /**
     * Constructeur
     */
    public ItemList()
    {
        this.aList = new HashMap<String, Item>();
    }
    
    /**
     * Procédure qui permet d'ajouter un item à la liste d'item
     */
    public void addItem(final String pNitem, final Item pItem)
    {
        this.aList.put(pNitem, pItem);
    }
    
    /**
     * Procédure qui retire l'item passé en paramètre à la liste d'items
     */
    public void itemTaken(final String pItem)
    {
        this.aList.remove(pItem);
    }   
    
    /**
     * Fonction booléenne indiquant si l'item est contenue dans la liste d'items ou non
     */public boolean hasItem(final String pI)
    {
        return aList.containsKey(pI);
    }
    
    /**
     *  Retourne l'item passé en paramètre
     */
    public Item getItem(final String pI)
    {
        return aList.get(pI);
    }
    
     /**
     * Retourne les objets disponibles
     */
    public String getItemString()
    {
        if (!aList.isEmpty())
        {
            String vItemString = "";
            Set<String> vKeys = aList.keySet();
        
            for(String vS : vKeys)
            {
                vItemString+= "There is a " + this.aList.get(vS).getItemName() + " \n";
            }

            return vItemString;
        }
        
        else
        {
            return "";
        }
    }
    
    /**
     * Retourne la HashMap de la classe
     */
    public HashMap<String, Item> getAllItems()
    {
        return this.aList;
    }
    
    /**
     * Fonction booléenne indiquant si la liste d'items est vide ou non
     */
    public boolean isEmpty()
    {
        return aList.isEmpty();
    }
}
