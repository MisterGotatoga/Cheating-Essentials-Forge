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
import java.util.logging.Level;

import net.minecraft.client.Minecraft;

import common.kodehawa.ce.logger.DynamicLogger;
import common.kodehawa.ce.module.core.AbstractModule;
import common.kodehawa.ce.module.man.ModuleManager;

public class ModuleStateConfiguration {

	private volatile static ModuleStateConfiguration instance = new ModuleStateConfiguration();
	private File moduleConfig = new File(Minecraft.getMinecraft().mcDataDir, "/config/Cheating Essentials/CEModuleStatus.txt");

	public ModuleStateConfiguration()
	{
		this.write();
	}
	
	public void writeToFile()
	{
		DynamicLogger.instance().writeLogWithPrefix("CM-M", "Writing module config file...", Level.INFO, 1);
		try
		{
			FileWriter filewriter = new FileWriter(moduleConfig);
			BufferedWriter bufferedwriter = new BufferedWriter(filewriter);
			for(AbstractModule module : ModuleManager.instance().avModules){
				Boolean s = module.isActive();
			    bufferedwriter.write(module.getModuleName().toLowerCase().replaceAll(" ", "") + ":" + s +"\r\n");
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
				for(AbstractModule module : ModuleManager.instance().avModules)
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
