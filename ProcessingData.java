package CodeLearn;

public class ProcessingData {

    public static int processingData(int[] a, int[] b, int k) {
        int[] c=new int[a.length];
        for (int i=0;i<a.length;i++){
            c[i]=a[i];
        }
        if (a[0]>=k) return 0;
        for (int i=0;i<a.length;i++){
            for (int j=i+1;j<=Math.min(i+b[i],a.length-1);j++){
                a[j]+=c[i];
                if (a[j]>=k) return j;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] a=new int[100000];
        int[] b=new int[100000];
        for (int i=1;i<99999;i++){
            int temp=Math.max(1,(int)Math.round(Math.random()*100000));
            a[i]=temp;
            System.out.print(a[i]+",");
        }
        System.out.println("===========");
        for (int i=1;i<99999;i++){
            int temp=Math.max(1,(int)Math.round(Math.random()*1000));
            b[i]=temp;
            System.out.print(b[i]+",");
        }
        System.out.println("===========");
        System.out.println(processingData(a, b, 600));
    }
}