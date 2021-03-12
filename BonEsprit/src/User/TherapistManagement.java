package User;

import java.util.*;
public class TherapistManagement {
	private ArrayList<Therapist> list_therapist;
	
	//constructor
	public TherapistManagement()
	{
		this.list_therapist = new ArrayList<Therapist>();
	}
	
	//function
	public ArrayList<Therapist> Therapists()
	{
		return this.list_therapist;
	}
	
	public void add(Therapist a)
	{
		this.list_therapist.add(a);
	}
	
	public boolean delete(String ID)
	{
		for(int i = 0; i < this.list_therapist.size(); i++)
			if(this.list_therapist.get(i).ID.equals(ID))
			{
				this.list_therapist.remove(i);
				return true;
			}
		return false;
	}
	
	public Therapist search(String thrpist)
	{
		for(int i = 0; i < this.list_therapist.size(); i++)
			if(this.list_therapist.get(i).ID.equals(thrpist))
			{
				return this.list_therapist.get(i);
			}
		return null;
	}
	
	public ArrayList<Therapist> searchAll(String thrpist)
	{
		ArrayList<Therapist> res = new ArrayList<Therapist>();
		for(int i = 0; i < this.list_therapist.size(); i++)
			if(this.list_therapist.get(i).ID.equals(thrpist))
			{
				res.add(this.list_therapist.get(i));
			}
		return res;
	}
}
