package org.firstinspires.ftc.teamcode;

/**
 * Created by laura.denney on 12/26/2017.
 */
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "redAuto")
public class autonomous extends LinearOpMode {

    vuforiaTest picture = new vuforiaTest();
    HdriveHardware robot = new HdriveHardware();
    colorSensorTest sense = new colorSensorTest();

    static final double     COUNTS_PER_MOTOR_REV    = 1680 ;
    static final double     DRIVE_GEAR_REDUCTION    = 2.0 ;
    static final double     WHEEL_DIAMETER_INCHES   = 4.0 ;
    static final double     COUNTS_PER_INCH         = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) /
            (WHEEL_DIAMETER_INCHES * 3.1415);


    @Override
    public void runOpMode() {


        waitForStart();
        robot.CServo.setPosition(0);
        sense.init();
        if (sense.equals("blue")) {
            encoderDrive(-0.5, 0, 5);
            robot.CServo.setPosition(1);
            encoderDrive(0.5, 5, 0);
        }
        else if (sense.equals("red")){
            encoderDrive(0.5, 0, 5);
            robot.CServo.setPosition(1);
            encoderDrive(-0.5, 5, 0);
        }
        picture.init();
        encoderDrive(0.75, 20, 20);
        if (picture.equals("center")){
            centerDrive(0.5, 12);
            robot.flap.setTargetPosition(840);

        }
        else if (picture.equals("left")){
            centerDrive(0.5, 6);
            robot.flap.setTargetPosition(840);

        }
        else if(picture.equals("right")){
            centerDrive(0.5, 18);
            robot.flap.setTargetPosition(840);

        }


    }

    public void encoderDrive(double speed, double leftInches, double rightInches)
    {
        int newLeftTarget;
        int newRightTarget;

        if(opModeIsActive()) {


            newLeftTarget = robot.leftMotor.getCurrentPosition() + (int) (leftInches * COUNTS_PER_INCH);
            newRightTarget = robot.rightMotor.getCurrentPosition() + (int) (rightInches * COUNTS_PER_INCH);
            robot.leftMotor.setTargetPosition(newLeftTarget);
            robot.rightMotor.setTargetPosition(newRightTarget);


            robot.leftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.rightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);


            robot.leftMotor.setPower(Math.abs(speed));
            robot.rightMotor.setPower(Math.abs(speed));


            robot.leftMotor.setPower(0);
            robot.rightMotor.setPower(0);


            robot.leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        }
    }
    public void centerDrive (double speed, double centerInches){
        int newCenterTarget;

        if(opModeIsActive()) {

            newCenterTarget = robot.center.getCurrentPosition() + (int) (centerInches * COUNTS_PER_INCH);

            robot.center.setTargetPosition(newCenterTarget);

            robot.center.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            robot.center.setPower(Math.abs(speed));

            robot.center.setPower(0);

            robot.center.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }



    }
}
