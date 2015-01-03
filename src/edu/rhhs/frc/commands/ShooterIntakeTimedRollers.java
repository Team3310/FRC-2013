/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.rhhs.frc.commands;

/**
 *
 * @author bselle
 */
public class ShooterIntakeTimedRollers extends CommandBase {
    
    private double m_motorSpeed;
    private double m_timeOut;
    
    public ShooterIntakeTimedRollers(double motorSpeed, double timeOut) {
        m_motorSpeed = motorSpeed;
        m_timeOut = timeOut;
        requires(getShooterIntake());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        getShooterIntake().setFrontRollerSpeed(m_motorSpeed*.7);
        getShooterIntake().setRearRollerSpeed(m_motorSpeed);
//        System.out.println("Start shooter timed rollers, Time = " + System.currentTimeMillis());
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
//        System.out.println("Stop shooter timed rollers, Time = " + System.currentTimeMillis());
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
