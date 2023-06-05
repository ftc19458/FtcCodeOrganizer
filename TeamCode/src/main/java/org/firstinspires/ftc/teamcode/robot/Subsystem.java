/*
This is the base class for all subsystems. It will rarely need to be edited.
 */

package org.firstinspires.ftc.teamcode.robot;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public abstract class Subsystem {
    protected static Telemetry telemetry;
    protected static boolean auto;
    public static Alliance alliance;
    protected static Controls controls;
    protected static HardwareMap hardwareMap;
    protected static LinearOpMode opMode;

    public abstract void onStart();
    public abstract void manualControl();

    public static void init(Controls c, Alliance al, boolean au, Telemetry t, HardwareMap hm, LinearOpMode opmode) {
        controls = c;
        alliance = al;
        auto = au;
        telemetry = t;
        hardwareMap = hm;
        opMode = opmode;
    }
}
