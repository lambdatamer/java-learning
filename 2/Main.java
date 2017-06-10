// Напишите программу, выводящую первые 10 степеней матрицы   
// [1 1]
// [1 0]

//

public class Main {
  public static void main(String[] args) {
    Matrix m = new Matrix(3);

    for (int i = 0; i < m.getSize(); i++) {
      for (int j = 0; j < m.getSize(); j++) {
        m.setElement(i, j, i + j);
      }
    }

    System.out.println(m);
    System.out.println(m.doMiracle(0));
    System.out.println(m.doMiracle(1));

  }
}