package Factory;

import java.util.Arrays;

public class WindowVariables {
	private boolean isBuryBones;
	private boolean isUseSpecialAttack;
	private boolean isUseChatBot;
	private boolean isUseWorldHopper;
	private boolean isPickUpArrow;
	private boolean isUseStrength;
	private boolean isUseAttack;
	private boolean isUseDefend;
	private AttackType AttackType;
	private int AreaSize;
	private int PickupItemCost;
	private String[] SelectedList;
	private String[] PickUpItems;

	public boolean isBuryBones() {
		return isBuryBones;
	}

	public void setBuryBones(boolean buryBones) {
		isBuryBones = buryBones;
	}

	public boolean isUseSpecialAttack() {
		return isUseSpecialAttack;
	}

	public void setUseSpecialAttack(boolean useSpecialAttack) {
		isUseSpecialAttack = useSpecialAttack;
	}

	public boolean isUseChatBot() {
		return isUseChatBot;
	}

	public void setUseChatBot(boolean useChatBot) {
		isUseChatBot = useChatBot;
	}

	public boolean isUseWorldHopper() {
		return isUseWorldHopper;
	}

	public void setUseWorldHopper(boolean useWorldHopper) {
		isUseWorldHopper = useWorldHopper;
	}

	public boolean isPickUpArrow() {
		return isPickUpArrow;
	}

	public void setPickUpArrow(boolean pickUpArrow) {
		isPickUpArrow = pickUpArrow;
	}

	public boolean isUseStrength() {
		return isUseStrength;
	}

	public void setUseStrength(boolean useStrength) {
		isUseStrength = useStrength;
	}

	public boolean isUseAttack() {
		return isUseAttack;
	}

	public void setUseAttack(boolean useAttack) {
		isUseAttack = useAttack;
	}

	public boolean isUseDefend() {
		return isUseDefend;
	}

	public void setUseDefend(boolean useDefend) {
		isUseDefend = useDefend;
	}

	public Factory.AttackType getAttackType() {
		return AttackType;
	}

	public void setAttackType(Factory.AttackType attackType) {
		AttackType = attackType;
	}

	public int getAreaSize() {
		return AreaSize;
	}

	public void setAreaSize(int areaSize) {
		AreaSize = areaSize;
	}

	public int getPickupItemCost() {
		return PickupItemCost;
	}

	public void setPickupItemCost(int pickupItemCost) {
		PickupItemCost = pickupItemCost;
	}

	public String[] getSelectedList() {
		return SelectedList;
	}

	public void setSelectedList(String[] selectedList) {
		SelectedList = selectedList;
	}

	public String[] getPickUpItems() {
		return PickUpItems;
	}

	public void setPickUpItems(String[] pickUpItems) {
		PickUpItems = pickUpItems;
	}

	public void SetAll(boolean _isBuryBones,
						boolean _isUseSpecialAttack,
						boolean _isUseChatBot,
						boolean _isUseWorldHopper,
						boolean _isPickUpArrow,
						boolean _isUseStrength,
						boolean _isUseAttack,
						boolean _isUseDefend,
						AttackType _AttackType,
						int _AreaSize,
						int _PickupItemCost,
						String[] _SelectedList,
						String[] _PickUpItems){

		isBuryBones = _isBuryBones;
		isUseSpecialAttack = _isUseSpecialAttack;
		isUseChatBot=_isUseChatBot;
		isUseWorldHopper=_isUseWorldHopper;
		isPickUpArrow=_isPickUpArrow;
		isUseStrength=_isUseStrength;
		isUseAttack=_isUseAttack;
		isUseDefend=_isUseDefend;
		AttackType=_AttackType;
		AreaSize=_AreaSize;
		PickupItemCost=_PickupItemCost;
		SelectedList=_SelectedList;
		PickUpItems=_PickUpItems;

	}
	@Override
	public String toString() {
		return "WindowVariables{" +
				"isBuryBones=" + isBuryBones +
				", isUseSpecialAttack=" + isUseSpecialAttack +
				", isUseChatBot=" + isUseChatBot +
				", isUseWorldHopper=" + isUseWorldHopper +
				", isPickUpArrow=" + isPickUpArrow +
				", isUseStrength=" + isUseStrength +
				", isUseAttack=" + isUseAttack +
				", isUseDefend=" + isUseDefend +
				", AttackType=" + AttackType +
				", AreaSize=" + AreaSize +
				", PickupItemCost=" + PickupItemCost +
				", SelectedList=" + Arrays.toString(SelectedList) +
				", PickUpItems=" + Arrays.toString(PickUpItems) +
				'}';
	}
}
