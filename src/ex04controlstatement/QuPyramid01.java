package ex04controlstatement;

public class QuPyramid01 {

    public static void main(String[] args) {

        /*
        for(int i=1 ; i<=5 ; i++) {
            for(int j=1 ; j<=i ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        */
        
        int i = 1;
        while(i<=5) {
            int j = 1;
            //i의 갯수만큼 j를 반복한다.
            while(j<=i) {
                System.out.print("*");
                j++;
            }
            System.out.println();
            i++;
        }
    }
}
