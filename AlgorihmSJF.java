package mohamed2;
import java.util.*;
 
public class AlgorihmSJF {
	public static void main(String args[])
	{
	Scanner sc = new Scanner(System.in);
	System.out.print("\nEnter the number of processes : ");
	int n = sc.nextInt();
	int pid[] = new int[n];
	int at[] = new int[n]; 
	int bt[] = new int[n]; 
	int ct[] = new int[n]; 
	int ta[] = new int[n]; 
	int wt[] = new int[n];  
	int f[] = new int[n];  
	int st=0, tot=0;
	float avgwt=0, avgta=0;
	 
	for(int i=0;i<n;i++)
	{
	System.out.println ("Enter process  Arrival time"+ (i+1) + ":" );
	at[i] = sc.nextInt();
	System.out.println ("Enter process Brust time" + (i+1) +":");
	bt[i] = sc.nextInt();
	pid[i] = i+1;
	f[i] = 0;
	}
	boolean a = true;
	while(true)
	{
	int c=n, min=999;
	if (tot == n) 
	break;
	for (int i=0; i<n; i++)
	{
	if ((at[i] <= st) && (f[i] == 0) && (bt[i]<min))
	{
	min=bt[i];
	c=i;
	}
	}
	if (c==n)
	st++;
	else
	{
	ct[c]=st+bt[c];
	st+=bt[c];
	ta[c]=ct[c]-at[c];
	wt[c]=ta[c]-bt[c];
	f[c]=1;
	tot++;
	}
	}
	System.out.println("\nprocess    ArrivalTime   BrustTime     WaitingTime      Turn around time       Completion time");
	for(int i=0;i<n;i++)
	{
	avgwt+= wt[i];
	avgta+= ta[i];
	System.out.println("    "+pid[i]+"            "+"\t"+at[i]+"\t"+"                      "+bt[i]+"\t"
	+"                 "+wt[i] +"                              "+"\t"+ta[i]+
	"                                      "+"\t"+ct[i]);
	}
	System.out.println ("Average wait time : "+ (float)(avgwt/n));
	System.out.println ("\nAverage Turnaround time : "+ (float)(avgta/n));

	sc.close();
	}
	}
