package hello.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
//이렇게 애노테이션으로 설정만 해주면 롬복이 자동으로 getter와 setter를 생성해준다
//이외에도 생성자나 여러가지 기능을 제공해준다.
public class whatIsLombok {
    private String name;
    private int age;

    public static void main(String[] args) {
        whatIsLombok temp=new whatIsLombok();

        temp.setName("코알라");
        temp.setAge(23);
        System.out.println(temp.getName());
        System.out.println(temp.getAge());
        System.out.println("temp = " + temp);
    }
}
