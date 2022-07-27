package priv.psq.old.ThreadTrain;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的第三种方法，使用Callable和Future创建线程
 * @author yanyu
 *
 */
public class demo3 
{
	public static void main(String[] args)
	{
		//创建Callable对象  1
		demo3 rt=new demo3();
		//先使用Lambda表达式创建Callable<Integer>对象  1
		//使用Futuretask来包装Callable对象
		FutureTask<Integer> task=new FutureTask<Integer>((Callable<Integer>)()->{
			//这里的方法相当于call()方法    1 call()方法可以有返回值  2 call()方法也可以声明抛出异常 
			int i=0;
			for(;i<100;i++)
			{
				//通过currentThread()来获得当前线程
				System.out.println(Thread.currentThread().getName()+" "+i);
			}
			//返回值
			return i;
		});
		//主线程
		for(int i=0;i<100;i++)
		{
			System.out.println(Thread.currentThread().getName()+" "+i);
			if(i==20)
			{
				//实质还是Callable对象创建线程的，执行者还是Thread
				new Thread(task,"有返回值的线程").start();
			}
		}
		//也可以获取异常
		try
		{
			//获取子线程的返回值get()方法
			System.out.println("子线程的返回值为："+task.get());
		}catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
	}
}
