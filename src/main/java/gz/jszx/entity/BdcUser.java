package gz.jszx.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the BDC_USER database table.
 * 
 */
@Entity
@Table(name="BDC_USER")
@NamedQuery(name="BdcUser.findAll", query="SELECT b FROM BdcUser b")
public class BdcUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String unitno;

	private String password;

	public BdcUser() {
	}
	
	public BdcUser(String unitno, String password) {
		this.unitno = unitno;
		this.password = password;
	}

	public String getUnitno() {
		return this.unitno;
	}

	public void setUnitno(String unitno) {
		this.unitno = unitno;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "BdcUser [unitno=" + unitno + ", password=" + password + "]";
	}

}