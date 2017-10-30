import java.io.*;
import java.util.*;

public class MakePalindrome {
    public static void main(String args[]) throws IOException
    {
        int n,i=0;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number of strings");
        n=Integer.parseInt(in.readLine());
        String arr[] = new String[n];
        System.out.println("Enter the strings");
        for(i=0;i<n;i++)
        {
            arr[i]=in.readLine();

        }
        for (i=0;i<n;i++)
        {
            String ip=arr[i];
            arr[i]=getPalindrome(ip);
        }

        for (i=0;i<n;i++)
        {
            System.out.print(arr[i]+"  ");
        }

    }
    static String getPalindrome(String str)
    {
        String output="";
        HashMap<Character,Integer> hm=new HashMap<Character,Integer>();
        int l=str.length();
        int i=0;
        for (i=0;i<l;i++){
            char ch= str.charAt(i);
            if (hm.containsKey(ch))
            {
                int x= hm.get(ch);
                x++;
                hm.remove(ch);
                hm.put(ch,x);
            }
            else
            {
                hm.put(ch,1);
            }
        }
        int even=0;
        int odd=0;
        char oddKey=' ';
        for(Map.Entry m:hm.entrySet()){
            int x=(int) m.getValue();
            if (x%2==0) {
                even++;
            }
            else {
                odd++;
                oddKey= (char) m.getKey();
            }
        }
        if(odd>1)
            output="-1";
        else
        {
            output=""+oddKey+"";
            if (hm.containsKey(oddKey))
            {
                int x= hm.get(oddKey);
                x--;
                hm.remove(oddKey);
                hm.put(oddKey,x);
            }

            for(Map.Entry m:hm.entrySet()){
                char ch=(char) m.getKey();
                int x= (int) m.getValue();
                while(x>0)
                {
                    output=ch+output+ch;
                    x=x-2;
                }
            }
        }

        return output;

    }
}
