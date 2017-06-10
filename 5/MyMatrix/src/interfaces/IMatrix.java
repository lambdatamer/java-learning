package MyMatrix.src.interfaces;

import MyMatrix.src.classes.UsualMatrix;

public interface IMatrix {
  int getElement(int row, int col);
  void setElement(int row, int col, int value);
  int getWidth();
  int getHeight();
  UsualMatrix add(UsualMatrix operand);
  UsualMatrix product(UsualMatrix operand);
  String toString();
  boolean equals(Object operand);
  UsualMatrix clone();
}