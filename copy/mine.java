package scripts.WildRunite.copy;

import java.util.Arrays;

import org.powerbot.core.event.events.MessageEvent;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.util.Filter;
import org.powerbot.game.api.util.Time;
import org.powerbot.game.api.wrappers.node.SceneObject;

public class mine extends Node {
	int runeId[] = { 14859, 14860 };
	// filter
	private final Filter<SceneObject> ROCK_FILTER = new Filter<SceneObject>() {
		public boolean accept(SceneObject rock) {
			Arrays.sort(runeId);
			return Arrays.binarySearch(runeId, rock.getId()) >= 0;
		}
	};
	

	@Override
	public boolean activate() {
		return (Players.getLocal().getAnimation() == -1 
				&& SceneEntities.getNearest(ROCK_FILTER)!=null
						&&Players.getLocal().getLocation().getY() >= 3881
							&& Players.getLocal().getLocation().getX() == 3059
								&& Inventory.getCount(Variables.runeoreId) < 2);
	}

	@Override
	public void execute() {
		WildRunite.status = "mining";

		SceneObject rock = SceneEntities.getNearest(new Filter<SceneObject>() {
			public boolean accept(SceneObject entity) {
				return entity.getId() == 14859 || entity.getId() == 14860;
			}
		});
		if (rock != null) {
			if (rock.isOnScreen()) {
				rock.interact("Mine");
				Time.sleep(900, 1000);
			}
		}
	}


/**public void messageReceived(MessageEvent e) {
    String Message = e.getMessage().toLowerCase();
    if (Message.contains("you get some")) {
       	;
    	}
    }**/
}
  