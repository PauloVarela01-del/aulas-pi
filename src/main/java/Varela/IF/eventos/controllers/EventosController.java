package Varela.IF.eventos.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import Varela.IF.eventos.models.Convidado;
import Varela.IF.eventos.models.Evento;
import Varela.IF.eventos.repository.ConvidadoRepository;
import Varela.IF.eventos.repository.EventoRepositoy;
import ch.qos.logback.core.model.Model;

@Controller
@RequestMapping("/eventos")
public class EventosController {

	@Autowired
	private EventoRepositoy er;
	@Autowired
	private ConvidadoRepository cr;
	
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
	
	@GetMapping("/{id}")
	public ModelAndView detalhar(@PathVariable long id) {
		ModelAndView md = new ModelAndView();
		Optional<Evento> opt = er.findById(id);
		if(opt.isEmpty()) {
			md.setViewName("redirect:/eventos");
			return md;
		}
		
		md.setViewName("eventos/detalhes");
		Evento eventos = opt.get();
		
		List<Convidado> convidado = cr.findAll();
		md.addObject("convidados", convidado);
		
		return md;
	}
	@PostMapping("/{idEvento}")
	public String salvarConvidade(@PathVariable long idEvento, Convidado convidado) {
		
		System.out.println("Id do evento: "+idEvento);
		System.out.println(convidado);
		
		Optional<Evento> opt = er.findById(idEvento);
		if(opt.isEmpty()) {
			return "redirect:/eventos/{idEvento}";
		}
		
		Evento evento = opt.get();
		convidado.setEvento(evento);
		
		cr.save(convidado);
		return "redirect:/evento/{id}";
	}
}

