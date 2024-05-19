package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UsersController {

    final UserService userService;
    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showAllUsers(Model model) {
       model.addAttribute("allUsers", userService.getAllUsers()) ;
        return "users";
    }


    @GetMapping("/addNewUser")
    public String addNewUser(Model model) {
    User user = new User();
    model.addAttribute("user", user );
    return "adduser";
    }
@PostMapping("/saveUser")
    public String saveUser (@ModelAttribute ("user") User user){
        userService.saveUser(user);
        return  "redirect:/users";
    }

    @PostMapping("/deleteUser")
    public String deleteUser (@RequestParam ("id") int id){
        userService.deleteUser(id);
        return "redirect:/users";
    }
    @GetMapping ("/updateUser")
    public String  update(@RequestParam ("id") int id,Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "updateuser";
    }
    @PostMapping("/user")
    public String save (@RequestParam ("id") int id, @ModelAttribute("user") User user) {
        user.setId(id);
        userService.updateUser(user);
        return "redirect:/users";
    }
}
