// Função chamada ao clicar no botão "Editar" da tabela
function preencherFormulario(id, nome, turma, ra) {
    document.getElementById('alunoId').value = id; // Define o ID oculto (sinaliza que é uma edição)
    document.getElementById('nome').value = nome; // Preenche o campo Nome
    document.getElementById('turma').value = turma; // Preenche o campo Turma
    document.getElementById('ra').value = ra; // Preenche o campo RA
}

// Função chamada pelo submit do formulário quando existe um ID
async function atualizarAluno(id, aluno) {
    await fetch(`${API_URL}/${id}`, { // Faz a requisição PUT para a URL específica (ex: .../alunos/1)
        method: 'PUT', // Define o método HTTP de atualização
        headers: { 'Content-Type': 'application/json' }, // Avisa que o corpo é JSON
        body: JSON.stringify(aluno) // Envia os dados atualizados
    });

    document.getElementById('alunoId').value = ''; // Limpa o ID oculto para voltar ao modo "Cadastro"
    document.getElementById('alunoForm').reset(); // Limpa os campos visuais
    carregarTabela(); // Atualiza a tabela com os dados novos
}