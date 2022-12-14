package tr.com.StokKart.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import javax.swing.JScrollPane;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import tr.com.StokKart.model.StokDao;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.ImageIcon;


public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private DefaultTableModel model;
	private JList list;
	private JDesktopPane desktopPane;
	private JMenuBar menuBar_1;
	private JMenuItem menuStokList;
	private JMenuItem menuStokKart;
	private JMenu mnNewMenu;
	private JMenuItem menuStokTip;
	private JMenuItem menuKdvTip;
	
	
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 490);
		
		menuBar_1 = new JMenuBar();
		setJMenuBar(menuBar_1);
		
		JMenu menuStok = new JMenu("Stok Menü");
		menuBar_1.add(menuStok);
		
		menuStokKart = new JMenuItem("Stok Kart");
		menuStok.add(menuStokKart);
		
		menuStokList = new JMenuItem("Stok Kartı Listesi");
		menuStok.add(menuStokList);
		
		mnNewMenu = new JMenu("Tip Menü");
		menuBar_1.add(mnNewMenu);
		
		menuStokTip = new JMenuItem("Stok Tip Kartı");
		mnNewMenu.add(menuStokTip);
		
		menuKdvTip = new JMenuItem("Kdv Tip Kartı");
		mnNewMenu.add(menuKdvTip);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(0, 0, 1370, 451);
		contentPane.add(panel1);
		panel1.setLayout(null);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(255, 255, 255));
		desktopPane.setBounds(0, 0, 1360, 427);
		panel1.add(desktopPane);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(148, 321, 101, 22);
		panel1.add(menuBar);
		
		
		list = new JList(new StokDao().getList().toArray());
		JScrollPane pane =new JScrollPane(list);
		list.setSelectedIndex(0);

	}
	
	

	/*public JTextField getTextStokKodu() {
		return textStokKodu;
	}

	public void setTextStokKodu(JTextField textStokKodu) {
		this.textStokKodu = textStokKodu;
	}

	public JTextField getTextStokAdi() {
		return textStokAdi;
	}

	public void setTextStokAdi(JTextField textStokAdi) {
		this.textStokAdi = textStokAdi;
	}

	public JTextField getTextBarkod() {
		return textBarkod;
	}

	public void setTextBarkod(JTextField textBarkod) {
		this.textBarkod = textBarkod;
	}

	/*public JTable getTable_1() {
		return table_1;
	}

	public void setTable_1(JTable table_1) {
		this.table_1 = table_1;
	}

	public JButton getBtnKaydet() {
		return btnKaydet;
	}

	public void setBtnKaydet(JButton btnKaydet) {
		this.btnKaydet = btnKaydet;
	}

	public JButton getBtnDzenle() {
		return btnDzenle;
	}

	public void setBtnDzenle(JButton btnDzenle) {
		this.btnDzenle = btnDzenle;
	}

	public JButton getBtnSil() {
		return btnSil;
	}

	public void setBtnSil(JButton btnSil) {
		this.btnSil = btnSil;
	}

	

	public JComboBox getComboBoxStokTipi() {
		return comboBoxStokTipi;
	}

	public void setComboBoxStokTipi(JComboBox comboBoxStokTipi) {
		this.comboBoxStokTipi = comboBoxStokTipi;
	}

	public JComboBox getComboBoxBirimi() {
		return comboBoxBirimi;
	}

	public void setComboBoxBirimi(JComboBox comboBoxBirimi) {
		this.comboBoxBirimi = comboBoxBirimi;
	}

	public JComboBox getComboBoxKdvTipi() {
		return comboBoxKdvTipi;
	}

	public void setComboBoxKdvTipi(JComboBox comboBoxKdvTipi) {
		this.comboBoxKdvTipi = comboBoxKdvTipi;
	}

	public JTextArea getTextAciklama() {
		return textAciklama;
	}

	public void setTextAciklama(JTextArea textAciklama) {
		this.textAciklama = textAciklama;
	}

	public JFormattedTextField getFtfTarih() {
		return ftfTarih;
	}

	public void setFtfTarih(JFormattedTextField ftfTarih) {
		this.ftfTarih = ftfTarih;
	}

	
	

	public JButton getBtnKopyala() {
		return btnKopyala;
	}

	public void setBtnKopyala(JButton btnKopyala) {
		this.btnKopyala = btnKopyala;
	}*/

	

	public JMenuItem getMenuStokTip() {
		return menuStokTip;
	}



	public void setMenuStokTip(JMenuItem menuStokTip) {
		this.menuStokTip = menuStokTip;
	}



	public JMenuItem getMenuKdvTip() {
		return menuKdvTip;
	}



	public void setMenuKdvTip(JMenuItem menuKdvTip) {
		this.menuKdvTip = menuKdvTip;
	}



	public JDesktopPane getDesktopPane() {
		return desktopPane;
	}

	public void setDesktopPane(JDesktopPane desktopPane) {
		this.desktopPane = desktopPane;
	}

	
	
	public void setModel(DefaultTableModel model) {
		this.model = model;
	}
	public DefaultTableModel getModel() {
		return model;
	}


	public JList getList() {
		return list;
	}

	public void setList(JList list) {
		this.list = list;
	}
	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public JMenuItem getMenuStokList() {
		return menuStokList;
	}

	public void setMenuStokList(JMenuItem menuStokList) {
		this.menuStokList = menuStokList;
	}

	public JMenuItem getMenuStokKart() {
		return menuStokKart;
	}

	public void setMenuStokKart(JMenuItem menuStokKart) {
		this.menuStokKart = menuStokKart;
	}
}
