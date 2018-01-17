package gz.jszx.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the DEMO database table.
 * 
 */
@Entity
@NamedQuery(name="Demo.findAll", query="SELECT d FROM Demo d")
public class Demo implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private String id;

	private String name;

	public Demo() {
	}

	public Demo(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}