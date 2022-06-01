package ThreadDemo;

/**
 * 经典生产者与消费者问题：生产者不断的往仓库中存放产品，消费者从仓库中消费产品。
 * 其中生产者和消费者都可以有若干个。仓库容量有限，库满时不能存放，库空时不能取产品
 */

public class ProducerConsumer {
	public static void main(String args[]) {
		SyncStack ss = new SyncStack();
		CandyProducer p = new CandyProducer(ss);
		CandyConsumer c = new CandyConsumer(ss);

		new Thread(p).start();
		new Thread(c).start();
	}
}

class SyncStack {
	int index = 0;
	Candy[] arrCandy = new Candy[6];

	public synchronized void push(Candy candy) {
		while (index == arrCandy.length) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.notify();
		arrCandy[index++] = candy;
	}

	public synchronized Candy pop() {
		while (index == 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.notify();
		return arrCandy[--index];
	}
}

class CandyProducer implements Runnable {
	SyncStack ss = null;

	CandyProducer(SyncStack ss) {
		this.ss = ss;
	}

	public void run() {
		for (int i = 0; i < 20; i++) {
			Candy candy = new Candy(i);
			ss.push(candy);
			System.out.println("生产了： " + candy);
			try {
				Thread.sleep((int) (Math.random() * 100));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class CandyConsumer implements Runnable {
	SyncStack ss = null;

	CandyConsumer(SyncStack ss) {
		this.ss = ss;
	}

	public void run() {
		for (int i = 0; i < 20; i++) {
			Candy candy = ss.pop();
			System.out.println("======消费了：" + candy);
			try {
				Thread.sleep((int) (Math.random() * 1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Candy {
	int id;

	Candy(int id) {
		this.id = id;
	}

	public String toString() {
		return "Candy :  " + id;
	}
}