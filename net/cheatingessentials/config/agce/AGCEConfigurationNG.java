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

public class AGCEConfigurationNG 
{
	
	public volatile static AGCEConfigurationNG instance = new AGCEConfigurationNG() ;
	private Object obj;
	private Object newobj;
	private String name;
	private File file;
	private String path;
	
	private AGCEConfigurationNG(){}
	
	public AGCEConfigurationNG(Class clazz, String name, String fieldName, String path, Object object){
		this.name = name;
		this.path = path;
		this.obj = object;
		this.file = new File(Minecraft.getMinecraft().mcDataDir, "/config/Cheating Essentials/"+path);
		this.createFile();
		this.read();
		ReflectionHelper.setStringFieldWW(clazz, null, fieldName, newobj);
	}
	
	private void createFile()
	{
		if(!file.exists())
		{
			file.getParentFile().mkdirs();
			try
			{
				file.createNewFile();
				create(file, obj);
			}
			catch(Exception e)
			{}
		}
	}
	
	public void modify(String path, Object o){
		this.path = path;
		this.file = new File(Minecraft.getMinecraft().mcDataDir, "/config/Cheating Essentials/"+path);
		create(file, o);
	}
	
	private void create(File file, Object obj){
		DynamicLogger.instance().writeLogWithPrefix("CMLG", "Writing (Generic) ["+obj.getClass().toString().replaceAll("class java.lang.", "")+"] config file to "+path, Level.INFO, 1);
		try
		{
			FileWriter filewriter = new FileWriter(file);
			BufferedWriter buffered = new BufferedWriter(filewriter);
			buffered.write(obj+"\r\n");
			buffered.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private void read(){
		DynamicLogger.instance().writeLogWithPrefix("CMLG", "Reading (Generic) ["+obj.getClass().toString().replaceAll("class java.lang.", "")+"] config file: "+name, Level.INFO, 1);
		try
		{
			FileInputStream imputstream = new FileInputStream(file.getAbsolutePath());
			DataInputStream datastream = new DataInputStream(imputstream);
			BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(datastream));
			String s;
			while((s = bufferedreader.readLine()) != null){
				if(obj instanceof Number)
				{
					if(obj instanceof Integer)
					{
						Integer i = Integer.parseInt(s);
						newobj = i;
					}
					if(obj instanceof Double)
					{
						Double d = Double.parseDouble(s);
						newobj = d;
					}
					if(obj instanceof Float)
					{
						Float f = Float.parseFloat(s);
						newobj = f;
					}
				}
				else
				{
					DynamicLogger.instance().writeLogWithPrefix("CMLG", "Unable to read non-numeric value on Numeric Configuration!", Level.WARN, 1);
				}
			}
			bufferedreader.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
