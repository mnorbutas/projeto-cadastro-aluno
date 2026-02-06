package com.senai.cadastroaluno.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.cadastroaluno.entities.Aluno;
import com.senai.cadastroaluno.services.AlunoService;

@RestController // Define a classe como um controlador REST que retorna JSON
@RequestMapping("/alunos") // Define o endereço base da API (http://localhost:8080/alunos)
@CrossOrigin(origins = "*") // Permite que o Frontend (que roda em outra porta) acesse a API
public class AlunoController {

    @Autowired // O Spring injeta o Service automaticamente
    private AlunoService service;

    @GetMapping // Mapeia requisições HTTP GET (Listar)
    public List<Aluno> listar() {
        return service.listarTodos(); // Retorna a lista de alunos direto como JSON
    }

   @PostMapping
public Aluno cadastrar(@RequestBody Aluno aluno) {
    // Retorna diretamente o objeto; o Spring entrega Status 200 automaticamente
    return service.salvar(aluno);
}

@PutMapping("/{id}")
public Aluno atualizar(@PathVariable Long id, @RequestBody Aluno aluno) {
    // Retorna o objeto atualizado ou null (baseado no seu Service anterior)
    return service.atualizar(id, aluno);
}

@DeleteMapping("/{id}")
public void deletar(@PathVariable Long id) {
    // Apenas executa a ação; o Spring retorna Status 200 por padrão ao finalizar
    service.deletar(id);
}
}