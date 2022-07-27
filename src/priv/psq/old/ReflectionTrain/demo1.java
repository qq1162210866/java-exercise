package priv.psq.old.ReflectionTrain;

/**
 * 反射小练习
 * 
 * @author yanyu
 *
 */
public class demo1 
{
	public static void main(String[] args)
	{
		try{
			//通过类的路径来获取Class
			/*
			 * 1 class.forName("类的路径")
			 * 2 类名.Class
			 * 3 实例.getClass
			 */			
 			Class a=Class.forName("ReflectionTrain.Sub");
 			/**
 			 * 1 newInstance: 弱类型。低效率。只能调用无参构造。
 			 * 2 new: 强类型。相对高效。能调用任何public构造。
 			 */
 			Base b=(Base)a.newInstance();
 			//为什么打印的是 Sub？
 			/*
 			 * 子类强转为父类，向上转换
 			 * 通过向上转换，我们能够在编写程序时采用通用程序设计的思想，
 			 * 在需要使用子类对象的时候，通过把变量定义为父类型，我们可以通过一个变量，使用该父类型的所有子类型实例
 			 * 子类可以转换为父类，即父类引用指向子类对象。引用的属性是父类的，方法若果被子类重写则是子类的方法。
 			 */
 			b.f();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
/**
 * 
 * @author yanyu
 *
 */
class Base
{
	public void f()
	{
		System.out.println("Base");
	}
}

/**
 * 
 * @author yanyu
 *
 */
class Sub extends Base
{
	public void f()
	{
		System.out.println("Sub");
	}
	
}
/**
 * 
 * @author yanyu
 * 测试类，测试子类与父类的关系
 */
class Sub2 extends Base
{
	public void f()
	{
		System.out.println("Sub2");
	}
	
}
