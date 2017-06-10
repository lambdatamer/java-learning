package MyMatrix.src.classes;

import java.util.LinkedList;
import java.util.ListIterator;
import MyMatrix.src.classes.Node;
import MyMatrix.src.interfaces.IMatrix;

public class SparseMatrix extends UsualMatrix implements IMatrix {
  protected LinkedList<Node> nodes;

  public SparseMatrix(int height, int width) {
    super(1, 1);
    this.height = height;
    this.width = width;
    this.nodes = new LinkedList<Node>();
  }

  public int getHeigth() {
    return this.height;
  }

  public int getWidth() {
    return this.width;
  }

  public int getElement(int row, int col) {
    if (row >= this.getHeigth() || col >= this.getWidth()) {
      throw new RuntimeException("Element is out of matrix bounds");
    }

    ListIterator<Node> itr = this.nodes.listIterator(0);
    int value = 0;
    Node current;

    while (itr.hasNext()) {
      current = itr.next();
      if (current.getRow() == row && current.getCol() == col) {
        value = current.getValue();
      }
    }

    return value;
  }

  public void setElement(int row, int col, int value) {
    if (row >= this.getHeigth() || col >= this.getWidth()) {
      throw new RuntimeException("Element is out of matrix bounds");
    }

    if (this.nodes.size() != 0) {
      ListIterator<Node> itr = this.nodes.listIterator(0);
      Node current;
      while (itr.hasNext()) {
        current = itr.next();

        if (current.getRow() == row && current.getCol() == col) {
          if (value == 0) {
            itr.remove();
            return;
          }
          current.setValue(value);
          return;
        }
      }
    }

    if (value == 0) return;

    Node newNode = new Node(row, col, value);
    this.nodes.add(newNode);
  }


}