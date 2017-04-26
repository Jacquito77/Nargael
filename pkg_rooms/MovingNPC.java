package pkg_rooms;

import java.util.HashMap;
import java.util.Set;

/**
 * Write a description of class MovingNPC here.
 * 
 * @author Baptiste HULIN 
 * @version (a version number or a date)
 */
public class MovingNPC extends NPC
{
    /**
     * Constructeur avec le nom du NPC hérité du paramètre de NPC
     */
    public MovingNPC (final String pName)
    {
        super(pName);
    }

    /**
     * Procédure qui permet au PNJ de se déplacer entre les salles adjacentes 
     */
    public void moveNPC()
    {
        HashMap<String, Room> vExits = this.getCurrentRoom().getExits();
        int vI = 0;
        int vO = 0;
        Room vOut = null;
        vO = RoomRandomizer.generateRandomNumber(0, RoomRandomizer.countRooms(vExits));
        Set<String> keys = vExits.keySet();
        for(String key : keys)
        {
            if(vI == vO)
                vOut = vExits.get(key);
            vI++;
        }
        if(vOut == null)
        {
            return;
        }
        super.getCurrentRoom().getNPCList().removeNPC(this);
        super.setCurrentRoom(vOut);
        super.getCurrentRoom().addNPCRoom(this.getNPCName(), this);
    }
}
