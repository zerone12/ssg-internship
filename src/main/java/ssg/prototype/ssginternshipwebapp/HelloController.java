package ssg.prototype.ssginternshipwebapp;

//import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	private static final String template = "Hello %s!";
	//private final AtomicLong counter = new AtomicLong();
	
	@GetMapping({"/", "/greeting"})
	public String greeting(Model model, @RequestParam(value = "name", defaultValue = "World") String name) {
		model.addAttribute("name", name);
		return "hello";
		//return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}
