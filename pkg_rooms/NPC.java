package pkg_rooms;

import java.util.HashMap;
import java.util.Set;
import pkg_rooms.Room;
import pkg_items.ItemList;
import pkg_items.Item;
import pkg_engine.GameEngine; 

/**
 * Write a description of class Character here.
 * 
 * @author Baptiste HULIN 
 * @version (a version number or a date)
 */
public class NPC
{
    private Room aCurrentRoom;
    private ItemList aNPCInventory;
    private String aText;
    private String aNPCName;

    /**
     * Constructeur de la classe qui permet de crÃ©Ã©e un PNJ
     */
    public NPC (final String pNPCName)
    {
        this.aNPCName = pNPCName;
        this.aNPCInventory = new ItemList();
    }

    /**
     * Change la salle actuelle oÃ¹ le PNJ se trouve
     */
    public void setCurrentRoom(final Room pCurrentRoom)
    {
        this.aCurrentRoom = pCurrentRoom;
    }

    /**
     * Retourne la salle actuelle du joueur
     */
    public Room getCurrentRoom()
    {
        return this.aCurrentRoom;
    }

    /**
     * Ajoute un item dans l'inventaire du PNJ
     */
    public void ajoutItemNPC(final String pNomItem, final Item pItem){
        this.aNPCInventory.addItem(pNomItem, pItem);
    }

    /**
     * Retourne la HashMap des items du PNJ
     */
    public ItemList getAllItemsPNJ(){
        return this.aNPCInventory;
    }

    /**
     * Retourne le texte du PNJ
     */
    public String getText()
    {
        return this.aText;
    }
    
    /**
     * * Retourne le nom du PNJ
     */
    public String getNPCName()
    {
        return this.aNPCName;
    }
    
    /**
     * Modifie le texte du PNJ
     */
    public void setText(final String pText){
        aText = pText;
    }
    
    /**
     * Fonction redéfinie dans GameEngine pour chacun des NPC qui assure le don d'items
     */
    public boolean onGive (final Item pItem) {
        GameEngine.aGUI.println ("[" + this.getNPCName() + "] : I don't want your item."); 
        return false; 
    }
    
    /**
     * Procédure redéfinie dans GameEngine pour chacun des NPC qui assure les évènements lié à la discussion avec le NPC
     */
    public void onTalk () {}
}
