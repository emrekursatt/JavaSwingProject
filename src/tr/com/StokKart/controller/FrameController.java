package tr.com.StokKart.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import tr.com.StokKart.model.KdvTip;
import tr.com.StokKart.model.StokKart;
import tr.com.StokKart.model.StokTip;
import tr.com.StokKart.view.MainFrame;
import tr.com.StokKart.view.StokKartViews;
import tr.com.StokKart.view.StokList;
import tr.com.StokKart.view.StokTipKart;

class FrameController {


	private MainFrame mainFrame;
	public StokKartViews stokKartViews;
	public StokList stokList;
	private StokTip stokTip;

	public FrameController() {

		mainFrame = new MainFrame();

		mainFrame.getMenuStokTip().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				StokTipKartFrameController stokTipKartFrameController = new StokTipKartFrameController(mainFrame);
				stokTipKartFrameController.execute();

			}
		});

		mainFrame.getMenuKdvTip().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				KdvTipKartFrameController kdvTipKartFrameController = new KdvTipKartFrameController(mainFrame);
				kdvTipKartFrameController.execute();

			}

		});

		mainFrame.getMenuStokList().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				StokListController stokListController = new StokListController(mainFrame);
				stokListController.execute();

			}
		});

		mainFrame.getMenuStokKart().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				StokKartViewsController stokKartViewsController = new StokKartViewsController(mainFrame);
				stokKartViewsController.execute();

			}
			
		});

		mainFrame.setVisible(true);

	}

	public static void main(String[] args) {
		
		
		new FrameController();
		

	}

}
