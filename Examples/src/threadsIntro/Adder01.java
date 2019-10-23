// 09/26/19
package threadsIntro;

public class Adder01 {

	public static void main(String[] args) throws InterruptedException {
		MyInt extremeTotal = new MyInt(0);
		Thread one = new Thread(new WorkerBee(0,100, extremeTotal));
		Thread two = new Thread(new WorkerBee(100,200, extremeTotal));
		Thread three = new Thread(new WorkerBee(200,300, extremeTotal));
		one.start();
		two.start();
		three.start();
		one.join();
		two.join();
		three.join();
		System.out.println("end of program total is " + extremeTotal.getNum());
		
	}
}

class WorkerBee implements Runnable{
	
	private int start;
	private int end;
	private int total;
	private MyInt officialTotal;
	
	public WorkerBee(int start, int end, MyInt tots){
		this.start = start;
		this.end = end;
		total = 0;
		officialTotal = tots;
	}

	@Override
	public void run() {
		for(int i = start; i < end; i++) {
			total = total + i;
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("the total was: " + total);
		officialTotal.setNum(officialTotal.getNum() + total);
		System.out.println("in thread" + officialTotal);
	}
}

class MyInt{
	private int num;
	public MyInt(int num){
		this.num = num;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
}

