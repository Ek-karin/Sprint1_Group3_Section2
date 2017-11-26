package User_Story_U8;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class NormReferenced
{
	private ArrayList<Integer> score = new ArrayList<>();
	private ArrayList<Double> stdGrade = new ArrayList<>();
	private ArrayList<String> grade = new ArrayList<>();
	private String g[] = {"A","B+","B","C+","C","D+","D","F"};
	private final double Z = 1.5;
	public NormReferenced(ArrayList<Integer> s)
	{
		score = s;
		calStdGrade();
		calGrade();
	}
	public NormReferenced(ArrayList<Integer> m,ArrayList<Integer> f,ArrayList<Integer> q,ArrayList<Integer> h)
	{
		int sum = 0;
		for (int i = 0; i < m.size(); i++)
		{
			sum = 0;
			sum = m.get(i)+f.get(i)+q.get(i)+h.get(i);
			score.add(sum);
		}
		calStdGrade();
		calGrade();
	}
	private double median()
	{
		if(score.size()%2==0)
		{
			return ((double)(score.get(score.size()/2)-score.get((score.size()/2)-1))/2.0)+score.get((score.size()/2)-1);
		}
		else
		{
			return score.get(score.size()/2);
		}
	}
	private double mean()
	{
		double sum =0;
		for (int j = 0;j  < score.size() ; j++)
		{
			sum +=score.get(j);
		}
		return sum/score.size();
	}
	private double sigma()
	{
		double m = mean();
		double sum = 0;
		for (int j = 0; j < score.size(); j++)
		{
			sum = sum + Math.pow((score.get(j)-m), 2);
		}
		return sum;
	}
	private double SD()
	{
		return Math.sqrt(sigma()/score.size());
	}
	private void calStdGrade()
	{
		stdGrade.removeAll(stdGrade);
		if(median()+Z*SD()<0)
			JOptionPane.showMessageDialog(null, "Invarid Input score");
		else
		{
			if(median()+Z*SD()>100)
				stdGrade.add(100.0);
			else 
				stdGrade.add(median()+Z*SD());
			for (int i = 1; i < 7; i++)
			{
				stdGrade.add(stdGrade.get(i-1)-SD()/2.0);
			}
		}	
	}
	public void printGrade()
	{
		try
		{
			System.out.println("A\t>= "+stdGrade.get(0));
			System.out.println("B+\t>= "+stdGrade.get(1));
			System.out.println("B\t>= "+stdGrade.get(2));
			System.out.println("C+\t>= "+stdGrade.get(3));
			System.out.println("C\t>= "+stdGrade.get(4));
			System.out.println("D+\t>= "+stdGrade.get(5));
			System.out.println("D\t>= "+stdGrade.get(6));
			System.out.println("F\t< "+stdGrade.get(6));
		} catch (IndexOutOfBoundsException e)
		{
			System.out.println("Don't have grade");
		}
	}
	private void calGrade()
	{
		for (int i = 0; i < score.size(); i++)
		{
			for (int j = 0; j < g.length; j++)
			{
				if(j==7)
				{
					grade.add(g[j]);
					break;
				}
				if(score.get(i)>=stdGrade.get(j))
				{
					grade.add(g[j]);
					break;
				}
				
			}			
		}
	}
	public ArrayList<String> getGrade()
	{	
		return grade;
	}
}
