package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void saveUser(User user);

    User getUser(Long id);

    void updateUser(User user);

    void deleteUser(Long id);
}
