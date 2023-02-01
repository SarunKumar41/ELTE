/*
Create a class basics.Matrix, which represents matrices storing double values, with the following operations.
Construction of a matrix of size 𝑀×𝑁
 containing zero elements.
Construction of a matrix of size 𝑀×𝑁
, initialized in a row major order from an array (double[]) of length 𝑀⋅𝑁
Construction of an identity matrix of size 𝑁×𝑁
implemented as a static method.
The transpose of a matrix.
The sum of two (equally sized) matrices.
The difference of two (equally sized) matrices.
The toString() method to represent the matrix textually. (Use the StringBuilder class!)
Create a main program to test the above operations!
*/ 
/**
* Class Matrix
* @author  Sarun Kumar
* @version 1.0
* @since   2022-03-28
*/
package basics;

public class Matrix
{
    private int m;
    private int n;
    double[][] mat;


    public Matrix(int m,int n)
    {
        this.m=m;
        this.n=n;
        mat = new double [m][n]; 
    }

    public Matrix(int m,int n, double[] linearData) 
    {
        if (m*n != linearData.length) {
            throw new IllegalArgumentException("Invalid ...");
        }
        this.m = m;
        this.n = n;
        mat = new double [m] [n];

        for (int i=0; i < linearData.length;i++) 
        {
            int row = (int)Math.floor(i/n);
            int col = i % n;
            mat[row][col] = linearData[i];
        }
    }

    public static Matrix identityM (int n)
    {   
        Matrix m = new Matrix(n,n);

        for (int i=0;i<n;i++)
        {
            for (int j=0;j<n;j++)
            {
                if (i == j)
                {
                    m.mat[i][j] = 1.0;
                }
                else
                {
                    m.mat[i][j] = 0.0;
                }
            }
        }
        return m;
    }

    public Matrix transpose()
    {
        Matrix a = new Matrix(m,n);

        for (int i=0;i<m;i++)
        {
            for (int j=0;j<n;j++)
            {
                a.mat[i][j] = mat[j][i];
            }
        }
            return a;
    }

    public Matrix sum(Matrix x)
    {
        if (x.m != m || x.n != n)
        {
            throw new IllegalArgumentException("Invalid ...");
        }
        Matrix a = new Matrix(m,n);
        for (int i=0;i<m;i++)
        {
            for (int j=0;j<n;j++)
            {
                a.mat[i][j] = mat[i][j] + x.mat[i][j];
            }
        }
            return a;
    }

    public Matrix difference(Matrix x)
    {
        if (x.m != m || x.n != n)
        {
            throw new IllegalArgumentException("Invalid ...");
        }
        Matrix a = new Matrix(m,n);
        for (int i=0;i<m;i++)
        {
            for (int j=0;j<n;j++)
            {
                a.mat[i][j] = mat[i][j] - x.mat[i][j];
            }
        }
            return a;
    }
    public String toString() 
    {
        StringBuilder sb = new StringBuilder();
        sb.append(System.lineSeparator());
        for (double[] row : mat) 
        { 
            for (double elem : row) 
            {
                sb.append(elem);
                sb.append("   ");
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}