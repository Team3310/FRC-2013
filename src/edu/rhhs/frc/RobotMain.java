/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.rhhs.frc;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.rhhs.frc.commands.CommandBase;
import edu.rhhs.frc.commands.ShooterShoot3FrisbeesWaitRPMAutonomous;
import edu.rhhs.frc.commands.ShooterShoot5FrisbeesCenterlineHalfCourtWaitRPMAutonomous;
import edu.rhhs.frc.commands.ShooterShoot5FrisbeesCenterlineWaitRPMAutonomous;
import edu.rhhs.frc.commands.ShooterShoot5to7FrisbeesWaitRPMAutonomous;
import edu.rhhs.frc.subsystems.PneumaticSubsystem;
import edu.rhhs.frc.subsystems.Transmission;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotMain extends IterativeRobot {

    Command autonomousCommand;
    SendableChooser autonomousModeChooser;
//    SendableChooser driveModeChooser;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        // Initialize all subsystems
        CommandBase.init();
        
        // instantiate the command used for the autonomous period
//        driveModeChooser = new SendableChooser();
//        driveModeChooser.addObject("Arcade", new Integer(Chassis.CONTROLLER_ARCADE));
//        driveModeChooser.addObject("Tank", new Integer(Chassis.CONTROLLER_TANK));
//        driveModeChooser.addDefault("Joystick Cheesy", new Integer(Chassis.CONTROLLER_CHEESY));
//        driveModeChooser.addObject("XBox Cheesy", new Integer(Chassis.CONTROLLER_XBOX));
//        driveModeChooser.addObject("Wheel Cheesy", new Integer(Chassis.CONTROLLER_WHEEL));
//        SmartDashboard.putData("Drive Mode", driveModeChooser);
        
        autonomousModeChooser = new SendableChooser();
        autonomousModeChooser.addObject("Shoot 3 Corner Pyramid", new ShooterShoot3FrisbeesWaitRPMAutonomous());
        autonomousModeChooser.addDefault("Shoot 5 Center Pyramid", new ShooterShoot5to7FrisbeesWaitRPMAutonomous(ShooterShoot5to7FrisbeesWaitRPMAutonomous.DISTANCE_5_FRISBEES_IN));
        autonomousModeChooser.addObject("Shoot 7 Center Pyramid", new ShooterShoot5to7FrisbeesWaitRPMAutonomous(ShooterShoot5to7FrisbeesWaitRPMAutonomous.DISTANCE_7_FRISBEES_IN));
        autonomousModeChooser.addObject("Shoot 5 Right Centerline", new ShooterShoot5FrisbeesCenterlineWaitRPMAutonomous(true));
        autonomousModeChooser.addObject("Shoot 5 Left Centerline", new ShooterShoot5FrisbeesCenterlineWaitRPMAutonomous(false));
        autonomousModeChooser.addObject("Shoot 5 Right Centerline Half Court", new ShooterShoot5FrisbeesCenterlineHalfCourtWaitRPMAutonomous(true));
        autonomousModeChooser.addObject("Shoot 5 Left Centerline Half Court", new ShooterShoot5FrisbeesCenterlineHalfCourtWaitRPMAutonomous(false));
        SmartDashboard.putData("Autonomous Mode", autonomousModeChooser);

        CommandBase.getShooterIntake().resetFrisbeeCount();
        CommandBase.getTransmission().shift(Transmission.LO_GEAR);
        CommandBase.getFloorIntake().setPosition(PneumaticSubsystem.RETRACT);
        CommandBase.getShooterKicker().setPosition(PneumaticSubsystem.RETRACT);
        CommandBase.getShooterLoader().setPosition(PneumaticSubsystem.RETRACT);
        CommandBase.getShooterWheel().stop();
        CommandBase.getLEDLights().setColor(0, 0, 0);

        CommandBase.getLEDLights().setAlliance(m_ds.getAlliance().value);
        System.out.println("Alliance value = " + m_ds.getAlliance().value);
        updateStatus();
        System.out.println("Robot Init Completed");
    }

    public void autonomousInit() {
         // instantiate the command used for the autonomous period
        autonomousCommand = (Command)autonomousModeChooser.getSelected();
        CommandBase.getShooterIntake().setFrisbeeCount(3);
        CommandBase.getLEDLights().setIncrementShootColor(CommandBase.getShooterIntake().getFrisbeeCount());

        // schedule the autonomous command (example)
        autonomousCommand.start();
        updateStatus();
        System.out.println("Automomous Init Completed");
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        updateStatus();
    }

    public void disabledInit() {
        updateStatus();
        System.out.println("Disabled Init Completed");
    }

    public void teleopInit() {
	// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) {
            autonomousCommand.cancel();
        }
//        CommandBase.getChassis().setControllerMode(((Integer)driveModeChooser.getSelected()).intValue());
        
        updateStatus();
        System.out.println("Teleop Init Completed");
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        updateStatus();
    }
    
    public void disabledPeriodic() {
        updateStatus();
    }

    /*
     * This function is called to update the SmartBoard display
     */
    public void updateStatus() {
        try {
            CommandBase.getChassis().updateStatus();
//            CommandBase.getClimbArm().updateStatus();
//            CommandBase.getClimbFoot().updateStatus();
//            CommandBase.getClimbWinch().updateStatus();
            CommandBase.getFloorIntake().updateStatus();
            CommandBase.getShooterIntake().updateStatus();
            CommandBase.getShooterKicker().updateStatus();
            CommandBase.getShooterLoader().updateStatus();
            CommandBase.getShooterPitchAngle().updateStatus();
            CommandBase.getShooterWheel().updateStatus();
            CommandBase.getBlocker().updateStatus();
        }
        catch (Exception e) {
            // Do nothing... just don't want to crash the robot
        }
    }

}
