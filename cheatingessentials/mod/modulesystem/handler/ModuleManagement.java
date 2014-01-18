package cheatingessentials.mod.modulesystem.handler;

import cheatingessentials.api.module.APICEMod;
import cheatingessentials.api.module.Mod;
import cheatingessentials.mod.modulesystem.classes.AdvancedTooltips;
import cheatingessentials.mod.modulesystem.classes.AnimalESP;
import cheatingessentials.mod.modulesystem.classes.ArrowDodge;
import cheatingessentials.mod.modulesystem.classes.AutoRespawn;
import cheatingessentials.mod.modulesystem.classes.AutoSprint;
import cheatingessentials.mod.modulesystem.classes.BlockFinder;
import cheatingessentials.mod.modulesystem.classes.BlockOverlay;
import cheatingessentials.mod.modulesystem.classes.Breadcrumb;
import cheatingessentials.mod.modulesystem.classes.ChestFinder;
import cheatingessentials.mod.modulesystem.classes.CreativeFly;
import cheatingessentials.mod.modulesystem.classes.Day;
import cheatingessentials.mod.modulesystem.classes.DieCoordinates;
import cheatingessentials.mod.modulesystem.classes.DynamicFly;
import cheatingessentials.mod.modulesystem.classes.FastBreak;
import cheatingessentials.mod.modulesystem.classes.FastPlace;
import cheatingessentials.mod.modulesystem.classes.Fly;
import cheatingessentials.mod.modulesystem.classes.FreezeCam;
import cheatingessentials.mod.modulesystem.classes.Fullbright;
import cheatingessentials.mod.modulesystem.classes.Gui;
import cheatingessentials.mod.modulesystem.classes.HighJump;
import cheatingessentials.mod.modulesystem.classes.InvisiblePlayer;
import cheatingessentials.mod.modulesystem.classes.JumpStep;
import cheatingessentials.mod.modulesystem.classes.MobAura;
import cheatingessentials.mod.modulesystem.classes.MobHitbox;
import cheatingessentials.mod.modulesystem.classes.NoFall;
import cheatingessentials.mod.modulesystem.classes.NoRain;
import cheatingessentials.mod.modulesystem.classes.NoWeb;
import cheatingessentials.mod.modulesystem.classes.PlayerESP;
import cheatingessentials.mod.modulesystem.classes.ReloadChunks;
import cheatingessentials.mod.modulesystem.classes.Sneak;
import cheatingessentials.mod.modulesystem.classes.Spectate;
import cheatingessentials.mod.modulesystem.classes.Speed;
import cheatingessentials.mod.modulesystem.classes.Sprint;
import cheatingessentials.mod.modulesystem.classes.Step;
import cheatingessentials.mod.modulesystem.classes.Tracers;
import cheatingessentials.mod.modulesystem.classes.Unpushable;
import cheatingessentials.mod.modulesystem.classes.WaterWalk;
import cheatingessentials.mod.modulesystem.classes.XRay;

public class ModuleManagement 
{
	public volatile static ModuleManagement INSTANCE = new ModuleManagement();
	
	private void add(Mod mod)
	{
		APICEMod.INSTANCE.enable(mod);
	}
	
	public void initModules()
	{
		add(new AdvancedTooltips());
		add(new AnimalESP());
		add(new ArrowDodge());
		add(new AutoRespawn());
		add(new AutoSprint());
		add(new BlockFinder());
		add(new BlockOverlay());
		add(new Breadcrumb());
		add(new ChestFinder());
		add(new CreativeFly());
		add(new Day());
		add(new DieCoordinates());
		add(new DynamicFly());
		add(new FastBreak());
		add(new FastPlace());
		add(new Fly());
		add(new FreezeCam());
		add(new Fullbright());
		add(new Gui());
		add(new HighJump());
		add(new InvisiblePlayer());
		add(new JumpStep());
		add(new MobAura());
		add(new MobHitbox());
		add(new NoFall());
		add(new NoRain());
		add(new NoWeb());
		add(new PlayerESP());
		add(new ReloadChunks());
		add(new Sneak());
		add(new Spectate());
		add(new Speed());
		add(new Sprint());
		add(new Step());
		add(new Tracers());
		add(new Unpushable());
		add(new WaterWalk());
		add(new XRay());
	}
}
