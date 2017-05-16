package dao;

import entity.User;

public interface UserDao {
 public boolean login(User user);
 public boolean reg(String username,String password);
}
