package gz.jszx.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the OA2_SYSDIC database table.
 * 
 */
@Entity
@Table(name="OA2_SYSDIC")
@NamedQuery(name="Oa2Sysdic.findAll", query="SELECT o FROM Oa2Sysdic o")
public class Oa2Sysdic implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SD_OID")
	private long sdOid;

	private BigDecimal owner;

	@Column(name="SD_CLASS")
	private BigDecimal sdClass;

	@Column(name="SD_KEYNO")
	private String sdKeyno;

	@Column(name="SD_KEYNO2")
	private String sdKeyno2;

	@Column(name="SD_MAIN")
	private BigDecimal sdMain;

	@Column(name="SD_ORDER")
	private BigDecimal sdOrder;

	@Column(name="SD_REMARK")
	private String sdRemark;

	@Column(name="SD_REMARK2")
	private String sdRemark2;

	@Column(name="SD_REMARK3")
	private String sdRemark3;

	@Column(name="SD_VALUE")
	private String sdValue;

	public Oa2Sysdic() {
	}

	public long getSdOid() {
		return this.sdOid;
	}

	public void setSdOid(long sdOid) {
		this.sdOid = sdOid;
	}

	public BigDecimal getOwner() {
		return this.owner;
	}

	public void setOwner(BigDecimal owner) {
		this.owner = owner;
	}

	public BigDecimal getSdClass() {
		return this.sdClass;
	}

	public void setSdClass(BigDecimal sdClass) {
		this.sdClass = sdClass;
	}

	public String getSdKeyno() {
		return this.sdKeyno;
	}

	public void setSdKeyno(String sdKeyno) {
		this.sdKeyno = sdKeyno;
	}

	public String getSdKeyno2() {
		return this.sdKeyno2;
	}

	public void setSdKeyno2(String sdKeyno2) {
		this.sdKeyno2 = sdKeyno2;
	}

	public BigDecimal getSdMain() {
		return this.sdMain;
	}

	public void setSdMain(BigDecimal sdMain) {
		this.sdMain = sdMain;
	}

	public BigDecimal getSdOrder() {
		return this.sdOrder;
	}

	public void setSdOrder(BigDecimal sdOrder) {
		this.sdOrder = sdOrder;
	}

	public String getSdRemark() {
		return this.sdRemark;
	}

	public void setSdRemark(String sdRemark) {
		this.sdRemark = sdRemark;
	}

	public String getSdRemark2() {
		return this.sdRemark2;
	}

	public void setSdRemark2(String sdRemark2) {
		this.sdRemark2 = sdRemark2;
	}

	public String getSdRemark3() {
		return this.sdRemark3;
	}

	public void setSdRemark3(String sdRemark3) {
		this.sdRemark3 = sdRemark3;
	}

	public String getSdValue() {
		return this.sdValue;
	}

	public void setSdValue(String sdValue) {
		this.sdValue = sdValue;
	}

	@Override
	public String toString() {
		return "Oa2Sysdic [sdOid=" + sdOid + ", owner=" + owner + ", sdClass="
				+ sdClass + ", sdKeyno=" + sdKeyno + ", sdKeyno2=" + sdKeyno2
				+ ", sdMain=" + sdMain + ", sdOrder=" + sdOrder + ", sdRemark="
				+ sdRemark + ", sdRemark2=" + sdRemark2 + ", sdRemark3="
				+ sdRemark3 + ", sdValue=" + sdValue + "]";
	}

}