package nonlinearChaos2;

public class nonlinearChaos2 {

	/* 決定論的カオス（予測不可能カオス）の実験
	 * @param args[]
	 * @return resultval
	 * @throws
	 */
	public static void main(String args[]) {
		int loopnum = 20; // 繰り返し回数
		double constval = 3.7; // 係数
		//  a <= 3 のとき、ある一定の値に収束する。
		//  3 < a <= 3.56995 のときについては、まず aが3を超えたところで 2つの値を繰り返す様になる。
		// さらに aが 1 + sqrt(6) より大きくなると とる値が4つ、8つと増加していく。
		// 3.56995がファイゲンバウム点
		double startval = 0.3; // 初期値
		double resultval;

		resultval = nonlinearChaos(constval, startval,loopnum); // カオス計算処理
		System.out.println("Final result = " + String.valueOf(resultval) ); // 繰り返し計算後結果
	}
	/*
	 * 完全性カオスの計算処理
	 * @param constval(係数), val(計算値), 繰り返し回数
	 * @return val(計算値)
	 * @throws
	 */
	public static double nonlinearChaos(double constval, double val, int loopnum) {
		if(loopnum <= 0) {
			return val;
		}
		loopnum--;
		val = constval * val * ( 1 - val );
		System.out.println("val = " + String.valueOf(val));
		return( nonlinearChaos(constval, val, loopnum));
	}
}
