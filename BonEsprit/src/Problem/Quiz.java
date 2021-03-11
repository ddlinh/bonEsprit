package Problem;

import java.util.*;
public class Quiz {
	String therapist;
	String problem;
	String name;
	ArrayList<Question> content;
	int numOfQuestion;
	
	//constructor
	Quiz()
	{
		therapist = "";
		problem = "";
		name = "";
		content = new ArrayList<Question>();
	}
	
	//input, output
	public void input(String therapist, String problem)
	{
		this.therapist = therapist;
		this.problem = problem;
		this.name = "TEST FOR " + problem.toUpperCase();
		
		Scanner obj = new Scanner(System.in);
		System.out.println("Enter number question: ");
		String tmp = obj.nextLine();
		int number = 0;
		while(true)
		{
			boolean isNum = true;
			try {
				number = Integer.parseInt(tmp);
			}
			catch(NumberFormatException e)
			{
				isNum = false;
			}
			if(isNum && number > 0)
				break;
			System.out.println("Number of questions must be a positive integer. Enter again: ");
			tmp = obj.nextLine();
		}
		this.numOfQuestion = number;
		content = new ArrayList<Question>();
		for(int i = 0; i < numOfQuestion; i++)
		{
			Question quest = new Question();
			quest.input();
			content.add(quest);
		}
	}
	
	public void ouput()
	{
		for(int i = 0; i < this.numOfQuestion; i++)
		{
			int no = i+1;
			System.out.print(no + ". ");
			this.content.get(i).output();
		}
	}
	
	//get result
	public int[] Answer()
	{
		int[] answer = new int[this.numOfQuestion];
		int ans = 0;
		Scanner obj = new Scanner(System.in);
		for(int i = 0; i < this.numOfQuestion; i++)
		{
			int no = i + 1;
			System.out.print("Answer for question " + no + "(A - 0, B = 1, C - 2, D - 3):");
			while(true)
			{
				boolean isNum = true;
				String tmp = obj.nextLine();
				try {
					ans = Integer.parseInt(tmp);
				}
				catch(NumberFormatException e)
				{
					isNum = false;
				}
				if(isNum && ans >= 0 && ans <= 3)
					break;
				System.out.println("Invalid answer. Enter again: ");
			}
			answer[i] = ans;
			ans = 0;
		}
		return answer;
	}
	
	public int Score()
	{
		int sum = 0;
		for(int i = 0; i < this.numOfQuestion; i++)
			sum += this.content.get(i).score();
		return sum;
	}
	public double Score(int[] answers)
	{
		int sum_ans = 0;
		for(int i = 0; i < this.numOfQuestion; i++)
			sum_ans += this.content.get(i).score(i);
		return (double)sum_ans/this.Score();
	}
}
