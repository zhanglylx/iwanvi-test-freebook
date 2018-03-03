package Collection_集和_Set;

public class 生成hashCode与equals方法 {
	private int x;
	private int y;
	public 生成hashCode与equals方法(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	/**
	 * 腾容
	 * 若我们不重写hashCode，那么使用的就是Object提供的
	 * 该方法是返回句柄！换句话说，不同的对象hashCode不同
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		生成hashCode与equals方法 other = (生成hashCode与equals方法) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	
}
