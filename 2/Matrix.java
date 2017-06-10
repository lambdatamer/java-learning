// Напишите класс Matrix, реализующий квадратные матрицы. В нем должны быть определены

// конструктор  с целочисленным параметром --- размером матрицы, создающий единичную матрицу; 
// методы Matrix sum(Matrix) и Matrix product(Matrix), вычисляющие сумму и произведение матриц  
// матрицы setElement(int row, int column, int value) и getElement(int row, int column), для  обращения к   элементам матрицы;
// метод  toString()

// Во всех методах предполагается, что передаваемые параметры всегда корректны.

public class Matrix implements Cloneable{

  private int[][] matrix;
  private int size;

  Matrix(int size) {
    this.size = size;
    this.matrix = new int[size][size];
    for (int i = 0; i < size; i++) {
      matrix[i][i] = 1;
    }
  }

  public int getSize(){
    return this.size;
  }

  public void setElement(int row, int column, int value) {
    this.matrix[row][column] = value;
  }

  public int getElement(int row, int column) {
    return this.matrix[row][column];
  }

// Sets all matrix's cells to value
  public void flood(int value) {
    for (int i = 0; i < this.size; i++) {
      for (int j = 0; j < this.size; j++) {
        this.matrix[i][j] = value;
      }
    }
  }

  public Matrix doMiracle(int direction) {
    //0 - vertical
    //1 - horizontal

    Matrix result = this.clone();

    int size = result.getSize();

    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        result.setElement(i, j, direction == 1 ? 
          this.getElement(size - (i + 1), j) 
          :
          this.getElement(i, size - (j + 1))
        );
      }
    }
    return result;
  }

  public Matrix sum(Matrix op) {
    int size = this.size;
    Matrix result = new Matrix(size);
    int a, b;
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        a = this.matrix[i][j];
        b = this.matrix[i][j];
        result.setElement(i, j, a + b);
      }
    }
    return result;
  }

// Matrix multiplication
  public Matrix product(Matrix op) {
    int size = this.size;
    Matrix result = new Matrix(size);
    result.flood(0);
    int tmp;

    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        for (int k = 0; k < size; k++) {
          tmp = result.getElement(i, j) + this.getElement(i, k) * op.getElement(k, j);
          result.setElement(i, j, tmp);
        }
      }
    }
    return result;
  }

  @Override
  public String toString() {
    String output = new String();

    for (int i = 0; i < this.size; i++) {
      output += "| ";
      for (int j = 0; j < this.size; j++) {
        output += (String.valueOf(this.matrix[i][j]) + " ");
      }
      output += "|\n";
    }

    return output;
  }

  @Override
  public Matrix clone() {
    Matrix clone = new Matrix(this.size);
    for (int i = 0; i < this.size; i++) {
      for (int j = 0; j < this.size; j++) {
        clone.setElement(i, j, this.matrix[i][j]);
      }
    }
    return clone;
  }
}