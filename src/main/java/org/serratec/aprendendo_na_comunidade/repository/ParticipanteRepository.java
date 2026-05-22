package org.serratec.aprendendo_na_comunidade.repository;

import org.serratec.aprendendo_na_comunidade.domain.Participante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipanteRepository 
       extends JpaRepository<Participante, Long> {

}