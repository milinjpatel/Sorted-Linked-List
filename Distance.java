public class Distance implements Comparable
{
    private int foot;
    private int inch;

    public Distance()
    {         
        foot = 0;
        inch = 0;
    }
    public Distance(int f, int i) 
    {
        foot = f + i /12;
        inch = i%12;
    }
    public void printDistance()
    {
        System.out.println(foot + " feet  " + inch + " inches");
    }
    public int compareTo( Object d)
    {
        Distance x = (Distance) d;
       	int s1 = foot *12 + inch;
      	int s2 = x.foot * 12 + x.inch;
       	if (s1 == s2)
           	return 0;
      	else if(s1 < s2)
           	return -1;
       	else  
           	return 1;
    }
 	public Distance sum(Distance d)
 	{
       	Distance sumTemp = new Distance();
       	sumTemp.foot = foot+ d.foot + (inch +d.inch)/12;
       	sumTemp.inch = (inch + d.inch)%12;
      	return sumTemp;
  	}
}
