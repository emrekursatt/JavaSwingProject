package tr.com.StokKart.controllerButton;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.Transaction;

import tr.com.StokKart.model.HibernateUtil;
import tr.com.StokKart.model.KdvTip;
import tr.com.StokKart.model.StokDao;
import tr.com.StokKart.view.KdvTipKart;

public class KdvTipKartSaveCommand implements ICommand {
	
	private KdvTipKart kdvTipKart;
	private StokDao stokDao = new StokDao();
	
	
	public KdvTipKartSaveCommand(KdvTipKart kdvTipKart) {
		super();
		this.kdvTipKart = kdvTipKart;
	}



	@Override
	public void execute() {
		KdvTip kdvTip = new KdvTip();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		kdvTip.setKdvKodu(kdvTipKart.getTextKdvKodu().getText());
		kdvTip.setKdvAdi(kdvTipKart.getTextKdvAdi().getText());
		kdvTip.setKdvOrani(kdvTipKart.getTextKdvOrani().getText());
		session.save(kdvTip);
		transaction.commit();
		session.close();
		JOptionPane.showInternalMessageDialog(null, "Başarılı");
		
		
		
		
		
		/*KdvTip kdvTip = new KdvTip();
		
		
		kdvTip.setKdvKodu(kdvTipKart.getTextKdvKodu().getText());
		kdvTip.setKdvAdi(kdvTipKart.getTextKdvAdi().getText());
		kdvTip.setKdvOrani(kdvTipKart.getTextKdvOrani().getText());
		
		stokDao.insertKdvTipi(kdvTip);
		
		JOptionPane.showMessageDialog(null, "Başarılı");*/

		
	}

}
