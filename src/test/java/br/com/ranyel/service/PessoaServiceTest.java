package br.com.ranyel.service;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import br.com.ranyel.domain.Pessoa;
import br.com.ranyel.repository.PessoaRepository;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class PessoaServiceTest {

	@InjectMocks
	PessoaService service;

	@Mock
	PessoaRepository repository;
	
	@BeforeEach
	void setUp() throws Exception {
		openMocks(this).close();
	}
	
	@Test
	public void listarComSucesso() {
		Pessoa p = new Pessoa();
		p.setNome("Teste");

		when(repository.listAll()).thenReturn(Arrays.asList(p));
		List<Pessoa> retorno = service.buscarTodos();
		Assertions.assertEquals(1, retorno.size());
	}
	
	@Test
	public void buscarPeloIdComSucesso() {
		Long id = 1l;
		
		Pessoa p = new Pessoa();
		p.setNome("Teste");

		when(repository.findById(id)).thenReturn(p);
		Pessoa retorno = service.buscarPessoa(id);
		Assertions.assertEquals("Teste", retorno.getNome());
	}
}
