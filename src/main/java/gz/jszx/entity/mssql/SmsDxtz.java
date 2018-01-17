package gz.jszx.entity.mssql;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the sms_dxtz database table.
 * 
 */
@Entity
@Table(name="sms_dxtz")
@NamedQuery(name="SmsDxtz.findAll", query="SELECT s FROM SmsDxtz s")
public class SmsDxtz implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String dxlx;

	private String dxnr;

	private String fssj;

	private String jbr;

	private String lxdh;

	private String lxr;

	@Column(name="proins_id")
	private Integer proins_id;

	private int sffsdx;

	private String ssbm;

	private String ywid;

	public SmsDxtz() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDxlx() {
		return this.dxlx;
	}

	public void setDxlx(String dxlx) {
		this.dxlx = dxlx;
	}

	public String getDxnr() {
		return this.dxnr;
	}

	public void setDxnr(String dxnr) {
		this.dxnr = dxnr;
	}

	public String getFssj() {
		return this.fssj;
	}

	public void setFssj(String fssj) {
		this.fssj = fssj;
	}

	public String getJbr() {
		return this.jbr;
	}

	public void setJbr(String jbr) {
		this.jbr = jbr;
	}

	public String getLxdh() {
		return this.lxdh;
	}

	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}

	public String getLxr() {
		return this.lxr;
	}

	public void setLxr(String lxr) {
		this.lxr = lxr;
	}

	public Integer getProinsId() {
		return this.proins_id;
	}

	public void setProinsId(Integer proinsId) {
		this.proins_id = proinsId;
	}

	public int getSffsdx() {
		return this.sffsdx;
	}

	public void setSffsdx(int sffsdx) {
		this.sffsdx = sffsdx;
	}

	public String getSsbm() {
		return this.ssbm;
	}

	public void setSsbm(String ssbm) {
		this.ssbm = ssbm;
	}

	public String getYwid() {
		return this.ywid;
	}

	public void setYwid(String ywid) {
		this.ywid = ywid;
	}

	@Override
	public String toString() {
		return "SmsDxtz [id=" + id + ", dxlx=" + dxlx + ", dxnr=" + dxnr
				+ ", fssj=" + fssj + ", jbr=" + jbr + ", lxdh=" + lxdh
				+ ", lxr=" + lxr + ", proins_id=" + proins_id + ", sffsdx="
				+ sffsdx + ", ssbm=" + ssbm + ", ywid=" + ywid + "]";
	}

}