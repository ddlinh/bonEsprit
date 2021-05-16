package BonEsprit.Service;

import BonEsprit.Model.Quiz;
import BonEsprit.Model.Problem;

import java.util.ArrayList;
import java.util.List;

public class QuizService {
    public static DATA myData = new DATA();

    public String create(Quiz quiz) {
        DATA.quizzes.add(quiz);
        Long problem = quiz.getProblem().getID();
        for(int i = 0; i < DATA.problems.size(); i++)
        {
            Problem x = DATA.problems.get(i);
            if(x.getID() == problem)
            {
                x.getQuizzes().add(quiz);
                break;
            }
        }
        return "Add Problem Successfully";

    }

    public static List<Quiz> searchByProblem(Long ID) {
        List<Quiz> results = new ArrayList<Quiz>();
        for(int i = 0; i < DATA.quizzes.size(); i++)
        {
            Quiz q = DATA.quizzes.get(i);
            if(q.getProblem().getID() == ID)
                results.add(q);
        }

        return results;
    }

    public static List<Quiz> searchByAuthor(Long ID) {
        List<Quiz> results = new ArrayList<Quiz>();
        for(int i = 0; i < DATA.quizzes.size(); i++)
        {
            Quiz q = DATA.quizzes.get(i);
            if(q.getAuthor().getID() == ID)
                results.add(q);
        }

        return results;

    }

    public static List<Quiz> getAll() {
        return DATA.quizzes;
    }

    public static boolean update(Quiz newQuiz)
    {
        Long idx = newQuiz.getID();
        for(int i = 0; i < DATA.quizzes.size(); i++)
        {
            Quiz k = DATA.quizzes.get(i);
            if(k.getID() == idx) {
                DATA.quizzes.set(i, newQuiz);
                return true;
            }
        }
        DATA.quizzes.add(newQuiz);

        Long problem = newQuiz.getProblem().getID();
        for(int i = 0; i < DATA.problems.size(); i++)
        {
            Problem p = DATA.problems.get(i);
            if(p.getID() == problem)
                p.getQuizzes().set(0, newQuiz);
        }

        return true;
    }

    public static boolean deletePost(Long idx) {
        DATA.quizzes.remove(idx);
        return true;
    }

}
