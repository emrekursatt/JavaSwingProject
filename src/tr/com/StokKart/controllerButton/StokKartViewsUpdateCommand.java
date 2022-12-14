package tr.com.StokKart.controllerButton;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.Transaction;

import tr.com.StokKart.model.HibernateUtil;
import tr.com.StokKart.model.KdvTip;
import tr.com.StokKart.model.StokKart;
import tr.com.StokKart.model.StokTip;
import tr.com.StokKart.view.StokKartViews;

public class StokKartViewsUpdateCommand implements ICommand {
	
	private StokKartViews stokKartViews;
	
	
	
	public StokKartViewsUpdateCommand(StokKartViews stokKartViews) {
		super();
		this.stokKartViews = stokKartViews;
	}



	@Override
	public void execute() {
		int a =Integer.parseInt(stokKartViews.getLblId().getText());  

		
		

		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		StokKart stokKart = session.get(StokKart.class, a);
		
		stokKart.setStokKodu(stokKartViews.getTextStokKodu().getText());
		
		stokKart.setStokAdi(stokKartViews.getTextStokAdi().getText());
		
		stokKart.setKtvTip((KdvTip) stokKartViews.getComboBoxKdvTipi().getSelectedItem());
		
		stokKart.setStokTip((StokTip) stokKartViews.getComboBoxStokTipi().getSelectedItem());
		
		stokKart.setBirimi((String)stokKartViews.getComboBoxBirimi().getSelectedItem());
		
		stokKart.setBarkodu(stokKartViews.getTextBarkod().getText());
		
		stokKart.setAciklama(stokKartViews.getTextAciklama().getText());
		
		stokKart.setOlusturmaTarihi(stokKartViews.getFtfTarih().getText());
		
		session.update(stokKart);
		transaction.commit();
		session.close();
		JOptionPane.showMessageDialog(null, "Değiştirildi");
		
		
		
		/*StokKart stokKart = new StokKart();
		StokTip stokTip2 = new StokTip();
		KdvTip kdvTip2 = new KdvTip();
		
		int a =Integer.parseInt(stokKartViews.getLblId().getText());  
		
		
		stokKart.setId(a);
		
		stokKart.setStokKodu(stokKartViews.getTextStokKodu().getText());
		
		stokKart.setStokAdi(stokKartViews.getTextStokAdi().getText());
		
		StokTip stokTip = (StokTip)stokKartViews.getComboBoxStokTipi().getSelectedItem();
		
		KdvTip kdvTip = (KdvTip) stokKartViews.getComboBoxKdvTipi().getSelectedItem();
		
		stokKart.setBirimi((String)stokKartViews.getComboBoxBirimi().getSelectedItem());
		
		stokKart.setBarkodu(stokKartViews.getTextBarkod().getText());
		
		stokKart.setAciklama(stokKartViews.getTextAciklama().getText());
		
		stokKart.setOlusturmaTarihi(stokKartViews.getFtfTarih().getText());
		
		new StokDao().update(stokKart, stokTip, kdvTip);*/
		
		//JOptionPane.showMessageDialog(null, "Değiştirildi");
		
	}

}
