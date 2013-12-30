package net.cheatingessentials.util;

import com.mojang.authlib.GameProfile;

import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.world.World;

public class EntitySpectator extends EntityOtherPlayerMP {

	public EntitySpectator(World par1World, GameProfile par2Str) {
		super(par1World, par2Str);
	}

}
