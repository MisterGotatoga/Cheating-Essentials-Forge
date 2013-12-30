package net.cheatingessentials.client.modules.player;

import net.cheatingessentials.api.Module;
import net.cheatingessentials.client.modules.general.Category;
import net.minecraft.entity.ai.attributes.AttributeModifier;

public class Speed extends Module {

	public Speed()
	{
		super(Category.PLAYER);
		setTick(true);
	}
	
	private static AttributeModifier cespeedmodifier = new AttributeModifier("Cheating Essentials Speed Attribute", 0.79500008D, 2).setSaved(false);
	
	public String getModuleName()
	{
		return "Speed";
	}
	
	@Override
	public String showHelp()
	{
		return "Makes the player to run faster.";
	}
	
	public static double SPEED_VALUE = 1.4;
	
	int start = 0;
	int finish = 100;
	
	public void tick()
	{
	/*if(player().onGround && !minecraft().gameSettings.keyBindJump.pressed && minecraft().gameSettings.keyBindForward.pressed 
			&& !(minecraft().currentScreen instanceof GuiIngameMenu))
	{
		player().motionX *= SPEED_VALUE;
		player().motionZ *= SPEED_VALUE;
	}*/
	/*	AttributeInstance attributeinstance = player().getEntityAttribute(SharedMonsterAttributes.movementSpeed);
		attributeinstance.applyModifier(cespeedmodifier);*/
	}
	
	public void disable()
	{
		/*AttributeInstance attributeinstance = player().getEntityAttribute(SharedMonsterAttributes.movementSpeed);
		attributeinstance.removeModifier(cespeedmodifier);*/
	}
}
