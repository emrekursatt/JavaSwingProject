package tr.com.StokKart.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;



public class StokDao {

	private String userName = "root";

	private String password = "12345";

	private String url = "jdbc:mysql://localhost:3306/guruhb?characterEncoding=utf8";

	
	static {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private ResultSet resultSet;
	private Connection connection;
	private Statement statement;

	public Connection getConnection() {

		Connection connection = null;

		try {
			connection = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {

			e.printStackTrace();
			
		}
		return connection;
	}
	

	

	public List<StokKart> getAll() {

		
		
		Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<StokKart> fullList = session.createNativeQuery("SELECT \r\n"
            		+ "    stok3.Id,\r\n"
            		+ "    stok3.stokAdi,\r\n"
            		+ "    stok3.stokKodu,\r\n"
            		+ "    stok3.stokTipiId,\r\n"
            		+ "    stok3.birimi,\r\n"
            		+ "    stok3.kdvTipiId,\r\n"
            		+ "    stok3.barkodu,\r\n"
            		+ "    stok3.olusturmaTarihi,\r\n"
            		+ "    stok3.aciklama,\r\n"
            		+ "    kdvtip.kdvKodu,\r\n"
            		+ "    kdvtip.kdvdAdi,\r\n"
            		+ "    kdvtip.kdvOrani,\r\n"
            		+ "    stoktip.stokTipKodu,\r\n"
            		+ "    stoktip.stokTipAdi,\r\n"
            		+ "    stoktip.stokTipaciklama\r\n"
            		+ "FROM\r\n"
            		+ "    stok3,\r\n"
            		+ "    kdvtip,\r\n"
            		+ "    stoktip\r\n"
            		+ "WHERE\r\n"
            		+ "    kdvtip.Id = stok3.kdvtipiId\r\n"
            		+ "        AND stoktip.Id = stok3.stoktipiId", StokKart.class).getResultList();
            return fullList;
        }catch (Exception e){
            return null;
        }finally {
            session.close();
        }
		
		
		
		
	

	}

public List<StokTip> stokTip() {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<StokTip> stokTipList = session.createNativeQuery("Select * from stoktip", StokTip.class).getResultList();
            return stokTipList;
        }catch (Exception e){
            return null;
        }finally {
            session.close();
        }
		
	

	}

	public List<KdvTip> kdvTip() {


		Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<KdvTip> kdvList = session.createNativeQuery("Select * from kdvtip", KdvTip.class).getResultList();
            return kdvList;
        }catch (Exception e){
            return null;
        }finally {
            session.close();
        }
		
	}
	
	public List<StokTip> getList3() {

		List<StokTip> dataStokKart = new ArrayList<StokTip>();
		
		
		StokTip stokTip;

		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from stoktip ");
			while (resultSet.next()) {
				
				stokTip = new StokTip();
				
				stokTip.setStokTipKodu(resultSet.getString("stokTipKodu"));
				stokTip.setStokTipAdi(resultSet.getString("stokTipAdi"));
				stokTip.setStokTipAciklama(resultSet.getString("stokTipaciklama"));
				
				
				
				
				dataStokKart.add(stokTip);
			}
			statement.close();
			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block ,
			e.printStackTrace();
		}

		return dataStokKart;
	}
	
	public List<KdvTip> getList2() {

		List<KdvTip> dataStokKart = new ArrayList<KdvTip>();
		
		
		KdvTip kdvTip;

		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from kdvtip ");
			while (resultSet.next()) {
				
				
				kdvTip = new KdvTip();
				

				
				kdvTip.setKdvKodu(resultSet.getString("kdvKodu"));
				kdvTip.setKdvAdi(resultSet.getString("kdvdAdi"));
				kdvTip.setKdvOrani(resultSet.getString("kdvOrani"));
				
				
				
				dataStokKart.add(kdvTip);
			}
			statement.close();
			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block ,
			e.printStackTrace();
		}

		return dataStokKart;
	}
	

	public List<StokKart> getList() {

		List<StokKart> dataStokKart = new ArrayList<StokKart>();
		
		StokKart stokKart;
		StokTip stokTip;
		KdvTip kdvTip;

		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from stok3 ");
			while (resultSet.next()) {
				
				stokKart = new StokKart();
				kdvTip = new KdvTip();
				stokTip = new StokTip();

				stokKart.setId(resultSet.getInt("Id"));
				stokKart.setStokKodu(resultSet.getString("stokKodu"));
				stokKart.setStokAdi(resultSet.getString("stokAdi"));
				stokKart.setStokTipiId(resultSet.getInt("stokTipiId"));
				stokKart.setBirimi(resultSet.getString("birimi"));
				stokKart.setBarkodu(resultSet.getString("barkodu"));
				stokKart.setKdvTipiId(resultSet.getInt("kdvTipiId"));
				stokKart.setAciklama(resultSet.getString("aciklama"));
				stokKart.setStokTip(stokTip);
				
				dataStokKart.add(stokKart);
			}
			statement.close();
			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block ,
			e.printStackTrace();
		}

		return dataStokKart;

	}

	public void kopyala(StokKart entity) {
		Connection connection = getConnection();

		try {
			Statement statement = connection.createStatement();

			statement.executeUpdate(
					"INSERT Stok3(stokKodu ,stokAdi ,stokTipi,birimi ,barkodu,kdvTipi,aciklama,olusturmaTarihi)"
							+ " VALUES('" + entity.getStokKodu() + "' , '" + entity.getStokAdi() + "' , "
							+ entity.getStokTipiId() + ", '" + entity.getBirimi() + "', '" + entity.getBarkodu() + "',"
							+ entity.getKdvTipiId() + ",'" + entity.getAciklama() + "','" + entity.getOlusturmaTarihi()
							+ "')");
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	
	
	
	

	public ResultSet getResultSet() {
		return resultSet;
	}

	public void setResultSet(ResultSet resultSet) {
		this.resultSet = resultSet;
	}

	public Statement getStatement() {
		return statement;
	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

}

