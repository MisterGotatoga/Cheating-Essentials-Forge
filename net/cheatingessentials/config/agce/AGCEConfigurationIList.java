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

import net.cheatingessentials.main.DynamicLogger;
import net.cheatingessentials.util.Utils;
import net.minecraft.client.Minecraft;

import org.apache.logging.log4j.Level;

/**
 * Auto Generated config file for Collection-extended (Integer) Lists.
 * @author Kodehawa
 */
public class AGCEConfigurationIList {

	public volatile static AGCEConfigurationIList instance = new AGCEConfigurationIList() ;
	private Collection list;
	private String name;
	private File file;
	private String path;
	
	private AGCEConfigurationIList(){}
	
	public AGCEConfigurationIList(String name, String path, Collection list){
		this.name = name;
		this.path = path;
		this.list = list;
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
	
	public void modify(String path, List list){
		this.path = path;
		this.file = new File(Minecraft.getMinecraft().mcDataDir, "/config/Cheating Essentials/"+path);
		create(file, list);
	}
	
	private void create(File file, Collection list){
		DynamicLogger.instance().writeLogWithPrefix("CMLI", "Writing (Integer) List config file to "+path, Level.INFO, 1);
		try
		{
			FileWriter filewriter = new FileWriter(file);
			BufferedWriter buffered = new BufferedWriter(filewriter);
			for(Integer s : (CopyOnWriteArrayList<Integer>)list){
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
		DynamicLogger.instance().writeLogWithPrefix("CMLI", "Reading (Integer) List config file: "+name, Level.INFO, 1);
		try
		{
			FileInputStream imputstream = new FileInputStream(file.getAbsolutePath());
			DataInputStream datastream = new DataInputStream(imputstream);
			BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(datastream));
			String s;
			while((s = bufferedreader.readLine()) != null){
				Integer i = Integer.parseInt(s);
				list.add(i);
			}
			bufferedreader.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}