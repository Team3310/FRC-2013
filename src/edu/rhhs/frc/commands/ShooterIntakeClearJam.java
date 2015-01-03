/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.rhhs.frc.commands;

/**
 *
 * @author bselle
 */
public class ShooterIntakeClearJam extends CommandBase {
    
    public ShooterIntakeClearJam() {
        requires(getShooterIntake());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        setTimeout(0.01);
        getShooterIntake().setFrontRollerSpeed(-0.25);
        getShooterIntake().setRearRollerSpeed(-0.35);
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
        getShooterIntake().stopFrontRoller();
        getShooterIntake().stopRearRoller();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
