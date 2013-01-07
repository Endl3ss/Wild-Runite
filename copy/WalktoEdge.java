package scripts.WildRunite.copy;

import java.util.EnumSet;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.util.Time;
import org.powerbot.game.api.wrappers.Tile;
import org.powerbot.game.api.wrappers.map.Path.TraversalOption;

public class WalktoEdge extends Node {	
	@Override
	public boolean activate() {
		return (Inventory.getCount(Variables.runeoreId)==0 
				&& Players.getLocal().getAnimation() == -1 
					&& Players.getLocal().getLocation().getY() <= 3518
						&& !Widgets.get(906,25).isOnScreen());
		
	}
	@Override
	public void execute() {
		WildRunite.status="walkingtoedge";
		if (!Widgets.get(906,25).isOnScreen()) {
		Walking.newTilePath(Variables.path_wte).traverse(EnumSet.of(TraversalOption.SPACE_ACTIONS));
		Time.sleep(2000);}}
	}