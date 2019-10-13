package org.backery.mainapp;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.log4j.Level;
import org.backery.common.BackeryException;
import org.backery.common.BackeryLogger;
import org.backery.dao.DataImplementation;
import org.backery.dao.DataSourceService;
import org.backery.entity.Item;
import org.backery.utils.ReadDataFromPropertiesFile;
import org.backery.utils.BackeryUtils;
import org.backery.utils.WriteDataFromGuiToPropertiesFile;

/**
 * Main Class for the Application.
 *  
 * This class contains the code for UI components made out of swing. Also the
 * action/events which are associated with the components.
 *  
 * 
 * @author esxxbhs
 *
 */
public class MainApp {

	static Map<Integer, Integer> data = new LinkedHashMap();
	static Map<String, Item> receivedList;

	static String output = "";

	static DataSourceService ds = new DataImplementation();

	private static javax.swing.JPanel addItemPanel;
	private static javax.swing.JTextArea inventoryTextArea;
	private static javax.swing.JLabel itemCode;
	private static javax.swing.JLabel itemCodeLabelAI;
	private static javax.swing.JTextField itemCodeTextBoxAI;
	private static javax.swing.JLabel itemName;
	private static javax.swing.JLabel itemNameLabelAI;
	private static javax.swing.JTextField itemNameTextBoxAI;
	private static javax.swing.JLabel itemNameValue;
	private static javax.swing.JComboBox<String> itemsComboBox;
	private static javax.swing.JButton addButton;
	private static javax.swing.JLabel jLabel1;
	private static javax.swing.JLabel jLabel10;
	private static javax.swing.JLabel jLabel11;
	private static javax.swing.JLabel jLabel13;
	private static javax.swing.JLabel jLabel14;
	private static javax.swing.JLabel jLabel15;
	private static javax.swing.JLabel jLabel16;
	private static javax.swing.JLabel jLabel17;
	private static javax.swing.JLabel jLabel18;
	private static javax.swing.JLabel jLabel2;
	private static javax.swing.JLabel jLabel6;
	private static javax.swing.JMenu jMenu1;
	private static javax.swing.JMenu jMenu2;
	private static javax.swing.JMenuBar jMenuBar1;
	private static javax.swing.JPanel jPanel1;
	private static javax.swing.JPanel jPanel2;
	private static javax.swing.JScrollPane jScrollPane1;
	private static javax.swing.JScrollPane jScrollPane2;
	private static javax.swing.JTextField packQuantityTextBox;
	private static javax.swing.JTextField packAmountTextBox;
	private static javax.swing.JTextField jTextField5;
	private static javax.swing.JTextField jTextField6;
	private static javax.swing.JTextField jTextField7;
	private static javax.swing.JTextField jTextField8;
	private static javax.swing.JButton orderButton;
	private static javax.swing.JPanel orderPanel;
	private static javax.swing.JTextArea outputTrextArea;
	private static javax.swing.JPanel packsPanel;
	private static javax.swing.JButton processButton;
	private static javax.swing.JComboBox<String> quantityComboBox;
	private static javax.swing.JLabel quantityLabel;
	private static javax.swing.JLabel remarksLabel;
	private static javax.swing.JButton viewInventoryButton;
	private static javax.swing.JPanel viewInventoryPanel;
	private static javax.swing.JTabbedPane viewItemsTab;

	static Map<String, String> loadItemName = new HashMap();

	public static void main(String[] args) {

		try {
			BackeryLogger.log(Level.INFO, "Bakery Application is getting initiated ... ");
			if (args.length == 0) {
				BackeryLogger.log(Level.INFO, "Launching GUI");
				MainApp mainApp = new MainApp();
				mainApp.initComponents();
			} else {
				BackeryLogger.log(Level.INFO, "Launching Command Line Mode");
				receivedList = ds.getAllData();
				String output = new BackeryUtils().processInput(receivedList, args[0], Integer.parseInt(args[1]), data);
				BackeryLogger.log(Level.INFO, "Packing Information " + output);
			}
		} catch (BackeryException e) {
			BackeryLogger.log(Level.ERROR, "Unable to initialize Bakery Application " + e.getMessage());
		}
	}

	/**
	 * initialize the components.
	 */
	private static void initComponents() {

		final ReadDataFromPropertiesFile readData = new ReadDataFromPropertiesFile();
		Map<String, String> data = readData.getPropertiesFileData();
		final StringBuilder inventoryData = new StringBuilder();

		BackeryLogger.log(Level.INFO, " Getting initialized ...");
		if (data.isEmpty()) {
			BackeryLogger.log(Level.ERROR,
					" Properties object/ Bakery Inventory Data not loaded. Closing the Application");
			System.exit(0);
		}

		loadItemName = new BackeryUtils().getItemName(data);
		JFrame mainFrame = new JFrame();

		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel17 = new javax.swing.JLabel();
		jLabel18 = new javax.swing.JLabel();
		jPanel2 = new javax.swing.JPanel();
		viewItemsTab = new javax.swing.JTabbedPane();
		orderPanel = new javax.swing.JPanel();
		itemName = new javax.swing.JLabel();
		itemsComboBox = new javax.swing.JComboBox();
		itemCode = new javax.swing.JLabel();
		itemNameValue = new javax.swing.JLabel();
		quantityLabel = new javax.swing.JLabel();
		quantityComboBox = new javax.swing.JComboBox();
		processButton = new javax.swing.JButton();
		remarksLabel = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		outputTrextArea = new javax.swing.JTextArea();
		orderButton = new javax.swing.JButton();
		addItemPanel = new javax.swing.JPanel();
		itemNameLabelAI = new javax.swing.JLabel();
		itemNameTextBoxAI = new javax.swing.JTextField();
		itemCodeLabelAI = new javax.swing.JLabel();
		itemCodeTextBoxAI = new javax.swing.JTextField();
		packsPanel = new javax.swing.JPanel();
		jLabel10 = new javax.swing.JLabel();
		packQuantityTextBox = new javax.swing.JTextField();
		jLabel11 = new javax.swing.JLabel();
		packAmountTextBox = new javax.swing.JTextField();
		jLabel13 = new javax.swing.JLabel();
		jLabel14 = new javax.swing.JLabel();
		jLabel15 = new javax.swing.JLabel();
		jLabel16 = new javax.swing.JLabel();
		jTextField5 = new javax.swing.JTextField();
		jTextField6 = new javax.swing.JTextField();
		jTextField7 = new javax.swing.JTextField();
		jTextField8 = new javax.swing.JTextField();
		addButton = new javax.swing.JButton();
		viewInventoryPanel = new javax.swing.JPanel();
		viewInventoryButton = new javax.swing.JButton();
		jScrollPane2 = new javax.swing.JScrollPane();
		inventoryTextArea = new javax.swing.JTextArea();
		jMenuBar1 = new javax.swing.JMenuBar();
		jMenu1 = new javax.swing.JMenu();
		jMenu2 = new javax.swing.JMenu();

		mainFrame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		mainFrame.setTitle("Backery - Application");
		mainFrame.setResizable(false);

		jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Operation"));

		jLabel1.setText("Backery logo");
		jLabel2.setText("Username");
		jLabel6.setText("Last Login Time");
		jLabel17.setText("Tom"); 
		jLabel18.setText("09.30 06-10-2019");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup()
								.addGroup(jPanel1Layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(jPanel1Layout
												.createSequentialGroup().addContainerGap().addComponent(jLabel1,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGroup(jPanel1Layout.createSequentialGroup()
												.addGroup(jPanel1Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabel18).addComponent(jLabel6)
														.addComponent(jLabel2).addComponent(jLabel17))
												.addGap(0, 0, Short.MAX_VALUE)))
								.addContainerGap()));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
						.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(67, 67, 67).addComponent(jLabel2)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel17)
						.addGap(21, 21, 21).addComponent(jLabel6)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jLabel18)
						.addGap(0, 309, Short.MAX_VALUE)));

		mainFrame.getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_START);

		jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Details"));
		jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

		viewItemsTab.setName("Order"); // NOI18N

		orderPanel.setLayout(null);

		itemName.setText("Itemname");
		orderPanel.add(itemName);
		itemName.setBounds(40, 80, 90, 20);

		Set<String> s1 = data.keySet();
		List<String> l1 = new ArrayList(s1);
		itemsComboBox.setModel(new javax.swing.DefaultComboBoxModel(l1.toArray()));
		orderPanel.add(itemsComboBox);
		itemsComboBox.setBounds(150, 40, 180, 26);
		itemsComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

				JComboBox cb = (JComboBox) e.getSource();
				Object item = e.getItem();
				String itemCode;
				if (e.getStateChange() == ItemEvent.SELECTED) {
					if (loadItemName.containsKey(item.toString())) {
						itemNameValue.setText(loadItemName.get(item.toString()));
					}
				}
			}
		});

		itemCode.setText("Itemcode");
		orderPanel.add(itemCode);
		itemCode.setBounds(40, 40, 66, 20);
		orderPanel.add(itemNameValue);
		itemNameValue.setBounds(150, 80, 390, 20);

		quantityLabel.setText("Quantity");
		orderPanel.add(quantityLabel);
		quantityLabel.setBounds(40, 120, 60, 20);

		quantityComboBox.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
		orderPanel.add(quantityComboBox);
		quantityComboBox.setBounds(150, 116, 180, 26);

		processButton.setText("Process");
		processButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {

				try {
					if (itemNameValue.getText().isEmpty()) {
						JOptionPane.showMessageDialog(itemNameValue, "Itemname is empty, Select any Itemcode");
					} else {
						receivedList = ds.getAllData();
						output = new BackeryUtils().processInput(receivedList, itemsComboBox.getSelectedItem().toString(),
								Integer.parseInt(quantityComboBox.getSelectedItem().toString()), MainApp.data);
						BackeryLogger.log(Level.DEBUG,
								"Selected Item Code - " + itemsComboBox.getSelectedItem().toString());
						BackeryLogger.log(Level.DEBUG,
								"Selected Quantity for the Item - " + quantityComboBox.getSelectedItem().toString());

						outputTrextArea.setText(output);
					}
				} catch (BackeryException e) {
					BackeryLogger.log(Level.ERROR, "Unable to find the pack match " + e.getMessage());
				}
			}
		});
		orderPanel.add(processButton);
		processButton.setBounds(150, 170, 85, 29);

		remarksLabel.setText("Remarks");
		orderPanel.add(remarksLabel);
		remarksLabel.setBounds(40, 230, 61, 20);

		outputTrextArea.setColumns(20);
		outputTrextArea.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
		outputTrextArea.setRows(5);
		jScrollPane1.setViewportView(outputTrextArea);

		orderPanel.add(jScrollPane1);
		jScrollPane1.setBounds(150, 220, 390, 200);

		orderButton.setText("Order");
		orderPanel.add(orderButton);
		orderButton.setBounds(383, 440, 150, 29);

		viewItemsTab.addTab("Order", orderPanel);

		itemNameLabelAI.setText("Itemname");

		itemCodeLabelAI.setText("Itemcode");

		packsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Pack - Size (Integer) and Amount (Float)"));

		jLabel10.setText("Pack size");

		jLabel11.setText("Pack cost");

		jLabel13.setText("Pack size");

		jLabel14.setText("Pack cost");

		jLabel15.setText("Pack size");

		jLabel16.setText("Pack cost");

		javax.swing.GroupLayout packsPanelLayout = new javax.swing.GroupLayout(packsPanel);
		packsPanel.setLayout(packsPanelLayout);
		packsPanelLayout
				.setHorizontalGroup(packsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(packsPanelLayout.createSequentialGroup().addGap(41, 41, 41).addGroup(packsPanelLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel11)
								.addGroup(packsPanelLayout.createSequentialGroup().addGroup(packsPanelLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(packsPanelLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(jLabel16).addComponent(jLabel15).addComponent(jLabel14)
												.addComponent(jLabel13))
										.addComponent(jLabel10)).addGap(34, 34, 34)
										.addGroup(packsPanelLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addComponent(packQuantityTextBox, javax.swing.GroupLayout.DEFAULT_SIZE,
														101, Short.MAX_VALUE)
												.addComponent(packAmountTextBox).addComponent(jTextField5)
												.addComponent(jTextField6).addComponent(jTextField7)
												.addComponent(jTextField8))))
								.addContainerGap(63, Short.MAX_VALUE)));
		packsPanelLayout.setVerticalGroup(packsPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(packsPanelLayout.createSequentialGroup().addContainerGap()
						.addGroup(packsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(packQuantityTextBox, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel10))
						.addGap(19, 19, 19)
						.addGroup(packsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(packAmountTextBox, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel11))
						.addGap(24, 24, 24)
						.addGroup(packsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel13)
								.addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(packsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel14)
								.addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(22, 22, 22)
						.addGroup(packsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel15).addComponent(jTextField7,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(packsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel16).addComponent(jTextField8,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(33, Short.MAX_VALUE)));

		addButton.setText("Add");
		addButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				StringBuilder dataToAddInPropertiesFile = new StringBuilder();
				String itemCode = itemCodeTextBoxAI.getText();
				String itemName = itemNameTextBoxAI.getText();

				String packSize1Quantity = packQuantityTextBox.getText();
				String packSize1Cost = packAmountTextBox.getText();

				if (itemCode.isEmpty() || itemName.isEmpty() || packSize1Quantity.isEmpty()
						|| packSize1Cost.isEmpty()) {
					JOptionPane.showMessageDialog(addButton, "ItemCode, ItemName and one set of pack is mandatory",
							"Insufficient Details", JOptionPane.INFORMATION_MESSAGE);
				}

				else if (checkSizeAndCostOfPack(packSize1Quantity, packSize1Cost)) {
					dataToAddInPropertiesFile.append("itemcode=" + itemCode);
					dataToAddInPropertiesFile.append(System.lineSeparator());
					dataToAddInPropertiesFile.append("itemname=" + itemName);
					dataToAddInPropertiesFile.append(System.lineSeparator());

					// convert amount to float and write it to file.
					dataToAddInPropertiesFile.append(
							"pack=" + packSize1Quantity + "-" + String.valueOf(Float.parseFloat(packSize1Cost)));
					WriteDataFromGuiToPropertiesFile obj = new WriteDataFromGuiToPropertiesFile(
							dataToAddInPropertiesFile);
					obj.writeDataToPropertiesFile();
					JOptionPane.showMessageDialog(addButton, "Details Added Successfully");
				} else {
					JOptionPane.showMessageDialog(addButton, "Either Quantity or Price of the Quantity in Invalid");
				}
				
				itemCodeTextBoxAI.setText("");
				itemNameTextBoxAI.setText("");
				packQuantityTextBox.setText("");
				packAmountTextBox.setText("");

			}

			/**
			 * To check whether the given input(quantity and price) from the gui correct or
			 * not.
			 * 
			 * @param packSize1Quantity
			 * @param packSize1Cost
			 * @return
			 */
			private boolean checkSizeAndCostOfPack(String packSize1Quantity, String packSize1Cost) {

				try {
					Integer.parseInt(packSize1Quantity);
					Float.parseFloat(packSize1Cost);
					return true;
				} catch (NumberFormatException e) {
					BackeryLogger.log(Level.ERROR, "Quantity should be of Integer and Price should be of Float");
					BackeryLogger.log(Level.ERROR, "Either Quantity - " + packSize1Quantity + " or Cost - "
							+ packSize1Cost + " of the Item is invalid");
				}
				return false;
			}
		});

		javax.swing.GroupLayout addItemPanelLayout = new javax.swing.GroupLayout(addItemPanel);
		addItemPanel.setLayout(addItemPanelLayout);
		addItemPanelLayout.setHorizontalGroup(addItemPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addItemPanelLayout.createSequentialGroup()
						.addGap(46, 46, 46)
						.addGroup(addItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(addItemPanelLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addComponent(addButton).addComponent(packsPanel,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(addItemPanelLayout.createSequentialGroup()
										.addGroup(addItemPanelLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(itemNameLabelAI).addComponent(itemCodeLabelAI))
										.addGap(35, 35, 35)
										.addGroup(addItemPanelLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addComponent(itemNameTextBoxAI, javax.swing.GroupLayout.DEFAULT_SIZE,
														182, Short.MAX_VALUE)
												.addComponent(itemCodeTextBoxAI))))
						.addContainerGap(241, Short.MAX_VALUE)));
		addItemPanelLayout.setVerticalGroup(addItemPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(addItemPanelLayout.createSequentialGroup().addGap(23, 23, 23)
						.addGroup(addItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(itemCodeTextBoxAI, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(itemCodeLabelAI))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(addItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(itemNameLabelAI)
								.addComponent(itemNameTextBoxAI, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(25, 25, 25)
						.addComponent(packsPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(addButton)
						.addGap(43, 43, 43)));

		viewItemsTab.addTab("Add Item", addItemPanel);

		viewInventoryButton.setText("View Inventory");
		viewInventoryButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				inventoryData.setLength(0);
				Map<String, String> propertiesFiledData = readData.getPropertiesFileData();
				for (Map.Entry<String, String> mapData : propertiesFiledData.entrySet()) {
					inventoryData.append(mapData.getValue().toString());
					inventoryData.append(System.lineSeparator());
					inventoryData.append(System.lineSeparator());
				}
				inventoryTextArea.setText(inventoryData.toString());
			}
		});

		inventoryTextArea.setColumns(20);
		inventoryTextArea.setRows(5);
		// inventoryTextArea.setText(inventoryData.toString());
		jScrollPane2.setViewportView(inventoryTextArea);

		javax.swing.GroupLayout viewInventoryPanelLayout = new javax.swing.GroupLayout(viewInventoryPanel);
		viewInventoryPanel.setLayout(viewInventoryPanelLayout);
		viewInventoryPanelLayout.setHorizontalGroup(viewInventoryPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(viewInventoryPanelLayout.createSequentialGroup().addGap(53, 53, 53)
						.addGroup(viewInventoryPanelLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 514,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(viewInventoryButton))
						.addContainerGap(36, Short.MAX_VALUE)));
		viewInventoryPanelLayout
				.setVerticalGroup(
						viewInventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(viewInventoryPanelLayout.createSequentialGroup().addGap(39, 39, 39)
										.addComponent(viewInventoryButton)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 422,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(24, Short.MAX_VALUE)));

		viewItemsTab.addTab("View Items", viewInventoryPanel);

		jPanel2.add(viewItemsTab);

		mainFrame.getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

		jMenu1.setText("File");
		jMenuBar1.add(jMenu1);

		jMenu2.setText("Edit");
		jMenuBar1.add(jMenu2);

		mainFrame.setJMenuBar(jMenuBar1);

		mainFrame.pack();

		// For now, lets limit to only one set of pack to be added at a time.
		jTextField5.setEditable(false);
		jTextField6.setEditable(false);
		jTextField7.setEditable(false);
		jTextField8.setEditable(false);

		// Center the GUI in the Screen.
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - mainFrame.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - mainFrame.getHeight()) / 2);
		mainFrame.setLocation(x, y);

		// Make the screen visible.
		mainFrame.setVisible(true);
	}
}