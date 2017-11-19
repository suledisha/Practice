import java.io.*;
import java.util.LinkedList;


/*
To find the length of longest increasing subsequence (LIS) and the sequence using Dynamic programming
Subproblem :- L[i]=length of LIS ending in and including arr[i]
Number of Subproblems:- n [Length of the input array]
Base case :- Start with L[i]=1 As every element is a LIS sequence of length 1
Recursion :- for j<i
if arr[j]<arr[i] then L[i]=Max(L[j]+1,L[i])
Time Complexity :- O(n^2)
Space Complexity:- O(n)
 */

public class LongestIncreasingSubsequence {
    public static void main(String args[]) throws IOException
    {
        int n,i,j,max;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the length of the sequence");
        n=Integer.parseInt(in.readLine());
        Integer arr[] = new Integer[n]; //input array
        Integer L[]=  new Integer[n]; // length of LIS array
        Integer S[]= new Integer[n]; // array storing the subsequence
        // Accepting input
        System.out.println("Enter the numbers");
        for(i=0;i<n;i++)
        {
            arr[i]=Integer.parseInt(in.readLine());

        }
        // Initialising the L array
        for(i=0;i<n;i++)
        {
            L[i]=1;

        }

        // Initialising the L array
        for(i=0;i<n;i++)
        {
            S[i]=-1;

        }

        // DP begins
        for(i=1;i<n;i++)
        {
            for (j=0;j<i;j++)
            {
                if( arr[j]<arr[i])
                {
                    //L[i]=Math.max(L[j]+1,L[i]);
                    if(L[j]+1>L[i])
                    {
                        L[i]=L[j]+1;
                        S[i]=j; //ARGMAX logic
                    }
                    else
                    {
                        S[i]=i; //ARGMAX logic
                    }
                }
            }
        }

        //Print length of longest increasing subsequence
        max=L[0];
        j=0;
        for (i=1;i<n;i++)
        {
            if(max<L[i])
            {
                max=L[i]; // Finding max length
                j=i; // ARGMAX Logic
            }
        }
        System.out.println("Length of the LIS "+max);

        //Constructing the sequence
        // Compute i*=ARGMAX L[i]
        //  Compute Arr[i*] - addFirst in list(sequence generated in reverse)
        // set i*=S[i*]
        // Continue till i*>0

        LinkedList<Integer> Sq= new LinkedList<Integer>();
        while(j>=0)
        {
            Sq.addFirst(arr[j]);
            j=S[j];
        }
        System.out.println("Longest Increasing Subsequence :- "+Sq);
    }
}
