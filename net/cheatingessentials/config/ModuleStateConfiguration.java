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
import net.cheatingessentials.client.modules.general.Category;
import net.cheatingessentials.client.modules.general.ModuleManager;
import net.cheatingessentials.main.DynamicLogger;
import net.minecraft.client.Minecraft;

public class ModuleStateConfiguration {

	private volatile static ModuleStateConfiguration instance = new ModuleStateConfiguration();
	private File moduleConfig = new File(Minecraft.getMinecraft().mcDataDir, "/config/Cheating Essentials/CEModuleStatus.txt");

	public ModuleStateConfiguration()
	{
		this.write();
	}
	
	public void writeToFile()
	{
		//DynamicLogger.instance().writeLogWithPrefix("CM-M", "Writing module config file...", Level.INFO, 1);
		try
		{
			FileWriter filewriter = new FileWriter(moduleConfig);
			BufferedWriter bufferedwriter = new BufferedWriter(filewriter);
			for(Module module : APIModule.instance().modules){
				Boolean s = module.isActive();
				if(module.cat != Category.NONE){
				    bufferedwriter.write(module.getModuleName().toLowerCase().replaceAll(" ", "") + ":" + s +"\r\n");
				}
		    }
			bufferedwriter.close();
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
	}
	
	@SuppressWarnings("resource")
	public void read()
	{
		DynamicLogger.instance().writeLogWithPrefix("CM-M", "Reading module config file...", Level.INFO, 1);
		try
		{
			FileInputStream inputstream = new FileInputStream(moduleConfig.getAbsolutePath());
			DataInputStream datastream = new DataInputStream(inputstream);
			BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(inputstream));
			String string;
			while((string = bufferedreader.readLine()) != null)
			{
				String line = string.trim();
				String[] string2 = string.split(":");
				String moduleName = string2[0];
				String booleanState = string2[1];
				for(Module module : APIModule.instance().modules)
				{
					if(module.cat != Category.NONE)
					{
						List<String> modules = Arrays.asList(module.getModuleName());
						for(int i = 0; i < modules.size(); ++i){
							if(moduleName.equalsIgnoreCase(modules.get(i).toLowerCase().replaceAll(" ", "")))
							{
								if(ConfigurationManager.universalDebug){
									System.out.println("Module: ".concat(module.getModuleName()).concat(" state: ")+booleanState);
								}
								if(booleanState.equalsIgnoreCase("true"))
								{
									try
									{
										module.forceEnable();
									}
									catch(Exception e)
									{
										e.printStackTrace();
									}
								}
							}
						}
					}
				}
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	private void write()
	{
		if(!moduleConfig.exists())
		{
			moduleConfig.getParentFile().mkdirs();
			try
			{
				moduleConfig.createNewFile();
				this.writeToFile();
			}
			catch(IOException e){}
		}
	}
	
	public static ModuleStateConfiguration instance(){
		return instance;
	}
}
