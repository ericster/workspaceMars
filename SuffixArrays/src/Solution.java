import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
	
	public static int MAXN = 65536;
	public static int MAXLG = 17;

	int N,i;

	public static void main(String[] args) {
		String A = "banana";
		A = "mississippi";
		/*
		 * SuffixArray  [10, 7, 4, 1, 0, 9, 8, 6, 3, 5, 2]
		   lcpArray 	[0, 1, 1, 4, 0, 0, 1, 0, 2, 1, 3]
		 */
		//suffixArrays(A.toCharArray());
		suffixArrays_naive(A);
	}

	static class Entry {
		int[] nr = new int[2];
		int p;
		public Entry(){
			nr = new int[]{0,0};
		}
	}

	public static void suffixArrays_naive(String s){
		int N = s.length();
		String[] suffixes = new String[N];
		int[] sa = new int[N];
		int[] lcp = new int[N];
		for (int i=0;i<N;i++) {
			suffixes[i] = s.substring(i);
		}
		Arrays.sort(suffixes);
		for (int i=0;i<N;i++) {
			sa[i] = N - suffixes[i].length();
		}
		System.out.println("suffix array " + Arrays.toString(sa));

		for (int i=1;i<N;i++) {
			lcp[i] = lcp(suffixes, i);
		}
		System.out.println("lcp " + Arrays.toString(lcp));
	}
	
	public static int lcp(String[] suffixes, int k) {
		String s = suffixes[k-1];
		String t = suffixes[k];
		int N = Math.min(s.length(), t.length());
		for (int i=0;i<N;i++) {
			if (s.charAt(i) != t.charAt(i)) return i;
		}
		return N;
	}

	
	
	public static void suffixArrays(char[] A){
		long start = System.currentTimeMillis();
		int N = A.length;
		// P[i][j] denotes rank of suffix at position 'j' when all suffixes are sorted by their first '2^i'
		int[][] P = new int[MAXLG][N];
		int[][] Sorted = new int[MAXLG][N];
		int[] suffixArray = new int[N];
		int[] lcpArray = new int[N];
		Entry[] L = new Entry[N];
		/* Initialization matters */
		for (int i=0;i<N;i++){
			L[i] = new Entry();
		}
	    for(int i = 0; i < N; i++){
	        P[0][i] = A[i] - 'a';
	    }
	    Sorted[0] = P[0];
	   System.out.println("P["+0+"]" + Arrays.toString(P[0]));

	    int stp = 1;
	    for(int cnt = 1; cnt < N; stp++, cnt *= 2)
	    {
			System.out.println("stp " + stp );
	        for(int i=0; i < N; i++)
	        {
	            L[i].nr[0] = P[stp - 1][i];
	            L[i].nr[1] = i + cnt<N ? P[stp -1][i+ cnt]:-1;
	            L[i].p = i;
	        }
	        for(int i=0; i < N; i++){
	        	Sorted[stp][i] = L[i].nr[0];
	        }

	        Arrays.sort(L, new Comparator<Entry>() {
	            @Override
	            public int compare(Entry a, Entry b) {
					return (a.nr[0]==b.nr[0]) ? (a.nr[1] - b.nr[1]) : (a.nr[0]-b.nr[0]);
	            }
	        });
	        for(int i=0; i < N; i++){
	            /*Assign same rank to suffixes which have same number in the first and second fields of their respective tuples.*/
	            P[stp][L[i].p] = (i> 0 && L[i].nr[0]==L[i-1].nr[0] && L[i].nr[1] == L[i- 1].nr[1]) ? P[stp][L[i-1].p] : i;
	        }

	    	System.out.println("P["+stp+"]" + Arrays.toString(P[stp]));
	    	System.out.println("Sorted["+stp+"]" + Arrays.toString(Sorted[stp]));
	    }
	    
	    stp--;
		for (int i=0;i<N;i++){
			   suffixArray[P[stp][i]] = i;
		}
		System.out.println("SuffixArray " + Arrays.toString(suffixArray));

		/*** LCP ***/
		lcpArray[0] = 0;
		for(int i=1;i<N;i++){
			int value = 0;
			int x = suffixArray[i-1];
			int y = suffixArray[i];
			for (int k=stp;k>=0;k--){
				//System.out.println(" i " + i+ " k " + k + " x " + x + " y " + y);
				if (x<N&&y<N&&P[k][x]==P[k][y]){
					value += (int)Math.pow(2, k);
					x += (int)Math.pow(2, k);
					y += (int)Math.pow(2, k);
				}
			}
			lcpArray[i] = value;
		}
		System.out.println("lcpArray " + Arrays.toString(lcpArray));

		long end = System.currentTimeMillis();
		NumberFormat formatter = new DecimalFormat("#0.00000");
		System.out.print("Execution time is " + formatter.format((end - start) / 1000d) + " seconds");
	}
}