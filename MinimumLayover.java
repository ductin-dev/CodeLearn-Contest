package CodeLearn;

import java.util.ArrayList;
import java.util.HashMap;

public class MinimumLayover {
    static int min=Integer.MAX_VALUE;
    static int time=0;
    static int daBay=0;
    //Bay den A chi la so chan
    //Bay den B chi la so le
    static int[][] beginAr;
    static HashMap<Integer,ArrayList<Integer>> pos=new HashMap<>();
    static HashMap<Integer,ArrayList<Integer>> posAll=new HashMap<>();
    static void res(int v,int[] total,boolean[] visited,int tong,int n){
        visited[v]=true;
        visited[v+1]=true;
       
        ArrayList<Integer> tempa=posAll.get(v+1);
        for (Integer i:tempa){
            if (visited[i]==false) {
                if (!pos.containsKey(v)) pos.put(v, new ArrayList<>());
                pos.get(v).add(i-1);
            }
            visited[i]=true;
            visited[i-1]=true;
        }
            
        //____________________
        if (time==0) {tong+=total[v]; time=1; } else {tong+=total[v+1]; time=0;}
        daBay++;
        
        //____________________
        if (daBay==n) {
            min=Math.min(min,tong);
            daBay--;//System.out.print("__"+min+"___TONG: "+tong+" >>>");for (int i=1;i<visited.length;i++)System.out.printf(i+":"+visited[i]+"   ");System.out.println();
            visited[v]=false;visited[v+1]=false; 
            ArrayList<Integer>  temp=pos.get(v); 
            if (temp!=null){
                for(Integer i:temp) {visited[i]=false;visited[i+1]=false;}
                pos.remove(v);
            }
            if (time==0) {tong-=total[v]; time=1; } else {tong-=total[v+1]; time=0;}
            return;
        }
        if (tong<min)       //____________________
        for (int i=1;i<total.length;i+=2){
            if ((!visited[i])&&(daBay<n)) res(i,total,visited,tong,n);
            if (tong>min) break;
        //____________________

        }
        daBay--;
        visited[v]=false;visited[v+1]=false;
        ArrayList<Integer>  temp=pos.get(v);//System.out.println(temp);
        if (temp!=null){
            for(Integer i:temp) {visited[i]=false;visited[i+1]=false;}
            pos.remove(v);
        }
        if (time==0) {tong-=total[v]; time=1; } else {tong-=total[v+1]; time=0;}
    }
    static void DFS1(int v,int[] total,int n){
        boolean visited[] = new boolean[total.length]; System.out.println(1);
        res(v,total,visited,0,n); 
    }
    static int[] prase(String s){
        String[] temp=s.split("[ -]+");
        int[] res=new int[2];
        res[0]=Integer.parseInt(temp[0]);
        res[1]=Integer.parseInt(temp[2]);
        if (temp[1].equals("PM")) res[0]+=12;
        if (temp[3].equals("PM")) res[1]+=12;
        return res;
    }
    static int minimumLayover(String[] a, String[] b)
    {
        int n=a.length;
        int departA[]=new int[n+1];////--------
        int departB[]=new int[n+1];           //
        int arriveA[]=new int[n+1];           //
        int arriveB[]=new int[n+1];////--------
        int total[]=new int[n*n*2+1];int count=1;
        for (int i=0;i<n;i++){
            int[] temp1=prase(a[i]);
            departA[i+1]=temp1[0];
            arriveA[i+1]=temp1[1];
            int[] temp2=prase(b[i]);
            departB[i+1]=temp2[0];
            arriveB[i+1]=temp2[1];
        }
        //________________________________
        for (int i=1;i<=n;i++)
            for (int j=1;j<=n;j++){
                if (departB[j]-arriveA[i]<5) total[count++]=departB[j]+24-arriveA[i];
                else total[count++]=departB[j]-arriveA[i];
                if (departA[i]-arriveB[j]<5) total[count++]=departA[i]+24-arriveB[j];
                else total[count++]=departA[i]-arriveB[j];
            }
        //________________________________
        int temp=2;
        beginAr=new int[n+1][n+1];
        for (int i=1;i<=n;i++)
            for (int j=1;j<=n;j++){
                beginAr[i][j]=temp;
                temp+=2;
            }
        for (int i=1;i<=n;i++)
            for (int j=1;j<=n;j++){
                posAll.put(beginAr[i][j], new ArrayList<>());
                for (int k=1;k<n;k++){
                    posAll.get(beginAr[i][j]).add(beginAr[1][k]);
                    posAll.get(beginAr[i][j]).add(beginAr[k][1]);
                }
            }
        for (int i=1;i<count;i+=2) DFS1(i,total,n);
        int result=min;
        return result;
    }
    
    public static void main(String[] args) {
       // String[] a={"6 AM - 8 AM","6 AM - 8 AM","6 AM - 8 AM", "8 AM - 10 AM", "2 PM - 4 PM", "8 PM - 10 PM","2 PM - 4 PM","6 AM - 8 AM"};
        //String[] b={"6 AM - 8 AM","6 AM - 8 AM","6 AM - 8 AM","2 PM - 4 PM", "9 AM - 11 AM","2 PM - 4 PM", "2 PM - 4 PM", "7 PM - 9 PM"};
        String[] a2={"6 AM - 8 AM", "8 AM - 10 AM"};
        String[] b2={"9 AM - 11 AM", "7 PM - 9 PM"};
        System.out.println(minimumLayover(a2, b2));//=42 =28
        //System.out.println(betweenNumber(a, b));
    }
    
}