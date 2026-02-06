package com.senai.cadastroaluno.entities;

import jakarta.persistence.*; // Importa as anotações do JPA (banco de dados)
import jakarta.validation.constraints.NotBlank; // Importa validação para campos não vazios

@Entity // Indica ao Spring que esta classe representa uma tabela no banco
@Table(name = "alunos") // Define explicitamente o nome da tabela associada
public class Aluno {

    @Id // Marca este campo como a Chave Primária (Primary Key)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Configura o Auto-Incremento pelo banco
    private Long id; // Identificador único do aluno

    @NotBlank(message = "O nome é obrigatório") // Validação: rejeita nulo ou vazio
    private String nome; // Atributo para armazenar o nome do aluno

    @NotBlank(message = "A turma é obrigatória") // Validação: o aluno deve ter uma turma
    private String turma; // Atributo para armazenar a turma

    @NotBlank(message = "O RA é obrigatório") // Validação: RA é indispensável
    @Column(unique = true) // Configuração extra no banco para garantir unicidade
    private String ra; // Atributo para o Registro Acadêmico

    public Aluno() {} // Construtor vazio obrigatório para o funcionamento do Hibernate

    // Construtor completo para facilitar a criação de objetos em testes ou carga inicial
    public Aluno(String nome, String turma, String ra) {
        this.nome = nome; // Inicializa o nome
        this.turma = turma; // Inicializa a turma
        this.ra = ra; // Inicializa o RA
    }

    // Getters e Setters: Métodos padrão para acesso e modificação dos atributos encapsulados
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getTurma() { return turma; }
    public void setTurma(String turma) { this.turma = turma; }
    public String getRa() { return ra; }
    public void setRa(String ra) { this.ra = ra; }
}