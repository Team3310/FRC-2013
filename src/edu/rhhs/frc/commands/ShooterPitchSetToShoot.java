/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.rhhs.frc.commands;

/**
 *
 * @author bselle
 */
public class ShooterPitchSetToShoot extends CommandBase {
    
    private double m_motorSpeed;
    
    public ShooterPitchSetToShoot(double motorSpeed) {
        m_motorSpeed = motorSpeed;
        requires(getShooterPitchAngle());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        getShooterPitchAngle().disable();
        System.out.println("Pitch in");
        if (m_motorSpeed != 0.0) {
            getShooterPitchAngle().rotateDevice(m_motorSpeed);
        }
        else {
            getShooterPitchAngle().stop();
        }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return getShooterPitchAngle().isLimitSwitchClosed();
    }

    // Called once after isFinished returns true
    protected void end() {
//         System.out.println("Pitch in");
         getShooterPitchAngle().rotateDevice(m_motorSpeed * 0.2);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        getShooterPitchAngle().stop();
    }
}
