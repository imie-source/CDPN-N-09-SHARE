package fr.imie;

import java.io.IOException;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import crowdfundingPersistance.Project;

/**
 * Servlet implementation class OneProject
 */
@WebServlet("/oneProject")
public class OneProject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource
	private UserTransaction transaction;
	@PersistenceContext
	private EntityManager em;

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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		Project project=null;
		
		try {
			transaction.begin();
			project =  em.find(Project.class, 1);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				transaction.rollback();
			} catch (IllegalStateException | SecurityException | SystemException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (project!=null){
			response.getWriter().append(project.getDescription());
		}
		
		request.setAttribute("project", project);
		
		request.getRequestDispatcher("/WEB-INF/oneProject.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
