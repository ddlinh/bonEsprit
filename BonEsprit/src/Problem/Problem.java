package Problem;

import java.util.*;
public class Problem {
	private String name;
	private ArrayList<String> symptoms;
	private String owner;
	private Quiz test;
	
	//constructor
	public Problem()
	{
		name = "";
		symptoms = new ArrayList<String>();
		owner = "";
		test = new Quiz();
	}
	
	//input
	public void input(String therapist)
	{
		this.owner = therapist;
		Scanner obj = new Scanner(System.in);
		System.out.println("Enter name: ");
		String tmp = obj.nextLine();
		if(tmp != "")
			this.name = tmp;
		
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
		
		Scanner obj = new Scanner(System.in);
		System.out.println("Do you want to take the test? Y - Yes, N - No");
		String tmp = obj.nextLine();
		while(true)
		{
			if (tmp.compareTo("Y") == 0 || tmp.compareTo("y") == 0)
			{
				this.test.ouput();
				int[] ans = this.test.Answer().clone();
				double score = this.test.Score(ans);
				if (score >= 0.7)
					System.out.println("Dangerous");
				else if(score >= 0.4 && score < 0.7)
					System.out.println("Maybe");
				else
					System.out.println("Normal");
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
	
}