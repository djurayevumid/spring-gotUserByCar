package hiber.dao;

import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.TypedQuery;
import java.util.List;
@Repository
public class UserDaoImp implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    public UserDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }
    @Override
    @SuppressWarnings("unchecked")
    public List<User> getUsersList() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }
    public User getUserByCarsModelAndSeries(String model, int series) {

        return sessionFactory.getCurrentSession().createQuery("select user from User user where user.userCar.model" +
                        " =:model and user.userCar.series =:series", User.class)
                .setParameter("model", model).setParameter("series", series).getSingleResult();

    }


}
