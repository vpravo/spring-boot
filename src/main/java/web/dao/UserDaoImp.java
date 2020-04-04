package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.List;

@Repository
public class UserDaoImp implements UserDAO {

  @Autowired
  private SessionFactory sessionFactory;

  @Override
  public List<User> getAllUsers() {
    return sessionFactory.getCurrentSession().createQuery("from User", User.class).list();
  }

  @Override
  public User findUserByEmail(String email) {
    return (User) sessionFactory.getCurrentSession()
            .createQuery("from User user where user.email = :email")
            .setParameter("email", email).getSingleResult();
  }

    @Override
    public User findUserByID(Long id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
  public void addUser(User user) {
    sessionFactory.getCurrentSession().persist(user);
  }

  @Override
  public void updateUser(User user) {
    sessionFactory.getCurrentSession().saveOrUpdate(user);
  }

  @Override
  public void deleteUser(User user) {
    sessionFactory.getCurrentSession().delete(user);
  }
}
