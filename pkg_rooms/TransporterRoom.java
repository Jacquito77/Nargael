package pkg_rooms;

import pkg_engine.GameEngine;

/**
 * Write a description of class TransporterRoom here.
 * 
 * @author Baptiste HULIN 
 * @version (a version number or a date)
 */
public class TransporterRoom extends Room
{
    /**
     * Constructeur
     */
    public TransporterRoom(final String pDescription, final String pImage)
    {
        super(pDescription, pImage);
    }
   
     /**
     * Retourne une Room aléatoire
     */
    @Override
    public Room getExit(final String pDirection)
    {
        RoomRandomizer vRandom = new RoomRandomizer(GameEngine.getRooms());
        return vRandom.nextRoom();
    }
    
    /**
     * MÃ©thode permettant de fixer une Room pour la commande alea.
     */
    public void setSavedRoom(final String pString)
    {
    }


}
