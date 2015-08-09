package cn.springmvc.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.attribute.HashAttributeSet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.springmvc.app.model.User;
import cn.springmvc.app.service.UserService;

@Controller
//@RequestMapping("/")
public class UserComtroller {
	@Autowired
	private UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(UserComtroller.class);
	@RequestMapping("index")
    public String index(Model model){
        /*ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:conf/spring.xml"
                ,"classpath:conf/spring-mybatis.xml"});
        userService = (UserService) context.getBean("userServiceImpl");*/
        User user = new User();
        user.setNickname("jingwen");
        user.setState(2);
        userService.insertUser(user);
        logger.info("OK!");
        
        logger.info("sssss - " + user);
        
        model.addAttribute("serverTime", "jingwen");
        return "index";
    }
	
	@RequestMapping("search")
    public void search(HttpServletRequest req,HttpServletResponse response){
		logger.debug("1111111");
		System.out.println("233333333333333");
        Map<String, Object> parmMap = new HashMap<String, Object>();
//        parmMap.put("id", req.getParameter("id"));
        parmMap.put("page", Integer.valueOf(req.getParameter("page")));
        parmMap.put("limit", Integer.valueOf(req.getParameter("limit")));
        System.out.println("233333333333333: " + parmMap);
        logger.debug("parm : " + parmMap);
        List list = userService.getData(parmMap);
        System.out.println("List : " + list.toString());
        /*return "search";*/
    }
}
