package CodeLearn;

import java.util.ArrayList;

public class ProminentCharacters {

    static char prominentCharacters(String s)
    {
        ArrayList<Character> a=new ArrayList<>();
        ArrayList<Integer> b=new ArrayList<>();
        int n=s.length();
        for (int i=0;i<n;i++){
            Character temp=s.charAt(i);
            if (!a.contains(temp)){
                a.add(temp);
                b.add(1);
            }else {
                int pos=a.indexOf(temp);
                b.set(pos,b.get(i)+1);
            }
        }
        int m=b.size();
        for (int i=0;i<m-1;i++)
            for (int j=i+1;j<m;j++){
                int temp1=b.get(i);
                int temp2=b.get(j);
                char temp3=a.get(i);
                char temp4=a.get(j);
                if (temp1<temp2){
                    b.set(i,temp2);
                    b.set(j,temp1);
                    a.set(i,temp4);
                    a.set(j,temp3);
                }
            }
        return a.get(0);
    }
    
    
    public static void main(String[] args) {
        int[] b=new int[100000];
        System.out.println("____________________");
        for (int i=0;i<100000;i++) System.out.print(b[i]+",");
        //String[] skill={"Java",".Net","C++","Python","Python"};
        //int[] salary={10,20,30,40,50,60};
        //int[][] c={{-49,-26},{-12,-24},{47,-49},{9,12},{0,-47},{-41,61},{26,83},{-6,-24},{58,-3},{42,-2}};
        System.out.println(prominentCharacters("Java3"));//=50
    }
    
}