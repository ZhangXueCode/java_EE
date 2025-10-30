import javax.swing.*;

//单例模型
class MySingleton {
    //饿汉模式
    public static MySingleton instance = new MySingleton();
    public static MySingleton getInstance() {
        return instance;
    }
    private  MySingleton() {

    }
}
class MySingletonLazy {
    //懒汉模式
    public volatile static MySingletonLazy instance = null;
    public static MySingletonLazy getInstance() {
        if(instance == null) {
            synchronized (MySingletonLazy.class) {
                if(instance == null) {
                    instance = new MySingletonLazy();
                }
            }
        }
        return instance;
    }
    private MySingletonLazy() {

    }

}
public class demo5 {

}
