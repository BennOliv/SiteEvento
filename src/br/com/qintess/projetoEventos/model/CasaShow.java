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
@Table(name="casa_de_show")
public class CasaShow {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="nome", nullable = false, length = 50)
	private String nome;
	
	@Column(name="logradouro", nullable = false)
	private String logradouro;
	
	@Column(name="numero", nullable = false, length = 10)
	private String numero;
	
	@Column(name="cidade", nullable = false, length = 30)
	private String cidade;
	
	@Column(name="estado", nullable = false, length = 19)
	private String estado;
	
	@Column(name="capacidade_comum", nullable = false)
	private int capacidadeComum;
	
	@Column(name="capacidade_vip", nullable = false)
	private int capacidadeVip;

	@OneToMany(mappedBy = "local", fetch = FetchType.LAZY)
	private List<Evento> eventos;
	
	public CasaShow() {
	}

	@Override
	public String toString() {
		return "CasaShow [id=" + id + ", nome=" + nome + ", logradouro=" + logradouro + ", numero=" + numero
				+ ", cidade=" + cidade + ", estado=" + estado + ", capacidadeComum=" + capacidadeComum
				+ ", capacidadeVip=" + capacidadeVip + "]";
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

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getCapacidadeComum() {
		return capacidadeComum;
	}

	public void setCapacidadeComum(int capacidadeComum) {
		this.capacidadeComum = capacidadeComum;
	}

	public int getCapacidadeVip() {
		return capacidadeVip;
	}

	public void setCapacidadeVip(int capacidadeVip) {
		this.capacidadeVip = capacidadeVip;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}
	
	public void setEvento(Evento evento) {
		if(eventos == null) {
			eventos = new ArrayList<>();
		}
		eventos.add(evento);
		evento.setLocal(this);
	}
	
}
