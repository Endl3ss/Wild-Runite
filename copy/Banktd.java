package scripts.WildRunite.copy;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Calculations;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.util.Filter;
import org.powerbot.game.api.util.Time;
import org.powerbot.game.api.wrappers.node.SceneObject;

public class Banktd extends Node {
	int bankId = 42377;
	static boolean once = true; 
	@Override
	public boolean activate() {
		SceneObject bank = SceneEntities.getNearest(new Filter<SceneObject>() {
			public boolean accept(SceneObject entity) {
			return entity.getId() == bankId;}});
		return (Inventory.getCount(Variables.runeoreId) == 2
				&& bank != null
					&& bank.isOnScreen()
							&& once
								&& Calculations.distanceTo(bank) <7
									&&!Widgets.get(762,33).isOnScreen());
	}

	@Override
	public void execute() {
		WildRunite.status="banking";
		SceneObject bank = SceneEntities.getNearest(new Filter<SceneObject>() {
			public boolean accept(SceneObject entity) {
			return entity.getId() == bankId;}});
		if (bank !=null)
			if (bank.isOnScreen()) {
				bank.interact("Bank");
				Time.sleep(1000, 1200);
			}
		if (Widgets.get(762,33).isOnScreen())
			once = false; 

	}

}
