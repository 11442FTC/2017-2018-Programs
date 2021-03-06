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
    scales Scale = new scales();



    double clawPosition = robot.clawHome;
    final double clawSpeed = 0.007;

    double rotatePosition = robot.clawRotateHome;
    final double rotateSpeed = 0.007;

//    double cPosition = robot.cHome;
//    final double cSpeed = 0.007;
//
//    double c2Position = robot.c2Home;
//    final double c2Speed = 0.007;

    @Override
    public void init() {
        robot.init(hardwareMap);

    }

    @Override
    public void loop() {

        float left = -gamepad1.right_stick_y;
        float right = -gamepad1.left_stick_y;

        right = Range.clip(right, -1, 1);
        left = Range.clip(left, -1, 1);


        right = (float) Scale.drive(right);
        left = (float) Scale.drive(left);


        robot.rightMotor.setPower(right);
        robot.leftMotor.setPower(left);
        //^^ Tank Drive

        float up = -gamepad2.right_stick_y;
        up = (float) Scale.scaleUp(up);
        up = Range.clip(up, -1, 1);
        robot.flap.setPower(up);
        //^^power the glyph lift flap on the left joystick

        float armUp = gamepad2.left_stick_y;
        armUp = (float) Scale.scaleArmUp(armUp);
        armUp = Range.clip(armUp, -1, 1);
        robot.arm.setPower(armUp);
        //^^ Control arm on the joystick


        if (gamepad1.left_bumper) {
            robot.center.setPower(1);
        } else if (gamepad1.right_bumper) {
            robot.center.setPower(-1);
        } else {
            robot.center.setPower(0);
        }
        //^^center wheel on left/right

        if(gamepad2.dpad_up){
            clawPosition += clawSpeed;

        }
        if (gamepad2.dpad_down){
            clawPosition -= clawSpeed;
        }

        if(gamepad2.dpad_left){
            rotatePosition += rotateSpeed;

        }
        if (gamepad2.dpad_right){
            rotatePosition -= rotateSpeed;
        }
        //^^ claw on arm servo

        if(gamepad2.right_bumper) {
            robot.track.setPower(-1);

        }
        else if(gamepad2.left_bumper){
            robot.track.setPower(1);
        }
        else {
            robot.track.setPower(0);
        }
        //^^ control the glyph track with the right and left bumpers

//        if(gamepad1.dpad_up){
//            cPosition += cSpeed;
//
//        }
//        if (gamepad1.dpad_down){
//            cPosition -= cSpeed;
//        }
//
//
//        if(gamepad1.dpad_left){
//            c2Position += c2Speed;
//
//        }
//        if (gamepad1.dpad_right){
//            c2Position -= c2Speed;
//        }
//
//        cPosition = Range.clip(cPosition, robot.C_MIN_RANGE, robot.C_MAX_RANGE);
//        robot.CServo.setPosition(cPosition);
//
//        c2Position = Range.clip(c2Position, robot.C2_MIN_RANGE, robot.C2_MAX_RANGE);
//        robot.C2Servo.setPosition(c2Position);

        clawPosition = Range.clip(clawPosition, robot.CLAW_MIN_RANGE, robot.CLAW_MAX_RANGE);
        robot.claw.setPosition(clawPosition);


        rotatePosition = Range.clip(rotatePosition, robot.CLAWROTATE_MIN_RANGE, robot.CLAWROTATE_MAX_RANGE);
        robot.clawRotate.setPosition(rotatePosition);
    }

}