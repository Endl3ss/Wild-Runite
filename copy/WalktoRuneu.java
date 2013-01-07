package scripts.WildRunite.copy;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.wrappers.Tile;

public class WalktoRuneu extends Node {
	@Override
	public boolean activate() {
	return (Players.getLocal().getLocation().getY() >= 3619
				&& Players.getLocal().getLocation().getY() <3844 
					&& Inventory.getCount(Variables.runeoreId) == 0);
	}

	@Override
	public void execute() {
		WildRunite.status="walkingtorune2";
		BVwalk.walk(new Tile (3003, 3843, 0));
            }
}

