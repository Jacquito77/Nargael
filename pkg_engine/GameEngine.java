package pkg_engine;
import java.util.HashMap;

import pkg_commands.Command;
import pkg_commands.Parser;
import pkg_items.Beamer;
import pkg_items.Item;
import pkg_rooms.MovingNPC;
import pkg_rooms.NPC;
import pkg_rooms.Room;
import pkg_rooms.TransporterRoom;
/**
 * Décrivez votre classe GameEngine ici.
 *
 * @author Baptiste HULIN
 * @version (un numéro de version ou une date)
 */
public class GameEngine
{
    public static Parser aParser;
    public static UserInterface aGUI;
    private static HashMap<String, Room> aList, aList1, aList2;
    private static Player aPlayer;
    //    private static Timer aTimeLimit;
    private static MovingNPC aJuju;
    private static int aLimit;
    public static boolean aTestMode;
    public static TransporterRoom aTR;

    private static Room aA;
    

    
    /**
     * Constructeur pour les objets de la classe GameEngine
     */
    public GameEngine()
    {
        setPlayer(new Player());
        aList = new HashMap<String, Room>();
//         aList1 = new HashMap<String, Room>();
//         aList2 = new HashMap<String, Room>();
        aParser = new Parser ();
        createRooms();
        
        aLimit = 60;
        
        Audio2 aAudio2 = new Audio2();

        new Thread() {
            public void run() {
                aAudio2.playLoop("assembly.wav");
            }
        }.start();
        
        aTestMode = false;
    }

     /**
     * Choix de l'interface du jeu et message de présentation du jeu
     */
    public void setGUI(final UserInterface pUI)
    {
        aGUI = pUI;
        printWelcome();
    }

    /**
     * Affiche un message de bienvenue au joueur
     */
    private void printWelcome()
    {
        aGUI.println ("Welcome to MorneFosse, may the force be with you !");
        aGUI.println ("Write 'help' if it's your first travel in this place!");
        aGUI.println ("Don't forget to complete your quest before the evening");
        aGUI.print(getPlayer().getCurrentRoom().getLongDescription());
        aGUI.showImage(getPlayer().getCurrentRoom().getImageName());
    } // affiche un message de bienvenue une seule fois au début

    /**
     * Procédure qui permet la création des différentes salles du jeu et leurs sorties
     */
    public void createRooms ()
    {

        //1 créer les 5 lieux ci-dessous
 
        Room vArea1001= new Room("at the Area1001","images/op1.png");
        Room vArea1002= new Room("at the Area1002","images/op2.jpg");
        Room vArea1003= new Room("at the Area1003","images/op3.png");
        Room vArea1004= new Room("at the Area1004","images/op4.png");
        Room vArea1005= new Room("at the Area1005","images/op5.png");
        Room vArea1006= new Room("at the Area1006","images/op6.png");
        Room vArea1007= new Room("at the Area1007","images/op7.png");
        Room vArea1008= new Room("at the Area1008","images/nora1.jpg");
        
        aA = vArea1001;
        
        Room vResidential_District= new Room("at the Residential District", "images/Res.jpeg");
        Room vOperating_Tower= new Room("in the Operating Tower (first floor)", "images/Op1.jpeg" ); 
        Room vOperating_Tower2ndf= new Room("in the Operating Tower (second floor)", "images/Op2.jpeg" );
        Room vOperating_Tower3rdf= new Room("in the Operating Tower (third floor)", "images/Op3.jpeg");
        Room vForge= new Room("in the Forge", "images/forge.jpeg");
        Room vTavern= new Room("in the Tavern", "images/tavern.jpeg" ); 
        Room vTraining_Field= new Room( "in the Training Field", "images/trainingf.jpeg");
        Room vSteel_Department= new Room ("in the Steel Department", "images/steeld.jpeg");
        Room vTannery = new Room ("in front of the Tannery", "images/tannery.jpg");
        Room vCommercial_District = new Room ("at the Commercial District", "images/commerc.jpeg");
        Room vCity_Center = new Room ("at the City Center", "images/cityc.jpeg");
        Room vWest_Gate = new Room ("at the West Gate", "images/westg.jpeg");
        Room vSouth_Gate = new TransporterRoom ("at the South Gate", "images/southg.jpg");
        Room vEast_Gate = new Room ("at the East Gate", "images/eastg.jpeg");
        Room vNorth_Gate = new Room ("at the North Gate", "images/northg.jpeg");

        //2 positionner les sorties pour créer le "réseau" de lieux
        // _pDir, pRoom

        vArea1001.setExit("north", vArea1002 );
        vArea1001.setExit("south", vArea1003 );
        vArea1001.setExit("west", vArea1004 );
        vArea1001.setExit("east", vArea1005 );
        vArea1001.setExit("down", vOperating_Tower3rdf );
        
        vArea1002.setExit("north", vArea1006);
        vArea1002.setExit("south", vArea1001);
        vArea1002.setExit("west", vArea1007);
        vArea1002.setExit("east", vArea1008);
        
        vArea1003.setExit("north", vArea1001 );
        vArea1003.setExit("south", vArea1004);
        vArea1003.setExit("west", vArea1005);
        vArea1003.setExit("east", vArea1006);
        
        vArea1004.setExit("north", vArea1003);
        vArea1004.setExit("south", vArea1005);
        vArea1004.setExit("west", vArea1006);
        vArea1004.setExit("east", vArea1001);
        
        vArea1005.setExit("north", vArea1004);
        vArea1005.setExit("south", vArea1006);
        vArea1005.setExit("west", vArea1001);
        vArea1005.setExit("east", vArea1003);
        
        vArea1006.setExit("north", vArea1005);
        vArea1006.setExit("south", vArea1002);
        vArea1006.setExit("west", vArea1003);
        vArea1006.setExit("east", vArea1004);
        
        vArea1007.setExit("north", vArea1008);
        vArea1007.setExit("south", vArea1008);
        vArea1007.setExit("west", vArea1008);
        vArea1007.setExit("east", vArea1002);
        
        vArea1008.setExit("north", vArea1007);
        vArea1008.setExit("south", vArea1007);
        vArea1008.setExit("west", vArea1002);
        vArea1008.setExit("east", vArea1007);
        
        vResidential_District.setExit("north", vNorth_Gate);
        vResidential_District.setExit("south", vOperating_Tower);
        vResidential_District.setExit("west", vCommercial_District);
        vResidential_District.setExit("east", vEast_Gate);

        vOperating_Tower.setExit("north",vResidential_District);
        vOperating_Tower.setExit("south",vForge);
        vOperating_Tower.setExit("west",vCity_Center);
        vOperating_Tower.setExit("east",vEast_Gate);
        vOperating_Tower.setExit("up",vOperating_Tower2ndf);

        vOperating_Tower2ndf.setExit("down",vOperating_Tower);
        vOperating_Tower2ndf.setExit("up",vOperating_Tower3rdf);

        vOperating_Tower3rdf.setExit("down", vOperating_Tower2ndf);
        vOperating_Tower3rdf.setExit("up",vArea1001);

        vForge.setExit("north",vOperating_Tower);
        vForge.setExit("south",vSouth_Gate);
        vForge.setExit("west",vTavern);
        vForge.setExit("east",vEast_Gate);

        vTavern.setExit("north",vCity_Center);
        vTavern.setExit("south",vSouth_Gate);
        vTavern.setExit("west",vTraining_Field);
        vTavern.setExit("east",vForge);

        vTraining_Field.setExit("north",vSteel_Department);
        vTraining_Field.setExit("south",vSouth_Gate);
        vTraining_Field.setExit("west",vWest_Gate);
        vTraining_Field.setExit("east",vTavern);

        vSteel_Department.setExit("north",vTannery);
        vSteel_Department.setExit("south",vTraining_Field);
        vSteel_Department.setExit("west",vWest_Gate);
        vSteel_Department.setExit("east",vCity_Center);

        vTannery.setExit("north",vNorth_Gate);
        vTannery.setExit("south",vSteel_Department);
        vTannery.setExit("west",vWest_Gate);
        vTannery.setExit("east",vCommercial_District);

        vCommercial_District.setExit("north",vNorth_Gate);
        vCommercial_District.setExit("south",vCity_Center);
        vCommercial_District.setExit("west",vTannery);
        vCommercial_District.setExit("east",vResidential_District);

        vCity_Center.setExit("north",vCommercial_District);
        vCity_Center.setExit("south",vTavern);
        vCity_Center.setExit("west",vSteel_Department);
        vCity_Center.setExit("east",vOperating_Tower);

        vWest_Gate.setExit("north",vTannery);
        vWest_Gate.setExit("south",vTraining_Field);
        vWest_Gate.setExit("west",vEast_Gate);
        vWest_Gate.setExit("east",vSteel_Department);

        vSouth_Gate.setExit("north",vTavern);
        vSouth_Gate.setExit("south",vNorth_Gate);
        vSouth_Gate.setExit("west",vTraining_Field);
        vSouth_Gate.setExit("east",vForge);

        vEast_Gate.setExit("north",vResidential_District);
        vEast_Gate.setExit("south",vForge);
        vEast_Gate.setExit("west",vOperating_Tower);
        vEast_Gate.setExit("east",vWest_Gate);

        vNorth_Gate.setExit("north",vSouth_Gate);
        vNorth_Gate.setExit("south",vCommercial_District);
        vNorth_Gate.setExit("west",vTannery);
        vNorth_Gate.setExit("east",vResidential_District);

        //3 initialiser le lieu courant

        GameEngine.getPlayer().setCurrentRoom(vResidential_District);

        //4 Liste les salles dans la HashMap
        aList.put("Residential District",vResidential_District);
        aList.put("Operating Tower (1st floor)",vOperating_Tower);
        aList.put("Operating Tower (2nd floor)",vOperating_Tower2ndf);
        aList.put("Operating Tower (3rd floor)",vOperating_Tower3rdf);
        aList.put("Forge",vForge);
        aList.put("Tavern",vTavern);
        aList.put("Training Field",vTraining_Field);
        aList.put("Steel Department",vSteel_Department);
        aList.put("Tannery",vTannery);
        aList.put("Commercial District",vCommercial_District);
        aList.put("City Center",vCity_Center);
        aList.put("West Gate",vWest_Gate);
        aList.put("South Gate",vSouth_Gate);
        aList.put("East Gate",vEast_Gate);
        aList.put("North Gate",vNorth_Gate);
        aList.put("Area1001",vArea1001);
        aList.put("Area1002",vArea1002);
        aList.put("Area1003",vArea1003);
        aList.put("Area1004",vArea1004);
        aList.put("Area1005",vArea1005);
        aList.put("Area1006",vArea1006);
        aList.put("Area1007",vArea1007);
        aList.put("Area1008",vArea1008);
        
        
        
//         aList1.put("Residential District",vResidential_District);
//         aList1.put("Operating Tower (1st floor)",vOperating_Tower);
//         aList1.put("Operating Tower (2nd floor)",vOperating_Tower2ndf);
//         aList1.put("Operating Tower (3rd floor)",vOperating_Tower3rdf);
//         aList1.put("Forge",vForge);
//         aList1.put("Tavern",vTavern);
//         aList1.put("Training Field",vTraining_Field);
//         aList1.put("Steel Department",vSteel_Department);
//         aList1.put("Tannery",vTannery);
//         aList1.put("Commercial District",vCommercial_District);
//         aList1.put("City Center",vCity_Center);
//         aList1.put("West Gate",vWest_Gate);
//         aList1.put("South Gate",vSouth_Gate);
//         aList1.put("East Gate",vEast_Gate);
//         aList1.put("North Gate",vNorth_Gate);
//         
//         aList2.put("Area1001",vArea1001);
//         aList2.put("Area1002",vArea1002);
//         aList2.put("Area1003",vArea1003);
//         aList2.put("Area1004",vArea1004);
//         aList2.put("Area1005",vArea1005);
//         aList2.put("Area1006",vArea1006);
//         aList2.put("Area1007",vArea1007);
//         aList2.put("Area1008",vArea1008);
        
        //5 ajoute les objets de chaque Room
        
        
        
        Item vSword = new Item("Sword", 360, "Badass sword forged by your dog", false);
        Item vIce_Cream = new Item("Ice Cream", 20, "Soooooo tasty !",true);
        
        Item vLeather = new Item("Leather Strip", 50, "A piece of leather, you should be able" +
                "to do something with it", false);
        Item vBurger = new Item("Burger", 30, "The biggest burger in the country", true);
        
        Item vArmory = new Item("Armory", 1200, "It's an armory, lol", false);
        Item vBeer = new Item("Beer", 50, "A big beer stein, like you love!", true);
        Item vMagicCookie = new Item("Magic_Cookie", 10, "A strange light shine from this cookie", true);
        Beamer vBeamer = new Beamer("Beamer", 50, "An item to teleport yourself");        
        Item vAxe = new Item("Axe", 450, "A short sharped and heavy black axe", false);
        Item vCertificate = new Item("Certificate", 1, "A certificate that attests the non-rarity of the leather", false);
        Item vKnob = new Item("Knob", 10, "A knob", false);
        Item vLeather2 = new Item("Leather", 30, "Leather", false);
        Item vFruit = new Item("Devil Fruit", 40, "A fruit with the evil's aura", true);
        Item vPotion = new Item("Aura Potion", 10, "Potion that will increase your Aura", true);
        Item vKey = new Item("Key", 3, "A key, maybe it could open some way to a treasure ?", false);
        Item vChest = new Item("Chest", 500, "A chest, try to find a key that would fit it !", false);
        Item vFeather = new Item("Feather", 1, "A feather, no one could say from wich bird it came from", false);
        Item vFragment = new Item("Sword Fragment", 40, "A sword fragment, collect them all to upgrade", false);
        Item vRing = new Item("Ring", 5, "A ring", false);
        Item vNecklace = new Item("Necklace", 7, "A necklace", false);
        Item vScroll = new Item("Ancient Scroll", 5, "An ancient scroll, you can't read a single line of it", false);
        Item vRune = new Item("Rune", 10, "An ancient rune, if you eat it, you", true);
        Item vTalisman = new Item("Talisman", 8, "A talisman", false);
        Item vStraw = new Item("Straw", 9999, "A stack of straw, maybe you could try to 'search' in it", false);
        Item vBracken = new Item("Bracken", 9999, "A bunch of bracken, maybe you could try to 'search' in it", false);
        Item vStone = new Item("Stone", 9999, "A stone, maybe you could try to 'search' behind it", false);
        Item vDrawer = new Item("Drawer", 9999, "An old drawer, maybe you could try to 'search' in it", false);
        
        
        
        NPC vBourgeois = new NPC("Bourgeois") {
            public boolean onGive (final Item pItem) 
            {
                if (pItem.getName().equals("Certificate")) {
                    aGUI.println ("[Bourgeois says:] This leather isn't rare at all, then, take it !"); 
                    aGUI.println ("The Bourgeois gave you Leather"); 
                    getPlayer().getInventory().addItem("Leather", vLeather2);
                    return true; 
                } else {
                    aGUI.println ("[Bourgeois says:] I won't let you my Leather, it is so rare "); 
                    return false; 
                }
            }
        };
        NPC vDurothan = new NPC("Durothan") {
            public boolean onGive (final Item pItem) 
            {
                if (pItem.getName() == "Fosse Burger") {
                    aGUI.println ("[Durothan says:] Mhhh... What a wonderful burger."); 
                    ///
                    return true; 
                }
                 if (pItem.getName() == "Knob") {
                    aGUI.println ("[Durothan says:] Mhhh... I will craft your Sword with the Blade I just crafted"); 
                    ///
                    aGUI.println ("YOU HAVE WON, CONGRATULATIONS");
                    aGUI.enable(false);
                    
                    return true; 
                }
                else {
                    aGUI.println ("[Durothan says:] I don't want this"); 
                    return false; 
                }
                
                
            }
        };
        NPC vTensen = new NPC("Tensen"){
            public void onTalk () 
            {
                aGUI.println("Tensen gave you a Certificate !");    
                getPlayer().getInventory().addItem("Certificate", vCertificate);         
            }
        };
        NPC vHina = new NPC("Hina"){
            public boolean onGive (final Item pItem) 
            {
                if (pItem.getName().equals("Leather") || pItem.getName().equals("Leather")) {
                    aGUI.println ("[Hina says:] Let me just... Okay, take this knob."); 
                    aGUI.println ("Hina gave you a Knob, go back and talk to Durothan to win the game !");
                    
                    getPlayer().getInventory().addItem("Knob", vKnob);
                    getPlayer().getInventory().itemTaken("Leather");
                    return true; 
                } else {
                    aGUI.println ("[Hina says:] I don't need this !"); 
                    return false; 
                }
            }
        };
        NPC vKoh = new NPC("Koh"){
            public boolean onGive (final Item pItem) 
            {
                if (pItem.getName().equals("Leather") || pItem.getName().equals("Leather")) {
                    aGUI.println ("[Hina says:] Let me just... Okay, take this knob."); 
                    aGUI.println ("Hina gave you a Knob, go back and talk to Durothan to win the game !");
                    
                    getPlayer().getInventory().addItem("Knob", vKnob);
                    getPlayer().getInventory().itemTaken("Leather");
                    return true; 
                } else {
                    aGUI.println ("[Koh says:] I don't need this !"); 
                    return false; 
                }
            }
        };
        
        NPC vTM = new NPC("TavernMan");
        
        NPC vRikio = new NPC("Rikio");
        NPC vIzumo = new NPC("Izumo");
        NPC vKusanagi = new NPC("Kusanagi");
        NPC vYujiro = new NPC("Yujiro");
        NPC vAndy = new NPC("Andy");
        NPC vMunakata = new NPC("Munakata");
        NPC vMikoto = new NPC("Mikoto");
        NPC vNagara = new NPC("Nagare");
        NPC vYukari = new NPC("Yukari");
        NPC vDouhan = new NPC("Douhan");
        NPC vIchigen = new NPC("Ichigen");
        
        aJuju = new MovingNPC("JUJU");

        aJuju.setCurrentRoom(vResidential_District);

        vDurothan.setText("[Durothan says:] Hello brave adventurer, you should seek for the guard Tensen at the Training Field, he will give you some Leather, go to the west.");
        vTensen.setText("[Tensen says:] We've just hunted these common monsters but a Bourgeois bought it, show the Bourgeois this certificate to prove this Leather is common.");
        vHina.setText("[Hina says:] Do you need some help ? I can craft you a Knob if you give me some Leather");
        vKoh.setText ("[Koh says:]I am useless");
        vBourgeois.setText("[Bourgeois says:] Hello, I won't let you my Leather, it is so rare!");
        aJuju.setText("[JUJU says:] Don't bother me i'm looking for money");
        vTM.setText("[TavernMan says:] You wanna eat some Beer ? Take it, today it's free !");

        vSteel_Department.addItemRoom("Beamer", vBeamer);
        vCommercial_District.addItemRoom("Burger", vBurger);
        vResidential_District.addItemRoom("Sword", vSword);
        vOperating_Tower2ndf.addItemRoom("Axe", vAxe);
        vOperating_Tower2ndf.addItemRoom("Straw", vStraw);
        vTavern.addItemRoom("Armory", vArmory);
        vTavern.addItemRoom("Beer", vBeer);
        vTraining_Field.addItemRoom("Magic_Cookie", vMagicCookie);

        vForge.addNPCRoom("Durothan", vDurothan);
        vTraining_Field.addNPCRoom("Tensen", vTensen);
        vTannery.addNPCRoom("Hina", vHina);
        vSteel_Department.addNPCRoom("Koh", vKoh);
        vResidential_District.addNPCRoom("JUJU", aJuju);
        vCommercial_District.addNPCRoom("Bourgeois", vBourgeois);
        vTavern.addNPCRoom("TavernMan", vTM);
    }

    /**
     * Procédure permettant d'exécuter la commande associée à la String entrée en paramètre
     */
    public static void interpretCommand(final String pCommandLine) 
    {
        aGUI.println(pCommandLine);
        Command vCommand = aParser.getCommand(pCommandLine);

        if (vCommand != null)
        {
            vCommand.execute(getPlayer());
        }
        else
        {
            aGUI.println("I don't know what you mean...");
        }

    }

    /**
     * Retourne la liste des Rooms 
     */
    public static HashMap<String, Room> getRooms()
    {
        return aList;
    }

     public HashMap<String, Room> getZone1()
    {
        return aList1;
    }
    
    public HashMap<String, Room> getZone2()
    {
        return aList2;
    }
    
    /**
     * Retourne le nombre de déplacements restants
     */
    public static int getLimit()
    {
        return aLimit;
    }
    
    /**
     * Permet de fixer le nombre de déplacements maximum que le joueur peut réaliser
     */
    public static void setLimit(final int pL)
    {
        aLimit = pL;
    }

    /**
     * Retourne le MovingNPC
     */
    public static MovingNPC getMovingNPC()
    {
        return aJuju;
    }
    
    public static Room getArea()
    {
        return aA;
    }

	public static Player getPlayer() {
		return aPlayer;
	}

	public static void setPlayer(Player aPlayer) {
		GameEngine.aPlayer = aPlayer;
	}
    
}
