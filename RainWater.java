package CodeLearn;

public class RainWater {
    static int[] rainWater(int[] a) {
        int l = 0;
        int r = 1;
        int i = 2;
        int n = a.length;
        while (i < n) {
            if (a[r] < a[i])
                r = i;
            else {
                int min1 = Math.min(a[l], a[r]);
                for (int j = l; j < r; j++)
                    if (a[j] < min1)
                        a[j] = min1;
                if (a[l] < a[r])
                    l = r;
                r = i;
            }

            if (i == n - 1) {
                int min2 = Math.min(a[l], a[r]);
                for (int j = l; j < r; j++)
                    if (a[j] < min2)
                        a[j] = min2;
            }
            i++;
        }
        return a;
    }

    public static void main(String[] args) {
        // String[] a=new String[100000];
        // int[] b=new int[100000];
        // String[] skill={"Java",".Net","C++","Python","Python"};
        int[] salary = { 8, 1, 2, 1, 6 };
        // int[][]
        // c={{-49,-26},{-12,-24},{47,-49},{9,12},{0,-47},{-41,61},{26,83},{-6,-24},{58,-3},{42,-2}};
        System.out.println(rainWater(salary));// =50
    }
}