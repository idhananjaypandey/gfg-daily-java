// Box Stacking

class Solution {

    static class Box {
        int h, w, l;

        Box(int h, int w, int l) {
            this.h = h;
            this.w = w;
            this.l = l;
        }
    }

    public int maxHeight(int[] height, int[] width, int[] length) {

        int n = height.length;

        // Generate all 6 possible rotations.
        List<Box> boxes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            addRotation(boxes, height[i], width[i], length[i]);
            addRotation(boxes, width[i], height[i], length[i]);
            addRotation(boxes, length[i], height[i], width[i]);
        }

        int m = boxes.size();

        int[] dp = new int[m];
        Arrays.fill(dp, -1);

        int answer = 0;

        for (int i = 0; i < m; i++) {
            answer = Math.max(answer, solve(i, boxes, dp));
        }

        return answer;
    }

    private void addRotation(List<Box> boxes, int h, int a, int b) {

        // Make the larger base dimension w
        // and smaller base dimension l.
        if (a >= b) {
            boxes.add(new Box(h, a, b));
        } else {
            boxes.add(new Box(h, b, a));
        }
    }

    private int solve(int current, List<Box> boxes, int[] dp) {

        if (dp[current] != -1) {
            return dp[current];
        }

        Box bottom = boxes.get(current);

        int maxAbove = 0;

        for (int next = 0; next < boxes.size(); next++) {

            Box above = boxes.get(next);
            if (above.w < bottom.w &&
                above.l < bottom.l) {

                maxAbove = Math.max(
                    maxAbove,
                    solve(next, boxes, dp)
                );
            }
        }

        dp[current] = bottom.h + maxAbove;

        return dp[current];
    }
}