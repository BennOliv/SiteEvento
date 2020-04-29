package br.com.qintess.projetoEventos.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cargo")
public class Cargo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="nome", length = 25, nullable = false)
	private String nome;
	
	@OneToMany(mappedBy = "cargo",fetch = FetchType.EAGER)
	private List<Usuario> usuarios;
	
	public void addUser(Usuario user) {
		if(usuarios == null)
			usuarios = new ArrayList<>();
		
		usuarios.add(user);
		user.setCargo(this);
	}

	public Cargo() {
	}

	public Cargo(String nome, List<Usuario> usuarios) {
		this.nome = nome;
		this.usuarios = usuarios;
	}

	@Override
	public String toString() {
		return "Cargo [id=" + id + ", nome=" + nome + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
}

