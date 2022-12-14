package tr.com.StokKart.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import tr.com.StokKart.model.KdvTip;
import tr.com.StokKart.model.StokDao;
import tr.com.StokKart.model.StokTip;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class KdvTipKart extends JInternalFrame {
	
	private JTextField textKdvKodu;
	private JTextField textKdvAdi;
	private JTextField textKdvOrani;
	private JButton btnKaydet;
	private JButton btnSil;
	private JButton btnGuncelle;
	private ResultSet resultSet;
	private PreparedStatement stm;
	private JLabel lblid = new JLabel("");



	public KdvTipKart() {
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		lblid.setVisible(false);
		setTitle("Kdv Tip Kartı");
		setBounds(100, 100, 671, 300);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 229, 270);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lblid.setBounds(464, 15, 46, 14);
		getContentPane().add(lblid);
		
		JLabel lblKdvkodu = new JLabel("KdvKodu");
		lblKdvkodu.setBounds(10, 11, 53, 32);
		panel.add(lblKdvkodu);
		
		textKdvKodu = new JTextField();
		textKdvKodu.setColumns(10);
		textKdvKodu.setBounds(73, 17, 125, 20);
		panel.add(textKdvKodu);
		
		textKdvAdi = new JTextField();
		textKdvAdi.setColumns(10);
		textKdvAdi.setBounds(73, 57, 125, 20);
		panel.add(textKdvAdi);
		
		JLabel lblKdvAd = new JLabel("Kdv Adı");
		lblKdvAd.setBounds(10, 51, 53, 32);
		panel.add(lblKdvAd);
		
		JLabel lblKdvOran = new JLabel("Kdv Oranı");
		lblKdvOran.setBounds(10, 94, 53, 32);
		panel.add(lblKdvOran);
		
		textKdvOrani = new JTextField();
		textKdvOrani.setBounds(73, 100, 125, 20);
		panel.add(textKdvOrani);
		textKdvOrani.setColumns(10);
		
		btnKaydet = new JButton("Kaydet");
		btnKaydet.setBounds(64, 156, 89, 23);
		panel.add(btnKaydet);
		
		btnGuncelle = new JButton("Değiştir");
		btnGuncelle.setBounds(64, 224, 89, 23);
		panel.add(btnGuncelle);
		
		btnSil = new JButton("Sil");
		btnSil.setBounds(64, 190, 89, 23);
		panel.add(btnSil);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\emrek\\Desktop\\Yeni klasör (2)\\left-arrow (1).png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				StokDao stokDao = new StokDao();

				Connection connection = stokDao.getConnection();
				try {

					stm = connection.prepareStatement("SELECT * FROM kdvTip WHERE kdvTip.Id    ORDER BY id ASC LIMIT 1");
					resultSet = stm.executeQuery();
					if(resultSet.next()) {
					lblid.setText(resultSet.getString("Id"));
					textKdvKodu.setText(resultSet.getString("kdvKodu"));
					textKdvAdi.setText(resultSet.getString("kdvdAdi"));
					textKdvOrani.setText(resultSet.getString("kdvOrani"));
					}

				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}

			}
			
		});
		btnNewButton.setBounds(239, 11, 28, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnGeri = new JButton("");
		btnGeri.setIcon(new ImageIcon("C:\\Users\\emrek\\Desktop\\Yeni klasör (2)\\back-button (1).png"));
		btnGeri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StokDao stokDao = new StokDao();
				String kdvKodu = textKdvKodu.getText();
				String kdvAdi = textKdvAdi.getText();
				String id = lblid.getText();
				Connection connection = stokDao.getConnection();

				try {
					
					PreparedStatement stm = connection.prepareStatement("select * from kdvtip where Id = (select max(Id) from kdvtip where Id < '"+id+"')");
					resultSet = stm.executeQuery();
							
					if(resultSet.next()) {
						lblid.setText(resultSet.getString("Id"));
						textKdvKodu.setText(resultSet.getString("kdvKodu"));
						textKdvAdi.setText(resultSet.getString("kdvdAdi"));
						textKdvOrani.setText(resultSet.getString("kdvOrani"));
						
						
						}
					

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnGeri.setBounds(239, 87, 28, 23);
		getContentPane().add(btnGeri);
		
		JButton btnSon = new JButton("");
		btnSon.setIcon(new ImageIcon("C:\\Users\\emrek\\Desktop\\Yeni klasör (2)\\next (1).png"));
		btnSon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				StokDao stokDao = new StokDao();

				Connection connection = stokDao.getConnection();
				try {

					stm = connection.prepareStatement("SELECT * FROM kdvTip WHERE  kdvTip.Id   ORDER BY Id desc LIMIT 1");
					resultSet = stm
							.executeQuery();

					if(resultSet.next()) {
					lblid.setText(resultSet.getString("Id"));
					textKdvKodu.setText(resultSet.getString("kdvKodu"));
					textKdvAdi.setText(resultSet.getString("kdvdAdi"));
					textKdvOrani.setText(resultSet.getString("kdvOrani"));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			
			
		});
		btnSon.setBounds(239, 121, 28, 23);
		getContentPane().add(btnSon);
		
				
				
				JButton btnIleri = new JButton("");
				btnIleri.setBounds(239, 45, 28, 23);
				getContentPane().add(btnIleri);
				btnIleri.setIcon(new ImageIcon("C:\\Users\\emrek\\Desktop\\Yeni klasör (2)\\right2.png"));
				btnIleri.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						StokDao stokDao = new StokDao();
						String kdvKodu = textKdvKodu.getText();
						String kdvAdi = textKdvAdi.getText();
						String id = lblid.getText();
						Connection connection = stokDao.getConnection();

						try {
							
							stm = connection.prepareStatement(" select * from kdvtip where Id = (select min(Id) from kdvtip where Id > '"+id+"') ");
							resultSet = stm.executeQuery();
									
							if(resultSet.next()) {
								lblid.setText(resultSet.getString("Id"));
								textKdvKodu.setText(resultSet.getString("kdvKodu"));
								textKdvAdi.setText(resultSet.getString("kdvdAdi"));
								textKdvOrani.setText(resultSet.getString("kdvOrani"));
								
								
								}
							

						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}


					}
					
					
				});
		
		
		

	}

	public JTextField getTextKdvKodu() {
		return textKdvKodu;
	}

	public void setTextKdvKodu(JTextField textKdvKodu) {
		this.textKdvKodu = textKdvKodu;
	}

	public JTextField getTextKdvAdi() {
		return textKdvAdi;
	}

	public void setTextKdvAdi(JTextField textKdvAdi) {
		this.textKdvAdi = textKdvAdi;
	}

	public JTextField getTextKdvOrani() {
		return textKdvOrani;
	}

	public void setTextKdvOrani(JTextField textKdvOrani) {
		this.textKdvOrani = textKdvOrani;
	}

	public JButton getBtnKaydet() {
		return btnKaydet;
	}

	public void setBtnKaydet(JButton btnKaydet) {
		this.btnKaydet = btnKaydet;
	}

	public JButton getBtnSil() {
		return btnSil;
	}

	public void setBtnSil(JButton btnSil) {
		this.btnSil = btnSil;
	}

	public JButton getBtnGuncelle() {
		return btnGuncelle;
	}

	public void setBtnGuncelle(JButton btnGuncelle) {
		this.btnGuncelle = btnGuncelle;
	}

	public JLabel getLblid() {
		return lblid;
	}

	public void setLblid(JLabel lblid) {
		this.lblid = lblid;
	}

	
	
}
