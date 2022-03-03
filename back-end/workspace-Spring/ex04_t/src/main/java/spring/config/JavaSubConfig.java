package spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.dao.MemberDao;
import spring.printer.MemberInfoPrinter;
import spring.printer.MemberPrinter;

@Configuration
public class JavaSubConfig {

	@Autowired
	private MemberDao dao;   // 설정 파일을 하나로 합치는 경우 주입 대상만 Autowired로 전달해야 한다.

	@Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}
	
	@Bean
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		infoPrinter.setMemDao(dao);   // setter메서드를 통한 주입
		infoPrinter.setPrinter(memberPrinter());  
		return infoPrinter;
	}
	
}
