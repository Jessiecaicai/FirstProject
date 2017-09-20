package hfutonline.service;

import java.util.List;
import hfutonline.entity.User;
import hfutonline.exception.UserException;

/**
 * Created by lenovo on 2017/9/10.
 */
public interface UserService {
    public void login(User user) throws UserException;

    public void register(User user) throws UserException;

    public List<User> listAll() throws UserException;

    public void addUser(User user) throws UserException;

    public void deleteUser(Integer id) throws UserException;

    public void updateUser(User user) throws UserException;
}







