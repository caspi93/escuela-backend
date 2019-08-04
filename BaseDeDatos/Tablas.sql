create database EscuelaDeFutbolTP;
use EscuelaDeFutbolTP;

create table Generos (
id int identity(1,1) primary key not null,
nombre varchar(9) not null,
);

create table TiposDeDocumento (
id int identity(1,1) primary key not null,
nombre varchar(21) not null,
nombreCorto varchar(4) not null
);


create table Roles(
id int identity(1,1) primary key not null,
nombre varchar(25) not null
);

create table Tallas(
id int identity(1,1) primary key not null,
nombre varchar(2) not null
);

create table Personas(
Id int identity(1,1) primary key not null,
PrimerNombre varchar(25) not null,
SegundoNombre varchar(25) not null,
PrimerApellido varchar(25) not null,
SegundoApellido varchar(25) not null,
NumeroDocumento varchar(12) not null, 
GeneroId int not null,
constraint GeneroId foreign key(GeneroId)
references Generos(id),
TiposDeDocumentoId int not null,
constraint TiposDeDocumentoId foreign key(TiposDeDocumentoId)
references TiposDeDocumento(id)
);

create table Usuarios(
id int identity(1,1) primary key not null,
NombreUsuario varchar(20) not null,
Clave varchar(8) not null, 
PersonaId int not null,
constraint PersonaId foreign key(PersonaId)
references Personas(Id),
RolId int not null,
constraint RolId foreign key(RolId)
references Roles(id)
);

create table Acudientes(
id int identity(1,1) primary key not null,
Correo varchar(50) not null,
Celular varchar(12) not null,
PersonaId int not null,
constraint AcudientesPersonaId foreign key(PersonaId)
references Personas(Id)
);

create table Categorias(
id int identity(1,1) primary key not null,
Nombre Varchar(50) not null,
AnoInicial int not null,
AnoFinal int not null
); 

create table Alumnos(
id int identity(1,1) primary key not null,
Peso float not null,
Altura float not null,
Direccion varchar(150) not null,
FechaDeNacimiento date not null,
FechaDeInscripcion datetime not null,
FechaDeMatricula datetime,
PersonaId int not null,
constraint AlumnosPersonaId foreign key(PersonaId)
references Personas(Id),
CategoriaId int not null,
constraint AlumnosCategoriaId foreign key(CategoriaId)
references Categorias(id),
TallaId int not null,
constraint AlumnosTallaId foreign key(TallaId)
references Tallas(id)
);

create table Permisos(
id int identity(1,1) primary key not null,
Codigo varchar(50) not null
);

create table PermisosPorRoles(
idRol int not null,
idPermisos int not null,
constraint pk_RolesPermisosIdRolIdPermisos primary key(idRol, idPermisos),
constraint fk_PermisosPorRoles_Roles
	foreign key (idRol) references Roles(id)
		on update cascade
		on delete cascade,
constraint fk_PermisosPorRoles_Permisos
	foreign key (idPermisos) references Permisos(id)
		on update cascade
		on delete cascade
);






