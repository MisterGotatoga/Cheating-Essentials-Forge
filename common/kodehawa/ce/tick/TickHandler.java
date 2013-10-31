package common.kodehawa.ce.tick;

import java.util.EnumSet;

import org.lwjgl.input.Keyboard;

import common.kodehawa.ce.event.EventHandler;
import common.kodehawa.ce.event.events.EventTick;
import common.kodehawa.ce.gui.CheatingEssentialsGui;
import common.kodehawa.ce.module.core.AbstractModule;
import common.kodehawa.ce.util.ConfigManager;
import common.kodehawa.ce.util.Keybinding;
import common.kodehawa.reeszrbteam.ce.gui.click.YouAlwaysWinClickGui;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.IScheduledTickHandler;
import cpw.mods.fml.common.TickType;

public class TickHandler implements IScheduledTickHandler {


	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
		Keybinding.instance().handle();
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		if(FMLClientHandler.instance().getClient().theWorld != null && FMLClientHandler.instance().getClient().thePlayer != null ){
			EventHandler.getInstance().call(new EventTick(this));
		}
	}

	@Override
	public EnumSet<TickType> ticks() {
		return EnumSet.of(TickType.CLIENT, TickType.WORLD);
	}

	@Override
	public String getLabel() {
		return "Cheating-Essentials";
	}

	@Override
	public int nextTickSpacing() {
		return 0;
	}
}
