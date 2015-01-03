package edu.rhhs.frc.commands;

import edu.rhhs.frc.subsystems.PneumaticSubsystem;
import edu.rhhs.frc.subsystems.ShooterPitchAngle;
import edu.rhhs.frc.subsystems.ShooterWheelRPM;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 * @author rhhs
 */
public class ShooterShoot1FrisbeeWaitRPM extends CommandGroup {
    
    public ShooterShoot1FrisbeeWaitRPM() {
        addSequential(new ShooterWheelStartAtSetRPM());
        addSequential(new ShooterPitchSetAngle(ShooterPitchAngle.FEEDER_STATION_LOAD));
        addSequential(new ShooterKickerShootOne());
        addSequential(new WaitCommand(0.1));  // Make sure last Frisbee clears shooter
        addSequential(new ShooterWheelSetRPM(0));
    }
    
    
}

