CREATE TABLE pessoa (
                        id SERIAL PRIMARY KEY,
                        nome VARCHAR(255) NOT NULL,
                        cpf VARCHAR(11) NOT NULL,
                        telefone VARCHAR(11),
                        rua VARCHAR(255),
                        numero VARCHAR(10),
                        complemento VARCHAR(255),
                        bairro VARCHAR(255),
                        cep VARCHAR(8),
                        cidade VARCHAR(255),
                        estado VARCHAR(2)
);