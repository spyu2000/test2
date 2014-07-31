package com.spyu.action;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.spyu.bean.RoleInfo;
import com.spyu.bean.UserInfo;
import com.spyu.service.UserInfoService;


@Controller
@RequestMapping(value="/home")
public class UserController {

	private UserInfoService userInfoService=null;
	
	@Resource(name="userInfoService")
	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

	@RequestMapping(value="/hello1",method=RequestMethod.GET)
	public @ResponseBody String helloWorld1(@RequestParam("userId")String userId){
		System.out.println("helloWorld:"+userId);		
		return "hello:"+userId;
	}
	@RequestMapping(value="/hello2",method=RequestMethod.GET)
	public @ResponseBody String helloWorld2(@RequestParam("userId")String userId,@RequestParam("userName")String userName){
		System.out.println("helloWorld:"+userId+"  "+userName);
		this.userInfoService.findByName(userName);
		return "hello:"+userId+"  "+userName;
	}
	
	@RequestMapping(value="/hello3",method=RequestMethod.POST)
	public @ResponseBody String helloWorld3(@RequestParam("roleId")String roleId,@RequestParam("roleName")String roleName){
		System.out.println("hello:"+roleId+"  "+roleName);
		return "hello:"+roleId+"  "+roleName;
		
	}

	@RequestMapping(value="/hello4",method=RequestMethod.POST)
	public @ResponseBody Map<String, String> helloWorld4(@RequestBody RoleInfo roleInfo){
		System.out.println("hello:"+roleInfo.getRoleId()+"  "+roleInfo.getRoleName());
		Map<String, String> result=new HashMap<String, String>();
		result.put("success", "true");
		return result;
		
	}
	
	@RequestMapping(value = "/hello5/{id}/{name}/{status}", method = RequestMethod.GET)
	public @ResponseBody
	Map<String,String>
	helloWorld5(@PathVariable int id, @PathVariable String name,
			@PathVariable boolean status) {
		System.out.println("hello:"+id+"  "+name+"  "+status);
		Map<String, String> result=new HashMap<String, String>();
		result.put("id", id+"");
		result.put("name", name);
		result.put("status", status+"");
		return result;
	}
	
	
	@RequestMapping(value="/hello6" ,method=RequestMethod.POST)
	public String login(@ModelAttribute("roleInfo") RoleInfo roleInfo, ModelMap model) {
			System.out.println("hello:"+roleInfo.getRoleId()+"  "+roleInfo.getRoleName());
		String message = "login.fail";
		model.addAttribute("message", message);
			//跳转到/index 链接 
		return "redirect:/index.jsp";
	}
	
}
