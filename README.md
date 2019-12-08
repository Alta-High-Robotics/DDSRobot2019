# DDSRobot2019
---
> Robot Code for **Destination: Deep Space FRC 2019** | Team 7634 -- (New Hawks)

 
[![N|Solid](http://cafirst.org/wp-content/uploads/2019/01/FRC-2019-Social-Assets_launch-programs-fb-cover.jpg)](https://www.firstinspires.org/) 

---

### Unique Robot Features (code-focused):
  - Curvature scaled drive train (6 wheels)
  - "System Control" that allows for fast change of acceleration & rotation speeds*
  - Limelight vision camera algorithms to align Robot relative to reflective tape
  - "Robot Settings" which allows for fast hot-swapping of entire Robot settings
   
  	` * based on the Logitech Extreme 3D Joystick `

---

### Code Rundown
    Documentation is included with nearly every class.
    You can clone this repository using the current URL (where you are reading this page).
    IDE: FRC Visual Studio Code 2019 distro.
    
    Things to note (in this order):
        - Robot hierarchy is based off of a Scheduler (as provided by FRC WPILib)
        - Initialize subsystems to define specific unique Robot functions
        - Create commands to call those Robot functions and define interruptions
        - Use Scheduler to "schedule" these commands (whether sequential or parallel)
        - There are SAFETY presets where only ONE command can be using any unique subsystems
    
    Below is a short rundown of every class and its attributing factors toward functionality.

#### frc.robot\
* **Main.java** -- supplied by WPILib, creates new object for Robot
* **Robot.java** -- initializes all subsystems and has supplied periodic methods (ran 50/sec)
    * Look for WPILib documentation on Scheduler (Command-based Robot hierarchy is legendary)
* **OI.java** -- maps controller (Joystick for my case) to commands
* **RobotMap.java** -- "maps" Robot motor ports (via RoboRIO or dedicated motor controllers)
* **RobotSettings.java** -- wide range entire Robot control, fast quick-swapping settings

#### frc.robot.commands\
* **DiskReleaseCommand.java** -- decompress or compress pnuematic solenoids to release game disk
* **DriveCommand.java** -- defines what acceleration and rotation is based on
    * Note: Command is never scheduled. It is ran at init. via DriveTrain#initDefaultCommand()
* **DriveSpeedCommand.java** -- system control to change drive speed
* **LiftRobotCommand.java** -- seesaw motion for front and back Robot pnuematic lifters -- _no longer used_
* **LocateTargetCommand.java** -- grabs Limelight calculated corrections, provides changes to drive train based on those corrections, in order to align to target
* **NomNomGrabCommand.java** -- grabs the ball (NomNom is the part that holds balls)
* **NomNomReleaseCommand.java** -- see above; self-explanatory
* **RotationSpeedCommand.java** -- similar to DriveSpeedCommand; change rotation speed
* **TankDriveCommand.java** -- tank drive functionality in case of emergencies (e.g. joystick breaks)

#### frc.robot.commands.manual\
* **ManualLiftRobotBackCommand.java** -- activates or deactivates back pnuematic lifters
* **ManualLiftRobotFrontCommand.java** -- see above; self-explanatory
* **ManualSliderCommand.java** -- moves Slider up or down

#### frc.robot.helper\
* ***.java** -- helper classes (enums specifically) that help sort out tasks and passed to commands (do I want slider to move up or move down)

#### frc.robot.subsystems\
* **DriveTrain.java** -- creates the definition of the drive train (mapping of all motors to wheels and sides), defines what "driving" does with respect to acceleration and rotation
* **Limelight.java** -- gathers data from NetworkTables and passes it down to create a network of calibrated information; uses its own data to correct heading and speed with respect to distance (can use this corrected data to alter drive train; make it move and align to reflective tape)
* **NomNom.java** -- defines what grabbing and shooting the ball means
* **Pneumatics.java** -- defines all the pnuematic solenoids and what compression and decompression is with respect to the specified game or Robot objective
* **Slider.java** -- defines what raising and lowering is; limit switch mechanism to prevent damage
* **SystemControl.java** -- uses Joystick slider to control Robot acceleration and rotation speed
---
### Technology
* [Visual Studio Code 2019 (FRC-distro)](https://wpilib.screenstepslive.com/s/currentCS/a/932382-installing-visual-studio-code-c-java) -- Integrated Development Environment (IDE)
* [Java](https://www.oracle.com/java) -- Primary Programming Language
---

### Installation
Git is recommended for the benefit of both version control and easy repository cloning.

* Install these dependencies:
`Java 10 or later`

* For production environments:
`Java Development Kit (JDK) 10 or later`

* Recommended installation:
`Java and JDK 11`
---
### Development
```text
Developed by Jie "Jason" Liu (@jiejasonliu)
Good luck next year!

Email me if you have any coding questions or if any confusion arises!
Contact: jasonningliu@gmail.com
```
