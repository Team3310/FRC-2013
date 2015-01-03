package edu.rhhs.frc.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * @author rhhs
 */
public class ShooterSetShootPosition extends CommandGroup {
    
    public ShooterSetShootPosition(double pitchSelectorAngleDeg) {     
        addSequential(new ShooterPitchCheckAngle(pitchSelectorAngleDeg));
        addSequential(new ShooterPitchSetSelectorAngle(pitchSelectorAngleDeg));
        addSequential(new ShooterPitchSetToShoot(-1.0));
    }
}

