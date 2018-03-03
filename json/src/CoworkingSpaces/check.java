package CoworkingSpaces;

public class check {
	// 记录返回结果
	private static boolean[] check;
	// 记录每个线程的运行状态
	private static boolean[] runCheck;

	public check() {
	}

	public check(int size) {
		CoworkingSpaces.check.check = new boolean[size];
		CoworkingSpaces.check.runCheck = new boolean[size];
	}

	public void setCheck(int num, boolean check) {
		CoworkingSpaces.check.check[num] = check;

	}

	public void setRunCheck(int num, boolean check) {
		CoworkingSpaces.check.runCheck[num] = check;
	}

	public boolean checkCheck() {
		int i = 0;
		int j = 0;
		for (boolean s : CoworkingSpaces.check.check) {
			if (s == true) {
				i += 1;
			}
		}
		if (i != 1) {
			return false;
		}
		return true;
	}

	public boolean checkRun() {
		for (boolean s : CoworkingSpaces.check.runCheck) {
			if (s == false) {
				return false;
			}
		}
		return true;
	}
}
