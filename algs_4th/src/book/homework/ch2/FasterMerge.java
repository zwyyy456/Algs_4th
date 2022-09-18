package book.homework.ch2;

//2.2.10 去掉了检测半边是否用尽的代码
public class FasterMerge {
    public static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        for (int k = lo; k <= mid; k++)
            aux[k] = a[k];
        for (int k = mid + 1; k <= hi; k++)
            aux[k] = a[hi + mid - k + 1];
        int i = lo, j = hi;
        for (int k = lo; k <= hi; k++) {
            if (less(aux[j], aux[i]))
                a[k] = aux[j--];
            else
                a[k] = aux[i++];
        }
    }
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
}
