package ssg.prototype.ssginternshipwebapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public String getAllUsers(Model model){
		model.addAttribute("users", userService.getAllUsers());
		return "user";
	}
	
	@GetMapping("/users/{id}")
	public String getUserById(Model model, @PathVariable long id) {
		model.addAttribute("user", userService.getUserById(id));
		return "user_detail";
	}
	
	@PostMapping("/users/new")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		return ResponseEntity.ok().body(userService.createUser(user));
	}
	
	@PostMapping("/users/{id}")
	public String updateUser(Model model, @PathVariable long id, 
			@ModelAttribute("user") User user) {
		model.addAttribute("task", "user");
		model.addAttribute("user", userService.updateUser(user));
		return "success";
	}
	
	@RequestMapping("/users/success")
	public void success() {
	}
	
	@DeleteMapping("/users/{id}")
	public HttpStatus deleteUser(@PathVariable long id) {
		userService.deleteUser(id);
		return HttpStatus.OK;
	}
}
