package action;

import javax.annotation.Resource;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;

import entity.User;
import service.UserService;
@Controller
public class UserAction extends SuperAction {
	private UserService userService;
	@Autowired
	public void setUserService(UserService userService){
		this.userService=userService;
	}
		public String login(){
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			User user=new User(username, password);
			if(userService.login(user)){
				return "login_success";
			}else{
				return "login_fail";
			}
		}
		public String register(){
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			if(userService.reg(username, password)){
				return "reg_success";
			}else{
				return "reg_fail";
			}
		}
}
