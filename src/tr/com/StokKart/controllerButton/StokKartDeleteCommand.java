package tr.com.StokKart.controllerButton;

import javax.swing.JOptionPane;


import org.hibernate.Session;
import org.hibernate.Transaction;

import tr.com.StokKart.model.HibernateUtil;
import tr.com.StokKart.model.StokDao;
import tr.com.StokKart.model.StokKart;
import tr.com.StokKart.view.StokKartViews;

public class StokKartDeleteCommand implements ICommand{
	
	private StokKartViews stokKartViews;
	private StokKart stokKart;
	
	
	
	public StokKartDeleteCommand(StokKartViews stokKartViews) {
		super();
		this.stokKartViews = stokKartViews;
	}


	

	@Override
	public void execute() {
		
		int a =Integer.parseInt(stokKartViews.getLblId().getText());  
		
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		stokKart = session.get(StokKart.class, a);
		session.delete(stokKart);
		
		transaction.commit();
		session.close();
		JOptionPane.showMessageDialog(null, "Silindi");
		

	}

}
