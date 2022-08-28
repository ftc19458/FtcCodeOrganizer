/*
This is the class where all your subsystems are stored.
 */

package org.firstinspires.ftc.teamcode.robot;

import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.MutableClassToInstanceMap;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Robot {
    private Telemetry telemetry;
    private Controls controls;
    private Alliance alliance;
    private boolean auto;
    private ElapsedTime timer;
    private LinearOpMode opMode;

    private ClassToInstanceMap<Subsystem> subsystems;

    public Robot(HardwareMap hardwareMap, Telemetry t, boolean au, Alliance al, Gamepad gamepad1, Gamepad gamepad2, LinearOpMode opmode) {
        telemetry = t;
        auto = au;
        timer = new ElapsedTime();
        alliance = al;
        opMode = opmode;

        controls = new Controls(gamepad1, gamepad2);
        Subsystem.init(controls, alliance, auto, telemetry, hardwareMap, opMode);

        subsystems = MutableClassToInstanceMap.create();
        //add subsystems here
    }

    public void wait(int time) {
        resetTimer();
        while (opMode.opModeIsActive() && getTime() < time);
    }

    public void resetTimer() {
        timer.reset();
    }

    public double getTime() {
        return timer.milliseconds();
    }

    public void fullManualControl() {
        for (Class i: subsystems.keySet()) {
            subsystems.getInstance(i).manualControl();
        }

        //interactions between subsystems to be used in teleop here
    }

    //if desired, add individual getter methods for easier access to specific subsystems

    public SubsystemStorage<? extends Subsystem> getSubsystem(Class<? extends Subsystem> subsystem) {
        return new SubsystemStorage<>(subsystems.getInstance(subsystem));
    }

    public class SubsystemStorage<S> {
        private S subsystem;

        private SubsystemStorage(S s) {
            subsystem = s;
        }

        public S get() {
            return subsystem;
        }
    }

    //add interactions between subsystems here
}