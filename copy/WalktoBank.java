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

public class WalktoBank extends Node {
	
	int bankId = 42377;
	@Override
	public boolean activate() {
		SceneObject bank = SceneEntities.getNearest(new Filter<SceneObject>() {
			public boolean accept(SceneObject entity) {
			return entity.getId() == bankId;}});
	return(Players.getLocal().getLocation().getX() >= 3067
					&&Inventory.getCount(Variables.runeoreId) == 2
						&& bank != null 
							&& !bank.isOnScreen());
		
	}

	@Override
	public void execute() {

		WildRunite.status="walkingtobank";
		
	Walking.newTilePath(Variables.path_wtb).traverse(EnumSet.of(TraversalOption.SPACE_ACTIONS));
        Time.sleep(Random.nextInt(1000, 2000));

	}

}
