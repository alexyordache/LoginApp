package persistence;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.alex.forum.dbo.User;
import com.alex.forum.persistence.UserDAO;

public class UserPersistenceTest {

	UserDAO userDAO;

	@Before
	public void setUp() {
		userDAO = new UserDAO();
	}

	@Test
	public void testSaveUser() {
		User user = new User("alex", "pass");
		userDAO.save(user);
	}
	
	@Ignore
	@Test
	public void testGetUser() {
		User user = userDAO.get("alex", "pass");
		System.out.println(user);
		assertNotNull(user);
	}
}
