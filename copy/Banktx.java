package scripts.WildRunite.copy;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Bank;
import org.powerbot.game.api.util.Time;
import org.powerbot.game.api.wrappers.node.Item;

public class Banktx extends Node {
	static boolean once = true;
	//bank everything but one item
	/**public void bankAllExcept(int... dontBankThis) {
		for (Item i : Inventory.getItems()) {
		for (int id : dontBankThis) {
			 if (!(i.getId() == id)) {
			 i.getWidgetChild().interact("Deposit-All");
			 Time.sleep(1000);
			 }
		}
		}
	}**/

	@Override
	public boolean activate() {
		return (Inventory.getCount(Variables.runeoreId) == 2
					&& Widgets.get(762,33).isOnScreen());}

	@Override
	public void execute() {
		WildRunite.status="banking1";
	//method 2 to bank everything
	/**	Widgets.get(762, 33).click(true);
		Task.sleep(1500);
		if (Widgets.get(762).validate() && !(Inventory.getCount(runeoreId) == 0)){
			Bank.deposit(runeoreId, Variables.rune); //For AMOUNT_TO_DEPOSIT put 0 for all.
			Time.sleep(1000);
			}**/
		//bankeverything but one item
		/**if (Widgets.get(762).validate() && !(Inventory.getCount() == 1)) {
			bankAllExcept(runepickId);
			Time.sleep(500);}**/
	if (Widgets.get(762).validate() && !(Inventory.getCount() == 0)){
			Bank.depositInventory();
			Time.sleep(1000);
			}
	}
}
