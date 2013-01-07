package scripts.WildRunite.copy;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Calculations;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.util.Filter;
import org.powerbot.game.api.wrappers.Tile;
import org.powerbot.game.api.wrappers.node.SceneObject;

public class WalktoRunet extends Node {
	 int blocktwoId = 65207;
	@Override
	public boolean activate() {
		SceneObject blocktwo = SceneEntities.getNearest(new Filter<SceneObject>() {
				public boolean accept(SceneObject entity) {
				return entity.getId() == blocktwoId;}});
	return (Players.getLocal().getLocation().getY() >= 3834 
				&& Players.getLocal().getLocation().getY() < 3883 
					&& Inventory.getCount(Variables.runeoreId) == 0
						&& blocktwo != null
							&& Calculations.distanceTo(blocktwo) >7 );
	}

	@Override
	public void execute() {
		WildRunite.status="walkingtorune3";
		BVwalk.walk(new Tile (3059, 3884, 0));
            }
} 