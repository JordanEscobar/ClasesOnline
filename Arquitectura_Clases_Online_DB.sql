USE [ModeloClasesOnline]
GO
/****** Object:  Table [dbo].[Administrador]    Script Date: 25-11-2022 14:32:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Administrador](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[rut] [varchar](50) NOT NULL,
	[nombre] [varchar](50) NOT NULL,
	[apellido] [varchar](50) NOT NULL,
	[correo] [varchar](50) NOT NULL,
	[password] [varchar](100) NOT NULL,
	[idusuario] [int] NOT NULL,
 CONSTRAINT [PK_Administrador] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Agenda]    Script Date: 25-11-2022 14:32:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Agenda](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[hora] [time](7) NOT NULL,
	[fecha] [date] NOT NULL,
	[id_profesor] [int] NOT NULL,
 CONSTRAINT [PK_Agenda] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[alumno]    Script Date: 25-11-2022 14:32:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[alumno](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[rut] [varchar](50) NOT NULL,
	[nombre] [varchar](50) NOT NULL,
	[apellido] [varchar](50) NOT NULL,
	[correo] [varchar](50) NOT NULL,
	[password] [varchar](100) NOT NULL,
	[curso] [varchar](50) NULL,
	[loginuser] [int] NOT NULL,
 CONSTRAINT [PK_alumno] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[app_pago]    Script Date: 25-11-2022 14:32:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[app_pago](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[formato_pago] [varchar](50) NOT NULL,
	[cantidad_a_pagar] [int] NOT NULL,
	[descuento] [float] NULL,
	[id_alumno] [int] NOT NULL,
 CONSTRAINT [PK_app_pago] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[app_reunion]    Script Date: 25-11-2022 14:32:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[app_reunion](
	[id_sala] [int] IDENTITY(1,1) NOT NULL,
	[fecha] [date] NOT NULL,
	[descripcion] [varchar](255) NULL,
 CONSTRAINT [PK_app_reunion] PRIMARY KEY CLUSTERED 
(
	[id_sala] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[aula_virtual]    Script Date: 25-11-2022 14:32:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[aula_virtual](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[id_materia] [int] NOT NULL,
	[id_profesor] [int] NOT NULL,
	[id_alumno] [int] NOT NULL,
	[id_agenda] [int] NOT NULL,
	[id_reunion] [int] NOT NULL,
 CONSTRAINT [PK_aula_virtual] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Login]    Script Date: 25-11-2022 14:32:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Login](
	[idus] [int] IDENTITY(1,1) NOT NULL,
	[usuario] [varchar](100) NOT NULL,
	[nivel] [char](10) NOT NULL,
 CONSTRAINT [PK_Login] PRIMARY KEY CLUSTERED 
(
	[idus] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[materia]    Script Date: 25-11-2022 14:32:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[materia](
	[id_materia] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NOT NULL,
	[categoria] [varchar](50) NOT NULL,
	[id_profesor] [int] NULL,
 CONSTRAINT [PK_materia] PRIMARY KEY CLUSTERED 
(
	[id_materia] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Profesor]    Script Date: 25-11-2022 14:32:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Profesor](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[rut] [varchar](50) NOT NULL,
	[nombre] [varchar](50) NOT NULL,
	[apellido] [varchar](50) NOT NULL,
	[correo] [varchar](50) NOT NULL,
	[password] [varchar](100) NOT NULL,
	[especializacion] [varchar](50) NOT NULL,
	[idlogpro] [int] NOT NULL,
 CONSTRAINT [PK_Profesor] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[seguridad]    Script Date: 25-11-2022 14:32:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[seguridad](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[fecha] [date] NOT NULL,
	[log] [varchar](500) NULL,
	[id_login] [int] NOT NULL,
 CONSTRAINT [PK_seguridad] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Administrador] ON 
GO
INSERT [dbo].[Administrador] ([id], [rut], [nombre], [apellido], [correo], [password], [idusuario]) VALUES (1, N'103185304', N'Wacoldo', N'Cerda', N'waco@gmail.com', N'123456', 1)
GO
SET IDENTITY_INSERT [dbo].[Administrador] OFF
GO
SET IDENTITY_INSERT [dbo].[Agenda] ON 
GO
INSERT [dbo].[Agenda] ([id], [hora], [fecha], [id_profesor]) VALUES (1, CAST(N'03:24:16' AS Time), CAST(N'2012-12-26' AS Date), 1)
GO
INSERT [dbo].[Agenda] ([id], [hora], [fecha], [id_profesor]) VALUES (2, CAST(N'05:07:01' AS Time), CAST(N'2023-01-04' AS Date), 1)
GO
SET IDENTITY_INSERT [dbo].[Agenda] OFF
GO
SET IDENTITY_INSERT [dbo].[alumno] ON 
GO
INSERT [dbo].[alumno] ([id], [rut], [nombre], [apellido], [correo], [password], [curso], [loginuser]) VALUES (1, N'178617591', N'jordan', N'escobar', N'jordan@gmail.com', N'123456', N'Base de datos', 3)
GO
SET IDENTITY_INSERT [dbo].[alumno] OFF
GO
SET IDENTITY_INSERT [dbo].[Login] ON 
GO
INSERT [dbo].[Login] ([idus], [usuario], [nivel]) VALUES (1, N'Administrador', N'1         ')
GO
INSERT [dbo].[Login] ([idus], [usuario], [nivel]) VALUES (2, N'Profesor', N'2         ')
GO
INSERT [dbo].[Login] ([idus], [usuario], [nivel]) VALUES (3, N'Alumno', N'3         ')
GO
SET IDENTITY_INSERT [dbo].[Login] OFF
GO
SET IDENTITY_INSERT [dbo].[materia] ON 
GO
INSERT [dbo].[materia] ([id_materia], [nombre], [categoria], [id_profesor]) VALUES (1, N'Programacion de base de datos', N'Base de datos', 1)
GO
INSERT [dbo].[materia] ([id_materia], [nombre], [categoria], [id_profesor]) VALUES (2, N'Programacion Web', N'Programacion', 2)
GO
INSERT [dbo].[materia] ([id_materia], [nombre], [categoria], [id_profesor]) VALUES (3, N'UXUI', N'DISEÑO WEB', 2)
GO
INSERT [dbo].[materia] ([id_materia], [nombre], [categoria], [id_profesor]) VALUES (4, N'Gestión Agil SCRUM', N'Marcos de Trabajo', 2)
GO
SET IDENTITY_INSERT [dbo].[materia] OFF
GO
SET IDENTITY_INSERT [dbo].[Profesor] ON 
GO
INSERT [dbo].[Profesor] ([id], [rut], [nombre], [apellido], [correo], [password], [especializacion], [idlogpro]) VALUES (1, N'178617591', N'Jordan', N'Escobar', N'jordan@gmail.com', N'123456', N'Base de datos', 2)
GO
INSERT [dbo].[Profesor] ([id], [rut], [nombre], [apellido], [correo], [password], [especializacion], [idlogpro]) VALUES (2, N'178617591', N'Martin', N'Reyes', N'reyes@gmail.com', N'123456', N'Programacion web', 2)
GO
SET IDENTITY_INSERT [dbo].[Profesor] OFF
GO
ALTER TABLE [dbo].[Administrador]  WITH CHECK ADD  CONSTRAINT [log_admin] FOREIGN KEY([idusuario])
REFERENCES [dbo].[Login] ([idus])
GO
ALTER TABLE [dbo].[Administrador] CHECK CONSTRAINT [log_admin]
GO
ALTER TABLE [dbo].[Agenda]  WITH CHECK ADD  CONSTRAINT [agenda_profesor] FOREIGN KEY([id_profesor])
REFERENCES [dbo].[Profesor] ([id])
GO
ALTER TABLE [dbo].[Agenda] CHECK CONSTRAINT [agenda_profesor]
GO
ALTER TABLE [dbo].[alumno]  WITH CHECK ADD  CONSTRAINT [alumno_login] FOREIGN KEY([loginuser])
REFERENCES [dbo].[Login] ([idus])
GO
ALTER TABLE [dbo].[alumno] CHECK CONSTRAINT [alumno_login]
GO
ALTER TABLE [dbo].[app_pago]  WITH CHECK ADD  CONSTRAINT [pago_alumno] FOREIGN KEY([id_alumno])
REFERENCES [dbo].[alumno] ([id])
GO
ALTER TABLE [dbo].[app_pago] CHECK CONSTRAINT [pago_alumno]
GO
ALTER TABLE [dbo].[aula_virtual]  WITH CHECK ADD  CONSTRAINT [aula_agenda] FOREIGN KEY([id_agenda])
REFERENCES [dbo].[Agenda] ([id])
GO
ALTER TABLE [dbo].[aula_virtual] CHECK CONSTRAINT [aula_agenda]
GO
ALTER TABLE [dbo].[aula_virtual]  WITH CHECK ADD  CONSTRAINT [aula_alumno] FOREIGN KEY([id_alumno])
REFERENCES [dbo].[alumno] ([id])
GO
ALTER TABLE [dbo].[aula_virtual] CHECK CONSTRAINT [aula_alumno]
GO
ALTER TABLE [dbo].[aula_virtual]  WITH CHECK ADD  CONSTRAINT [aula_materia] FOREIGN KEY([id_materia])
REFERENCES [dbo].[materia] ([id_materia])
GO
ALTER TABLE [dbo].[aula_virtual] CHECK CONSTRAINT [aula_materia]
GO
ALTER TABLE [dbo].[aula_virtual]  WITH CHECK ADD  CONSTRAINT [aula_profesor] FOREIGN KEY([id_profesor])
REFERENCES [dbo].[Profesor] ([id])
GO
ALTER TABLE [dbo].[aula_virtual] CHECK CONSTRAINT [aula_profesor]
GO
ALTER TABLE [dbo].[aula_virtual]  WITH CHECK ADD  CONSTRAINT [aula_reunion] FOREIGN KEY([id_reunion])
REFERENCES [dbo].[app_reunion] ([id_sala])
GO
ALTER TABLE [dbo].[aula_virtual] CHECK CONSTRAINT [aula_reunion]
GO
ALTER TABLE [dbo].[materia]  WITH CHECK ADD  CONSTRAINT [materia_profesor] FOREIGN KEY([id_profesor])
REFERENCES [dbo].[Profesor] ([id])
GO
ALTER TABLE [dbo].[materia] CHECK CONSTRAINT [materia_profesor]
GO
ALTER TABLE [dbo].[Profesor]  WITH CHECK ADD  CONSTRAINT [login_profesor] FOREIGN KEY([idlogpro])
REFERENCES [dbo].[Login] ([idus])
GO
ALTER TABLE [dbo].[Profesor] CHECK CONSTRAINT [login_profesor]
GO
ALTER TABLE [dbo].[seguridad]  WITH CHECK ADD  CONSTRAINT [login_seguridad] FOREIGN KEY([id_login])
REFERENCES [dbo].[Login] ([idus])
GO
ALTER TABLE [dbo].[seguridad] CHECK CONSTRAINT [login_seguridad]
GO
