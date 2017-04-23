package algorithm;

public class CompareVersion {
	public int compareVersion(String version1, String version2) {
		String[] splip1 = version1.split("\\.");
		String[] split2 = version2.split("\\.");
		int len = Math.max(splip1.length, split2.length);
		for (int i = 0; i < len; i++) {
			Integer num1 = i < splip1.length ? Integer.parseInt(splip1[i]) : 0;
			Integer num2 = i < split2.length ? Integer.parseInt(split2[i]) : 0;
			int com = num1.compareTo(num2);
			if (com != 0) {
				return com;
			}
		}
		return 0;
	}
}
