/**
 * This program will ask the user for a distance and then based on that distance calculate and tell the 
 * user the best angle and speed/velocity to hit the target, as well as the distance travelled and how
 * much the user missed the center of the target by
 * 
 * @author Isaac Nagle
 * @version 10012022
 **/
import java.util.Scanner;

public class TrajectoryModeling {

	public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in); //declare scanner object
      
      double distanceFromTarget; //declare variable for distance from target
      
      System.out.println("Enter a distance to target: "); //asks user for a distance
      distanceFromTarget = scnr.nextDouble();
      
      //double variable declarations for first equation
      double angle = 25.00;
      double g = 9.8; 
      double sinAngle = Math.sin(Math.toRadians(angle));
      double speed = 0;
      double distanceTravelled = 0;
      double bestMiss = 1.7e+308;
      double distanceMissed = 0;
      double bestAngle = 0;
      double bestSpeed = 0;
      
      //loop for incrementing angle by 5.00 
      for (angle = 25.00; angle <= 85.00; angle += 5.00) {
         sinAngle = Math.sin(Math.toRadians(angle));
         for (double i = 1.00; i <= 29.00; i += 1.00) {
            speed = i;
         
         //double variable declarations for second equation
         double timeInAir = ((2 * speed * sinAngle) / g);
         double cosAngle = Math.cos(Math.toRadians(angle));
         distanceTravelled = (speed * timeInAir * cosAngle);
         distanceMissed = distanceFromTarget - distanceTravelled;
         
         //if statements to determine the best angle and speed
         if (Math.abs(distanceMissed) < Math.abs(bestMiss - distanceFromTarget)) { 
            bestMiss = distanceTravelled; 
            bestAngle = angle;
            bestSpeed = speed;
         }
         /* System.out.println("Ang: " + angle + ", " + "Speed: " + speed + ", " + "D: " + 
         distanceTravelled + ", " + "Miss: " + distanceMissed); */
         }
      }
      // System.out.println(bestMiss);
      // System.out.println(bestAngle);
      // System.out.println(bestSpeed);
         
      System.out.printf("Best angle: %.2f%n", bestAngle);
      System.out.printf("Best speed: %.2f%n", bestSpeed);
      System.out.printf("Distance travelled: %.2f%n", bestMiss);
      System.out.printf("Missed the target center by: %.2f%n", Math.abs(bestMiss - distanceFromTarget));
       
      
      scnr.close();
	
	}

}
