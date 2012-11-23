package org.basejava.base;
/**
 * 经典例子  多态 
 * @author jim.liu
 *
 */
public class TestABCD {

	/**
	 * blog.csdn.net/thinkghoster/article/details/2307001
	 * 运行时多态性是面向对象程序设计代码重用的一个最强大机制，
	 * 动态性的概念也可以被说成“一个接口，多个方法”。Java实现运行时多态性的基础是动态方法调度，
	 * 它是一种在运行时而不是在编译期调用重载方法的机制。
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a1 = new A();
        A a2 = new B();//向上转型只能拿到子类中覆盖到
        B b = new B();
        C c = new C(); 
       // A a3 = new C();
        D d = new D(); 
        System.out.println(a1.show(b));   //ok
        System.out.println(a1.show(c));   //ok
        System.out.println(a1.show(d));   //ok
        System.out.println(a2.show(b));   
        System.out.println(a2.show(c));   //ok
        System.out.println(a2.show(d));  //ok 
        System.out.println(b.show(b));     
        System.out.println(b.show(c));     
        System.out.println(b.show(d));     
	}

}
