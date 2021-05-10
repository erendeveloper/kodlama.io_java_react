package dataAccess.abstracts;

import entitiies.concretes.User;

import java.util.ArrayList;
import java.util.List;

public interface IUserDao{
    public void add(User user);
    public List<User> getAll();
}
