import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;


public class Solution {
	 public static void main(String[] args) throws Exception{
		 System.out.println("");
		 HashMap<String, Integer> map = new HashMap<String,Integer>();
		 map.put("hi",5 );
		 String a = "abck";
		 String b = "def";
		 //String result = mergeStrings(a,b);
		 //System.out.println("res " + result);

		 String substr = "spiderman";
		 getMovieTitles(substr);
	 }
	 
	 
	public static String[] getMovieTitles(String substr) throws Exception {
		String url = "https://jsonmock.hackerrank.com/api/movies/search/";
		StringBuilder sb = new StringBuilder("https://jsonmock.hackerrank.com/api/movies/search/");
        sb.append("?Title=");
        sb.append(substr);
        URL obj = new URL(sb.toString());
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		System.out.println("\nSending request to URL : " + url);
		System.out.println("Response Code : " + con.getResponseCode());
		System.out.println("Response Message : " + con.getResponseMessage());
 
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String line;
		StringBuffer response = new StringBuffer();
 
		while ((line = in.readLine()) != null) {
			response.append(line);
		}
		in.close();
 
		System.out.println(response.toString());


		
		return null;
	}
	 
	 
	public static String mergeStrings(String a, String b) {
		
		int a_len = a.length();
		int b_len = b.length();
		int min, max;
		if (a_len < b_len) {
			min = a_len;
			max = b_len;
		}
		else {
			max = a_len;
			min = b_len;
		}
		
		char[] a_arr = a.toCharArray();
		char[] b_arr = b.toCharArray();
		char[] merge = new char[a_len+b_len];
		for (int i=0;i<min;i++) {
			merge[2*i] = a_arr[i];
			merge[2*i+1] = b_arr[i];
		}

		if (a_len < b_len) {
			for (int i=0;i< (b_len-a_len);i++) {
				merge[2*min +i] = b_arr[min + i];
			}
		}
		else {
			for (int i=0;i< (a_len-b_len);i++) {
				merge[2*min +i] = a_arr[min + i];
			}
			
		}
		System.out.println("res" + Arrays.toString(merge));

	    String res = new String(merge);
		return res;

	    }

	
}
	/*
	 * 0 1 2 
	 * 0 1 2 3
	 * 0 1 2 3 4 5 6
	 * a=3
	 * b=4
	 * min = 3
	 * 0, 1
	 * 2, 3
	 * 4, 5
	 * 
	 */