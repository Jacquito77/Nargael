package pkg_commands;

import pkg_engine.Player;
import pkg_engine.GameEngine;
import pkg_engine.Audio2;
import pkg_engine.CommandSerializer;

import java.io.IOException;
import java.util.Scanner;

/**
 * Write a description of class QuitCommand here.
 * 
 * @author Baptiste HULIN 
 * @version (a version number or a date)
 */

public class SaveCommand extends Command {
	 private String save;

	    SaveCommand(String save)
	    {
	        this.save = save;
	    }
	    

@Override public boolean execute(final Player pPlayer)
{
      CommandSerializer seri = new CommandSerializer();
      try {
		seri.serialize(save);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    return false;
}

}
