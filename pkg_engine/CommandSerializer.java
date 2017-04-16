package pkg_engine;


import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class CommandSerializer {
	
	static Object fromString(String str) {
	    XMLDecoder d = new XMLDecoder(new ByteArrayInputStream(str.getBytes()));
	    Object obj = d.readObject();
	    d.close();
	    return obj;
	}
	
	public void serialize(String save) throws IOException {
		FileOutputStream fos = new FileOutputStream("test/test.xml");
		XMLEncoder encoder = null;
		File f = new File("test/test.xml");
        if(!f.exists())
        {
            f.createNewFile();
        }
		
		try {
			
            encoder = new XMLEncoder(fos);
			SaveText sText = new SaveText();
			sText.setText(save);
			System.out.println("TEST "+sText.getText());
			encoder.writeObject(sText);
			encoder.flush();
		} finally {
			if (encoder != null) {
				
				encoder.close();
				}
		}
	}

}
