package tr.com.StokKart.controllerButton;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JOptionPane;




import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.view.JasperViewer;
import tr.com.StokKart.model.StokDao;
import tr.com.StokKart.view.StokList;

public class StokListMenuPdfCommand implements ICommand{
	
	private StokList stokList;
	
	
	
	public StokListMenuPdfCommand(StokList stokList) {
		super();
		this.stokList = stokList;
	}



	@Override
	public void execute() {
		
		StokDao stokDao = new StokDao();

		Connection con = stokDao.getConnection();

		try {
			JasperDesign jasperDesign = JRXmlLoader
					.load("D:\\GitHub Repoları\\GuruWorkShop\\src\\Relatorio\\reports.jrxml");
			
			String query = "SELECT \r\n"
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
					+ "        AND stoktip.Id = stok3.stoktipiId;";
			
			JRDesignQuery updateQuery = new JRDesignQuery();
			updateQuery.setText(query);
			jasperDesign.setQuery(updateQuery);
			
			JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
			
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null,con);
			
			JasperExportManager.exportReportToPdfFile(jasperPrint,"C:\\Users\\emrek\\Desktop\\excel\\report.pdf");
			try {
				Desktop.getDesktop().open(new File("C:\\Users\\emrek\\Desktop\\excel\\report.pdf"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			//JasperViewer.viewReport(jasperPrint);
			
			
			
			JOptionPane.showMessageDialog(null, "Oluşturuldu");
		} catch (JRException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
//		InputStream stringPath =getClass().getResourceAsStream("/Relatorio/report4.jasper");
//		Collection<Map<String, ?>> parameters = new ArrayList<>();
//		Map<String, Object> maps = new HashMap<String,Object>();
//		
//		int selectedRow = stokList.getTable1().getSelectedRow();
//		maps.put("Id", stokList.getTable1().getModel().getValueAt(selectedRow, 0).toString());
//		maps.put("stokKodu", stokList.getTable1().getModel().getValueAt(selectedRow, 1).toString());
//		maps.put("stokTipiId", stokList.getTable1().getModel().getValueAt(selectedRow, 2).toString());
//		maps.put("birimi", stokList.getTable1().getModel().getValueAt(selectedRow, 3).toString());
//		maps.put("kdvTipiId", stokList.getTable1().getModel().getValueAt(selectedRow, 4).toString());
//		maps.put("barkodu", stokList.getTable1().getModel().getValueAt(selectedRow, 5).toString());
//		maps.put("olusturmaTarihi", stokList.getTable1().getModel().getValueAt(selectedRow, 6).toString());
//		maps.put("aciklama", stokList.getTable1().getModel().getValueAt(selectedRow, 7).toString());
//		maps.put("kdvKodu", stokList.getTable1().getModel().getValueAt(selectedRow, 8).toString());
//		maps.put("kdvdAdi", stokList.getTable1().getModel().getValueAt(selectedRow, 9).toString());
//		maps.put("kdvOrani", stokList.getTable1().getModel().getValueAt(selectedRow, 10).toString());
//		maps.put("stokTipKodu", stokList.getTable1().getModel().getValueAt(selectedRow, 11).toString());
//		maps.put("stokTipAdi", stokList.getTable1().getModel().getValueAt(selectedRow, 12).toString());
//		maps.put("stokTipaciklama", stokList.getTable1().getModel().getValueAt(selectedRow, 13).toString());
//		
		
		
//		parameters.add(maps);
//		
//		JRMapCollectionDataSource dataSource = new JRMapCollectionDataSource(parameters);
//		
//		try {
//			JasperPrint jp = JasperFillManager.fillReport(stringPath, maps,dataSource);
//			JFrame frame = new JFrame("Report");
//			frame.getContentPane().add(new JRViewer(jp));
//			frame.setBounds(500,500,1500,1500);
//			frame.pack();
//			frame.setVisible(true);
//		} catch (JRException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}	
//		
		
		
		
		
		
		
		
		
		
		
		
		

		

		
	}

}
//InputStream stringPath =getClass().getResourceAsStream("/Relatorio/reports.jasper");
//Collection<Map<String, ?>> parameters = new ArrayList<>();
////Collection<Map<String, ?>> parameters = new ArrayList<>();
//Map<String, Object> maps = new HashMap<String,Object>();
//
//int selectedRow = stokList.getTable1().getSelectedRow();
//maps.put("Id", stokList.getTable1().getModel().getValueAt(selectedRow, 0).toString());
//maps.put("stokKodu", stokList.getTable1().getModel().getValueAt(selectedRow, 1).toString());
//maps.put("stokTipiId", stokList.getTable1().getModel().getValueAt(selectedRow, 2).toString());
//maps.put("birimi", stokList.getTable1().getModel().getValueAt(selectedRow, 3).toString());
//maps.put("kdvTipiId", stokList.getTable1().getModel().getValueAt(selectedRow, 4).toString());
//maps.put("barkodu", stokList.getTable1().getModel().getValueAt(selectedRow, 5).toString());
//maps.put("olusturmaTarihi", stokList.getTable1().getModel().getValueAt(selectedRow, 6).toString());
//maps.put("aciklama", stokList.getTable1().getModel().getValueAt(selectedRow, 7).toString());
//maps.put("kdvKodu", stokList.getTable1().getModel().getValueAt(selectedRow, 8).toString());
//maps.put("kdvdAdi", stokList.getTable1().getModel().getValueAt(selectedRow, 9).toString());
//maps.put("kdvOrani", stokList.getTable1().getModel().getValueAt(selectedRow, 10).toString());
//maps.put("stokTipKodu", stokList.getTable1().getModel().getValueAt(selectedRow, 11).toString());
//maps.put("stokTipAdi", stokList.getTable1().getModel().getValueAt(selectedRow, 12).toString());
//maps.put("stokTipaciklama", stokList.getTable1().getModel().getValueAt(selectedRow, 13).toString());
//
//
//
//parameters.add(maps);
//
//JRMapCollectionDataSource dataSource = new JRMapCollectionDataSource(parameters);
//
//try {
//	JasperPrint jp = JasperFillManager.fillReport(stringPath, maps,dataSource);
//	JFrame frame = new JFrame("Report");
//	frame.getContentPane().add(new JRViewer(jp));
//	frame.setBounds(500,500,1500,1500);
//	frame.pack();
//	frame.setVisible(true);
//} catch (JRException e1) {
//	// TODO Auto-generated catch block
//	e1.printStackTrace();
//}
	
