/**
 * 面试题2：实现Singleton模式
 *
    单例模式三句口诀：
    1.构造器私有化；
    2.类的内部构建静态对象；
    3.向外暴露一个静态的公共方法。

    单例模式推荐的三种方式：
    1.饿汉式（静态常量、或者静态代码块，虽然可能会造成内存浪费，但针对频繁使用的对象，还是可以用该种模式的）
    2.双重检查（延迟加载、线程安全）
    3.静态内部类（延迟加载、线程安全）
 */
public class Singleton {
    /**
     * 饿汉式，线程安全，但可能会存在内存浪费的问题
     * 静态代码块形式和饿汉式的创建方式是一样的，都是在类加载的时候就创建对象
     静态代码块：
     private static Singleton singleton;
     static{
        singleton = new Singleton();
     }
     */
    private Singleton(){

    }
    private static Singleton singleton =  new Singleton();

    public static Singleton getInstance() {
        return singleton;
    }

    /**
     * 双重检查，线程安全
     * 静态变量上需要用volatile关键词修饰（保证可见性，同时防止指令重排序）
     */
    public static Singleton getInstance_doubleCheck() {
        if(singleton == null) {
            synchronized(Singleton.class){
                if(singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    /**
     * 静态内部类
     1.静态内部类用private修饰
     2.内部类内部只有一个私有的、静态的、不可变的成员变量
     */
     private static class SingletonInner {
        private static final Singleton singleton = new Singleton();

    }

    public static Singleton getInstance_staticInnerClass() {
        return SingletonInner.singleton;
    }
}
