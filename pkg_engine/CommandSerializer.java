package pkg_engine;

import pkg_rooms.TransporterRoom;  
import pkg_commands.Command;  
import pkg_commands.Parser; 
import pkg_items.Item;
import pkg_items.Beamer;
import pkg_rooms.NPC;
import pkg_rooms.NPCList;
import pkg_rooms.MovingNPC;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class CommandSerializer {

	public static void serialize(Object item) throws IOException {
		XMLEncoder encoder = null;
		File f = new File("test/test.xml");
        if(!f.exists())
        {
            f.createNewFile();
        }
		
		try {
			encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("test/test.xml")));
			encoder.writeObject(item);
			encoder.flush();
		} catch (final java.io.IOException e) {
			e.printStackTrace();
		} finally {
			if (encoder != null) {
				encoder.close();
			}
		}
	}

}