package cn.springmvc.app.service;

import java.util.List;
import java.util.Map;

import cn.springmvc.app.model.User;

public interface UserService {
	public int insertUser(User user);
	public List getData(Map<String, Object> parmMap);
}
