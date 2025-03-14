USE [master]
GO
/****** Object:  Database [FLIGHTBOOKING]    Script Date: 11/30/2024 12:26:56 PM ******/
CREATE DATABASE [FLIGHTBOOKING]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'FLIGHTBOOKING', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\FLIGHTBOOKING.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'FLIGHTBOOKING_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\FLIGHTBOOKING_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [FLIGHTBOOKING] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [FLIGHTBOOKING].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [FLIGHTBOOKING] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [FLIGHTBOOKING] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [FLIGHTBOOKING] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [FLIGHTBOOKING] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [FLIGHTBOOKING] SET ARITHABORT OFF 
GO
ALTER DATABASE [FLIGHTBOOKING] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [FLIGHTBOOKING] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [FLIGHTBOOKING] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [FLIGHTBOOKING] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [FLIGHTBOOKING] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [FLIGHTBOOKING] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [FLIGHTBOOKING] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [FLIGHTBOOKING] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [FLIGHTBOOKING] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [FLIGHTBOOKING] SET  DISABLE_BROKER 
GO
ALTER DATABASE [FLIGHTBOOKING] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [FLIGHTBOOKING] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [FLIGHTBOOKING] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [FLIGHTBOOKING] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [FLIGHTBOOKING] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [FLIGHTBOOKING] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [FLIGHTBOOKING] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [FLIGHTBOOKING] SET RECOVERY FULL 
GO
ALTER DATABASE [FLIGHTBOOKING] SET  MULTI_USER 
GO
ALTER DATABASE [FLIGHTBOOKING] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [FLIGHTBOOKING] SET DB_CHAINING OFF 
GO
ALTER DATABASE [FLIGHTBOOKING] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [FLIGHTBOOKING] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [FLIGHTBOOKING] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [FLIGHTBOOKING] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'FLIGHTBOOKING', N'ON'
GO
ALTER DATABASE [FLIGHTBOOKING] SET QUERY_STORE = ON
GO
ALTER DATABASE [FLIGHTBOOKING] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [FLIGHTBOOKING]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 11/30/2024 12:26:56 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[Username] [varchar](20) NOT NULL,
	[Password] [varchar](255) NULL,
	[User_Id] [char](10) NOT NULL,
	[Status] [bit] NOT NULL,
 CONSTRAINT [PK_ACCOUNT] PRIMARY KEY CLUSTERED 
(
	[Username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Class]    Script Date: 11/30/2024 12:26:56 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Class](
	[Class_Id] [char](10) NOT NULL,
	[Class_Name] [nvarchar](10) NOT NULL,
	[Price] [float] NOT NULL,
 CONSTRAINT [PK_CLASS] PRIMARY KEY CLUSTERED 
(
	[Class_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Flight]    Script Date: 11/30/2024 12:26:56 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Flight](
	[Flight_Id] [int] IDENTITY(1,1) NOT NULL,
	[Plane_Id] [char](10) NOT NULL,
	[Departure] [nvarchar](50) NOT NULL,
	[Destination] [nvarchar](50) NOT NULL,
	[Dep_Time] [datetime] NOT NULL,
	[Arr_Time] [datetime] NOT NULL,
	[Price] [float] NOT NULL,
 CONSTRAINT [PK_FLIGHT] PRIMARY KEY CLUSTERED 
(
	[Flight_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Plane]    Script Date: 11/30/2024 12:26:56 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Plane](
	[Plane_Id] [char](10) NOT NULL,
	[Name] [nchar](10) NOT NULL,
 CONSTRAINT [PK_PLANE] PRIMARY KEY CLUSTERED 
(
	[Plane_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Seat]    Script Date: 11/30/2024 12:26:56 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Seat](
	[Seat_ID] [char](10) NOT NULL,
	[Seat_Num] [smallint] NOT NULL,
	[Class_ID] [char](10) NOT NULL,
	[Plane_ID] [char](10) NOT NULL,
 CONSTRAINT [PK_SEAT] PRIMARY KEY CLUSTERED 
(
	[Seat_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Service]    Script Date: 11/30/2024 12:26:56 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Service](
	[Service_Id] [char](10) NOT NULL,
	[Service_Name] [nvarchar](100) NOT NULL,
	[Price] [int] NOT NULL,
	[Image] [varchar](max) NOT NULL,
 CONSTRAINT [PK_Service] PRIMARY KEY CLUSTERED 
(
	[Service_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Service_Detail]    Script Date: 11/30/2024 12:26:56 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Service_Detail](
	[Service_Detail_Id] [int] IDENTITY(1,1) NOT NULL,
	[Ticket_Id] [int] NOT NULL,
	[Service_Id] [char](10) NOT NULL,
	[Quantity] [int] NOT NULL,
 CONSTRAINT [PK_ServiceDetail] PRIMARY KEY CLUSTERED 
(
	[Service_Detail_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Ticket]    Script Date: 11/30/2024 12:26:56 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Ticket](
	[Ticket_Id] [int] IDENTITY(1,1) NOT NULL,
	[Type] [nvarchar](15) NOT NULL,
	[Tax] [nvarchar](10) NOT NULL,
	[Status] [bit] NOT NULL,
	[User_Id] [char](10) NOT NULL,
	[Seat_Num] [smallint] NOT NULL,
	[Flight_Id] [int] NOT NULL,
 CONSTRAINT [PK_TICKET] PRIMARY KEY CLUSTERED 
(
	[Ticket_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[User]    Script Date: 11/30/2024 12:26:56 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[User](
	[User_Id] [char](10) NOT NULL,
	[Name] [nvarchar](50) NOT NULL,
	[Phone_Num] [char](10) NOT NULL,
	[Email] [varchar](50) NOT NULL,
	[Citizen_Id] [char](12) NOT NULL,
	[Credit_Num] [varchar](20) NULL,
	[Status] [bit] NOT NULL,
 CONSTRAINT [PRI] PRIMARY KEY CLUSTERED 
(
	[User_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Account] ([Username], [Password], [User_Id], [Status]) VALUES (N'customer01', N'$2y$10$MG6jaQZk49xYO95xMxt6UO5pk.sA1htpEZppNcKY7iRudengtwzmO', N'0001      ', 1)
GO
INSERT [dbo].[Class] ([Class_Id], [Class_Name], [Price]) VALUES (N'VIP       ', N'VIP', 340000)
GO
SET IDENTITY_INSERT [dbo].[Flight] ON 

INSERT [dbo].[Flight] ([Flight_Id], [Plane_Id], [Departure], [Destination], [Dep_Time], [Arr_Time], [Price]) VALUES (1, N'PLANE001  ', N'Hồ Chí Minh', N'Hà Nội', CAST(N'2025-03-01T06:00:00.000' AS DateTime), CAST(N'2025-03-01T11:00:00.000' AS DateTime), 150000)
INSERT [dbo].[Flight] ([Flight_Id], [Plane_Id], [Departure], [Destination], [Dep_Time], [Arr_Time], [Price]) VALUES (2, N'PLANE001  ', N'Hà Nội', N'Hồ Chí Minh', CAST(N'2025-03-02T00:00:00.000' AS DateTime), CAST(N'2025-03-03T00:00:00.000' AS DateTime), 150000)
INSERT [dbo].[Flight] ([Flight_Id], [Plane_Id], [Departure], [Destination], [Dep_Time], [Arr_Time], [Price]) VALUES (3, N'PLANE002  ', N'Cần Thơ', N'Hồ Chí Minh', CAST(N'2025-04-01T00:00:00.000' AS DateTime), CAST(N'2025-04-02T00:00:00.000' AS DateTime), 200000)
SET IDENTITY_INSERT [dbo].[Flight] OFF
GO
INSERT [dbo].[Plane] ([Plane_Id], [Name]) VALUES (N'PLANE001  ', N'VN-001    ')
INSERT [dbo].[Plane] ([Plane_Id], [Name]) VALUES (N'PLANE002  ', N'VN-002    ')
INSERT [dbo].[Plane] ([Plane_Id], [Name]) VALUES (N'PLANE003  ', N'GB-001    ')
GO
INSERT [dbo].[Seat] ([Seat_ID], [Seat_Num], [Class_ID], [Plane_ID]) VALUES (N'SEAT001   ', 1, N'VIP       ', N'PLANE001  ')
INSERT [dbo].[Seat] ([Seat_ID], [Seat_Num], [Class_ID], [Plane_ID]) VALUES (N'SEAT002   ', 2, N'VIP       ', N'PLANE001  ')
INSERT [dbo].[Seat] ([Seat_ID], [Seat_Num], [Class_ID], [Plane_ID]) VALUES (N'SEAT003   ', 3, N'VIP       ', N'PLANE001  ')
INSERT [dbo].[Seat] ([Seat_ID], [Seat_Num], [Class_ID], [Plane_ID]) VALUES (N'SEAT004   ', 4, N'VIP       ', N'PLANE001  ')
INSERT [dbo].[Seat] ([Seat_ID], [Seat_Num], [Class_ID], [Plane_ID]) VALUES (N'SEAT005   ', 5, N'VIP       ', N'PLANE001  ')
INSERT [dbo].[Seat] ([Seat_ID], [Seat_Num], [Class_ID], [Plane_ID]) VALUES (N'SEAT006   ', 6, N'VIP       ', N'PLANE001  ')
INSERT [dbo].[Seat] ([Seat_ID], [Seat_Num], [Class_ID], [Plane_ID]) VALUES (N'SEAT007   ', 7, N'VIP       ', N'PLANE001  ')
INSERT [dbo].[Seat] ([Seat_ID], [Seat_Num], [Class_ID], [Plane_ID]) VALUES (N'SEAT008   ', 8, N'VIP       ', N'PLANE001  ')
INSERT [dbo].[Seat] ([Seat_ID], [Seat_Num], [Class_ID], [Plane_ID]) VALUES (N'SEAT009   ', 9, N'VIP       ', N'PLANE001  ')
INSERT [dbo].[Seat] ([Seat_ID], [Seat_Num], [Class_ID], [Plane_ID]) VALUES (N'SEAT010   ', 10, N'VIP       ', N'PLANE001  ')
GO
INSERT [dbo].[Service] ([Service_Id], [Service_Name], [Price], [Image]) VALUES (N'CAR001    ', N'Xe hơi trung chuyển', 450000, N'xehoi.jpg')
INSERT [dbo].[Service] ([Service_Id], [Service_Name], [Price], [Image]) VALUES (N'DRINK001  ', N'Nước suối', 20000, N'nuocsuoi.jpg')
INSERT [dbo].[Service] ([Service_Id], [Service_Name], [Price], [Image]) VALUES (N'DRINK002  ', N'Coca', 20000, N'coca.jpg')
INSERT [dbo].[Service] ([Service_Id], [Service_Name], [Price], [Image]) VALUES (N'DRINK003  ', N'Cacao nóng', 40000, N'cacao.jpg')
INSERT [dbo].[Service] ([Service_Id], [Service_Name], [Price], [Image]) VALUES (N'DRINK004  ', N'Cà phê đen', 25000, N'caphe.jpg')
INSERT [dbo].[Service] ([Service_Id], [Service_Name], [Price], [Image]) VALUES (N'FOOD001   ', N'Pizza     ', 150000, N'pizza.jpg')
INSERT [dbo].[Service] ([Service_Id], [Service_Name], [Price], [Image]) VALUES (N'FOOD002   ', N'Bánh Su Kem', 50000, N'sukem.jpg')
INSERT [dbo].[Service] ([Service_Id], [Service_Name], [Price], [Image]) VALUES (N'FOOD003   ', N'Bánh mì', 50000, N'banhmi.jpg')
INSERT [dbo].[Service] ([Service_Id], [Service_Name], [Price], [Image]) VALUES (N'FOOD004   ', N'Mì  Ý', 60000, N'miy.jpg')
INSERT [dbo].[Service] ([Service_Id], [Service_Name], [Price], [Image]) VALUES (N'MOTO001   ', N'Xe máy trung chuyển', 200000, N'xemay.jpg')
INSERT [dbo].[Service] ([Service_Id], [Service_Name], [Price], [Image]) VALUES (N'SLOT001   ', N'Thêm 3kg hành lý', 300000, N'slot.jpg')
INSERT [dbo].[Service] ([Service_Id], [Service_Name], [Price], [Image]) VALUES (N'WARM001   ', N'Áo ấm giữ nhiệt', 120000, N'aoam.jpg')
GO
SET IDENTITY_INSERT [dbo].[Service_Detail] ON 

INSERT [dbo].[Service_Detail] ([Service_Detail_Id], [Ticket_Id], [Service_Id], [Quantity]) VALUES (2, 2, N'WARM001   ', 1)
INSERT [dbo].[Service_Detail] ([Service_Detail_Id], [Ticket_Id], [Service_Id], [Quantity]) VALUES (3, 2, N'FOOD002   ', 1)
INSERT [dbo].[Service_Detail] ([Service_Detail_Id], [Ticket_Id], [Service_Id], [Quantity]) VALUES (4, 4, N'DRINK002  ', 1)
INSERT [dbo].[Service_Detail] ([Service_Detail_Id], [Ticket_Id], [Service_Id], [Quantity]) VALUES (5, 4, N'FOOD004   ', 2)
SET IDENTITY_INSERT [dbo].[Service_Detail] OFF
GO
SET IDENTITY_INSERT [dbo].[Ticket] ON 

INSERT [dbo].[Ticket] ([Ticket_Id], [Type], [Tax], [Status], [User_Id], [Seat_Num], [Flight_Id]) VALUES (2, N'Một chiều', N'123', 1, N'0001      ', 5, 3)
INSERT [dbo].[Ticket] ([Ticket_Id], [Type], [Tax], [Status], [User_Id], [Seat_Num], [Flight_Id]) VALUES (3, N'Một chiều', N'123', 1, N'1001      ', 9, 1)
INSERT [dbo].[Ticket] ([Ticket_Id], [Type], [Tax], [Status], [User_Id], [Seat_Num], [Flight_Id]) VALUES (4, N'Một chiều', N'123', 1, N'0001      ', 10, 2)
INSERT [dbo].[Ticket] ([Ticket_Id], [Type], [Tax], [Status], [User_Id], [Seat_Num], [Flight_Id]) VALUES (1011, N'Một chiều', N'123', 1, N'0001      ', 1, 1)
SET IDENTITY_INSERT [dbo].[Ticket] OFF
GO
INSERT [dbo].[User] ([User_Id], [Name], [Phone_Num], [Email], [Citizen_Id], [Credit_Num], [Status]) VALUES (N'0001      ', N'Nguyen Van An', N'0123456789', N'vanan@gmail.com', N'0123123123  ', N'0111222333', 1)
INSERT [dbo].[User] ([User_Id], [Name], [Phone_Num], [Email], [Citizen_Id], [Credit_Num], [Status]) VALUES (N'1001      ', N'Tran Ngoc Ba', N'0123321123', N'ngocba@gmail.com', N'1234565432  ', N'0567567567', 1)
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UK_USER]    Script Date: 11/30/2024 12:26:56 PM ******/
ALTER TABLE [dbo].[Account] ADD  CONSTRAINT [UK_USER] UNIQUE NONCLUSTERED 
(
	[User_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UK_FLIGHT]    Script Date: 11/30/2024 12:26:56 PM ******/
ALTER TABLE [dbo].[Flight] ADD  CONSTRAINT [UK_FLIGHT] UNIQUE NONCLUSTERED 
(
	[Arr_Time] ASC,
	[Dep_Time] ASC,
	[Destination] ASC,
	[Plane_Id] ASC,
	[Departure] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UK_ServiceDetailID]    Script Date: 11/30/2024 12:26:56 PM ******/
ALTER TABLE [dbo].[Service_Detail] ADD  CONSTRAINT [UK_ServiceDetailID] UNIQUE NONCLUSTERED 
(
	[Service_Id] ASC,
	[Ticket_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UK_EMAIL]    Script Date: 11/30/2024 12:26:56 PM ******/
ALTER TABLE [dbo].[User] ADD  CONSTRAINT [UK_EMAIL] UNIQUE NONCLUSTERED 
(
	[Email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UK_NTZ]    Script Date: 11/30/2024 12:26:56 PM ******/
ALTER TABLE [dbo].[User] ADD  CONSTRAINT [UK_NTZ] UNIQUE NONCLUSTERED 
(
	[Citizen_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UK_PHONE]    Script Date: 11/30/2024 12:26:56 PM ******/
ALTER TABLE [dbo].[User] ADD  CONSTRAINT [UK_PHONE] UNIQUE NONCLUSTERED 
(
	[Phone_Num] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Account]  WITH CHECK ADD  CONSTRAINT [FK_ACCOUNT_USER] FOREIGN KEY([User_Id])
REFERENCES [dbo].[User] ([User_Id])
GO
ALTER TABLE [dbo].[Account] CHECK CONSTRAINT [FK_ACCOUNT_USER]
GO
ALTER TABLE [dbo].[Flight]  WITH CHECK ADD  CONSTRAINT [FK_FLIGHT_PLANE] FOREIGN KEY([Plane_Id])
REFERENCES [dbo].[Plane] ([Plane_Id])
GO
ALTER TABLE [dbo].[Flight] CHECK CONSTRAINT [FK_FLIGHT_PLANE]
GO
ALTER TABLE [dbo].[Seat]  WITH CHECK ADD  CONSTRAINT [FK_SEAT_CLASS] FOREIGN KEY([Class_ID])
REFERENCES [dbo].[Class] ([Class_Id])
GO
ALTER TABLE [dbo].[Seat] CHECK CONSTRAINT [FK_SEAT_CLASS]
GO
ALTER TABLE [dbo].[Seat]  WITH CHECK ADD  CONSTRAINT [FK_SEAT_PLANE] FOREIGN KEY([Plane_ID])
REFERENCES [dbo].[Plane] ([Plane_Id])
GO
ALTER TABLE [dbo].[Seat] CHECK CONSTRAINT [FK_SEAT_PLANE]
GO
ALTER TABLE [dbo].[Service_Detail]  WITH CHECK ADD  CONSTRAINT [FK_ServiceDetail_Service] FOREIGN KEY([Service_Id])
REFERENCES [dbo].[Service] ([Service_Id])
GO
ALTER TABLE [dbo].[Service_Detail] CHECK CONSTRAINT [FK_ServiceDetail_Service]
GO
ALTER TABLE [dbo].[Service_Detail]  WITH CHECK ADD  CONSTRAINT [FK_ServiceDetail_TICKET] FOREIGN KEY([Ticket_Id])
REFERENCES [dbo].[Ticket] ([Ticket_Id])
GO
ALTER TABLE [dbo].[Service_Detail] CHECK CONSTRAINT [FK_ServiceDetail_TICKET]
GO
ALTER TABLE [dbo].[Ticket]  WITH CHECK ADD  CONSTRAINT [FK_TICKET_FLIGHT] FOREIGN KEY([Flight_Id])
REFERENCES [dbo].[Flight] ([Flight_Id])
GO
ALTER TABLE [dbo].[Ticket] CHECK CONSTRAINT [FK_TICKET_FLIGHT]
GO
ALTER TABLE [dbo].[Ticket]  WITH CHECK ADD  CONSTRAINT [FK_TICKET_USER] FOREIGN KEY([User_Id])
REFERENCES [dbo].[User] ([User_Id])
GO
ALTER TABLE [dbo].[Ticket] CHECK CONSTRAINT [FK_TICKET_USER]
GO
USE [master]
GO
ALTER DATABASE [FLIGHTBOOKING] SET  READ_WRITE 
GO
