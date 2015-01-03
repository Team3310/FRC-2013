/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.rhhs.frc.commands;

/**
 *
 * @author bselle
 */
public class ShooterPitchSetAngle extends CommandBase {
    
    private double m_positionDeg;
    
    public ShooterPitchSetAngle(double positionDeg) {
        m_positionDeg = positionDeg;
        requires(getShooterPitchAngle());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        getShooterPitchAngle().setDeviceAngle(m_positionDeg);
        getShooterPitchAngle().startPID();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return getShooterPitchAngle().atSetpoint();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        getShooterPitchAngle().stop();
    }
}
