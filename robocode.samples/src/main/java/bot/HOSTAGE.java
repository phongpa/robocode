/**
 * 
 */
package bot;

import java.awt.Color;

import robocode.AdvancedRobot;
import robocode.HitByBulletEvent;
import robocode.HitWallEvent;
import robocode.ScannedRobotEvent;
import robocode.TurnCompleteCondition;

/**
 * HOSTAGE - a hostage robot
 * 
 * @author anhphong
 *
 */
public class HOSTAGE extends AdvancedRobot {
	private boolean movingForward = false;

	/**
	 * run: HOSTAGE's default behavior
	 */
	public void run() {
		 setColors(Color.gray, Color.gray,Color.gray); // body,gun,radar

		// Robot main loop
		while(true) {
			ahead(40000);
			movingForward = true;
			setTurnRight(90);
			waitFor(new TurnCompleteCondition(this));
			setTurnLeft(180);
			waitFor(new TurnCompleteCondition(this));
			setTurnRight(180);
			waitFor(new TurnCompleteCondition(this));
		}
	}

	public void onScannedRobot(ScannedRobotEvent e) {
		doNothing();
	}

	public void onHitByBullet(HitByBulletEvent e) {
		doNothing();
	}
	
	public void onHitWall(HitWallEvent e) {
		reverseDirection();
	}
	
	public void reverseDirection() {
		if (movingForward) {
			setBack(40000);
			movingForward = false;
		} else {
			setAhead(40000);
			movingForward = true;
		}
	}
}
