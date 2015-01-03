/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.rhhs.frc.commands;

/**
 *
 * @author bselle
 */
public class ShooterPitchSetSelectorAngle extends CommandBase {
    
    private double m_positionDeg;
    
    public ShooterPitchSetSelectorAngle(double positionDeg) {
        m_positionDeg = positionDeg;
        requires(getShooterPitchSelector());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
//        System.out.println("");
//        System.out.println("Set Selector Angle = " + m_positionDeg + ", Current Selector Angle = " + getShooterPitchSelector().getSelectorAngle());
        getShooterPitchSelector().setSelectorAngle(m_positionDeg);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
//        System.out.println("Selector Angle = " + getShooterPitchSelector().getSelectorAngle());
        return getShooterPitchSelector().isAtSetAngle();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
