package spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.dao.MemberDao;
import spring.printer.MemberInfoPrinter;
import spring.printer.MemberPrinter;
import spring.service.MemberRegisterService;

@Configuration  //스프링 설정 파일이다.
public class JavaConfig01 {  

	// 빈(Bean) 객체를 생성해 봅시다.
//	<bean class="spring.dao.MemberDao" id="memberDao"></bean>
	@Bean  // 스프링 컨테이너가 관리하는 빈 객체입니다.
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao()); // 생성자를 통한 주입
	}
	
	@Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}
	
	@Bean
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		infoPrinter.setMemDao(memberDao());   // setter메서드를 통한 주입
//		infoPrinter.setPrinter(memberPrinter());   Autowired를 통한 자동 주입 진행
		return infoPrinter;
	}
}







