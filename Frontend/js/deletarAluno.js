// Função chamada ao clicar no botão "Excluir" da tabela
async function deletarAluno(id) {
    // Exibe um alerta de confirmação nativo (OK/Cancelar)
    if (confirm("Tem certeza que deseja excluir este aluno?")) {
        
        await fetch(`${API_URL}/${id}`, { // Faz a requisição DELETE para URL com ID (ex: .../alunos/5)
            method: 'DELETE' // Define o método HTTP de exclusão
        });

        carregarTabela(); // Recarrega a lista para sumir com o item excluído
    }
}