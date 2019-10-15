package org.backery.mainapp;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

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

	private static JPanel addItemPanel;
	private static JTextArea inventoryTextArea;
	private static JLabel itemCode;
	private static JLabel itemCodeLabelAI;
	private static JTextField itemCodeTextBoxAI;
	private static JLabel itemName;
	private static JLabel exampleFormat;
	private static JLabel itemNameLabelAI;
	private static JTextField itemNameTextBoxAI;
	private static JLabel itemNameValue;
	private static JComboBox<String> itemsComboBox;
	private static JButton addButton;
	private static JLabel jLabel1;
	private static JLabel jLabel10;
	private static JLabel jLabel11;
	private static JLabel jLabel13;
	private static JLabel jLabel14;
	private static JLabel jLabel15;
	private static JLabel jLabel16;
	private static JLabel jLabel17;
	private static JLabel jLabel18;
	private static JLabel jLabel2;
	private static JLabel jLabel6;
	private static javax.swing.JMenu jMenu1;
	private static javax.swing.JMenuBar jMenuBar1;
	private static javax.swing.JMenuItem exitMenu;
	private static JPanel mainPanel;
	private static JPanel jPanel2;
	private static javax.swing.JScrollPane jScrollPane1;
	private static javax.swing.JScrollPane jScrollPane2;
	private static JTextField packQuantityTextBox;
	private static JTextField packAmountTextBox;
	private static JTextField packQuantity2TextBox;
	private static JTextField packAmount2TextBox;
	private static JTextField packQuantity3TextBox;
	private static JTextField packAmount3TextBox;
	private static JButton orderButton;
	private static JPanel orderPanel;
	private static JTextArea outputTextArea;
	private static JPanel packsPanel;
	private static JButton processButton;
	private static JComboBox<String> quantityComboBox;
	private static JLabel quantityLabel;
	private static JLabel outputLabel;
	private static JButton viewInventoryButton;
	private static JPanel viewInventoryPanel;
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
				Scanner scanner = new Scanner(System.in);
				System.out.println("Enter the ItemCode : ");
				String itemCode = scanner.next();
				System.out.println("Enter the Required No of Quantities : ");
				int itemQuantity = scanner.nextInt();
				String output = new BackeryUtils().processInput(receivedList, itemCode, itemQuantity, data);
				System.out.println("Packing Information (Box Capacity * Quantity) is  " + output);
				BackeryLogger.log(Level.INFO, "Packing Information (Box Capacity * Quantity) " + output);
				BackeryLogger.log(Level.INFO, "Closing the application ");
			}
		} catch (BackeryException e) {
			BackeryLogger.log(Level.ERROR, "Unable to initialize Bakery Application " + e.getMessage());
		} catch (InputMismatchException e) {
			System.out.println(" Input mismatch, ItemCode Should be type STRING and Item Quantity Should be of type INTEGER");
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

		mainPanel = new JPanel();
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		jLabel6 = new JLabel();
		jLabel17 = new JLabel();
		jLabel18 = new JLabel();
		jPanel2 = new JPanel();
		viewItemsTab = new javax.swing.JTabbedPane();
		orderPanel = new JPanel();
		itemName = new JLabel();
		itemsComboBox = new JComboBox();
		itemCode = new JLabel();
		itemNameValue = new JLabel();
		quantityLabel = new JLabel();
		exampleFormat = new JLabel();
		quantityComboBox = new JComboBox();
		processButton = new JButton();
		outputLabel = new JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		outputTextArea = new JTextArea();
		orderButton = new JButton();
		addItemPanel = new JPanel();
		itemNameLabelAI = new JLabel();
		itemNameTextBoxAI = new JTextField();
		itemCodeLabelAI = new JLabel();
		itemCodeTextBoxAI = new JTextField();
		packsPanel = new JPanel();
		jLabel10 = new JLabel();
		packQuantityTextBox = new JTextField();
		jLabel11 = new JLabel();
		packAmountTextBox = new JTextField();
		jLabel13 = new JLabel();
		jLabel14 = new JLabel();
		jLabel15 = new JLabel();
		jLabel16 = new JLabel();
		packQuantity2TextBox = new JTextField();
		packAmount2TextBox = new JTextField();
		packQuantity3TextBox = new JTextField();
		packAmount3TextBox = new JTextField();
		addButton = new JButton();
		viewInventoryPanel = new JPanel();
		viewInventoryButton = new JButton();
		jScrollPane2 = new javax.swing.JScrollPane();
		inventoryTextArea = new JTextArea();
		jMenuBar1 = new javax.swing.JMenuBar();
		jMenu1 = new javax.swing.JMenu();
		exitMenu = new javax.swing.JMenuItem();

		mainFrame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		mainFrame.setTitle("Backery - Application");
		mainFrame.setResizable(false);

		mainPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Operation"));

		jLabel1.setText("Backery logo");
		jLabel2.setText("Username");
		jLabel6.setText("Last Login Time");
		jLabel17.setText("Tom");
		jLabel18.setText("09.30 06-10-2019");

		exitMenu.setText("Exit");
		exitMenu.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				System.exit(0);
			}
		});
		jMenu1.add(exitMenu);

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(mainPanel);
		mainPanel.setLayout(jPanel1Layout);
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

		mainFrame.getContentPane().add(mainPanel, java.awt.BorderLayout.LINE_START);

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
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14" }));
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
						output = new BackeryUtils().processInput(receivedList,
								itemsComboBox.getSelectedItem().toString(),
								Integer.parseInt(quantityComboBox.getSelectedItem().toString()), MainApp.data);
						BackeryLogger.log(Level.DEBUG,
								"Selected Item Code - " + itemsComboBox.getSelectedItem().toString());
						BackeryLogger.log(Level.DEBUG,
								"Selected Quantity for the Item - " + quantityComboBox.getSelectedItem().toString());

						outputTextArea.setText(output);
					}
				} catch (BackeryException e) {
					BackeryLogger.log(Level.ERROR, "Unable to find the pack match " + e.getMessage());
				}
			}
		});

		exampleFormat.setText("Pack Size * No of Packs ");
		exampleFormat.setBounds(150, 190, 145, 29);
		orderPanel.add(exampleFormat);

		orderPanel.add(processButton);
		processButton.setBounds(150, 160, 85, 29);

		outputLabel.setText("Pack & Cost");
		orderPanel.add(outputLabel);
		outputLabel.setBounds(40, 230, 71, 20);

		outputTextArea.setColumns(20);
		outputTextArea.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18)); // NOI18N
		outputTextArea.setRows(5);
		jScrollPane1.setViewportView(outputTextArea);

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
												.addComponent(packAmountTextBox).addComponent(packQuantity2TextBox)
												.addComponent(packAmount2TextBox).addComponent(packQuantity3TextBox)
												.addComponent(packAmount3TextBox))))
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
								.addComponent(packQuantity2TextBox, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(packsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel14)
								.addComponent(packAmount2TextBox, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(22, 22, 22)
						.addGroup(packsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel15).addComponent(packQuantity3TextBox,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(packsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel16).addComponent(packAmount3TextBox,
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

				String packSize2Quantity = packQuantity2TextBox.getText();
				String packSize2Cost = packAmount2TextBox.getText();

				String packSize3Quantity = packQuantity3TextBox.getText();
				String packSize3Cost = packAmount3TextBox.getText();

				List<String> quantityList = new ArrayList();
				List<String> costList = new ArrayList();

				quantityList.add(packSize1Quantity);
				quantityList.add(packSize2Quantity);

				costList.add(packSize1Cost);
				costList.add(packSize2Cost);

				if (itemCode.isEmpty() || itemName.isEmpty() || packSize1Quantity.isEmpty() || packSize1Cost.isEmpty()
						|| packSize2Quantity.isEmpty() || packSize2Cost.isEmpty()) {
					JOptionPane.showMessageDialog(addButton, "ItemCode, ItemName and two set of pack is mandatory",
							"Insufficient Details", JOptionPane.INFORMATION_MESSAGE);
				}

				else if (checkSizeAndCostOfPack(quantityList, costList)) {
					dataToAddInPropertiesFile.append("itemcode=" + itemCode);
					dataToAddInPropertiesFile.append(System.lineSeparator());
					dataToAddInPropertiesFile.append("itemname=" + itemName);
					dataToAddInPropertiesFile.append(System.lineSeparator());

					// convert amount to float and write it to file.
					dataToAddInPropertiesFile.append(
							"pack=" + packSize1Quantity + "-" + String.valueOf(Float.parseFloat(packSize1Cost)));
					dataToAddInPropertiesFile.append(",");
					dataToAddInPropertiesFile
							.append(packSize2Quantity + "-" + String.valueOf(Float.parseFloat(packSize2Cost)));

					// Third item is optional, hence it is added only when they are not empty.
					if (!(packSize3Quantity.isEmpty() || packSize3Cost.isEmpty())) {
						if (checkSizeAndCostOfPack(packSize3Quantity, packSize3Cost)) {
							dataToAddInPropertiesFile.append(",");
							dataToAddInPropertiesFile
									.append(packSize3Quantity + "-" + String.valueOf(Float.parseFloat(packSize3Cost)));
						}
					}

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
				packQuantity2TextBox.setText("");
				packAmount2TextBox.setText("");
				packQuantity3TextBox.setText("");
				packAmount3TextBox.setText("");

			}

			private boolean checkSizeAndCostOfPack(List<String> quantityList, List<String> costList) {

				try {
					for (String str : quantityList) {
						Integer.parseInt(str);
					}

					for (String str : costList) {
						Float.parseFloat(str);
					}
					return true;
				} catch (NumberFormatException e) {
					BackeryLogger.log(Level.ERROR, "Quantity should be of Integer and Price should be of Float");
					BackeryLogger.log(Level.ERROR, "Either Quantity or cost of the Item is invalid");
				}

				return false;
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
		jMenu1.add(exitMenu);
		jMenuBar1.add(jMenu1);

		mainFrame.setJMenuBar(jMenuBar1);

		mainFrame.pack();

		// Center the GUI in the Screen.
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - mainFrame.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - mainFrame.getHeight()) / 2);
		mainFrame.setLocation(x, y);

		// Make the screen visible.
		mainFrame.setVisible(true);
	}
}