package action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import entity.Score;
import entity.Student;
import service.ScoreService;
import service.StudentService;
@Repository
public class ScoreAction extends SuperAction {
	private ScoreService scoreService;
	@Autowired
	public void setScoreService(ScoreService scoreService){
		this.scoreService=scoreService;
	}
	private StudentService studentService;
	@Autowired
	public void setStudentService(StudentService studentService){
		this.studentService=studentService;
	}
	public String add(){
		int math=Integer.parseInt(request.getParameter("math"));
		int chinese=Integer.parseInt(request.getParameter("chinese"));
		int english=Integer.parseInt(request.getParameter("english"));
		Score score=new Score(math,chinese,english);
		if(scoreService.add(score)){
			session.setAttribute("scid", score.getScid());
			//System.out.println(session.getAttribute("scid"));
			return "addScore_success";
		}else{
			return "addScore_fail";
		}	
	}
	public String update(){
		int math=Integer.parseInt(request.getParameter("math"));
		int chinese=Integer.parseInt(request.getParameter("chinese"));
		int english=Integer.parseInt(request.getParameter("english"));
		int scid=(int) session.getAttribute("scid");
		Score score=new Score(scid,math,chinese,english);
		if(scoreService.update(score)){
			return "update_success";
		}else{
			return "update_fail";
		}
	}
	public String query(){
		int scid=Integer.parseInt(request.getParameter("scid"));
		int sid=Integer.parseInt(request.getParameter("sid"));
		Student student=studentService.queryById(sid);
		List<Score> scoreList=scoreService.queryById(scid);
		if(scoreList!=null&&scoreList.size()>0){
			session.setAttribute("scoreList", scoreList);
		}
		String name=student.getSname();
		session.setAttribute("sid", sid);
		session.setAttribute("name", name);
		return "query_success";
	}
}
