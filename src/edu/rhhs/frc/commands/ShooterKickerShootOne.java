/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.rhhs.frc.commands;

import edu.rhhs.frc.subsystems.PneumaticSubsystem;

/**
 *
 * @author bselle
 */
public class ShooterKickerShootOne extends CommandBase {
    
    private static final double WAIT_TIMEOUT = 0.1; 
    
    public ShooterKickerShootOne() {
        requires(getShooterKicker());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        getShooterKicker().setPosition(PneumaticSubsystem.EXTEND);
        getShooterIntake().incrementFrisbeeCount(-1);
//        getLEDLights().setColorRipple();
        getLEDLights().setIncrementShootColor(getShooterIntake().getFrisbeeCount());
        System.out.println("Shooter RPM at Kick = " + getShooterWheel().getShooterWheelRPM());
        setTimeout(WAIT_TIMEOUT);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {  
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
        getShooterKicker().setPosition(PneumaticSubsystem.RETRACT);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        getShooterKicker().setPosition(PneumaticSubsystem.RETRACT);
    }
}
