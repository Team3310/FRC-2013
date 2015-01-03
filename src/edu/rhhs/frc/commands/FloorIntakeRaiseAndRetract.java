package edu.rhhs.frc.commands;

import edu.rhhs.frc.subsystems.PneumaticSubsystem;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * @author rhhs
 */
public class FloorIntakeRaiseAndRetract extends CommandGroup {
    
    public FloorIntakeRaiseAndRetract() {
        addSequential(new FloorIntakeSetRollerSpeed(0));
        addSequential(new FloorIntakeSetPosition(PneumaticSubsystem.RETRACT));
        addSequential(new ShooterPitchSetToShoot(-1.0));
    }
}

