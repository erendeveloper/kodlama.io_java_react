package business.abstracts;

import entitiies.concretes.User;

import java.util.List;

public interface IUserService {

    public boolean add(User user);
    public List<User> getAllUsers();

}
