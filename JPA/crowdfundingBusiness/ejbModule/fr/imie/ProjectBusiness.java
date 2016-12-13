package fr.imie;

import crowdfundingPersistance.Project;
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
    public Project getProjectById(Integer id) {
    	Project project =  em.find(Project.class, id);
		return project;
    }

}
