package GUI;

import Combat.Main;
import Factory.AttackType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/*import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;*/


public class Window {
	private Main _main;
	private JFrame frmSettings;
	private ButtonGroup GroupRadioButton = new ButtonGroup();
	private JTextField AddItemTextField;

	public Window(Main main) {
		this._main = main;
		initialize();

	}
	private void initialize() {
		frmSettings = new JFrame();
		frmSettings.setTitle("Settings");
		frmSettings.setBounds(100, 100, 453, 629);
		frmSettings.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frmSettings.getContentPane().setLayout(springLayout);

		JCheckBox AttackCheckBox = new JCheckBox("Attack");
		JCheckBox StrengthCheckBox = new JCheckBox("Strength");
		JCheckBox DefendCheckBox = new JCheckBox("Defend");

		JButton StartBtn = new JButton("Start");
		springLayout.putConstraint(SpringLayout.NORTH, StartBtn, -32, SpringLayout.SOUTH, frmSettings.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, StartBtn, 0, SpringLayout.WEST, frmSettings.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, StartBtn, 0, SpringLayout.SOUTH, frmSettings.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, StartBtn, -294, SpringLayout.EAST, frmSettings.getContentPane());
		frmSettings.getContentPane().add(StartBtn);
		
		List ScannedList = new List();
		ScannedList.setForeground(new Color(255, 255, 255));
		ScannedList.setBackground(new Color(0, 51, 51));
		ScannedList.setMultipleSelections(true);
		springLayout.putConstraint(SpringLayout.NORTH, ScannedList, 20, SpringLayout.NORTH, frmSettings.getContentPane());
		frmSettings.getContentPane().add(ScannedList);
		
		List SelectedList = new List();
		SelectedList.setForeground(new Color(255, 255, 255));
		SelectedList.setBackground(new Color(0, 51, 51));
		SelectedList.setMultipleSelections(true);
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
		springLayout.putConstraint(SpringLayout.EAST, ScannedList, 0, SpringLayout.EAST, SearchNPCButton);
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
		springLayout.putConstraint(SpringLayout.NORTH, PickupItemCostSpinner, 18, SpringLayout.SOUTH, SearchNPCButton);
		frmSettings.getContentPane().add(PickupItemCostSpinner);
		
		JLabel PickUpItemLabel = new JLabel("Pick up item");
		springLayout.putConstraint(SpringLayout.EAST, PickUpItemLabel, -109, SpringLayout.EAST, frmSettings.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, PickupItemCostSpinner, 6, SpringLayout.EAST, PickUpItemLabel);
		springLayout.putConstraint(SpringLayout.NORTH, PickUpItemLabel, 3, SpringLayout.NORTH, PickupItemCostSpinner);
		frmSettings.getContentPane().add(PickUpItemLabel);
		
		JLabel GPLabel = new JLabel("Gp");
		springLayout.putConstraint(SpringLayout.EAST, PickupItemCostSpinner, -6, SpringLayout.WEST, GPLabel);
		springLayout.putConstraint(SpringLayout.NORTH, GPLabel, 232, SpringLayout.NORTH, frmSettings.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, GPLabel, -5, SpringLayout.EAST, frmSettings.getContentPane());
		frmSettings.getContentPane().add(GPLabel);

		JSpinner AreaSizeField = new JSpinner();
		springLayout.putConstraint(SpringLayout.NORTH, AreaSizeField, 18, SpringLayout.SOUTH, PickupItemCostSpinner);
		springLayout.putConstraint(SpringLayout.WEST, AreaSizeField, 355, SpringLayout.WEST, frmSettings.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, AreaSizeField, 0, SpringLayout.EAST, PickupItemCostSpinner);
		frmSettings.getContentPane().add(AreaSizeField);
		
		JLabel AreaSizeLabel = new JLabel("Area size");
		springLayout.putConstraint(SpringLayout.NORTH, AreaSizeLabel, 3, SpringLayout.NORTH, AreaSizeField);
		springLayout.putConstraint(SpringLayout.EAST, AreaSizeLabel, -6, SpringLayout.WEST, AreaSizeField);
		frmSettings.getContentPane().add(AreaSizeLabel);
		
		JLabel SelectedListLabel = new JLabel("Selected List");
		springLayout.putConstraint(SpringLayout.SOUTH, SelectedListLabel, -576, SpringLayout.SOUTH, frmSettings.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, SelectedList, 6, SpringLayout.SOUTH, SelectedListLabel);
		springLayout.putConstraint(SpringLayout.WEST, SelectedListLabel, 78, SpringLayout.EAST, BuryBonesCheckBox);
		frmSettings.getContentPane().add(SelectedListLabel);
		
		JLabel ScannedListLabel = new JLabel("Scanned List");
		springLayout.putConstraint(SpringLayout.NORTH, ScannedListLabel, 0, SpringLayout.NORTH, SelectedListLabel);
		springLayout.putConstraint(SpringLayout.EAST, ScannedListLabel, -32, SpringLayout.EAST, frmSettings.getContentPane());
		frmSettings.getContentPane().add(ScannedListLabel);

		JRadioButton MagicRadioButton = new JRadioButton("Magic");
		springLayout.putConstraint(SpringLayout.WEST, MagicRadioButton, 0, SpringLayout.WEST, BuryBonesCheckBox);
		frmSettings.getContentPane().add(MagicRadioButton);
		GroupRadioButton.add(MagicRadioButton);
		MagicRadioButton.setActionCommand(AttackType.Magic.toString());

		JRadioButton RandgeRadioButton = new JRadioButton("Range");
		springLayout.putConstraint(SpringLayout.SOUTH, MagicRadioButton, -6, SpringLayout.NORTH, RandgeRadioButton);
		springLayout.putConstraint(SpringLayout.WEST, RandgeRadioButton, 0, SpringLayout.WEST, BuryBonesCheckBox);
		springLayout.putConstraint(SpringLayout.SOUTH, RandgeRadioButton, 0, SpringLayout.SOUTH, SearchNPCButton);
		frmSettings.getContentPane().add(RandgeRadioButton);
		GroupRadioButton.add(RandgeRadioButton);
		RandgeRadioButton.setActionCommand(AttackType.Range.toString());

		JRadioButton MeleeRadioButton = new JRadioButton("Melee");
		MeleeRadioButton.setSelected(true);
		springLayout.putConstraint(SpringLayout.NORTH, MeleeRadioButton, 6, SpringLayout.SOUTH, RandgeRadioButton);
		springLayout.putConstraint(SpringLayout.WEST, MeleeRadioButton, 0, SpringLayout.WEST, BuryBonesCheckBox);
		frmSettings.getContentPane().add(MeleeRadioButton);
		GroupRadioButton.add(MeleeRadioButton);
		MeleeRadioButton.setActionCommand(AttackType.Melee.toString());
		
		AddItemTextField = new JTextField();
		frmSettings.getContentPane().add(AddItemTextField);
		AddItemTextField.setColumns(10);
		
		JLabel AddItemLabel = new JLabel("Item name:");
		springLayout.putConstraint(SpringLayout.NORTH, AddItemTextField, -3, SpringLayout.NORTH, AddItemLabel);
		springLayout.putConstraint(SpringLayout.WEST, AddItemTextField, 6, SpringLayout.EAST, AddItemLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, AddItemLabel, -197, SpringLayout.SOUTH, frmSettings.getContentPane());
		frmSettings.getContentPane().add(AddItemLabel);
		
		JButton AddItemButton = new JButton("Add");
		springLayout.putConstraint(SpringLayout.EAST, AddItemButton, -53, SpringLayout.EAST, frmSettings.getContentPane());
		frmSettings.getContentPane().add(AddItemButton);
		
		List AddedItemsList = new List();
		springLayout.putConstraint(SpringLayout.SOUTH, SelectedList, -188, SpringLayout.NORTH, AddedItemsList);
		AddedItemsList.setForeground(new Color(255, 255, 255));
		AddedItemsList.setBackground(new Color(0, 51, 51));
		springLayout.putConstraint(SpringLayout.WEST, AddItemButton, 85, SpringLayout.EAST, AddedItemsList);
		springLayout.putConstraint(SpringLayout.WEST, AddItemLabel, 27, SpringLayout.EAST, AddedItemsList);
		springLayout.putConstraint(SpringLayout.SOUTH, AddedItemsList, -103, SpringLayout.NORTH, StartBtn);
		AddedItemsList.setMultipleSelections(true);
		springLayout.putConstraint(SpringLayout.WEST, AddedItemsList, 10, SpringLayout.WEST, frmSettings.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, AddedItemsList, 210, SpringLayout.WEST, frmSettings.getContentPane());
		frmSettings.getContentPane().add(AddedItemsList);
		
		JButton RemoveItemButton = new JButton("Remove");
		springLayout.putConstraint(SpringLayout.WEST, RemoveItemButton, 85, SpringLayout.EAST, AddedItemsList);
		springLayout.putConstraint(SpringLayout.EAST, RemoveItemButton, -53, SpringLayout.EAST, frmSettings.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, AddItemButton, -6, SpringLayout.NORTH, RemoveItemButton);
		springLayout.putConstraint(SpringLayout.SOUTH, RemoveItemButton, 0, SpringLayout.SOUTH, AddedItemsList);
		frmSettings.getContentPane().add(RemoveItemButton);
		
		JLabel PickUpItemsLabel = new JLabel("Pick up Items:");
		springLayout.putConstraint(SpringLayout.WEST, PickUpItemsLabel, 10, SpringLayout.WEST, frmSettings.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, AddedItemsList, 6, SpringLayout.SOUTH, PickUpItemsLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, PickUpItemsLabel, -226, SpringLayout.SOUTH, frmSettings.getContentPane());
		frmSettings.getContentPane().add(PickUpItemsLabel);
		
		JLabel percentageValueLabel = new JLabel("");
		springLayout.putConstraint(SpringLayout.WEST, percentageValueLabel, 89, SpringLayout.WEST, frmSettings.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, percentageValueLabel, -60, SpringLayout.NORTH, AddedItemsList);
		frmSettings.getContentPane().add(percentageValueLabel);
		
		JCheckBox ChatBotCheckBox = new JCheckBox("ChatBot");
		springLayout.putConstraint(SpringLayout.NORTH, ChatBotCheckBox, 6, SpringLayout.SOUTH, SpecialAttackCheckBox);
		springLayout.putConstraint(SpringLayout.WEST, ChatBotCheckBox, 10, SpringLayout.WEST, frmSettings.getContentPane());
		ChatBotCheckBox.setSelected(true);
		frmSettings.getContentPane().add(ChatBotCheckBox);
		
		JCheckBox WorldHopperCheckBox = new JCheckBox("WorldHopper");
		springLayout.putConstraint(SpringLayout.NORTH, WorldHopperCheckBox, 5, SpringLayout.NORTH, RemoveNpcButton);
		springLayout.putConstraint(SpringLayout.WEST, WorldHopperCheckBox, 0, SpringLayout.WEST, BuryBonesCheckBox);
		WorldHopperCheckBox.setSelected(true);
		frmSettings.getContentPane().add(WorldHopperCheckBox);
		
		JCheckBox PickUpArrowCheckBox = new JCheckBox("Pick Up Arrow");
		springLayout.putConstraint(SpringLayout.NORTH, PickUpArrowCheckBox, 6, SpringLayout.SOUTH, WorldHopperCheckBox);
		springLayout.putConstraint(SpringLayout.EAST, PickUpArrowCheckBox, 0, SpringLayout.EAST, SpecialAttackCheckBox);
		frmSettings.getContentPane().add(PickUpArrowCheckBox);
		

		springLayout.putConstraint(SpringLayout.NORTH, AttackCheckBox, 19, SpringLayout.SOUTH, MeleeRadioButton);
		springLayout.putConstraint(SpringLayout.WEST, AttackCheckBox, 0, SpringLayout.WEST, BuryBonesCheckBox);
		frmSettings.getContentPane().add(AttackCheckBox);



		springLayout.putConstraint(SpringLayout.NORTH, StrengthCheckBox, 6, SpringLayout.SOUTH, AttackCheckBox);
		springLayout.putConstraint(SpringLayout.WEST, StrengthCheckBox, 0, SpringLayout.WEST, BuryBonesCheckBox);
		frmSettings.getContentPane().add(StrengthCheckBox);


		springLayout.putConstraint(SpringLayout.NORTH, DefendCheckBox, 6, SpringLayout.SOUTH, StrengthCheckBox);
		springLayout.putConstraint(SpringLayout.WEST, DefendCheckBox, 0, SpringLayout.WEST, BuryBonesCheckBox);
		frmSettings.getContentPane().add(DefendCheckBox);

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
					SelectedList.remove(SelectedList.getSelectedItems()[i]);
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
		StartBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				_main.get_CombatVariables().get_WindowVariables().SetAll(
						BuryBonesCheckBox.isSelected(),
						SpecialAttackCheckBox.isSelected(),
						ChatBotCheckBox.isSelected(),
						WorldHopperCheckBox.isSelected(),
						PickUpArrowCheckBox.isSelected(),
						StrengthCheckBox.isSelected(),
						AttackCheckBox.isSelected(),
						DefendCheckBox.isSelected(),
						AttackType.valueOf(GroupRadioButton.getSelection().getActionCommand()),
						(int)AreaSizeField.getValue(),
						(int)PickupItemCostSpinner.getValue(),
						SelectedList.getItems(),
						AddedItemsList.getItems());
				_main.get_CombatVariables().setStarted(true);
			}
		});
		MagicRadioButton.addMouseListener(new MouseAdapter() {
			public void actionPerformed(MouseEvent arg0) {
				//GroupRadioButton.clearSelection();
				AttackCheckBox.setEnabled(false);
				StrengthCheckBox.setEnabled(false);
			}
		});
		RandgeRadioButton.addMouseListener(new MouseAdapter() {
			public void actionPerformed(MouseEvent e) {
				//GroupRadioButton.clearSelection();
				AttackCheckBox.setEnabled(false);
				StrengthCheckBox.setEnabled(false);
			}
		});
		MeleeRadioButton.addMouseListener(new MouseAdapter() {
			public void actionPerformed(MouseEvent e) {
				//GroupRadioButton.clearSelection();
				AttackCheckBox.setEnabled(true);
				StrengthCheckBox.setEnabled(true);
			}
		});
		SearchNPCButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				for(int i = 0; i < _main.get_factory().get_Npcs().GetAllNpc().size(); i++){
					if(!hasElement(_main.get_factory().get_Npcs().GetAllNpc().get(i).getName(), ScannedList)){
						ScannedList.add(_main.get_factory().get_Npcs().GetAllNpc().get(i).getName());
					}
				}
			}
		});
	}
	public JFrame GetJFrame() {
		return frmSettings;
	}
	public static boolean hasElement(Object searched, List list) {
		for (int a = 0; a < list.getItemCount(); a++) {
			Object element = list.getItem(a);
			if (element.equals(searched))  {
				return true;
			}
		}
		return false;
	}
}
