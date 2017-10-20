package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;


@TeleOp(name="Hdrive", group="Test")
public class Hdrive extends OpMode {

    HdriveHardware robot = new HdriveHardware();




    @Override
    public void init() {
        robot.init(hardwareMap);

    }

    @Override
    public void loop() {

        float left = gamepad1.left_stick_y;
        float right = gamepad1.right_stick_y;

        right = Range.clip(right, -1, 1);
        left = Range.clip(left, -1, 1);


        right = (float) scaleInput(right);
        left = (float) scaleInput(left);


        robot.rightMotor.setPower(right);
        robot.leftMotor.setPower(left);


        if(gamepad1.left_bumper){
            robot.center.setPower(0.75);
        }

        if(gamepad1.right_bumper){
            robot.center.setPower(-0.75);
        }

        else{
            robot.center.setPower(0);
        }

    }

    double scaleInput(double dVal) {
        double[] scaleArray = {0, 0.05, 0.09, 0.10, 0.12, 0.15, 0.18, 0.20, 0.20, 0.24,
                0.30, 0.32, 0.36, 0.43, 0.50, 0.60, 0.72, 0.85, 1.00, 1.00};

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
