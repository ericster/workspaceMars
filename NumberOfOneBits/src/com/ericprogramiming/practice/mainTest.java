package com.ericprogramiming.practice;

public class mainTest {
	public static void main(String[] args) {
		System.out.println("Hello");
		
		int number = 2147483647;
		int count = 0;
		count = hammingWeight(number);
		
		System.out.println("result is " + count);
		count = Integer.bitCount(number);
		System.out.println("result from Integer bitCount is " + count);
		System.out.println("Max integer " + Integer.MAX_VALUE);
	}

    public static int hammingWeight(int n) {
        int count=0;
        while (n!=0){
            if(n%2 ==1) {
                count++;
            }
            n = n/2;
        }
        return count;
    }
}
