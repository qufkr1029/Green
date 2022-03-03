package spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import spring.dao.MemberDao;
import spring.service.MemberRegisterService;

@Configuration
@ImportResource("classpath:sub-config.xml")
public class JavaMainConfig {  // sub-config.xml  : xml을 자바코드로 가져와서 합치기

	@Bean  // 스프링 컨테이너가 관리하는 빈 객체입니다.
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao()); // 생성자를 통한 주입
	}
}
