package net.cheatingessentials.client.modules.player;

import net.cheatingessentials.api.Module;
import net.cheatingessentials.client.modules.general.Category;
import net.minecraft.network.play.server.S08PacketPlayerPosLook;

import org.lwjgl.input.Keyboard;

public class NoFall extends Module {

	public NoFall() {
		super(Category.PLAYER);
		this.setTick(true);
		this.setKeybinding(Keyboard.KEY_V);
	}
	
	@Override
	public String getModuleName(){
		return "No Fall";
	}
	
	@Override
	public String showHelp(){
		return "Avoid player fall damage calculations and removes player fall damage itself";
	}
	
	@Override
	public void tick(){
		player().sendQueue.func_147258_a(new S08PacketPlayerPosLook(player().motionX, -999.0D, player().motionZ,
				player().rotationYaw, player().rotationPitch, !player().onGround));
		
	}
}
