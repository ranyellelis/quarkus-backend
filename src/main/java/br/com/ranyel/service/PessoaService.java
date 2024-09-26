package br.com.ranyel.service;

import java.util.List;

import br.com.ranyel.domain.Pessoa;
import br.com.ranyel.repository.PessoaRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@RequestScoped
public class PessoaService {

	@Inject
	private PessoaRepository repository;

	public Pessoa buscarPessoa(Long id) {
		return repository.findById(id);
	}
	
	@Transactional
	public void incluirPessoa(Pessoa p) {
		repository.persist(p);
	}
	
	@Transactional
	public Pessoa alterarPessoa(Pessoa p) {
		repository.persist(p);
		return p;
	}
	
	@Transactional
	public void removerPessoa(Long id) {
		repository.deleteById(id);
	}

	public List<Pessoa> buscarTodos() {
		return repository.listAll();
	}
}