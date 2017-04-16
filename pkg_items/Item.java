package pkg_items;
/**
 * Write a description of class Item here.
 * 
 * @author Baptiste HULIN 
 * @version (a version number or a date)
 */
public class Item
{
    private String name;
    public void setName(String name) {
		this.name = name;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private int weight;
    private String description;
    private boolean eatable;
    
    public Item(){
    	this.name = "";
        this.weight = 0;
        this.description = "";
    }
   
    /**
     * Constructeur naturel de la classe Item
     */public Item(final String pName, final int pWeight, final String pDescription)
    {
       this.name = pName;
       this.weight = pWeight;
       this.description = pDescription;
    }
   
    public Item(final String pName, final int pWeight, final String pDescription, final boolean pEatable)
    {
       this.name = pName;
       this.weight = pWeight;
       this.description = pDescription;
       this.eatable = pEatable;
    }
    
    /**
     * Accesseur qui permet de retourner le nom d'un Item
     */
    public String getName()
    {
        return this.name;
    }
    
    /**
     * Accesseur qui permet de retourner le poids d'un Item
     */
    public int getWeight()
    {
        return this.weight;
    }
    
    /**
     * Accesseur qui permet de retourner la description d'un Item
     */
    public String getDescription()
    {
        return this.description + "(" + this.weight + ")";
    }
    
    /**
     * Fonction booléenne qui indique si l'item est mangeable ou non
     */
    public boolean getEatable()
    {
        return this.eatable;
    }
    
    /**
     * Procédure qui permet de choisir si l'item est mangeable ou non
     */
    public void setEatable (final boolean pEatable)
    {
        this.eatable = pEatable;
    }
}
