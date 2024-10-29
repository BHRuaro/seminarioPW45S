package br.edu.utfpr.pw45s.controller;

import br.edu.utfpr.pw45s.model.Pessoa;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import br.edu.utfpr.pw45s.repository.PessoaRepository;

import java.util.List;

@RequestScoped
public class PessoaController {

    @Inject
    protected PessoaRepository pessoaRepository;

        public void create(Pessoa pessoa) {
            pessoaRepository.save(pessoa);
        }

        public void update(Pessoa pessoa) {
            pessoaRepository.save(pessoa);
        }

        public void delete(Long id) {
            pessoaRepository.deleteById(id);
        }

        public Pessoa getById(Long id) {
            return pessoaRepository.findById(id).get();
        }

        public List<Pessoa> getAll() {
            return pessoaRepository.findAll();
        }
}
