CREATE DATABASE ess_homolog2;
USE ess_homolog;

CREATE TABLE salas (
	sala_id INT AUTO_INCREMENT PRIMARY KEY,
	sala_numero VARCHAR(255)
);

CREATE TABLE materiais (
	material_id INT AUTO_INCREMENT PRIMARY KEY,
	material_descricao VARCHAR(255),
	material_qtde_disponivel INT
);

CREATE TABLE equipamentos (
	equipamento_id INT AUTO_INCREMENT PRIMARY KEY,
	equipamento_descricao VARCHAR(255),
	equipamento_qtde_disponivel INT
);

CREATE TABLE procedimentos (
	procedimento_id INT AUTO_INCREMENT PRIMARY KEY,
	procedimento_descricao VARCHAR(255)
);

CREATE TABLE pessoas (
	pessoa_id INT AUTO_INCREMENT PRIMARY KEY,
	pessoa_nome VARCHAR(255),
	pessoa_email VARCHAR(510),
	pessoa_telefone VARCHAR(100),
	pessoa_login VARCHAR(100),
	pessoa_senha_hash VARCHAR(100)
);

CREATE TABLE especialidades (
	especialidade_id INT AUTO_INCREMENT PRIMARY KEY,
	especialidade_nome VARCHAR(255),
	especialidade_descricao VARCHAR(500)
);

CREATE TABLE pacientes (
	paciente_id INT AUTO_INCREMENT PRIMARY KEY,
	pessoa_id INT NOT NULL	
);
ALTER TABLE pacientes 
ADD CONSTRAINT con_pacientes_pessoas
FOREIGN KEY (pessoa_id)
REFERENCES pessoas(pessoa_id);

CREATE TABLE administradores (
	administrador_id  INT AUTO_INCREMENT PRIMARY KEY,
	pessoa_id INT NOT NULL
);
ALTER TABLE administradores 
ADD CONSTRAINT con_administradores_pessoas
FOREIGN KEY (pessoa_id)
REFERENCES pessoas(pessoa_id);

CREATE TABLE medicos (
	medico_id  INT AUTO_INCREMENT PRIMARY KEY,
	medico_crm VARCHAR(10),
	pessoa_id INT NOT NULL,
	especialidade_id INT
);
ALTER TABLE medicos 
ADD CONSTRAINT con_medicos_pessoas
FOREIGN KEY (pessoa_id)
REFERENCES pessoas(pessoa_id);
ALTER TABLE medicos 
ADD CONSTRAINT con_medicos_especialidades
FOREIGN KEY (especialidade_id)
REFERENCES especialidades(especialidade_id);

CREATE TABLE agendamentos (
	agendamento_id  INT AUTO_INCREMENT PRIMARY KEY,
	agendamento_data_inicio DATE,
	agendamento_data_fim DATE,
	sala_id INT NOT NULL,
	medico_id INT NOT NULL,
	paciente_id INT NOT NULL
);
ALTER TABLE agendamentos 
ADD CONSTRAINT con_agendamentos_salas
FOREIGN KEY (sala_id)
REFERENCES salas(sala_id);
ALTER TABLE agendamentos 
ADD CONSTRAINT con_agendamentos_medicos
FOREIGN KEY (medico_id)
REFERENCES medicos(medico_id);
ALTER TABLE agendamentos 
ADD CONSTRAINT con_agendamentos_pacientes
FOREIGN KEY (paciente_id)
REFERENCES pacientes(paciente_id);

CREATE TABLE equipamentos_agendamentos (
	agendamento_id INT NOT NULL,
	equipamento_id INT NOT NULL,
	equipamento_agendamento_qtde INT,
	PRIMARY KEY(agendamento_id, equipamento_id)
);
ALTER TABLE equipamentos_agendamentos 
ADD CONSTRAINT con_equipamentos_agendamentos_agendamentos
FOREIGN KEY (agendamento_id)
REFERENCES agendamentos(agendamento_id);
ALTER TABLE equipamentos_agendamentos 
ADD CONSTRAINT con_equipamentos_agendamentos_equipamentos
FOREIGN KEY (equipamento_id)
REFERENCES equipamentos(equipamento_id);

CREATE TABLE procedimentos_agendamentos (
	agendamento_id INT NOT NULL,
	procedimento_id INT NOT NULL,
	PRIMARY KEY(agendamento_id, procedimento_id)
);
ALTER TABLE procedimentos_agendamentos 
ADD CONSTRAINT con_procedimentos_agendamentos_agendamentos
FOREIGN KEY (agendamento_id)
REFERENCES agendamentos(agendamento_id);
ALTER TABLE procedimentos_agendamentos 
ADD CONSTRAINT con_procedimentos_agendamentos_procedimentos
FOREIGN KEY (procedimento_id)
REFERENCES procedimentos(procedimento_id);

CREATE TABLE materiais_agendamentos (
	agendamento_id INT NOT NULL,
	material_id INT NOT NULL,
	materiais_agendamentos_qtde INT,
	PRIMARY KEY(agendamento_id, material_id)
);
ALTER TABLE materiais_agendamentos 
ADD CONSTRAINT con_materiais_agendamentos_agendamentos
FOREIGN KEY (agendamento_id)
REFERENCES agendamentos(agendamento_id);
ALTER TABLE materiais_agendamentos 
ADD CONSTRAINT con_materiais_agendamentos_materiais
FOREIGN KEY (material_id)
REFERENCES materiais(material_id);