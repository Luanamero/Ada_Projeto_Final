# Resumo do Projeto: Criar uma agenda de contatos
**Membros:**

| [**Carlos**](http://github.com/gonzaga95/) | [**Catarine Gonçalves**](https://github.com/catarinegoncalves) | [**Erick**](https://github.com/Erick-sr) | [**Luana de Méro**](https://github.com/Luanamero) | [**Victor Faria**](https://github.com/victot-exe) |
|---|---|---|---|---|




## Quais foram os desafios no projeto?
Os desafios do projeto começaram no momento de entender o que foi proposto e pensar em soluções para isto, tivemos a sorte de ter um grupo que conseguiu trabalhar muito bem junto e deixou todos participarem.  
A primeiro momento, trabalhar com arrays é um pouco limitado, ainda mais para uma agenda telefonica, onde não sabemos qual será o número de contatos para ser armazenado.  
Outro desafio foi a questão de fazer a verificação se o telefone já existia na agenda para permitir a inserção do mesmo na lista telefonica.

## O que foi mais interessante?
Achamos bem interessante trabalhar com o grupo e explorar as possibilidades das arrays, até pensar nos métodos que utilizamos, cada um dando ideias e soluções cada vez melhorando mais o projeto.

## O que pode ser melhorado?
Acho que a primeira coisa que melhorariamos seria mudar a utilização das arrays e adicionando ai a Orientação a objetos ~que aprenderemos no próximo módulo~ nos permitiria muito mais otimizar os métodos e verificações necessárias.

## Explicação dos métodos:
*  `Menu.menu()` -> Um método que utiliza o `do{}while()` para exibição do menu no terminal e o `switch()case:` para a escola da ação.
* `Agenda.numeroDeRegistro()` -> verifica se tem algum registro inserido na base de dados.
* `Agenda.validacaoDeInt()` -> verifica se os caracteres digitados são numeros, para a validação de numero de telefone.
* `Agenda.telefoneContaNaBase()` -> valida se o numero digitado já consta na base de dados.
* `Agenda.adicionarContato()` -> adiciona um novo contato na base, pedindo os dados necessários e fazendo as verificações para a inclusão na array.
* `Agenda.exibirContatos()` -> primeiro verifica se existe algum contato na base e depois disso exibe os dados atravez de um `for`, utilizando o `if`para não exibir os contatos `null` ou os que foram excluidos.
* `Agenda.buscarContato()` -> primeiro verifica se a agenda está com algum registro, se tiver ele utiliza um `for` para pesquisar o telefone desejado, após encontrar ele verifica pelo `if`e para a repetição, caso ele não econtre ele avisa o usuário.
* `Agenda.editarContato()` -> utiliza um método bem parecido com o `Agenda.buscarContato()` mas após encontrar o contato ele pede as modificações.
* `Agenda.removerContato()` -> primeiro verifica se a base de dados possui algum registro, se tiver ele valida se apenas números foram digitados e utiliza um `for` para percorrer a base e quando encontrar o telefone ele define os dados do contato desejado para `""` vazio.

