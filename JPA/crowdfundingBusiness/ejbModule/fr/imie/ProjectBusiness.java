package fr.imie;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import sun.net.www.content.image.gif;

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
    	this.computeGifts(project);
		return project;
    }

	@Override
	public List<Project> getAllProject() {
		List<Project> projects = em.createNamedQuery("Project.findAll",Project.class).getResultList();
		for (Project project : projects) {
			this.computeGifts(project);
		}
		return projects;
	}

	@Override
	public Project updateProject(Project project) {
		Project projetToUpdate= em.find(Project.class,project.getId());
		projetToUpdate.setGoal(project.getGoal());
		projetToUpdate.setName(project.getName());
		projetToUpdate.setDescription(project.getDescription());
		return projetToUpdate;
		
	}

	@Override
	public Project insertProject(Project project) {
		em.persist(project);
		return project;
	}
	
	private void computeGifts(Project project){
		Integer sumOfGifts = 0;
		for (Gift gift : project.getGifts()) {
			sumOfGifts += gift.getAmount();
		}
		project.setSumOfGifts(sumOfGifts);
	}

	@Override
	public Project giveToProject(Project project, Integer amount, User user) {
		Gift gift = new Gift();
		project = this.getProjectById(project.getId());
		gift.setProject(project);
		gift.setAmount(amount);
		gift.setUser(user);
		em.persist(gift);
		em.refresh(project);
		this.computeGifts(project);
		return project;	
		
	}

}
