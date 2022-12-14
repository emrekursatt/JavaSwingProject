package tr.com.StokKart.controllerButton;

import javax.swing.table.DefaultTableModel;

import tr.com.StokKart.view.MainFrame;
import tr.com.StokKart.view.StokKartViews;
import tr.com.StokKart.view.StokList;

public class StokListMenuGosterCommand implements ICommand {

	private StokList  stokList;
	private StokKartViews stokKartViews;
	private MainFrame mainFrame;
	
	
	
	public StokListMenuGosterCommand(StokList stokList , MainFrame mainFrame) {
		super();
		this.stokList = stokList;
		this.mainFrame = mainFrame;
	}




	@Override
	public void execute() {
		
		
		
		stokKartViews = new StokKartViews();
		stokKartViews.setVisible(true);
		mainFrame.getDesktopPane().add(stokKartViews);
		stokList.setVisible(false);
		
		DefaultTableModel model = (DefaultTableModel)stokList.getTable1().getModel();

		int selectRow = stokList.getTable1().getSelectedRow();
		stokKartViews.getTextStokKodu().setText(model.getValueAt(selectRow, 1).toString());
		stokKartViews.getTextStokAdi().setText(model.getValueAt(selectRow, 2).toString());
		stokKartViews.getComboBoxStokTipi().setSelectedItem(model.getValueAt(selectRow, 12).toString());
		stokKartViews.getComboBoxBirimi().setSelectedItem(model.getValueAt(selectRow, 4).toString());
		stokKartViews.getTextBarkod().setText(model.getValueAt(selectRow, 5).toString());
		stokKartViews.getComboBoxKdvTipi().setSelectedItem(model.getValueAt(selectRow, 10).toString());
		stokKartViews.getTextAciklama().setText(model.getValueAt(selectRow, 7).toString());
		
		stokKartViews.getBtnKaydett().addActionListener(new GeneralAction(new StokKartViewsSaveCommand(stokKartViews)));
		stokKartViews.getBtnSil().addActionListener(new GeneralAction(new StokKartDeleteCommand(stokKartViews)));
		stokKartViews.getBtnDuzenle().addActionListener(new GeneralAction(new StokKartViewsUpdateCommand(stokKartViews)));
		stokKartViews.getBtnNext().addActionListener(new GeneralAction(new StokKartViewsNextCommand(stokKartViews)));

		
	}

}
