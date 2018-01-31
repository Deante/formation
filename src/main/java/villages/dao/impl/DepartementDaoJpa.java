package villages.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import villages.Application;
import villages.dao.DepartementDao;
import villages.model.Departement;

public class DepartementDaoJpa implements DepartementDao {

	@Override
	public Departement find(Long id) {
		EntityManager em = null;
		Departement departement = null;
		try {
			em = Application.getInstance().getEmf().createEntityManager();
			departement = em.find(Departement.class, id);
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
	public List<Departement> findAll() {
		EntityManager em = null;
		List<Departement> departements = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			departements = em.createQuery("SELECT d FROM Departement d").getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
		}

		return departements;
	}

	@Override
	public void create(Departement obj) {
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
	public Departement update(Departement obj) {
		EntityManager em = null;
		EntityTransaction tx = null;
		Departement updatedDepartement = null;
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
	public void delete(Departement obj) {
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
