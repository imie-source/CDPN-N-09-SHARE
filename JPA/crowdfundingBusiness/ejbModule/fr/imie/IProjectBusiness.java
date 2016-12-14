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
}
