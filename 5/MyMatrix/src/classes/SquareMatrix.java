package MyMatrix.src.classes;

import MyMatrix.src.classes.UsualMatrix;
import MyMatrix.src.interfaces.IMatrix;

public class SquareMatrix extends UsualMatrix implements IMatrix {
  public SquareMatrix(int size) {
    super(size, size);
    for (int i = 0; i < size; i++) {
      this.setElement(i, i, 1);
    }
  }

  public int getSize() {
    return this.getHeight();
  }

  public SquareMatrix add(SquareMatrix operand) {
    if (this.getSize() != operand.getSize()) {
      throw new RuntimeException("Sum operation can only be performed over matrices with equal width and height");
    }
    SquareMatrix result = new SquareMatrix(this.getSize());

    int tmp;
    for (int i = 0; i < this.getSize(); i++) {
      for (int j = 0; j < this.getSize(); j++) {
        tmp = this.getElement(i, j) + operand.getElement(i, j);
        result.setElement(i, j, tmp);
      }
    }
    return result;
  }

  public SquareMatrix product(SquareMatrix operand) {
    if (this.getSize() != operand.getSize()){
      throw new RuntimeException("Matrices must have equal size to product");
    }
    SquareMatrix result = new SquareMatrix(this.getSize());
    int tmp;
    for (int i = 0; i < result.getSize(); i++) {
      for (int j = 0; j < result.getSize(); j++) {
        tmp = 0;
        for (int k = 0; k < this.getSize(); k++) {
          tmp += this.getElement(i, k) + operand.getElement(k, j);
        }
        result.setElement(i, j, tmp);
      }
    }
    return result;
  }
}