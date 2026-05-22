package org.serratec.aprendendo_na_comunidade.repository;

import org.serratec.aprendendo_na_comunidade.domain.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository 
       extends JpaRepository<Curso, Long> {

}