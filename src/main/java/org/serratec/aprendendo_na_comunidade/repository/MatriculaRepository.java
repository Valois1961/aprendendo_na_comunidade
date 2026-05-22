package org.serratec.aprendendo_na_comunidade.repository;

import org.serratec.aprendendo_na_comunidade.domain.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository 
       extends JpaRepository<Matricula, Long> {

}