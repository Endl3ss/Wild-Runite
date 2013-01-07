package scripts.WildRunite.copy;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Calculations;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.util.Filter;
import org.powerbot.game.api.wrappers.Tile;
import org.powerbot.game.api.wrappers.node.SceneObject;

public class teleport extends Node {
	int runeoreId = 451;
	int bankID = 42373;
	int loadID = 65268;
	static boolean once = true; 
	SceneObject load = SceneEntities.getNearest(loadID);
	public boolean accept(SceneObject entity) {
		return entity.getId() == loadID;};
	
	@Override
	public boolean activate() {
	
		return (Players.getLocal().getLocation().getY() == 3634
				&& Players.getLocal().getLocation().getX() == 3004
					&& once
						&& Inventory.getCount(runeoreId) == 2);}

	@Override
	public void execute() {
		
		WildRunite.status="teleport";
		
		if (Widgets.get(548,123).isOnScreen()){
			Widgets.get(548,123).click(true);
			Task.sleep(1500);
			}
		if (Widgets.get(275, 11).isOnScreen())
		once = false; 
	} 

}


