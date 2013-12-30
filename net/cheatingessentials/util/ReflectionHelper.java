package net.cheatingessentials.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import net.cheatingessentials.main.DynamicLogger;

import org.apache.logging.log4j.Level;

public class ReflectionHelper {

	/**}
	 * Exalm code.
	 * @param clazz
	 * @param o
	 * @param s
	 * @param val
	 */
	public static void setField(Class clazz, Object o, String s, Object val){
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++){
            if (fields[i].getName().equals(s)){
            	DynamicLogger.instance().writeLog("Fix Reflection usage: Use \""+i+"\" instead of \""+s+"\"!", Level.WARN);
                setField(clazz, o, i, val);
                return;
            }
        }
        DynamicLogger.instance().writeLog("Fix Reflection usage: No such field: \""+s+"\"!", Level.WARN);
    }
	
	public static void setStringFieldWW(Class clazz, Object o, String s, Object val){
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++){
            if (fields[i].getName().equals(s)){
                setField(clazz, o, i, val);
                return;
            }
        }
        DynamicLogger.instance().writeLog("Fix Reflection usage: No such field: \""+s+"\"!", Level.WARN);
    }

    public static void setField(Class c, Object o, int n, Object val){
        try{
            Field field = c.getDeclaredFields()[n];
            field.setAccessible(true);
            Field modifiers = field.getClass().getDeclaredField("modifiers");
            modifiers.setAccessible(true);
            modifiers.setInt(field, field.getModifiers() & ~Modifier.FINAL);
            field.set(o, val);
        }
        catch(Exception ex){
        	ex.printStackTrace();
        }
    }


}
