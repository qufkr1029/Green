package spring.printer;

import java.util.Collection;

import spring.dao.MemberDao;
import spring.vo.Member;

public class MemberListPrinter {

	private MemberDao memberDao;
	private MemberPrinter printer;
	
	
	
	public MemberListPrinter(MemberDao memberDao, MemberPrinter printer) {
		// 생성자를 통한 두 객체 주입
		this.memberDao = memberDao;
		this.printer = printer;
	}



	public void printAll() {
		Collection<Member> members = memberDao.selectAll();
									//MemberDao 객체 필요
		for(Member m:members)
			printer.print(m);
			// MemberPinter 객체가 핋요
	}
}
