package org.serratec.aprendendo_na_comunidade.repository;

import org.serratec.aprendendo_na_comunidade.domain.PerfilSocial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilSocialRepository 
       extends JpaRepository<PerfilSocial, Long> {

}