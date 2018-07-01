

/**
 * Quick and dirty Suffix- and LCP-array construction algorithms
 */
import java.util.*;

class SuffixComparator implements Comparator {
	String s;

    public int compare(Object o, Object p) {
	String str1 = s.substring(((Integer) o).intValue());
	String str2 = s.substring(((Integer) p).intValue());
	return str1.compareTo(str2);
    }

    SuffixComparator(String str) {
	s = str;
    }
}

class SuffixArrayNaive {
    int len;
    int[] A;

    SuffixArrayNaive(String s) {
        len = s.length();
	SuffixComparator comp = new SuffixComparator(s);
        Integer[] suffixes = new Integer[len];
        for (int i = 0; i < len; i++) suffixes[i] = new Integer(i);
        Arrays.sort(suffixes, comp); // build suffix array the naive way
        A = new int[len];
        for (int i = 0; i < len; i++) A[i] = suffixes[i].intValue();
    }
}

class LCPArray {
    int H[];
    
    LCPArray(String s, int[] A) {
	int l = s.length();
	H = new int[l];

	// build inverse suffix array I:
	int[] I = new int[l];
	for (int i = 0; i < l; i++) I[A[i]] = i;

	
	// build LCP:
	int h = 0; H[0] = 0;
	for (int i = 0; i < l; i++) {
	    if (I[i] != 0) {
		while (s.charAt(i+h) == s.charAt(A[I[i]-1]+h)) h++;
		H[I[i]] = h--;
		if (h < 0) h = 0;
	    }
	}
    }
}

class sarry {
    public static void main(String args[]) {
	SuffixArrayNaive sa = new SuffixArrayNaive(args[0]);
	for (int i = 0; i < args[0].length(); i++) {
	    System.out.print(sa.A[i] + ",");
	}
	System.out.println();

	LCPArray lcp = new LCPArray(args[0], sa.A);
	for (int i = 0; i < args[0].length(); i++) {
	    System.out.print(lcp.H[i] + ",");
	}
	System.out.println();
    }
}
