CREATE TABLE topicos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    mensaje TEXT NOT NULL,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    activo BOOLEAN NOT NULL DEFAULT TRUE,


    autor_id BIGINT,
    curso_id BIGINT
);
create table usuarios(

    id bigint not null auto_increment,
    login varchar(100) not null,
    contrasena varchar(255) not null,

    primary key(id)
);