package MyMatrix.src.classes;

import java.lang.StringBuilder;
import MyMatrix.src.interfaces.IMatrix;


public class UsualMatrix implements IMatrix {
  protected int height;
  protected int width;
  protected int[][] matrix;

  public UsualMatrix(final int height, final int width) {
    if (!(height > 0 && width > 0)) {
      throw new RuntimeException("Parameters height and width can't be less or equal to 0");
    }
    this.height = height;
    this.width = width;
    this.matrix = new int[height][width];
  }

  public int getHeight() {
    return this.height;
  }

  public int getWidth() {
    return this.width;
  }

  public void setElement(int row, int col, int value) {
    if (row < 0 || col < 0) {
      throw new RuntimeException("Parameters row and col can't be less than 0");
    }
    if (row >= this.getHeight() || col >= this.getWidth()) {
      throw new RuntimeException("Matrix index out of bounds");
    }
    this.matrix[row][col] = value;
  }

  public int getElement(int row, int col) {
    if (row < 0 || col < 0) {
      throw new RuntimeException("Parameters row and col can't be less than 0");
    }
    if (row >= this.getHeight() || col >= this.getWidth()) {
      throw new RuntimeException("Matrix index out of bounds");
    }
    return this.matrix[row][col];
  }

  public UsualMatrix add(final UsualMatrix operand) {
    if (this.getHeight() != operand.getHeight() || this.getWidth() != operand.getHeight()) {
      throw new RuntimeException("Sum operation can only be performed over matrices with equal width and height");
    }

    UsualMatrix result = new UsualMatrix(this.getHeight(), this.getWidth());
    int a, b;
    for (int i = 0; i < this.getHeight(); i++) {
      for (int j = 0; j < this.getWidth(); j++) {
        a = this.getElement(i, j);
        b = operand.getElement(i, j);
        result.setElement(i, j, a + b);
      }
    }
    return result;
  }

  public UsualMatrix product(final UsualMatrix operand) {
    if (this.getWidth() != operand.getHeight()) {
      throw new RuntimeException("Operand height must be equal to the matrix width to product");
    }
    UsualMatrix result = new UsualMatrix(this.getHeight(), operand.getWidth());
    int tmp;
    for (int i = 0; i < result.getHeight(); i++) {
      for (int j = 0; j < result.getWidth(); j++) {
        tmp = 0;
        for (int k = 0; k < this.getWidth(); k++) {
          tmp += this.getElement(i, k) + operand.getElement(k, j);
        }
        result.setElement(i, j, tmp);
      }
    }
    return result;
  }

  @Override
  public UsualMatrix clone() {
    UsualMatrix clone = new UsualMatrix(this.getHeight(), this.getWidth());
    for (int i = 0; i < this.getHeight(); i++) {
      for (int j = 0; j < this.getWidth(); j++) {
        clone.setElement(i, j, this.getElement(i, j));
      }
    }
    return clone;
  }

  @Override
  public String toString() {
    StringBuilder output = new StringBuilder();
    for (int i = 0; i < this.getHeight(); i++) {
      output.append("| ");
      for (int j = 0; j < this.getWidth(); j++) {
        output.append(String.valueOf(this.getElement(i, j)));
        output.append(" ");
      }
      output.append("|\n");
    }
    return output.toString();
  }

  @Override
  public boolean equals(final Object operand) {
    if (!(operand instanceof UsualMatrix)) {
      return false;
    }
    if (this == operand) {
      return true;
    }

    UsualMatrix opCast = (UsualMatrix)operand;

    if (this.getHeight() != opCast.getHeight() || this.getWidth() != opCast.getWidth()) {
      return false;
    }
    for (int i = 0; i < this.getHeight(); i++) {
      for (int j = 0; j < this.getWidth(); j++) {
        if (this.getElement(i, j) != opCast.getElement(i, j)) {
          return false;
        }
      }
    }
    return true;
  }

}
