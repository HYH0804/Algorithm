

public class Main  {
	
	public static void main(String[] args) {
		String[] words = {"write","program","that","receive","positive"};
		
		String anotherGame;
		
		
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		
		do { 
			java.util.Random rand = new java.util.Random();
	        int random = rand.nextInt(5);
			char[] strToArray = words[random].toCharArray(); //문자열 배열로 바꾸고
			int count = strToArray.length; //str의 글자 개수
			char[] current_guess = new char[count]; //현재까지 맞춘 
			for (int z = 0; z< count; z++) {
				current_guess[z]= '*';
			}
			int remain = count; //남은 알파벳
			int try_count =0; // 시도횟수
			while (remain != 0) { //글씨 다 맞출때까지...
				System.out.println("(Guess) Enter a letter in word "+String.valueOf(current_guess)+"> ");
				char guess = input.next().charAt(0);
				int remain_before = remain; 
				for (int i = 0 ; i<words[random].length(); i++) { // 입력값을 배열 인덱스 0 부터 순회하며 같은 것 있는지 확인
					
					if(words[random].charAt(i)==guess) { //i에서 맞음
						current_guess[i] = guess;
						remain--; //남은 알파벳 감소
					}
					else
						continue; //순회하면서 각 index에서 같지 않으면 다시 continue
					
				}
				if (remain_before == remain) {
					try_count++;
					System.out.printf("%c is not in the word\n", guess); 
				}
			}
			System.out.printf("The word is %s. You missed %d times\n", words[random] , try_count );
			System.out.printf("Do you want to guess for another word? Enter y or n  ");
			
		} while (input.nextLine()=="y"); //다른 str로 행맨 할때까지
	}
}
	/*
int check_guess(String str , char guess , int remain , char[] current_guess) {
for (int i = 0 ; i<str.length(); i++) { // 입력값을 배열 인덱스 0 부터 순회하며 같은 것 있는지 확인
	
	if(str.charAt(i)==guess) { //i에서 맞음
		current_guess[i] = guess;
		remain--; //남은 알파벳 감소
	}
	else
		continue; //순회하면서 각 index에서 같지 않으면 다y시 continue
	
	}
}
	*/