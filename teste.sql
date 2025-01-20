-- Criação do banco de dados
CREATE DATABASE ForumHub;
USE ForumHub;

-- Tabela de Perfis
CREATE TABLE Perfil (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL
);

-- Tabela de Usuários
CREATE TABLE Usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL,
    perfil_id INT,
    FOREIGN KEY (perfil_id) REFERENCES Perfil(id)
);

-- Tabela de Cursos
CREATE TABLE Curso (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    categoria VARCHAR(50) NOT NULL
);

-- Tabela de Tópicos
CREATE TABLE Topico (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(200) NOT NULL,
    mensagem TEXT NOT NULL,
    dataCriacao DATETIME DEFAULT CURRENT_TIMESTAMP,
    status ENUM('ABERTO', 'FECHADO', 'RESOLVIDO') NOT NULL,
    autor_id INT,
    curso_id INT,
    FOREIGN KEY (autor_id) REFERENCES Usuario(id),
    FOREIGN KEY (curso_id) REFERENCES Curso(id)
);

-- Tabela de Respostas
CREATE TABLE Resposta (
    id INT AUTO_INCREMENT PRIMARY KEY,
    mensagem TEXT NOT NULL,
    dataCriacao DATETIME DEFAULT CURRENT_TIMESTAMP,
    topico_id INT,
    autor_id INT,
    solucao BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (topico_id) REFERENCES Topico(id) ON DELETE CASCADE,
    FOREIGN KEY (autor_id) REFERENCES Usuario(id)
);
