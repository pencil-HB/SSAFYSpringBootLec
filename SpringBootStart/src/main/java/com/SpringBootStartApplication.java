package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/*@SpringBootApplication: 메인 클래스, 부트스트랩 클래스, 시작 클래스라고 부름
 * 실행시키면 내장 서버(톰캣)이 실행된다.
 * 아래 어노테이션들을 내장한다. (다른 어노테이션들도 있다)
 * 
 * @SpringBootConfiguration : 이 클래스가 application의 설정 정보를 가지고 있는 클래스임을 표시
 * @EnableAutoConfiguration : boot 의 자동 설정 기능을 활성화시킨다.
 * 사용자가 필요로 할 것 같은 빈을 예상해서 미리 생성해줌.
 * @ComponentScan : 전체 패키지(com) 부터 시작해서 하위 패키지를 스캔해 필요한 객체들을 생성하고 주입시켜 줌.
 
 * Boot에서는 빈을 생성, 등록하는 두 가지 방법이 있다.
 * 1. ComponentScan
 * 2. EnableAutoConfiguration
 * */

@SpringBootApplication
public class SpringBootStartApplication {

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(SpringBootStartApplication.class, args);
		
		String names[] = context.getBeanDefinitionNames();
		for(String s : names) {
			System.out.println(s);
		}
		
	}

}
