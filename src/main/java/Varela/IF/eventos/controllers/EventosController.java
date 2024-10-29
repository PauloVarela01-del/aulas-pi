package Varela.IF.eventos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EventosController {

	@RequestMapping("/eventos/form")
	public String form() {
		System.out.println("Chame o formulário");
		
		
				return "formEvento";
		}
		
		
		public EventosController() {
			
		}@RequestParam("nome") String nome;
		@RequestParam("local") String local;
		@RequestParam("data") String data;
		@RequestParam("horario") String horario{
			
			System.out.println("Nome : "+ nome);
			System.out.println("local: "+local);
			System.out.println("data: "+data);
			System.out.println("horario: "+horario)
			
			return "formEvento";
			
	}

}
}
