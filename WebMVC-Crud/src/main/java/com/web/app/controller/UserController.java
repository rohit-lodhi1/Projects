package com.web.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.app.entity.User;
import com.web.app.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
//   @Autowired(required = false)
//   private UserService userService;
//    
//   @GetMapping("")
//   public String getUsers(ModelMap model) {
//	   List<User> users = this.userService.getUsers();
//	     System.out.println();
//	    model.addAttribute("userList",users );
//	    return "userHome";
//   }
//   
//   @PostMapping("/add")
//   public String addUser(@ModelAttribute User user,Model model) {
//	   
//	     this.userService.createUser(user);
//	     List<User> users = this.userService.getUsers();
//	     System.out.println();
//	    model.addAttribute("userList",users );
//	     model.addAttribute("msg", "Successfully added");
//	       return "userHome";
//   }
//   
//   @GetMapping("/add-user")
//   public String addUserPage() {
//	   System.out.println("addUser");
//	   return "addUser";
//   }
//   
//   
//   @GetMapping("/edit/{id}")
//   public String editUser(@PathVariable("id") Integer id,Model model) {
//	    User user1 = this.userService.getUserByID(id);
//	     model.addAttribute("user", user1);
//	     return "editUser";
//	    
//   }
//   @PostMapping("/update")
//   public String updateUser(@ModelAttribute User user,Model model) {
//	   
//	   this.userService.updateUser(user);
//	   model.addAttribute("msg", "Successfully updated");
//	   return "userHome";
//   }
//   
//   @GetMapping("/delete/{id}")
//   public String deletUser(@PathVariable("id") Integer id ,Model model) {
//	   this.userService.deleteUser(id) ;
//	   List<User> users = this.userService.getUsers();
//	     System.out.println();
//	    model.addAttribute("userList",users );
//	   model.addAttribute("msg", "Deleted Successfully ");
//	   model.addAttribute("check", true);
//	   return "userHome";
//   }
//   
   
}
