package BonEsprit.Service;

import BonEsprit.Model.Problem;
import BonEsprit.Model.Symptom;
import BonEsprit.Model.Treatment;

import java.util.ArrayList;
import java.util.List;

public class ProblemService {
    public static DATA myData = new DATA();
    public String create(Problem problem) {
        DATA.problems.add(problem);
        return "Add Problem Successfully";

    }

    public static List<Problem> search(String keyword) {
        List<Problem> results = new ArrayList<Problem>();
        for(int i = 0; i < DATA.problems.size(); i++)
        {
            if (DATA.problems.get(i).getName().contains(keyword))
                results.add(DATA.problems.get(i));
        }

        return results;
    }

    public static List<Problem> recentProblem() {
        if(DATA.problems.size() < 5)
            return DATA.problems;
        return DATA.problems.subList(DATA.problems.size()-5, DATA.problems.size());
    }

    public static List<Problem> readByUser(Long ID) {
        List<Problem> result = new ArrayList<Problem>();
        for(int i = 0; i < DATA.problems.size(); i++) {
            Problem x = DATA.problems.get(i);
            if(x.getAuthor().getID() == ID) {
                result.add(x);
            }
        }
        return result;
    }

    public static  boolean updatePost(Problem newProblem)
    {
        Long idx = newProblem.getID();
        for(int i = 0; i < DATA.problems.size(); i++)
        {
            Problem k = DATA.problems.get(i);
            if(k.getID() == idx) {
                DATA.problems.set(i, newProblem);
                return true;
            }
        }
        DATA.problems.add(newProblem);
        return true;
    }

    public static boolean deletePost(Long idx) {
        for(int i = 0 ; i < DATA.problems.size(); i++) {
            Problem k = DATA.problems.get(i);
            if(k.getID() == idx) {
                DATA.problems.remove(i);
                return true;
            }
        }
        return false;
    }

    public static List<Problem> getAll() {
        return DATA.problems;
    }

}
