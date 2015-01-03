package edu.rhhs.frc.commands;

import edu.rhhs.frc.subsystems.PneumaticSubsystem;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 * @author rhhs
 */
public class FloorIntakeRaiseAndRetractAuton extends CommandGroup {
    
    public FloorIntakeRaiseAndRetractAuton() {
        addSequential(new WaitCommand(1.5));
        addSequential(new FloorIntakeSetPosition(PneumaticSubsystem.RETRACT));
        addSequential(new ShooterPitchSetToShoot(-1.0));
        addSequential(new FloorIntakeSetRollerSpeed(0));
        addSequential(new FloorIntakeTimedRoller(-1.0, 0.1));
    }
}

