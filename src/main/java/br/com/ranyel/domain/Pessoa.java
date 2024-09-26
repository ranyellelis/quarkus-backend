package br.com.ranyel.domain;

import java.io.Serializable;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(schema = "dbo", name = "Pessoa")
public class Pessoa extends PanacheEntityBase implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;
	private String nome;
	private Integer idade;
	private String cpf;
	
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public Integer getIdade() {
		return idade;
	}
	public String getCpf() {
		return cpf;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
