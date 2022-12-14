package tr.com.StokKart.controllerButton;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.Transaction;

import tr.com.StokKart.model.HibernateUtil;
import tr.com.StokKart.model.StokDao;
import tr.com.StokKart.model.StokTip;
import tr.com.StokKart.view.StokTipKart;

public class StokTipKartDeleteCommand implements ICommand {
	
	private StokTipKart stokTipKart;
	private StokDao stokDao = new StokDao();

	
	public StokTipKartDeleteCommand(StokTipKart stokTipKart) {
		super();
		this.stokTipKart = stokTipKart;
	}




	@Override
	public void execute() {
		

		int b = Integer.parseInt(stokTipKart.getLblId().getText());
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		StokTip stokTip = session.get(StokTip.class, b);
		
		session.delete(stokTip);
		transaction.commit();
		session.close();

		JOptionPane.showMessageDialog(null, "Silindi");
		

		
	}

}
