package learn.threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class InterviewService {

	public static void main(String[] args) {
		
		BlockingQueue<String>queue=new ArrayBlockingQueue<>(3);
		InterviewProcessor process=new InterviewProcessor(queue);
		InterviewScheduler scheduler=new InterviewScheduler(queue);
		
		new Thread(scheduler).start();
		new Thread(process).start();

		
		
	}
	
}
