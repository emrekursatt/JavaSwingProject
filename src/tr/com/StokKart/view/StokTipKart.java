package tr.com.StokKart.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import tr.com.StokKart.controller.StokTipKartFrameController;
import tr.com.StokKart.model.KdvTip;
import tr.com.StokKart.model.StokDao;
import tr.com.StokKart.model.StokTip;

import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class StokTipKart extends JInternalFrame {
	
	private JTextField textStokTipKodu;
	private JTextField textStokTipAdi;
	private JTextArea textStokTipAciklama;
	private JButton btnSil;
	private JButton btnKaydet;
	private JButton btnDegistir;
	private ResultSet resultSet;
	private Statement statement;
	private JLabel lblId = new JLabel("");


	
	public StokTipKart() {
		setTitle("Stok Tip Kartı");
		setToolTipText("");
		setClosable(true);
		lblId.setVisible(false);
		setMaximizable(true);
		setIconifiable(true);
		setBounds(100, 100, 671, 300);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 227, 274);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Stok Kodu");
		lblNewLabel.setBounds(10, 11, 53, 32);
		panel.add(lblNewLabel);
		
		JLabel lblAklama = new JLabel("Açıklama");
		lblAklama.setBounds(10, 94, 53, 32);
		panel.add(lblAklama);
		
		JLabel lblStokAd = new JLabel("Stok Adı");
		lblStokAd.setBounds(10, 51, 53, 32);
		panel.add(lblStokAd);
		
		textStokTipKodu = new JTextField();
		textStokTipKodu.setBounds(73, 17, 125, 20);
		panel.add(textStokTipKodu);
		textStokTipKodu.setColumns(10);
		
		textStokTipAdi = new JTextField();
		textStokTipAdi.setColumns(10);
		textStokTipAdi.setBounds(73, 57, 125, 20);
		panel.add(textStokTipAdi);
		
		btnSil = new JButton("Sil");
	
		btnSil.setBounds(109, 209, 89, 23);
		panel.add(btnSil);
		
		
		
		btnDegistir = new JButton("Değiştir");
		btnDegistir.setBounds(10, 243, 89, 23);
		panel.add(btnDegistir);
		
		btnKaydet = new JButton("Kaydet");
		btnKaydet.setBounds(10, 209, 89, 23);
		panel.add(btnKaydet);
		
		textStokTipAciklama = new JTextArea();
		textStokTipAciklama.setBounds(73, 103, 125, 79);
		panel.add(textStokTipAciklama);
		
		
		lblId.setBounds(17, 141, 46, 14);
		panel.add(lblId);
		
		JButton btnİlk = new JButton("");
		btnİlk.setIcon(new ImageIcon("C:\\Users\\emrek\\Desktop\\Yeni klasör (2)\\left-arrow (1).png"));
		
		
		
		
		
		
		
		
		
		
		
		btnİlk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				StokDao stokDao = new StokDao();

				Connection connection = stokDao.getConnection();
				try {

					statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
					resultSet = statement.executeQuery("SELECT * FROM stokTip WHERE stokTip.Id    ORDER BY id ASC LIMIT 1");

					if(resultSet.next()) {
					lblId.setText(resultSet.getString("Id"));
					textStokTipKodu.setText(resultSet.getString("stokTipKodu"));
					textStokTipAdi.setText(resultSet.getString("stokTipAdi"));
					textStokTipAciklama.setText(resultSet.getString("stokTipaciklama"));
					
					}
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
			}
		});
		btnİlk.setBounds(233, 19, 35, 23);
		getContentPane().add(btnİlk);
		
		JButton btnIleri = new JButton("");
		btnIleri.setIcon(new ImageIcon("C:\\Users\\emrek\\Desktop\\Yeni klasör (2)\\right2.png"));
		btnIleri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				StokDao stokDao = new StokDao();
				String stokTipKodu = textStokTipKodu.getText();
				String stokTipAdi = textStokTipAdi.getText();
				String id = lblId.getText();
				Connection connection = stokDao.getConnection();

				try {
					
					PreparedStatement stm = connection.prepareStatement(" select * from stoktip where Id = (select min(Id) from stoktip where Id > '"+id+"') ");
					resultSet = stm.executeQuery();
							
					if(resultSet.next()) {
						lblId.setText(resultSet.getString("Id"));
						textStokTipKodu.setText(resultSet.getString("stokTipKodu"));
						textStokTipAdi.setText(resultSet.getString("stokTipAdi"));
						textStokTipAciklama.setText(resultSet.getString("stokTipaciklama"));
						
						
						}
					

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnIleri.setBounds(233, 53, 35, 23);
		getContentPane().add(btnIleri);
		
		JButton btnGeri = new JButton("");
		btnGeri.setIcon(new ImageIcon("C:\\Users\\emrek\\Desktop\\Yeni klasör (2)\\back-button (1).png"));
		btnGeri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				StokDao stokDao = new StokDao();
				String stokTipKodu = textStokTipKodu.getText();
				String stokTipAdi = textStokTipAdi.getText();
				String id = lblId.getText();
				Connection connection = stokDao.getConnection();

				try {
					
					PreparedStatement stm = connection.prepareStatement(" select * from stoktip where Id = (select max(Id) from stoktip where Id < '"+id+"') ");
					resultSet = stm.executeQuery();
							
					if(resultSet.next()) {
						lblId.setText(resultSet.getString("Id"));
						textStokTipKodu.setText(resultSet.getString("stokTipKodu"));
						textStokTipAdi.setText(resultSet.getString("stokTipAdi"));
						textStokTipAciklama.setText(resultSet.getString("stokTipaciklama"));
						
						
						}
					

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnGeri.setBounds(233, 87, 35, 23);
		getContentPane().add(btnGeri);
		
		JButton btnSon = new JButton("");
		btnSon.setIcon(new ImageIcon("C:\\Users\\emrek\\Desktop\\Yeni klasör (2)\\next (1).png"));
		btnSon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				StokDao stokDao = new StokDao();

				Connection connection = stokDao.getConnection();
				try {

					statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
					resultSet = statement.executeQuery("SELECT * FROM stokTip WHERE stokTip.Id    ORDER BY id desc LIMIT 1");

					if(resultSet.next()) {
						lblId.setText(resultSet.getString("Id"));
					textStokTipKodu.setText(resultSet.getString("stokTipKodu"));
					textStokTipAdi.setText(resultSet.getString("stokTipAdi"));
					textStokTipAciklama.setText(resultSet.getString("stokTipaciklama"));
					}

				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				
			}
		});
		btnSon.setBounds(233, 121, 35, 23);
		getContentPane().add(btnSon);

	}

	

	public JTextField getTextStokTipKodu() {
		return textStokTipKodu;
	}

	public void setTextStokTipKodu(JTextField textStokTipKodu) {
		this.textStokTipKodu = textStokTipKodu;
	}

	public JTextField getTextStokTipAdi() {
		return textStokTipAdi;
	}

	public void setTextStokTipAdi(JTextField textStokTipAdi) {
		this.textStokTipAdi = textStokTipAdi;
	}

	public JTextArea getTextStokTipAciklama() {
		return textStokTipAciklama;
	}

	public void setTextStokTipAciklama(JTextArea textStokTipAciklama) {
		this.textStokTipAciklama = textStokTipAciklama;
	}

	public JButton getBtnSil() {
		return btnSil;
	}

	public void setBtnSil(JButton btnSil) {
		this.btnSil = btnSil;
	}

	public JButton getBtnKaydet() {
		return btnKaydet;
	}

	public void setBtnKaydet(JButton btnKaydet) {
		this.btnKaydet = btnKaydet;
	}

	public JButton getBtnDegistir() {
		return btnDegistir;
	}

	public void setBtnDegistir(JButton btnDegistir) {
		this.btnDegistir = btnDegistir;
	}

	public JLabel getLblId() {
		return lblId;
	}

	public void setLblId(JLabel lblId) {
		this.lblId = lblId;
	}
	
	
}
