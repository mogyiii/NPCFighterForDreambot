package GUI;

import Combat.Main;
import Factory.AttackType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Window extends JFrame{
	private Main _main;

	public Window(Main main) {
		this._main = main;
		/*try{*/
			Declaration();
			initialize();
		/*}catch (Exception e){
			_main.log("Window error: " + e.toString());
		}*/
	}

	private void Declaration(){
        contentPane = getContentPane();
        springLayout = new SpringLayout();
        contentPane.setLayout(springLayout);


		AddItemTextField = new JTextField();
		StartBtn = new JButton();
		StrengthCheckBox = new JCheckBox();
		PickUpArrowCheckBox = new JCheckBox();
		WorldHopperCheckBox = new JCheckBox();
		ChatBotCheckBox = new JCheckBox();
		AddedItemsList = new List();
		SelectedList = new List();
		AttackCheckBox = new JCheckBox();
		DefendCheckBox = new JCheckBox();
		ScannedList = new List();
		AreaSizeField = new JSpinner();
		PickupItemCostSpinner = new JSpinner();
		SpecialAttackCheckBox = new JCheckBox();
		BuryBonesCheckBox = new JCheckBox();
		percentageValueLabel = new JLabel();
		PickUpItemsLabel = new JLabel();
		RemoveItemButton = new JButton();
		AddItemButton = new JButton();
		AddItemLabel = new JLabel();
		MeleeRadioButton = new JRadioButton();
		RandgeRadioButton = new JRadioButton();
		MagicRadioButton = new JRadioButton();
		ScannedListLabel = new JLabel();
		SelectedListLabel = new JLabel();
		AreaSizeLabel = new JLabel();
		GPLabel = new JLabel();
		PickUpItemLabel = new JLabel();
		SearchNPCButton = new JButton();
		RemoveNpcButton = new JButton();
		AddNpcButton = new JButton();

		GroupRadioButton = new ButtonGroup();
	}

    /*Actions*/
    private void AddNpc(ActionEvent e){
        for(int i = 0; i < ScannedList.getSelectedItems().length; i++) {
            SelectedList.add(ScannedList.getSelectedItems()[i]);
        }
    }
    private void RemoveNpc(ActionEvent e){
        for(int i = 0; i < SelectedList.getSelectedItems().length; i++) {
            SelectedList.remove(SelectedList.getSelectedItems()[i]);
        }
    }
    private void AddItem(ActionEvent e){
        AddedItemsList.add(AddItemTextField.getText());
        AddItemTextField.setText("");
    }
    private void RemoveItem(ActionEvent e){
        for(int i = 0; i < AddedItemsList.getSelectedItems().length; i++) {
            AddedItemsList.remove(AddedItemsList.getSelectedItems()[i]);
        }
    }
    private void StartAction(ActionEvent e){
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
                Integer.parseInt(AreaSizeField.getValue().toString()),
                Integer.parseInt(PickupItemCostSpinner.getValue().toString()),
                SelectedList.getItems(),
                AddedItemsList.getItems());
        _main.get_CombatVariables().setStarted(true);
    }
    private void AttackTypeAction(ActionEvent e, boolean str, boolean att){
        AttackCheckBox.setEnabled(att);
        StrengthCheckBox.setEnabled(str);
    }
    private void SearchNpc(ActionEvent e){
        for(int i = 0; i < _main.get_factory().getNpcs().GetAllNpc().size(); i++){
            if(!hasElement(_main.get_factory().getNpcs().GetAllNpc().get(i).getName(), ScannedList)){
                ScannedList.add(_main.get_factory().getNpcs().GetAllNpc().get(i).getName());
            }
        }
    }
	private void initialize() {

        StartBtn.setText("Start");
		springLayout.putConstraint(SpringLayout.NORTH, StartBtn, -32, SpringLayout.SOUTH, contentPane);
		springLayout.putConstraint(SpringLayout.WEST, StartBtn, 0, SpringLayout.WEST, contentPane);
		springLayout.putConstraint(SpringLayout.SOUTH, StartBtn, 0, SpringLayout.SOUTH, contentPane);
		springLayout.putConstraint(SpringLayout.EAST, StartBtn, -294, SpringLayout.EAST, contentPane);
        contentPane.add(StartBtn);

		ScannedList.setForeground(new Color(255, 255, 255));
		ScannedList.setBackground(new Color(0, 51, 51));
		ScannedList.setMultipleSelections(true);
		springLayout.putConstraint(SpringLayout.NORTH, ScannedList, 20, SpringLayout.NORTH, contentPane);
        contentPane.add(ScannedList);

		SelectedList.setForeground(new Color(255, 255, 255));
		SelectedList.setBackground(new Color(0, 51, 51));
		SelectedList.setMultipleSelections(true);
        contentPane.add(SelectedList);

        AddNpcButton.setText("<-");
		springLayout.putConstraint(SpringLayout.EAST, SelectedList, -6, SpringLayout.WEST, AddNpcButton);
		springLayout.putConstraint(SpringLayout.WEST, ScannedList, 6, SpringLayout.EAST, AddNpcButton);
		springLayout.putConstraint(SpringLayout.WEST, AddNpcButton, 260, SpringLayout.WEST, contentPane);
		springLayout.putConstraint(SpringLayout.EAST, AddNpcButton, -126, SpringLayout.EAST, contentPane);
		springLayout.putConstraint(SpringLayout.NORTH, AddNpcButton, 20, SpringLayout.NORTH, contentPane);
		springLayout.putConstraint(SpringLayout.SOUTH, AddNpcButton, 52, SpringLayout.NORTH, contentPane);
        contentPane.add(AddNpcButton);

        RemoveNpcButton.setText("->");
		springLayout.putConstraint(SpringLayout.NORTH, RemoveNpcButton, 38, SpringLayout.SOUTH, AddNpcButton);
		springLayout.putConstraint(SpringLayout.WEST, RemoveNpcButton, 6, SpringLayout.EAST, SelectedList);
		springLayout.putConstraint(SpringLayout.SOUTH, RemoveNpcButton, 70, SpringLayout.SOUTH, AddNpcButton);
		springLayout.putConstraint(SpringLayout.EAST, RemoveNpcButton, -6, SpringLayout.WEST, ScannedList);
        contentPane.add(RemoveNpcButton);

        SearchNPCButton.setText("Scan");
		springLayout.putConstraint(SpringLayout.EAST, ScannedList, 0, SpringLayout.EAST, SearchNPCButton);
		springLayout.putConstraint(SpringLayout.WEST, SearchNPCButton, 372, SpringLayout.WEST, contentPane);
		springLayout.putConstraint(SpringLayout.SOUTH, ScannedList, -6, SpringLayout.NORTH, SearchNPCButton);
		springLayout.putConstraint(SpringLayout.NORTH, SearchNPCButton, 188, SpringLayout.NORTH, contentPane);
        contentPane.add(SearchNPCButton);

        BuryBonesCheckBox.setText("Bury Bones");
		springLayout.putConstraint(SpringLayout.NORTH, BuryBonesCheckBox, 10, SpringLayout.NORTH, contentPane);
		springLayout.putConstraint(SpringLayout.WEST, BuryBonesCheckBox, 10, SpringLayout.WEST, contentPane);
        contentPane.add(BuryBonesCheckBox);
		BuryBonesCheckBox.setSelected(true);

        SpecialAttackCheckBox.setText("Special attack");
		springLayout.putConstraint(SpringLayout.NORTH, SpecialAttackCheckBox, 6, SpringLayout.SOUTH, BuryBonesCheckBox);
		springLayout.putConstraint(SpringLayout.WEST, SpecialAttackCheckBox, 10, SpringLayout.WEST, contentPane);
        contentPane.add(SpecialAttackCheckBox);
		SpecialAttackCheckBox.setSelected(true);

		springLayout.putConstraint(SpringLayout.NORTH, PickupItemCostSpinner, 18, SpringLayout.SOUTH, SearchNPCButton);
        contentPane.add(PickupItemCostSpinner);

        PickUpItemLabel.setText("Pick up item");
		springLayout.putConstraint(SpringLayout.EAST, PickUpItemLabel, -109, SpringLayout.EAST, contentPane);
		springLayout.putConstraint(SpringLayout.WEST, PickupItemCostSpinner, 6, SpringLayout.EAST, PickUpItemLabel);
		springLayout.putConstraint(SpringLayout.NORTH, PickUpItemLabel, 3, SpringLayout.NORTH, PickupItemCostSpinner);
        contentPane.add(PickUpItemLabel);

        GPLabel.setText("Gp");
		springLayout.putConstraint(SpringLayout.EAST, PickupItemCostSpinner, -6, SpringLayout.WEST, GPLabel);
		springLayout.putConstraint(SpringLayout.NORTH, GPLabel, 232, SpringLayout.NORTH, contentPane);
		springLayout.putConstraint(SpringLayout.EAST, GPLabel, -5, SpringLayout.EAST, contentPane);
        contentPane.add(GPLabel);

		AreaSizeField.setValue(8);
		springLayout.putConstraint(SpringLayout.NORTH, AreaSizeField, 18, SpringLayout.SOUTH, PickupItemCostSpinner);
		springLayout.putConstraint(SpringLayout.WEST, AreaSizeField, 355, SpringLayout.WEST, contentPane);
		springLayout.putConstraint(SpringLayout.EAST, AreaSizeField, 0, SpringLayout.EAST, PickupItemCostSpinner);
        contentPane.add(AreaSizeField);

        AreaSizeLabel.setText("Area size");
		springLayout.putConstraint(SpringLayout.NORTH, AreaSizeLabel, 3, SpringLayout.NORTH, AreaSizeField);
		springLayout.putConstraint(SpringLayout.EAST, AreaSizeLabel, -6, SpringLayout.WEST, AreaSizeField);
        contentPane.add(AreaSizeLabel);

        SelectedListLabel.setText("Selected List");
		springLayout.putConstraint(SpringLayout.SOUTH, SelectedListLabel, -576, SpringLayout.SOUTH, contentPane);
		springLayout.putConstraint(SpringLayout.NORTH, SelectedList, 6, SpringLayout.SOUTH, SelectedListLabel);
		springLayout.putConstraint(SpringLayout.WEST, SelectedListLabel, 78, SpringLayout.EAST, BuryBonesCheckBox);
        contentPane.add(SelectedListLabel);

        ScannedListLabel.setText("Scanned List");
		springLayout.putConstraint(SpringLayout.NORTH, ScannedListLabel, 0, SpringLayout.NORTH, SelectedListLabel);
		springLayout.putConstraint(SpringLayout.EAST, ScannedListLabel, -32, SpringLayout.EAST, contentPane);
        contentPane.add(ScannedListLabel);

        MagicRadioButton.setText(AttackType.Magic.toString());
		springLayout.putConstraint(SpringLayout.WEST, MagicRadioButton, 0, SpringLayout.WEST, BuryBonesCheckBox);
        contentPane.add(MagicRadioButton);
		GroupRadioButton.add(MagicRadioButton);
		MagicRadioButton.setActionCommand(AttackType.Magic.toString());

        RandgeRadioButton.setText(AttackType.Range.toString());
		springLayout.putConstraint(SpringLayout.SOUTH, MagicRadioButton, -6, SpringLayout.NORTH, RandgeRadioButton);
		springLayout.putConstraint(SpringLayout.WEST, RandgeRadioButton, 0, SpringLayout.WEST, BuryBonesCheckBox);
		springLayout.putConstraint(SpringLayout.SOUTH, RandgeRadioButton, 0, SpringLayout.SOUTH, SearchNPCButton);
        contentPane.add(RandgeRadioButton);
		GroupRadioButton.add(RandgeRadioButton);
		RandgeRadioButton.setActionCommand(AttackType.Range.toString());

        MeleeRadioButton.setText(AttackType.Melee.toString());
		springLayout.putConstraint(SpringLayout.NORTH, MeleeRadioButton, 6, SpringLayout.SOUTH, RandgeRadioButton);
		springLayout.putConstraint(SpringLayout.WEST, MeleeRadioButton, 0, SpringLayout.WEST, BuryBonesCheckBox);
        contentPane.add(MeleeRadioButton);
		GroupRadioButton.add(MeleeRadioButton);
		MeleeRadioButton.setActionCommand(AttackType.Melee.toString());
		MeleeRadioButton.setSelected(true);

        contentPane.add(AddItemTextField);
		AddItemTextField.setColumns(10);

        AddItemLabel.setText("Item name:");
		springLayout.putConstraint(SpringLayout.NORTH, AddItemTextField, -3, SpringLayout.NORTH, AddItemLabel);
		springLayout.putConstraint(SpringLayout.WEST, AddItemTextField, 6, SpringLayout.EAST, AddItemLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, AddItemLabel, -197, SpringLayout.SOUTH, contentPane);
        contentPane.add(AddItemLabel);

        AddItemButton.setText("Add");
		springLayout.putConstraint(SpringLayout.EAST, AddItemButton, -53, SpringLayout.EAST, contentPane);
        contentPane.add(AddItemButton);

		springLayout.putConstraint(SpringLayout.SOUTH, SelectedList, -188, SpringLayout.NORTH, AddedItemsList);
		AddedItemsList.setForeground(new Color(255, 255, 255));
		AddedItemsList.setBackground(new Color(0, 51, 51));
		springLayout.putConstraint(SpringLayout.WEST, AddItemButton, 85, SpringLayout.EAST, AddedItemsList);
		springLayout.putConstraint(SpringLayout.WEST, AddItemLabel, 27, SpringLayout.EAST, AddedItemsList);
		springLayout.putConstraint(SpringLayout.SOUTH, AddedItemsList, -103, SpringLayout.NORTH, StartBtn);
		AddedItemsList.setMultipleSelections(true);
		springLayout.putConstraint(SpringLayout.WEST, AddedItemsList, 10, SpringLayout.WEST, contentPane);
		springLayout.putConstraint(SpringLayout.EAST, AddedItemsList, 210, SpringLayout.WEST, contentPane);
        contentPane.add(AddedItemsList);

        RemoveItemButton.setText("Remove");
		springLayout.putConstraint(SpringLayout.WEST, RemoveItemButton, 85, SpringLayout.EAST, AddedItemsList);
		springLayout.putConstraint(SpringLayout.EAST, RemoveItemButton, -53, SpringLayout.EAST, contentPane);
		springLayout.putConstraint(SpringLayout.SOUTH, AddItemButton, -6, SpringLayout.NORTH, RemoveItemButton);
		springLayout.putConstraint(SpringLayout.SOUTH, RemoveItemButton, 0, SpringLayout.SOUTH, AddedItemsList);
        contentPane.add(RemoveItemButton);

        PickUpItemsLabel.setText("Pick up Items:");
		springLayout.putConstraint(SpringLayout.WEST, PickUpItemsLabel, 10, SpringLayout.WEST, contentPane);
		springLayout.putConstraint(SpringLayout.NORTH, AddedItemsList, 6, SpringLayout.SOUTH, PickUpItemsLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, PickUpItemsLabel, -226, SpringLayout.SOUTH, contentPane);
        contentPane.add(PickUpItemsLabel);

		springLayout.putConstraint(SpringLayout.WEST, percentageValueLabel, 89, SpringLayout.WEST, contentPane);
		springLayout.putConstraint(SpringLayout.SOUTH, percentageValueLabel, -60, SpringLayout.NORTH, AddedItemsList);
        contentPane.add(percentageValueLabel);

        ChatBotCheckBox.setText("ChatBot");
		springLayout.putConstraint(SpringLayout.NORTH, ChatBotCheckBox, 6, SpringLayout.SOUTH, SpecialAttackCheckBox);
		springLayout.putConstraint(SpringLayout.WEST, ChatBotCheckBox, 10, SpringLayout.WEST, contentPane);
        contentPane.add(ChatBotCheckBox);
		ChatBotCheckBox.setSelected(true);

        WorldHopperCheckBox.setText("WorldHopper");
		springLayout.putConstraint(SpringLayout.NORTH, WorldHopperCheckBox, 5, SpringLayout.NORTH, RemoveNpcButton);
		springLayout.putConstraint(SpringLayout.WEST, WorldHopperCheckBox, 0, SpringLayout.WEST, BuryBonesCheckBox);
        contentPane.add(WorldHopperCheckBox);
		WorldHopperCheckBox.setSelected(true);

        PickUpArrowCheckBox.setText("Pick Up Arrow");
		springLayout.putConstraint(SpringLayout.NORTH, PickUpArrowCheckBox, 6, SpringLayout.SOUTH, WorldHopperCheckBox);
		springLayout.putConstraint(SpringLayout.EAST, PickUpArrowCheckBox, 0, SpringLayout.EAST, SpecialAttackCheckBox);
        contentPane.add(PickUpArrowCheckBox);

        AttackCheckBox.setText("Attack");
		springLayout.putConstraint(SpringLayout.NORTH, AttackCheckBox, 19, SpringLayout.SOUTH, MeleeRadioButton);
		springLayout.putConstraint(SpringLayout.WEST, AttackCheckBox, 0, SpringLayout.WEST, BuryBonesCheckBox);
        contentPane.add(AttackCheckBox);


        StrengthCheckBox.setText("Strength");
		springLayout.putConstraint(SpringLayout.NORTH, StrengthCheckBox, 6, SpringLayout.SOUTH, AttackCheckBox);
		springLayout.putConstraint(SpringLayout.WEST, StrengthCheckBox, 0, SpringLayout.WEST, BuryBonesCheckBox);
        contentPane.add(StrengthCheckBox);

        DefendCheckBox.setText("Defend");
		springLayout.putConstraint(SpringLayout.NORTH, DefendCheckBox, 6, SpringLayout.SOUTH, StrengthCheckBox);
		springLayout.putConstraint(SpringLayout.WEST, DefendCheckBox, 0, SpringLayout.WEST, BuryBonesCheckBox);
        contentPane.add(DefendCheckBox);

		/*Action*/
		AddNpcButton.addActionListener(e -> AddNpc(e));

		RemoveNpcButton.addActionListener(e -> RemoveNpc(e));

		AddItemButton.addActionListener(e -> AddItem(e));

		RemoveItemButton.addActionListener(e -> RemoveItem(e));
		StartBtn.addActionListener(e -> StartAction(e));
		MagicRadioButton.addActionListener(e -> AttackTypeAction(e, false, false));
		RandgeRadioButton.addActionListener(e -> AttackTypeAction(e, false, false));
		MeleeRadioButton.addActionListener(e -> AttackTypeAction(e, true, true));
		SearchNPCButton.addActionListener(e ->  SearchNpc(e));
		/*End Actions*/

        WindowSettings();
	}
	private void WindowSettings(){
        { // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        contentPane.setPreferredSize(new Dimension(453, 589));
        pack();
        setLocationRelativeTo(getOwner());
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
    private ButtonGroup GroupRadioButton;
    private JTextField AddItemTextField;
    private JCheckBox PickUpArrowCheckBox;
    private JCheckBox WorldHopperCheckBox;
    private JCheckBox ChatBotCheckBox;
    private List AddedItemsList;
    private List SelectedList;
    private JCheckBox StrengthCheckBox;
    private JCheckBox AttackCheckBox;
    private JCheckBox DefendCheckBox;
    private List ScannedList;
    private JSpinner AreaSizeField;
    private JSpinner PickupItemCostSpinner;
    private JCheckBox SpecialAttackCheckBox;
    private JCheckBox BuryBonesCheckBox;
    private SpringLayout springLayout;
    private JButton StartBtn;
    private JLabel percentageValueLabel;

    private JLabel PickUpItemsLabel;
    private JButton RemoveItemButton;
    private JButton AddItemButton;
    private JLabel AddItemLabel;
    private JRadioButton MeleeRadioButton;
    private JRadioButton RandgeRadioButton;
    private JRadioButton MagicRadioButton;
    private JLabel ScannedListLabel;
    private JLabel SelectedListLabel;
    private JLabel AreaSizeLabel;
    private JLabel GPLabel;
    private JLabel PickUpItemLabel;
    private JButton SearchNPCButton;
    private JButton RemoveNpcButton;
    private JButton AddNpcButton;
    private Container contentPane;
}
