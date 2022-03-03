package spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import spring.dao.MemberDao;
import spring.service.MemberRegisterService;

@Configuration
@Import(ConfigPartSub.class)
//@Import({ConfigPartSub.class,ConfigPartThired.class,ConfigPart4Th.class,.....})   합쳐야 할 대상 클래스가 여러개라면!!
public class ConfigPartMain {

	@Bean  // 스프링 컨테이너가 관리하는 빈 객체입니다.
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao()); // 생성자를 통한 주입
	}
}
