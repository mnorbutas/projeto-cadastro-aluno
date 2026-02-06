package com.senai.cadastroaluno.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.cadastroaluno.entities.Aluno;

// Interface que herda do JpaRepository, tipada com a Entidade (Aluno) e o tipo do ID (Long)
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    // Nenhuma implementação necessária: O Spring gera métodos como save(), findAll() e deleteById() em tempo de execução
}