package net.cheatingessentials.config.agce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;

import net.cheatingessentials.main.DynamicLogger;
import net.cheatingessentials.util.Utils;
import net.minecraft.client.Minecraft;

/**
 * Auto Generated Config for Collection-extended values that uses String values.
 * @author Kodehawa
 */
public class AGCEConfigurationSList {

	public volatile static AGCEConfigurationSList instance = new AGCEConfigurationSList() ;
	private String name;
	private File file;
	private String path;
	private Collection list;
	
	private AGCEConfigurationSList(){}

	/**
	 * Set all the values
	 * @param name
	 * @param path
	 * @param list
	 */
	public AGCEConfigurationSList(String name, String path, Collection list)
	{
		this.name = name;
		this.list = list;
		this.path = path;
		this.file = new File(Minecraft.getMinecraft().mcDataDir, "/config/Cheating Essentials/"+path);
		this.createFile();
		this.read();
	}
	
	private void createFile()
	{
		if(!file.exists())
		{
			file.getParentFile().mkdirs();
			try
			{
				file.createNewFile();
				create(file, list);
			}
			catch(Exception e)
			{}
		}
	}
	
	public void modify(File file, List list){
		create(file, list);
	}
	
	private void create(File file, Collection list){
		DynamicLogger.instance().writeLogWithPrefix("CMLS", "Writing (String) List config file to "+path, Level.INFO, 1);
		try
		{
			FileWriter filewriter = new FileWriter(file);
			BufferedWriter buffered = new BufferedWriter(filewriter);
			for(String s : (CopyOnWriteArrayList<String>)list){
				Utils.instance().removeDupes(list);
				buffered.write(s+"\r\n");
			}
			buffered.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private void read(){
		DynamicLogger.instance().writeLogWithPrefix("CMLS", "Reading (String) List config file: "+name, Level.INFO, 1);
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