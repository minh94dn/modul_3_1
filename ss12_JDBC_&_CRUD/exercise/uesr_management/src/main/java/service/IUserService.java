package service;

import model.User;

import java.util.List;

public interface IUserService {
    List<User> showAll();

    boolean add(User user);

    boolean edit(User user);

    User findById(int id);

    boolean delete(int id);

    List<User> search(String countrySearch);

    List<User> sort();
}
