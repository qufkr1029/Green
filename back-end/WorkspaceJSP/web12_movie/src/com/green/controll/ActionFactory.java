package com.green.controll;

import com.green.controll.action.Action;
import com.green.controll.action.MovieDeleteAction;
import com.green.controll.action.MovieListAction;
import com.green.controll.action.MovieUpdateAction;
import com.green.controll.action.MovieUpdateFormAction;
import com.green.controll.action.MovieViewAction;
import com.green.controll.action.MovieWriteAction;
import com.green.controll.action.MovieWriteFormAction;

public class ActionFactory {
	private ActionFactory() {}
	private static ActionFactory af = new ActionFactory();
	public static ActionFactory getInstance() {
		return af;
	}
	
	
	
	
	// 커맨드 값에 따라 처리할 명령 기능을 가진 클래스를 반환하는 메서드
	public Action getAction(String command) {
		Action action = null;
		
		if(command.equals("movie_list")) {
			action = new MovieListAction();
		}
		else if(command.equals("movie_write_form")) {
			action = new MovieWriteFormAction();
		}
		else if(command.equals("movie_write")) {
			action = new MovieWriteAction();
		}
		else if(command.equals("movie_view")) {
			action = new MovieViewAction();
		}
		else if(command.equals("movie_update_form")) {
		action = new MovieUpdateFormAction();
		}
		else if(command.equals("movie_update")) {
			action = new MovieUpdateAction();
		}
		else if(command.equals("movie_delete_form")) {
			action = new MovieDeleteAction();
		}
//		else if(command.equals("")) {
//			action = new hhhhhh();
//		}
		
		
		return action;
	}
}
