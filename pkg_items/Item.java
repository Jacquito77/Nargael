package pkg_items;
/**
 * Write a description of class Item here.
 * 
 * @author Baptiste HULIN 
 * @version (a version number or a date)
 */
public class Item
{
    private String aName;
    private int aWeight;
    private String aDescription;
    private boolean aEatable;
    
   
    /**
     * Constructeur naturel de la classe Item
     */public Item(final String pName, final int pWeight, final String pDescription)
    {
       this.aName = pName;
       this.aWeight = pWeight;
       this.aDescription = pDescription;
    }
   
    public Item(final String pName, final int pWeight, final String pDescription, final boolean pEatable)
    {
       this.aName = pName;
       this.aWeight = pWeight;
       this.aDescription = pDescription;
       this.aEatable = pEatable;
    }
    
    /**
     * Accesseur qui permet de retourner le nom d'un Item
     */
    public String getItemName()
    {
        return this.aName;
    }
    
    /**
     * Accesseur qui permet de retourner le poids d'un Item
     */
    public int getWeight()
    {
        return this.aWeight;
    }
    
    /**
     * Accesseur qui permet de retourner la description d'un Item
     */
    public String getItemDescription()
    {
        return this.aDescription + "(" + this.aWeight + ")";
    }
    
    /**
     * Fonction booléenne qui indique si l'item est mangeable ou non
     */
    public boolean isEatable()
    {
        return this.aEatable;
    }
    
    /**
     * Procédure qui permet de choisir si l'item est mangeable ou non
     */
    public void setEatable (final boolean pEatable)
    {
        this.aEatable = pEatable;
    }
}
