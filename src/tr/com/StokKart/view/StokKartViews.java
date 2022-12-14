package tr.com.StokKart.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import tr.com.StokKart.model.StokDao;

public class StokKartViews extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnKaydett;
	private JButton btnDuzenle;
	private JButton btnSil;
	private JComboBox comboBoxStokTipi;
	private JComboBox comboBoxBirimi;
	private JComboBox comboBoxKdvTipi;
	private JTextArea textAciklama;
	private JFormattedTextField ftfTarih;
	private DefaultTableModel model;
	private JList list;
	private JMenuItem menuStokKart;
	private JMenuItem menuStokList;
	private JButton btnStokKart;
	private JButton btnStokList;
	private JDesktopPane desktopPane;
	private JTextField textStokKodu;
	private JTextField textStokAdi;
	private JTextField textBarkod;
	private JButton btnİlk;
	private StokList stokList;
	private JButton btnNext;
	private JButton btnGeri;
	JButton btnSon;
	private JLabel lblId = new JLabel("");

	private ResultSet resultSet;
	private Statement statement;
	private PreparedStatement stm;
	
	
	
	@SuppressWarnings("unchecked")
	public StokKartViews() {
		setTitle("Stok Kart");

		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		lblId.setVisible(false);
		setBounds(100, 100, 717, 313);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 701, 283);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Stok Kodu");
		lblNewLabel.setBounds(10, 24, 54, 25);
		panel.add(lblNewLabel);

		JLabel lblStokAdi = new JLabel("Stok Adı");
		lblStokAdi.setBounds(10, 56, 54, 22);
		panel.add(lblStokAdi);

		JLabel lblStokTipi = new JLabel("Stok Tipi");
		lblStokTipi.setBounds(10, 89, 54, 22);
		panel.add(lblStokTipi);

		textStokKodu = new JTextField();
		textStokKodu.setColumns(10);
		textStokKodu.setBounds(70, 27, 132, 20);
		panel.add(textStokKodu);

		textStokAdi = new JTextField();
		textStokAdi.setColumns(10);
		textStokAdi.setBounds(70, 57, 132, 20);
		panel.add(textStokAdi);

		comboBoxStokTipi = new JComboBox<Object>(new DefaultComboBoxModel<Object>(new StokDao().stokTip().toArray()));
		comboBoxStokTipi.setBounds(71, 89, 132, 25);
		panel.add(comboBoxStokTipi);

		comboBoxBirimi = new JComboBox<Object>();
		comboBoxBirimi.setModel(new DefaultComboBoxModel<Object>(new String[] { "KG", "G", "METRE", "CM" }));
		comboBoxBirimi.setBounds(396, 25, 131, 22);
		panel.add(comboBoxBirimi);

		textBarkod = new JTextField();
		textBarkod.setColumns(10);
		textBarkod.setBounds(396, 57, 132, 20);
		panel.add(textBarkod);

		comboBoxKdvTipi = new JComboBox<Object>();
		comboBoxKdvTipi.setModel(new DefaultComboBoxModel<Object>(new StokDao().kdvTip().toArray()));
		comboBoxKdvTipi.setBounds(396, 89, 131, 22);
		panel.add(comboBoxKdvTipi);
		

		JLabel lblBirimi = new JLabel("Birimi");
		lblBirimi.setBounds(332, 25, 54, 22);
		panel.add(lblBirimi);

		JLabel lblBarkod = new JLabel("Barkod");
		lblBarkod.setBounds(332, 56, 54, 22);
		panel.add(lblBarkod);

		JLabel lblNewLabel_1_4 = new JLabel("KDV");
		lblNewLabel_1_4.setBounds(332, 89, 54, 22);
		panel.add(lblNewLabel_1_4);

		JLabel lblAciklama = new JLabel("Açıklama");
		lblAciklama.setBounds(10, 162, 61, 22);
		panel.add(lblAciklama);

		JLabel lblTarih = new JLabel("Tarih");
		lblTarih.setBounds(10, 208, 54, 22);
		panel.add(lblTarih);

		textAciklama = new JTextArea();
		textAciklama.setBounds(63, 148, 156, 48);
		panel.add(textAciklama);

		ftfTarih = new JFormattedTextField();
		ftfTarih.setBounds(63, 210, 156, 20);
		panel.add(ftfTarih);

		btnKaydett = new JButton("Kaydet");
		btnKaydett.setBounds(321, 144, 89, 23);
		panel.add(btnKaydett);

		btnDuzenle = new JButton("Düzenle");
		btnDuzenle.setBounds(431, 144, 89, 23);
		panel.add(btnDuzenle);

		btnSil = new JButton("Sil");
		btnSil.setBounds(537, 144, 89, 23);
		panel.add(btnSil);
		
		

		btnNext = new JButton("");
		btnNext.setBackground(Color.WHITE);
		btnNext.setIcon(new ImageIcon("C:\\Users\\emrek\\Desktop\\Yeni klasör (2)\\right2.png"));
		btnNext.setBounds(420, 208, 31, 22);
		panel.add(btnNext);

		btnGeri = new JButton("");
		btnGeri.setIcon(new ImageIcon("C:\\Users\\emrek\\Desktop\\Yeni klasör (2)\\back-button (1).png"));
		btnGeri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StokDao stokDao = new StokDao();
				String stokKodu = textStokKodu.getText();
				String stokAdi = textStokAdi.getText();
				String id = lblId.getText();
				Connection connection = stokDao.getConnection();

				try {
					
					stm = connection.prepareStatement(" select * from stok3 where Id = (select max(Id) from stok3 where Id < '"+id+"')");
					resultSet = stm.executeQuery();
							
					if(resultSet.next()) {
						lblId.setText(resultSet.getString("Id"));
						textStokKodu.setText(resultSet.getString("stokKodu"));
						textStokAdi.setText(resultSet.getString("stokAdi"));
						//comboBoxStokTipi.setSelectedItem(resultSet.getString("stokTipiId"));
						comboBoxStokTipi.setSelectedItem(resultSet.getObject("stokTipiId"));
						comboBoxBirimi.setSelectedItem(resultSet.getString("birimi"));
						textBarkod.setText(resultSet.getString("barkodu"));
						comboBoxKdvTipi.setSelectedItem(resultSet.getString("kdvTipiId"));
						textAciklama.setText(resultSet.getString("aciklama"));
						ftfTarih.setText(resultSet.getString("olusturmaTarihi"));
						
						}
					

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}


			}
		});
		btnGeri.setBounds(386, 208, 24, 22);
		panel.add(btnGeri);

		btnSon = new JButton("");
		btnSon.setIcon(new ImageIcon("C:\\Users\\emrek\\Desktop\\Yeni klasör (2)\\next (1).png"));
		btnSon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				StokDao stokDao = new StokDao();

				Connection connection = stokDao.getConnection();
				try {

					stm = connection.prepareStatement("SELECT * FROM stok3 WHERE  stok3.Id   ORDER BY Id desc LIMIT 1");
					resultSet = stm
							.executeQuery();

					if(resultSet.next()) {
					
					lblId.setText(resultSet.getString("Id"));
					textStokKodu.setText(resultSet.getString("stokKodu"));
					textStokAdi.setText(resultSet.getString("stokAdi"));
					comboBoxStokTipi.setSelectedItem(resultSet.getString("stokTipiId"));
					comboBoxBirimi.setSelectedItem(resultSet.getString("birimi"));
					textBarkod.setText(resultSet.getString("barkodu"));
					comboBoxKdvTipi.setSelectedItem(resultSet.getString("kdvTipiId"));
					textAciklama.setText(resultSet.getString("aciklama"));
					ftfTarih.setText(resultSet.getString("olusturmaTarihi"));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSon.setBounds(458, 208, 31, 23);
		panel.add(btnSon);

		btnİlk = new JButton("");
		btnİlk.setIcon(new ImageIcon("C:\\Users\\emrek\\Desktop\\Yeni klasör (2)\\left-arrow (1).png"));
		btnİlk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				StokDao stokDao = new StokDao();

				Connection connection = stokDao.getConnection();
				try {

					stm = connection.prepareStatement("SELECT * FROM stok3 WHERE stok3.Id    ORDER BY id ASC LIMIT 1");
					resultSet = stm.executeQuery();
					
					if(resultSet.next()) {

					lblId.setText(resultSet.getString("Id"));
					textStokKodu.setText(resultSet.getString("stokKodu"));
					textStokAdi.setText(resultSet.getString("stokAdi"));
					comboBoxStokTipi.setSelectedItem(resultSet.getString("stokTipiId"));
					comboBoxBirimi.setSelectedItem(resultSet.getString("birimi"));
					textBarkod.setText(resultSet.getString("barkodu"));
					comboBoxKdvTipi.setSelectedItem(resultSet.getString("kdvTipiId"));
					textAciklama.setText(resultSet.getString("aciklama"));
					ftfTarih.setText(resultSet.getString("olusturmaTarihi"));
					}

				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}

			}
		});

		btnİlk.setBounds(338, 207, 38, 23);
		panel.add(btnİlk);
		
		
		lblId.setBounds(10, 137, 16, 14);
		panel.add(lblId);

	}

	public JTextField getTextStokKodu() {
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

	public JButton getBtnKaydett() {
		return btnKaydett;
	}

	public void setBtnKaydet(JButton btnKaydet) {
		this.btnKaydett = btnKaydet;
	}

	public JButton getBtnDzenle() {
		return btnDuzenle;
	}

	public void setBtnDzenle(JButton btnDzenle) {
		this.btnDuzenle = btnDzenle;
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

	public DefaultTableModel getModel() {
		return model;
	}

	public void setModel(DefaultTableModel model) {
		this.model = model;
	}

	

	public JMenuItem getMenuStokKart() {
		return menuStokKart;
	}

	public void setMenuStokKart(JMenuItem menuStokKart) {
		this.menuStokKart = menuStokKart;
	}

	public JMenuItem getMenuStokList() {
		return menuStokList;
	}

	public void setMenuStokList(JMenuItem menuStokList) {
		this.menuStokList = menuStokList;
	}

	public JButton getBtnStokKart() {
		return btnStokKart;
	}

	public void setBtnStokKart(JButton btnStokKart) {
		this.btnStokKart = btnStokKart;
	}

	public JButton getBtnStokList() {
		return btnStokList;
	}

	public void setBtnStokList(JButton btnStokList) {
		this.btnStokList = btnStokList;
	}

	public JDesktopPane getDesktopPane() {
		return desktopPane;
	}

	public void setDesktopPane(JDesktopPane desktopPane) {
		this.desktopPane = desktopPane;
	}

	public JTextField getTextField() {
		return textStokKodu;
	}

	public void setTextField(JTextField textField) {
		this.textStokKodu = textField;
	}

	public JTextField getTextField_1() {
		return textStokAdi;
	}

	public void setTextField_1(JTextField textField_1) {
		this.textStokAdi = textField_1;
	}

	public JTextField getTextField_2() {
		return textBarkod;
	}

	public void setTextField_2(JTextField textField_2) {
		this.textBarkod = textField_2;
	}

	public JButton getBtnDuzenle() {
		return btnDuzenle;
	}

	public void setBtnDuzenle(JButton btnDuzenle) {
		this.btnDuzenle = btnDuzenle;
	}

	public JButton getBtnİlk() {
		return btnİlk;
	}

	public void setBtnİlk(JButton btnİlk) {
		this.btnİlk = btnİlk;
	}

	public JLabel getLblId() {
		return lblId;
	}

	public void setLblId(JLabel lblId) {
		this.lblId = lblId;
	}

	public void setBtnKaydett(JButton btnKaydett) {
		this.btnKaydett = btnKaydett;
	}

	public JButton getBtnNext() {
		return btnNext;
	}

	public void setBtnNext(JButton btnNext) {
		this.btnNext = btnNext;
	}

	public JButton getBtnGeri() {
		return btnGeri;
	}

	public void setBtnGeri(JButton btnGeri) {
		this.btnGeri = btnGeri;
	}

	public JButton getBtnSon() {
		return btnSon;
	}

	public void setBtnSon(JButton btnSon) {
		this.btnSon = btnSon;
	}
	
	
	
	
}
