CREATE DATABASE ess 
DEFAULT CHARACTER SET utf8;

CREATE TABLE medicos(
	medico_id INT not null auto_increment,
	medico_nome VARCHAR(255),
	meidico_email VARCHAR(355),
	medico_crm VARCHAR(100),
	medico_data_criacao DATETIME,
	medico_data_utualizacao DATETIME,
	PRIMARY KEY (medico_id)
);