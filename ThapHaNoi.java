package CodeLearn;
public class ThapHaNoi {
    public static void main(String[] args) {
       int nDisks = 3;
       dequy(nDisks, 'A', 'B', 'C');//c la dich
    }
    public static void dequy(int topN, char from, char temp, char to) {
       if (topN == 1)
          System.out.println("Disk 1 from "+ from + " to " + to);
       else {
          dequy(topN - 1, from, to, temp);
          System.out.println("Disk "+ topN + " from " + from + " to " + to);
          dequy(topN - 1, temp, from, to);
       }
    }
 }