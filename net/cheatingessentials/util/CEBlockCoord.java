package net.cheatingessentials.util;

import net.minecraft.client.renderer.entity.RenderManager;

public final class CEBlockCoord {
	
	private int x, y, z;

	public CEBlockCoord(int x, int y, int z) {
		this.x = x;
	    this.y = y;
	    this.z = z;
	}

	public int getX() {
	    return x;
	}

	public int getY() {
	    return y;
	}

	public int getZ() {
	    return z;
	}

	public double getDeltaX() {
	    return getX() - RenderManager.renderPosX;
	}

	public double getDeltaY() {
	    return getY() - RenderManager.renderPosY;
	}

	public double getDeltaZ() {
	    return getZ() - RenderManager.renderPosZ;
	}
}
