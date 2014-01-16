package cheatingessentials.mod.external.config.agce;

import java.io.File;

import cheatingessentials.mod.wrapper.Wrapper;

public class AGCEConfiguration
{

	protected Object obj;
	protected Object newobj;
	protected String name;
	protected File file;
	protected String path;
	
	protected void createFile()
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
	
	public void modify(String path, Object o)
	{
		this.path = path;
		this.file = new File(Wrapper.INSTANCE.minecraft().mcDataDir, "/config/Cheating Essentials/"+path);
		create(file, o);
	}
	
	protected void create(File file, Object obj){}
	
	@SuppressWarnings("unused")
	protected void read(){}

}
