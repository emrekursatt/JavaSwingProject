package tr.com.StokKart.controllerButton;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.Transaction;

import tr.com.StokKart.model.HibernateUtil;
import tr.com.StokKart.model.KdvTip;
import tr.com.StokKart.model.StokDao;
import tr.com.StokKart.model.StokKart;
import tr.com.StokKart.model.StokTip;
import tr.com.StokKart.view.StokKartViews;
import tr.com.StokKart.view.StokTipKart;

public class StokKartViewsSaveCommand implements ICommand {

	private StokKartViews stokKartViews;
	
	
	
	
	public StokKartViewsSaveCommand(StokKartViews stokKartViews) {
		super();
		this.stokKartViews = stokKartViews;
	}




	@Override
	public void execute() {
		StokKart stokKart = new StokKart();

		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		stokKart.setStokKodu(stokKartViews.getTextStokKodu().getText());
		
		stokKart.setStokAdi(stokKartViews.getTextStokAdi().getText());
		
		stokKart.setKtvTip((KdvTip) stokKartViews.getComboBoxKdvTipi().getSelectedItem());
		
		stokKart.setStokTip((StokTip) stokKartViews.getComboBoxStokTipi().getSelectedItem());
		
		stokKart.setBirimi((String)stokKartViews.getComboBoxBirimi().getSelectedItem());
		
		stokKart.setBarkodu(stokKartViews.getTextBarkod().getText());
		
		stokKart.setAciklama(stokKartViews.getTextAciklama().getText());
		
		stokKart.setOlusturmaTarihi(stokKartViews.getFtfTarih().getText());
		
		session.save(stokKart);
		transaction.commit();
		session.close();
		JOptionPane.showMessageDialog(null, stokKart.getStokAdi()+ " " + stokKart.getStokKodu() +"Eklendi");
		
		/*StokKart stokKart = new StokKart();
		
		stokKart.setStokKodu(stokKartViews.getTextStokKodu().getText());
		
		stokKart.setStokAdi(stokKartViews.getTextStokAdi().getText());
		
		StokTip stokTip = (StokTip)stokKartViews.getComboBoxStokTipi().getSelectedItem();
		
		KdvTip kdvTip = (KdvTip) stokKartViews.getComboBoxKdvTipi().getSelectedItem();
		
		stokKart.setBirimi((String)stokKartViews.getComboBoxBirimi().getSelectedItem());
		
		stokKart.setBarkodu(stokKartViews.getTextBarkod().getText());
		
		stokKart.setAciklama(stokKartViews.getTextAciklama().getText());
		
		stokKart.setOlusturmaTarihi(stokKartViews.getFtfTarih().getText());*/
		
		
		//new StokDao().insert(stokKart,stokTip,kdvTip);
		
		
		
		
	}

}
