package tr.com.StokKart.controller;

import tr.com.StokKart.controllerButton.GeneralAction;
import tr.com.StokKart.controllerButton.KdvTipKartDeleteCommand;
import tr.com.StokKart.controllerButton.KdvTipKartSaveCommand;
import tr.com.StokKart.controllerButton.KdvTipKartUpdateCommand;
import tr.com.StokKart.view.KdvTipKart;
import tr.com.StokKart.view.MainFrame;

public class KdvTipKartFrameController {
	
	private KdvTipKart kdvTipKart;
	private MainFrame mainFrame;


	
	public KdvTipKartFrameController(MainFrame mainFrame) {
		super();
		this.mainFrame = mainFrame;
	}

	public void execute() {
		
		kdvTipKart = new KdvTipKart();
		setListeners();
		//desktop.add(kdvTipKart);
		kdvTipKart.setVisible(true);
		mainFrame.getDesktopPane().add(kdvTipKart);
		
		
	}
	
	private void setListeners() {
		
		kdvTipKart.getBtnKaydet().addActionListener(new GeneralAction(new KdvTipKartSaveCommand(kdvTipKart)));
		kdvTipKart.getBtnSil().addActionListener(new GeneralAction(new KdvTipKartDeleteCommand(kdvTipKart)));
		kdvTipKart.getBtnGuncelle().addActionListener(new GeneralAction(new KdvTipKartUpdateCommand(kdvTipKart)));
		
//		kdvTipKart.getBtnGuncelle().addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//				KdvTip kdvTip = new KdvTip();
//				
//				
//				int a =Integer.parseInt(kdvTipKart.getLblid().getText());  
//			
//				kdvTip.setId(a);
//			
//				kdvTip.setKdvKodu(kdvTipKart.getTextKdvKodu().getText());
//				
//				kdvTip.setKdvAdi(kdvTipKart.getTextKdvAdi().getText());
//				
//				kdvTip.setKdvOrani(kdvTipKart.getTextKdvOrani().getText());
//				new StokDao().updateKdv(kdvTip);
//				JOptionPane.showMessageDialog(null, "Değiştirildi");
//				
//				
//			}
//		});
//		
//		
//		kdvTipKart.getBtnSil().addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//				KdvTip kdvTip = new KdvTip();
//				
//				int b =Integer.parseInt(kdvTipKart.getLblid().getText());  
//				kdvTip.setId(b);
//				
//				new StokDao().deleteKdv(kdvTip);
//				JOptionPane.showMessageDialog(null, "Silindi");
//				
//			}
//		});
//		
//		
//		
//		kdvTipKart.getBtnKaydet().addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				KdvTip kdvTip = new KdvTip();
//				
//				
//				kdvTip.setKdvKodu(kdvTipKart.getTextKdvKodu().getText());
//				kdvTip.setKdvAdi(kdvTipKart.getTextKdvAdi().getText());
//				kdvTip.setKdvOrani(kdvTipKart.getTextKdvOrani().getText());
//				
//				new StokDao().insertKdvTipi(kdvTip);
//				
//				JOptionPane.showMessageDialog(null, "Başarılı");
//			}
//				
//			
//		});
		
	}
	
}
