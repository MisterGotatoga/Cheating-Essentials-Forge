package cheatingessentials.mod.util.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Reflection Code for Cheating Essentials
 * @author Exalm
 */
public class ReflectionHelper
{
	
    public static void setField(Class clazz, Object o, String s, Object val)
    {
    	Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++){
        	if (fields[i].getName().equals(s)){
                System.out.println("Fix Reflection usage: Use \""+i+"\" instead of \""+s+"\"!");
                setField(clazz, o, i, val);
                return;
        	}
        }
        
        System.out.println("Fix Reflection usage: No such field: \""+s+"\"!");
    }
    
    public static void setStringFieldWW(Class clazz, Object o, String s, Object val)
    {
    	Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++){
        	if (fields[i].getName().equals(s)){
        		setField(clazz, o, i, val);
                return;
        	}
        }
        
        System.out.println("Fix Reflection usage: No such field: \""+s+"\"!");
    }

    public static void setField(Class c, Object o, int n, Object val)
    {
    	try{
    		Field field = c.getDeclaredFields()[n];
            field.setAccessible(true);
            Field modifiers = field.getClass().getDeclaredField("modifiers");
            modifiers.setAccessible(true);
            modifiers.setInt(field, field.getModifiers() & ~Modifier.FINAL);
            field.set(o, val);
    	}
    	
    	catch(Exception ex)
    	{
    		ex.printStackTrace();
    	}
    }
}
