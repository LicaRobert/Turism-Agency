package turist;

import statiune.Statiune;

public class Turist {
	private int id;
	private String nume;
	private String sex;
	private int varsta;
	private String psejur;
	private String ssejur;
	private String statiune;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getStatiune() {
		return statiune;
	}
	public void setStatiune(String statiune) {
		this.statiune = statiune;
	}
	public int getVarsta() {
		return varsta;
	}
	public void setVarsta(int varsta) {
		this.varsta = varsta;
	}
	public String getPsejur() {
		return psejur;
	}
	public void setPsejur(String psejur) {
		this.psejur=psejur;
	}
	
	public String getSsejur() {
		return ssejur;
	}
	public void setSsejur(String ssejur) {
		this.ssejur=ssejur;
	}
	
	@Override
	public String toString() {
		return "Id:"+id+"\nNume:"+nume+"\nSex:"+sex+"\nVarsta:"+varsta+"\nInceput sejur:"+psejur+"\nSfarsit sejur:"+ssejur+"\nStatiune :"+statiune;
	}
}
