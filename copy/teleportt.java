package scripts.WildRunite.copy;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.interactive.Players;

public class teleportt extends Node {
	int bankId = 42217;
	int blockId = 65207;
	static boolean once = true; 
	@Override
	public boolean activate() {
		
		return (Players.getLocal().getLocation().getY() == 3634
				&& Players.getLocal().getLocation().getX() == 3004
					&& once);}

	@Override
	public void execute() {
		WildRunite.status="teleport1"; {
			Widgets.get(679, 0).getChild(8).click(true);
			Task.sleep(1500);
		}
		if (Widgets.get(1092,45).isOnScreen())
		once = false;
	}
}