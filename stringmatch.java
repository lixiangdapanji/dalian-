class Solution {
	public int StringMatch(String A, String B) {
		if(A.equals("") || B.equals("")) {
			return -1;
		}
		StringBuilder sb = new StringBuilder(A);
		int count = 1;

		while (sb.length() < B.length()) {
			sb.append(A);
			count++;
		}
		if (sb.indexOf(B) >= 0) {
			return count;
		}
		sb. append(A);
		if (sb.indexOf(B) >= 0) {
			return count + 1;
		}
		return -1;
	}
}