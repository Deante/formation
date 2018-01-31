package villages.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import villages.Application;
import villages.dao.VilleDao;
import villages.model.Ville;

public class VilleDaoJpa implements VilleDao {


	@Override
	public Ville find(Long id) {
		EntityManager em = null;
		Ville departement = null;
		try {
			em = Application.getInstance().getEmf().createEntityManager();
			departement = em.find(Ville.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
		}
		return departement;
	}

	@Override
	public List<Ville> findAll() {
		EntityManager em = null;
		List<Ville> ville = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			ville = em.createQuery("SELECT d FROM Ville d").getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
		}

		return ville;
	}

	@Override
	public void create(Ville obj) {
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			em.persist(obj);
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}

	}

	@Override
	public Ville update(Ville obj) {
		EntityManager em = null;
		EntityTransaction tx = null;
		Ville updatedDepartement = null;
		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			updatedDepartement = em.merge(obj);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}

		} finally {
			if (em != null) {
				em.close();
			}
		}

		return updatedDepartement;
	}

	@Override
	public void delete(Ville obj) {
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			em.remove(em.merge(obj));

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}

		} finally {
			if (em != null) {
				em.close();
			}
		}

	}

	
}
