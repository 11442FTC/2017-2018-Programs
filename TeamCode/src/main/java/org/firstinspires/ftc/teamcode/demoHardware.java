package org.firstinspires.ftc.teamcode;

/**
 * Created by laura.denney on 11/9/2016.
 */
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;


public class demoHardware{


    public DcMotor  Motor;
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

    public demoHardware() {

    }
    public void init(HardwareMap ahwMap) {


        hwMap = ahwMap;

        Motor   = hwMap.dcMotor.get("motor");
        rightServo = hwMap.servo.get("right");
        leftServo = hwMap.servo.get("left");


        Motor.setPower(0);



        Motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);



    }



}