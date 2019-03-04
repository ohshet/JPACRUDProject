package com.skilldistillery.jpacruddata.dao;

import java.util.List;

import com.skilldistillery.jpacruddata.entities.RedMeat;

public interface RedMeatDAO {
	public List<RedMeat> searchId(int id);
	public List<RedMeat> searchTitle(String title);
	public List<RedMeat> searchCharacter(String character);
	public List<RedMeat> searchText(String text);	
	public RedMeat create(RedMeat redmeat);
	public RedMeat update(int id, RedMeat redmeat);
	public boolean destroy(int id);
}

