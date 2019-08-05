select * from TiposDeDocumento;

select * from Personas;

select * from Tallas;

select * from Roles;

select * from Permisos;

select * from Usuarios;

select * from Acudientes;

select * from Usuarios u
inner join Personas p
on u.PersonaId = p.Id
where u.NombreUsuario = 'luisk' and u.Clave = 'lmuairsy';