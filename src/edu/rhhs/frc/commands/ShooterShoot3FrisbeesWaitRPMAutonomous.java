package edu.rhhs.frc.commands;

import edu.rhhs.frc.subsystems.ShooterPitchSelector;
import edu.rhhs.frc.subsystems.ShooterWheelRPM;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 * @author rhhs
 */
public class ShooterShoot3FrisbeesWaitRPMAutonomous extends CommandGroup {
    
    public ShooterShoot3FrisbeesWaitRPMAutonomous() {     
        addSequential(new ShooterSetShootPosition(ShooterPitchSelector.SHOOTER_SELECTOR_ANGLE_CORNER));
        addSequential(new ShooterWheelSetRPM(ShooterWheelRPM.SHOOTER_WHEEL_RPM_REAR_PYRAMID));
        addSequential(new WaitTimer(ShooterWheelRPM.SHOOTER_WHEEL_SPOOL_UP_TIME_SEC));
        addSequential(new ShooterShoot3FrisbeesWaitRPM());
        addSequential(new WaitCommand(0.1));  // Make sure last Frisbee clears shooter
        addSequential(new ShooterWheelSetRPM(0));
    }
}

