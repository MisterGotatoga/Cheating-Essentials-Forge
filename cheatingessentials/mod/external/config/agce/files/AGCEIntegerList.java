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

public class AGCEIntegerList extends AGCEConfiguration 
{
	
	private Collection list;
	public volatile static AGCEIntegerList INSTANCE = new AGCEIntegerList();

	private AGCEIntegerList(){}
	
	public AGCEIntegerList(String name, String path, Collection list){
		this.name = name;
		this.path = path;
		this.list = list;
		this.file = new File(Minecraft.getMinecraft().mcDataDir, "/config/Cheating-Essentials/"+path);
		this.createFile();
		this.read();
	}
	
	protected void create(File file, Collection list){
		CheatingEssentials.INSTANCE.logger.info("Writing //Integer// List config file to "+path);
		try
		{
			FileWriter filewriter = new FileWriter(file);
			BufferedWriter buffered = new BufferedWriter(filewriter);
			for(Integer s : (CopyOnWriteArrayList<Integer>)list){
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
		CheatingEssentials.INSTANCE.logger.info("Reading //Integer// List config file: "+name);
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
