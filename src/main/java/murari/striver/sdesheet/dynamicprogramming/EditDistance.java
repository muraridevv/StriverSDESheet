package murari.striver.sdesheet.dynamicprogramming;

public class EditDistance {
    public int minDistanceRecursion(String word1, String word2) {
        return minDistanceHelper(word1, word2, word1.length(), word2.length());
    }

    private int minDistanceHelper(String word1, String word2, int m, int n){
        //Base Case: If any of strings become empty
        if(m==0){
            return n;// insert n chars to word1 from word2
        }
        if(n==0){
            return m;// delete m chars from word1
        }

        // If chars in both string matches
        if(word1.charAt(m-1)==word2.charAt(n-1)){
            return minDistanceHelper(word1, word2, m-1, n-1);
        }

        //Recursively call for insert, delete, and replace
        int insert= minDistanceHelper(word1, word2, m, n-1)+1;
        int delete= minDistanceHelper(word1, word2, m-1, n)+1;
        int replace= minDistanceHelper(word1, word2, m-1, n-1)+1;

        return Math.min(insert, Math.min(delete, replace));
    }

    public int minDistance(String word1, String word2) {
        int[][] dp= new int[word1.length()+1][word2.length()+1];

        for(int i=0; i<=word1.length(); i++){
            dp[i][0]= i;
        }

        for(int j=0; j<=word2.length(); j++){
            dp[0][j]=j;
        }

        for(int i=1; i<= word1.length(); i++){
            for(int j=1; j<=word2.length(); j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                } else {
                    dp[i][j]= 1+Math.min(dp[i-1][j], Math.min(dp[i][j-1],dp[i-1][j-1]));
                }

            }
        }
        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        EditDistance editDistance = new EditDistance();
        String word1 = "horse";
        String word2 = "ros";
        int minOps = editDistance.minDistance(word1, word2);
        System.out.println("Minimum number of operations: " + minOps);
    }
}
