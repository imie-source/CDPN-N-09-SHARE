package fr.imie;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class ProjectBusiness
 */
@Stateless
@Local(IProjectBusiness.class)
public class ProjectBusiness implements IProjectBusiness {

	@PersistenceContext
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public ProjectBusiness() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see IProjectBusiness#getProjectById(Integer)
     */
    @Override
    public Project getProjectById(Integer id) {
    	Project project =  em.find(Project.class, id);
		return project;
    }

	@Override
	public List<Project> getAllProject() {
		return em.createNamedQuery("Project.findAll",Project.class).getResultList();
	}

}
