USE [BonEsprit]
GO
/****** Object:  Table [dbo].[Problem]    Script Date: 4/3/2021 1:15:57 PM ******/
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
	[author] [int] NULL,
	[date] [date] NULL,
 CONSTRAINT [PK_Problem] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Quiz]    Script Date: 4/3/2021 1:15:57 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Quiz](
	[ID] [int] NOT NULL,
	[name] [nvarchar](50) NULL,
	[problem] [int] NULL,
	[author] [int] NULL,
	[date] [date] NULL,
 CONSTRAINT [PK_Quiz] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Quiz_Details]    Script Date: 4/3/2021 1:15:57 PM ******/
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
 CONSTRAINT [PK_Quiz_Details] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Take_quiz]    Script Date: 4/3/2021 1:15:57 PM ******/
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
/****** Object:  Table [dbo].[User]    Script Date: 4/3/2021 1:15:57 PM ******/
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
/****** Object:  Table [dbo].[View]    Script Date: 4/3/2021 1:15:57 PM ******/
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
INSERT [dbo].[Problem] ([ID], [name], [description], [symptoms], [treatments], [author], [date]) VALUES (1, N'Depression', N'A sense of hopelessness, the feeling of being “weighed down,” and a loss of enjoyment in things that used to bring you joy — these are some common signs of depression, one of the most widespread mental health issues in the world.', N'a persistent feeling of loneliness or sadness,lack of energy,feelings of hopelessness,getting too much or too little sleep,eating too much or too little,difficulties with concentration or attention,loss of interest in enjoyable activities or socializing,feelings of guilt and worthlessness,thoughts of death or suicide', N'Cognitive behavioral therapy (CBT),
Interpersonal therapy,Psychodynamic therapy,Electroconvulsive therapy (ECT),Repetitive transcranial magnetic stimulation (rTMS)', 1001, CAST(N'2021-02-21' AS Date))
INSERT [dbo].[Problem] ([ID], [name], [description], [symptoms], [treatments], [author], [date]) VALUES (2, N'Anxiety', N'Anxiety disorders are one of the most common mental health conditions in the United States. So if you’re feeling concerned about your anxiety, know that you’re not alone.

In fact, the National Institute of Mental Health (NIMH) estimates that almost one-third of U.S. adults will have an anxiety disorder during their lifetimes.

While anxiety can feel overwhelming at times, there are many ways to cope. With the right tools, you can manage your anxiety and start feeling less anxious.

Keep reading to learn about the different types of anxiety disorders, symptoms and treatments, and tips to help you manage your anxiety.', N'racing thoughts,
shortness of breath
,rapid heart rate or feeling like your heart is pounding hard
,upset stomach
,dry mouth,
feeling dizzy,
feelings of dread or panic
,sweating
,tunnel vision,
feeling restless,
muscle tension,
physical weakness
,poor memory,
confusion,
trouble concentrating,
constant worry,
dissociation', N'Cognitive behavioral therapy (CBT),Exposure response prevention (ERP),Benzodiazepines', 1001, CAST(N'2021-02-16' AS Date))
INSERT [dbo].[Problem] ([ID], [name], [description], [symptoms], [treatments], [author], [date]) VALUES (3, N'Eating Disorders', N'Eating disorders are often one of the unspoken secrets that affect many families. Millions of Americans are afflicted with this disorder every year, and most of them — up to 90 percent — are adolescent and young women. Rarely talked about, an eating disorder can affect up to 5 percent of the population of teenage girls.

Why are teenage and young adult women so susceptible to getting an eating disorder? According to the National Institute of Mental Health, it is because during this period of time, women are more likely to diet — or try extreme dieting — to try to stay thin. Certain sports (such as gymnastics) and careers (such as modeling) are especially prone to reinforcing the need to keep a fit figure, even if it means purging food or not eating at all.', N'Anorexia,Bulimia,Binge,Avoidant/Restrictive Food Intake Disorder', N'Anorexia Treatment,Bulimia Treatment,Binge Eating Disorder Treatment', 1002, CAST(N'2016-05-17' AS Date))
INSERT [dbo].[Problem] ([ID], [name], [description], [symptoms], [treatments], [author], [date]) VALUES (4, N'ADHD', N'This is often due to ongoing, persistent patterns of inattention, an inability to focus, hyperactivity, or impulsivity. These patterns may lead you to face challenges in how you function daily and develop skills.', N'forgetfulness,
being easily distracted
,losing or misplacing things,
abrupt or impulsive behavior,
lack of motivation for specific activities or in general,
difficulty organizing or completing tasks,
not being able to follow instructions
,constantly moving from one activity to another
,engaging in behaviors that might put you or others in jeopardy,
having a hard time focusing on a conversation', N'Medication,Psychotherapy,Behavior management', 1002, CAST(N'2021-03-28' AS Date))
INSERT [dbo].[Problem] ([ID], [name], [description], [symptoms], [treatments], [author], [date]) VALUES (5, N'Autism', N'Autism spectrum disorder (ASD) is a neurodevelopmental disorder that can affect the ways a person interacts, communicates, and behaves.', N'trouble relating to others or no interest in other people,avoiding eye contact and want to be alone,trouble expressing their needs,repeating actions,not looking at objects when another person points at them,trouble understanding other people’s feelings or talking about their own feelings,trouble adapting when a routine changes,differences in speech tone or prosody', N'Autism spectrum disorder (ASD),Cognitive behavioral therapy (CBT)', 1003, CAST(N'2019-10-14' AS Date))
INSERT [dbo].[Problem] ([ID], [name], [description], [symptoms], [treatments], [author], [date]) VALUES (6, N'Schizophrenia', N'Schizophrenia is a chronic mental health condition that affects thoughts, feelings, and behaviors. The condition is characterized by symptoms such as delusions and hallucinations.', N'delusions,hallucinations,incoherent speech or speech that quickly switches from topic to topic,severely disorganized behavior such as issues with motor function or inexplicable agitation or giddiness', N'Medications,Therapy,Social support treatment,Vocational rehabilitation', 1003, CAST(N'2021-02-03' AS Date))
GO
INSERT [dbo].[Quiz] ([ID], [name], [problem], [author], [date]) VALUES (1, N'Depression', 1, 1001, CAST(N'2021-02-21' AS Date))
INSERT [dbo].[Quiz] ([ID], [name], [problem], [author], [date]) VALUES (2, N'Anxiety', 2, 1001, CAST(N'2021-02-16' AS Date))
INSERT [dbo].[Quiz] ([ID], [name], [problem], [author], [date]) VALUES (3, N'Eating Disorders', 3, 1002, CAST(N'2016-05-17' AS Date))
INSERT [dbo].[Quiz] ([ID], [name], [problem], [author], [date]) VALUES (4, N'ADHD', 4, 1002, CAST(N'2021-03-28' AS Date))
INSERT [dbo].[Quiz] ([ID], [name], [problem], [author], [date]) VALUES (5, N'Autism', 5, 1003, CAST(N'2019-10-14' AS Date))
INSERT [dbo].[Quiz] ([ID], [name], [problem], [author], [date]) VALUES (6, N'Schizophrenia', 6, 1003, CAST(N'2021-02-03' AS Date))
GO
INSERT [dbo].[Quiz_Details] ([ID], [question], [answer], [answer_score], [score], [Quiz]) VALUES (11, N'I do things slowly.', N'Not at all,Just a little,Moderately,Quite a lot', N'10,15,20,25', 100, 1)
INSERT [dbo].[Quiz_Details] ([ID], [question], [answer], [answer_score], [score], [Quiz]) VALUES (12, N'My future seems hopeless.', N'Not at all,Just a little,Moderately,Quite a lot', N'10,15,20,25', 100, 1)
INSERT [dbo].[Quiz_Details] ([ID], [question], [answer], [answer_score], [score], [Quiz]) VALUES (13, N'It is hard for me to concentrate on reading.', N'Not at all,Just a little,Moderately,Quite a lot', N'10,15,20,25', 100, 1)
INSERT [dbo].[Quiz_Details] ([ID], [question], [answer], [answer_score], [score], [Quiz]) VALUES (14, N'The pleasure and joy has gone out of my life.', N'Not at all,Just a little,Moderately,Quite a lot', N'10,15,20,25', 100, 1)
INSERT [dbo].[Quiz_Details] ([ID], [question], [answer], [answer_score], [score], [Quiz]) VALUES (21, N'Pounding heart', N'Not at all,Just a little,Sometimes,Usually', N'10,15,20,25', 100, 2)
INSERT [dbo].[Quiz_Details] ([ID], [question], [answer], [answer_score], [score], [Quiz]) VALUES (22, N'Sweating', N'Not at all,Just a little,Sometimes,Usually', N'10,15,20,25', 100, 2)
INSERT [dbo].[Quiz_Details] ([ID], [question], [answer], [answer_score], [score], [Quiz]) VALUES (23, N'Trembling or shaking', N'Not at all,Just a little,Sometimes,Usually', N'10,15,20,25', 100, 2)
INSERT [dbo].[Quiz_Details] ([ID], [question], [answer], [answer_score], [score], [Quiz]) VALUES (24, N'Shortness of breath', N'Not at all,Just a little,Sometimes,Often,Usually', N'10,15,20,25', 100, 2)
INSERT [dbo].[Quiz_Details] ([ID], [question], [answer], [answer_score], [score], [Quiz]) VALUES (31, N'Eat a lot', N'Not at all,Just a little,Moderately,Quite a lot', N'10,15,20,25', 100, 3)
INSERT [dbo].[Quiz_Details] ([ID], [question], [answer], [answer_score], [score], [Quiz]) VALUES (32, N'Like sweet', N'Not at all,Just a little,Moderately,Quite a lot', N'10,15,20,25', 100, 3)
INSERT [dbo].[Quiz_Details] ([ID], [question], [answer], [answer_score], [score], [Quiz]) VALUES (33, N'Sleep', N'Not at all,Just a little,Moderately,Quite a lot', N'10,15,20,25', 100, 3)
INSERT [dbo].[Quiz_Details] ([ID], [question], [answer], [answer_score], [score], [Quiz]) VALUES (34, N'Weight gain', N'Not at all,Just a little,Moderately,Quite a lot', N'10,15,20,25', 100, 3)
INSERT [dbo].[Quiz_Details] ([ID], [question], [answer], [answer_score], [score], [Quiz]) VALUES (41, N'How often do you have difficulty sustaining your attention while doing something for work, school, a hobby, or fun activity (e.g., remaining focused during lectures, lengthy reading or conversations)?', N'Never,Rarely,Sometimes,
Often', N'10,15,20,25', 100, 4)
INSERT [dbo].[Quiz_Details] ([ID], [question], [answer], [answer_score], [score], [Quiz]) VALUES (42, N'How often are you easily distracted by external stimuli, like something in your environment or unrelated thoughts?', N'Never,Rarely,Sometimes,
Often', N'10,15,20,25', 100, 4)
INSERT [dbo].[Quiz_Details] ([ID], [question], [answer], [answer_score], [score], [Quiz]) VALUES (43, N'How often do you avoid, dislike, or are reluctant to engage in tasks that require sustained mental effort or thought?', N'Never,Rarely,Sometimes,
Often', N'10,15,20,25', 100, 4)
INSERT [dbo].[Quiz_Details] ([ID], [question], [answer], [answer_score], [score], [Quiz]) VALUES (44, N'How often do you have trouble listening to someone, even when they are speaking directly to you — like your mind is somewhere else?', N'Never,Rarely,Sometimes,
Often', N'10,15,20,25', 100, 4)
INSERT [dbo].[Quiz_Details] ([ID], [question], [answer], [answer_score], [score], [Quiz]) VALUES (51, N'I prefer to do things with others rather than on my own.', N'Definitely Agree,Slightly Agree,Slightly Disagree,Definitely Disagree', N'10,15,20,25', 100, 5)
INSERT [dbo].[Quiz_Details] ([ID], [question], [answer], [answer_score], [score], [Quiz]) VALUES (52, N'I prefer to do things the same way over and over again.', N'Definitely Agree,Slightly Agree,Slightly Disagree,Definitely Disagree', N'10,15,20,25', 100, 5)
INSERT [dbo].[Quiz_Details] ([ID], [question], [answer], [answer_score], [score], [Quiz]) VALUES (53, N'If I try to imagine something, I find it very easy to create a picture in my mind.', N'Definitely Agree,Slightly Agree,Slightly Disagree,Definitely Disagree', N'10,15,20,25', 100, 5)
INSERT [dbo].[Quiz_Details] ([ID], [question], [answer], [answer_score], [score], [Quiz]) VALUES (54, N'I frequently get so strongly absorbed in one thing that I lose sight of other things.', N'Definitely Agree,Slightly Agree,Slightly Disagree,Definitely Disagree', N'10,15,20,25', 100, 5)
INSERT [dbo].[Quiz_Details] ([ID], [question], [answer], [answer_score], [score], [Quiz]) VALUES (61, N'I believe that others control what I think and feel', N'Not at all,Just a little,Moderately,All the time', N'10,15,20,25', 100, 6)
INSERT [dbo].[Quiz_Details] ([ID], [question], [answer], [answer_score], [score], [Quiz]) VALUES (62, N'I hear or see things that others do not hear or see
', N'Not at all,Just a little,Moderately,All the time', N'10,15,20,25', 100, 6)
INSERT [dbo].[Quiz_Details] ([ID], [question], [answer], [answer_score], [score], [Quiz]) VALUES (63, N'I feel it is very difficult for me to express myself in words that others can understand', N'Not at all,Just a little,Moderately,All the time', N'10,15,20,25', 100, 6)
INSERT [dbo].[Quiz_Details] ([ID], [question], [answer], [answer_score], [score], [Quiz]) VALUES (64, N'I feel I share absolutely nothing in common with others, including my friends and family', N'Not at all,Just a little,Moderately,All the time', N'10,15,20,25', 100, 6)
GO
INSERT [dbo].[Take_quiz] ([ID], [ID_quiz], [ID_user], [score], [result]) VALUES (1, 1, 2001, 30, 1)
INSERT [dbo].[Take_quiz] ([ID], [ID_quiz], [ID_user], [score], [result]) VALUES (2, 4, 2002, 90, 3)
GO
INSERT [dbo].[User] ([ID], [username], [passwd], [first_name], [last_name], [email], [certificates], [experiences], [working_place]) VALUES (1001, N'ue1', N'ue1pass', N'John ', N'Grohol', N'UE1.gmail.com', N'Doctorate in clinical psychology', 13, N'Nova Southeastern')
INSERT [dbo].[User] ([ID], [username], [passwd], [first_name], [last_name], [email], [certificates], [experiences], [working_place]) VALUES (1002, N'ue2', N'ue2pass', N'Francis', N'Kuehnle', N'UE2.gmail.com', N'Doctorate in clinical psychology', 8, N'Mount Mercy')
INSERT [dbo].[User] ([ID], [username], [passwd], [first_name], [last_name], [email], [certificates], [experiences], [working_place]) VALUES (1003, N'ue3', N'ue3pass', N'Timothy', N'Legg', N'UE3.gmail.com', N'Doctorate in clinical psychology', 17, N'California Southern University')
INSERT [dbo].[User] ([ID], [username], [passwd], [first_name], [last_name], [email], [certificates], [experiences], [working_place]) VALUES (2001, N'un1', N'un1pass', N'Frank ', N'Bryan', N'UN1.gmail.com', N'International Business Administration', 7, N'Frost Span
 Corp')
INSERT [dbo].[User] ([ID], [username], [passwd], [first_name], [last_name], [email], [certificates], [experiences], [working_place]) VALUES (2002, N'un2', N'un2pass', N'Shane ', N'Cannon', N'UN2.gmail.com', N'Hospitality Business Administration', 9, N'Wick Go 
Corp')
INSERT [dbo].[User] ([ID], [username], [passwd], [first_name], [last_name], [email], [certificates], [experiences], [working_place]) VALUES (2003, N'un3', N'un3pass', N'Joel', N'Dolan', N'UN3.gmail.com', N'Entrepreneurial Business Administration', 11, N'Rebel Cen
 Corp')
GO
INSERT [dbo].[View] ([ID], [ID_problem], [ID_user], [Love]) VALUES (1, 2, 2001, 0)
INSERT [dbo].[View] ([ID], [ID_problem], [ID_user], [Love]) VALUES (2, 1, 2003, 1)
GO
ALTER TABLE [dbo].[Problem]  WITH CHECK ADD  CONSTRAINT [FK_Problem_User] FOREIGN KEY([author])
REFERENCES [dbo].[User] ([ID])
GO
ALTER TABLE [dbo].[Problem] CHECK CONSTRAINT [FK_Problem_User]
GO
ALTER TABLE [dbo].[Quiz]  WITH CHECK ADD  CONSTRAINT [FK_Quiz_Problem] FOREIGN KEY([problem])
REFERENCES [dbo].[Problem] ([ID])
GO
ALTER TABLE [dbo].[Quiz] CHECK CONSTRAINT [FK_Quiz_Problem]
GO
ALTER TABLE [dbo].[Quiz]  WITH CHECK ADD  CONSTRAINT [FK_Quiz_User] FOREIGN KEY([author])
REFERENCES [dbo].[User] ([ID])
GO
ALTER TABLE [dbo].[Quiz] CHECK CONSTRAINT [FK_Quiz_User]
GO
ALTER TABLE [dbo].[Quiz_Details]  WITH CHECK ADD  CONSTRAINT [FK_Quiz_Details_Quiz] FOREIGN KEY([Quiz])
REFERENCES [dbo].[Quiz] ([ID])
GO
ALTER TABLE [dbo].[Quiz_Details] CHECK CONSTRAINT [FK_Quiz_Details_Quiz]
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
