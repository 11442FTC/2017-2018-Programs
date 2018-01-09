package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

import java.util.Dictionary;

/**
 * Created by laura.denney on 1/9/2018.
 */

@TeleOp(name="CRServo", group="Test")
public class CRServo extends OpMode {
    HdriveHardware robot = new HdriveHardware();

    double EXTEND_HOME = 0.5;
    final double EXTEND_MIN_RANGE  = 0.0;
    final double EXTEND_MAX_RANGE  = 1.0;

    double EXTEND_POSITION = EXTEND_HOME;
    final double EXTEND_SPEED = 1;


    @Override
    public void init() {

    }

    @Override
    public void loop() {
        if (gamepad2.dpad_right){
            EXTEND_HOME += EXTEND_SPEED;
            robot.extendServo.setPosition(EXTEND_POSITION);
        }
        else if (gamepad2.dpad_left){
            EXTEND_HOME -= EXTEND_SPEED;
            robot.extendServo.setPosition(EXTEND_POSITION);
        }
        else{
            robot.extendServo.setPosition(0.5);
        }


    }


}
