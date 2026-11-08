# 🧮 Calculadora Java

Programa de terminal em **Java** com menu interativo para calcular **média de notas**, **áreas de figuras geométricas** e **juros simples e compostos**.

## ✨ Funcionalidades

| Opção | O que faz | Fórmula |
|---|---|---|
| Média de notas | Calcula a média e informa se o aluno está aprovado, em recuperação ou reprovado | soma das notas / quantidade |
| Área do quadrado | | lado² |
| Área do retângulo | | base × altura |
| Área do círculo | | π × raio² |
| Área do triângulo | | (base × altura) / 2 |
| Área do losango | | (diagonal maior × diagonal menor) / 2 |
| Área do trapézio | | ((base maior + base menor) × altura) / 2 |
| Juros simples | Juros e montante | J = C × i × t |
| Juros compostos | Juros e montante | M = C × (1 + i)^t |

**Regras da situação do aluno:** média ≥ 7 → Aprovado(a); média ≥ 5 → Recuperação; abaixo disso → Reprovado(a).

O programa valida os dados digitados (letras no lugar de números, valores negativos, notas fora do intervalo de 0 a 10) e aceita decimais com vírgula, como `8,5`.

## 📁 Estrutura do projeto

```
calculadora-java/
├── src/
│   └── calculadora/
│       ├── Main.java         # menu e leitura dos dados
│       ├── Notas.java        # média e situação do aluno
│       ├── Geometria.java    # áreas
│       └── Financeiro.java   # juros
├── test/
│   └── calculadora/
│       └── Testes.java       # testes automatizados simples
├── .gitignore
├── LICENSE
└── README.md
```

## ▶️ Como executar

Pré-requisito: **JDK 21 ou superior** (confira com `java -version` e `javac -version`).

```bash
# 1. Clonar o repositório
git clone https://github.com/alejandra-apaza-tech/calculadora-java.git
cd calculadora-java

# 2. Compilar
javac -encoding UTF-8 -d bin src/calculadora/*.java

# 3. Executar
java -cp bin calculadora.Main
```

Pelo **VS Code**: instale o *Extension Pack for Java*, abra a pasta do projeto, abra `src/calculadora/Main.java` e clique em **Run** acima do método `main`.

> **Dica (Windows):** se os acentos aparecerem estranhos no terminal, rode `chcp 65001` antes de executar o programa.

## 🧪 Como rodar os testes

```bash
javac -encoding UTF-8 -d bin src/calculadora/*.java test/calculadora/*.java
java -cp bin calculadora.Testes
```

Se tudo estiver certo, o final da saída mostra `19 testes, 0 falha(s).`

## 💻 Exemplo de uso

```
==================================================
            CALCULADORA JAVA
==================================================
1 - Média de notas
2 - Área de figuras geométricas
3 - Juros simples
4 - Juros compostos
0 - Sair
Escolha uma opção: 1

Nome do aluno(a): Alejandra
Quantas notas? 4
Nota 1: 10
Nota 2: 8,5
Nota 3: 9
Nota 4: 8

Média de Alejandra: 8,88
Situação: Aprovado(a)
```

## 🔧 Ideias para evoluir

- [ ] Adicionar mais figuras (pentágono, elipse)
- [ ] Salvar o histórico de cálculos em arquivo
- [ ] Migrar os testes para JUnit com Maven ou Gradle
- [ ] Criar uma interface gráfica (Swing ou JavaFX)

## 👩‍💻 Autora

**Alejandra Apaza** — [@alejandra-apaza-tech](https://github.com/alejandra-apaza-tech)

## 📄 Licença

Distribuído sob a licença MIT. Veja o arquivo [LICENSE](LICENSE).
