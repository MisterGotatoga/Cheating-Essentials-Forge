package cheatingessentials.mod.commands.apicommands;

public class APICommandManager {

	public static void addCommands(){
		CommandManager.instance();
		CommandManager.instance().addCommand(new ACommandBFRadius());
		CommandManager.instance().addCommand(new ACommandBlockESP());
		CommandManager.instance().addCommand(new ACommandCBreadcrumb());
		CommandManager.instance().addCommand(new ACommandEnemy());
		CommandManager.instance().addCommand(new ACommandFlySpeed());
		CommandManager.instance().addCommand(new ACommandFriend());
		CommandManager.instance().addCommand(new ACommandModuleHelp());
		CommandManager.instance().addCommand(new ACommandModuleList());
		CommandManager.instance().addCommand(new ACommandModuleToggle());
		CommandManager.instance().addCommand(new ACommandSMKeybind());
		CommandManager.instance().addCommand(new ACommandSpeedValue());
		CommandManager.instance().addCommand(new ACommandStepHeight());
		CommandManager.instance().addCommand(new ACommandXray());
	}
}
