package User_Story_U7;

import java.util.ArrayList;
public class CalculateNetScoreThread implements Runnable
{
	public long startTime ;
	public long endTime ;
	private int start = 0;
	private ArrayList<Integer> score;
	public int criterion;
	public int max;
	public boolean finish = false;
	public CalculateNetScoreThread(ArrayList<Integer> s ,int criterion, int max )
	{
		startTime = System.nanoTime();
		this.criterion = criterion;
		this.max = max;
		this.score = s;
	}
	@Override
	public void run()
	{
		while (start < score.size())
		{
			int netScore = (int) Math
					.round(((double) criterion /max) * score.get(start));
			
			score.set(start, netScore);
			start++;
		}
		finish = true;	
	}
	public ArrayList<Integer> getNetScoreThread()
	{
		return score;
	}
	public boolean finished()
	{
		return finish;
	}
}