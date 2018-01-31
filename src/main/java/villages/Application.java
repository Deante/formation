package villages;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import villages.dao.DepartementDao;
import villages.dao.impl.DepartementDaoJpa;

public class Application {
	private static Application instance = null;

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("formation");

	private final DepartementDao departementDao = new DepartementDaoJpa();

	private Application() {
	}

	public static Application getInstance() {
		if (instance == null) {
			instance = new Application();
		}

		return instance;
	}

	public static void stop() {
		Application inst = getInstance();
		inst.emf.close();
		inst.emf = null;
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public DepartementDao getDepartementDao() {
		return departementDao;
	}

}
