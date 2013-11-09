package common.kodehawa.ce.config;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;

import net.minecraft.client.Minecraft;

import org.lwjgl.input.Keyboard;

import com.google.common.collect.Lists;
import common.kodehawa.ce.logger.DynamicLogger;
import common.kodehawa.ce.module.classes.BlockFinder;
import common.kodehawa.ce.module.classes.XRay;
import common.kodehawa.ce.module.core.AbstractModule;
import common.kodehawa.ce.module.man.ModuleManager;

/**
 * Class that loads / writes all the configurations in Cheating Essentials.
 * @author Kodehawa
 */

public class ConfigManager {

	private volatile static ConfigManager instance = new ConfigManager();
	private File mcdata = Minecraft.getMinecraft().mcDataDir;
	private String configPath = "/config/Cheating Essentials/";
	private File keybindConfig = new File(mcdata, configPath+"CEKeybindConfig.txt");
	private File blockESPConfig = new File(mcdata, configPath+"CEBlockESP.txt");
	private File xrayConfig = new File(mcdata, configPath+"CEXrayBlocks.txt");
	public CopyOnWriteArrayList<String> friends = new CopyOnWriteArrayList<String>();
	public CopyOnWriteArrayList<String> enemies = new CopyOnWriteArrayList<String>();
	public static boolean universalDebug;
	
	public ConfigManager() 
	{
		this.addDefaultFriends();
		new AGCEConfigurationBoolean("Debug Config", this.getClass(), "universalDebug", universalDebug, "CEDebugConfig.txt");
		new AGCEConfigurationSList("Friend List", "CEFriends.txt", friends);
		new AGCEConfigurationSList("Enemy List", "CEEnemies.txt", enemies);
		this.write();
		this.readKeybindConfig();
		this.readXrayConfig();
		this.readBlockESPConfig();
	}
	
	public void writeKeybindConfig()
	{
		DynamicLogger.instance().writeLogWithPrefix("CM", "Writing keybinding config file...", Level.INFO, 1);
		try
		{
			FileWriter filewriter = new FileWriter(keybindConfig);
			BufferedWriter bufferedwriter = new BufferedWriter(filewriter);
			for(AbstractModule module : ModuleManager.instance().avModules){
				String s = Keyboard.getKeyName(module.getKeybind());
			    bufferedwriter.write(module.getModuleName().toLowerCase().replaceAll(" ", "") + ":" + s +"\r\n");
		    }
			bufferedwriter.close();
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
	}
	
	public void readKeybindConfig()
	{
		try 
		{
			DynamicLogger.instance().writeLogWithPrefix("CM", "Reading Keybinding config file...", Level.INFO, 1);
			FileInputStream imputstream = new FileInputStream(keybindConfig.getAbsolutePath());
			DataInputStream datastream = new DataInputStream(imputstream);
			@SuppressWarnings("resource")
			BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(datastream));
			String key;
			while((key = bufferedreader.readLine()) != null){
				String line = key.trim();
				String[] string = line.split(":");
				String module1 = string[0];
				String keybinding = string[1].toUpperCase();
				for(AbstractModule module : ModuleManager.instance().avModules){
					//Add the modules to another List.
					List<String> modules = Arrays.asList(module.getModuleName());
					//Iterate into all modules.
					for(int i = 0; i < modules.size(); ++i){
						//See if the iterated module is the same than the one in the file
						if(module1.equalsIgnoreCase(modules.get(i).toLowerCase().replaceAll(" ", ""))){
							//If the module name in the list is the same than the declared in the file, set new keybinding
							module.setKeybinding(Keyboard.getKeyIndex(keybinding));
							if(universalDebug){
								DynamicLogger.instance().writeLog("[CM] Binded: "+module.getModuleName()+" | "+Keyboard.getKeyName(module.getKeybind()), Level.INFO); break;
							}
						}
					}
				}
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void writeXrayConfig(){
		DynamicLogger.instance().writeLogWithPrefix("CM", "Writing X-Ray config file...", Level.INFO, 1);
		try
		{
			FileWriter filewriter = new FileWriter(xrayConfig);
			BufferedWriter bufferedwriter = new BufferedWriter(filewriter);
			for(Integer i : XRay.xrayList2)
			{
				bufferedwriter.write(i+"\r\n");
			}
			bufferedwriter.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void readXrayConfig(){
		DynamicLogger.instance().writeLogWithPrefix("CM", "Reading X-Ray config file...", Level.INFO, 1);
		try 
		{
			FileInputStream inputstream = new FileInputStream(xrayConfig.getAbsolutePath());
			DataInputStream datastream = new DataInputStream(inputstream);
			BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(datastream));
			String value;
			while((value = bufferedreader.readLine()) != null)
			{
				Integer i1 = Integer.parseInt(value);
				XRay.xrayList2.add(i1);
			}
			bufferedreader.close();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void writeBlockESPConfig(){
		DynamicLogger.instance().writeLogWithPrefix("CECM", "Writing BlockESP config file...", Level.INFO, 1);
		try
		{
			FileWriter filewriter = new FileWriter(blockESPConfig);
			BufferedWriter bufferedwriter = new BufferedWriter(filewriter);
			for(Integer i : BlockFinder.espList)
			{
				bufferedwriter.write(i+"\r\n");
			}
			bufferedwriter.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void readBlockESPConfig(){
		DynamicLogger.instance().writeLogWithPrefix("CM", "Reading BlockESP config file...", Level.INFO, 1);
		try 
		{
			FileInputStream inputstream = new FileInputStream(blockESPConfig.getAbsolutePath());
			DataInputStream datastream = new DataInputStream(inputstream);
			BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(datastream));
			String value;
			while((value = bufferedreader.readLine()) != null)
			{
				Integer i1 = Integer.parseInt(value);
				BlockFinder.espList.add(i1);
			}
			bufferedreader.close();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

	private void addDefaultFriends()
	{
		friends.add("Kodehawa");
		friends.add("ReesZRB");
	}
	
	private void write()
	{
		if(!keybindConfig.exists())
		{ 
			keybindConfig.getParentFile().mkdirs();
			try { 
				keybindConfig.createNewFile(); 
			} 
			catch (IOException e) 
			{ 
				e.printStackTrace();
			}
			
			writeKeybindConfig();
		}
		
		if(!xrayConfig.exists())
		{
			xrayConfig.getParentFile().mkdirs();
			try
			{
				xrayConfig.createNewFile();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			writeXrayConfig();
		}
		
		if(!blockESPConfig.exists())
		{
			blockESPConfig.getParentFile().mkdirs();
			try
			{
				blockESPConfig.createNewFile();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			writeBlockESPConfig();
		}
	}
	
	public static ConfigManager instance()
	{
		return instance;
	}
}