package org.serratec.aprendendo_na_comunidade.repository;

import org.serratec.aprendendo_na_comunidade.domain.CategoriaCurso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaCursoRepository 
       extends JpaRepository<CategoriaCurso, Long> {

}