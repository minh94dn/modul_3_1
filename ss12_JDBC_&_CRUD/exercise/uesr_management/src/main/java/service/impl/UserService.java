package service.impl;

import model.User;
import repository.IUserRepository;
import repository.impl.UserRepository;
import service.IUserService;

import java.util.List;

public class UserService implements IUserService {
    private IUserRepository iUserRepository = new UserRepository();

    @Override
    public List<User> showAll() {
        return iUserRepository.showAll();
    }

    @Override
    public boolean add(User user) {
        return iUserRepository.add(user);
    }

    @Override
    public boolean edit(User user) {
        return iUserRepository.edit(user);
    }

    @Override
    public User findById(int id_search) {
        return iUserRepository.findById(id_search);
    }

    @Override
    public boolean delete(int id) {
        return iUserRepository.delete(id);
    }

    @Override
    public List<User> search(String countrySearch) {
        return iUserRepository.search(countrySearch);
    }

    @Override
    public List<User> sort() {
        return iUserRepository.sort();
    }
}
