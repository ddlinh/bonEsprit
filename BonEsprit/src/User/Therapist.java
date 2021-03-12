package User;

import Problem.*;
import java.util.*;
public class Therapist extends User {
	private ArrayList<String> certificates;
	private int experiences;
	private String major;
	private ArrayList<Problem> problems;
	private String working_place;
	
	public Therapist(String ID) {
		super(ID);
		// TODO Auto-generated constructor stub
		this.certificates = new ArrayList<String>();
		this.experiences = 0;
		this.major = "";
		this.type_user = 1;
		this.problems = new ArrayList<Problem>();
		this.working_place = "";
	}
	
	//post
	public boolean addPost()
	{
		String new_id = this.ID + this.problems.size();
		String therps = this.first_name + this.last_name;
		Problem new_prob = new Problem();
		new_prob.input(therps, new_id);
		this.problems.add(new_prob);
		return true;
	}
	
	public boolean deletePost(String id)
	{
		for(int i = 0; i < this.problems.size(); i++)
			if(this.problems.get(i).ID().equals(id))
			{
				this.problems.remove(i);
				return true;
			}				
		return false;
	}
	
	
}
