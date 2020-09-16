package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;

import Combat.Main;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import javax.swing.SpringLayout;
import javax.swing.JTabbedPane;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import java.awt.List;
import java.awt.Color;
import javax.swing.JCheckBox;
import java.awt.Choice;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.JPanel;
import javax.swing.JLayeredPane;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JToggleButton;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Window.Type;
import javax.swing.JList;

public class Window {
	private Main _main;
	private JFrame frame;
	private JTextField AreaSizeField;
	private ButtonGroup GroupRadioButton = new ButtonGroup();
	private JTextField AddItemTextField;
	public Window(Main main) {
		this._main = main;
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 453, 583);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		
		JButton StartBtn = new JButton("Start");
		springLayout.putConstraint(SpringLayout.NORTH, StartBtn, -32, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, StartBtn, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, StartBtn, 0, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, StartBtn, -294, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(StartBtn);
		
		
		JTabbedPane AttackPane = new JTabbedPane(JTabbedPane.TOP);
		springLayout.putConstraint(SpringLayout.NORTH, AttackPane, -92, SpringLayout.NORTH, StartBtn);
		springLayout.putConstraint(SpringLayout.WEST, AttackPane, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, AttackPane, -9, SpringLayout.NORTH, StartBtn);
		springLayout.putConstraint(SpringLayout.EAST, AttackPane, 427, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(AttackPane);
		
		JPanel MeleePanel = new JPanel();
		AttackPane.addTab("Melee", null, MeleePanel, null);
		GridBagLayout gbl_MeleePanel = new GridBagLayout();
		gbl_MeleePanel.columnWidths = new int[]{0, 57, 67, 0};
		gbl_MeleePanel.rowHeights = new int[]{90, 23, 0, 0, 0};
		gbl_MeleePanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_MeleePanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		MeleePanel.setLayout(gbl_MeleePanel);
		
		JCheckBox MeleeAttackCheckBox = new JCheckBox("Attack");
		GridBagConstraints gbc_MeleeAttackCheckBox = new GridBagConstraints();
		gbc_MeleeAttackCheckBox.anchor = GridBagConstraints.WEST;
		gbc_MeleeAttackCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_MeleeAttackCheckBox.gridx = 0;
		gbc_MeleeAttackCheckBox.gridy = 1;
		MeleePanel.add(MeleeAttackCheckBox, gbc_MeleeAttackCheckBox);
		
		JCheckBox MeleeStrengthCheckBox = new JCheckBox("Strength");
		GridBagConstraints gbc_MeleeStrengthCheckBox = new GridBagConstraints();
		gbc_MeleeStrengthCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_MeleeStrengthCheckBox.anchor = GridBagConstraints.WEST;
		gbc_MeleeStrengthCheckBox.gridx = 1;
		gbc_MeleeStrengthCheckBox.gridy = 1;
		MeleePanel.add(MeleeStrengthCheckBox, gbc_MeleeStrengthCheckBox);
		
		JCheckBox MeleeDefendCheckBox = new JCheckBox("Defend");
		GridBagConstraints gbc_MeleeDefendCheckBox = new GridBagConstraints();
		gbc_MeleeDefendCheckBox.insets = new Insets(0, 0, 5, 0);
		gbc_MeleeDefendCheckBox.gridx = 2;
		gbc_MeleeDefendCheckBox.gridy = 1;
		MeleePanel.add(MeleeDefendCheckBox, gbc_MeleeDefendCheckBox);
		
		JPanel RangePanel = new JPanel();
		AttackPane.addTab("Range", null, RangePanel, null);
		RangePanel.setLayout(new BoxLayout(RangePanel, BoxLayout.X_AXIS));
		
		JCheckBox RangeDefendCheckBox = new JCheckBox("Defend");
		RangePanel.add(RangeDefendCheckBox);
		
		JCheckBox PickUpArrowCheckBox = new JCheckBox("Pick Up Arrow");
		RangePanel.add(PickUpArrowCheckBox);
		springLayout.putConstraint(SpringLayout.NORTH, PickUpArrowCheckBox, 6, SpringLayout.SOUTH, SpecialAttackCheckBox);
		springLayout.putConstraint(SpringLayout.WEST, PickUpArrowCheckBox, 0, SpringLayout.WEST, BuryBonesCheckBox);
		
		JPanel MagicPanel = new JPanel();
		AttackPane.addTab("Magic", null, MagicPanel, null);
		MagicPanel.setLayout(new BoxLayout(MagicPanel, BoxLayout.X_AXIS));
		
		JCheckBox MagicDefendCheckBox = new JCheckBox("Defend");
		MagicPanel.add(MagicDefendCheckBox);
		
		List ScannedList = new List();
		ScannedList.setMultipleSelections(true);
		springLayout.putConstraint(SpringLayout.NORTH, ScannedList, 20, SpringLayout.NORTH, frame.getContentPane());
		frame.getContentPane().add(ScannedList);
		
		List SelectedList = new List();
		SelectedList.setMultipleSelections(true);
		springLayout.putConstraint(SpringLayout.NORTH, SelectedList, 20, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, SelectedList, 0, SpringLayout.SOUTH, ScannedList);
		frame.getContentPane().add(SelectedList);
		
		JButton AddNpcButton = new JButton("<-");
		springLayout.putConstraint(SpringLayout.EAST, SelectedList, -6, SpringLayout.WEST, AddNpcButton);
		springLayout.putConstraint(SpringLayout.WEST, ScannedList, 6, SpringLayout.EAST, AddNpcButton);
		springLayout.putConstraint(SpringLayout.WEST, AddNpcButton, 260, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, AddNpcButton, -126, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, AddNpcButton, 20, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, AddNpcButton, 52, SpringLayout.NORTH, frame.getContentPane());
		frame.getContentPane().add(AddNpcButton);
		
		JButton RemoveNpcButton = new JButton("->");
		springLayout.putConstraint(SpringLayout.NORTH, RemoveNpcButton, 38, SpringLayout.SOUTH, AddNpcButton);
		springLayout.putConstraint(SpringLayout.WEST, RemoveNpcButton, 6, SpringLayout.EAST, SelectedList);
		springLayout.putConstraint(SpringLayout.SOUTH, RemoveNpcButton, 70, SpringLayout.SOUTH, AddNpcButton);
		springLayout.putConstraint(SpringLayout.EAST, RemoveNpcButton, -6, SpringLayout.WEST, ScannedList);
		frame.getContentPane().add(RemoveNpcButton);
		
		JButton SearchNPCButton = new JButton("Scan");
		springLayout.putConstraint(SpringLayout.WEST, SearchNPCButton, 372, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, ScannedList, -6, SpringLayout.NORTH, SearchNPCButton);
		springLayout.putConstraint(SpringLayout.NORTH, SearchNPCButton, 188, SpringLayout.NORTH, frame.getContentPane());
		frame.getContentPane().add(SearchNPCButton);
		
		JCheckBox BuryBonesCheckBox = new JCheckBox("Bury Bones");
		BuryBonesCheckBox.setSelected(true);
		springLayout.putConstraint(SpringLayout.NORTH, BuryBonesCheckBox, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, BuryBonesCheckBox, 10, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(BuryBonesCheckBox);
		
		JCheckBox SpecialAttackCheckBox = new JCheckBox("Special attack");
		SpecialAttackCheckBox.setSelected(true);
		springLayout.putConstraint(SpringLayout.NORTH, SpecialAttackCheckBox, 6, SpringLayout.SOUTH, BuryBonesCheckBox);
		springLayout.putConstraint(SpringLayout.WEST, SpecialAttackCheckBox, 10, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(SpecialAttackCheckBox);
		
		JSpinner PickupItemCostSpinner = new JSpinner();
		springLayout.putConstraint(SpringLayout.NORTH, PickupItemCostSpinner, 227, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, PickupItemCostSpinner, -293, SpringLayout.SOUTH, frame.getContentPane());
		frame.getContentPane().add(PickupItemCostSpinner);
		
		JLabel PickUpItemLabel = new JLabel("Pick up item");
		springLayout.putConstraint(SpringLayout.WEST, PickupItemCostSpinner, 15, SpringLayout.EAST, PickUpItemLabel);
		springLayout.putConstraint(SpringLayout.NORTH, PickUpItemLabel, 5, SpringLayout.NORTH, PickupItemCostSpinner);
		springLayout.putConstraint(SpringLayout.EAST, PickUpItemLabel, 0, SpringLayout.EAST, AddNpcButton);
		frame.getContentPane().add(PickUpItemLabel);
		
		JLabel GPLabel = new JLabel("Gp");
		springLayout.putConstraint(SpringLayout.NORTH, GPLabel, 232, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, PickupItemCostSpinner, -14, SpringLayout.WEST, GPLabel);
		springLayout.putConstraint(SpringLayout.EAST, GPLabel, -5, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(GPLabel);
		
		AreaSizeField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, AreaSizeField, 40, SpringLayout.SOUTH, SpecialAttackCheckBox);
		springLayout.putConstraint(SpringLayout.EAST, AreaSizeField, -26, SpringLayout.WEST, SelectedList);
		AreaSizeField.setText("8");
		frame.getContentPane().add(AreaSizeField);
		AreaSizeField.setColumns(10);
		
		JLabel AreaSizeLabel = new JLabel("Area size");
		springLayout.putConstraint(SpringLayout.WEST, AreaSizeField, 6, SpringLayout.EAST, AreaSizeLabel);
		springLayout.putConstraint(SpringLayout.WEST, AreaSizeLabel, 0, SpringLayout.WEST, BuryBonesCheckBox);
		springLayout.putConstraint(SpringLayout.SOUTH, AreaSizeLabel, 0, SpringLayout.SOUTH, RemoveNpcButton);
		frame.getContentPane().add(AreaSizeLabel);
		
		JLabel SelectedListLabel = new JLabel("Selected List");
		springLayout.putConstraint(SpringLayout.WEST, SelectedListLabel, 78, SpringLayout.EAST, BuryBonesCheckBox);
		springLayout.putConstraint(SpringLayout.SOUTH, SelectedListLabel, -6, SpringLayout.NORTH, SelectedList);
		frame.getContentPane().add(SelectedListLabel);
		
		JLabel ScannedListLabel = new JLabel("Scanned List");
		springLayout.putConstraint(SpringLayout.NORTH, ScannedListLabel, 0, SpringLayout.NORTH, SelectedListLabel);
		springLayout.putConstraint(SpringLayout.EAST, ScannedListLabel, 0, SpringLayout.EAST, PickupItemCostSpinner);
		frame.getContentPane().add(ScannedListLabel);
		
		JRadioButton MagicRadioButton = new JRadioButton("Magic");
		springLayout.putConstraint(SpringLayout.SOUTH, AreaSizeField, -34, SpringLayout.NORTH, MagicRadioButton);
		MagicRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GroupRadioButton.clearSelection();
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, MagicRadioButton, 0, SpringLayout.WEST, BuryBonesCheckBox);
		springLayout.putConstraint(SpringLayout.SOUTH, MagicRadioButton, 0, SpringLayout.SOUTH, ScannedList);
		frame.getContentPane().add(MagicRadioButton);
		GroupRadioButton.add(MagicRadioButton);
		
		JRadioButton RandgeRadioButton = new JRadioButton("Range");
		RandgeRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GroupRadioButton.clearSelection();
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, RandgeRadioButton, 0, SpringLayout.WEST, BuryBonesCheckBox);
		springLayout.putConstraint(SpringLayout.SOUTH, RandgeRadioButton, 0, SpringLayout.SOUTH, SearchNPCButton);
		frame.getContentPane().add(RandgeRadioButton);
		GroupRadioButton.add(RandgeRadioButton);
		
		JRadioButton MeleeRadioButton = new JRadioButton("Melee");
		MeleeRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GroupRadioButton.clearSelection();
			}
		});
		MeleeRadioButton.setSelected(true);
		springLayout.putConstraint(SpringLayout.NORTH, MeleeRadioButton, 6, SpringLayout.SOUTH, RandgeRadioButton);
		springLayout.putConstraint(SpringLayout.WEST, MeleeRadioButton, 0, SpringLayout.WEST, BuryBonesCheckBox);
		frame.getContentPane().add(MeleeRadioButton);
		GroupRadioButton.add(MeleeRadioButton);
		
		
		JLabel percentageValueLabel = new JLabel("");
		springLayout.putConstraint(SpringLayout.SOUTH, percentageValueLabel, -255, SpringLayout.SOUTH, frame.getContentPane());
		JSlider Foodslider = new JSlider();
		springLayout.putConstraint(SpringLayout.NORTH, Foodslider, 6, SpringLayout.SOUTH, percentageValueLabel);
		springLayout.putConstraint(SpringLayout.WEST, Foodslider, 0, SpringLayout.WEST, AttackPane);
		springLayout.putConstraint(SpringLayout.EAST, Foodslider, -17, SpringLayout.EAST, SelectedListLabel);
		Foodslider.setSnapToTicks(true);
		Foodslider.setPaintTicks(true);
		Foodslider.setPaintLabels(true);
		Foodslider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent event) {
				percentageValueLabel.setText(((JSlider)event.getSource()).getValue() + "%");
				
			}
		});
		springLayout.putConstraint(SpringLayout.EAST, percentageValueLabel, 0, SpringLayout.EAST, AreaSizeField);
		frame.getContentPane().add(percentageValueLabel);
		frame.getContentPane().add(Foodslider);
		
		JLabel FeedLabel = new JLabel("Feed:");
		springLayout.putConstraint(SpringLayout.SOUTH, FeedLabel, 0, SpringLayout.SOUTH, percentageValueLabel);
		springLayout.putConstraint(SpringLayout.EAST, FeedLabel, 0, SpringLayout.EAST, AreaSizeLabel);
		frame.getContentPane().add(FeedLabel);
		
		AddItemTextField = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, AddItemTextField, 298, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(AddItemTextField);
		AddItemTextField.setColumns(10);
		
		JLabel AddItemLabel = new JLabel("Item name:");
		springLayout.putConstraint(SpringLayout.SOUTH, AddItemLabel, -73, SpringLayout.NORTH, AttackPane);
		springLayout.putConstraint(SpringLayout.EAST, AddItemLabel, -6, SpringLayout.WEST, AddItemTextField);
		frame.getContentPane().add(AddItemLabel);
		
		JButton AddItemButton = new JButton("Add");
		springLayout.putConstraint(SpringLayout.NORTH, AddItemButton, 367, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, AddItemTextField, -17, SpringLayout.NORTH, AddItemButton);
		springLayout.putConstraint(SpringLayout.WEST, AddItemButton, -89, SpringLayout.EAST, AddItemTextField);
		springLayout.putConstraint(SpringLayout.EAST, AddItemButton, 0, SpringLayout.EAST, AddItemTextField);
		frame.getContentPane().add(AddItemButton);
		
		List AddedItemsList = new List();
		AddedItemsList.setMultipleSelections(true);
		springLayout.putConstraint(SpringLayout.NORTH, AddedItemsList, 6, SpringLayout.SOUTH, Foodslider);
		springLayout.putConstraint(SpringLayout.WEST, AddedItemsList, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, AddedItemsList, 83, SpringLayout.SOUTH, Foodslider);
		springLayout.putConstraint(SpringLayout.EAST, AddedItemsList, 210, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(AddedItemsList);
		
		JButton RemoveItemButton = new JButton("Remove");
		springLayout.putConstraint(SpringLayout.WEST, RemoveItemButton, 0, SpringLayout.WEST, AddItemButton);
		springLayout.putConstraint(SpringLayout.SOUTH, RemoveItemButton, -1, SpringLayout.NORTH, AttackPane);
		springLayout.putConstraint(SpringLayout.EAST, RemoveItemButton, 0, SpringLayout.EAST, AddItemTextField);
		frame.getContentPane().add(RemoveItemButton);
		

		
		
		
		
	}
	public void RadioButtonGroup() {
		
	}
	public JFrame GetJFrame() {
		return frame;
	}
}
