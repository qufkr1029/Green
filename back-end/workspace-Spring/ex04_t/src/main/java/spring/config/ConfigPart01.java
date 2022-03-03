package spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.dao.MemberDao;
import spring.service.MemberRegisterService;

@Configuration
public class ConfigPart01 {

	@Bean  // 스프링 컨테이너가 관리하는 빈 객체입니다.
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao()); // 생성자를 통한 주입
	}
}
