package scripts.WildRunite.copy;

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
import org.powerbot.game.api.wrappers.node.SceneObject;

public class WalktoSpot extends Node {
	public final Tile[] path_wts = {
            new Tile(3059, 3883, 0)};
	int runeoreId = 451;
	int blocktwoId = 65207;
	
	@Override
	public boolean activate() {
		SceneObject blocktwo = SceneEntities.getNearest(new Filter<SceneObject>() {
			public boolean accept(SceneObject entity) {
			return entity.getId() == blocktwoId;}});
		return (Players.getLocal().getLocation().getY() >= 3885
				&&Players.getLocal().getLocation().getX() >= 3058
					&& !(Players.getLocal().getLocation().getY() == 3884)
						&&!(Players.getLocal().getLocation().getX() == 3059)
							&&Inventory.getCount(runeoreId) == 0
								&& blocktwo != null
									&& Calculations.distanceTo(blocktwo) >5 );
	}

	@Override
	public void execute() {
		WildRunite.status="failsafewalkingtorune";
		Walking.newTilePath(path_wts).traverse();
        Time.sleep(Random.nextInt(1000, 2000));
        }
        
}
