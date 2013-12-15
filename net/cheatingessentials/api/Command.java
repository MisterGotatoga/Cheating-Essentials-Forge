package net.cheatingessentials.api;

public abstract class Command {
	
	/**
	 * Unlocalized Command
	 */
	private String command;
	
	/**
     * Main constructor. Defines all things that a command needs
     */
	public Command(String command) {
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