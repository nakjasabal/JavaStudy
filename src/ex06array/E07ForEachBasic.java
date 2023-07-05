package ex06array;

/*
foreach문(개선된 for문)
: 배열의 일부가 아니라 전체를 참조해야할때 주로 사용하는 for문을 
말한다. 배열의 원소를 참조의 형태로 가져와서 사용한다. 
따라서 참조의 목적으로만 사용해야하고, 값의 변경은 허용하지 않는다.
형식]
	for(자료형 참조변수 : 배열명){
		실행문장;
		참조변수를 통해 배열의 원소 출력가능;
	}
 */
public class E07ForEachBasic {

	public static void main(String[] args) {
		 
		//1차원 배열을 선언 및 초기화한다. 
		int[] arr = {1, 2, 3, 4, 5};
		int sum = 0;
		//일반for문을 통해 index로 접근하여 각 원소의 합을 구한다.
		for(int i=0 ; i<arr.length ; i++) {
			sum += arr[i];
		}
		System.out.println("기본for문을 이용한 합계:"+sum);
		
		/* 배열 arr의 원소를 순서대로 하나씩 참조하여 출력하고, 
		더이상 참조할 원소가 없을때 for문이 자동으로 종료된다. */
		sum = 0;		
		for(int e : arr) {
			//배열의 원소들이 순서대로 출력된다. 
			System.out.print(e+" ");
			sum += e;
		}
		System.out.println("\nforeach문을 이용한 합계:"+sum);
		
		/* 참조형태로 각 원소를 읽어와서 변수 b에 할당하는 형식이
		므로 아래 증가연산자를 통해 증가시킨 값은 실제 배열에 
		적용되지 않는다. 해당 for문 내에서만 증가된 값이 출력된다.
		 */
		System.out.println("배열arr의 요소값 1 증가시키기");
		for(int b : arr) {
			//배열의 각 원소를 꺼내서 b에 잠깐 저장한다. 
			b++;
			//1 증가된 값이 출력된다. 
			System.out.print(b +" ");
			//하지만 원 배열에 적용되지는 않는다. 
		}
		System.out.println();
		System.out.println("배열arr의 요소 재출력하기");
		/* 1증가되는 부분이 기존 배열에 적용되지 않으므로 기존값이
		출력된다. */
		for(int c : arr) {
			System.out.print(c +" ");  
		}
		System.out.println();
		
		
		System.out.println("2차원 배열을 foreach문으로 출력하기");
		int[][] twoDim = {
				{1,2,3,4},
				{10,20,30,40},
				{100,200,300,400}
		};
		//2차원 배열에서 하나의 행씩 접근한다. 
		for(int[] a : twoDim) { 
			//각 행의 원소들을 순서대로 접근하여 출력한다. 
			for(int b : a) { 
				System.out.print(b +" ");
			}
			System.out.println();
		}		
	}
}
