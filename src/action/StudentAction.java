 package action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import entity.Student;
import service.StudentService;
@Controller
public class StudentAction extends SuperAction {
	
	private StudentService studentService;
	@Autowired
	public void setStudentService(StudentService studentService){
		this.studentService=studentService;
	}
	
	public String queryAll(){
		List<Student> list=studentService.query();
		if(list.size()>0&&list!=null){
		session.setAttribute("studentList", list);
		}
		return "queryAll_success";
	}
	public String add(){
		int sid=Integer.parseInt(request.getParameter("sid"));
		String sname=request.getParameter("sname");
		String gender=request.getParameter("gender");
		String address=request.getParameter("address");
		int scid=(int) session.getAttribute("scid");
		if(studentService.add(sid, sname, gender, address, scid)){
			return "addStudent_success";
		}else{
			return "addStudent_fail";
		}
	}
	public String update(){
		int sid=Integer.parseInt(request.getParameter("sid"));
		String sname=request.getParameter("sname");
		String gender=request.getParameter("gender");
		String address=request.getParameter("address");
		Student s=new Student(sid,sname,gender,address);
		if(studentService.update(s)){
			session.setAttribute("scid",studentService.queryById(sid).getScore().getScid() );
			return "update_success";
		}else{
			return "update_fail";
		}
	}
	public String delete(){
		int sid=Integer.parseInt(request.getParameter("sid"));
		Student student=studentService.queryById(sid);
		if(studentService.delete(student)){
			System.out.println("right");
			return "delete_success";
		}else{
			System.out.println("error");
			return "delete_fail";
		}
	}
}
