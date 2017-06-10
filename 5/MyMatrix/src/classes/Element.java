package MyMatrix.src.classes;

public class Element {
  public final int row;
  public final int col;

  public Element(int row, int col) {
    this.row = row;
    this.col = col;
  }

  public int hashCode () {
    return (this.row * this.col) % 100;
  }

  @Override
  public boolean equals(Object operand) {
    if (!(operand instanceof Element)) {
      return false;
    }
    if (this == operand) {
      return true;
    }

    Element opCast = (Element)operand;
    if ((opCast.row == this.row) && (opCast.col == this.col)){
      return true;
    }
    return false;
  }

}