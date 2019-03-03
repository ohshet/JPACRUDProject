package com.skilldistillery.jpacruddata.dao;

import com.skilldistillery.jpacruddata.entities.RedMeat;

public interface RedMeatDAO {
	public RedMeat create(RedMeat redmeat);
	public RedMeat update(int id, RedMeat redmeat);
	public boolean destroy(int id);
}

