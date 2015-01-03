/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.rhhs.frc.commands;

import edu.rhhs.frc.subsystems.ShooterPitchAngle;

/**
 *
 * @author bselle
 */
public class ShooterPitchCheckAngle extends CommandBase {
    
    private static final double SELECTOR_ANGLE_TOLERANCE = 10.0;
    private double m_selectorAngleDeg;
    private boolean m_isAtAngle = false;
    
    public ShooterPitchCheckAngle(double selectorAngleDeg) {
        m_selectorAngleDeg = selectorAngleDeg;
        requires(getShooterPitchAngle());
        requires(getShooterPitchSelector());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
//        System.out.println("");
//        System.out.println("Set Selector Angle = " + m_selectorAngleDeg + ", Selector Angle = " + getShooterPitchSelector().getSelectorAngle() + ", Pitch Angle = " + getShooterPitchAngle().getDeviceAngle());
//        System.out.println("isSelectorAngleWithinTolerance = " + isSelectorAngleWithinTolerance());
        if (isSelectorAngleWithinTolerance()) {
//            System.out.println("Selector within tolerance, done");
            m_isAtAngle = true;
        }
        else if (getShooterPitchAngle().getDeviceAngle() > (ShooterPitchAngle.FEEDER_STATION_LOAD + 5.0)) {
//            System.out.println("Selector NOT within tolerance pitch angle NOT OK.   Set pitch angle = " + (ShooterPitchAngle.FEEDER_STATION_LOAD + 5.0));
            m_isAtAngle = false;
            getShooterPitchAngle().setDeviceAngle(ShooterPitchAngle.FEEDER_STATION_LOAD);
            getShooterPitchAngle().startPID();
        }
        else {
//            System.out.println("Selector NOT within tolerance but pitch angle OK, done");
            m_isAtAngle = true;
        }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (m_isAtAngle == true) {
//            System.out.println("Done");
            return true;
        }
        else {
//            System.out.println("Current Pitch Angle = " + getShooterPitchAngle().getDeviceAngle() + ", isAtSetPoint = " + getShooterPitchAngle().atSetpoint());
            return getShooterPitchAngle().atSetpoint();
        }
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
//        System.out.println("Pitch Check Interupted");
        getShooterPitchAngle().stop();
    }
    
    private boolean isSelectorAngleWithinTolerance() {
        double curentSelectorAngle = getShooterPitchSelector().getSelectorAngle();
        if (Math.abs(curentSelectorAngle - m_selectorAngleDeg) < SELECTOR_ANGLE_TOLERANCE) {
            return true;
        }
        return false;
    }
}
