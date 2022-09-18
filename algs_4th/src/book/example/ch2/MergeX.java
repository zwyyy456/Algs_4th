package book.example.ch2;

//2.2.11 改进
//还需要改进"在递归中交换参数来避免数组复制"
public class MergeX {
    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }
    private  static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (lo >= hi)
            return;
        if (hi - lo < 15)
            inSort(a, lo, hi);
        else {
            int mid = (hi - lo) / 2;
            sort(a, aux, lo, mid);
            sort(a, aux, mid + 1, hi);
            merge(a, aux, lo, mid, hi);
        }

    }
    public static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        if (less(a[mid], a[mid + 1]))
            return;
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
    private static void inSort(Comparable[] a, int lo, int hi) {
        for (int k = lo + 1; k <= hi; k++) {
            for (int j = k; j > 0 && less(a[j], a[j - 1]); j--) {
                    exch(a, j, j - 1);
            }
        }
    }
    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

}
