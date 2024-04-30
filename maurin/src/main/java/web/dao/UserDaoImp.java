package web.dao;

import web.model.User;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

@PersistenceContext
   EntityManager entityManager;


   @Override
   public List<User> getAllUsers() {
     List <User> userList =  entityManager.createQuery("from User", User.class).getResultList();
      return userList;
   }

   @Override
   public void saveUser(User user) {
      entityManager.persist(user);
   }

   @Override
   public User getUser(Long id) {
       return entityManager.find(User.class,id);

   }

   @Override
   public void updateUser(User user) {
        entityManager.merge(User.class);
   }

   @Override
   public void deleteUser(Long id) {
     User user = entityManager.find(User.class,id);
     if (user!=null){
        entityManager.remove(user);
     }
   }
}
