package com.alex.forum.persistence;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.alex.forum.config.DbConfig;
import com.alex.forum.dbo.User;

@Service
public class UserDAO {

	SessionFactory sessionFactory;
	Session session;

	public UserDAO() {
		Configuration configuration = DbConfig.getPersistenceConfiguration();
		configuration.addAnnotatedClass(User.class);
		sessionFactory = configuration.buildSessionFactory();
		session = sessionFactory.openSession();
	}

	public void save(User user) {
		session.getTransaction().begin();
		session.saveOrUpdate(user);
		session.getTransaction().commit();
	}

	public User get(String username, String password) {
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.and(Restrictions.eq("username", username), Restrictions.eq("password", password)));
		List<User> users = criteria.list();
		return users.get(0);
	}
	
	public boolean exists(String username, String password) {
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.and(Restrictions.eq("username", username), Restrictions.eq("password", password)));
		List<User> users = criteria.list();
		return users.size() == 1;
	}

}
