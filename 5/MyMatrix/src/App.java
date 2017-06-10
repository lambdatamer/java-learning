/*
* Напишите интерфейс IMatrix с несколькими реализациями - UsualMatrix и
* расширяющий его SquareMatrix из предыдущих заданий и SparseMatrix для
* разреженных матриц. SparseMatrix должен быть реализован с помощью
* LinkedList (возможно, вам потребуется создать какие-то еще
* дополнительные классы). Все общие методы должны быть представлены в
* интерфейсе IMatrix.
*
* Напишите программу, создающую 2 случайные матрицы размером 1000x1000
* с 1000 нулевых элементов в каждой двумя способами --- с помощью обычных
* и разреженных матриц. Проверьте, что сложение и умножение для разных
* видов матриц дает одинаковые результаты.
*/

package MyMatrix.src;

import java.lang.Math;
import MyMatrix.src.classes.UsualMatrix;
import MyMatrix.src.classes.SquareMatrix;
import MyMatrix.src.classes.SparseMatrix;
import MyMatrix.src.classes.HashMatrix;


public class App {
  public static void main(String[] args) {
    test2();
  }
  private static void log(final Object msg) {
    System.out.println(msg.toString());
  }
  private static void test() {
    int mult = 10;

    // generate usual matrix;
    UsualMatrix um1 = new UsualMatrix(mult, mult);
    int value, zeros = 0;
    for(int i = 0; i < mult; i++) {
      for(int j = 0; j < mult; j++) {
        value = randomRange(0, 9);
        if (value == 0) {
          if (zeros < mult) {
            zeros++;
          } else {
            while (value == 0) {
              value = randomRange(9, 9);
            }
          }
        }
        um1.setElement(i, j, value);
      }
    }

    while (zeros < mult) {
      um1.setElement(randomRange(0, mult - 1), randomRange(0, mult - 1), 0);
      zeros++;
    }

    log(um1);

    // generate sparse matrix

    SparseMatrix spm1 = new SparseMatrix(mult, mult);
    zeros = 0;
    for(int i = 0; i < mult; i++) {
      for(int j = 0; j < mult; j++) {
        value = randomRange(0, 9);
        if (value == 0) {
          if (zeros < mult) {
            zeros++;
          } else {
            while (value == 0) {
              value = randomRange(9, 9);
            }
          }
        }
        spm1.setElement(i, j, value);
      }
    }

    while (zeros < mult) {
      spm1.setElement(randomRange(0, mult - 1), randomRange(0, mult - 1), 0);
      zeros++;
    }

    log(spm1);

    // clone sparse matrix as usual matrix

    UsualMatrix um2 = spm1.clone();

    // check equal

    UsualMatrix sum1 = (um1.add(spm1));  // Sparse + Usual
    UsualMatrix sum2 = (um1.add(um2));  // Usual + Usual
    log(sum1.equals(sum2));

    // check product() the same way
    UsualMatrix mul1 = um1.product(spm1);
    UsualMatrix mul2 = um1.product(um2);
    log(mul1.equals(mul2));

  }
  private static void test2() {
    int mult = 100;

    HashMatrix hm1 = new HashMatrix(mult, mult);
    SparseMatrix sm1 = new SparseMatrix(mult, mult);

    int value, zeros = 0;
    for(int i = 0; i < mult; i++) {
      for(int j = 0; j < mult; j++) {
        value = randomRange(0, 9);
        if (value == 0) {
          if (zeros < mult) {
            zeros++;
          } else {
            while (value == 0) {
              value = randomRange(9, 9);
            }
          }
        }
        sm1.setElement(i, j, value);
        hm1.setElement(i, j, value);
      }
    }

    log(hm1);

    UsualMatrix um1 = new UsualMatrix(mult, mult);
    zeros = 0;
    for(int i = 0; i < mult; i++) {
      for(int j = 0; j < mult; j++) {
        value = randomRange(0, 9);
        if (value == 0) {
          if (zeros < mult) {
            zeros++;
          } else {
            while (value == 0) {
              value = randomRange(9, 9);
            }
          }
        }
        um1.setElement(i, j, value);
      }
    }

    log(hm1.equals(sm1));

    log("Benchmarking SparseMatrix...");

    long start = System.currentTimeMillis();

    sm1.add(um1);

    long finish = System.currentTimeMillis();

    log("Result: " + (finish - start) + " ms");


    log("Benchmarking HashMatrix...");

    start = System.currentTimeMillis();

    hm1.add(um1);

    finish = System.currentTimeMillis();

    log("Result: " + (finish - start) + " ms");
  }
  private static int randomRange(int from, int to) {
    return (int)(from + ((to - from) * Math.random()));
  }
}