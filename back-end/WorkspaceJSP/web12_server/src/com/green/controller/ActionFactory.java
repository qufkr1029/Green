package com.green.controller;

import com.green.controller.action.Action;
import com.green.controller.action.CourseDeleteAction;
import com.green.controller.action.CourseUpdateAction;
import com.green.controller.action.CourseUpdateFormAction;
import com.green.controller.action.CourseViewAction;
import com.green.controller.action.CourseWriteAction;
import com.green.controller.action.CourseWriteFormAction;
import com.green.controller.action.JoinListAction;
import com.green.controller.action.LecturerListAction;
import com.green.controller.action.LecturerUpdateAction;
import com.green.controller.action.LecturerUpdateFormAction;
import com.green.controller.action.LecturerWriteAction;
import com.green.controller.action.LecturerWriteFromAction;

public class ActionFactory {
	private ActionFactory() {}
	private static ActionFactory af = new ActionFactory();
	public static ActionFactory getInstance() {
		return af;
	}
	
	
	
	
	// 커맨드 값에 따라 처리할 명령 기능을 가진 클래스를 반환하는 메서드
	public Action getAction(String command) {
		Action action = null;
		
		if(command.equals("join_list")) {    // 조인된 교과목 리스트를 보려 할 때
			action = new JoinListAction();
		}
		else if(command.equals("course_write_form")) {
			action = new CourseWriteFormAction();
		}
		else if(command.equals("course_write")) {
			action = new CourseWriteAction();
		}
		else if(command.equals("course_view")) {
			action = new CourseViewAction();
		}
		else if(command.equals("course_update_form")) {
		action = new CourseUpdateFormAction();
		}
		else if(command.equals("course_update")) {
			action = new CourseUpdateAction();
		}
		else if(command.equals("course_delete")) {
			action = new CourseDeleteAction();
		}
		else if(command.equals("lecturer_list")) {
			action = new LecturerListAction();
		}
		else if(command.equals("lecturer_write_form")) {
			action = new LecturerWriteFromAction();
		}
		else if(command.equals("lecturer_write")) {
			action = new LecturerWriteAction();
		}
		else if(command.equals("lecturer_update_form")) {
			action = new LecturerUpdateFormAction();
		}
		else if(command.equals("lecturer_update")) {
			action = new LecturerUpdateAction();
		}
		
		
		return action;
	}
}
