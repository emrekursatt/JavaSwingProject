package tr.com.StokKart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

@Entity
@Table(name = "stok3")
@Audited
public class StokKart {
	
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int Id;
	@Column(insertable = false, updatable = false)
	private int stokTipiId;
	@Column(insertable = false, updatable = false)
	private int kdvTipiId;
	
	@Column(name = "stokKodu")
	private String stokKodu;
	@Column(name = "stokAdi")
	private String stokAdi;;
	@Column(name = "birimi")
	private String birimi;
	@Column(name = "barkodu")
	private String barkodu;
	@Column(name = "aciklama")
	private String aciklama;
	@Column(name = "olusturmaTarihi")
	private String olusturmaTarihi;
	
	@OneToOne
	@JoinColumn(name = "kdvTipiId")
	private KdvTip ktvTip;
	
	@OneToOne
	@JoinColumn(name = "stokTipiId")
	private StokTip stokTip;
	
	
	
	public StokKart() {
		
	}
	

	public StokKart(int id, String stokKodu, String stokAdi, int stokTipiId, String birimi, String barkodu,
			int kdvTipiId, String aciklama, String olusturmaTarihi) {
		super();
		Id = id;
		this.stokKodu = stokKodu;
		this.stokAdi = stokAdi;
		this.stokTipiId = stokTipiId;
		this.birimi = birimi;
		this.barkodu = barkodu;
		this.kdvTipiId = kdvTipiId;
		this.aciklama = aciklama;
		this.olusturmaTarihi = olusturmaTarihi;
	}







	public int getId() {
		return Id;
	}

	public void setId(int id) {
		this.Id = id;
	}

	public String getStokKodu() {
		return stokKodu;
	}

	public void setStokKodu(String stokKodu) {
		this.stokKodu = stokKodu;
	}

	public String getStokAdi() {
		return stokAdi;
	}

	public void setStokAdi(String stokAdi) {
		this.stokAdi = stokAdi;
	}

	

	public String getBirimi() {
		return birimi;
	}

	public void setBirimi(String birimi) {
		this.birimi = birimi;
	}

	public String getBarkodu() {
		return barkodu;
	}

	public void setBarkodu(String barkodu) {
		this.barkodu = barkodu;
	}

	

	public String getAciklama() {
		return aciklama;
	}

	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}

	public String getOlusturmaTarihi() {
		return olusturmaTarihi;
	}

	public void setOlusturmaTarihi(String olusturmaTarihi) {
		this.olusturmaTarihi = olusturmaTarihi;
	}
	
	
	
	public int getStokTipiId() {
		return stokTipiId;
	}



	public void setStokTipiId(int stokTipiId) {
		this.stokTipiId = stokTipiId;
	}


	public int getKdvTipiId() {
		return kdvTipiId;
	}


	public void setKdvTipiId(int kdvTipiId) {
		this.kdvTipiId = kdvTipiId;
	}
	

	public KdvTip getKtvTip() {
		return ktvTip;
	}


	public void setKtvTip(KdvTip ktvTip) {
		this.ktvTip = ktvTip;
	}
	
	

	public StokTip getStokTip() {
		return stokTip;
	}


	public void setStokTip(StokTip stokTip) {
		this.stokTip = stokTip;
	}







	public Object[] getVeriler() {
		

		Object[] veriler = {Id,stokKodu,stokAdi,stokTipiId,birimi,barkodu,kdvTipiId,aciklama, ktvTip.getKdvKodu(), ktvTip.getKdvAdi(), ktvTip.getKdvOrani(),stokTip.getStokTipKodu(),stokTip.getStokTipAdi(),stokTip.getStokTipAciklama()};

		return veriler;
	}
/*olusturmaTarihi,*/

	@Override
	public String toString() {
		return "StokKart [Id=" + Id + ", stokKodu=" + stokKodu + ", stokAdi=" + stokAdi + ", stokTipi=" + stokTipiId
				+ ", birimi=" + birimi + ", barkodu=" + barkodu + ", kdvTipi=" + kdvTipiId + ", aciklama=" + aciklama
				+ ", olusturmaTarihi=" + olusturmaTarihi + "]";
	}
	
	
	

}








/*StokKart stokKartlist = new StokKart();
Object[] veriler = {stokKartlist.getId(),stokKartlist.getStokKodu(),stokKartlist.getStokTipiId(),stokKartlist.getBirimi(),
		stokKartlist.getBarkodu(),stokKartlist.getKdvTipiId(),stokKartlist.getAciklama(),stokKartlist.getOlusturmaTarihi()};


//Id,stokKodu,stokAdi,stokTipiId,birimi,barkodu,kdvTipiId,aciklama,olusturmaTarihi*/
