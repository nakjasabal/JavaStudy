package ex04controlstatement;
/*
for문 
: while문과 같은 반복문으로 초기값, 조건식, 증감식이 한줄에
 있어 반복의 횟수를 명확히 알수있는 반복문이다. 
 따라서 반복의 횟수가 정해져있을때 주로 사용한다. 
 형식]
 	for(초기값 ; 조건식 ; 증감식){
 		실행문;
 	}
 */
public class E05For {

	public static void main(String[] args) {
				
		//변수i가 1부터 5까지 1씩 증가하므로 5번 반복된다.
		for(int i=1 ; i<=5 ; i++) {
			System.out.println("i="+ i);
		}
		
		/*
		시나리오] 1~100까지의 합을 구하는 프로그램을 for문을 
			이용하여 작성하시오. 
		 */
		//누적합 저장용 변수
		int sum = 0;
		//증가하는 j를 변수에 누적해서 더한다. 
		for(int j=1 ; j<=100 ; j++) { 
			sum += j;  
		}
		System.out.println("1~100까지의합:"+ sum); 

		/*
		시나리오] for문을 이용하여 1~10까지의 정수중 2의배수의 합을
			구하는 프로그램을 작성하시오.
		 */
		/*
		방법1 : 1~10까지 10번 반복해서 if문을 통해 2의 배수를
			찾은 후 누적해서 더한다. 
		 */
		int total = 0;		 
		for(int i=1 ; i<=10 ; i++) {
			if(i%2==0) { 
				total += i;
			}
		}
		System.out.println("1~10사이 2의배수의합(방법1):"+ total);
		
		/*
		방법2 : if문없이 초기값을 0부터 시작하여 2씩 증가시킨다. 
		 */
		total = 0;
		for(int i=0 ; i<=10 ; i+=2) {  
			total += i;
		}
		System.out.println("1~10사이 2의배수의합(방법2):"+ total);
		
		//for문으로 무한루프를 만들때는 (;;)와 같이 표현한다. 
		int a = 1;
		for(;;) {
			System.out.println("나는 for문으로 만든 무한루프입니다."+ a);
			a++;
			//1000이 되면 탈출하는 조건을 추가한다. 
			if(a==1000) break;
		}

		/*
		for문의 끝에 ;을 사용하면 반복할 문장이 없는것으로 
		간주되어 for문과 상관없이 한번만 실행된다. 
		 */
		for(int j=0 ; j<=5 ; j++); 
		{ 
			System.out.println("어랏...나는 누구? 여긴 어디?");
		}
		/*
		for문의 초기식에서 선언된 변수 j는 for문이 종료되는 순간
		메모리에서 소멸된다. 여기서 사용된 변수 j는 지역변수(Local
		variable)라고 한다. 지역변수는 해당 지역을 벗어나면 즉시
		소멸되는 특징을 가지고있다. 
		 */
		//j는 for문이 종료될때 소멸되므로 아래문장은 에러발생
		//System.out.println("위 for문에서 선언한 변수 j="+ j);
		System.out.println("위 main함수 지역에서 선언한 변수 "
				+ "total="+ total);
		
		/*
		for문의 초기값을 외부(넓은지역, 여기서는 main지역)에서
		선언하면 해당변수는 for문의 안쪽(좁은지역)에서 사용할 수 있다.
		즉 아래에 선언한 변수 i는 main메서드의 지역변수로 선언된다. 
		 */
		int i=0;
		for( ; i<=5 ; i++) {			
			System.out.println("for문 안에서의 i값="+ i);
		}
		System.out.println("for문 밖에서의 i값="+ i);
		/* Java에서는 중괄호가 나오면 하나의 지역이라 생각하면
		된다. 즉 if문, while문 등의 제어문도 지역을 가지게
		된다. */
		
		
		/*
		연습문제1] 구구단을 출력하는 프로그램을 for문으로 
		작성하시오.
		 */
		System.out.println("구구단 출력하기");
		//단은 2~9까지 증가
		for(int dan=2 ; dan<=9 ; dan++) {
			//수는 1~9까지 증가
			for(int su=1 ; su<=9 ; su++) {
				System.out.printf("%d*%d=%2d ", 
						dan, su, (dan*su));
			}
			//하나의 단을 출력한 후 줄바꿈 처리
			System.out.println();
		}
				
		/*
		연습문제2] 다음의 출력결과를 보이는 for문을 작성하시오
		출력결과
			0 0 0 1
			0 0 1 0
			0 1 0 0
			1 0 0 0
		해법 : x와 y를 더해서 5가 될때 1을 출력한다.
		 */
		System.out.println("0과 1패턴 출력하기");
		for(int x=1 ; x<=4 ; x++) {
			for(int y=1 ; y<=4 ; y++) {
				if(x+y==5)
					System.out.print("1 ");
				else
					System.out.print("0 ");
			}
			System.out.println();
		}
	}
}
