package BonEsprit.Service;

import BonEsprit.Model.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DATA {
    public static List<User> users;
    public static List<Certificate> certificates;

    public static List<Problem> problems;
    public static List<Symptom> symptoms;
    public static List<Treatment> treatments;

    public static List<Quiz> quizzes;
    public static List<Question> questions;
    public static List<Choice> choices;


    public DATA()
    {
        users = new ArrayList<User>();
        User a = new User();
        a.setID(1L);
        a.setUserName("username_1");
        a.setPassWord("12345");
        a.setFirstName("USER 1");
        a.setEmail("user1@be.com");
        a.setLastName("NORMAL");
        a.setTypeUser(0);


        User b = new User();
        b.setID(2L);
        b.setUserName("username_2");
        b.setPassWord("12345");
        b.setFirstName("USER 2");
        b.setLastName("THERAPIST");
        b.setEmail("user2@be.com");
        b.setWorkingPlace("abc");
        b.setExperiences(4);
        certificates = new ArrayList<Certificate>();
        b.setCertificates(new ArrayList<Certificate>());
        for(int i = 0; i < 3; i++) {
            Certificate c2 = new Certificate();
            c2.setID((long)(certificates.size()));
            c2.setName("certificate" + i);
            c2.setTherapist(b);
            certificates.add(c2);
            b.getCertificates().add(c2);
        }

        b.setTypeUser(1);

        User c = new User();
        c.setID(3L);
        c.setUserName("username_3");
        c.setPassWord("12345");
        c.setFirstName("USER 3");
        c.setLastName("THERAPIST");
        c.setEmail("user3@be.com");
        List<Certificate> certificates3 = new ArrayList<Certificate>();
        for(int i = 0; i < 8; i++) {
            Certificate c3 = new Certificate();
            c3.setID((long)(certificates.size()));
            c3.setName("certificate" + i);
            c3.setTherapist(c);
            certificates.add(c3);
        }
        c.setCertificates(certificates3);
        c.setTypeUser(1);

        User d = new User();
        d.setID(4L);
        d.setUserName("username_4");
        d.setPassWord("12345");
        d.setFirstName("USER 4");
        d.setLastName("THERAPIST");
        d.setEmail("user4@be.com");
        d.setWorkingPlace("abc");
        d.setExperiences(4);
        List<Certificate> certificates_4 = new ArrayList<Certificate>();
        for(int i = 0; i < 5; i++) {
            Certificate c4 = new Certificate();
            c4.setID((long)(certificates.size()));
            c4.setName("certificate" + i);
            c4.setTherapist(d);
            certificates.add(c4);
        }
        d.setCertificates(certificates_4);
        d.setTypeUser(1);

        User e = new User();
        e.setID(5L);
        e.setUserName("username_5");
        e.setPassWord("12345");
        e.setFirstName("USER 5");
        e.setLastName("NORMAL");
        b.setEmail("user5@be.com");
        e.setTypeUser(0);

        users.add(a);
        users.add(b);
        users.add(c);
        users.add(d);
        users.add(e);

        problems = new ArrayList<Problem>();
        Problem p1 = new Problem();
        p1.setID((long)(problems.size()+1));
        p1.setName("DEPRESSION");
        p1.setDescription("Depression is classified as a mood disorder. It may be described as feelings of sadness, loss, or anger that interfere with a person’s everyday activities.");
        p1.setAuthor(b);
        p1.setDate(Calendar.getInstance().getTimeInMillis());
        symptoms = new ArrayList<Symptom>();
        String[] symptomTxt1 = {"emotional well-being, such as feeling empty, sad, hopeless", "mood, such as anger, aggressiveness,...", "sleep patterns, such as insomnia, restless sleep, excessive sleepiness", "cognitive abilities, such as inability to concentrate, difficulty completing tasks"};
        for(int i = 0; i < symptomTxt1.length; i++)
        {
            Symptom x = new Symptom();
            x.setID((long)(symptoms.size()));
            x.setContent(symptomTxt1[i]);
            symptoms.add(x);
        }
        p1.setSymptoms(symptoms.subList(0, symptomTxt1.length));

        treatments = new ArrayList<Treatment>();
        String[] treatmentTxt1 = {"Medication: antipsychotic medications, antianxiety...", "Psychotherapy: learn skills to cope with negative feelings", "Light therapy: egulate your mood and improve symptoms of depression.", "Exercise: 30 minutes of physical activity 3 to 5 days a week."};
        for(int i = 0; i < treatmentTxt1.length; i++)
        {
            Treatment x = new Treatment();
            x.setID((long)(treatments.size()));
            x.setContent(treatmentTxt1[i]);
            treatments.add(x);
        }
        p1.setTreatments(treatments.subList(0, treatmentTxt1.length));
        problems.add(p1);

        //Quiz
        quizzes = new ArrayList<Quiz>();
        Quiz q1 = new Quiz();
        q1.setID(1L);
        q1.setName("TEST FOR DEREPSSION");
        q1.setAuthor(b);
        q1.setProblem(p1);
        q1.setDate(Calendar.getInstance().getTimeInMillis());
        q1.setQuestions(new ArrayList<Question>());

        String[] questionTxt = {"Do you feel nervous?", "Do you lost in focus?", "Do you sleep less?"};
        String[] answerTxt = {"Never", "Sometimes", "Usually", "Always"};
        choices = new ArrayList<Choice>();
        questions = new ArrayList<Question>();
        for(int i = 0; i < questionTxt.length; i++)
        {
            Question x = new Question();
            x.setID((long)(questions.size()));
            x.setContent(questionTxt[i]);
            x.setQuiz(q1);
            x.setChoices(new ArrayList<Choice>());
            for(int j = 0; j < 4; j++) {
                Choice choice = new Choice();
                choice.setID((long)(choices.size()+1));
                choice.setContent(answerTxt[j]);
                choice.setQuestion(x);
                choice.setScore(j*5);
                choices.add(choice);
                x.getChoices().add(choice);
            }
            questions.add(x);
            q1.getQuestions().add(x);
        }

        quizzes.add(q1);
    }

}
