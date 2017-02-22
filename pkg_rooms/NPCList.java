package pkg_rooms;
import java.util.HashMap;
import java.util.Set;
 
/**
 * Write a description of class ItemList here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NPCList
 {
    private HashMap<String, NPC> aNPCList ;
     
    /**
     * Constructeur
     */
    public NPCList()
    {
        this.aNPCList = new HashMap<String, NPC>();
    }
    
     /**
     * Ajoute un NPC à la HashMap
     */
    public void addNPC(final String pName, final NPC pNPC)
    {
        this.aNPCList.put(pName, pNPC);
    }
    
    /**
     * Retire le NPC associée à la String passée en paramètre de la HashMap
     */
    public boolean hasNPC(final String pI)
    {
        return aNPCList.containsKey(pI);
    }
    
    
    /**
     * Vérifie si le NPC est présent dans la liste
     */
    public NPC getNPC(final String pI)
    {
        return aNPCList.get(pI);
    }
    
    /**
     * Retourne les NPC disponibles
     */
    public String getNPCString()
    {
        if (!aNPCList.isEmpty())
        {
            String vNPCString = "";
            Set<String> vKeys = aNPCList.keySet();

            for(String vS : vKeys)
            {
                vNPCString+= "There is NPC " + this.aNPCList.get(vS).getNPCName() + " here" + "\n";
            }

            return vNPCString;
        }

        else
        {
            return "";
        }
    }
    
    /**
     * Retourne la HashMap de NPC
     */
    public HashMap<String, NPC> getNPCList()
    {
        return this.aNPCList;
    }
    
    /**
     * Vérifie si la liste de NPC est vide ou non
     */
    public boolean isEmpty()
    {
        return aNPCList.isEmpty();
    }
    
    /**
     * Procédure qui supprime un NPC de la liste des NPC
     */
    public void removeNPC(final NPC pNPC)
    {
        this.aNPCList.remove(pNPC.getNPCName());
    }
}