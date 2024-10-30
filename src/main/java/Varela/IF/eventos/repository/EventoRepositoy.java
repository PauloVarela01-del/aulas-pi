package Varela.IF.eventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Varela.IF.eventos.models.Evento;

public interface EventoRepositoy extends JpaRepository<Evento, Long> {
	

}
