package net.cheatingessentials.config;

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
import java.util.logging.Level;

import net.cheatingessentials.api.APIModule;
import net.cheatingessentials.api.Module;
import net.cheatingessentials.client.modules.general.ModuleManager;
import net.cheatingessentials.main.DynamicLogger;
import net.minecraft.client.Minecraft;

import org.lwjgl.input.Keyboard;

public class KeybindConfiguration {

	private volatile static KeybindConfiguration instance = new KeybindConfiguration();
	private File keybindConfig = new File(Minecraft.getMinecraft().mcDataDir, "/config/Cheating Essentials/CEKeybindConfig.txt");
	
	public KeybindConfiguration(){
		this.write();
		this.readKeybindConfig();
	}
	
	public void writeKeybindConfig()
	{
		DynamicLogger.instance().writeLogWithPrefix("CM", "Writing keybinding config file...", Level.INFO, 1);
		try
		{
			FileWriter filewriter = new FileWriter(keybindConfig);
			BufferedWriter bufferedwriter = new BufferedWriter(filewriter);
			for(Module module : APIModule.instance().modules){
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
				for(Module module : APIModule.instance().modules){
					//Add the modules to another List.
					List<String> modules = Arrays.asList(module.getModuleName());
					//Iterate into all modules.
					for(int i = 0; i < modules.size(); ++i){
						//See if the iterated module is the same than the one in the file
						if(module1.equalsIgnoreCase(modules.get(i).toLowerCase().replaceAll(" ", ""))){
							//If the module name in the list is the same than the declared in the file, set new keybinding
							module.setKeybinding(Keyboard.getKeyIndex(keybinding));
							if(ConfigurationManager.universalDebug){
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
	
	private void write()
	{
		if(!keybindConfig.exists())
		{ 
			keybindConfig.getParentFile().mkdirs();
			try { 
				keybindConfig.createNewFile(); 
				writeKeybindConfig();
			} 
			catch (IOException e){}
		}
	}
	
	public static KeybindConfiguration instance(){
		return instance;
	}
}
