package aug14;

public class InnerEx3 {
	private int outerIv = 0;
	static int outerCv = 0;
	class InstanceInner {
		int iiv = outerIv;
		int iiv2 = outerCv;
	}
	static class StaticInner {
		static int scv = outerCv;
	}
	void myMethod() {
		int lv = 0;
		final int LV = 0;
		class LocalInner {
			int liv = outerIv;
			int liv2 = 2;
			int liv4 = LV;
		}
	}
}
