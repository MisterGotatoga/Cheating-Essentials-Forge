package net.cheatingessentials.main;

import org.apache.logging.log4j.Level;

import cpw.mods.fml.common.FMLLog;

/**
 * Logger for print things in console used by a lot of classes, specially {@link CheatingEssentials} and modules.
 * This logger provides to the mod a basic funcionality for describe the warning level and the string to print.
 * @author Kodehawa
 */
public class DynamicLogger {

	private static volatile DynamicLogger instance = new DynamicLogger();
	String p = "[CE Default] ";
	String p1 = "CE ";
	
	/**
	 * Write a FML Log to the console.
	 * @param data = String to print
	 * @param level = Level mode
	 */
	public void writeLog(String data, Level level){
		FMLLog.log(level, "Cheating Essentials", data);
	}
	
	/**
	 * Write a information log in FML Logger.
	 */
	public void writeInfo(String data){
		FMLLog.info(p+data, "");
	}
	
	/**
	 * Write a raw java log with the "[CE Default]" prefix.
	 * @param data
	 */
	public void writeSimple(String data){
		System.out.println(p+data);
	}
	
	/**
	 * Write a raw java log without prefix.
	 * @param data
	 */
	public void writeRaw(String data){
		System.out.println(data);
	}
	
	/**
	 * Allows to print a log with the specified prefix
	 * @param prefix = Prefix to print
	 * @param data = Data to print
	 * @param level = Level mode
	 * @param mode = Mode to print (1 = FML log, 2 = Raw Java log)
	 */
	public void writeLogWithPrefix(String prefix, String data, Level level, int mode){
		if(mode == 1){
			FMLLog.log(p1+prefix, level , data);
		}
		if(mode == 2){
			System.out.println("["+prefix+"]"+ " [" + level + "] " + data);
		}
	}
	
	public static DynamicLogger instance(){
		return instance;
	}
}
