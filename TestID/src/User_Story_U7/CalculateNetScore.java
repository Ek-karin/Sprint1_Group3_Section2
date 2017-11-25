package User_Story_U7;

import java.util.ArrayList;

public class CalculateNetScore
{
	private CalculateNetScoreThread cal;
	private Thread t;
	public CalculateNetScore(ArrayList<Integer> array,int criterion,int maxRawScore)
	{
		cal = new CalculateNetScoreThread(array, criterion, maxRawScore);
		t = new Thread(cal);
		t.start();
	}
	public ArrayList<Integer> getNetScore() throws Exception
	{
		if(cal.finished())
			return cal.getNetScoreThread();
		else
			throw new Exception();
	}
}
