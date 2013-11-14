package common.kodehawa.api.console;

public abstract class BaseCommand {
	
	/**
	 * Unlocalized Command
	 */
	private String command;
	
	/**
     * Main constructor. Defines all things that a command needs
     */
	public BaseCommand(String command) {
		this.command = command;
	}

	/**
	 * Runs Command
	 */
	public abstract void runCommand(String s, String[] subcommands);
	
	/**
	 * Gets Description of a Command
	 */
	public abstract String getDescription();
	
	/**
	 * Gets Syntax of a Command
	 */
	public abstract String getSyntax();
	
	/**
	 * Gets Command
	 */
	public String getCommand() {
		return command;
	}
}