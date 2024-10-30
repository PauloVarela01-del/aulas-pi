package Varela.IF.eventos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Varela.IF.eventos.models.Evento;
import Varela.IF.eventos.repository.EventoRepositoy;

@Controller
public class EventosController {

	@Autowired
	private EventoRepositoy er;
	
	@RequestMapping("/eventos/form")
	public String form() {
		System.out.println("Chame o formulário");
		
		
				return "formEvento";
		}
		
	@PostMapping("/eventos")
		public String adicionar(Evento evento) {
		
		System.out.println(evento);
		er.save(evento);
		
			return "evento-adicionado";
		}
}

