// Função assíncrona que busca os dados no Backend e atualiza a tela
async function carregarTabela() {
    const response = await fetch(API_URL); // Faz uma requisição GET para o servidor Java
    const alunos = await response.json(); // Converte a resposta bruta para um array de objetos JSON

    const tabela = document.getElementById('corpoTabela'); // Seleciona o corpo da tabela no HTML
    tabela.innerHTML = ''; // Limpa a tabela para não duplicar dados antigos

    alunos.forEach(aluno => { // Percorre cada aluno retornado pelo banco
        // Cria uma linha (tr) com os dados do aluno e botões de ação com eventos onclick
        const linha = `
            <tr>
                <td>${aluno.ra}</td>
                <td>${aluno.nome}</td>
                <td>${aluno.turma}</td>
                <td>
                    <button class="btn-edit" onclick="preencherFormulario(${aluno.id}, '${aluno.nome}', '${aluno.turma}', '${aluno.ra}')">Editar</button>
                    <button class="btn-del" onclick="deletarAluno(${aluno.id})">Excluir</button>
                </td>
            </tr>
        `;
        tabela.innerHTML += linha; // Adiciona a nova linha ao HTML da tabela
    });
}

// Inicialização: Chama a função assim que o arquivo é lido para mostrar os dados iniciais
carregarTabela();