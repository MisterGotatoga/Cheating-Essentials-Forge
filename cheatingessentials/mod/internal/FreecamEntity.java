package cheatingessentials.mod.internal;

import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MovementInput;
import net.minecraft.world.World;

import com.mojang.authlib.GameProfile;

public class FreecamEntity extends EntityOtherPlayerMP
{
	public FreecamEntity(World par1World, GameProfile par2Str)
	{
		super(par1World, par2Str);
	}
	
	public MovementInput movementInput = null;

	public boolean flyMode = false;
	
	public void setMovementInput(MovementInput par1MovementInput)
	{
		this.movementInput = par1MovementInput;
		
		if(par1MovementInput.jump && !flyMode && onGround)
		{
			this.jump();
		}
		
		this.moveEntityWithHeading(par1MovementInput.moveStrafe, par1MovementInput.moveForward);
	}
	
	public void moveEntity(double x, double y, double z)
	{
		super.moveEntity(x, y, z);
	}
	
	/*public boolean isSneaking()
	{
		return this.movementInput.sneak && !flyMode;
	}
	*/
	public void onLivingUpdate()
	{
		super.onLivingUpdate();
		if(flyMode)
		{
			noClip = true;
			motionX = 0;
			motionY = 0;
			motionZ = 0;
			this.setAIMoveSpeed(0.6F);
			jumpMovementFactor = 0.6F;
			if(this.movementInput != null)
			{
				motionX = 0;
				motionY = 0;
				motionZ = 0;
				this.jumpMovementFactor *= 3;

				if(this.movementInput.jump)
				{
					motionY += 1;
				}
				if(this.movementInput.sneak)
				{
					motionY -= 1;
				}
			}
		}else
		{
			if(!isSprinting())
			{
				this.setAIMoveSpeed(0.1F);
				this.jumpMovementFactor = 0.02F;
			}
			noClip = false;
		}
	}
}
