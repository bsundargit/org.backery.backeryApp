package mainApp;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.log4j.Level;
import org.backery.common.BackeryLogger;
import org.backery.dao.DataImplementation;
import org.backery.dao.DataSourceService;
import org.backery.entity.BackeryException;
import org.backery.entity.Item;
import org.backery.entity.Pack;
import org.backery.utils.ReadDataFromPropertiesFile;

public class MainApp {

	static Map<Integer, Integer> data = new LinkedHashMap();
	static Map<String, Item> receivedList;

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
	private static javax.swing.JButton jButton3;
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
	private static javax.swing.JTextField jTextField3;
	private static javax.swing.JTextField jTextField4;
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

		MainApp mainApp = new MainApp();
		mainApp.initComponents();
		BackeryLogger.log(Level.INFO, "Bakery Application is getting initiated ... ");

		try {
			receivedList = ds.getAllData();
			// Vegemite Scroll 10
			// processIt(receivedList, "Blueberry Muffin", 14);

		} catch (BackeryException e) {
			BackeryLogger.log(Level.ERROR, "Unable to initialize Bakery Application");
		}

	}

	/**
	 * This method checks whether, there exist the next item in the array or not.
	 * 
	 * @param entryItems
	 * @param size
	 * @return
	 */
	private static boolean checkIfNextItemPresent(List<Integer> entryItems, int size) {
		if (size <= entryItems.size() - 1) {
			return true;
		}
		return false;
	}

	private static void initComponents() {

		ReadDataFromPropertiesFile readData = new ReadDataFromPropertiesFile();
		Map<String, String> data = readData.getPropertiesFileData();
		BackeryLogger.log(Level.INFO, " Getting initialized ...");
		if (data.isEmpty()) {
			BackeryLogger.log(Level.ERROR,
					" Properties object/ Bakery Inventory Data not loaded. Closing the Application");
			System.exit(0);
		}

		loadItemName = getItemName(data);
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
		itemsComboBox = new javax.swing.JComboBox<>();
		itemCode = new javax.swing.JLabel();
		itemNameValue = new javax.swing.JLabel();
		quantityLabel = new javax.swing.JLabel();
		quantityComboBox = new javax.swing.JComboBox<>();
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
		jTextField3 = new javax.swing.JTextField();
		jLabel11 = new javax.swing.JLabel();
		jTextField4 = new javax.swing.JTextField();
		jLabel13 = new javax.swing.JLabel();
		jLabel14 = new javax.swing.JLabel();
		jLabel15 = new javax.swing.JLabel();
		jLabel16 = new javax.swing.JLabel();
		jTextField5 = new javax.swing.JTextField();
		jTextField6 = new javax.swing.JTextField();
		jTextField7 = new javax.swing.JTextField();
		jTextField8 = new javax.swing.JTextField();
		jButton3 = new javax.swing.JButton();
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
			@Override
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

		quantityComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15" }));
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
						processIt(receivedList, itemsComboBox.getSelectedItem().toString(),
								Integer.parseInt(quantityComboBox.getSelectedItem().toString()));
						BackeryLogger.log(Level.DEBUG,
								"Selected Item Code - " + itemsComboBox.getSelectedItem().toString());
						BackeryLogger.log(Level.DEBUG,
								"Selected Quantity for the Item - " + quantityComboBox.getSelectedItem().toString());
					}
				} catch (BackeryException e1) {
					BackeryLogger.log(Level.ERROR, "Unable to find the pack match");
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

		itemCodeTextBoxAI.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				// itemCodeTextBoxAIActionPerformed(evt);
			}
		});

		packsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Pack"));

		jLabel10.setText("Pack size");

		jTextField3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				// jTextField3ActionPerformed(evt);
			}
		});

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
												.addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 101,
														Short.MAX_VALUE)
												.addComponent(jTextField4).addComponent(jTextField5)
												.addComponent(jTextField6).addComponent(jTextField7)
												.addComponent(jTextField8))))
								.addContainerGap(63, Short.MAX_VALUE)));
		packsPanelLayout.setVerticalGroup(packsPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(packsPanelLayout.createSequentialGroup().addContainerGap()
						.addGroup(packsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel10))
						.addGap(19, 19, 19)
						.addGroup(packsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE,
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

		jButton3.setText("Add");

		javax.swing.GroupLayout addItemPanelLayout = new javax.swing.GroupLayout(addItemPanel);
		addItemPanel.setLayout(addItemPanelLayout);
		addItemPanelLayout.setHorizontalGroup(addItemPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addItemPanelLayout.createSequentialGroup()
						.addGap(46, 46, 46)
						.addGroup(addItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(addItemPanelLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addComponent(jButton3).addComponent(packsPanel,
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
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jButton3)
						.addGap(43, 43, 43)));

		viewItemsTab.addTab("Add Item", addItemPanel);

		viewInventoryButton.setText("View Inventory");

		inventoryTextArea.setColumns(20);
		inventoryTextArea.setRows(5);
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

		// Center the GUI in the Screen.
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - mainFrame.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - mainFrame.getHeight()) / 2);
		mainFrame.setLocation(x, y);

		// Make the screen visible.
		mainFrame.setVisible(true);
	}

	/**
	 * Get itemName from map and make it available for using it in the GUI
	 * 
	 * @param aInDataMap
	 * @return
	 */
	private static Map<String, String> getItemName(Map<String, String> aInDataMap) {

		Map<String, String> returnMap = new HashMap();
		for (Map.Entry<String, String> mapVar : aInDataMap.entrySet()) {
			String value = mapVar.getValue();
			// itemcode=CF
			// itemname=Croissant
			// pack=3-5.95,5-9.95,9-16.99

			String[] splitValue = value.split(System.lineSeparator());
			returnMap.put(mapVar.getKey(), splitValue[1].split("=")[1]);
		}

		return returnMap;
	}

	/**
	 * 
	 * @param receivedList
	 * @param inputItem
	 * @param reqItems
	 */
	private static void processIt(Map<String, Item> receivedList, String inputItem, int input) {

		BackeryLogger.log(Level.INFO, "Finding the packaging structure for the selected itemcode " + inputItem
				+ " with the quantity " + input);
		List<Float> eachPackPrice = new ArrayList();
		List<Integer> entryItems = new LinkedList<Integer>();
		StringBuilder strBuilder = new StringBuilder();
		float totalAmount = 0.0f;

		if (receivedList.containsKey(inputItem)) {
			Item value = receivedList.get(inputItem);

			Map<Integer, Float> ratePerPack = new HashMap();

			for (Pack p : value.getPacks()) {
				entryItems.add(p.getNumberOfItemsPerPack());
				ratePerPack.put(p.getNumberOfItemsPerPack(), p.getPackAmount());
			}

			// Sort it so it can be reversed in descending order
			Collections.sort(entryItems);

			// reverse it.
			Collections.reverse(entryItems);

			int calculated = 0;
			for (int i = 0; i <= entryItems.size() - 1; i++) {
				if (input >= entryItems.get(i)) { // Now divide input by each array item
					int divideQuotient = input / entryItems.get(i);
					int divideReminder = input % entryItems.get(i);

					BackeryLogger.log(Level.DEBUG,
							input + " divided by " + entryItems.get(i) + " and the quotient  is " + divideQuotient);
					BackeryLogger.log(Level.DEBUG,
							input + " divided by " + entryItems.get(i) + " and the reminder  is " + divideReminder);

					// Scenario -- where first item gets matched.
					if (entryItems.get(i) * divideQuotient == input) {
						strBuilder.append(entryItems.get(i) + " * " + divideQuotient);
						strBuilder.append(System.lineSeparator());
						BackeryLogger.log(Level.DEBUG, entryItems.get(i) + " * " + divideQuotient);
						break;
					}

					if (checkIfNextItemPresent(entryItems, i + 1)) {
						if (entryItems.get(i + 1) > divideReminder) {
							// skip doing this division
							continue;
						} else {
							BackeryLogger.log(Level.DEBUG, entryItems.get(i) + " * " + divideQuotient);
							strBuilder.append(entryItems.get(i) + " * " + divideQuotient);
							strBuilder.append(System.lineSeparator());
							calculated = entryItems.get(i) * divideQuotient;
							input = input - calculated;
						}
					} else {
						if (divideReminder == 0) {
							BackeryLogger.log(Level.DEBUG, entryItems.get(i) + " * " + divideQuotient);
							strBuilder.append(entryItems.get(i) + " * " + divideQuotient);
							strBuilder.append(System.lineSeparator());
						}
					}
				}
			}

			for (Map.Entry<Integer, Integer> map : data.entrySet()) {
				strBuilder.append(map.getValue() + " packs of " + map.getKey() + " quanties and cost is "
						+ (ratePerPack.get(map.getKey()) * map.getValue()));
				strBuilder.append(System.lineSeparator());
				eachPackPrice.add((ratePerPack.get(map.getKey()) * map.getValue()));
			}

			float finalPrice = 0;
			for (Float f : eachPackPrice) {
				finalPrice = finalPrice + f;
			}

			String[] splitStrBuilder = strBuilder.toString().split(System.lineSeparator());

			for (String eachData : splitStrBuilder) {
				if (!eachData.isEmpty()) {
					String splitData[] = eachData.split("\\*");
					int testData = Integer.parseInt(splitData[0].trim());

					if (ratePerPack.containsKey(testData)) {
						float localValue = ratePerPack.get(Integer.parseInt(splitData[0].trim()));
						totalAmount = totalAmount + (localValue * Integer.parseInt(splitData[1].trim()));
					}
				}
			}

			if (strBuilder.toString().isEmpty()) {
				strBuilder.append("No matching Combinations for the item selected.");
			} else {

				strBuilder.append(System.lineSeparator());
				strBuilder.append("Total Amount " + "$" + totalAmount);
			}
			outputTrextArea.setText(strBuilder.toString());
			BackeryLogger.log(Level.INFO, "The Packaging structure for the selected itemcode " + inputItem
					+ " with the quantity " + input + " is processed successfully");
		} else {
			BackeryLogger.log(Level.INFO, "The Selected item is not available in the inventory");
		}
	}
}