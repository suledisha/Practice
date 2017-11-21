import java.io.*;

/*

Egg dropping question using Dynamic Programming
Given a number of floors and a number of eggs,
find the minimum number of attempts it will take to find out from which floor egg will break.
Subproblem :- T[i][j]= Minimum number of attempts to find out from which floor egg will break with i eggs and j floors.
Base case:-T[1][j]=j
            T[i][1]=1
Recursion :- T[i][j]=T[i-1][j] when i>j
             T[i][j]= 1 + min(max(T[i-1][k-1],T[i][j-k])) where K is between 1...j
             max=Finding the worst case, min= minimum number of attempts
Time Complexity : eggs*(floors ^2) = O(n(k^2))
Space Complexity O(nk)


*/

public class EggDrop {
    public static void main(String args[]) throws IOException
    {
        int eggs,floors,i,j,k;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number of eggs");
        eggs=Integer.parseInt(in.readLine());
        System.out.println("Enter the number of floors");
        floors=Integer.parseInt(in.readLine());
        int T[][]= new int[eggs+1][floors+1];

        for(j=1;j<=floors;j++)
        {
            T[1][j]=j;
        }

        for(i=1;i<=eggs;i++)
        {
            T[i][1]=1;
        }

        for(i=2;i<=eggs;i++)
        {
            for(j=2;j<=floors;j++)
            {
                if(i>j)
                {
                    T[i][j]=T[i-1][j];
                }
                else
                {
                    int min= Integer.MAX_VALUE;
                    for(k=2;k<=j;k++)
                    {
                        int c=1+ Math.max(T[i-1][k-1],T[i][j-k]);
                        if(min > c)
                        {
                            min=c;
                        }
                        T[i][j]=min;
                    }
                }
            }
        }

        System.out.println("Minimum attempts "+T[eggs][floors]);


    }
}
