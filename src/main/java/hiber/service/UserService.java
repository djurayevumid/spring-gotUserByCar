package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    List<User> getUsersList();

    User getUserByCarsModelAndSeries (String model, int series);
}
