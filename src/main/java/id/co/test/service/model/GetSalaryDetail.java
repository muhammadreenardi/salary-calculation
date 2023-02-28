package id.co.test.service.model;

import java.math.BigDecimal;

public class GetSalaryDetail {
	
    private BigDecimal pokok;
	private BigDecimal tunjangan;
	private BigDecimal bonus;
	private BigDecimal potongan;
	private BigDecimal pajak;
	private BigDecimal nett;
	private BigDecimal persentasePengurangan;
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
	public BigDecimal getNett() {
		return nett;
	}
	public void setNett(BigDecimal nett) {
		this.nett = nett;
	}
	public BigDecimal getPersentasePengurangan() {
		return persentasePengurangan;
	}
	public void setPersentasePengurangan(BigDecimal persentasePengurangan) {
		this.persentasePengurangan = persentasePengurangan;
	}
	
	

}
