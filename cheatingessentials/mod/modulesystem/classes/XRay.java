package cheatingessentials.mod.modulesystem.classes;

import java.lang.reflect.Field;
import java.util.concurrent.CopyOnWriteArrayList;

import org.lwjgl.input.Keyboard;

import net.minecraft.block.Block;
import cheatingessentials.api.module.APICEMod;
import cheatingessentials.api.module.Mod;
import cheatingessentials.mod.util.CEUtility;
import cheatingessentials.mod.wrapper.ModuleCategories;
import cheatingessentials.mod.wrapper.Wrapper;

public class XRay extends Mod
{
	public static CopyOnWriteArrayList<String> xrayList2 = new CopyOnWriteArrayList<String>();
	
	public XRay() 
	{
		xrayList2.add("coal_ore");
		xrayList2.add("iron_ore");
		xrayList2.add("diamond_ore");
		xrayList2.add("emerald_ore");
		xrayList2.add("gold_ore");
		xrayList2.add("lapis_ore");
		xrayList2.add("redstone_ore");
	}

	@Override
	public String getName()
	{
		return "X-Ray";
	}
	
	@Override
	public void onEnableMod()
	{
		if(!APICEMod.INSTANCE.call(Fullbright.class).isActive())
		{
			float[] bright = Wrapper.INSTANCE.world().provider.lightBrightnessTable;
			for(int i = 0; i < bright.length; i++){
				bright[i] = 1.0F;
			}
		}
		rerender();
		try
		{
			Field field = Block.class.getDeclaredField("enabled");
			if(field != null){
				field.setAccessible(true);
				field.setBoolean(null, true);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		addDefaultList();
	}
	
	public ModuleCategories getCategory()
	{
		return ModuleCategories.WORLD;
	}

	public int getKeybind()
	{
		return Keyboard.KEY_X;
	}
	
	@Override
	public void onDisableMod()
	{
		if(!APICEMod.INSTANCE.call(Fullbright.class).isActive())
		{
			Wrapper.INSTANCE.world().provider.registerWorld(Wrapper.INSTANCE.world());
		}
		rerender();
		try
		{
			Field field = Block.class.getDeclaredField("enabled");
			if(field != null){
				field.setAccessible(true);
				field.setBoolean(null, false);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public String showHelp(){
		return "Shows the hidden ores :D";
	}
	
	public static void addDefaultList()
	{
		CEUtility.removeDupes(xrayList2);
		try
		{
			Field field = Block.class.getDeclaredField("xrayList");
			field.setAccessible(true);
			CopyOnWriteArrayList<String> xray = (CopyOnWriteArrayList<String>) field.get(null);
			for(String i : xrayList2)
			{
				CEUtility.removeDupes(xray);
				xray.add(i);
			}
		} 
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void removeDefaultList()
	{
		CEUtility.removeDupes(xrayList2);
		try
		{
			Field field = Block.class.getDeclaredField("xrayList");
			field.setAccessible(true);
			CopyOnWriteArrayList<String> xray = (CopyOnWriteArrayList<String>) field.get(null);
			for(String i : xrayList2)
			{
				xray.remove(xrayList2.indexOf((String)i)); break;
			}
		} 
		catch (Exception e){
			e.printStackTrace();
		}
	}

	private void rerender()
	{
		int x = (int) Wrapper.INSTANCE.player().posX;
		int y = (int) Wrapper.INSTANCE.player().posY;
		int z = (int) Wrapper.INSTANCE.player().posZ;
		Wrapper.INSTANCE.minecraft().renderGlobal.markBlocksForUpdate(x - 200, y - 200, z - 200, x + 200, y + 200, z + 200);
	}
}