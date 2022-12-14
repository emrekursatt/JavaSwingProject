package tr.com.StokKart.view;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JInternalFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

import tr.com.StokKart.model.StokDao;
import tr.com.StokKart.model.StokKart;

public class StokList extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table1;
	private JMenuItem menuExcel;
	private DefaultTableModel model1;
	private JMenuItem menuGoster;
	private JMenuItem menuPdf;
	private JMenuItem menuMail;
	

	public StokList() {
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setTitle("Stok Listesi");
		setResizable(true);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 1920, 388);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1366, 358);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		

		Object[] stokList = { "Id", "Stok Kodu", "Stok Adı", "Stok Tipi", "Birimi", "Barkodu", "Kdv Tipi", "Açıklama",
				"Kdv Kodu", "Kdv Adı", "Kdv Oranı", "Stok Tip Kodu", "Stok Tip Adı",
				"Stok Tip Açıklama" };
		model1 = new DefaultTableModel(stokList, 0);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1366, 347);

		for (StokKart stokKart : new StokDao().getAll()) {
			model1.addRow(stokKart.getVeriler());
		}

		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(scrollPane, popupMenu);

		menuExcel = new JMenuItem("Excel'e Aktar");
		popupMenu.add(menuExcel);

		menuGoster = new JMenuItem("Göster");
		popupMenu.add(menuGoster);

		menuPdf = new JMenuItem("Ekrana");
		popupMenu.add(menuPdf);
		
		menuMail = new JMenuItem("Pdf Mail Gönder");
		popupMenu.add(menuMail);
		table1 = new JTable(model1);
		scrollPane.setViewportView(table1);
		panel.add(scrollPane);

	}

	public JMenuItem getMenuExcel() {
		return menuExcel;
	}

	public void setMenuExcel(JMenuItem menuExcel) {
		this.menuExcel = menuExcel;
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}

		});
	}

	public JTable getTable1() {
		return table1;
	}

	public void setTable1(JTable table_1) {
		this.table1 = table_1;
	}

	public DefaultTableModel getModel1() {
		return model1;
	}

	public void setModel1(DefaultTableModel model) {
		this.model1 = model;
	}

	public JMenuItem getMenuGoster() {
		return menuGoster;
	}

	public void setMenuGoster(JMenuItem menuGoster) {
		this.menuGoster = menuGoster;
	}

	public JMenuItem getMenuPdf() {
		return menuPdf;
	}

	public void setMenuPdf(JMenuItem menuPdf) {
		this.menuPdf = menuPdf;
	}

	public JMenuItem getMenuMail() {
		return menuMail;
	}

	public void setMenuMail(JMenuItem menuMail) {
		this.menuMail = menuMail;
	}
	
	

}

