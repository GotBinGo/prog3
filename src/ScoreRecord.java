class ScoreRecord{
	
	private String name = "";
	private int score = 0;
	private long time = 0;
	public ScoreRecord(String n, int s, long t)
	{
		name = n;
		score = s;
		time = t;
	}
	
	public int getScore()
	{
		return score;		
	}
	public void setScore(int s)
	{
		score = s;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String n)
	{
		name = n;
	}
	
	public long getTime()
	{
		return time;
	}
	
	public void setTime(long t)
	{
		time = t;
	}
	
	public String toString(String sep)
	{
		return name + sep + score + sep + time;
	}
	
	public String toString()
	{
		return toString(" ");
	}

}