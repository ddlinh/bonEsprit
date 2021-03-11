package Problem;
import java.util.*;
public class Question {
	String question;
	String[] answer = new String[4];
	int[] score = new int[4];
	//constructor
	Question()
	{
		question = "";
		for (int i = 0; i < 4; i++)
		{
			answer[i] = "";
			score[i] = 0;
		}
	}
	
	//input
	public void input()
	{
		Scanner obj = new Scanner(System.in);
		System.out.println("Enter Question:");
		String tmp = obj.nextLine();
		if(tmp != "")
			this.question = tmp;
		
		for(int i = 0; i < 4; i++)
		{
			System.out.println("Enter answer " + (i+1));
			tmp = obj.nextLine();
			if(tmp != "")
				this.answer[i] = tmp;
			System.out.println("Enter score for answer " + (i+1));
			tmp = obj.nextLine();
			while(true)
			{
				boolean isNum = true;
				try {
					this.score[i] = Integer.parseInt(tmp);
				}
				catch(NumberFormatException e)
				{
					isNum = false;
				}
				if(isNum && this.score[i] > 0)
					break;
				System.out.println("Score must be a positive integer. Enter again: ");
				tmp = obj.nextLine();
			}
		}
	}
	//output
	public void output()
	{
		System.out.println(this.question);
		System.out.println("0. " + score[0] + "\t1. " + score[1]);
		System.out.println("2. " + score[2] + "\t3. " + score[3]);
	}
	
	//score
	public int score()
	{
		int sum = 0;
		for (int i = 0; i < 3; i++)
			sum += score[i];
		return sum;
	}
	public int score(int idx)
	{
		if(idx >= 0 && idx < 4)
			return score[idx];
		else
			return 0;
	}
}
