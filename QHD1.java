/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodeLearn;

public class QHD1 {

    static int jumppingMokey(int[] a)
    {
        int n=a.length;
        if ((n==1)&&(a[0]==0)) return 0;
        if (n==2) return -1;
        if (n==3) if ((a[0]==0)&&(a[2]==0)) return 1;
        if (n==4) if ((a[0]==0)&&(a[3]==0)) return 1;
        if ((a[0]==1)||(a[n-1]==1)) return -1;
        int[] l=new int[n];
        if (a[2]==0) l[2]=1;
        if (a[3]==0) l[3]=1;
        for (int i=4;i<n;i++){
            if (a[i]==1) l[i]=0; 
            else if ((l[i-2]==0)&&(l[i-3]==0)) l[i]=0;
            else if (l[i-2]==0) l[i]=l[i-3]+1;
            else if (l[i-3]==0) l[i]=l[i-2]+1;
           
            else l[i]=Math.min(l[i-2],l[i-3])+1;
        }
        if (l[n-1]==0) return -1;
        return l[n-1];
    }
    
    

    public static void main(String[] args) {
        int[] a=new int[100000];
        a[0]=0;a[99999]=0;
        for (int i=1;i<99999;i++){
            int temp=(int)Math.round(Math.random()*20);
            if (temp<1) temp=1; else temp=0;
            a[i]=temp;
            System.out.print(a[i]+",");
        }

        //int[] b={2,3,1};
        System.out.println(jumppingMokey(a));
    }
    
}