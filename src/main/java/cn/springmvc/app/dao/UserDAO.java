package cn.springmvc.app.dao;

import java.util.List;
import java.util.Map;

import cn.springmvc.app.model.User;

public interface UserDAO {
	/**
     * 添加新用户
     * @param user
     * @return
     */
    public int insertUser(User user);
    public List getData(Map<String, Object> parmMap);
}
