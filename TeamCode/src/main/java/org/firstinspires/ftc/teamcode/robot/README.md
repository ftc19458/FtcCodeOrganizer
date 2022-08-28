# FTC Code Organizer

This template created by team 19458 Equilibrium.exe makes it easy to keep your code organized and allows the Autonomous and TeleOp periods to share code.

## Setup

The easiest way to use the template is to fork this repository. If your team already has the SDK installed, you can manually download the `robot` package into the `teamcode` directory, and add the following line to the `dependencies` section of `TeamCode/build.gradle`:

```java
implementation 'com.google.guava:guava:31.1-android'
```

## Creating Subsystems

Each subsystem is its own object stored in the `Robot` class. To create a subsystem, put this starter code into a new class in the `robot` package:

```java
package org.firstinspires.ftc.teamcode.robot;

public class Example extends Subsystem{
    //instance variables here
    
    public Example() {
        super();
        //constructor code here
    }
    
    @Override
    public void manualControl() {
        //teleop code here
    }
    
    //other methods here
}
```

Replace `Example` with the name of the subsystem (and file name), then implement code where the comments tell you to. You will also need to add the subsystem to the `Robot` class. You can do this by adding the following line to the end of the constructor:

```java
subsystems.putInstance(Example.class, new Example());
```
Again, replace `Example` with the name of the subsystem.

To call a method from a subsystem in your OpMode, just use this line below and pass in the class for the subsystem:

```java
((Example) (robot.getSubsystem(Example.class).get())).example();
```

If you want, you can also add this method to the Robot class to call it more easily using `Robot.getExample()`:
```java
public Example getExample() {
    return (Example) (getSubsystem(Example.class).get());
}
```

## Autonomous

You can start your autonomous program with this starter code:

```java
@Autonomous
public class Auto extends LinearOpMode {
    private Robot robot;

    @Override
    public void runOpMode() throws InterruptedException {
        robot = new Robot(hardwareMap, telemetry, true, Alliance.BLUE, gamepad1, gamepad2, this);

        waitForStart();

        //auto path here
    }
}
```

## TeleOp

All teleop code should be written in the `manualControl()` methods of subsystems, and the `fullManualControl()` method in the `Robot` class. Gamepads should only be called from the `Controls` class. Because of this, your teleop code can be as simple as this:

```java
@TeleOp
public class TeleOp extends LinearOpMode {
    private Robot robot;

    @Override
    public void runOpMode() throws InterruptedException {
        robot = new Robot(hardwareMap, telemetry, false, Subsystem.alliance, gamepad1, gamepad2, this);

        waitForStart();

        while (opModeIsActive()) {
            robot.fullManualControl();
        }
    }
}
```

## Help

If you have any trouble using the template on your robot, feel free to open a GitHub issue.