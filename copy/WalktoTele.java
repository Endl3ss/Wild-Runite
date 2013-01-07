package scripts.WildRunite.copy;

import java.util.EnumSet;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Calculations;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.util.Filter;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.util.Time;
import org.powerbot.game.api.wrappers.Tile;
import org.powerbot.game.api.wrappers.map.Path.TraversalOption;
import org.powerbot.game.api.wrappers.node.SceneObject;

public class WalktoTele extends Node {
	@Override
	public boolean activate() {
		return (Players.getLocal().getLocation().getY() > 3634
					&& Inventory.getCount(Variables.runeoreId) == 2
					);}
	@Override
	public void execute() {

		WildRunite.status="walkingtotele";
		
				Walking.newTilePath(Variables.path_wtt).traverse(EnumSet.of(TraversalOption.SPACE_ACTIONS));
        Time.sleep(Random.nextInt(1000, 2000));
	}		
}



