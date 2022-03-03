package spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.printer.MemberInfoPrinter;
import spring.printer.MemberPrinter;

@Configuration
public class ConfigPart02 {
	
	@Autowired
	private ConfigPart01 configPart01;

	@Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}
	
	@Bean
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		infoPrinter.setMemDao(configPart01.memberDao());   // setter메서드를 통한 주입
	infoPrinter.setPrinter(memberPrinter());  
		return infoPrinter;
	}
}
