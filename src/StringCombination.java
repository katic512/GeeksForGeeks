import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Katic
 *
 * @source: 
 */

public class StringCombination {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.next();
		//A-Z => 65 - 90 && a - z => 97 - 122 to make it easier converting it into caps
		input = input.toUpperCase();
		int[] l = new int[26];
		Set<String> out = new HashSet<String>();
		char[] inn = input.toCharArray();
		for(int i=0;i<inn.length;i++){
			int c = inn[i];
			l[c-65]++;
		}
		createCombination(out,l,0,"");
	}

	private static void createCombination(Set<String> out, int[] l, int startIndex, String currString) {
		
		if(out.add(currString))
		System.out.println("string :: "+currString);
		if(startIndex>l.length-1)return;
		for(int i=startIndex;i<l.length;i++){
			if(l[i]!=0){
				l[i]--;
				createCombination(out, l, i, currString + (char)(i+65));
				l[i]++;
			}
			
		}
	}
	

}
