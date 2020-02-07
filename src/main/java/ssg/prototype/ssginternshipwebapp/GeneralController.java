package ssg.prototype.ssginternshipwebapp;

//import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GeneralController {
	//private final AtomicLong counter = new AtomicLong();
	
	@GetMapping("/")
	public String getIndex(Model model) {
		return "index";
	}
}
