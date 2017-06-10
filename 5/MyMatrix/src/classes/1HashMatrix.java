package MyMatrix.src.classes;

import java.util.HashMap;
import MyMatrix.src.classes.UsualMatrix;
import MyMatrix.src.classes.Element;
import MyMatrix.src.interfaces.IMatrix;

public class HashMatrix extends UsualMatrix implements IMatrix {
  protected HashMap<Element, Integer> map;

  public HashMatrix(final int height, final int width) {
    super(1, 1);
    this.height = height;
    this.width = width;
    this.map = new HashMap<Element, Integer>();
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

    Element el = new Element(row, col);
    if (map.containsKey(el)) {
      return this.map.get(el).intValue();
    } else {
      return 0;
    }
  }

  public void setElement(int row, int col, int value) {
    if (row >= this.getHeigth() || col >= this.getWidth()) {
      throw new RuntimeException("Element is out of matrix bounds");
    }

    Element el = new Element(row, col);

    if (value == 0) {
      if (map.containsKey(el)) {
        map.remove(el);
      }
      return;
    }

    map.put(el, value);
  }
}