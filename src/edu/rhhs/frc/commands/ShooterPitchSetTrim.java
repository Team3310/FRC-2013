/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.rhhs.frc.commands;

/**
 *
 * @author bselle
 */
public class ShooterPitchSetTrim extends CommandBase {
    
    private double m_deltaDeviceZeroDeg;
    
    public ShooterPitchSetTrim(double deltaDeviceZeroDeg) {
        m_deltaDeviceZeroDeg = deltaDeviceZeroDeg;
        requires(getShooterPitchAngle());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        double currentDeviceZeroPosition = getShooterPitchAngle().getDeviceZeroPositionOffsetDeg();
        getShooterPitchAngle().setDeviceZeroPositionOffsetDeg(currentDeviceZeroPosition + m_deltaDeviceZeroDeg);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
