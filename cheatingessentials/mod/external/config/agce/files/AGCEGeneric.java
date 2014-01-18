package cheatingessentials.mod.external.config.agce.files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

import net.minecraft.client.Minecraft;
import cheatingessentials.mod.external.config.agce.AGCEConfiguration;
import cheatingessentials.mod.main.CheatingEssentials;
import cheatingessentials.mod.util.reflect.ReflectionHelper;

public class AGCEGeneric extends AGCEConfiguration
{
	
	public AGCEGeneric(Class clazz, String name, String fieldName, String path, Object object)
	{
		this.name = name;
		this.path = path;
		this.obj = object;
		this.file = new File(Minecraft.getMinecraft().mcDataDir, "/config/Cheating Essentials/"+path);
		this.createFile();
		this.read();
		ReflectionHelper.setStringFieldWW(clazz, null, fieldName, newobj);
	}
	
	@Override
	protected void create(File file, Object obj)
	{
		CheatingEssentials.INSTANCE.logger.info("Writing //Generic// ["+obj.getClass().toString().replaceAll("class java.lang.", "")+"] config file to "+path);
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
	 
	@Override
	protected void read()
    {
		CheatingEssentials.INSTANCE.logger.info("Reading //Generic// ["+obj.getClass().toString().replaceAll("class java.lang.", "")+"] config file: "+name);
		try
		{
			FileInputStream imputstream = new FileInputStream(file.getAbsolutePath());
			DataInputStream datastream = new DataInputStream(imputstream);
			BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(datastream));
			String s;
			while((s = bufferedreader.readLine()) != null)
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
				
				if(obj instanceof String)
				{
					newobj = s;
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
