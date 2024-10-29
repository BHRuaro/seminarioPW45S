package br.edu.utfpr.pw45s.repository;

import br.edu.utfpr.pw45s.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
