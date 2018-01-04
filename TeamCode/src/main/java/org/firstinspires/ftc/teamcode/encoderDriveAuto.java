package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcontroller.external.samples.HardwarePushbot;

/**
 * Created by Laura.Denney on 12/29/2017.
 */

public class encoderDriveAuto {

    HdriveHardware robot = new HdriveHardware();
    private ElapsedTime runtime = new ElapsedTime();

    static final double     COUNTS_PER_MOTOR_REV    = 1440 ;    // eg: TETRIX Motor Encoder
    static final double     DRIVE_GEAR_REDUCTION    = 2.0 ;     // This is < 1.0 if geared UP
    static final double     WHEEL_DIAMETER_INCHES   = 4.0 ;     // For figuring circumference
    static final double     COUNTS_PER_INCH         = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) /
            (WHEEL_DIAMETER_INCHES * 3.1415);
    static final double     DRIVE_SPEED             = 0.6;
    static final double     TURN_SPEED              = 0.5;



public void encoderDrive(double speed, double leftInches, double rightInches)
{
    int newLeftTarget;
    int newRightTarget;

        // Ensure that the opmode is still active


            // Determine new target position, and pass to motor controller
    newLeftTarget = robot.leftMotor.getCurrentPosition() + (int)(leftInches * COUNTS_PER_INCH);
    newRightTarget = robot.rightMotor.getCurrentPosition() + (int)(rightInches * COUNTS_PER_INCH);
    robot.leftMotor.setTargetPosition(newLeftTarget);
    robot.rightMotor.setTargetPosition(newRightTarget);

            // Turn On RUN_TO_POSITION
    robot.leftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    robot.rightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            // reset the timeout time and start motion.
    robot.leftMotor.setPower(Math.abs(speed));
    robot.rightMotor.setPower(Math.abs(speed));

            // keep looping while we are still active, and there is time left, and both motors are running.
            // Note: We use (isBusy() && isBusy()) in the loop test, which means that when EITHER motor hits
            // its target position, the motion will stop.  This is "safer" in the event that the robot will
            // always end the motion as soon as possible.
            // However, if you require that BOTH motors have finished their moves before the robot continues
            // onto the next step, use (isBusy() || isBusy()) in the loop test.

            // Stop all motion;
    robot.leftMotor.setPower(0);
    robot.rightMotor.setPower(0);

            // Turn off RUN_TO_POSITION
    robot.leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    robot.rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

            //  sleep(250);   // optional pause after each move

}



}
