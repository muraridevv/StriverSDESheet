package murari.striver.sdesheet.arrayspart3;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int N=m+n-2;
        int r=m-1;
        int result=1;

        for(int i=1;i<=r;i++){
            result=result*(N-r+i)/i;
        }
        return result;
    }
}
