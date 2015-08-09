package cn.springmvc.app.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.springmvc.app.dao.UserDAO;
import cn.springmvc.app.model.User;
import cn.springmvc.app.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
    private UserDAO userDAO;
     
    @Override
    public int insertUser(User user) {
        return userDAO.insertUser(user);
    }
    
    @Override
    public List getData(Map<String, Object> parmMap){
        return userDAO.getData(parmMap);
    }
}
