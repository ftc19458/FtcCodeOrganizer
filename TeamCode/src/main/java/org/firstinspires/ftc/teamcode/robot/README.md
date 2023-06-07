# FTC Code Organizer

This template created by team 19458 Equilibrium.exe makes it easy to keep your code organized and allows the Autonomous and TeleOp periods to share code.

## Overview

Each subsystem has its own class that handles all motors, servos, and sensors for that subsystem. Instances of these classes are stored in the `Robot` class, which extends `LinearOpMode`.

## Setup

The easiest way to use the template is to fork or clone this repository. If your team already has the SDK installed, you can manually download the `robot` package into the `teamcode` directory.

## Creating Subsystems

Each subsystem is its own object stored in the `Robot` class. To create a subsystem, put this starter code into a new class in the `robot` package:

```java
package org.firstinspires.ftc.teamcode.robot;

public class Example extends Subsystem{
    //instance variables here
    
    public Example() {
        //init code here
    }

    @Override
    public void onStart() {
        //teleop run code here
    }
    
    @Override
    public void manualControl() {
        //teleop loop code here
    }
    
    //other methods here
}
```

Replace `Example` with the name of the subsystem (and file name), then implement code where the comments tell you to. You will also need to add the subsystem to the `Robot` class. You can do this by creating the following instance variable:

```java
protected Example example;
```

You will also need to initialize the variable and add it to the list in the constructor:
```java
example = new Example();
subsystems.add(example);
```

To call a method from a subsystem OpMode, you can reference the variable you created.

## Autonomous

You can start your autonomous program with this starter code:

```java
@Autonomous
public class Auto extends Robot {
    @Override
    public void runOpMode() throws InterruptedException {
        init(Alliance.BLUE,true);

        waitForStart();

        //auto code here
    }
}
```

## TeleOp

All teleop code should be written in the `onStart()` and `manualControl()` methods of subsystems, and the `teleOp()` method in the `Robot` class. Gamepads should only be called from the `Controls` class. Because of this, your teleop code can be as simple as this:

```java
@TeleOp
public class Teleop extends Robot {
    @Override
    public void runOpMode() throws InterruptedException {
        init(Subsystem.alliance, false);

        waitForStart();

        teleOp();
    }
}
```

## Help

If you have any trouble using the template on your robot, feel free to open a GitHub issue.