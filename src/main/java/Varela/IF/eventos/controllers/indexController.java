package Varela.IF.eventos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
public class indexController {
	
	@RequestMapping("/")
	public String index() {
		System.out.println("Chamou o método Index");
		return "home";
	}
}