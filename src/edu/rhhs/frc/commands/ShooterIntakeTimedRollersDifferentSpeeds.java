/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.rhhs.frc.commands;

/**
 *
 * @author bselle
 */
public class ShooterIntakeTimedRollersDifferentSpeeds extends CommandBase {
    
    private double m_motorSpeedFront;
    private double m_motorSpeedRear;
    private double m_timeOut;
    
    public ShooterIntakeTimedRollersDifferentSpeeds(double motorSpeedFront, double motorSpeedRear, double timeOut) {
        m_motorSpeedFront = motorSpeedFront;
        m_motorSpeedRear = motorSpeedRear;
        m_timeOut = timeOut;
        requires(getShooterIntake());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        getShooterIntake().setFrontRollerSpeed(m_motorSpeedFront);
        getShooterIntake().setRearRollerSpeed(m_motorSpeedRear);
        setTimeout(m_timeOut);
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
