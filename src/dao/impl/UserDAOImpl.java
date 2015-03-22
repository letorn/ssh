package dao.impl;

import org.springframework.stereotype.Repository;

import pojo.User;
import dao.UserDAO;

@Repository("userDAO")
public class UserDAOImpl extends BaseDAOImpl<User> implements UserDAO {

}
