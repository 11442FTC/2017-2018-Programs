package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;


public class HdriveHardware{
    public CRServo CRServo;

    public DcMotor  rightMotor;
    public DcMotor  leftMotor;
    public DcMotor  center;

   // public DcMotor  lift;
    public DcMotor  arm;
    public DcMotor flap;
    public DcMotor track;

    //public Servo rightServo;
    //public Servo leftServo;

    public DcMotor extend;
    public Servo claw;
    public Servo clawRotate;

    public Servo extendServo;

    public Servo CServo;
    public Servo C2Servo;

    final double RIGHT_HOME = 1.0;
    final double RIGHT_MIN_RANGE  = 0.0;
    final double RIGHT_MAX_RANGE  = 1.0;

    final double LEFT_HOME = 1.0;
    final double LEFT_MIN_RANGE  = 0.0;
    final double LEFT_MAX_RANGE  = 1.0;


    final double c2Home = 1.0;
    final double C2_MIN_RANGE  = 0;
    final double C2_MAX_RANGE  = 1.0;

    final double cHome = 1.0;
    final double C_MIN_RANGE  = 0;
    final double C_MAX_RANGE  = 1.0;



    final double clawHome = 1.0;
    final double CLAW_MIN_RANGE  = 0.5;
    final double CLAW_MAX_RANGE  = 1.0;

    final double clawRotateHome = 1.0;
    final double CLAWROTATE_MIN_RANGE  = 0.5;
    final double CLAWROTATE_MAX_RANGE  = 1.0;




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

       // lift = hwMap.dcMotor.get("lift");

        arm = hwMap.dcMotor.get("arm");
        claw = hwMap.servo.get("claw");
        extend = hwMap.dcMotor.get("extend");
        clawRotate = hwMap.servo.get("rotateClaw");


        flap = hwMap.dcMotor.get("flap");
        track = hwMap.dcMotor.get("track");

        CRServo = hwMap.crservo.get("crservo");

       // rightServo = hwMap.servo.get("rservo");
        //leftServo  = hwMap.servo.get("lservo");

        CServo = hwMap.servo.get("CServo");
        C2Servo = hwMap.servo.get("C2Servo");


        rightMotor.setPower(0);
        leftMotor.setPower(0);
        center.setPower(0);

       // lift.setPower(0);
        arm.setPower(0);
        flap.setPower(0);
        track.setPower(0);
        extend.setPower(0);


       rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        center.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        //lift.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        arm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        flap.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        track.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        extend.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


    }



}