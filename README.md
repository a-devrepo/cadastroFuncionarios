Este é um projeto simples em **Java 17** que permite o cadastro de funcionários e exporta os dados em formato **JSON**. O projeto é organizado em camadas para garantir a separação de responsabilidades e facilitar a manutenção.

## 🎯 Objetivo

O sistema permite ao usuário:

- Cadastrar funcionários com suas respectivas informações.
- Validar os dados de entrada.
- Exibir as informações no console.
- Escolher o diretório de exportação.
- Exportar os dados em formato JSON.

## 🧱 Estrutura do Projeto

O projeto é dividido em pacotes conforme as responsabilidades:

### `controllers`
Contém a lógica de controle da aplicação.

- `FuncionarioController`: Controla o fluxo principal da aplicação, incluindo uma classe de validação dos dados de entrada.


### `views`
Contém as classes responsáveis pela interação com o usuário via console.

- `ConsoleInput`: Coleta informações do usuário.
- `ConsoleOutput`: Exibe mensagens e dados no console.
- `DirectoryView`: Permite ao usuário escolher o diretório onde o arquivo JSON será salvo.

### `exceptions`
Pacote dedicado para exceções personalizadas lançadas durante o processamento da aplicação.

### `entities`
Modelos de domínio utilizados no projeto.

- `Pessoa`: Classe base para representar uma pessoa.
- `Funcionario`: Estende `Pessoa`, adicionando informações funcionais.
- `Funcao`: Representa o cargo ou função de um funcionário.
- `Setor`: Representa o setor em que o funcionário atua.

### `repositories`
Contém abstrações e implementações para persistência/exportação de dados.

- `FuncionariosRepository`: Interface de repositório para persistência de dados.
- Implementação em JSON: Exporta os dados dos funcionários em um arquivo `.json`.

### `principal`
Pacote principal onde o projeto é iniciado.

- Instancia as classes principais.
- Invoca o método `exibirOpcoes()` da classe `FuncionarioController` para iniciar a aplicação.