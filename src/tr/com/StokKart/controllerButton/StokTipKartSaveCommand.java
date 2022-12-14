package tr.com.StokKart.controllerButton;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import tr.com.StokKart.model.HibernateUtil;
import tr.com.StokKart.model.StokDao;
import tr.com.StokKart.model.StokTip;
import tr.com.StokKart.view.StokTipKart;

public class StokTipKartSaveCommand implements ICommand {

	private StokTipKart stokTipKart;
	private StokTip stokTip;
	

	public StokTipKartSaveCommand(StokTipKart stokTipKart) {
		super();
		this.stokTipKart = stokTipKart;
	}

	
	
	@Override
	public void execute() {
		
		stokTip = new StokTip();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		stokTip.setStokTipKodu(stokTipKart.getTextStokTipKodu().getText());
		stokTip.setStokTipAdi(stokTipKart.getTextStokTipAdi().getText());
		stokTip.setStokTipAciklama(stokTipKart.getTextStokTipAciklama().getText());
		session.save(stokTip);
		transaction.commit();
		session.close();
		JOptionPane.showInternalMessageDialog(null, "Başarılı");
		
		
		/*stokTip = new StokTip();
		StokTip stokTip = new StokTip();
		StokTipKart stokTipKart = new StokTipKart();
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(StokTip.class)
				.buildSessionFactory();

		stokTip.setStokTipKodu(stokTipKart.getTextStokTipKodu().getText());
		stokTip.setStokTipAdi(stokTipKart.getTextStokTipAdi().getText());
		stokTip.setStokTipAciklama(stokTipKart.getTextStokTipAciklama().getText());
		
		
		Session session = sessionFactory.openSession();
		session.save(stokTip);

		session.beginTransaction().commit();
		session.close();*/
		
	
		
		
		

	}

}
