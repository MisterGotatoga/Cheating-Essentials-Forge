package cheatingessentials.mod.relationsystem;

import java.util.concurrent.CopyOnWriteArrayList;

import cheatingessentials.mod.wrapper.Wrapper;

public class Enemy
{
	private static volatile Enemy INSTANCE = new Enemy();
	public CopyOnWriteArrayList<String> enemyList = new CopyOnWriteArrayList<String>();
	
	public void addEnemy(String string)
	{
		if(!enemyList.contains(string))
		{
			enemyList.add(string);
		}
	}
	
	public void removeEnemy(String string)
	{
		enemyList.remove(string);
	}
	
	public boolean readEnemy(String string)
	{
		if(Wrapper.INSTANCE.player().func_146103_bH().getName() == string && enemyList.contains(string))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static Enemy instance()
	{
		return INSTANCE;
	}
}
