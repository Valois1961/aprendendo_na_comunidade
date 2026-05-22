package org.serratec.aprendendo_na_comunidade.dto;

public class ParticipanteDTO {

	private Long id;

	private String nome;

	private String email;

	private String perfilSocial;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPerfilSocial() {
		return perfilSocial;
	}

	public void setPerfilSocial(String perfilSocial) {
		this.perfilSocial = perfilSocial;
	}
}