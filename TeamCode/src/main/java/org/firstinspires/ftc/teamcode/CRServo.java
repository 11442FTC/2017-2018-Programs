package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.PwmControl;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoControllerEx;

import java.util.Dictionary;

/**
 * Created by laura.denney on 1/9/2018.
 */

@TeleOp(name="CRServo", group="Test")
public class CRServo extends OpMode {

    HdriveHardware robot = new HdriveHardware();

    @Override
    public void init() {

        robot.init(hardwareMap);

        if (robot.CRServo.getController() instanceof ServoControllerEx) {
// Confirm its an extended range servo controller before we try to set to avoid crash
            ServoControllerEx theControl = (ServoControllerEx) robot.CRServo.getController();
            int thePort = robot.CRServo.getPortNumber();
            PwmControl.PwmRange theRange = new PwmControl.PwmRange(600, 2400);
            theControl.setServoPwmRange(thePort, theRange);
        }

    }

    @Override
    public void loop() {

        if (gamepad2.dpad_right) {
            robot.CRServo.setPower(1);
        } else if (gamepad2.dpad_left) {
            robot.CRServo.setPower(0);
        } else {
            robot.CRServo.setPower(0.5);
        }


    }
}