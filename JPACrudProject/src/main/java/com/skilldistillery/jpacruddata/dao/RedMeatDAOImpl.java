package com.skilldistillery.jpacruddata.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
//import org.springframework.stereotype.Service;

import com.skilldistillery.jpacruddata.entities.RedMeat;

@Transactional
//@Service
public class RedMeatDAOImpl implements RedMeatDAO {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("redmeat");

	@PersistenceContext
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

	@Override
	public List<RedMeat> searchId(int id) {
		em = emf.createEntityManager();
		String sql = "select rm from RedMeat rm where id = :sid";
		List<RedMeat> meatList = null;

		meatList = em.createQuery(sql, RedMeat.class).setParameter("sid", id).getResultList();

		return meatList;
	}

	@Override
	public List<RedMeat> searchTitle(String searchString) {
		em = emf.createEntityManager();
		searchString = "%" + searchString + "%";
		String sql = "select rm from RedMeat rm where rm.title like :string";
		List<RedMeat> meatList = null;
		meatList = em.createQuery(sql, RedMeat.class).setParameter("string", searchString).getResultList();
		return meatList;
	}

	@Override
	public List<RedMeat> searchCharacter(String searchString) {
		em = emf.createEntityManager();
		searchString = "%" + searchString + "%";
		String sql = "select rm from RedMeat rm where rm.characters like :string";
		List<RedMeat> meatList = null;
		meatList = em.createQuery(sql, RedMeat.class).setParameter("string", searchString).getResultList();
		return meatList;
	}

	@Override
	public List<RedMeat> searchText(String searchString) {
		em = emf.createEntityManager();
		searchString = "%" + searchString + "%";
		String sql = "select rm from RedMeat rm where rm.text like :string";
		List<RedMeat> meatList = null;
		meatList = em.createQuery(sql, RedMeat.class).setParameter("string", searchString).getResultList();
		return meatList;
	}

	@Override
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

	@Override
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
