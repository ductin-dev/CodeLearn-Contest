/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodeLearn;

/**
 *
 * @author Admin
 */
public class SquareEdge {

    static int squareEdge(int[][] a)
    {
        int numberOfPoints=a.length;
        double[] len=new double[numberOfPoints];
        int countLen=0;
        double max=0;
        int pos=0;
        for (int i=0;i<numberOfPoints;i++){
            len[countLen]=Math.sqrt(a[i][0]*a[i][0]+a[i][1]+a[i][1]);
            if (max<len[countLen]){
                max=len[countLen];
                pos=i;
            }
            countLen++;
        }
        return Math.abs(a[pos][1])+Math.abs(a[pos][0]);
    }
    
    

    public static void main(String[] args) {
        /*int[] a=new int[100000];
        a[0]=0;a[99999]=0;
        for (int i=1;i<99999;i++){
            int temp=(int)Math.round(Math.random()*20);
            if (temp<1) temp=1; else temp=0;
            a[i]=temp;
            System.out.print(a[i]+",");
        }*/

        //int[] b={2,3,1};
        int[][] c={{-49,-26},{-12,-24},{47,-49},{9,12},{0,-47},{-41,61},{26,83},{-6,-24},{58,-3},{42,-2}};
        System.out.println(squareEdge(c));
    }
    
}