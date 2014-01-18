package cheatingessentials.mod.external.config.agce.files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;

import net.minecraft.client.Minecraft;
import cheatingessentials.mod.external.config.agce.AGCEConfiguration;
import cheatingessentials.mod.main.CheatingEssentials;
import cheatingessentials.mod.util.CEUtility;

public class AGCEList extends AGCEConfiguration
{
	
	private Collection list;
	
	/**
	 * Set all the values
	 * @param name
	 * @param path
	 * @param list
	 */
	public AGCEList(String name, String path, Collection list)
	{
		this.name = name;
		this.list = list;
		this.path = path;
		this.file = new File(Minecraft.getMinecraft().mcDataDir, "/config/Cheating Essentials/"+path);
		this.createFile();
		this.read();
	}
	
	protected void create(File file, Collection list){
		CheatingEssentials.INSTANCE.logger.info("Writing //String// List config file to "+path);
		try
		{
			FileWriter filewriter = new FileWriter(file);
			BufferedWriter buffered = new BufferedWriter(filewriter);
			for(String s : (CopyOnWriteArrayList<String>)list){
				CEUtility.removeDupes(list);
				buffered.write(s+"\r\n");
			}
			buffered.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	protected void read(){
		CheatingEssentials.INSTANCE.logger.info("Reading //String// List config file: "+name);
		try
		{
			FileInputStream imputstream = new FileInputStream(file.getAbsolutePath());
			DataInputStream datastream = new DataInputStream(imputstream);
			BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(datastream));
			String s;
			while((s = bufferedreader.readLine()) != null){
				list.add(s.toLowerCase().trim());
			}
			bufferedreader.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
