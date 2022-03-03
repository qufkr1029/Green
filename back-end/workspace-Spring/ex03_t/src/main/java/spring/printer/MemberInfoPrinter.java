package spring.printer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import spring.dao.MemberDao;
import spring.vo.Member;

public class MemberInfoPrinter {
	
	@Autowired(required=false)   // 빈 객체가 없는 경우  기본 객체를 전달해서 에러를 최소화
	private MemberDao memDao;
	private MemberPrinter printer;
	
//	@Autowired
//	public void setMemDao(MemberDao memDao) {
//		this.memDao = memDao;
//	}
	//Setter메서드를 통해서 주 객체를 주입받는다.
	@Autowired
	//@Qualifier("chk02")
	public void setPrinter(MemberPrinter printer) {
		this.printer = printer;
	}
	
	
	public void printMemberInfo(String email) {
		Member member = memDao.selectByEmail(email);
	
		if(member == null) {
			System.out.println("데이터없음!");
			return;
		}
		
		printer.print(member);
		System.out.println();
			
	}

	
}
