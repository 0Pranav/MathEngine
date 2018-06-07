public class  Matrix3n  {
    float[][] Matrix = new float[3][3];

    //Default constructor returns a identity matrix
    public Matrix3n(){
        for (int i = 0; i <3 ; i++) Matrix[i][i] = 1;
    }
    //Constructor 1m takes a 3x3 array and converts it into Matrix
    //it ignores any array elements beyond 2
    public Matrix3n(float[][] matrix) {
        Matrix = matrix;
    }
    //Constructor 2, Crude integer based.
    public Matrix3n(int n1,int n2,int n3,int n4,int n5,int n6,int n7,int n8,int n9) {
        Matrix[0][0]=n1;
        Matrix[0][1]=n2;
        Matrix[0][2]=n3;
        Matrix[1][0]=n4;
        Matrix[1][1]=n5;
        Matrix[1][2]=n6;
        Matrix[2][0]=n7;
        Matrix[2][1]=n8;
        Matrix[2][2]=n9;
    }
    //Duplicator
    public Matrix3n(Matrix3n m){
        for (int i = 0; i < 3; i++) for (int j = 0; j < 3; j++) Matrix[i][j] = m.Matrix[i][j];
    }
    //Matrix Arithmetic
    public Matrix3n add(Matrix3n m){
        float[][] resultMatrix = new float[3][3];
        for (int i = 0; i <3 ; i++) {
            for (int j = 0; j <3 ; j++) {
                resultMatrix[i][j]=this.Matrix[i][j]+m.Matrix[i][j];
            }
        }
        return  new Matrix3n(resultMatrix);
    }
    public Matrix3n subtract(Matrix3n m){
        float[][] resultMatrix = new float[3][3];
        for (int i = 0; i <3 ; i++) {
            for (int j = 0; j <3 ; j++) {
                resultMatrix[i][j]=this.Matrix[i][j]-m.Matrix[i][j];
            }
        }
        return  new Matrix3n(resultMatrix);
    }
    public Matrix3n multiplyBy (float scalar){
        float[][] resultMatrix= new float[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                resultMatrix[i][j]=scalar*this.Matrix[i][j];
            }
        }
        return new Matrix3n(resultMatrix);
    }
    //Matrix Multiplication
    public  Matrix3n multiplyBy(Matrix3n m){
        float[][] resultMatrix = new float[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    resultMatrix[i][j]= resultMatrix[i][j]+(this.Matrix[i][k]+m.Matrix[k][j]);
                }
            }
        }
        return new Matrix3n(resultMatrix);
    }
    //
}
