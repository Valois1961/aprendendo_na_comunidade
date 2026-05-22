package org.serratec.aprendendo_na_comunidade.repository;

import org.serratec.aprendendo_na_comunidade.domain.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository 
       extends JpaRepository<Professor, Long> {

}