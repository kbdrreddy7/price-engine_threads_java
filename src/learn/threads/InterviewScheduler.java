package learn.threads;

import java.util.concurrent.BlockingQueue;

public class InterviewScheduler implements Runnable {

	
	private BlockingQueue<String> queue;
	
	
	
	
	public InterviewScheduler(BlockingQueue<String> queue) {
		super();
		this.setQueue(queue);
	}




	@Override
	public void run() {
		
		System.out.println(" 10 students are arrived ");
		for (int i = 0; i < 10; i++) {
			
			String msg="Candidate:"+i;
			try {
				queue.put(msg);
				System.out.println(" interview scheduled for "+msg);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
		System.out.println(" interview scheduled for all students ");
		
		String msg="STOP";
		try {
			queue.put(msg);
			
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
