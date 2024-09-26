package br.com.ranyel.repository;

import br.com.ranyel.domain.Pessoa;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class PessoaRepository implements PanacheRepositoryBase<Pessoa, Long> {

}
