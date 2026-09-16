class Solution {

    private static final long MOD = 1_000_000_007;

    public int numberOfSets(int n, int k) {

        int N = n + k - 1;
        int R = 2 * k;

        long[] fact = new long[N + 1];
        long[] invFact = new long[N + 1];

        // Calculate factorials
        fact[0] = 1;

        for (int i = 1; i <= N; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }

        // Calculate inverse factorial
        invFact[N] = power(fact[N], MOD - 2);

        for (int i = N - 1; i >= 0; i--) {
            invFact[i] = (invFact[i + 1] * (i + 1)) % MOD;
        }

        // C(N, R) = N! / (R! * (N-R)!)
        long ans = fact[N];

        ans = (ans * invFact[R]) % MOD;
        ans = (ans * invFact[N - R]) % MOD;

        return (int) ans;
    }

    // Fast modular exponentiation
    private long power(long a, long b) {

        long result = 1;

        while (b > 0) {

            if ((b & 1) == 1) {
                result = (result * a) % MOD;
            }

            a = (a * a) % MOD;
            b >>= 1;
        }

        return result;
    }
}