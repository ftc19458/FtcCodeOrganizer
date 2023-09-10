/*
This is the class where all your subsystems are stored.
 */

package org.firstinspires.ftc.teamcode.robot;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import java.util.ArrayList;
import java.util.List;

public abstract class Robot extends LinearOpMode {
    // declare subsystem instances
    // protected Example example;

    private List<Subsystem> subsystems;

    protected void init(Alliance alliance, boolean auto) {
        Subsystem.init(new Controls(gamepad1, gamepad2), alliance, auto, telemetry, hardwareMap, this);
        subsystems = new ArrayList<>();

        // init subsystem instances
        // example = new Example();

        // add subsystems to list
        // subsystems.add(example);
    }

    protected void teleOp() {
        for (Subsystem subsystem: subsystems) {
            subsystem.onStart();
        }

        while (opModeIsActive()) {
            for (Subsystem subsystem: subsystems) {
                subsystem.manualControl();
                telemetry.update();
            }
        }
    }
}
