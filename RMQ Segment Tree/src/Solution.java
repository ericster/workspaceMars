import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
        5 5
		1 5 2 4 3
		q 1 5
		q 1 3
		q 3 5
		u 3 6
		q 1 5

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String split[]=br.readLine().trim().split(" ");
        int sizeArr=Integer.parseInt(split[0]);
        int noOfQueries=Integer.parseInt(split[1]);
        split=br.readLine().trim().split(" ");
        int arr[]=new int[sizeArr];
        for(int i=0;i<split.length;i++){
            arr[i]=Integer.parseInt(split[i]);
        }
        int height=(int)Math.ceil(Math.log(sizeArr)/Math.log(2));
        int possibleValues=4*arr.length;//(int)(Math.pow(2,height)+1);
        int[] segmentTree=new int[possibleValues];
        createSegmentTree(arr,0,arr.length-1,segmentTree,0);
        for(int i=0;i<noOfQueries;i++){
            split=br.readLine().trim().split(" ");
            if(split[0].equals("q")){
                int l=Integer.parseInt(split[1])-1;
                int r=Integer.parseInt(split[2])-1;
                System.out.println(minInRange(segmentTree, l,r,0,arr.length-1,0));
            } else{
                int x=Integer.parseInt(split[1])-1;
                int y=Integer.parseInt(split[2]);
                update(segmentTree,x,0,arr.length-1,0,y);
            }
        }
        */
        
        Scanner sc = new Scanner(System.in);
        int sizeArr= sc.nextInt();
        int noOfQueries= sc.nextInt();
        int arr[]=new int[sizeArr];
        for(int i=0;i<sizeArr;i++){
        	arr[i]=sc.nextInt();
        }
        System.out.println("array " + Arrays.toString(arr));
        int height=(int)Math.ceil(Math.log(sizeArr)/Math.log(2));
        int possibleValues=4*arr.length; //(int)(Math.pow(2,height)+1);
        /* construct segment tree */
        int[] segmentTree=new int[possibleValues];
        createSegmentTree(arr,0,arr.length-1,segmentTree,0);
        System.out.println("Segment tree " + Arrays.toString(segmentTree));

        for(int i=0;i<noOfQueries;i++){
        	String command = sc.next();
        	System.out.println("command " + command);
            if(command.equals("q")){
                int l=sc.nextInt()-1;
                int r=sc.nextInt()-1;
                System.out.println(minInRange(segmentTree, l,r,0,arr.length-1,0));
            } 
            else{
                int x=sc.nextInt()-1;
                int y=sc.nextInt();
                update(segmentTree,x,0,arr.length-1,0,y);
            }
        }
    }
    static void  update(int[] st, int index, int start,int end, int stIndex,int newValue){
        if(start==end){
            st[stIndex]=newValue;
            return;
        }
        int mid=start+(end-start)/2;
        if(mid<index){
            update(st,index,mid+1,end,2*stIndex+2,newValue);
          
        } 
        else{
            update(st,index,start,mid,2*stIndex+1,newValue);
        }
          	st[stIndex]=Math.min(st[2*stIndex+1],st[2*stIndex+2]);
    }
    static int  minInRange(int[] st,int low,int high, int start,int end, int index){
    	System.out.println("low "+low+" high: "+high+" s: "+start+" e: "+end+" index: "+index);
        if(low>end||high<start){
            return Integer.MAX_VALUE;
        }
        if(start>=low&&end<=high){
            return st[index];
        }
        int mid=start+(end-start)/2;
        int min = Math.min(minInRange(st,low,high,start,mid,2*index+1),
        minInRange(st,low,high,mid+1,end,2*index+2));
        System.out.println("min " + min);
        return min;
    }
    static void  createSegmentTree(int[] arr,int start,int end,int[] st,int stIndex){
    	if(start>end) return;
        if(start==end){
            st[stIndex]=arr[start];
            return;
        }
        int mid=start+(end-start)/2;
        createSegmentTree(arr,start,mid,st,stIndex*2+1);
        createSegmentTree(arr,mid+1,end,st,stIndex*2+2);
        st[stIndex]=Math.min(st[stIndex*2+1],st[stIndex*2+2]);
    }
}