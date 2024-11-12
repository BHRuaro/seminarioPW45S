package br.edu.utfpr.pw45s.service;

import br.edu.utfpr.pw45s.model.Pessoa;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import br.edu.utfpr.pw45s.repository.PessoaRepository;
import jakarta.transaction.Transactional;

import java.util.List;

@RequestScoped
public class PessoaService {

    @Inject
    protected PessoaRepository pessoaRepository;

    @Transactional
    public void create(Pessoa pessoa) {
            pessoaRepository.save(pessoa);
    }

    @Transactional
    public void update(Pessoa pessoa) {
            pessoaRepository.save(pessoa);
    }

    @Transactional
    public void delete(Long id) {
            pessoaRepository.deleteById(id);
    }
    @Transactional
    public Pessoa getById(Long id) {
            return pessoaRepository.findById(id).get();
    }

    @Transactional
    public List<Pessoa> getAll() {
            return pessoaRepository.findAll();
    }
}
