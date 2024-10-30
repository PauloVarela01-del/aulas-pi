package Varela.IF.eventos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Varela.IF.eventos.models.Evento;

@Controller
public class EventosController {

	@RequestMapping("/eventos/form")
	public String form() {
		System.out.println("Chame o formulário");
		
		
				return "formEvento";
		}
		
	@PostMapping("/eventos")
		public String adicionar(Evento evento) {
		
		System.out.println(evento);
		
			return "evento-adicionado";
		}
}

