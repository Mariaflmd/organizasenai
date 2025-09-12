create database OrganizaSenai;

create table cadastro(
	id serial primary key,
	nome_completo varchar(100) not null,
	email varchar(100) CHECK (email LIKE '%@%.%') not null unique,
	senha numeric(10) not null,
	matricula char(10) not null,
	tipo_usuario varchar(20) check (tipo_usuario in ('aluno', 'professor')),
	last_update timestamp not null
	
);

create table login(
	id serial primary key,
	email varchar(100) CHECK (email LIKE '%@%.%') not null unique,
	senha numeric(10) not null,
	cadastro_id int,
	foreign key (cadastro_id) references cadastro(id),
	last_update timestamp not null

);


create table notas(
	id serial primary key,
	cadastro_id int not null,
	foreign key (cadastro_id) references cadastro(id),
	nota_primeiro_trimestre numeric(3),
	nota_segundo_trimestre numeric(3),
	nota_terceiro_trimestre numeric(3),
	last_update timestamp not null
	
	
);

create table anotacoes(
	id serial primary key,
	cadastro_id int not null,
	foreign key (cadastro_id) references cadastro(id),
	anotacao text not null,
	last_update timestamp not null
	
);

create table tarefa(
	id serial primary key,
	titulo_tarefa varchar(100),
	tarefa_descricao text not null,
	last_update timestamp not null
	
);

create table tarefa_enviar(
	id serial primary key,
	cadastro_id int not null,
	foreign key (cadastro_id) references cadastro(id),
	tarefa_id int not null,
	foreign key (tarefa_id) references tarefa(id)
);
