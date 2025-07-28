package hello.core.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonService {

    public static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService(){
       //싱글톤 패턴인데 외부에서 해당 인스턴스를 계속 생성하는 것을 방지하기 위해
    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }


}
