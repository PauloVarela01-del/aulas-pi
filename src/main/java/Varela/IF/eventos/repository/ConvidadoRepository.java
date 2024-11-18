package Varela.IF.eventos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Varela.IF.eventos.models.Convidado;
import Varela.IF.eventos.models.Evento;

public interface ConvidadoRepository extends JpaRepository<Convidado, Long> {
	
 List<Convidado> findByEvento(Evento evento);
 

}
