package br.com.qintess.projetoEventos.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="evento")
public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="nome", length = 20, nullable = false)
	private String nome;
	
	@Column(name="descricao", nullable = false)
	private String descricao;
	
	@Column(name="data",nullable = false)
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate data;
	
	@Column(name="hr_abertura", nullable = true)
	private LocalTime hrAbertura;
	
	@Column(name="hr_encerramento", nullable = true)
	private LocalTime hrEncerramento;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "id_casa_show")
	private CasaShow local;
	
	@Lob
	@Column(columnDefinition = "mediumblob")
	private byte[] imagemEvento;
	
	@Transient
	private String imagemEncoded;
	
	@OneToMany(mappedBy = "evento",orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Ingresso> ingressos;

	public Evento() {
	}

	@Override
	public String toString() {
		return "Evento [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", data=" + data + ", hrAbertura="
				+ hrAbertura + ", hrEncerramento=" + hrEncerramento + ", local=" + local + "imagem: " + (imagemEvento.length!=0 ? "notEmpty" : "Empty" + "]");
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalTime getHrAbertura() {
		return hrAbertura;
	}

	public void setHrAbertura(LocalTime hrAbertura) {
		this.hrAbertura = hrAbertura;
	}

	public LocalTime getHrEncerramento() {
		return hrEncerramento;
	}

	public void setHrEncerramento(LocalTime hrEncerramento) {
		this.hrEncerramento = hrEncerramento;
	}

	public CasaShow getLocal() {
		return local;
	}

	public void setLocal(CasaShow local) {
		this.local = local;
	}
	
	public List<Ingresso> getIngressos() {
		return ingressos;
	}

	public void setIngressos(List<Ingresso> ingressos) {
		this.ingressos = ingressos;
	}

	public byte[] getImagemEvento() {
		return imagemEvento;
	}

	public void setImagemEvento(byte[] imagemEvento) {
		this.imagemEvento = imagemEvento;
	}

	public String getImagemEncoded() {
		return imagemEncoded;
	}

	public void setImagemEncoded(String imagemEncoded) {
		this.imagemEncoded = imagemEncoded;
	}

	public void addIngresso(Ingresso ingresso) {
		if(ingressos == null) {
			ingressos = new ArrayList<>(); 
		}
		ingressos.add(ingresso);
		ingresso.setEvento(this);
	}
}