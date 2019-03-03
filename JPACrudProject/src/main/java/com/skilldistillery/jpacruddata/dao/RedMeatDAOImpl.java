package com.skilldistillery.jpacruddata.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.skilldistillery.jpacruddata.entities.RedMeat;

public class RedMeatDAOImpl implements RedMeatDAO {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("redmeat");
	private EntityManager em;

	@Override
	public RedMeat create(RedMeat redmeat) {
		em = emf.createEntityManager();

		em.getTransaction().begin();
		em.persist(redmeat);
		em.flush();
		em.getTransaction().commit();
		em.close();
		return redmeat;
	}

	public RedMeat update(int id, RedMeat updatedRedMeat) {
		em = emf.createEntityManager();
		RedMeat managed = em.find(RedMeat.class, id);
		em.getTransaction().begin();
		managed.setTitle(updatedRedMeat.getTitle());
		managed.setCharacters(updatedRedMeat.getCharacters());
		managed.setText(updatedRedMeat.getText());
		managed.setImgUrl(updatedRedMeat.getImgUrl());
		em.getTransaction().commit();
		em.close();
		return managed;
	}

	public boolean destroy(int id) {
		em = emf.createEntityManager();
		RedMeat redmeat = em.find(RedMeat.class, id);
		em.getTransaction().begin();
		em.remove(redmeat);
		em.getTransaction().commit();
		redmeat = em.find(RedMeat.class, id);
		boolean result = false;
		if (redmeat == null) {
			result = true;
		} 
		em.close();
		return result;
	}
}
