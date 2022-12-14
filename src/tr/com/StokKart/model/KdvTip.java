package tr.com.StokKart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

@Entity
@Table(name = "kdvtip")
@Audited
public class KdvTip {

	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int Id;
	@Column(name = "kdvkodu")
	private String kdvKodu;
	@Column(name = "kdvdAdi")
	private String kdvAdi;
	@Column(name = "kdvOrani")
	private String kdvOrani;
	
	
	
	
	public KdvTip(int id, String kdvKodu, String kdvAdi, String kdvOrani) {
		super();
		Id = id;
		this.kdvKodu = kdvKodu;
		this.kdvAdi = kdvAdi;
		this.kdvOrani = kdvOrani;
	}



	public KdvTip() {
		
	}



	public int getId() {
		return Id;
	}



	public void setId(int id) {
		Id = id;
	}



	public String getKdvKodu() {
		return kdvKodu;
	}



	public void setKdvKodu(String kdvKodu) {
		this.kdvKodu = kdvKodu;
	}



	public String getKdvAdi() {
		return kdvAdi;
	}



	public void setKdvAdi(String kdvAdi) {
		this.kdvAdi = kdvAdi;
	}



	public String getKdvOrani() {
		return kdvOrani;
	}



	public void setKdvOrani(String kdvOrani) {
		this.kdvOrani = kdvOrani;
	}



	
	
	@Override
	public String toString() {
		return kdvOrani;
	}

	



public Object[] getVeriler2() {
		
		
		Object[] veriler2 = {kdvKodu,kdvAdi,kdvOrani};
		/*StokKart stokKartlist = new StokKart();
		Object[] veriler = {stokKartlist.getId(),stokKartlist.getStokKodu(),stokKartlist.getStokTipiId(),stokKartlist.getBirimi(),
				stokKartlist.getBarkodu(),stokKartlist.getKdvTipiId(),stokKartlist.getAciklama(),stokKartlist.getOlusturmaTarihi()};*/
		
		
		//Id,stokKodu,stokAdi,stokTipiId,birimi,barkodu,kdvTipiId,aciklama,olusturmaTarihi
		
		return veriler2;
	}

	
}
