package action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;

public class SuperAction extends ActionSupport implements ServletContextAware, ServletRequestAware,ServletResponseAware{
	protected HttpServletRequest request;
	protected ServletContext context;
	protected HttpServletResponse response;
	protected HttpSession session;
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
		this.session=this.request.getSession();
	}

	public void setServletContext(ServletContext context) {
		this.context=context;
	}

	
	public void setServletResponse(HttpServletResponse response) {
		this.response=response;
	}

}
