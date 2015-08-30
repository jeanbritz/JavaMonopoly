package com.monopoly.views;


import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import com.monopoly.AssetLoader;
import com.monopoly.models.Property;
import com.monopoly.models.Property.Tariff;

public class PropertyCardDialog extends AbstractDialog<Object> {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Icon imageHouseCost = new ImageIcon("house.png");
	
	JLabel labelPropertyType = new JLabel("Property Type");
	JLabel labelPropertyCost = new JLabel("Property Cost");
	
	JLabel labelHouseCost = new JLabel("Cost of house");
	
	JLabel labelHeader;
	JLabel labelBody;
	JTable tableTariffs;
	JButton buttonClose;
	
	Property property;
	
	public PropertyCardDialog() {
		super();
		
		setTitle("Monopoly");
		setBounds(70, 70, 270, 300);
		getBodyPanel().setBackground(Color.WHITE);
		getFooterPanel().setBackground(Color.WHITE);
		
		
	}
		
	public void onCloseClick() {
		dispose();
	}

	@Override
	public void setData(Object data) {
		property = (Property)data;
		String body = "";
		labelHeader.setText(property.getName() + " " + property.getType());
		getHeaderPanel().setBackground(property.getColour());
		labelBody.setText("R " + property.getHouseCost());
		tableTariffs.setModel(property.getTariffTableModel());
		
	}

	
	@Override
	public void initView() {
		labelHeader = new JLabel("Header");
		labelHeader.setFont(AssetLoader.loadFont("h2"));
		labelHeader.setVerticalAlignment(JLabel.CENTER);
		labelHeader.setHorizontalAlignment(JLabel.CENTER);
		
		labelBody = new JLabel("Body");
		labelBody.setFont(AssetLoader.loadFont("body"));
		labelBody.setVerticalAlignment(JLabel.CENTER);
		buttonClose = new JButton("Close");
		
		tableTariffs = new JTable();
		tableTariffs.setGridColor(Color.white);
		
		getHeaderPanel().add(labelHeader);
		
		//getBodyPanel().add(labelBody);
		getBodyPanel().add(tableTariffs);
		
		getFooterPanel().add(buttonClose);
		
		buttonClose.addActionListener(this);
		
		
	}
	
	@Override
	public void updateView() {
				
	}
	
	/**
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource().equals(buttonClose)) {
			onCloseClick();
		}
	}

}