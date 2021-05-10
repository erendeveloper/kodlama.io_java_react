package dataAccess.concretes;

import dataAccess.abstracts.IUserDao;
import entitiies.concretes.User;

import java.util.ArrayList;


public class HibernateUserDao implements IUserDao {

    static ArrayList<User> users = new ArrayList<User>();

    @Override
    public void add(User user) {
        users.add(user);
    }

    @Override
    public ArrayList<User> getAll() {
        return users;
    }
}
