package tr.com.StokKart.controllerButton;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.Transaction;

import tr.com.StokKart.model.HibernateUtil;
import tr.com.StokKart.model.KdvTip;
import tr.com.StokKart.model.StokDao;
import tr.com.StokKart.view.KdvTipKart;

public class KdvTipKartUpdateCommand implements ICommand {
	
	private KdvTipKart kdvTipKart;
	
	
	
	
	public KdvTipKartUpdateCommand(KdvTipKart kdvTipKart) {
		super();
		this.kdvTipKart = kdvTipKart;
	}




	@Override
	public void execute() {
		
		int a =Integer.parseInt(kdvTipKart.getLblid().getText());  
		
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		
		KdvTip kdvTip = session.get(KdvTip.class, a);
		
		kdvTip.setKdvKodu(kdvTipKart.getTextKdvKodu().getText());
		
		kdvTip.setKdvAdi(kdvTipKart.getTextKdvAdi().getText());
		
		kdvTip.setKdvOrani(kdvTipKart.getTextKdvOrani().getText());
		
		session.update(kdvTip);
		
		transaction.commit();
		session.close();
		
		/*KdvTip kdvTip = new KdvTip();
		int a =Integer.parseInt(kdvTipKart.getLblid().getText());  
		kdvTip.setId(a);
	
		kdvTip.setKdvKodu(kdvTipKart.getTextKdvKodu().getText());
		
		kdvTip.setKdvAdi(kdvTipKart.getTextKdvAdi().getText());
		
		kdvTip.setKdvOrani(kdvTipKart.getTextKdvOrani().getText());
		new StokDao().updateKdv(kdvTip);*/
		JOptionPane.showMessageDialog(null, "Değiştirildi");
		
	}

}
