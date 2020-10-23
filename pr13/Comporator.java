package pr13;

interface Comparator {
    void QuickSort(double[] array, int low, int high);
    void MergeSort(double[] arr, int l, int r);
    void Merge(double[] arr, int l, int m, int r);
}