import java.util.Scanner;

public class  Algorithm {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int nt=sc.nextInt();
		for(int i=0; i< nt; i++){
			char ch[]=new char[16];
			for(int j=0; j< 4; j++){
				char carr[]=sc.next().toCharArray();
				for(int k=0; k< carr.length; k++){
					ch[j*4 + k] = carr[k];
				}
			}
			int res = computeGame(ch, 0);
			if(res != 200){
				System.out.println(res);
			}else{
				System.out.println("impossible");
			}
			
		}
	}

	private static int computeGame(char[] ch, int pos) {
		int x = pos / 4;
		int y= pos % 4;
        if(isGameCompleted(ch)){
			return 0;
		}
		if(pos >=16){
			return 200;
		}
		
		
		int res1 = computeGame(ch, pos+1);
		change(ch, x, y);
		int res2 = computeGame(ch, pos+1)+1;
		change(ch, x, y);
		if(res1 > res2){
			res1 = res2;
		}
		return res1;
	}

	private static void change(char[] ch, int x, int y) {
		changeme(ch, x, y);
		changeme(ch, x-1, y);
		changeme(ch, x+1, y);
		changeme(ch, x, y-1);
		changeme(ch, x, y+1);
	}

	private static void changeme(char[] ch, int x, int y) {
		if(x < 0 || x > 3 || y < 0 || y > 3){
			return;
		}
		if(ch[x*4+y]=='b'){
			ch[x*4+y]='w';
		}else if(ch[x*4+y]=='w'){
			ch[x*4+y]='b';
		}
	}

	private static boolean isGameCompleted(char[] ch) {
		char c = ch[0];
		boolean flg = true;
		for(int i=1; i< 16; i++){
			if(ch[i] != c){
				flg = false;
				break;
			}
		}
		return flg;
	}

}