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

    HardwareMap hwMap  = null;
    private ElapsedTime period  = new ElapsedTime();

    public HdriveHardware() {

    }
    public void init(HardwareMap ahwMap) {


        hwMap = ahwMap;

        rightMotor   = hwMap.dcMotor.get("right");
        leftMotor    = hwMap.dcMotor.get("left");
        leftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        center  = hwMap.dcMotor.get("center");


        rightMotor.setPower(0);
        leftMotor.setPower(0);
        center.setPower(0);



        rightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        center.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);



    }



}