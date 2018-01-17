package gz.jszx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bdc_qh_dept")
public class Dept {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length=11)
	private Integer id;
	
	@Column(name="orgCode",length=6)
	private String orgCode;
	
	@Column(name="orgName",length=30)
	private String orgName;
	
	@Column(name="djzgNo",length=2)
	private String djzgNo;
	
	@Column(name="zsNo",length=2)
	private String zsNo;
	
 
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrgCode() {
		return orgCode;
	}
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	public String getDjzgNo() {
		return djzgNo;
	}
	public void setDjzgNo(String djzgNo) {
		this.djzgNo = djzgNo;
	}
	public String getZsNo() {
		return zsNo;
	}
	public void setZsNo(String zsNo) {
		this.zsNo = zsNo;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	
	
}
