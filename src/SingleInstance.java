// 懒汉式和饿汉式
// 单例模式中线程安全的懒汉式单例模式
public class SingleInstance {
    private volatile static SingleInstance singleInstance;
    // 构造函数私有化
    // 第一步：使用私有的构造函数，单例模式常规写法，防止外部通过构造方法初始化，统一初始化入口。
    private SingleInstance(){
    }
    private static SingleInstance getSingleInstance(){
        /*
        第二步：同步代码块外加判空条件，这个判空是为了程序效率，去掉后导致效率变低。因为去掉之后，
        不管instance是否已经初始化，都会进行synchronized操作，而synchronized是一个重操作消耗性能。
        加上之后，如果已经初始化直接返回结果，不会进行synchronized操作。
        * */
        if(singleInstance==null){
            // 第三步：初始化实例代码加上synchronized是为了防止多个线程同时调用getInstance方法时，
            // 各初始化instance一遍的并发问题。
            synchronized (SingleInstance.class){
                /*第四步：同步代码块里加判空条件，为了防止多线程情况下多次初始化实例，
                假设两个线程a和b都通过了第一个判空条件。
                此时假设a先获得锁，进入synchronized的代码块，初始化instance，a释放锁。
                接着b获得锁，进入synchronized的代码块，也直接初始化instance，导致初始化了两次，
                加上判空就可以防止这种情况发生*/
                if(singleInstance==null){
                    singleInstance = new SingleInstance();
                }
            }
        }
        return singleInstance;
    }
}


//public class SingleInstance{
//    private static volatile SingleInstance singleInstance;
//    private SingleInstance(){}
//    private static SingleInstance getSingleInstance(){
//        if(singleInstance==null){
//            synchronized (SingleInstance.class){
//                if(singleInstance==null){
//                    singleInstance = new SingleInstance();
//                }
//            }
//        }
//        return singleInstance;
//    }
//}
