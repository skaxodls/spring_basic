package hello.core.web;

import hello.core.common.MyLogger;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class LogDemonController{
    private final LogDemoService logDemoService;
    private final MyLogger myLogger;

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request){
        String requestURL=request.getRequestURL().toString();
        myLogger.setRequestURL(requestURL);
        myLogger.log("controller test");
        logDemoService.logic("testId");
        return "OK";
    }
}

/*
이 예제는 웹 스코프 중 request scope를 사용하는 예제입니다.
request는 HTTP 요청이 들어오고 처리될 때까지 유지되는 생명 주기를 가집니다.
이 스코프의 빈은 의존성 주입 시점에는 생성할 수 없기 때문에,
Spring은 프록시 객체를 주입해서 지연 처리(Lazy Lookup)를 사용합니다.

HTTP 요청이 들어오면 Spring은 RequestContext를 생성하고,
프록시 객체는 현재 요청의 컨텍스트(RequestContextHolder)를 통해
해당 요청에 맞는 실제 인스턴스를 찾아서 동작을 위임합니다.

그 결과, 같은 요청 안에서는 컨트롤러와 서비스가 동일한 인스턴스를 공유하며,
요청이 다르면 서로 다른 인스턴스를 사용하게 됩니다.


용어 정리

서블릿
Servlet은 자바로 만든 웹 요청 처리용 클래스입니다.
클라이언트의 HTTP 요청을 받아서,
처리하고 HTTP 응답을 생성하는 역할을 합니다.

톰캣
자바로 만든 웹 애플리케이션을 실행할 수 있게 도와주는 프로그램이에요.
*/