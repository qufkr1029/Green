package com.green.controller;

import com.green.controller.action.Action;
import com.green.controller.action.BoardCheckPassAction;
import com.green.controller.action.BoardCheckPassFormAction;
import com.green.controller.action.BoardDeleteAction;
import com.green.controller.action.BoardListAction;
import com.green.controller.action.BoardUpdateAction;
import com.green.controller.action.BoardUpdateFormAction;
import com.green.controller.action.BoardViewAction;
import com.green.controller.action.BoardWriteAction;
import com.green.controller.action.BoardWriteFormAction;

public class ActionFactory {
	//싱글턴 패턴
	private ActionFactory() {}
	private static ActionFactory af = new ActionFactory();
	public static ActionFactory getInstance() {
		return af;
	}
	
	//////////////////////////////////////////////////////////////////////
	// 커맨드 값에 따라서 처리할 명령기능을 가진 클래스를  반환하는 메서드
	
	public Action getAction(String command){
		Action action = null;
		
		if(command.equals("board_list")) {
			action = new BoardListAction(); //게시물 전체 보기(목록 보기)
		}else if(command.equals("board_write_form")) {
			action = new BoardWriteFormAction(); //게시물 등록 폼 이동
		}else if(command.equals("board_write")) {
			action = new BoardWriteAction();	// 등록된 게시물을 DB에 저장하는 기능
		}else if(command.equals("board_view")) {
			action = new BoardViewAction();	// 선택된 게시물 상세 보기 기능
		}else if(command.equals("board_check_pass_form")) {
			action = new BoardCheckPassFormAction();		// 암호 확인 폼으로 이동
		}else if(command.equals("board_check_pass")) {
			action = new BoardCheckPassAction();		// 암호 확인 기능을 담당
		}else if(command.equals("board_delete")) {
			action = new BoardDeleteAction();		// 삭제 기능
		}else if(command.equals("board_update_form")) {
			action = new BoardUpdateFormAction();		// 수정 폼으로 이동
		}else if(command.equals("board_update")) {
			action = new BoardUpdateAction();		// 수정 기능 
		}
		
		return action;
	}
	
}
