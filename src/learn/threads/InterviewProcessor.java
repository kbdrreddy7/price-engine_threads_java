package learn.threads;

import java.util.concurrent.BlockingQueue;

public class InterviewProcessor implements Runnable {

	private BlockingQueue<String> queue;

	
	
	
	public InterviewProcessor(BlockingQueue<String> queue) {
		super();
		this.queue = queue;
	}

	
	@Override
	public void run() {
		
		String msg;
		try {
			Thread.sleep(1000);
			while (!(msg=queue.take()).equals("STOP")) {
				System.out.println(" interview complted for "+msg);
				Thread.sleep(1000);
			}
			System.out.println(" interview is completd for all students");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	

	public BlockingQueue<String> getQueue() {
		return queue;
	}

	public void setQueue(BlockingQueue<String> queue) {
		this.queue = queue;
	}


	
}
