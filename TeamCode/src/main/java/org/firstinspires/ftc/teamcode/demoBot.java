package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;


@TeleOp(name="demoBot", group="Test")
public class demoBot extends OpMode {


    demoHardware robot = new demoHardware();


    double rightServoPosition = robot.RIGHT_HOME;
    final double RIGHT_SPEED = 0.01;

    double leftServoPosition = robot.LEFT_HOME;
    final double LEFT_SPEED = 0.01;

    @Override
    public void init() {
    robot.init(hardwareMap);
    }

    @Override
    public void loop() {

        if(gamepad1.a) {
            robot.Motor.setPower(-0.3);
        }
       if(gamepad1.b){
           robot.Motor.setPower(0);
       }
       if(gamepad1.x){
           robot.Motor.setPower(0.3);
       }

        if (gamepad1.dpad_right) {
            rightServoPosition += RIGHT_SPEED;
            leftServoPosition -= LEFT_SPEED;
        }

        else if (gamepad1.dpad_left) {
            rightServoPosition -= RIGHT_SPEED;
            leftServoPosition += LEFT_SPEED;
        }



        rightServoPosition = Range.clip(rightServoPosition, robot.RIGHT_MIN_RANGE, robot.RIGHT_MAX_RANGE);
        robot.rightServo.setPosition(rightServoPosition);

        leftServoPosition = Range.clip(leftServoPosition, robot.LEFT_MIN_RANGE, robot.LEFT_MAX_RANGE);
        robot.leftServo.setPosition(leftServoPosition);
    }


}


























