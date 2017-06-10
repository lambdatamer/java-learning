package MyMatrix.src.classes;

public class Node {
  protected final int row;
  protected final int col;
  protected int val;

  public Node(int row, int col, int val) {
    this.row = row;
    this.col = col;
    this.val = val;
  }

  public int getValue() {
    return val;
  }

  public void setValue(int value) {
    this.val = value;
  }

  public int getCol() {
    return this.col;
  }

  public int getRow() {
    return this.row;
  }

  public String toString() {
    return ("[" + row + "," + col + "] = " + val);
  }
}