package scripts.WildRunite.copy;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.SwingUtilities;
import java.awt.*;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.net.URL;

import org.powerbot.core.event.listeners.PaintListener;
import org.powerbot.core.script.ActiveScript;
import org.powerbot.core.script.job.Job;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.core.script.job.state.Tree;
import org.powerbot.game.api.Manifest;
import org.powerbot.game.api.util.Random;

@Manifest(authors = { "Endl3ss" }, name = "WildRuniteFree", description = "Mines rune in wilderness start at edgeville bank and have edgeville lodestone activated", version = 1.0)
public class WildRunite extends ActiveScript implements PaintListener {

	int runeId[] = { 14859, 14860 };
	
	//paint
	private final List<Node> jobsCollection = Collections.synchronizedList(new ArrayList<Node>());
    private Tree jobContainer = null;
    
    public static String status="initializing";
    

    public synchronized final void provide(final Node... jobs) {
        for (final Node job : jobs) {
            if(!jobsCollection.contains(job)) {
                jobsCollection.add(job);
            }
        }
        jobContainer = new Tree(jobsCollection.toArray(new Node[jobsCollection.size()]));
    }

    public synchronized final void revoke(final Node... jobs) {
        for (final Node job : jobs) {
            if(jobsCollection.contains(job)) {
                jobsCollection.remove(job);
            }
        }
        jobContainer = new Tree(jobsCollection.toArray(new Node[jobsCollection.size()]));
    }

    public final void submit(final Job... jobs) {
        for (final Job job : jobs) {
            getContainer().submit(job);
        }
    }
    static Gui g = new Gui();
    public void onStart() {
    	
    	g.setVisible(true);
    	  while(Gui.guiWait) sleep(500);
    	
    		
    		
    		
        provide(new AntibanTask(), new mine(), new WalktoTele(), 
        		new teleport(), new teleportt(), new teleportu(), new WalktoEdge(), new crossEdge(), 
        		new WalktoRune(), new WalktoRuneu(), new WalktoRunet(), new WalktoSpot(),
        		new WalktoBank(), new Banktd(),new Banktx()
        		);
    }

    @Override
    public int loop() {
        if (jobContainer != null) {
            final Node job = jobContainer.state();
            if (job != null) {
                jobContainer.set(job);
                getContainer().submit(job);
                job.join();
            }
        }
        return Random.nextInt(10, 50);
    }

    //START: Code generated using Enfilade's Easel
    private Image getImage(String url) {
        try {
            return ImageIO.read(new URL(url));
        } catch(IOException e) {
            return null;
        }
    }
    
    private final Color color1 = new Color(255, 204, 0);

    private final Font font1 = new Font("Harlow Solid Italic", 0, 19);

    private final Image img1 = getImage("http://img525.imageshack.us/img525/1760/wildrunitexcf.png");

    public void onRepaint(Graphics g1) {
        Graphics2D g = (Graphics2D)g1;
        g.drawImage(img1, 6, 264, null);
        g.setFont(font1);
        g.setColor(color1);
        g.drawString("Rune Mined:", 192, 403);
        g.drawString("Deaths:", 198, 426);
        g.drawString("na", 314, 405);
        g.drawString("na", 313, 426);
        g.drawString("na", 310, 453);
        g.drawString(status, 15, 355);
        g.drawString("Runtime:", 193, 451);
    }

}
