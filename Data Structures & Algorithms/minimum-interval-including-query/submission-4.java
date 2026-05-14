class SegmentTree {
    int n;
    int[] tree;
    int[] lazy;

    SegmentTree(int n) {
        this.n = n;
        this.tree = new int[4 * n];
        this.lazy = new int[4 * n];
        Arrays.fill(this.tree, Integer.MAX_VALUE);
        Arrays.fill(this.lazy, Integer.MAX_VALUE);
    }

    void propagate(int ind, int l, int h) {
        if(lazy[ind] != Integer.MAX_VALUE) {
            tree[ind] = Math.min(tree[ind], lazy[ind]);

            if(l != h) {
                lazy[2 * ind + 1] = Math.min(lazy[2 * ind + 1], 
                lazy[ind]);

                lazy[2 * ind + 2] = Math.min(lazy[2 * ind + 2], 
                lazy[ind]);
            }

            lazy[ind] = Integer.MAX_VALUE;
        }
    }

    void update(int ind, int l, int h, int left, int right, int val) {
        propagate(ind, l, h);

        if(l > right || h < left) {
            return;
        }

        if(l >= left && h <= right) {
            lazy[ind] = Math.min(lazy[ind], val);
            propagate(ind, l, h);
            return;
        }

        int mid = l + (h - l) / 2;
        update(2 * ind + 1, l, mid, left, right, val);
        update(2 * ind + 2, mid + 1, h, left, right, val);
        tree[ind] = Math.min(tree[2 * ind + 1], tree[2 * ind + 2]);
    }

    void update(int left, int right, int val) {
        update(0, 0, n - 1, left, right, val);
    }

    int query(int ind, int l, int h, int idx) {
        propagate(ind, l, h);
        if (l == h) {
            return tree[ind];
        }

        int mid = l + (h - l) / 2;
        return idx <= mid ? query(2 * ind + 1, l, mid, idx) :
        query(2 * ind + 2, mid + 1, h, idx);
    }

    int query(int ind) {
        return query(0, 0, n - 1, ind);
    }
}
class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Set<Integer> pointSet = new HashSet<>();
        for(int[] interval : intervals) {
            pointSet.add(interval[0]);
            pointSet.add(interval[1]);
        }

        for(int query : queries) {
            pointSet.add(query);
        }

        List<Integer> points = new ArrayList<>(pointSet);
        Collections.sort(points);

        Map<Integer, Integer> compress = new HashMap<>();
        for(int i = 0; i < points.size(); i++) {
            compress.put(points.get(i), i);
        }

        SegmentTree segTree = new SegmentTree(points.size());

        for(int[] interval : intervals) {
            int start = compress.get(interval[0]);
            int end = compress.get(interval[1]);
            int length = interval[1] - interval[0] + 1;
            segTree.update(start, end, length);
        }

        int[] ans = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            int ind = compress.get(queries[i]);
            int res = segTree.query(ind);
            ans[i] = res == Integer.MAX_VALUE ? -1 : res;
        }

        return ans;
    }
}
