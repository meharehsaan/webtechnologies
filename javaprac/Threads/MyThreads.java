class NewThread implements Runnable {
	public void run() {
		try {
			for (int i = 1; i <= 5; i++) {
				System.out.println("Child Thread: " + i);
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			System.out.println("Child thread interrupted " + e.getMessage());
		}
		System.out.println("Child Exiting");
	}
}

class MyThreads {
	public static void main(String[] args) {
		NewThread ct = new NewThread();

		Thread t1 = new Thread(ct);
		t1.start();

		try {
			for (int i = 1; i <= 5; i++) {
				System.out.println("Main Thread: " + i);
				Thread.sleep(1000);
			}
		}

		catch (InterruptedException e) {
			System.out.println("Main thread interrupted " + e.getMessage());
		}
		System.out.println("Main Exiting");
	}

}
