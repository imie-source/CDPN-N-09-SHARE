package fr.imie;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OneProject
 */
@WebServlet("/oneProject")
public class OneProject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	IProjectBusiness projectBusiness;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OneProject() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = null;


			String action = request.getParameter("action");
			action = action == null ? "" : action;
			Project project = null;
			switch (action) {
			case "edit":
				id = Integer.parseInt(request.getParameter("id"));
				project = projectBusiness.getProjectById(id);
				request.setAttribute("project", project);
				request.setAttribute("mode", "edit");
				break;
			case "create":
				request.setAttribute("mode", "edit");
				break;
			default:
				id = Integer.parseInt(request.getParameter("id"));
				project = projectBusiness.getProjectById(id);
				request.setAttribute("project", project);
				request.setAttribute("mode", "read");
				break;
			}

			request.getRequestDispatcher("/WEB-INF/oneProject.jsp").forward(request, response);


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Project project = new Project();
		if(request.getParameter("saveAction")!=null){
			String name = request.getParameter("nameInput");
			String goalInput = request.getParameter("goalInput");
			Integer goal = Integer.parseInt(goalInput);
			String description = request.getParameter("descriptionInput");
			
			project.setName(name);
			project.setGoal(goal);
			project.setDescription(description);

			String idInput = request.getParameter("id");

			if (!idInput.equals("")) {
				Integer id = Integer.parseInt(idInput);
				project.setId(id);
				projectBusiness.updateProject(project);

			} else {
				projectBusiness.insertProject(project);

			}
		}else if (request.getParameter("giveAction")!=null) {
			String idInput = request.getParameter("id");
			Integer id = Integer.parseInt(idInput);
			String amountInput = request.getParameter("giftAmountInput");
			Integer amount = Integer.parseInt(amountInput);
			project= projectBusiness.getProjectById(id);
			projectBusiness.giveToProject(project, amount, null);
		}
		

		response.sendRedirect(String.format("./oneProject?id=%S", project.getId()));
	}

}
