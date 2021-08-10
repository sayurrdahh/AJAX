package user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserSearchServlet")
public class UserSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //utf-8으로 파라미터를 인코딩 할 수 있도록 한다. 아이디정보, 회원정보 등 넘어온 값을 utf-8로 처리하겠다.
		response.setContentType("text/html;charset=UTF-8"); 
		String userName = request.getParameter("userName"); //요청에 담긴 파라미터값 userName을 가져오도록 한다.
		response.getWriter().write(getJSON(userName)); 
	}
	public String getJSON(String userName) { //json은 파싱하기 쉬운 하나의 형태, 특정한 회원을 검색했을 때 json형태로 돌아오도록
		if(userName == null) userName = "";
		StringBuffer result = new StringBuffer("");
		result.append("{\"result\":[");
		UserDAO userDAO = new UserDAO();
		ArrayList<User> userList = userDAO.search(userName);
		for(int i = 0; i<userList.size();i++) {
			result.append("[{\"value\": \"" + userList.get(i).getUserName() + "\"},");
			result.append("{\"value\": \"" + userList.get(i).getUserAge() + "\"},");
			result.append("{\"value\": \"" + userList.get(i).getUserGender() + "\"},");
			result.append("{\"value\": \"" + userList.get(i).getUserEmail() + "\"}],");
		}
		result.append("]}");
		return result.toString();
	}
}
