package net.cheatingessentials.relation;

import java.util.concurrent.CopyOnWriteArrayList;

public class PlayerRelations {

	public volatile static PlayerRelations instance = new PlayerRelations();
	public CopyOnWriteArrayList<String> friends = new CopyOnWriteArrayList<String>();
	public CopyOnWriteArrayList<String> enemies = new CopyOnWriteArrayList<String>();
	
	public PlayerRelations(){
		addDefaultFriends();
	}
		
	private void addDefaultFriends()
	{
		friends.add("Kodehawa");
		friends.add("ReesZRB");
	}
	
	public static PlayerRelations instance(){
		return instance;
	}
}
