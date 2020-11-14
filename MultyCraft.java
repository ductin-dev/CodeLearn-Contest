package CodeLearn;

public class MultyCraft{
    static int n;
    static int[] a=new int[10];
    static int[] x=new int[10];
    static int[] y=new int[10];
    static int[] z=new int[10];
    static int T;

    static boolean DFS(int i) {
        //khong hop le___________________________
        if (x[0] < 0 || y[0] < 0 || z[0] < 0) { 
            return false;
        }
        //Gia tri cuoi co roi____________________
        if (i > 1) 
            if (x[i - 1] + y[i - 1] + z[i - 1] > T)
                return false;
        //Trang thai cuoi cung tr khi chet het___
        if (i == n + 1) return true;
        //Ko tim ra _____________________________
        if (x[0] * 9 + y[0] * 3 + z[0] < a[0]) return false;
        //_______________________________________
        int sum = a[i];
        int nx = (sum + 8) / 9;
        nx = Math.min(nx, x[0]);
        for (; nx >= 0; nx--) {
            x[i] = nx;
            x[0] -= x[i];
            sum -= x[i] * 9;
            int ny = (sum + 2) / 3;
            if (sum <= 0)ny = 0;
            ny = Math.min(ny, y[0]);
            for (; ny >= 0; ny--) {
                y[i] = ny;
                y[0] -= y[i];
                sum -= y[i] * 3;
                z[i] = Math.max(0, sum);
                z[0] -= z[i];
                a[0] -= a[i];
                boolean temp = DFS(i + 1);
                if (temp) return true;
                a[0] += a[i];
                z[0] += z[i];
                y[0] += y[i];
                sum += y[i] * 3;
            }
            sum += x[i] * 9;
            x[0] += x[i];
        }
        return false;
    }

    static int mutaliskAttack(int[] scvs) {
        n=scvs.length;
        for (int i=0;i<n-1;i++)
            for (int j=i+1;j<n;j++)
                if (scvs[i]<scvs[j]){
                    int temp=scvs[i];
                    scvs[i]=scvs[j];
                    scvs[j]=temp;
                }
        //_____________________________
        a[0]=0;
        for (int i=0;i<n;i++) a[i+1]=scvs[i];
        int minS=a[0]/13;
        int l=minS, r=41,res=42;
        //_____________________________
        while (l <= r) {
            int m = (l + r) >> 1;
            T = m;x[0] = m;y[0] = m;z[0] = m;
            boolean check = DFS(1);
            if (check) {
                res = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return res;

    }
    public static void main(String[] args) {
        int[] e={55,60,53};//=13
        System.out.println(mutaliskAttack(e));
    }
}