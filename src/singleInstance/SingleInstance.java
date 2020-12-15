package singleInstance;

public class SingleInstance {

    // 第一步：使用私有的构造函数，单例模式常规写法，防止外部通过构造方法初始化，统一初始化入口。
    private SingleInstance() {
    }

    private volatile static SingleInstance singleInstance;

    private static SingleInstance getSingleInstance() {
        if (singleInstance == null) {
            synchronized (SingleInstance.class) {
                if (singleInstance == null) {
                    singleInstance = new SingleInstance();
                }
            }
        }
        return singleInstance;
    }
}
