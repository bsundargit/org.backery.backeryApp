package mainApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import org.backery.dao.DataImplementation;
import org.backery.dao.DataSourceService;
import org.backery.entity.BackeryException;
import org.backery.entity.Item;
import org.backery.entity.Pack;

public class MainApp {

	private static javax.swing.JButton jButton1;
	private static javax.swing.JComboBox<String> jComboBox1;
	private static javax.swing.JComboBox<String> jComboBox3;
	private static javax.swing.JLabel jLabel1;
	private static javax.swing.JLabel jLabel10;
	private static javax.swing.JLabel jLabel11;
	private static javax.swing.JLabel jLabel2;
	private static javax.swing.JLabel jLabel6;
	private static javax.swing.JLabel jLabel7;
	private static javax.swing.JLabel jLabel8;
	private static javax.swing.JMenu jMenu1;
	private static javax.swing.JMenu jMenu2;
	private static javax.swing.JMenuBar jMenuBar1;
	private static javax.swing.JPanel jPanel1;
	private static javax.swing.JPanel jPanel2;
	private static javax.swing.JPanel jPanel3;
	private static javax.swing.JPanel jPanel7;
	private static javax.swing.JTabbedPane jTabbedPane1;

	static Map<Integer, Integer> data = new LinkedHashMap();
	static Map<String, List<Item>> receivedList;

	static DataSourceService ds = new DataImplementation();

	public static void main(String[] args) {

		// initComponents();

		try {
			receivedList = ds.getAllData();
			processIt(receivedList, "Blueberry Muffin", 16);
		} catch (BackeryException e) {
			e.printStackTrace();
		}

	}

	private static void initComponents() {

		JFrame jf = new JFrame();
		jPanel1 = new javax.swing.JPanel();
		jPanel2 = new javax.swing.JPanel();
		jTabbedPane1 = new javax.swing.JTabbedPane();
		jPanel3 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jComboBox1 = new javax.swing.JComboBox<>();
		jLabel2 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jComboBox3 = new javax.swing.JComboBox<>();
		jLabel8 = new javax.swing.JLabel();
		jButton1 = new javax.swing.JButton();
		jLabel10 = new javax.swing.JLabel();
		jLabel11 = new javax.swing.JLabel();
		jPanel7 = new javax.swing.JPanel();
		jMenuBar1 = new javax.swing.JMenuBar();
		jMenu1 = new javax.swing.JMenu();
		jMenu2 = new javax.swing.JMenu();

		jf.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Operation"));

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 100, Short.MAX_VALUE));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 568, Short.MAX_VALUE));

		jf.getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_START);

		jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Details"));
		jPanel2.setLayout(new java.awt.BorderLayout());

		jTabbedPane1.setName("Order"); // NOI18N

		jPanel3.setLayout(new java.awt.GridLayout(5, 2, 10, 10));

		jLabel1.setText("Item Name");
		jPanel3.add(jLabel1);

		jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(
				new String[] { " ", "Vegemite Scroll", "Blueberry Muffin", "Croissant" }));
		jComboBox1.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {

				JComboBox cb = (JComboBox) e.getSource();
				Object item = e.getItem();
				if (e.getStateChange() == ItemEvent.SELECTED) {
					if (item.equals("Vegemite Scroll")) {
						jLabel6.setText("VS5");
					} else if (item.equals("Blueberry Muffin")) {
						jLabel6.setText("MB11");
					} else if (item.equals("Croissant")) {
						jLabel6.setText("CF");
					}
				} else if (e.getStateChange() == ItemEvent.DESELECTED) {
					// Item is no longer selected
				}
			}
		});

		jPanel3.add(jComboBox1);

		jLabel2.setText("Item Code");
		jPanel3.add(jLabel2);

		jLabel6.setText("jLabel6");
		jPanel3.add(jLabel6);

		jLabel7.setText("Item Quantity");
		jPanel3.add(jLabel7);

		jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
		jPanel3.add(jComboBox3);

		jLabel8.setText("Process");
		jPanel3.add(jLabel8);

		jButton1.setText("jButton1");
		jButton1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					receivedList = ds.getAllData();
					System.out.println(jComboBox1.getSelectedItem() + " " + jComboBox3.getSelectedItem());
					processIt(receivedList, jComboBox1.getSelectedItem().toString(),
							Integer.parseInt(jComboBox3.getSelectedItem().toString()));
				} catch (BackeryException e1) {
					e1.printStackTrace();
				}

			}
		});
		jPanel3.add(jButton1);

		jLabel10.setText("Amount");
		jPanel3.add(jLabel10);
		jPanel3.add(jLabel11);

		jTabbedPane1.addTab("Order", jPanel3);

		javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
		jPanel7.setLayout(jPanel7Layout);
		jPanel7Layout.setHorizontalGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 689, Short.MAX_VALUE));
		jPanel7Layout.setVerticalGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 185, Short.MAX_VALUE));

		jTabbedPane1.addTab("Add Item", jPanel7);
		jPanel2.add(jTabbedPane1, java.awt.BorderLayout.PAGE_START);
		jf.getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

		jMenu1.setText("File");
		jMenuBar1.add(jMenu1);

		jMenu2.setText("Edit");
		jMenuBar1.add(jMenu2);

		jf.setJMenuBar(jMenuBar1);

		jf.pack();
		jf.setVisible(true);

	}

	/**
	 * 
	 * @param receivedList
	 * @param inputItem
	 * @param reqItems
	 */
	private static void processIt(Map<String, List<Item>> receivedList, String inputItem, int reqItems) {

		List<Float> eachPackPrice = new ArrayList();
		List<Integer> entryItems = new LinkedList<Integer>();
		StringBuilder strBuilder = new StringBuilder();

		if (receivedList.containsKey(inputItem)) {
			List<Item> value = receivedList.get(inputItem);

			Map<Integer, Float> ratePerPack = new HashMap();

			for (Item it : value) {
				for (Pack p : it.getPacks()) {
					entryItems.add(p.getNumberOfItemsPerPack());
					ratePerPack.put(p.getNumberOfItemsPerPack(), p.getPackAmount());
				}
			}

			boolean isInputEvenOrOdd = reqItems % 2 == 0 ? true : false;

			Collections.sort(entryItems);
			Collections.reverse(entryItems);

			if (isInputEvenOrOdd) {
				for (Integer eachInt : entryItems) {
					if (eachInt % 2 == 0) {
						reqItems = iterateAndFind(eachInt, reqItems);
					}
				}

			} else {
				for (Integer eachInt : entryItems) {
					if (eachInt % 2 != 0) {
						reqItems = iterateAndFind(eachInt, reqItems);
					}
				}
			}

			for (Map.Entry<Integer, Integer> map : data.entrySet()) {
				// System.out.println(inputItem);
				strBuilder.append(map.getValue() + " packs of " + map.getKey() + " quanties and cost is "
						+ (ratePerPack.get(map.getKey()) * map.getValue()));
				strBuilder.append(System.lineSeparator());
				eachPackPrice.add((ratePerPack.get(map.getKey()) * map.getValue()));
				// System.out.println(map.getValue() + " packs of " + map.getKey() + " quanties
				// and cost is " + (ratePerPack.get(map.getKey()) * map.getValue()));
				// jLabel11.setText(map.getValue() + " packs of " + map.getKey() + " quanties
				// and cost is " + (ratePerPack.get(map.getKey()) * map.getValue()));
			}

			float finalPrice = 0;
			for (Float f : eachPackPrice) {
				finalPrice = finalPrice + f;
			}

			// System.out.println(finalPrice);
			strBuilder.append("Total Price : " + finalPrice);
			// jLabel11.setText(strBuilder.toString());

			System.out.println(strBuilder.toString());
		}
	}

	/**
	 * 
	 * @param eachInt
	 * @param reqItems
	 * @return
	 */
	private static int iterateAndFind(Integer eachInt, int reqItems) {
		int processed = 0;
		for (int i = 1; i <= 5; i++) {
			if ((eachInt * i) <= reqItems) {
				data.put(eachInt, i);
				processed = processed + (eachInt);
			}
		}
		reqItems = reqItems - processed;
		return reqItems;
	}

}