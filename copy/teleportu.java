package scripts.WildRunite.copy;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.interactive.Players;

public class teleportu extends Node {
	static boolean once = true; 

	@Override
	public boolean activate() {
		 return (Players.getLocal().getAnimation() == -1
				 &&Players.getLocal().getLocation().getY() == 3634
					&& Players.getLocal().getLocation().getX() == 3004
						&& once); 
	}

	@Override
	public void execute() {
		WildRunite.status="teleport2";
	 Widgets.get(1092, 45).click(true);
		Task.sleep(15000);
		once = false; 

	}
	
}
