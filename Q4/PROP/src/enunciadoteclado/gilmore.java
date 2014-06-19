/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package enunciadoteclado;

/**
 *
 * @author alex
 */
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace NathanBrixius.AssignmentLib {
  /// <summary>Computes the Gilmore-Lawler bound.</summary>
  public class gilmore{
    /// <summary>Computes the Gilmore-Lawler bound.</summary>
    /// <param name="qap">The QAP.</param>
    /// <param name="p">Primal solution.</param>
    /// <param name="U">Reduced costs matrix (dual solution).</param>
    /// <returns>The Gilmore-Lawler bound of the QAP.</returns>
    public static double Bound(Qap qap, int[] p, double[][] U) {
      int n = qap.Size;

      double[][] L = AssignmentMatrix(qap);

      // Solve LAP(L) to get bound - U is the reduced costs matrix.
      int[] ip = new int[n];
      double[] ys = new double[n];
      double[] yt = new double[n];
      double bound = LinearAssignment.Solve(L, p, ip, ys, yt) + qap.Shift;
      LinearAssignment.ReducedCosts(L, U, ys, yt);
      return bound;
    }

    public static double[][] AssignmentMatrix(Qap qap) {
      int n = qap.Size;
      // copy all elements of B_i into br_i except B_ii
      double[][] br = LinearAlgebra.NewMatrix(n, n - 1);
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < i; j++) {
          br[i][j] = qap.B[i][j];
        }
        for (int j = i + 1; j < n; j++) {
          br[i][j - 1] = qap.B[i][j];
        }
        Array.Sort(br[i]);
        Array.Reverse(br[i]); // descending
      }

      // L_ij = A_ii B_jj + _ + c_ij
      // (A'_i is computed inline below)
      double[][] L = LinearAlgebra.NewMatrix(n);
      double[] ar_i = new double[n - 1];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < i; j++) {
          ar_i[j] = qap.A[i][j];
        }
        for (int j = i + 1; j < n; j++) {
          ar_i[j - 1] = qap.A[i][j];
        }
        Array.Sort(ar_i); // ascending
        for (int j = 0; j < n; j++) {
          double l_ij = qap.A[i][i] * qap.B[j][j] + qap.C[i][j];
          for (int k = 0; k < n - 1; k++) {
            l_ij += ar_i[k] * br[j][k];
          }
          L[i][j] = l_ij;
        }
      }
      return L;
    }
  }
}
