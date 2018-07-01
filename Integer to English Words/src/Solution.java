import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {

	public static void main(String[] args) {
		/*
		 * 	123 -> "One Hundred Twenty Three"
			12345 -> "Twelve Thousand Three Hundred Forty Five"
			1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
		 */
		int num = 1234567;
		num = 123;
		num = 19;
		num = 1000;
		num = 1001;
		num = 50868;
		num = 10000;
		//num = 100000;
		//num = 1000000;
		//num = 10000000;
		
		String res = numberToWords(num);
		
		System.out.println("number in word is : " + res);

	}
	
	
    public static String numberToWords(int num) {
    	if (num==0) return "Zero";
    	String[] ones = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" ,
    	"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", 
    	"Eighteen", "Nineteen" };
    	String[] decs = { "", "",  "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    	String[] hundreds  = { "", "Thousand", "Million", "Billion"};
    	ArrayList<String> res = new ArrayList<String>();
    	
    	int digitCnt = 0;
    	int threeCnt = 0;
    	while(num > 0){
    		if (digitCnt%3 == 0){
				if (threeCnt > 0 ){
					if (num%1000 != 0){
						res.add(hundreds[threeCnt]);
					}
				}
    			if (num%100 < 20){
					if (num%100 !=0){
						res.add(ones[num%100]);
					}
					num=num/100;
    			}
    			else {
    				if (num%10 !=0){
						res.add(ones[num%10]);
    				}
    				num=num/10;
    				if (num%10 !=0){
						res.add(decs[num%10]);
    				}
    				num=num/10;
    			}
    			digitCnt +=2;
    			//12345;
    		}
    		else if (digitCnt%3 == 2){
    			if (num%10 !=0){
					res.add("Hundred");
					res.add(ones[num%10]);
    			}
				num=num/10;
				digitCnt++;
				threeCnt++;
    		}
    	}
    	
    	Collections.reverse(res);
    	//return Arrays.toString(res.toArray()).replace(",", "");
    	return res.toString().replace(",", "")
    			.replace("[", "")  //remove the right bracket
    		    .replace("]", "")  //remove the left bracket
    		    .trim(); 
    	//return res.toString();
        
    }

}
