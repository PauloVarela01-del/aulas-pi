package Varela.IF.eventos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ModelAndViewMethodReturnValueHandler;

import Varela.IF.eventos.models.Evento;
import Varela.IF.eventos.repository.EventoRepositoy;

@Controller
@RequestMapping("/eventos")
public class EventosController {

	@Autowired
	private EventoRepositoy er;
	
	@GetMapping("/form")
	public String form() {
		System.out.println("Chame o formulário");
		
		
				return "eventos/formEvento";
		}
		
	@PostMapping("/eventos")
		public String adicionar(Evento evento) {
		
		System.out.println(evento);
		er.save(evento);
		
			return "eventos/evento-adicionado";
		}
	
	@GetMapping
	public ModelAndView Listar() {
		List<Evento> eventos = er.findAll();
		ModelAndView mv = new ModelAndView("Eventos/lista");
		mv.addObject("eventos", eventos);
		return mv;
	}
}

