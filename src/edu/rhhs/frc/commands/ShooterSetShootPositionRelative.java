package edu.rhhs.frc.commands;

import edu.rhhs.frc.subsystems.ShooterPitchSelector;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * @author rhhs
 */
public class ShooterSetShootPositionRelative extends CommandGroup {
    
    public ShooterSetShootPositionRelative(double relativePitchAngleDeg) {     
        addSequential(new ShooterSetShootPosition(ShooterPitchSelector.SHOOTER_SELECTOR_ANGLE_CENTER));
        addSequential(new ShooterPitchSetAngleRelative(relativePitchAngleDeg));
    }
}

