/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodeLearn;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class DFS {

    static boolean isPerfect(int a){
        if (a<1) return false;
        int temp=(int)Math.sqrt(a);
        if ((temp*temp)==a) return true;
        return false;
    }
    static int count=0;
    static ArrayList<Integer> a=new ArrayList<>();
    static void res(int v,boolean[] visited,int tong,int n){
        visited[v]=true;
        tong+=a.get(v).intValue();
        System.out.println(v);
        if (tong>=n) {
            if (tong==n){
                count++;
            }  
            visited[v]=false;
            tong-=a.get(v).intValue();
            return;
        }
        for (int i=v+1;i<a.size();i++)
            if (!visited[i]) res(i,visited,tong,n);
            
        visited[v]=false;
        tong-=a.get(v).intValue();
    }
    static void DFS1(int v,int size,int n){
        boolean visited[] = new boolean[size]; 
        res(v, visited,0,n); 
    }
    static int countCase(int n){
        for (int i=1;i<=n;i++)
            if (isPerfect(i))a.add(i);
        
        for (int i=0;i<a.size();i++) DFS1(i,a.size(),n); 
        int result=count;
        return result;
    }//1 4 9 16 25 36 49 64 81 100 121 144 169 196 225

    public static void main(String[] args) {
        System.out.println(countCase(234));
    }
    
}