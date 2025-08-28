# Documentação da Aplicação de Gerenciamento de Ativos

Esta documentação descreve os métodos principais da classe `Main` de uma aplicação em Java para gerenciar uma carteira de investimentos.

---

### `main(String[] args)`

Este é o **ponto de entrada** da aplicação. Ele inicia a interface de usuário em modo console, apresentando um menu interativo que permite ao usuário escolher entre várias opções. O menu é exibido repetidamente em um loop `do-while` até que o usuário decida sair.

-   **Função**: Exibe o menu principal e gerencia a navegação entre as funcionalidades.
-   **Controle de Fluxo**: Usa um `switch` para direcionar a execução para o método correspondente à opção escolhida.
-   **Robustez**: Inclui um bloco `try-catch-finally` para tratar erros de entrada inesperados e garantir que os recursos (como o `Scanner`) sejam fechados corretamente.

---

### `saveActive()`

Permite ao usuário **adicionar um novo ativo** à carteira.

-   **Entrada**: Solicita o código, a quantidade e o preço unitário do ativo.
-   **Processamento**: Cria um objeto `Active` com os dados inseridos e chama o método `ActiveService.save()` para persistir as informações.
-   **Feedback**: Fornece uma mensagem de sucesso ou um alerta de erro caso a entrada seja inválida.

---

### `listActives()`

Exibe a **lista completa de todos os ativos** da carteira.

-   **Processamento**: Obtém a lista de ativos através do método `ActiveService.getActiveList()`.
-   **Saída**:
    -   Se a lista estiver vazia, exibe uma mensagem indicando **"Lista vazia!"**.
    -   Caso contrário, percorre a lista e imprime os detalhes de cada ativo, incluindo código, valor unitário, valor total e a data da compra.

---

### `reportSale()`

Permite ao usuário **registrar a venda** de uma quantidade específica de um ativo existente.

-   **Entrada**: Solicita o código do ativo e a quantidade que será vendida.
-   **Validação**:
    -   Primeiro, verifica se o ativo existe na carteira.
    -   Em seguida, checa se a quantidade a ser vendida é menor ou igual à quantidade disponível.
-   **Processamento**: Se a validação for bem-sucedida, chama `ActiveService.reportSale()` para processar a transação.
-   **Feedback**: Exibe uma mensagem de sucesso ou um erro, caso o ativo não seja encontrado ou a quantidade seja insuficiente.

---

### `investmentSummary()`

Calcula e exibe um **resumo do valor total** da carteira de investimentos.

-   **Processamento**: Invoca o método `ActiveService.investmentSummary()` para obter o valor consolidado da carteira.
-   **Saída**: Imprime o resultado na tela do console.

---

### Métodos Auxiliares

-   `space()`: Um método simples para **limpar a tela** do console, imprimindo dez linhas em branco para melhorar a organização visual.
-   `optionReturnSummary()`: Método privado que **padroniza a mensagem** de retorno ao menu principal, evitando a repetição de código. Ele exibe **"-> 0 - Retornar ao menu"** e aguarda a próxima entrada do usuário.