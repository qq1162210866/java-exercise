package priv.psq.old.ThreadTrain;
/*
 * 创建线程的第二种方法
 * 实现Runnable接口创建线程
 */
public class demo2 implements Runnable 
{
	private int i;//初始值为0
	//线程执行体
	@Override
	public void run() 
	{
		for(;i<100;i++)
		{
			//当实现Runnable接口时，只能使用Thread.currentThread().getName()获得当前线程
			System.out.println(Thread.currentThread().getName()+" "+i);
		}
	}
	public static void main(String[] args)
	{
		for(int i=0;i<100;i++)
		{
			System.out.println(Thread.currentThread().getName()+" "+i);
			if(i==20)
			{
				demo2 dt=new demo2();
				/*
				 * 最终的执行者还是Thread
				 * 发现新线程1和新线程2的i值是连续的，因为Thread共享了同一个target(就是Runnable对象)
				 */
				//通过new Thread(target,name)来创建新线程
				new Thread(dt,"新线程1").start();
				new Thread(dt,"新线程2").start();
			}
		}
	}
}
