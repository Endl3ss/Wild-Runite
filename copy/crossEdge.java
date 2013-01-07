package scripts.WildRunite.copy;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Calculations;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.util.Filter;
import org.powerbot.game.api.util.Time;
import org.powerbot.game.api.wrappers.node.SceneObject;

public class crossEdge extends Node {
	int edgeId = 65080;
	int blockId = 65149;
	int blocktwoId = 77834;
	/**SceneObject edge = SceneEntities.getNearest(new Filter<SceneObject>() {
		public boolean accept(SceneObject entity) {
			return entity.getId() == edgeId;}});
	  SceneObject block = SceneEntities.getNearest(new Filter<SceneObject>() {
			public boolean accept(SceneObject entity) {
			return entity.getId() == blockId;}});
	  SceneObject blocktwo = SceneEntities.getNearest(new Filter<SceneObject>() {
			public boolean accept(SceneObject entity) {
			return entity.getId() == blocktwoId;}});**/
	@Override
	public boolean activate() {
		return (Players.getLocal().getLocation().getY() <= 3520
					&& Players.getLocal().getLocation().getY() >= 3519) ;
	}	

	@Override
	public void execute() {
		SceneObject edge = SceneEntities.getNearest(new Filter<SceneObject>() {
			public boolean accept(SceneObject entity) {
				return entity.getId() == edgeId;}});
		WildRunite.status="crossingedge";
			if (Players.getLocal().getLocation().getY() >= 3519){
					edge.interact("Cross");
					Time.sleep(1200,1000);
			}
		}
	}


