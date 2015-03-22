package service;

import java.util.Map;

public interface UserService extends BaseService {

	public Map<String, Object> page(Integer start, Integer limit);
}
