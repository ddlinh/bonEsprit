package Problem;

import java.util.*;
import User.*;
public class Problem {
	private String ID;
	private String name;
	private String description;
	private ArrayList<String> symptoms;
	private ArrayList<String> treatments;
	private String owner;
	private Quiz test;
	
	//constructor
	public Problem()
	{
		ID = "";
		name = "";
		description = "";
		symptoms = new ArrayList<String>();
		treatments = new ArrayList<String>();
		owner = "";
		test = new Quiz();
	}
	
	//input
	public void input(String therapist, String ID)
	{
		this.ID = ID;
		this.owner = therapist;
		Scanner obj = new Scanner(System.in);
		System.out.println("Enter name: ");
		String tmp = obj.nextLine();
		if(tmp != "")
			this.name = tmp;
		
		System.out.println("Enter description: ");
		tmp = obj.nextLine();
		if(tmp != "")
			this.description = tmp;
		
		System.out.println("Enter symptoms:");
		String symp = obj.nextLine();
		while(true)
		{
			this.symptoms.add(symp);
			System.out.println("Enter next symptoms (\"q\" for exit): ");
			symp = obj.nextLine();
			if(symp.compareTo("q") == 0)
				break;
		}
		
		System.out.println("Enter treatments:");
		String treatment = obj.nextLine();
		while(true)
		{
			this.treatments.add(treatment);
			System.out.println("Enter next treatment (\"q\" for exit): ");
			symp = obj.nextLine();
			if(symp.compareTo("q") == 0)
				break;
		}
		
		this.test = new Quiz();
		this.test.input(therapist, name);
	}
	//output
	public void output()
	{
		System.out.println(this.name);
		System.out.println("Written by: " + this.owner);
		System.out.println("Symptoms:");
		for(int i = 0; i < this.symptoms.size(); i++)
			System.out.println(i+1 + ". " + this.symptoms.get(i));
		
		System.out.println("Treatments:");
		for(int i = 0; i < this.treatments.size(); i++)
			System.out.println(i+1 + ". " + this.treatments.get(i));
		
		Scanner obj = new Scanner(System.in);
		System.out.println("Do you want to take the test? Y - Yes, N - No");
		String tmp = obj.nextLine();
		while(true)
		{
			if (tmp.compareTo("Y") == 0 || tmp.compareTo("y") == 0)
			{
				this.test.ouput();
				int[] ans = this.test.Answer().clone();
				double score = this.test.Score(ans)*100;
				if (score >= 0.7)
				{
					System.out.println("Your score: " + score + "%");
				}					
				else if(score >= 0.4 && score < 0.7)
				{
					System.out.println("Your score: " + score + "%");
				}
				else
				{	
					System.out.println("Your probability: " + score + "%");
				}

				break;
			}
			else if(tmp.compareTo("N") == 0 || tmp.compareTo("n") == 0)
				break;
			else
			{
				System.out.println("Wrong Syntax. Try again: ");
				tmp = obj.nextLine();
			}
		}
	}
	
	//get
	public ArrayList<String> Symptoms()
	{
		return this.symptoms;
	}
	public String Owner()
	{
		return this.owner;
	}
	public Quiz Test()
	{
		return this.test;
	}
	public String Name()
	{
		return this.name;
	}
	public String ID()
	{
		return this.ID;
	}
	public String Description()
	{
		return this.description;
	}
	public ArrayList<String> Treatment() {
		return this.treatments;
	}
}