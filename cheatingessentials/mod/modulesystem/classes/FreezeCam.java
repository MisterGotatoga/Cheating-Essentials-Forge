package cheatingessentials.mod.modulesystem.classes;

import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.Entity;
import cheatingessentials.api.module.Mod;
import cheatingessentials.mod.internal.FreecamEntity;
import cheatingessentials.mod.wrapper.ModuleCategories;
import cheatingessentials.mod.wrapper.Wrapper;

public class FreezeCam extends Mod {
	
	/**
	 * Modified Spectator, to yoloswag u
	 */

	LocationHelper location;
	
	public FreezeCam()
	{
		super(ModuleCategories.RENDER);
	}
	
	@Override
	public String getName(){
		return "Freeze Cam";
	}
	
	@Override
	public String getDescription(){
		return "Freeze the player camera for do a control of the PJ from another entity. Useful for make videos";
	}
	
	@Override
	public void onEnableMod(){
		doFreezeCam();
	}
	
	@Override
	public void onDisableMod(){
		undoFreezeCam();
	}
	
	public void doFreezeCam(){
		if(Wrapper.INSTANCE.world() instanceof WorldClient){
			location = new LocationHelper(Wrapper.INSTANCE.player());
			FreecamEntity spectator = new FreecamEntity(Wrapper.INSTANCE.world(), Wrapper.INSTANCE.player().func_146103_bH());
			spectator.setPositionAndRotation(location.posX, location.posY - 1.5, location.posZ, location.rotationYaw, location.rotationPitch);
			spectator.inventory.copyInventory(Wrapper.INSTANCE.player().inventory);
			Wrapper.INSTANCE.world().addEntityToWorld(-1, spectator);
			Wrapper.INSTANCE.minecraft().renderViewEntity = spectator;
		}
	}
	
	public void undoFreezeCam(){
		Wrapper.INSTANCE.world().removeEntityFromWorld(-1);
		Wrapper.INSTANCE.minecraft().renderViewEntity = Wrapper.INSTANCE.player();
	}
	
    class LocationHelper {

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
