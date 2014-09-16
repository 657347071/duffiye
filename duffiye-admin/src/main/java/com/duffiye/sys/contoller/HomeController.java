package com.duffiye.sys.contoller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.duffiye.core.annotation.Description;

@Controller("homeController")
public class HomeController {
	
	

	 public HomeController() {
		 System.out.println("============HomeController=============");
	 }

	//首页
    @RequestMapping(value = "/admin/index.html")
    @Secured("home")
    @Description("首页")
    public String home(ModelMap map) {
    	System.out.println("index controller");
        return "index";
    }

    @RequestMapping(value = "/admin/login.html", method = {RequestMethod.GET, RequestMethod.POST})
    public String login(ModelMap map) {
    	System.out.println("login controller");
        return "login";
    }

    @RequestMapping(value = "/accessDenied.html")
    public String accessDenied(ModelMap map) {
        return "accessDenied";
    }
	
}
