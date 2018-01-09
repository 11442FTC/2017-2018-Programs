package org.firstinspires.ftc.teamcode;

/**
 * Created by laura.denney on 1/8/2018.
 */

public class scales{

   double drive(double dVal) {
        double[] scaleArray = {0, 0.05, 0.09, 0.10, 0.12, 0.15, 0.18, 0.20, 0.20, 0.24,
        0.30, 0.32, 0.36, 0.43, 0.50, 0.55, 0.57, 0.60, 0.63,0.65, 0.67, 0.72, 0.77, 0.8, 0.85,
        0.9,0.95, 1.00, 1.0, 1.0, 1.00, 1.0, 1, 1};

        int index = (int) (dVal * 16.0);


        if (index < 0) {
        index = -index;
        }


        if (index > 16) {
        index = 16;
        }


        double dScale;
        if (dVal < 0) {
        dScale = -scaleArray[index];
        } else {
        dScale = scaleArray[index];
        }

        return dScale;
        }



        double scaleArmUp(double dVal) {
        double[] scaleArray = {0, 0.05, 0.09, 0.10, 0.12, 0.15, 0.18, 0.20, 0.20, 0.24,
        0.30, 0.32, 0.36, 0.4, 0.4, 0.4, 0.4, .45, .47, 0.47, 0.5, 0.5, 0.5};

        int index = (int) (dVal * 16.0);


        if (index < 0) {
        index = -index;
        }


        if (index > 16) {
        index = 16;
        }


        double dScale;
        if (dVal < 0) {
        dScale = -scaleArray[index];
        } else {
        dScale = scaleArray[index];
        }

        return dScale;
        }

        double scaleUp(double dVal) {
        double[] scaleArray = {0, 0.05, 0.09, 0.10, 0.12, 0.15, 0.18, 0.20, 0.20, 0.24,
        0.30, 0.32, 0.36, 0.43, 0.50, 0.55, 0.57, 0.60, 0.63,0.65, 0.67, 0.72,};

        int index = (int) (dVal * 16.0);


        if (index < 0) {
        index = -index;
        }


        if (index > 16) {
        index = 16;
        }


        double dScale;
        if (dVal < 0) {
        dScale = -scaleArray[index];
        } else {
        dScale = scaleArray[index];
        }

        return dScale;
        }
}

