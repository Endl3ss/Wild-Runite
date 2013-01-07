package scripts.WildRunite.copy;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.util.Time;
import org.powerbot.game.api.wrappers.Tile;

public class death extends Node {

	@Override
	public boolean activate() {
		return Players.getLocal().getLocation().getY() == 3488
				&&Players.getLocal().getLocation().getX() == 3102;
	}

	@Override
	public void execute() {
		WildRunite.status="deathwalk";
		Walking.newTilePath(Variables.path_wtd).traverse();
        Time.sleep(Random.nextInt(1000, 2000));
	}

}
