package net.cheatingessentials.config.agce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

import net.cheatingessentials.main.DynamicLogger;
import net.cheatingessentials.util.ReflectionHelper;
import net.minecraft.client.Minecraft;

import org.apache.logging.log4j.Level;

/**
 * "Decomplied" name: "Auto Generated Cheating Essentials Configuration for Boolean values".
 * Generates a generic configuration file for boolean fields that needs configuration.
 * Configurable name, path and boolean value.
 * @author Kodehawa
 */
public class AGCEConfigurationBoolean {

	public volatile static AGCEConfigurationBoolean instance = new AGCEConfigurationBoolean();
	private String name;
	private String boolname;
	private String path;
	private File file;
	private boolean bool;
	public boolean newbool;
	
	private AGCEConfigurationBoolean(){}
	
	/**
	 * Set all the values.
	 * @param clazz
	 * @param name
	 * @param bool
	 * @param path
	 */
	public AGCEConfigurationBoolean(String showname, Class clazz, String name, Boolean bool, String path)
	{
		this.name = showname;
		this.boolname = name;
		this.bool = bool;
		this.path = path;
		this.file = new File(Minecraft.getMinecraft().mcDataDir, "/config/Cheating Essentials/"+path);
		this.createFile();
		this.read();
		ReflectionHelper.setStringFieldWW(clazz, null, name, newbool);
	}
	
	private void createFile(){
		if(!file.exists()){
			file.getParentFile().mkdirs();
			try
			{ 
				file.createNewFile();
				this.create(boolname, bool, path);
			}
			catch(Exception e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	private void create(String n, boolean b, String p)
	{
		DynamicLogger.instance().writeLogWithPrefix("CMB", "Creating Boolean config file: "+name, Level.INFO, 1);
		try
		{
			FileWriter filewriter = new FileWriter(file);
			BufferedWriter bufferedwriter = new BufferedWriter(filewriter);
			String s = String.valueOf(b);
			bufferedwriter.write(n+":" + s);
			bufferedwriter.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private void read()
	{
		DynamicLogger.instance().writeLogWithPrefix("CMB", "Reading boolean file: "+name, Level.INFO, 1);
		FileInputStream imputstream;
		try 
		{
			imputstream = new FileInputStream(file.getAbsolutePath());
			DataInputStream datastream = new DataInputStream(imputstream);
			BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(datastream));
			String value;
			while((value = bufferedreader.readLine()) != null){
				String line = value.trim();
				String[] values = line.split(":");
				String value1 = values[1];
				try{
					if(value1.equalsIgnoreCase("true") || value1.equalsIgnoreCase("false")){
						newbool = Boolean.parseBoolean(value1);
					}
					else{
						DynamicLogger.instance().writeLogWithPrefix("CMB", "Unable to recognize boolean value from file: "+bool, Level.WARN, 1);
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			
			bufferedreader.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}