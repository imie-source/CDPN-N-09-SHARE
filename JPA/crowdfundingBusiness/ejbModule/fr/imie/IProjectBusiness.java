/**
 * 
 */
package fr.imie;

import java.util.List;

/**
 * @author imiedev
 *
 */
public interface IProjectBusiness {
	Project getProjectById(Integer id);
	List<Project> getAllProject();
	Project updateProject(Project project);
	Project insertProject(Project project);
	Project giveToProject(Project project, Integer amount, User user);
}
