package common.kodehawa.ce.module.core;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.profiler.Profiler;
import net.minecraftforge.common.MinecraftForge;

import org.apache.commons.lang3.StringUtils;
import org.lwjgl.input.Keyboard;

import common.kodehawa.ce.event.Event;
import common.kodehawa.ce.event.EventHandler;
import common.kodehawa.ce.event.Listener;
import common.kodehawa.ce.event.events.EventRender;
import common.kodehawa.ce.event.events.EventTick;
import common.kodehawa.ce.main.CheatingEssentials;
import common.kodehawa.ce.module.enums.Category;
import common.kodehawa.ce.module.man.ModuleManager;

public abstract class AbstractModule implements Listener {

	public String moduleName, moduleVersion, moduleAuthor, help = "NULL_HELP_REACHED";
	public int keybinding = Keyboard.KEY_NONE;
	public Category cat;
	private boolean state, forgeEvt, tick, render;

	public AbstractModule(Category category){
		cat = category;
	}
	
	public String getModuleName(){
		return (moduleName == null ? this.getClass().toString() : moduleName); //As a placeholder
	}
	
	public int getKeybind(){
		return keybinding;
	}
	
	public String getModuleVersion(){
		return StringUtils.defaultString(moduleVersion);
	}
	
	public String getModuleAuth(){
		return StringUtils.defaultString(moduleAuthor);
	}
	
	public void setForgeEvent(boolean state){
		forgeEvt = state;
	}
	
	public void setKeybinding(int key){
		keybinding = key;
	}
	
	public void setTick(boolean state){
		tick = state;
	}
	
	public void setRender(boolean state){
		render = state;
	}
	
	public boolean getForgeEvent(){
		return forgeEvt;
	}
	
	public boolean getRender(){
		return render;
	}
	
	public boolean getTick(){
		return tick;
	}
	
	public boolean isActive(){
		return state;
	}

	public Category getCategory(){
		return cat;
	}
	
	public void reset(){
		this.toggle();
		this.toggle();
	}
	
	public void forceEnable()
	{
		state = true;
		enable();
		if(!(getCategory() == Category.NONE)){ ModuleManager.instance().enabled.add(this.getModuleName()); }
		if(getTick()){ EventHandler.getInstance().registerListener(EventTick.class, this); }
		if(getRender()){ EventHandler.getInstance().registerListener(EventRender.class, this); }
		if(getForgeEvent()){ MinecraftForge.EVENT_BUS.register(this); }
	}
	
	public void forceDisable()
	{
		state = false;
		disable();
		if(!(getCategory() == Category.NONE)){ ModuleManager.instance().enabled.remove(this.getModuleName()); }
		if(getTick()){ EventHandler.getInstance().unRegisterListener(EventTick.class, this); }
		if(getRender()){ EventHandler.getInstance().unRegisterListener(EventRender.class, this); }
		if(getForgeEvent()){ MinecraftForge.EVENT_BUS.unregister(this); }
	}
	
	public void toggle(){
		//Register, register, call and REGISTER :)
		state = !state;
		if(state){
			enable();
			if(!(getCategory() == Category.NONE)){ ModuleManager.instance().enabled.add(this.getModuleName()); }
			if(getTick()){ EventHandler.getInstance().registerListener(EventTick.class, this); }
			if(getRender()){ EventHandler.getInstance().registerListener(EventRender.class, this); }
			if(getForgeEvent()){ MinecraftForge.EVENT_BUS.register(this); }
		}
		else{
			disable();
			if(!(getCategory() == Category.NONE)){ ModuleManager.instance().enabled.remove(this.getModuleName()); }
			if(getTick()){ EventHandler.getInstance().unRegisterListener(EventTick.class, this); }
			if(getRender()){ EventHandler.getInstance().unRegisterListener(EventRender.class, this); }
			if(getForgeEvent()){ MinecraftForge.EVENT_BUS.unregister(this); }
		}
	}
	
	public String showHelp()
	{
		return help;
	}
	
	public Minecraft minecraft()
	{
		return Minecraft.getMinecraft();
	}
	
	public EntityClientPlayerMP player()
	{
		return Minecraft.getMinecraft().thePlayer;
	}
	
	public WorldClient world()
	{
		return Minecraft.getMinecraft().theWorld;
	}
	
	public Profiler profiler(){
		return Minecraft.getMinecraft().mcProfiler;
	}
	
	@Override
	public void onEvent(Event evt){
		if(evt instanceof EventTick){
			this.tick();
		}
		if(evt instanceof EventRender){
			this.doRender();
		}
	}
	
	public void enable(){}
	public void disable(){}
	public void doRender(){}
	public void tick(){}
}
