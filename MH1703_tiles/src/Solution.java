
public class Solution {

	public static void main(String[] args) {
		/*
		* @file [MH1703] 수정이의 타일자르기
		* @brief 모범풀이법
		* Copyright 2017 by Samsung Electronics, Inc.
		*/
		 
		 
		 
		 
		/*
		 큰 타일부터 잘라낸다.
		 잘라내야 하는 타일의 크기는 2^s형태이므로, 자를 때 왼쪽 위부터 하나씩 잘라서,
		 어떤 직사각형 타일을 자르고 나면 (최대) 세 개의 좀 더 작은 타일이 생긴다고 생각하면 된다.
		 만약 원하는 크기를 만들 수 없다면 새로운 크기 M의 타일을 사면 된다.
		*/
		 
		 
		int QUEUE_SIZE = 5000;
		 
		 
		Class Paper{
		 int x;
		 int y;
		};
		 
		 
		int N, M; 
		int[] S = new int[505];
		Paper[] paper_queue = new Paper[QUEUE_SIZE];
		 
		 
		//Reference Code 참고
		void quickSort(int first, int last)
		{
		 int pivot;
		 int i;
		 int j;
		 int temp;
		 
		 
		 if (first < last)
		 {
		  pivot = first;
		  i = first;
		  j = last;
		 
		 
		  while (i < j)
		  {
		   while (S[i] <= S[pivot] && i < last)
		   {
			i++;
		   }
		   while (S[j] > S[pivot])
		   {
			j--;
		   }
		   if (i < j)
		   {
			temp = S[i];
			S[i] = S[j];
			S[j] = temp;
		   }
		  }
		 
		 
		  temp = S[pivot];
		  S[pivot] = S[j];
		  S[j] = temp;
		 
		 
		  quickSort(first, j - 1);
		  quickSort(j + 1, last);
		 }
		}
		 
		 
		void push(int rear, int x, int y)
		{
		 paper_queue[rear].x = x;
		 paper_queue[rear].y = y;
		 rear++;
		 rear %= QUEUE_SIZE;
		}
		 
		 
		 
		int main()
		{
		 int Test;
		 scanf("%d", &Test);
		 for (int tc = 1; tc <= Test; tc++){
		   
		  scanf("%d %d", &N, &M);
		  for (int i = 0; i<N; i++) scanf("%d", &S[i]);
		 
		 
		  //S[i]를 오름차순으로 정렬한다.
		  quickSort(0, N-1);
		 
		 
		  int ans = 0;
		 
		 
		  //queue의 처음과 끝을 가리킬 포인터
		  int front = 0, rear = 0;
		 
		 
		  for (int i = N - 1; i >= 0; i--){
		   int sz = (1 << S[i]);
		 
		 
		   //크기에 맞는 타일이 있는지 확인하는 변수
		   int f = 0;
		 
		 
		   //queue를 확인할 변수
		   int ptr = front;
		   int last = rear;
		 
		 
		   while (ptr != last)
		   {
			//queue의 사이즈를 모듈러 연산으로 사용함으로써,
			//사용했었던 공간을 재활용할 수 있다.
			front++;
			front %= QUEUE_SIZE;
		 
		 
			int x = paper_queue[ptr].x - sz;
			int y = paper_queue[ptr].y - sz;
			//적당한 타일이 있을 경우
			if (x >= 0 && y >= 0){
			 //타일이 사용되고, 남은 세 부분을 다시 queue에 넣는다.
			 if (x) push(rear, x, sz);
			 if (y) push(rear, sz, y);
			 if (x && y) push(rear, x, y);
			 f = 1;
			 break;
			}
			//queue의 맨 뒤에 데이터를 옮기다.
			push(rear, paper_queue[ptr].x, paper_queue[ptr].y);
			ptr++;
			ptr %= QUEUE_SIZE;
		   }
		 
		 
		   //사용할 수 있는 적당한 크기의 타일이 없을 경우,
		   //새로운 타일을 사용한다.
		   if (!f){
			ans++;
			if (M - sz > 0){
			 push(rear, sz, M - sz);
			 push(rear, sz, M - sz);
			 push(rear, M - sz, M - sz);
			}
		   }
		  }
		  printf("#%d %d\n", tc, ans);
		 }
		 
		 
		 return 0;
		}
	}
}
