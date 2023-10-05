CREATE TABLE fabricadb.modelo (
	id_modelo INT auto_increment NOT NULL,
	nombre_modelo varchar(100) NOT NULL,
	piezas_necesarias INT NOT NULL,
	CONSTRAINT modelo_pk PRIMARY KEY (id_modelo)
)