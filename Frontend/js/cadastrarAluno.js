// Adiciona um "ouvinte" para o evento de submit do formulário
document.getElementById('alunoForm').addEventListener('submit', async (event) => {
    event.preventDefault(); // Impede que a página recarregue (comportamento padrão do HTML)

    // Captura os valores dos inputs do HTML
    const id = document.getElementById('alunoId').value;
    const aluno = {
        nome: document.getElementById('nome').value,
        turma: document.getElementById('turma').value,
        ra: document.getElementById('ra').value
    };

    if (id) {
        // Se existe ID, chama a função de atualizar (que estará no arquivo editarAluno.js)
        atualizarAluno(id, aluno);
    } else {
        // Se NÃO existe ID, executa o cadastro (POST)
        await fetch(API_URL, { // Faz a requisição para http://localhost:8080/alunos
            method: 'POST', // Define o método HTTP de criação
            headers: { 'Content-Type': 'application/json' }, // Avisa o Back que estamos mandando JSON
            body: JSON.stringify(aluno) // Converte o objeto JS para texto JSON
        });

        document.getElementById('alunoForm').reset(); // Limpa os campos do formulário
        carregarTabela(); // Atualiza a lista lá embaixo (função do listarAlunos.js)
    }
});