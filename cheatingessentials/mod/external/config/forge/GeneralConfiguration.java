package cheatingessentials.mod.external.config.forge;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import cheatingessentials.mod.modulesystem.classes.BlockFinder;
import cheatingessentials.mod.modulesystem.classes.Fly;
import cheatingessentials.mod.modulesystem.classes.Speed;
import cheatingessentials.mod.modulesystem.classes.Step;
import cheatingessentials.mod.wrapper.Wrapper;

/**
 * Forge configuration file manager. This create the file that manages all the general values in Cheating Essentials.
 * @author Kodehawa
 */
public class GeneralConfiguration 
{
	private volatile static GeneralConfiguration INSTANCE = new GeneralConfiguration();
	
	public Configuration configuration;
	
	public float flySpeedValue;
	public float stepHeightValue;
	public double speedValue;
	public int bfrValue;
	
	public GeneralConfiguration()
	{
		File path = new File(Wrapper.INSTANCE.minecraft().mcDataDir, "/config/Cheating-Essentials/General-Config.cfg");
		
		configuration = new Configuration(path);
		
		configuration.load();
		
		configuration.addCustomCategoryComment(Configuration.CATEGORY_GENERAL, "General Cheating Essentials values. This change when you use commands but you can change them here too");
		
		Property flySpeed;
		Property stepHeight;
		Property speed;
		Property blockFinderRadius;
		
		flySpeed = configuration.get(Configuration.CATEGORY_GENERAL, "flySpeed", Fly.FLY_SPEED);
		stepHeight = configuration.get(Configuration.CATEGORY_GENERAL, "stepHeight", Step.DEFAULT_STEP_HEIGHT);
		speed = configuration.get(Configuration.CATEGORY_GENERAL, "speedValue", Speed.SPEED_VALUE);
		blockFinderRadius = configuration.get(Configuration.CATEGORY_GENERAL, "blockFinderRadius", BlockFinder.BLOCK_RADIUS);
		
		flySpeed.comment = "Player Fly speed when <Fly> module is enabled.";
		stepHeight.comment = "Player step height when <Step> module is enabled.";
		speed.comment = "Player speed when <Speed> module is enabled.";
		blockFinderRadius.comment = "Block Finder block highlight radius.";
		
		flySpeedValue = (float) flySpeed.getDouble(Fly.FLY_SPEED);
		stepHeightValue = (float) stepHeight.getDouble(Step.DEFAULT_STEP_HEIGHT);
		speedValue = speed.getDouble(Speed.SPEED_VALUE);
		bfrValue = blockFinderRadius.getInt(BlockFinder.BLOCK_RADIUS);
		
		this.apply();
				
		configuration.save();
	}
	
	private void apply()
	{
		Fly.FLY_SPEED = flySpeedValue;
		Step.DEFAULT_STEP_HEIGHT = stepHeightValue;
		Speed.SPEED_VALUE = speedValue;
		BlockFinder.BLOCK_RADIUS = bfrValue;
	}
	
	public static GeneralConfiguration instance()
	{
		return INSTANCE;
	}
	
}
