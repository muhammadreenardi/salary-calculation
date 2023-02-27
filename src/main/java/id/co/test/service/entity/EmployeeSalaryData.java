package id.co.test.service.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE_SALARY")
public class EmployeeSalaryData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
    
	private String nik;
    private BigDecimal pokok;
	private BigDecimal tunjangan;
	private BigDecimal bonus;
	private BigDecimal potongan;
	private BigDecimal pajak;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNik() {
		return nik;
	}
	public void setNik(String nik) {
		this.nik = nik;
	}
	public BigDecimal getPokok() {
		return pokok;
	}
	public void setPokok(BigDecimal pokok) {
		this.pokok = pokok;
	}
	public BigDecimal getTunjangan() {
		return tunjangan;
	}
	public void setTunjangan(BigDecimal tunjangan) {
		this.tunjangan = tunjangan;
	}
	public BigDecimal getBonus() {
		return bonus;
	}
	public void setBonus(BigDecimal bonus) {
		this.bonus = bonus;
	}
	public BigDecimal getPotongan() {
		return potongan;
	}
	public void setPotongan(BigDecimal potongan) {
		this.potongan = potongan;
	}
	public BigDecimal getPajak() {
		return pajak;
	}
	public void setPajak(BigDecimal pajak) {
		this.pajak = pajak;
	}
	
	
}
