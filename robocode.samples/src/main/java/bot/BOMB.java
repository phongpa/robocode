/**
 * 
 */
package bot;

import java.awt.Color;

import robocode.AdvancedRobot;
import robocode.HitByBulletEvent;
import robocode.HitRobotEvent;
import robocode.HitWallEvent;
import robocode.ScannedRobotEvent;
import robocode.TurnCompleteCondition;

/**
 * HOSTAGE - a bomb robot
 * 
 * @author anhphong
 *
 */
public class BOMB extends AdvancedRobot {

	/**
	 * run: 's default behavior
	 */
	public void run() {
		setColors(Color.red, Color.red, Color.red); // body,gun,radar

		// Robot main loop
		while(true) {
			doNothing();
		}
	}

	public void onScannedRobot(ScannedRobotEvent e) {
		doNothing();
	}
	
	public void onHitByBullet(HitByBulletEvent e) {
		doNothing();
	}
	
	public void onHitWall(HitWallEvent e) {
		doNothing();
	}

}
