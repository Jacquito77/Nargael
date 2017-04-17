package pkg_engine;


import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class CommandSerializer {
	
	public void serialize(String save) throws IOException {
		File f = new File("test/test.xml");
		if(!f.exists())
		{
		    f.createNewFile();
		}

		FileOutputStream fos = new FileOutputStream("test/test.xml");
		XMLEncoder encoder = new XMLEncoder(fos);
		SaveText sText = new SaveText();
		sText.setText(save);
		System.out.println("TEST "+sText.getText());
		encoder.writeObject(sText);
		encoder.close();
		fos.close();
	}

}
