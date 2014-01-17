package cheatingessentials.mod.modulesystem.classes;

import org.lwjgl.input.Keyboard;

import cheatingessentials.api.module.Mod;
import cheatingessentials.mod.wrapper.ModuleCategories;
import cheatingessentials.mod.wrapper.Wrapper;

public class Fullbright extends Mod {

	@Override
	public String getName(){
		return "Fullbright";
	}
	
	@Override
	public String getDescription(){
		return "Makes the world brighter";
	}
	
	public ModuleCategories getCategory()
	{
		return ModuleCategories.WORLD;
	}
	
	public int getKeybind()
	{
		return Keyboard.KEY_F;
	}
	
	@Override
	public void onEnableMod(){
		float[] bright = Wrapper.INSTANCE.world().provider.lightBrightnessTable;
		for(int i = 0; i < bright.length; i++){
			bright[i] = 1.0F;
		}
	}
	
	@Override
	public void onDisableMod(){
		Wrapper.INSTANCE.world().provider.registerWorld(Wrapper.INSTANCE.world());
	}
}
