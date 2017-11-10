package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;


public class HdriveHardware{


    public DcMotor  rightMotor;
    public DcMotor  leftMotor;
    public DcMotor  center;
    public DcMotor  lift;

    public Servo rightServo;
    public Servo leftServo;

    final double RIGHT_HOME = 1.0;
    final double RIGHT_MIN_RANGE  = 0.0;
    final double RIGHT_MAX_RANGE  = 1.0;

    final double LEFT_HOME = 1.0;
    final double LEFT_MIN_RANGE  = 0.0;
    final double LEFT_MAX_RANGE  = 1.0;

    HardwareMap hwMap  = null;

    private ElapsedTime period  = new ElapsedTime();

    public HdriveHardware() {

    }
    public void init(HardwareMap ahwMap) {


        hwMap = ahwMap;

        rightMotor   = hwMap.dcMotor.get("right");
        leftMotor    = hwMap.dcMotor.get("left");
        rightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        center  = hwMap.dcMotor.get("center");
        lift = hwMap.dcMotor.get("lift");


        rightServo = hwMap.servo.get("rservo");
        leftServo  = hwMap.servo.get("lservo");


        rightMotor.setPower(0);
        leftMotor.setPower(0);
        center.setPower(0);
        lift.setPower(0);



        rightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        center.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        lift.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);



    }



}