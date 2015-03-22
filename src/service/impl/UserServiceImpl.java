package service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import service.UserService;
import dao.UserDAO;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl implements UserService {

	@Resource
	private UserDAO userDAO;

	@Override
	public Map<String, Object> page(Integer start, Integer limit) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", userDAO.countAll());
		map.put("list", userDAO.find(start, limit));
		return map;
	}
}
