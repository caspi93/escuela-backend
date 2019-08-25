insert into Roles(nombre) values ('Super Administrador'), ('Administrador'), ('Entrenador');

insert into Generos(nombre) values ('Masculino'), ('Femenino'), ('Otro');

insert into tiposDeDocumento(nombre, nombreCorto) 
values('Cédula de Ciudadanía', 'C.C.'), ('Cédula de Extrangería', 'C.E.'), ('Tarjeta de Identidad', 'T.I.'),
	('Registro Civil', 'R.C.'), ('Pasaporte', 'P.P.');

insert into Personas(PrimerNombre, SegundoNombre, PrimerApellido, SegundoApellido, TiposDeDocumentoId, NumeroDocumento, GeneroId)
values ('Luis', 'Carlos', 'Pedroza', 'Pineda', 1, '1079935561', 1);

insert into Personas(PrimerNombre, SegundoNombre, PrimerApellido, SegundoApellido, TiposDeDocumentoId, NumeroDocumento, GeneroId)
values ('Olmedo', 'Rafael', 'Pedroza', 'Barrios', 1, '7594393', 1);

insert into Tallas (nombre) values (14), (12), (10), (8), (6);

insert into Permisos (Codigo)
values ('CREAR_USUARIO'), ('ELIMINAR_USUARIO'), ('EDITAR_USUARIO'), ('MATRICULAR_ALUMNO'), ('EDITAR_ALUMNO'), ('ELIMINAR_ALUMNO');
insert into Permisos (Codigo) values('CREAR_ADMINISTRADOR');
insert into Permisos (Codigo) values('VER_USUARIOS'), ('VER_ALMUNOS');

insert into EstadosAlumnos (id,Nombre) values (1,'Matriculado'), (2,'Inscrito'), (3,'Suspendido');

insert into Usuarios (Correo, Celular, NombreUsuario, Clave, PersonaId, RolId)
values ('luisk301374@gmail.com', '3004255615','luisk','lmuairsy',2, 1);

insert into Usuarios (Correo, Celular, NombreUsuario, Clave, PersonaId, RolId)
values ('olrape67@gmail.com', '3023797554','olrape','o7594393',3, 2);

-- Super Administrador
insert into PermisosPorRoles (idRol, idPermisos) values (1,1);
insert into PermisosPorRoles (idRol, idPermisos) values (1,2);
insert into PermisosPorRoles (idRol, idPermisos) values (1,3);
insert into PermisosPorRoles (idRol, idPermisos) values (1,4);
insert into PermisosPorRoles (idRol, idPermisos) values (1,5);
insert into PermisosPorRoles (idRol, idPermisos) values (1,6);
insert into PermisosPorRoles (idRol, idPermisos) values (1,7);

-- Administrador
insert into PermisosPorRoles (idRol, idPermisos) values (2,1);
insert into PermisosPorRoles (idRol, idPermisos) values (2,2);
insert into PermisosPorRoles (idRol, idPermisos) values (2,3);
insert into PermisosPorRoles (idRol, idPermisos) values (2,4);
insert into PermisosPorRoles (idRol, idPermisos) values (2,5);
insert into PermisosPorRoles (idRol, idPermisos) values (2,6);

-- Entrenador
insert into PermisosPorRoles (idRol, idPermisos) values (3,4);
insert into PermisosPorRoles (idRol, idPermisos) values (3,5);
