class Solution {
    private static final long MOD = 1_000_000_007L;

    public int minTime(int a, int b, int d, int l, int r) {
        long A = a, B = b, D = d;
        long g = A - B;
        long C = A + B;

        long tNorm = normalTime(A, B, D, g, C);
        long total = 0L;

        // Fast O(1) path when g == 1: avoids O(D) loop iterations
        if (g == 1L) {
            long cur = l;
            long endRange = r;

            // Case 1: j < D - A => m = D - A - j > 0, time = ((D - A) * C + A + 1) - C * j
            if (cur <= endRange && cur < D - A) {
                long hi1 = Math.min(endRange, D - A - 1);
                long cnt = hi1 - cur + 1;
                long baseIntercept = (D - A) * C + A + 1;
                long firstVal = baseIntercept - C * cur;
                long step = C;
                total = (total + sumDecreasingApMinCap(firstVal, step, cnt, tNorm)) % MOD;
                cur = hi1 + 1;
            }

            // Case 2: D - A <= j < D => m = 0, time = (D - j) + 1
            if (cur <= endRange && cur < D) {
                long hi2 = Math.min(endRange, D - 1);
                long cnt = hi2 - cur + 1;
                long firstVal = (D - cur) + 1;
                long step = 1L;
                total = (total + sumDecreasingApMinCap(firstVal, step, cnt, tNorm)) % MOD;
                cur = hi2 + 1;
            }

            // Case 3: j >= D => time = 1
            if (cur <= endRange) {
                long cnt = endRange - cur + 1;
                long val = Math.min(tNorm, 1L);
                total = (total + ((cnt % MOD) * (val % MOD)) % MOD) % MOD;
            }

            return (int) (total % MOD);
        }

        // General path for g > 1: m changes in blocks of size ~g
        long cur = l;
        long endRange = r;

        while (cur <= endRange) {
            long m;
            if (A + cur >= D) {
                m = 0L;
            } else {
                m = (D - A - cur + g - 1) / g;
            }

            long basePhaseTime = m * C + 1;
            if (basePhaseTime >= tNorm) {
                long count = endRange - cur + 1;
                total = (total + (count % MOD) * (tNorm % MOD)) % MOD;
                break;
            }

            long hiForM = (m == 0L) ? endRange : Math.min(endRange, D - A - (m - 1) * g - 1);
            if (hiForM < cur) {
                hiForM = cur;
            }

            long threshold = D - m * g;

            if (cur < threshold) {
                long linearEnd = Math.min(hiForM, threshold - 1);
                long cnt = linearEnd - cur + 1;
                long firstVal = m * C + D - m * g + 1 - cur;
                total = (total + sumDecreasingApMinCap(firstVal, 1L, cnt, tNorm)) % MOD;
            }

            long constStart = Math.max(cur, threshold);
            if (constStart <= hiForM) {
                long cnt = hiForM - constStart + 1;
                long val = Math.min(tNorm, basePhaseTime);
                total = (total + ((cnt % MOD) * (val % MOD)) % MOD) % MOD;
            }

            cur = hiForM + 1;
        }

        return (int) (total % MOD);
    }

    private long normalTime(long A, long B, long D, long g, long C) {
        if (D <= A) {
            return D;
        }
        long m = (D - A + g - 1) / g;
        return m * C + (D - m * g);
    }

    // Sums min(cap, firstVal - step * i) for i = 0 .. cnt - 1 (step >= 0).
    // Note: val_i is non-increasing with i, so val_i <= cap holds for i >= i0 where:
    //   firstVal - step * i <= cap  =>  i >= ceil(max(0, firstVal - cap) / step)
    private long sumDecreasingApMinCap(long firstVal, long step, long cnt, long cap) {
        if (cnt <= 0L) return 0L;

        if (firstVal <= cap) {
            long lastVal = firstVal - step * (cnt - 1);
            return apSumMod(firstVal, lastVal, cnt);
        }

        // First index i in [0, cnt - 1] where firstVal - step * i <= cap:
        // step * i >= firstVal - cap => i = (firstVal - cap + step - 1) / step
        long diff = firstVal - cap;
        long firstBelowIdx = (diff + step - 1) / step;

        if (firstBelowIdx >= cnt) {
            // Every element in the progression is > cap
            return ((cnt % MOD) * (cap % MOD)) % MOD;
        }

        long aboveCnt = firstBelowIdx;
        long aboveSum = ((aboveCnt % MOD) * (cap % MOD)) % MOD;

        long belowCnt = cnt - aboveCnt;
        long firstBelowVal = firstVal - step * firstBelowIdx;
        long lastBelowVal = firstBelowVal - step * (belowCnt - 1);
        long belowSum = apSumMod(firstBelowVal, lastBelowVal, belowCnt);

        return (aboveSum + belowSum) % MOD;
    }

    private long apSumMod(long first, long last, long cnt) {
        if (cnt <= 0L) return 0L;
        long sumEnds = first + last;
        long term1, term2;
        if (cnt % 2 == 0) {
            term1 = (cnt / 2) % MOD;
            term2 = sumEnds % MOD;
        } else {
            term1 = cnt % MOD;
            term2 = (sumEnds / 2) % MOD;
        }
        return (term1 * term2) % MOD;
    }
}