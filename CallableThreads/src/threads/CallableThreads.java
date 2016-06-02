package threads;

import java.util.*;
import java.util.concurrent.*;

public class CallableThreads {

	public static void main(String[] args) throws InterruptedException, ExecutionException{
		// TODO Auto-generated method stub
			Callable<Integer> mn= () -> {
				for( int  i=0;i<10;i++)
				{
					Thread.sleep(1000);
					System.out.println("value of i is "+ i);
				}
				return  2000;
			};
			
			Callable<Integer> sb = ()->{
				for( int j=0;j<10;j++)
				{
					Thread.sleep(700);
					System.out.println("Value of J is "+ j);
				}
				return 5000;
			};
			
			List<Future<Integer>> f = new ArrayList<Future<Integer>>();
			List<Integer> l = new ArrayList<>();
			final ExecutorService s = Executors.newFixedThreadPool(2);
			
			try{
				f.add(s.submit(mn));
				f.add(s.submit(sb));
				
				for(Future<Integer> future : f)
				{
					l.add(future.get());
				}
			}finally{
				s.shutdown();
			}
			
			for(Integer i: l)
			{
				System.out.println("The result is "+i);
			}
			}
	}


