package cheatingessentials.mod.modulesystem.classes;

import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.Entity;
import cheatingessentials.api.module.APICEMod;
import cheatingessentials.api.module.Mod;
import cheatingessentials.mod.internal.FreecamEntity;
import cheatingessentials.mod.wrapper.ModuleCategories;
import cheatingessentials.mod.wrapper.Wrapper;

public class Spectate extends Mod {
	
	private LocationHelper loc;
	
	public String getName(){
		return "Spectator";
	}
	
	public ModuleCategories getCategory()
	{
		return ModuleCategories.RENDER;
	}
	
	@Override
	public String getDescription(){
		return "Creates another player entity (EntityFreecam) for be able to spectate your own player";
	}

	public void onEnableMod(){
		APICEMod.INSTANCE.call(DynamicFly.class).toggle();
		doSpectate();
	}
	
	public void onDisableMod(){
		APICEMod.INSTANCE.call(DynamicFly.class).toggle();
		undoSpectate();
	}
	
	public void doSpectate(){
		if(Wrapper.INSTANCE.world() instanceof WorldClient){
			loc = new LocationHelper(Wrapper.INSTANCE.player());
			FreecamEntity spectator = new FreecamEntity(Wrapper.INSTANCE.world(), Wrapper.INSTANCE.player().func_146103_bH());
			spectator.setPositionAndRotation(loc.posX, loc.posY - 1.5, loc.posZ, loc.rotationYaw, loc.rotationPitch);
			spectator.boundingBox.setBB(Wrapper.INSTANCE.player().boundingBox.copy());
			spectator.inventory.copyInventory(Wrapper.INSTANCE.player().inventory);
			Wrapper.INSTANCE.world().addEntityToWorld(-1, spectator);
		}
	}
	
	public void undoSpectate(){
		Wrapper.INSTANCE.world().removeEntityFromWorld(-1);
		Wrapper.INSTANCE.player().setPositionAndRotation(loc.posX, loc.posY, loc.posZ, loc.rotationYaw, loc.rotationPitch);
	}
	
	public class LocationHelper {

		public double posX;
	    public double posY;
	    public double posZ;
	    public float rotationYaw;
	    public float rotationPitch;

	    public String name;

	    @Override
	    public LocationHelper clone() {
	    	return new LocationHelper(posX, posY, posZ, rotationYaw, rotationPitch, name);
	    }
	    
	    public LocationHelper(Entity entity) {
	    	this(entity, "");
	    }
	    
	    public LocationHelper(Entity entity, String s) {
	    	this(entity.posX, entity.posY, entity.posZ, entity.rotationYaw, entity.rotationPitch, s);
	    }
	    
	    public LocationHelper() {
	    	this(0.0D, 0.0D, 0.0D, 0.0F, 0.0F, "");
	    }

	    public LocationHelper(double d, double d1, double d2, String s) {
	    	this(d, d1, d2, 0.0F, 0.0F, s);
	    }

	    public LocationHelper(double d, double d1, double d2) {
	    	this(d, d1, d2, 0.0F, 0.0F, "");
	    }

	    public LocationHelper(double d, double d1, double d2, float f, float f1) {
	    	this(d, d1, d2, f, f1, "");
	    }

	    public LocationHelper(double d, double d1, double d2, float f, float f1, String s) {
	     posX = d;
	     posY = d1;
	     posZ = d2;
	     rotationYaw = f;
	     rotationPitch = f1;
	     name = s;
	    }

	    public double distance(LocationHelper Location) {
	    	return Math.sqrt(distanceSquare(Location));
	    }

	    public double distanceSquare(LocationHelper Location) {
	    	double d = Location.posX - posX;
	        double d1 = Location.posY - posY;
	        double d2 = Location.posZ - posZ;
	        return d * d + d1 * d1 + d2 * d2;
	    }

	    public double distance2D(LocationHelper Location) {
	    	return Math.sqrt(distance2DSquare(Location));
	    }

	    public double distance2DSquare(LocationHelper Location) {
	    	double d = Location.posX - posX;
	        double d1 = Location.posZ - posZ;
	        return d * d + d1 * d1;
	    }

	    public double distanceY(LocationHelper Location) {
	    	return Location.posY - posY;
	    }

	    public LocationHelper(String s) throws Exception {
	    	String as[] = s.split(";", 6);
	    
	    	if (as.length != 6){
	    		throw new Exception("Invalid line!");
	    	}
	    	else {
	    		name = as[5];
	            posX = Double.parseDouble(as[0]);
	            posY = Double.parseDouble(as[1]);
	            posZ = Double.parseDouble(as[2]);
	            rotationYaw = Float.parseFloat(as[3]);
	            rotationPitch = Float.parseFloat(as[4]);
	            return;
	            }
	    }
	     
	    public String export() {
	     return (new StringBuilder()).append(posX).append(";").append(posY).append(";").append(posZ).append(";").append(rotationYaw).append(";").append(rotationPitch).append(";").append(name).toString();
	    }
	}
}
