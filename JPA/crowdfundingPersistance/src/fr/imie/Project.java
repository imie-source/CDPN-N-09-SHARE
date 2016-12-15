package fr.imie;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="projet")
@NamedQuery(name="Project.findAll", query="SELECT p FROM Project p order by p.id")
public class Project {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String description;
	
	@Column(name="nom")
	private String name;
	
	@Column(name="objectif")
	private Integer goal;
	
	@OneToMany(mappedBy="project")
	private List<Gift> gifts;

	@Transient
	private Integer sumOfGifts;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getGoal() {
		return goal;
	}

	public void setGoal(Integer goal) {
		this.goal = goal;
	}

	public List<Gift> getGifts() {
		return gifts;
	}

	public Integer getSumOfGifts() {
		return sumOfGifts;
	}

	public void setSumOfGifts(Integer sumOfGifts) {
		this.sumOfGifts = sumOfGifts;
	}
	
	
	
	
	

}
