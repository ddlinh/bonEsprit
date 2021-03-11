package Problem;

import java.util.*;
public class ProblemManagement {
	private ArrayList<Problem> all_problem;
	
	//constructor
	ProblemManagement()
	{
		this.all_problem = new ArrayList<Problem>();
	}
	
	//function
	public boolean add(Problem a)
	{
		all_problem.add(a);
		return true;
	}
	
	public boolean remove(Problem a)
	{
		all_problem.remove(a);
		return true;
	}
	
	public ArrayList<Problem> search(String name)
	{
		ArrayList<Problem> result = new ArrayList<Problem>();
		for(int i = 0; i < this.all_problem.size(); i++)
		{
			if(this.all_problem.get(i).Name().contains(name))
				result.add(this.all_problem.get(i));
		}
		return result;
	}
	
	public ArrayList<Problem> search(String info, int option)
	{
		ArrayList<Problem> result = new ArrayList<Problem>();
		if(option == 1)
		{
			for(int i = 0; i < this.all_problem.size(); i++)
			{
				if(this.all_problem.get(i).Name().contains(info))
					result.add(this.all_problem.get(i));
			}			
		}
		return result;
	}
}
