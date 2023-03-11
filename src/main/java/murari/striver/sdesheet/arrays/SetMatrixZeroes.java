package murari.striver.sdesheet.arrays;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int []row=new int[matrix.length];
        for(int i=0;i<row.length;i++){
            row[i]=-1;
        }

        int []col=new int[matrix[0].length];
        for(int i=0;i<col.length;i++){
            col[i]=-1;
        }


        for(int i=0;i<row.length;i++){
            for(int j=0;j<col.length;j++){
                if(matrix[i][j]==0){
                    row[i]=0;
                    col[j]=0;
                }
            }
        }
        for(int i=0;i<row.length;i++){
            for(int j=0;j<col.length;j++){
                if(row[i]==0 || col[j]==0 ){
                    matrix[i][j]=0;
                }
            }
        }

    }
}
