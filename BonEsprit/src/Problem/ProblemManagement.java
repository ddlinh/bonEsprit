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
	
	public boolean remove(String ID)
	{
		for(int i = 0; i < this.all_problem.size(); i++)
		{
			if(this.all_problem.get(i).ID().equals(ID))
			{
				all_problem.remove(i);
				return true;
			}
				
		}
		return false;
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
	
}
