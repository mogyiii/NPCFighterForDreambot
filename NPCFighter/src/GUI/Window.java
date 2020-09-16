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
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Window {
	private Main _main;
	private JFrame frmSettings;
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
		frmSettings = new JFrame();
		frmSettings.setTitle("Settings");
		frmSettings.setBounds(100, 100, 453, 583);
		frmSettings.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frmSettings.getContentPane().setLayout(springLayout);
		
		JButton StartBtn = new JButton("Start");
		springLayout.putConstraint(SpringLayout.NORTH, StartBtn, -32, SpringLayout.SOUTH, frmSettings.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, StartBtn, 0, SpringLayout.WEST, frmSettings.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, StartBtn, 0, SpringLayout.SOUTH, frmSettings.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, StartBtn, -294, SpringLayout.EAST, frmSettings.getContentPane());
		frmSettings.getContentPane().add(StartBtn);
		
		JTabbedPane AttackPane = new JTabbedPane(JTabbedPane.TOP);
		springLayout.putConstraint(SpringLayout.NORTH, AttackPane, -92, SpringLayout.NORTH, StartBtn);
		springLayout.putConstraint(SpringLayout.WEST, AttackPane, 10, SpringLayout.WEST, frmSettings.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, AttackPane, -9, SpringLayout.NORTH, StartBtn);
		springLayout.putConstraint(SpringLayout.EAST, AttackPane, 427, SpringLayout.WEST, frmSettings.getContentPane());
		frmSettings.getContentPane().add(AttackPane);
		
		JPanel MeleePanel = new JPanel();
		AttackPane.addTab("Melee", null, MeleePanel, null);
		MeleePanel.setLayout(new BoxLayout(MeleePanel, BoxLayout.X_AXIS));
		
		JCheckBox MeleeAttackCheckBox = new JCheckBox("Attack");
		MeleePanel.add(MeleeAttackCheckBox);
		
		JCheckBox MeleeStrengthCheckBox = new JCheckBox("Strength");
		MeleePanel.add(MeleeStrengthCheckBox);
		
		JCheckBox MeleeDefendCheckBox = new JCheckBox("Defend");
		MeleePanel.add(MeleeDefendCheckBox);
		
		JPanel RangePanel = new JPanel();
		AttackPane.addTab("Range", null, RangePanel, null);
		RangePanel.setLayout(new BoxLayout(RangePanel, BoxLayout.X_AXIS));
		
		JCheckBox RangeDefendCheckBox = new JCheckBox("Defend");
		RangePanel.add(RangeDefendCheckBox);
		
		JPanel MagicPanel = new JPanel();
		AttackPane.addTab("Magic", null, MagicPanel, null);
		MagicPanel.setLayout(new BoxLayout(MagicPanel, BoxLayout.X_AXIS));
		
		JCheckBox MagicDefendCheckBox = new JCheckBox("Defend");
		MagicPanel.add(MagicDefendCheckBox);
		
		List ScannedList = new List();
		ScannedList.setMultipleSelections(true);
		springLayout.putConstraint(SpringLayout.NORTH, ScannedList, 20, SpringLayout.NORTH, frmSettings.getContentPane());
		frmSettings.getContentPane().add(ScannedList);
		
		List SelectedList = new List();
		SelectedList.setMultipleSelections(true);
		springLayout.putConstraint(SpringLayout.NORTH, SelectedList, 20, SpringLayout.NORTH, frmSettings.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, SelectedList, 0, SpringLayout.SOUTH, ScannedList);
		frmSettings.getContentPane().add(SelectedList);
		
		JButton AddNpcButton = new JButton("<-");
		springLayout.putConstraint(SpringLayout.EAST, SelectedList, -6, SpringLayout.WEST, AddNpcButton);
		springLayout.putConstraint(SpringLayout.WEST, ScannedList, 6, SpringLayout.EAST, AddNpcButton);
		springLayout.putConstraint(SpringLayout.WEST, AddNpcButton, 260, SpringLayout.WEST, frmSettings.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, AddNpcButton, -126, SpringLayout.EAST, frmSettings.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, AddNpcButton, 20, SpringLayout.NORTH, frmSettings.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, AddNpcButton, 52, SpringLayout.NORTH, frmSettings.getContentPane());
		frmSettings.getContentPane().add(AddNpcButton);
		
		JButton RemoveNpcButton = new JButton("->");
		springLayout.putConstraint(SpringLayout.NORTH, RemoveNpcButton, 38, SpringLayout.SOUTH, AddNpcButton);
		springLayout.putConstraint(SpringLayout.WEST, RemoveNpcButton, 6, SpringLayout.EAST, SelectedList);
		springLayout.putConstraint(SpringLayout.SOUTH, RemoveNpcButton, 70, SpringLayout.SOUTH, AddNpcButton);
		springLayout.putConstraint(SpringLayout.EAST, RemoveNpcButton, -6, SpringLayout.WEST, ScannedList);
		frmSettings.getContentPane().add(RemoveNpcButton);
		
		JButton SearchNPCButton = new JButton("Scan");
		springLayout.putConstraint(SpringLayout.WEST, SearchNPCButton, 372, SpringLayout.WEST, frmSettings.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, ScannedList, -6, SpringLayout.NORTH, SearchNPCButton);
		springLayout.putConstraint(SpringLayout.NORTH, SearchNPCButton, 188, SpringLayout.NORTH, frmSettings.getContentPane());
		frmSettings.getContentPane().add(SearchNPCButton);
		
		JCheckBox BuryBonesCheckBox = new JCheckBox("Bury Bones");
		BuryBonesCheckBox.setSelected(true);
		springLayout.putConstraint(SpringLayout.NORTH, BuryBonesCheckBox, 10, SpringLayout.NORTH, frmSettings.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, BuryBonesCheckBox, 10, SpringLayout.WEST, frmSettings.getContentPane());
		frmSettings.getContentPane().add(BuryBonesCheckBox);
		
		JCheckBox SpecialAttackCheckBox = new JCheckBox("Special attack");
		SpecialAttackCheckBox.setSelected(true);
		springLayout.putConstraint(SpringLayout.NORTH, SpecialAttackCheckBox, 6, SpringLayout.SOUTH, BuryBonesCheckBox);
		springLayout.putConstraint(SpringLayout.WEST, SpecialAttackCheckBox, 10, SpringLayout.WEST, frmSettings.getContentPane());
		frmSettings.getContentPane().add(SpecialAttackCheckBox);
		
		JSpinner PickupItemCostSpinner = new JSpinner();
		springLayout.putConstraint(SpringLayout.NORTH, PickupItemCostSpinner, 227, SpringLayout.NORTH, frmSettings.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, PickupItemCostSpinner, -293, SpringLayout.SOUTH, frmSettings.getContentPane());
		frmSettings.getContentPane().add(PickupItemCostSpinner);
		
		JLabel PickUpItemLabel = new JLabel("Pick up item");
		springLayout.putConstraint(SpringLayout.WEST, PickupItemCostSpinner, 15, SpringLayout.EAST, PickUpItemLabel);
		springLayout.putConstraint(SpringLayout.NORTH, PickUpItemLabel, 5, SpringLayout.NORTH, PickupItemCostSpinner);
		springLayout.putConstraint(SpringLayout.EAST, PickUpItemLabel, 0, SpringLayout.EAST, AddNpcButton);
		frmSettings.getContentPane().add(PickUpItemLabel);
		
		JLabel GPLabel = new JLabel("Gp");
		springLayout.putConstraint(SpringLayout.NORTH, GPLabel, 232, SpringLayout.NORTH, frmSettings.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, PickupItemCostSpinner, -14, SpringLayout.WEST, GPLabel);
		springLayout.putConstraint(SpringLayout.EAST, GPLabel, -5, SpringLayout.EAST, frmSettings.getContentPane());
		frmSettings.getContentPane().add(GPLabel);
		
		AreaSizeField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, AreaSizeField, 40, SpringLayout.SOUTH, SpecialAttackCheckBox);
		springLayout.putConstraint(SpringLayout.EAST, AreaSizeField, -26, SpringLayout.WEST, SelectedList);
		AreaSizeField.setText("8");
		frmSettings.getContentPane().add(AreaSizeField);
		AreaSizeField.setColumns(10);
		
		JLabel AreaSizeLabel = new JLabel("Area size");
		springLayout.putConstraint(SpringLayout.WEST, AreaSizeField, 6, SpringLayout.EAST, AreaSizeLabel);
		springLayout.putConstraint(SpringLayout.WEST, AreaSizeLabel, 0, SpringLayout.WEST, BuryBonesCheckBox);
		springLayout.putConstraint(SpringLayout.SOUTH, AreaSizeLabel, 0, SpringLayout.SOUTH, RemoveNpcButton);
		frmSettings.getContentPane().add(AreaSizeLabel);
		
		JLabel SelectedListLabel = new JLabel("Selected List");
		springLayout.putConstraint(SpringLayout.WEST, SelectedListLabel, 78, SpringLayout.EAST, BuryBonesCheckBox);
		springLayout.putConstraint(SpringLayout.SOUTH, SelectedListLabel, -6, SpringLayout.NORTH, SelectedList);
		frmSettings.getContentPane().add(SelectedListLabel);
		
		JLabel ScannedListLabel = new JLabel("Scanned List");
		springLayout.putConstraint(SpringLayout.NORTH, ScannedListLabel, 0, SpringLayout.NORTH, SelectedListLabel);
		springLayout.putConstraint(SpringLayout.EAST, ScannedListLabel, 0, SpringLayout.EAST, PickupItemCostSpinner);
		frmSettings.getContentPane().add(ScannedListLabel);
		
		JRadioButton MagicRadioButton = new JRadioButton("Magic");
		springLayout.putConstraint(SpringLayout.SOUTH, AreaSizeField, -34, SpringLayout.NORTH, MagicRadioButton);
		MagicRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GroupRadioButton.clearSelection();
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, MagicRadioButton, 0, SpringLayout.WEST, BuryBonesCheckBox);
		springLayout.putConstraint(SpringLayout.SOUTH, MagicRadioButton, 0, SpringLayout.SOUTH, ScannedList);
		frmSettings.getContentPane().add(MagicRadioButton);
		GroupRadioButton.add(MagicRadioButton);
		
		JRadioButton RandgeRadioButton = new JRadioButton("Range");
		RandgeRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GroupRadioButton.clearSelection();
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, RandgeRadioButton, 0, SpringLayout.WEST, BuryBonesCheckBox);
		springLayout.putConstraint(SpringLayout.SOUTH, RandgeRadioButton, 0, SpringLayout.SOUTH, SearchNPCButton);
		frmSettings.getContentPane().add(RandgeRadioButton);
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
		frmSettings.getContentPane().add(MeleeRadioButton);
		GroupRadioButton.add(MeleeRadioButton);
		
		AddItemTextField = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, AddItemTextField, 298, SpringLayout.WEST, frmSettings.getContentPane());
		frmSettings.getContentPane().add(AddItemTextField);
		AddItemTextField.setColumns(10);
		
		JLabel AddItemLabel = new JLabel("Item name:");
		springLayout.putConstraint(SpringLayout.SOUTH, AddItemLabel, -73, SpringLayout.NORTH, AttackPane);
		springLayout.putConstraint(SpringLayout.EAST, AddItemLabel, -6, SpringLayout.WEST, AddItemTextField);
		frmSettings.getContentPane().add(AddItemLabel);
		
		JButton AddItemButton = new JButton("Add");
		springLayout.putConstraint(SpringLayout.NORTH, AddItemButton, 367, SpringLayout.NORTH, frmSettings.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, AddItemTextField, -17, SpringLayout.NORTH, AddItemButton);
		springLayout.putConstraint(SpringLayout.WEST, AddItemButton, -89, SpringLayout.EAST, AddItemTextField);
		springLayout.putConstraint(SpringLayout.EAST, AddItemButton, 0, SpringLayout.EAST, AddItemTextField);
		frmSettings.getContentPane().add(AddItemButton);
		
		List AddedItemsList = new List();
		springLayout.putConstraint(SpringLayout.SOUTH, AddedItemsList, -11, SpringLayout.NORTH, AttackPane);
		AddedItemsList.setMultipleSelections(true);
		springLayout.putConstraint(SpringLayout.WEST, AddedItemsList, 10, SpringLayout.WEST, frmSettings.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, AddedItemsList, 210, SpringLayout.WEST, frmSettings.getContentPane());
		frmSettings.getContentPane().add(AddedItemsList);
		
		JButton RemoveItemButton = new JButton("Remove");
		springLayout.putConstraint(SpringLayout.WEST, RemoveItemButton, 0, SpringLayout.WEST, AddItemButton);
		springLayout.putConstraint(SpringLayout.SOUTH, RemoveItemButton, -1, SpringLayout.NORTH, AttackPane);
		springLayout.putConstraint(SpringLayout.EAST, RemoveItemButton, 0, SpringLayout.EAST, AddItemTextField);
		frmSettings.getContentPane().add(RemoveItemButton);
		
		JLabel PickUpItemsLabel = new JLabel("Pick up Items:");
		springLayout.putConstraint(SpringLayout.SOUTH, PickUpItemsLabel, -226, SpringLayout.SOUTH, frmSettings.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, AddedItemsList, 6, SpringLayout.SOUTH, PickUpItemsLabel);
		springLayout.putConstraint(SpringLayout.WEST, PickUpItemsLabel, 0, SpringLayout.WEST, AttackPane);
		frmSettings.getContentPane().add(PickUpItemsLabel);
		
		JLabel percentageValueLabel = new JLabel("");
		springLayout.putConstraint(SpringLayout.WEST, percentageValueLabel, 89, SpringLayout.WEST, frmSettings.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, percentageValueLabel, -60, SpringLayout.NORTH, AddedItemsList);
		frmSettings.getContentPane().add(percentageValueLabel);
		
		JCheckBox ChatBotCheckBox = new JCheckBox("ChatBot");
		springLayout.putConstraint(SpringLayout.NORTH, ChatBotCheckBox, 6, SpringLayout.SOUTH, SpecialAttackCheckBox);
		springLayout.putConstraint(SpringLayout.WEST, ChatBotCheckBox, 0, SpringLayout.WEST, AttackPane);
		ChatBotCheckBox.setSelected(true);
		frmSettings.getContentPane().add(ChatBotCheckBox);
		
		JCheckBox WorldHopperCheckBox = new JCheckBox("WorldHopper");
		WorldHopperCheckBox.setSelected(true);
		springLayout.putConstraint(SpringLayout.NORTH, WorldHopperCheckBox, 0, SpringLayout.NORTH, percentageValueLabel);
		springLayout.putConstraint(SpringLayout.WEST, WorldHopperCheckBox, 0, SpringLayout.WEST, AttackPane);
		frmSettings.getContentPane().add(WorldHopperCheckBox);
		
		JButton SaveSettingsButton = new JButton("Save Settings");
		springLayout.putConstraint(SpringLayout.NORTH, SaveSettingsButton, 6, SpringLayout.SOUTH, AttackPane);
		springLayout.putConstraint(SpringLayout.WEST, SaveSettingsButton, 10, SpringLayout.WEST, AddItemButton);
		springLayout.putConstraint(SpringLayout.SOUTH, SaveSettingsButton, 0, SpringLayout.SOUTH, frmSettings.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, SaveSettingsButton, 0, SpringLayout.EAST, frmSettings.getContentPane());
		frmSettings.getContentPane().add(SaveSettingsButton);
		
		JCheckBox PickUpArrowCheckBox = new JCheckBox("Pick Up Arrow");
		RangePanel.add(PickUpArrowCheckBox);
		springLayout.putConstraint(SpringLayout.NORTH, PickUpArrowCheckBox, 6, SpringLayout.SOUTH, SpecialAttackCheckBox);
		springLayout.putConstraint(SpringLayout.WEST, PickUpArrowCheckBox, 0, SpringLayout.WEST, BuryBonesCheckBox);
		/*Action*/
		AddNpcButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				for(int i = 0; i < ScannedList.getSelectedItems().length; i++) {
					SelectedList.add(ScannedList.getSelectedItems()[i]);	
				}
			}
		});
		
		RemoveNpcButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for(int i = 0; i < SelectedList.getSelectedItems().length; i++) {
					SelectedList.remove(ScannedList.getSelectedItems()[i]);	
				}
			}
		});
		
		AddItemButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddedItemsList.add(AddItemTextField.getText());
				AddItemTextField.setText("");
			}
		});
		
		RemoveItemButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for(int i = 0; i < AddedItemsList.getSelectedItems().length; i++) {
					AddedItemsList.remove(AddedItemsList.getSelectedItems()[i]);	
				}
			}
		});
	}
	public JFrame GetJFrame() {
		return frmSettings;
	}
}
