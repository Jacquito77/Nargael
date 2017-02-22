package pkg_items;

import pkg_rooms.Room;

/**
 * Write a description of class Beamer here.
 * 
 * @author Baptiste HULIN 
 * @version (a version number or a date)
 */
 
 
    public class Beamer extends Item
    {
        private Room aSavedRoom;
        private boolean aCharged;
        
        /**
         * Constructeur de la classe
         */
        public Beamer(final String pName,  final int pWeight, final String pDescription)
        {
            super(pName, pWeight, pDescription);
        }
        
        /**
         *  Fonction qui permet de sauvegarder la room avec le beamer
         */
        public Room getSavedRoom()
        {
            return aSavedRoom;
        }
        
        /**
         * Procédure qui permet de choisir quelle room va être sauvegardée
         */
        public void setSavedRoom(final Room pSavedRoom)
        {
            this.aSavedRoom = pSavedRoom;
        }
        
        /**
         * Fonction booléenne indiquant la charge du Beamer
         */
        public boolean isCharged()
        {
            return this.aCharged;
        }
        
        /**
         * Procédure qui permet de charger le Beamer au premier teleport entré
         */
        public void setCharged(final boolean pCharged)
        {
            this.aCharged = pCharged;
        }
        
    }
