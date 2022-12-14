package tr.com.StokKart.model;


import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.hibernate.envers.Audited;
@Entity
@Table(name = "stoktip")
@Audited
public class StokTip {

	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int Id;
	@Column(name = "stokTipKodu")
	private String stokTipKodu;
	@Column(name = "stokTipAdi")
	private String stokTipAdi;
	@Column(name = "stokTipaciklama")
	private String stokTipAciklama;
	
	
	
	

	


	public StokTip(int id, String stokTipKodu, String stokTipAdi, String stokTipAciklama) {
		super();
		Id = id;
		this.stokTipKodu = stokTipKodu;
		this.stokTipAdi = stokTipAdi;
		this.stokTipAciklama = stokTipAciklama;
	}




	public StokTip() {
		// TODO Auto-generated constructor stub
	}




	public int getId() {
		return Id;
	}



	public void setId(int id) {
		Id = id;
	}




	public String getStokTipKodu() {
		return stokTipKodu;
	}




	public void setStokTipKodu(String stokTipKodu) {
		this.stokTipKodu = stokTipKodu;
	}




	public String getStokTipAdi() {
		return stokTipAdi;
	}




	public void setStokTipAdi(String stokTipAdi) {
		this.stokTipAdi = stokTipAdi;
	}




	public String getStokTipAciklama() {
		return stokTipAciklama;
	}




	public void setStokTipAciklama(String stokTipAciklama) {
		this.stokTipAciklama = stokTipAciklama;
	}




	@Override
	public String toString() {
		return stokTipAdi;
				 
	}




	@Override
	public int hashCode() {
		return Objects.hash(Id, stokTipAciklama, stokTipAdi, stokTipKodu);
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StokTip other = (StokTip) obj;
		return Id == other.Id && Objects.equals(stokTipAciklama, other.stokTipAciklama)
				&& Objects.equals(stokTipAdi, other.stokTipAdi) && Objects.equals(stokTipKodu, other.stokTipKodu);
	}



	



	

	

	


	
	
	
	
	
	
	
	
	

}
