package villages.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import villages.Application;
import villages.model.Departement;

public class DepartementDaoJpaTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testFind() {
		Departement d = new Departement(1l, "75000", "Paris");
		Application.getInstance().getDepartementDao().create(d);
		Departement e = Application.getInstance().getDepartementDao().find(1l);
		assertEquals(d.getId(), e.getId());
	}

	@Test
	public void testFindAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreate() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

}
