
public class Solution {

	public static void main(String[] args) {
		int x = 1;
		int y = 4;
		hammingDistance(x, y);

	}
	
    public static int hammingDistance(int x, int y) {
    	int hd =0;
    	
    	while (x!=0 || y!=0){
    		hd += (x % 2) ^ (y % 2);
    		x = x/2;
    		y = y/2;
    	}
    
    	System.out.println("Hamming distance is " + hd);

    	return hd;   
    }

}
