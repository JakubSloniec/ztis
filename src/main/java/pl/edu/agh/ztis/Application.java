package pl.edu.agh.ztis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Jakub Sloniec on 21.03.2016.
 */

@Controller
@SpringBootApplication
//public class Application extends SpringBootServletInitializer {
public class Application {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

	@RequestMapping("/")
	public String swagger() {
		return "redirect:/swagger-ui.html";
	}
}
