package web.service;

import web.dao.UserDao;
import web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Transactional
   @Override
   public List<User> getAllUsers() {
      return userDao.getAllUsers();

   }
@Transactional
   @Override
   public void saveUser(User user) {
      userDao.saveUser(user);
   }
@Transactional
   @Override
   public User getUser(Long id) {
      return userDao.getUser(id);
   }
@Transactional
   @Override
   public void updateUser(User user) {
   userDao.updateUser(user);
   }
@Transactional
   @Override
   public void deleteUser(Long id) {
   userDao.deleteUser(id);
   }
}
