package cheatingessentials.mod.relationsystem;

import java.util.concurrent.CopyOnWriteArrayList;

import cheatingessentials.mod.wrapper.Wrapper;

/**
 * Friend category class. The {@link #friendList} should be readed by AGCEList (Due to it's state
 * as a String list that saves the player names). The names needs to be get from {@link GameProfile}
 * class since "username" in Player classes doesn't longer exists and {@link Minecraft#getMinecraft()#session}
 * is private and can't be accessed without using reflection.
 */
public class Friend
{
	private static volatile Friend INSTANCE = new Friend();
	public CopyOnWriteArrayList<String> friendList = new CopyOnWriteArrayList<String>();
	
	public void addFriend(String string)
	{
		if(!friendList.contains(string))
		{
			friendList.add(string);
		}
	}
	
	public void removeFriend(String string)
	{
		friendList.remove(string);
	}
	
	public boolean readFriend(String string)
	{
		if(Wrapper.INSTANCE.player().func_146103_bH().getName() == string && friendList.contains(string))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static Friend instance()
	{
		return INSTANCE;
	}
}
