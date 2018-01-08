	if (phrase == null) return null;
	if (phrase == "") return null;
    String[] str = phrase.split(" ");

    StringBuffer sb = new StringBuffer();
    for (String word : str) {
        sb.append(word.substring(0, 1).toUpperCase() + word.substring(1));
        sb.append(" ");
    }
    sb.toString().trim();
} 

ArrayList<Integer> arr = new ArrayList<>();
for(int i = 2; i < n; i++) {
	if (n % i == 0) {
		arr.add(i);
	}
}
return arr;