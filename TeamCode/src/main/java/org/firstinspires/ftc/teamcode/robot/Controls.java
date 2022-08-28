/*
This is where you put all methods regarding TeleOp controls. Gamepads shouldn't be called anywhere else.
 */

package org.firstinspires.ftc.teamcode.robot;

import com.qualcomm.robotcore.hardware.Gamepad;

public class Controls {
    private Gamepad gamepad1;
    private Gamepad gamepad2;

    public Controls (Gamepad g1, Gamepad g2) {
        gamepad1 = g1;
        gamepad2 = g2;
    }
}
