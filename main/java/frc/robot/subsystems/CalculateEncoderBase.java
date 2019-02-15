/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.Encoder;


/**
 * Add your docs here.
 */
public class CalculateEncoderBase {

    //Encoder encoder1 = new Encoder(0,1,false);//0,1 already used, this is just to calculate, not send data
   Encoder encoder1 = new Encoder(5, 6, false, Encoder.EncodingType.k4X);


    public void setEValue() {

        encoder1.setMaxPeriod(1);
    	encoder1.setMinRate(1);
    	encoder1.setDistancePerPulse((Math.PI*6)/360);
    	encoder1.setReverseDirection(true);
    	encoder1.setSamplesToAverage(10);
        encoder1.reset();
        System.out.println("initializing Encoder");
    }

    public void getEValue(){

        int val = encoder1.get();
        System.out.println("encoder1's .get :" + val);

        boolean valS = encoder1.getStopped();
        System.out.println("encoder1's .getStopped :" + valS);

        double valR = encoder1.getRaw();
        System.out.println("encoder1's .getRaw :" + valR);

        double valD = encoder1.getDistance();
        System.out.println("encoder1's .getDistance :" + valD);






    }

}
