// Count Pairs Violating BST Property

class Solution {
    public int pairsViolatingBST(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root, list);
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return (int) mergeSort(arr, 0, arr.length - 1);
    }

    private void inorder(Node node, ArrayList<Integer> list) {
        if (node == null) return;
        inorder(node.left, list);
        list.add(node.data);
        inorder(node.right, list);
    }

    private long mergeSort(int[] arr, int left, int right) {
        long count = 0;
        if (left < right) {
            int mid = left + (right - left) / 2;
            count += mergeSort(arr, left, mid);
            count += mergeSort(arr, mid + 1, right);
            count += merge(arr, left, mid, right);
        }
        return count;
    }

    private long merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        long invCount = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                invCount += (mid - i + 1);
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        System.arraycopy(temp, 0, arr, left, temp.length);
        return invCount;
    }
}