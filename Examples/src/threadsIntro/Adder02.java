package threadsIntro;

public class Adder02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread a = new Thread(new Worker('a'));
		Thread b = new Thread(new Worker('b'));
		Thread c = new Thread(new Worker('c'));
		a.start();
		b.start();
		c.start();
		System.out.print("Hey... where is this?");
	}

}//end of class adder

class Worker implements Runnable{
	private char id;
	
	public Worker(char id){
		this.id = id;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 110; i++)
			System.out.println(""+ id + i);
	}
}
