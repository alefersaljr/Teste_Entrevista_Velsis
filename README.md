# teste-entrevista-velvis
Praticas RESTful

Querys SQL para:
- Criar banco de dados
> CREATE DATABASE Entrevista
- Utilizar banco de dados criado
> USE Entrevista
- Criar tabela de hóspedes
> CREATE TABLE Pessoas (Id INT PRIMARY KEY NOT NULL, nome VARCHAR (50), documento VARCHAR (50), telefone VARCHAR (50))
- Inserir novo hóspede
> INSERT INTO Pessoas (Id, nome, documento, telefone) VALUES ([ID], "[NOME]", "[DOCUMENTO]", "[TELEFONE]")
- Deletar hóspede
> DELETE FROM Pessoas WHERE Id = [ID]
- Alterar dados do hóspede (EXEMPLO)
> UPDATE Pessoas SET Telefone = "41988619505" WHERE Id = 1
- Buscar hóspedes cadastrados pelo nome
> SELECT * FROM pessoas WHERE nome = '[NOME]'
- Buscar hóspedes cadastrados pelo documento
> SELECT * FROM pessoas WHERE documento = '[DOCUMENTO]'
- Buscar hóspedes cadastrados pelo telefone
> SELECT * FROM pessoas WHERE telefone = '[TELEFONE]'

