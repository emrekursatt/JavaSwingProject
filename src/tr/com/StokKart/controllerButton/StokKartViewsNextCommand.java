package tr.com.StokKart.controllerButton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import tr.com.StokKart.model.HibernateUtil;
import tr.com.StokKart.model.KdvTip;
import tr.com.StokKart.model.StokDao;
import tr.com.StokKart.model.StokKart;
import tr.com.StokKart.view.StokKartViews;

public class StokKartViewsNextCommand implements ICommand {
	
	private StokKartViews stokKartViews;
	private ResultSet resultSet;
	private PreparedStatement stm;
	
	
	
	
	
	public StokKartViewsNextCommand(StokKartViews stokKartViews) {
		super();
		this.stokKartViews = stokKartViews;
	}




	@Override
	public void execute() {
		
		
		
		String id = stokKartViews.getLblId().getText();
		
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "select * from stok3 where Id = (select min(Id) from stok3 where Id > '"+id+"')";
		Query query = session.createNativeQuery(hql);
		List<Object[]> resultSet = query.getResultList();
		
		
		for(Object[] row : resultSet) {
			stokKartViews.getLblId().setText( row[0].toString());
			stokKartViews.getTextStokKodu().setText((String) row[1]);
			stokKartViews.getTextStokAdi().setText((String) row[2]);
			stokKartViews.getComboBoxStokTipi().setSelectedItem(row[3]);
			stokKartViews.getComboBoxBirimi().setSelectedItem(row[4]);
			stokKartViews.getTextBarkod().setText((String) row[5]);
			stokKartViews.getComboBoxKdvTipi().setSelectedItem(row[6]);
			stokKartViews.getTextAciklama().setText((String) row[7]);
			stokKartViews.getFtfTarih().setText( row[8].toString());
		}
		
		
		
		
		/*try {
			if(resultSet.next()) {
				stokKartViews.getLblId().setText(resultSet.getString("Id"));
				stokKartViews.getTextStokKodu().setText(resultSet.getString("stokKodu"));
				stokKartViews.getTextStokAdi().setText(resultSet.getString("stokAdi"));
				stokKartViews.getComboBoxStokTipi().setSelectedItem(resultSet.getObject("stokTipiId"));
				stokKartViews.getComboBoxBirimi().setSelectedItem(resultSet.getString("birimi"));
				stokKartViews.getTextBarkod().setText(resultSet.getString("barkodu"));
				stokKartViews.getComboBoxKdvTipi().setSelectedItem(resultSet.getString("kdvTipiId"));
				stokKartViews.getTextAciklama().setText(resultSet.getString("aciklama"));
				stokKartViews.getFtfTarih().setText(resultSet.getString("olusturmaTarihi"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		
		/*Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "select * from stok3 where Id = (select min(Id) from stok3 where Id > '"+id+"')"; 
		
		Query query = session.createNativeQuery(hql); 
		List<StokKart> uyeListesi = query.list();*/
		
		
		


		
		/*StokDao stokDao = new StokDao();
		String stokKodu = stokKartViews.getTextStokKodu().getText();
		String id = stokKartViews.getLblId().getText();
		Connection connection = stokDao.getConnection();

		try {
			
			stm = connection.prepareStatement(" select * from stok3 where Id = (select min(Id) from stok3 where Id > '"+id+"') ");
			resultSet = stm.executeQuery();
					
			if(resultSet.next()) {
				stokKartViews.getLblId().setText(resultSet.getString("Id"));
				stokKartViews.getTextStokKodu().setText(resultSet.getString("stokKodu"));
				stokKartViews.getTextStokAdi().setText(resultSet.getString("stokAdi"));
				stokKartViews.getComboBoxStokTipi().setSelectedItem(resultSet.getObject("stokTipiId"));
				stokKartViews.getComboBoxBirimi().setSelectedItem(resultSet.getString("birimi"));
				stokKartViews.getTextBarkod().setText(resultSet.getString("barkodu"));
				stokKartViews.getComboBoxKdvTipi().setSelectedItem(resultSet.getString("kdvTipiId"));
				stokKartViews.getTextAciklama().setText(resultSet.getString("aciklama"));
				stokKartViews.getFtfTarih().setText(resultSet.getString("olusturmaTarihi"));
				
				}
			

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		
		
		
	}




	

}
