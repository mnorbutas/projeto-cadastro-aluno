package com.senai.cadastroaluno.services;


import java.util.List; // Importa classe de Lista

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.cadastroaluno.entities.Aluno;
import com.senai.cadastroaluno.repositories.AlunoRepository;

@Service // Registra esta classe no contexto do Spring como um componente de serviço
public class AlunoService {

    @Autowired // Injeta automaticamente a instância do repositório
    private AlunoRepository repository;

    public List<Aluno> listarTodos() { // Método para buscar todos os registros
        return repository.findAll(); // Chama o repositório para trazer a lista completa
    }

    public Aluno salvar(Aluno aluno) { // Método para salvar um novo aluno
        return repository.save(aluno); // Persiste o objeto no banco de dados
    }

    public Aluno atualizar(Long id, Aluno alunoAtualizado) {

    Aluno alunoAntigo = repository.findById(id).orElse(null); // Busca o aluno no banco pelo ID
    
        if (alunoAntigo != null) { // Verifica se o registro antigo foi encontrado
        
        alunoAtualizado.setId(id); // Vincula o ID da URL ao objeto atualizado.
        return repository.save(alunoAtualizado); // Retorna o objeto salvo
        }
    return null; // Retorna nulo caso o aluno não tenha sido encontrado
        }

    public boolean deletar(Long id) { // Método para remover um aluno
        if (repository.existsById(id)) { // Verifica a existência do registro
            repository.deleteById(id); // Executa a exclusão física no banco
            return true; // Retorna verdadeiro confirmando a exclusão
        }
        return false; // Retorna falso se o aluno não foi encontrado
    }
}