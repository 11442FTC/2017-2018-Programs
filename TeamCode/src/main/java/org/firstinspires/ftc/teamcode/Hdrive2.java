package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.util.Range;


@TeleOp(name="Hdrive2", group="Test")
public class Hdrive2 extends OpMode {
    /* Dan's comments
    final int LEFT = 1;
    final int MAX_HEIGHT = 840;
    */

    HdriveHardware robot = new HdriveHardware();

    double extendPosition = robot.EXTEND_HOME;
    final double EXTEND_SPEED = 0.2;

    double clawPosition = robot.clawHome;
    final double clawSpeed = 0.2;



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


        float up = gamepad2.left_stick_y;
        up = (float) scaleInput(up);
        up = Range.clip(up, -1, 1);
        robot.flap.setPower(up);
        //^^power the glyph lift flap on the left joystick

        float armUp = gamepad2.left_stick_y;
        armUp = (float) scaleInput(armUp);
        armUp = Range.clip(armUp, -1, 1);
        robot.flap.setPower(armUp);


        if (gamepad1.left_bumper) {
            robot.center.setPower(-1);
        } else if (gamepad1.right_bumper) {
            robot.center.setPower(1);
        } else {
            robot.center.setPower(0);
        }
        //^^center wheel on left/right


        if(gamepad2.dpad_right){
            extendPosition += EXTEND_SPEED;

        }
        if(gamepad2.dpad_left){
            extendPosition -= EXTEND_SPEED;
        }


        if(gamepad2.x){
            clawPosition += clawSpeed;

        }
        if (gamepad2.y){
            clawPosition -= clawSpeed;
        }
        //^^ claw on arm servo

        if(gamepad2.right_bumper) {
            robot.track.setPower(-0.5);

        }
        else {
            robot.track.setPower(0);
        }



        extendPosition = Range.clip(extendPosition, robot.EXTEND_MIN_RANGE, robot.EXTEND_MAX_RANGE);
        robot.extend.setPosition(extendPosition);

        clawPosition = Range.clip(clawPosition, robot.CLAW_MIN_RANGE, robot.CLAW_MAX_RANGE);
        robot.claw.setPosition(clawPosition);

    }

    double scaleInput(double dVal) {
        double[] scaleArray = {0, 0.05, 0.09, 0.10, 0.12, 0.15, 0.18, 0.20, 0.20, 0.24,
                0.30, 0.32, 0.36, 0.43, 0.50, 0.55, 0.57, 0.60, 0.63,0.65, 0.67, 0.72, 0.77, 0.8, 0.85, 0.9,0.95, 1.00};

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
