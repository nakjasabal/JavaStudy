package ex12overidding.noco;

class Speaker {
	private int volumnRate;
	public void setVolumn(int vol) {
		volumnRate = vol;
	}
	public void showState() {
		System.out.println("스피커의 볼륨크기:"+ volumnRate);
	}
}
class BaseSpeaker extends Speaker {
	private int baseRate;
	public void setBase(int bas) {
		baseRate = bas;
	}
	@Override
	public void showState() {
		super.showState();
		System.out.println("베이스의 볼륨크기:"+baseRate);
	}
}

public class E01Overriding {
	
	public static void main(String[] args) {
		
		BaseSpeaker baseSpeaker = new BaseSpeaker();
		baseSpeaker.setVolumn(10); 
		baseSpeaker.setBase(20);
		baseSpeaker.showState(); 

		System.out.println();
		
		Speaker speaker = new BaseSpeaker();
		speaker.setVolumn(30);
		//speaker.setBase(40);//[에러발생]
		speaker.showState();
	}
}


