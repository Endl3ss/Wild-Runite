package scripts.WildRunite.copy;

import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.wrappers.Tile;

public class BVwalk {
	/**
	 * @author Alaineman
	 * @author Bob
	 */

	    public static void walk(Tile goaltile) {
	        Tile intermediate = goaltile;
	        while (!intermediate.isOnMap()) {
	            intermediate = new Tile(Math.round((intermediate.getX() + Players
	                    .getLocal().getLocation().getX()) / 2),
	                    Math.round((intermediate.getY() + Players.getLocal()
	                    .getLocation().getY()) / 2),
	                    intermediate.getPlane());
	        }

	        Walking.walk(intermediate);
	    }
	
}

