insert into curso (nome) values 
('Administração'),
('Sistemas para Internet'),
('Desenvolvimento de Sistemas Multiplataformas');

insert into tipo_sugestao (descricao) values 
('Comentário'),
('Crítica'),
('Elogio'),
('Sugestão');

insert into sugestao (conteudo, id_tipo, data, id_curso) values
('Lorem ipsum dolor sit amet. ', 4, now(), 3);