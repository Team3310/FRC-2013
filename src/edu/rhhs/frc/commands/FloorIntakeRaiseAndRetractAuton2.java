package edu.rhhs.frc.commands;

import edu.rhhs.frc.subsystems.PneumaticSubsystem;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 * @author rhhs
 */
public class FloorIntakeRaiseAndRetractAuton2 extends CommandGroup {
    
    public FloorIntakeRaiseAndRetractAuton2() {
        addSequential(new ShooterPitchSetToShoot(-1.0));
        addSequential(new WaitCommand(0.1));
        addSequential(new FloorIntakeSetPosition(PneumaticSubsystem.RETRACT));
        addSequential(new FloorIntakeSetRollerSpeed(0));
        addSequential(new FloorIntakeTimedRoller(-1.0, 0.1));
    }
}

