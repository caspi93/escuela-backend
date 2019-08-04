insert into Roles(nombre) values ('Super Administrador'), ('Administrador'), ('Entrenador');

insert into Generos(nombre) values ('Masculino'), ('Femenino'), ('Otro');

insert into tiposDeDocumento(nombre, nombreCorto) 
values('C�dula de Ciudadan�a', 'C.C.'), ('C�dula de Extranger�a', 'C.E.'), ('Tarjeta de Identidad', 'T.I.'),
	('Registro Civil', 'R.C.'), ('Pasaporte', 'P.P.');

insert into Personas(PrimerNombre, SegundoNombre, PrimerApellido, SegundoApellido, TiposDeDocumentoId, NumeroDocumento, GeneroId)
values ('Luis', 'Carlos', 'Pedroza', 'Pineda', 1, '1079935561', 1);

insert into Tallas (nombre) values (14), (12), (10), (8), (6);

insert into Permisos (Codigo)
values ('CREAR_USUARIO'), ('ELIMINAR_USUARIO'), ('EDITAR_USUARIO'), ('MATRICULAR_ALUMNO'), ('EDITAR_ALUMNO'), ('ELIMINAR_ALUMNO');
