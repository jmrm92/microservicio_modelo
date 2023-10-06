CREATE TABLE fabricadb.modelos (
	id_modelo INT auto_increment NOT NULL,
	nombre_modelo varchar(100) NOT NULL,
	piezas_necesarias INT NOT NULL,
	coste DOUBLE NOT NULL,
	CONSTRAINT modelos_pk PRIMARY KEY (id_modelo)
)