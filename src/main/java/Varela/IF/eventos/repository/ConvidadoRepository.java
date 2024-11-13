package Varela.IF.eventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Varela.IF.eventos.models.Convidado;

public interface ConvidadoRepository extends JpaRepository<Convidado, Long> {

}
