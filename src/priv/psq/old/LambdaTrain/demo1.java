package priv.psq.old.LambdaTrain;

public class demo1 
{
	/*
	 * 测试使用的代码，分别要传入各自的参数
	 */
	public void eat(Eatable e)
	{
		System.out.println(e);
		e.taste();
	}
	public void drive(Flyable f)
	{
		System.out.println("我正在驾驶："+f);
		f.fly("【碧空如洗的日子】");
	}
	public void test(Addable add)
	{
		System.out.println("5与3的和为："+add.add(5, 3));
	}
	/*
	 * 主方法，其中的方法参数都是使用lambda表达式
	 */
	public static void main(String[] args)
	{
		demo1 demo1=new demo1();
		//lambda表达式的代码只只有一句，可以省略“{}”
		//这里的lambda表达式实际上被当成任意的类型，具体的类型取决于运行环境的需要
		demo1.eat(()->System.out.println("苹果的味道不错"));
		//方法的形参只有一个，可以省略“()”  weather是接口方法的形参
		demo1.drive(weather->{
			System.out.println("今天的天气是："+weather);
			System.out.println("直升机飞行平稳");
		});
		//代码只有一句，可以省略“{}”,同时也可以省略return关键字 a+b是返回值
		demo1.test(Integer::sum);
		
	}

}
/*
 * 测试使用的接口,只有一个抽象方法的接口（函数式接口）
 */
@FunctionalInterface
interface Eatable
{
	void taste();
}
@FunctionalInterface
interface Flyable
{
	void fly(String weather);
}
@FunctionalInterface
interface Addable
{
	int add(int a,int b);
}
