/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodeLearn;

import java.util.ArrayList;
import java.util.Collections;

public class ChooseEmployee {

    static int chooseEmployee(String[] skill, int[] salary, String requestSkill, int k)
    {
        int n=skill.length;
        if (n<k) return -1;
        ArrayList<String> a=new ArrayList<>();
        ArrayList<Integer> b=new ArrayList<>();
        for (int i=0;i<n;i++){
            if (a.contains(skill[i])) b.set(a.indexOf(skill[i]),b.get(a.indexOf(skill[i]))+1);
            else {
                a.add(skill[i]);
                b.add(1);
            }
        }
        
        int res=0;
        if (a.contains(requestSkill)) {
            ArrayList<Integer> temp=new ArrayList<>();
            for (int i=0;i<n;i++) if (skill[i].equals(requestSkill)) temp.add(salary[i]);
            Collections.sort(temp);
            for (Integer i:temp) {
                if (k==0) break;
                res+=i;
                k--;
            }
        }

        int m=b.size();
        for (int i=0;i<m-1;i++)
            for (int j=i+1;j<m;j++){
                int temp1=b.get(i);
                int temp2=b.get(j);
                String temp3=a.get(i);
                String temp4=a.get(j);
                if (temp1<temp2){
                    b.set(i,temp2);
                    b.set(j,temp1);
                    a.set(i,temp4);
                    a.set(j,temp3);
                }else if (temp1==temp2){
                    if (temp3.compareTo(temp4)>0){
                        a.set(i,temp4);
                        a.set(j,temp3);
                        b.set(i,temp2);
                        b.set(j,temp1);
                    }
                }
            }
        
        for (int i=0;i<m;i++){
            if (k==0) break;
            ArrayList<Integer> temp=new ArrayList<>();
            for (int j=0;j<n;j++) if (skill[j].equals(a.get(i))) temp.add(salary[j]);
            Collections.sort(temp);
            for (Integer p:temp) {
                if (k==0) break;
                res+=p;
                k--;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        //String[] a=new String[100000];
        //int[] b=new int[100000];
        /*for (int i=0;i<100000;i++){
            int temp=(int)Math.round(Math.random()*13);
            int luong=(int)(Math.random()*10000);
            switch (temp){
                case 1: a[i]="Java";break;
                case 2: a[i]="Ruby";break;
                case 3: a[i]="Python";break;
                case 4: a[i]="C++";break;
                case 5: a[i]="C#";break;
                case 6: a[i]="DQEOUQ";break;
                case 7: a[i]="Java2";break;
                case 8: a[i]="Java3";break;
                case 9: a[i]="Java4";break;
                case 10: a[i]="Java5";break;
                default:a[i]="Nope";break;
            }
            System.out.print("\""+a[i]+"\",");
            b[i]=luong;
        }
        System.out.println("____________________");
        for (int i=0;i<100000;i++) System.out.print(b[i]+",");*/
        String[] skill={"Java","Java","Java"};
        int[] salary={90,20,50};
        //int[][] c={{-49,-26},{-12,-24},{47,-49},{9,12},{0,-47},{-41,61},{26,83},{-6,-24},{58,-3},{42,-2}};
        System.out.println(chooseEmployee(skill, salary, ".Net", 2));//=50
    }
    
}