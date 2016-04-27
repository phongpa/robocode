/**
 * 
 */
package bot;

import java.awt.Color;
import java.util.Random;

import robocode.AdvancedRobot;
import robocode.HitByBulletEvent;
import robocode.HitRobotEvent;
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
	boolean movingForward;

	public void run() {
		setColors(Color.gray, Color.gray,Color.gray); // body,gun,radar

		while (true) {
			setAhead(randomBetween(0, 99999));
			movingForward = true;
			setTurnRight(randomBetween(0, 90));
			waitFor(new TurnCompleteCondition(this));
			setTurnLeft(randomBetween(90, 180));
			waitFor(new TurnCompleteCondition(this));
			setTurnRight(randomBetween(90, 180));
			waitFor(new TurnCompleteCondition(this));
		}
	}

	public void onHitWall(HitWallEvent e) {
		reverseDirection();
	}

	public void reverseDirection() {
		if (movingForward) {
			setBack(randomBetween(0, 99999));
			movingForward = false;
		} else {
			setAhead(randomBetween(0, 99999));
			movingForward = true;
		}
	}

	public void onScannedRobot(ScannedRobotEvent e) {
		doNothing();
	}

	public void onHitRobot(HitRobotEvent e) {
		if (e.isMyFault()) {
			reverseDirection();
		}
	}

	private int randomBetween(Integer min, Integer max) {
		Random rand = new Random();
		int num = rand.nextInt(max - min + 1) + min;
		return num;
	}
}
