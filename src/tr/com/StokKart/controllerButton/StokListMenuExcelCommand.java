package tr.com.StokKart.controllerButton;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import tr.com.StokKart.model.StokDao;
import tr.com.StokKart.view.StokKartViews;
import tr.com.StokKart.view.StokList;

public class StokListMenuExcelCommand implements ICommand {
	
	private StokList stokList;
	
	
	
	public StokListMenuExcelCommand(StokList stokList) {
		super();
		this.stokList = stokList;
	}

	@Override
	public void execute() {
		StokDao stokDao = new StokDao();
		StokKartViews stokKartViews = new StokKartViews();
		
		
		
		//Excel Calisma Kitabini Olustur
	    XSSFWorkbook workbook = new XSSFWorkbook();
	   
	   	//Excel Sayfasi Olustur
	    XSSFSheet sheet = workbook.createSheet("Liste");
	    
	    //Basliklar icin olusturulacak bicim yapisi icin font nesnesi hazirla
	    XSSFFont headerFont = workbook.createFont();
	    

	    //Yazi rengini belirle
	    headerFont.setColor(IndexedColors.BLUE.getIndex()); 
	    
	    //Basliklar icin bicim nesnesini olustur
	    XSSFCellStyle headerStyle = workbook.createCellStyle();
	    
	    //Hazirladigin Font nesnesini bicime ekle
	    headerStyle.setFont(headerFont);
	   
	    Row headerRow = sheet.createRow(0);
	    
	    Cell hId = headerRow.createCell(0);
	    hId.setCellValue("ID");
	    Cell hStokKodu = headerRow.createCell(1);
	    hStokKodu.setCellValue("Stok Kodu");
	    Cell hStokAdi = headerRow.createCell(2);
	    hStokAdi.setCellValue("Stok Adı");
	    Cell hStokTipi = headerRow.createCell(3);
	    hStokTipi.setCellValue("Stok Tipi");
	    Cell hBirimi = headerRow.createCell(4);
	    hBirimi.setCellValue("Birimi");
	    Cell hBakordu = headerRow.createCell(5);
	    hBakordu.setCellValue("Barkodu");
	    Cell hKdvTipi = headerRow.createCell(6);
	    hKdvTipi.setCellValue("Kdv Tipi");
	    Cell hAciklama = headerRow.createCell(7);
	    hAciklama.setCellValue("Açıklama");
	    Cell hKdvKodu = headerRow.createCell(8);
	    hKdvKodu.setCellValue("Kdv Kodu");
	    Cell hKdvAdi = headerRow.createCell(9);
	    hKdvAdi.setCellValue("Kdv Adı");
	    Cell hKdvOrani = headerRow.createCell(10);
	    hKdvOrani.setCellValue("Kdv Oranı");
	    Cell hStokTipKodu = headerRow.createCell(11);
	    hStokTipKodu.setCellValue("Stok Tip Kodu");
	    Cell hStokTipAdı = headerRow.createCell(12);
	    hStokTipAdı.setCellValue("Stok Tip Adı");
	    Cell hStokTipAciklama = headerRow.createCell(13);
	    hStokTipAciklama.setCellValue("Stok Tip Açıklama");
	    
	    
	    
	    hId.setCellStyle(headerStyle);
	    hStokKodu.setCellStyle(headerStyle);
	    hStokAdi.setCellStyle(headerStyle);
	    hStokTipi.setCellStyle(headerStyle);
	    hBirimi.setCellStyle(headerStyle);
	    hBakordu.setCellStyle(headerStyle);
	    hKdvTipi.setCellStyle(headerStyle);
	    hStokAdi.setCellStyle(headerStyle);
	    hKdvKodu.setCellStyle(headerStyle);
	    hKdvAdi.setCellStyle(headerStyle);
	    hKdvOrani.setCellStyle(headerStyle);
	    hStokTipKodu.setCellStyle(headerStyle);
	    hStokTipAdı.setCellStyle(headerStyle);
	    hStokTipAciklama.setCellStyle(headerStyle);
	    
	    
	    for (int i = 0; i < stokDao.getAll().size(); i++) {
	    	//Olusturdugumuz sayfa icerisinde yeni bir satir olustur
	        //i+1 yazmamizin nedeni 0. satir yani ilk satira basliklari yazdigimizdan 0 dan baslatmadik
	        Row row = sheet.createRow(i+1);
	        
	      //Ilgili satir icin yeni bir hucre olustur
	        
	        Cell Id = row.createCell(0);
	        Id.setCellValue(stokDao.getList().get(i).getId());
	        
	        Cell stokKodu = row.createCell(1);
	        stokKodu.setCellValue(stokDao.getList().get(i).getStokKodu());
	        
	        Cell stokAdi = row.createCell(2);
	        stokAdi.setCellValue(stokDao.getList().get(i).getStokAdi());
	        
	        Cell stokTipi = row.createCell(3);
	        stokTipi.setCellValue((stokDao.getList().get(i).getStokTipiId()));
	        
	        Cell birimi = row.createCell(4);
	        birimi.setCellValue((stokDao.getList().get(i).getBirimi()));
	        
	        Cell barkodu = row.createCell(5);
	        barkodu.setCellValue((stokDao.getList().get(i).getBarkodu()));
	        
	        Cell kdvTipi = row.createCell(6);
	        kdvTipi.setCellValue((stokDao.getList().get(i).getKdvTipiId()));
	        
	        Cell aciklama = row.createCell(7);
	        aciklama.setCellValue((stokDao.getList().get(i).getAciklama()));
	        
	        Cell kdvKodu = row.createCell(8);
	        kdvKodu.setCellValue((stokDao.getList2().get(i).getKdvKodu()));
	        
	        Cell kdvAdi = row.createCell(9);
	        kdvAdi.setCellValue((stokDao.getList2().get(i).getKdvAdi()));
	        
	        Cell kdvOrani = row.createCell(10);
	        kdvOrani.setCellValue((stokDao.getList2().get(i).getKdvOrani()));
	        
	        Cell stokTipKodu = row.createCell(11);
	        stokTipKodu.setCellValue((stokDao.getList3().get(i).getStokTipKodu()));
	        
	        Cell stokTipAdi = row.createCell(12);
	        stokTipAdi.setCellValue((stokDao.getList3().get(i).getStokTipAdi()));
	        
	        Cell stokTipAciklama = row.createCell(13);
	        stokTipAciklama.setCellValue((stokDao.getList3().get(i).getStokTipAciklama()));
	        
	        
	        
		    write(workbook);
		    
		    
	        
		}
	    
	    JOptionPane.showMessageDialog(null, "Başarılı");
		
	}

	private void write(XSSFWorkbook workbook) {
		try 
		  {
		       FileOutputStream out = new FileOutputStream(new File("C:\\Users\\emrek\\Desktop\\liste.xlsx"));
		       Desktop.getDesktop().open(new File("C:\\Users\\emrek\\Desktop\\liste.xlsx"));
		       workbook.write(out);
		       out.close();
		  } 
		  catch (FileNotFoundException e) {
		    e.printStackTrace();
		  } 
		  catch (IOException e) {
		       e.printStackTrace();
		  }
		
	}

}
