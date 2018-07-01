import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution2 {

	public static void main(String[] args) {
		/*
		beginWord = "hit"
		endWord = "cog"
		wordList = ["hot","dot","dog","lot","log","cog"]
		*/
		//String beginWord= "hit";
		//String endWord = "cog";
		//String beginWord= "hot";
		//String endWord = "dog";
		//List<String> wordList = new ArrayList<String>();
		//wordList.add("hot");
		//wordList.add("dot");
		//wordList.add("dog");
		//wordList.add("lot");
		//wordList.add("log");
		//wordList.add("cog");
		
		String beginWord= "sm";
		String endWord = "mt";
		String[] input = {"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"};
		//String[] input = {"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po"};
		//String[] input = {"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr"};
		List<String> wordList = new ArrayList<String>(Arrays.asList(input));
		
		ladderLength(beginWord, endWord, wordList);

	}
	
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
    	int len = wordList.size();
    	System.out.println("wordList size : " + len);
    	int wordLen = beginWord.length();
    	if (len==0){
    		return 0;
    	}
    	
    	int[][] neighbor = new int [len+1][len+1];
    	List<List<Integer>> neigborList = new ArrayList<List<Integer>>(); 
    	int beginIndex = wordList.indexOf(beginWord);
    	System.out.println("beginWord index : " + beginIndex);
    	if (beginIndex == -1) {
			beginIndex = 0;
			wordList.add(0, beginWord);
    	} 
    	int endWordIndex = wordList.indexOf(endWord);
    	System.out.println("endWord index : " + endWordIndex);
    	if (endWordIndex == -1) {
    		return 0;
    	}
    	
    	// graph representation
    	int i = 0;
    	for (String item1 : wordList){
    		int j = 0;
    		List<Integer> nList = new ArrayList<Integer>();
    		for (String item2 : wordList){
    			char[] i1Array = item1.toCharArray();
    			char[] i2Array = item2.toCharArray();
    			int cnt = 0;
    			for (int k=0;k<wordLen;k++){
    				if (i1Array[k] != i2Array[k]){
    					cnt++;
    				}
    			}
				if (cnt == 1){
					neighbor[i][j] = 1;
					nList.add(j);
				}
    			j++;
    		}
			neigborList.add(nList);
			System.out.println("neighbor of i : " + i + " is " + neigborList.get(i));
    		i++;
    		
    	}
    	int iter = 0;
    	int[] visited = new int[len+1];

    	System.out.println(Arrays.deepToString(neighbor));

    	
    	int dist = Integer.MAX_VALUE;
    	int distance = Integer.MAX_VALUE;
    	List<Integer> result = new ArrayList<Integer>();
    	visited[0] = 1;
    	//ladderDFS(neigborList, len, endWordIndex, beginIndex, visited, 1, dist, result);
    	ladderBFS(neigborList, beginIndex, endWordIndex, wordList);
    	
    	/*
    	for (Integer item : result){
    		if (item < distance){
    			distance = item;
    		}
    	}
    	if (distance == Integer.MAX_VALUE){
    		distance = 0;
    	}
		System.out.println("visited: " + Arrays.toString(visited));
    	System.out.println("min distance is : " + distance);
    	return distance;
    	*/
        
    }
    
    public static int ladderBFS(List<List<Integer>> neigborList, int beginIndex, int endIndex, List<String> wordList  ){
    	//wordList
    	//neigborList
        //wordList.add(endWord);
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(beginIndex);
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Integer cur = queue.remove();
                if(cur == endIndex){ return level + 1;}
				for (Integer item : neigborList.get(cur)){
                            queue.add(item);
				}
				/*
                for(int j = 0; j < cur.length(); j++){
                    char[] word = cur.toCharArray();
                    for(char ch = 'a'; ch < 'z'; ch++){
                        word[j] = ch;
                        String check = new String(word);
                        if(!check.equals(cur) && wordList.contains(check)){
                            queue.add(check);
                            wordList.remove(check);
                        }
                    }
                }
                */
            }
            level++;
        }
        return 0;

    }
    public static void ladderDFS(List<List<Integer>> neigborList, int len, int endIdx, int index, int[] visited, int level, int dist, List<Integer> result){
    		if (index == endIdx ){
				int cnt=0;
				System.out.println("visited: " + Arrays.toString(visited));
				//System.out.println("level : " + level);
				for (int i=0;i<visited.length;i++){
					if(visited[i]==1){
						cnt++;
					}
				}
				result.add(cnt);
				return ;
    		}

    		int shortPath;
			for (Integer item : neigborList.get(index)){
				if (visited[item] !=1 ){
					visited[item] = 1;
					ladderDFS(neigborList, len, endIdx, item, visited, level+1, dist, result);
					visited[item] = 0;
				}
			}
    }

}
