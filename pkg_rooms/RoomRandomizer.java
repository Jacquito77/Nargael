package pkg_rooms;
import java.util.HashMap;
import java.util.Set;
import java.util.Random;

/**
 * Write a description of class RoomRandomizer here.
 * 
 * @author Baptiste HULIN 
 * @version (a version number or a date)
 */
public class RoomRandomizer
{
    private static Long seed = null;
    private Room[] aTabRoom;
    private Random aRandom;
    
    /**
     * Constructeur
     */
    public RoomRandomizer (final HashMap <String, Room> pListRoom)
    {
        if (seed == null)
        this.aRandom = new Random();
        else
        this.aRandom = new Random(seed);
        this.aTabRoom = new Room [pListRoom.size()];
        int vI = 0;
        
        for (String vS : pListRoom.keySet())
        {
            this.aTabRoom[vI] = pListRoom.get(vS);
            vI += 1;
        }
    }
    
    /**
     * Retourne une salle correspondant au numéro de la salle dans le tableau de salles par rapport au nombre généré aléatoirement
     */public Room nextRoom()
    {
        if (seed != null)
        this.aRandom = new Random(seed);
        return this.aTabRoom[aRandom.nextInt(this.aTabRoom.length)];
    }
    
    /**
     *  Retourne le numéro de la suite
     */
    public static void setSeed(final Long pSeed)
    {
        RoomRandomizer.seed = pSeed;
    }
    
    /**
     * Genère un nombre aléatoire entier entre vMin et vMax.
     */
    public static int generateRandomNumber(int vMin, int vMax)
    {
        if(vMax <= vMin)
        {
            return 0;
        }
        Random vRand = new Random();

        // Ligne trouvée sur Internet, mais comprise et apprise !
        return vRand.nextInt(vMax - vMin + 1) + vMin;
    }
    
     /**
     * Compte la liste des salles.
     */
    public static int countRooms(final HashMap<String,Room> pRooms)
    {
        int vSize = 0;

        Set<String> keys = pRooms.keySet();

        for(String key : keys)
        {
            vSize++;
        }

        return vSize;
    }
}
