package edu.rhhs.frc.commands;

import edu.rhhs.frc.subsystems.ShooterWheelRPM;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * @author rhhs
 */
public class ShooterShoot3FrisbeesAutonomous extends CommandGroup {
    
    public ShooterShoot3FrisbeesAutonomous() {     
        addParallel(new ShooterPitchSetToShoot(-0.7));
        addSequential(new ShooterWheelSetRPM(ShooterWheelRPM.SHOOTER_WHEEL_RPM_REAR_PYRAMID));
        addSequential(new WaitTimer(ShooterWheelRPM.SHOOTER_WHEEL_SPOOL_UP_TIME_SEC));
        addSequential(new ShooterShoot4FrisbeesWaitRPM());
    }
}

