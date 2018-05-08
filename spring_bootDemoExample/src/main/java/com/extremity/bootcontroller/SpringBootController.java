package com.extremity.bootcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.extremity.model.User;
import com.extremity.service.Iservice;

@Controller
public class SpringBootController {

	@Autowired
	private Iservice iservice;
	@RequestMapping("/")
	public String welcome()
	{
		System.out.println("index page...");
		return "index";
	}
	@RequestMapping("/registerPage")
	public String register()
	{
		System.out.println("in registration page...");
		return "registration";
	}
	
	@RequestMapping(value="/addUser",method=RequestMethod.GET)
	public ModelAndView addUser(@ModelAttribute User user,BindingResult br){
		System.out.println("in add user...");
		System.out.println(user.getName());
		System.out.println(user.getAddress());
		System.out.println(user.getUid());
		System.out.println(user.getUname());
		iservice.saveUser(user);
		System.out.println("user is added....");
		
		return new ModelAndView("index","msg","Login Successfull...");
		
	}
	
	
	
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView loginUser(@ModelAttribute User user)
	{
		System.out.println("in login.....");
		int id=iservice.loginCheck(user);
		if(id>0)
		{
			System.out.println("in if.................");
			List<User> listUser=iservice.displayAll(user);
			System.out.println("DATA====="+listUser);
			return new ModelAndView("successs","userList",listUser);
		}
		return new ModelAndView("index","msg","Enter valid username and Password...");
	}
	
	@RequestMapping(value="/delete")
	public ModelAndView deleteUser(@ModelAttribute User user)
	{
		System.out.println("in delete......");
		System.out.println(user.getUid());
	
		int id=iservice.deleteUser(user);
		List<User> listUser=iservice.displayAll(user);
		if(id>0)
		{
			return new ModelAndView("successs","userList",listUser);
		}
		return new ModelAndView("successs","userList",listUser);
	}
	@RequestMapping("/edit")
	public ModelAndView editUser(@ModelAttribute User user)
	{
		System.out.println("in edit .......");
		
		System.out.println(user.getUid());
		User u=iservice.editUser(user);
		return new ModelAndView("edit","data",u);
	}
	
	@RequestMapping(value="/update")
	public ModelAndView updateUser(@ModelAttribute User user)
	{
		int id=iservice.updateUser(user);
		List<User> listUser=iservice.displayAll(user);
		if(id>0)
		{
			return new ModelAndView("successs","userList",listUser);
		}
		return new ModelAndView("successs","userList",listUser);
	}
}
