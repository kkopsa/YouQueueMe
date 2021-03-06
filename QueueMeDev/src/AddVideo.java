
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddVideo
 */
@WebServlet("/AddVideo")
public class AddVideo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddVideo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String userID;
		String[] friendID;
		String videoID;
		String videoTitle;

		QueueDatabase qdb = new QueueDatabase();

		videoID = request.getParameter("videoId");
		userID = (String) request.getSession().getAttribute("userId");
		friendID = request.getParameterValues("friends[]");
		videoTitle = request.getParameter("videoTitle");

		int size = friendID.length;

		for (int i = 0; i < size; i++) {
			try {
				qdb.addVideo(userID, friendID[i], videoID, videoTitle);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}

		response.sendRedirect("watch.jsp");

	}

}
