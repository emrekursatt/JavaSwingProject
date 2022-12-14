package tr.com.StokKart.controllerButton;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.Transaction;

import tr.com.StokKart.model.HibernateUtil;
import tr.com.StokKart.model.KdvTip;
import tr.com.StokKart.view.KdvTipKart;

public class KdvTipKartDeleteCommand implements ICommand {
	
	private KdvTipKart kdvTipKart;
	
	
	
	public KdvTipKartDeleteCommand(KdvTipKart kdvTipKart) {
		super();
		this.kdvTipKart = kdvTipKart;
	}



	@Override
	public void execute() {
		
		int b =Integer.parseInt(kdvTipKart.getLblid().getText());  
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		KdvTip kdvTip = session.get(KdvTip.class,b);
		session.delete(kdvTip);
		
		transaction.commit();
		session.close();
		
		
		/*KdvTip kdvTip = new KdvTip();
		int b =Integer.parseInt(kdvTipKart.getLblid().getText());  
		kdvTip.setId(b);
		
		
		new StokDao().deleteKdv(kdvTip);*/
		JOptionPane.showMessageDialog(null, "Silindi");

		
		
		
	}



	

}
