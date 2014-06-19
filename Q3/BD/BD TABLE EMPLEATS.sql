CREATE TABLE empleats (
		num_empl INTEGER,
		nom_empl CHAR(30) NOT NULL,
		sou INTEGER DEFAULT = 100000
			CHECK (sou > 80000),
		ciutat_empl CHAR(30),
		num_dpt INTEGER,
		num_proj INTEGER,
	PRIMARY KEY(num_empl),
	FOREIGN KEY(num_dpt) REFERENCES departaments(num_dpt),
	FOREIGN KEY(num_proj) REFERENCES projectes(num_proj));