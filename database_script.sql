USE [master]
GO
/****** Object:  Database [BonEsprit]    Script Date: 4/2/2021 10:54:03 PM ******/
IF NOT EXISTS(SELECT * FROM sys.databases WHERE name = 'BonEsprit')
BEGIN
CREATE DATABASE [BonEsprit]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'BonEsprit', FILENAME = N'D:\BonEsprit.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'BonEsprit_log', FILENAME = N'D:\BonEsprit_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
END
GO
ALTER DATABASE [BonEsprit] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [BonEsprit].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [BonEsprit] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [BonEsprit] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [BonEsprit] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [BonEsprit] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [BonEsprit] SET ARITHABORT OFF 
GO
ALTER DATABASE [BonEsprit] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [BonEsprit] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [BonEsprit] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [BonEsprit] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [BonEsprit] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [BonEsprit] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [BonEsprit] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [BonEsprit] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [BonEsprit] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [BonEsprit] SET  DISABLE_BROKER 
GO
ALTER DATABASE [BonEsprit] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [BonEsprit] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [BonEsprit] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [BonEsprit] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [BonEsprit] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [BonEsprit] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [BonEsprit] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [BonEsprit] SET RECOVERY FULL 
GO
ALTER DATABASE [BonEsprit] SET  MULTI_USER 
GO
ALTER DATABASE [BonEsprit] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [BonEsprit] SET DB_CHAINING OFF 
GO
ALTER DATABASE [BonEsprit] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [BonEsprit] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [BonEsprit] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [BonEsprit] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'BonEsprit', N'ON'
GO
ALTER DATABASE [BonEsprit] SET QUERY_STORE = OFF
GO
USE [BonEsprit]
GO
/****** Object:  Table [dbo].[Post_Problem]    Script Date: 4/2/2021 10:54:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Post_Problem](
	[ID] [int] NOT NULL,
	[ID_problem] [int] NOT NULL,
	[ID_user] [int] NOT NULL,
	[date] [date] NULL,
 CONSTRAINT [PK_Post_Problem_1] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Post_quiz]    Script Date: 4/2/2021 10:54:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Post_quiz](
	[ID] [int] NOT NULL,
	[ID_quiz] [int] NOT NULL,
	[ID_user] [int] NOT NULL,
	[date] [date] NULL,
 CONSTRAINT [PK_Post_quiz] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Problem]    Script Date: 4/2/2021 10:54:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Problem](
	[ID] [int] NOT NULL,
	[name] [nvarchar](50) NULL,
	[description] [ntext] NULL,
	[symptoms] [ntext] NULL,
	[treatments] [ntext] NULL,
 CONSTRAINT [PK_Problem] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Quiz]    Script Date: 4/2/2021 10:54:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Quiz](
	[ID] [int] NOT NULL,
	[name] [nvarchar](50) NULL,
	[Problem] [int] NULL,
 CONSTRAINT [PK_Quiz] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Quiz_Details]    Script Date: 4/2/2021 10:54:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Quiz_Details](
	[ID] [int] NOT NULL,
	[question] [ntext] NULL,
	[answer] [ntext] NULL,
	[answer_score] [ntext] NULL,
	[score] [int] NULL,
	[Quiz] [int] NULL,
	[Author] [int] NULL,
 CONSTRAINT [PK_Quiz_Details] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Take_quiz]    Script Date: 4/2/2021 10:54:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Take_quiz](
	[ID] [int] NOT NULL,
	[ID_quiz] [int] NOT NULL,
	[ID_user] [int] NOT NULL,
	[score] [int] NULL,
	[result] [int] NULL,
 CONSTRAINT [PK_Take_quiz_1] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[User]    Script Date: 4/2/2021 10:54:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[User](
	[ID] [int] NOT NULL,
	[username] [varchar](20) NULL,
	[passwd] [varchar](20) NULL,
	[first_name] [nvarchar](50) NULL,
	[last_name] [nvarchar](50) NULL,
	[email] [varchar](50) NULL,
	[certificates] [text] NULL,
	[experiences] [int] NULL,
	[working_place] [nvarchar](50) NULL,
 CONSTRAINT [PK_User] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[View]    Script Date: 4/2/2021 10:54:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[View](
	[ID] [int] NOT NULL,
	[ID_problem] [int] NOT NULL,
	[ID_user] [int] NOT NULL,
	[Love] [bit] NULL,
 CONSTRAINT [PK_View] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Post_Problem]  WITH CHECK ADD  CONSTRAINT [FK_Post_Problem_Problem] FOREIGN KEY([ID_problem])
REFERENCES [dbo].[Problem] ([ID])
GO
ALTER TABLE [dbo].[Post_Problem] CHECK CONSTRAINT [FK_Post_Problem_Problem]
GO
ALTER TABLE [dbo].[Post_Problem]  WITH CHECK ADD  CONSTRAINT [FK_Post_Problem_User] FOREIGN KEY([ID_user])
REFERENCES [dbo].[User] ([ID])
GO
ALTER TABLE [dbo].[Post_Problem] CHECK CONSTRAINT [FK_Post_Problem_User]
GO
ALTER TABLE [dbo].[Post_quiz]  WITH CHECK ADD  CONSTRAINT [FK_Post_quiz_Quiz] FOREIGN KEY([ID_quiz])
REFERENCES [dbo].[Quiz] ([ID])
GO
ALTER TABLE [dbo].[Post_quiz] CHECK CONSTRAINT [FK_Post_quiz_Quiz]
GO
ALTER TABLE [dbo].[Post_quiz]  WITH CHECK ADD  CONSTRAINT [FK_Post_quiz_User] FOREIGN KEY([ID_user])
REFERENCES [dbo].[User] ([ID])
GO
ALTER TABLE [dbo].[Post_quiz] CHECK CONSTRAINT [FK_Post_quiz_User]
GO
ALTER TABLE [dbo].[Quiz]  WITH CHECK ADD  CONSTRAINT [FK_Quiz_Problem] FOREIGN KEY([Problem])
REFERENCES [dbo].[Problem] ([ID])
GO
ALTER TABLE [dbo].[Quiz] CHECK CONSTRAINT [FK_Quiz_Problem]
GO
ALTER TABLE [dbo].[Quiz_Details]  WITH CHECK ADD  CONSTRAINT [FK_Quiz_Details_Quiz] FOREIGN KEY([Quiz])
REFERENCES [dbo].[Quiz] ([ID])
GO
ALTER TABLE [dbo].[Quiz_Details] CHECK CONSTRAINT [FK_Quiz_Details_Quiz]
GO
ALTER TABLE [dbo].[Quiz_Details]  WITH CHECK ADD  CONSTRAINT [FK_Quiz_Details_User] FOREIGN KEY([Author])
REFERENCES [dbo].[User] ([ID])
GO
ALTER TABLE [dbo].[Quiz_Details] CHECK CONSTRAINT [FK_Quiz_Details_User]
GO
ALTER TABLE [dbo].[Take_quiz]  WITH CHECK ADD  CONSTRAINT [FK_Take_quiz_Quiz] FOREIGN KEY([ID_quiz])
REFERENCES [dbo].[Quiz] ([ID])
GO
ALTER TABLE [dbo].[Take_quiz] CHECK CONSTRAINT [FK_Take_quiz_Quiz]
GO
ALTER TABLE [dbo].[Take_quiz]  WITH CHECK ADD  CONSTRAINT [FK_Take_quiz_User] FOREIGN KEY([ID_user])
REFERENCES [dbo].[User] ([ID])
GO
ALTER TABLE [dbo].[Take_quiz] CHECK CONSTRAINT [FK_Take_quiz_User]
GO
ALTER TABLE [dbo].[View]  WITH CHECK ADD  CONSTRAINT [FK_View_Problem] FOREIGN KEY([ID_problem])
REFERENCES [dbo].[Problem] ([ID])
GO
ALTER TABLE [dbo].[View] CHECK CONSTRAINT [FK_View_Problem]
GO
ALTER TABLE [dbo].[View]  WITH CHECK ADD  CONSTRAINT [FK_View_User] FOREIGN KEY([ID_user])
REFERENCES [dbo].[User] ([ID])
GO
ALTER TABLE [dbo].[View] CHECK CONSTRAINT [FK_View_User]
GO
USE [master]
GO
ALTER DATABASE [BonEsprit] SET  READ_WRITE 
GO
