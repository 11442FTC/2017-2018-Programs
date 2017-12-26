package org.firstinspires.ftc.teamcode;

/**
 * Created by laura.denney on 12/26/2017.
 */
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "autoTest")
public class autonomous extends LinearOpMode {

    vuforiaTest picture = new vuforiaTest();
    HdriveHardware robot = new HdriveHardware();
    colorSensorTest sense = new colorSensorTest();

    @Override
    public void runOpMode() {


        while(opModeIsActive()){
            robot.CServo.setPosition(0);
            if (sense.equals("blue")) {


            }












        }

    }
}
