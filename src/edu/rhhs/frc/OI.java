
package edu.rhhs.frc;

import edu.rhhs.frc.buttons.XBoxDPadTriggerButton;
import edu.rhhs.frc.buttons.XBoxTriggerButton;
import edu.rhhs.frc.commands.BlockerMove;
import edu.rhhs.frc.commands.BlockerMoveToPosition;
import edu.rhhs.frc.commands.BlockerReset;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.InternalButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.rhhs.frc.commands.ChassisSetup;
import edu.rhhs.frc.commands.Climb10PtHangerSetPosition;
import edu.rhhs.frc.commands.FloorIntakeExtendAndLower;
import edu.rhhs.frc.commands.FloorIntakeRaiseAndRetract;
import edu.rhhs.frc.commands.FloorIntakeSetPosition;
import edu.rhhs.frc.commands.FloorIntakeSetRollerSpeed;
import edu.rhhs.frc.commands.ShooterIntakeEject;
import edu.rhhs.frc.commands.ShooterIntakeFrisbeeCountReset;
import edu.rhhs.frc.commands.ShooterIntakeLoad1Frisbee;
import edu.rhhs.frc.commands.ShooterIntakeLoad4Frisbees;
import edu.rhhs.frc.commands.ShooterIntakeSetFrontRollerSpeed;
import edu.rhhs.frc.commands.ShooterIntakeSetRearRollerSpeed;
import edu.rhhs.frc.commands.ShooterKickerSetPosition;
import edu.rhhs.frc.commands.ShooterLoaderSetPosition;
import edu.rhhs.frc.commands.ShooterPitchRotate;
import edu.rhhs.frc.commands.ShooterPitchSetAngle;
import edu.rhhs.frc.commands.ShooterPitchSetTrim;
import edu.rhhs.frc.commands.ShooterSetShootPosition;
import edu.rhhs.frc.commands.ShooterSetShootPositionRelative;
import edu.rhhs.frc.commands.ShooterShoot1FrisbeeWaitRPM;
import edu.rhhs.frc.commands.ShooterShoot4FrisbeesWaitRPM;
import edu.rhhs.frc.commands.ShooterWheelIncrementRPM;
import edu.rhhs.frc.commands.ShooterWheelSetRPM;
import edu.rhhs.frc.commands.ShooterWheelSetSpeed;
import edu.rhhs.frc.commands.TransmissionShift;
import edu.rhhs.frc.controller.XboxController;
import edu.rhhs.frc.subsystems.PneumaticSubsystem;
import edu.rhhs.frc.subsystems.ShooterIntake;
import edu.rhhs.frc.subsystems.ShooterPitchAngle;
import edu.rhhs.frc.subsystems.ShooterPitchSelector;
import edu.rhhs.frc.subsystems.Transmission;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    // Driver stick

    private static OI instance = null;
    private Joystick m_joystick1;
    private Joystick m_joystick2;
    private XboxController m_xboxController;
//    private Joystick m_steeringWheel;

    private OI() {
        // Driver stick
        m_joystick1 = new Joystick(RobotMap.JOYSTICK_1_USB_ID);
        m_joystick2 = new Joystick(RobotMap.JOYSTICK_2_USB_ID);
        m_xboxController = new XboxController(RobotMap.XBOX_USB_ID);
//        m_steeringWheel = new Joystick(RobotMap.STEERING_WHEEL_USB_ID);
        
        JoystickButton joystickShiftTrigger = new JoystickButton(m_joystick1, RobotMap.JOYSTICK_1_SHIFT_BUTTON);
        joystickShiftTrigger.whenPressed(new TransmissionShift(Transmission.HI_GEAR));
        joystickShiftTrigger.whenReleased(new TransmissionShift(Transmission.LO_GEAR));
 
//        JoystickButton xboxShiftTrigger = new JoystickButton(m_xboxController.getJoyStick(), RobotMap.XBOX_SHIFT_BUTTON);
//        xboxShiftTrigger.whenPressed(new TransmissionShift(Transmission.HI_GEAR));
//        xboxShiftTrigger.whenReleased(new TransmissionShift(Transmission.LO_GEAR));
// 
//        JoystickButton xboxLightsOffTrigger = new JoystickButton(m_xboxController.getJoyStick(), RobotMap.XBOX_LIGHTS_OFF_BUTTON);
//        xboxLightsOffTrigger.whenPressed(new LEDLightsShow(0, 0, 0, 0, 0, 0));
//    
//        JoystickButton xboxLightsRedTrigger = new JoystickButton(m_xboxController.getJoyStick(), RobotMap.XBOX_LIGHTS_RED_BUTTON);
//        xboxLightsRedTrigger.whenPressed(new LEDLightsShow(255, 0, 0, 255, 0, 0));
//    
//        JoystickButton xboxLightsGreenTrigger = new JoystickButton(m_xboxController.getJoyStick(), RobotMap.XBOX_LIGHTS_GREEN_BUTTON);
//        xboxLightsGreenTrigger.whenPressed(new LEDLightsShow(0, 255, 0, 0, 255, 0));
//    
//        JoystickButton xboxLightsBlueTrigger = new JoystickButton(m_xboxController.getJoyStick(), RobotMap.XBOX_LIGHTS_BLUE_BUTTON);
//        xboxLightsBlueTrigger.whenPressed(new LEDLightsShow(0, 0, 255, 0, 0, 255));
//    
//        JoystickButton xboxLightsGoldTrigger = new JoystickButton(m_xboxController.getJoyStick(), RobotMap.XBOX_LIGHTS_GOLD_BUTTON);
//        xboxLightsGoldTrigger.whenPressed(new LEDLightsShow(248, 221, 136, 248, 221, 136));
    
        JoystickButton frisbeeResetCountTrigger = new JoystickButton(m_xboxController.getJoyStick(), XboxController.LEFT_JOYSTICK_BUTTON);
        frisbeeResetCountTrigger.whenPressed(new ShooterIntakeFrisbeeCountReset());

        JoystickButton blockerPositionResetTrigger = new JoystickButton(m_xboxController.getJoyStick(), XboxController.RIGHT_JOYSTICK_BUTTON);
        blockerPositionResetTrigger.whenPressed(new BlockerReset());

        XBoxTriggerButton blockerPosition76Trigger = new XBoxTriggerButton(m_xboxController, XBoxTriggerButton.RIGHT_AXIS_UP_TRIGGER);
        blockerPosition76Trigger.whenPressed(new BlockerMove(1.0, 76));
        
 //       XBoxTriggerButton blockerPosition60Trigger = new XBoxTriggerButton(m_xboxController, XBoxTriggerButton.RIGHT_AXIS_LEFT_TRIGGER);
//        blockerPosition60Trigger.whenPressed(new BlockerMove(1.0, 45.0));
        XBoxTriggerButton blockerPosition60Trigger = new XBoxTriggerButton(m_xboxController, XBoxTriggerButton.RIGHT_AXIS_LEFT_TRIGGER);
        blockerPosition60Trigger.whenPressed(new BlockerMoveToPosition(45.0, 1.0));
        
        XBoxTriggerButton blockerPosition0Trigger = new XBoxTriggerButton(m_xboxController, XBoxTriggerButton.RIGHT_AXIS_DOWN_TRIGGER);
        blockerPosition0Trigger.whenPressed(new BlockerMove(-1.0, 1.0));
                
        XBoxTriggerButton blockerMoveDownTrigger = new XBoxTriggerButton(m_xboxController, XBoxTriggerButton.RIGHT_AXIS_RIGHT_TRIGGER);
        blockerMoveDownTrigger.whenPressed(new BlockerMove(-0.4, -1.0));
        
        JoystickButton shooterPitchCorner = new JoystickButton(m_xboxController.getJoyStick(), XboxController.X_BUTTON);
        shooterPitchCorner.whenPressed(new ShooterSetShootPosition(ShooterPitchSelector.SHOOTER_SELECTOR_ANGLE_CORNER));
//        shooterPitchCorner.whenPressed(new ShooterPitchSetSelectorAngle(ShooterPitchSelector.SHOOTER_SELECTOR_ANGLE_CORNER));

        JoystickButton shooterPitchLoadTrigger = new JoystickButton(m_xboxController.getJoyStick(), RobotMap.XBOX_SHOOTER_PITCH_ANGLE_LOAD_BUTTON);
        shooterPitchLoadTrigger.whenPressed(new ShooterPitchSetAngle(ShooterPitchAngle.FEEDER_STATION_LOAD));

        JoystickButton shooterPitchHalfCourtTrigger = new JoystickButton(m_xboxController.getJoyStick(), RobotMap.XBOX_SHOOTER_PITCH_ANGLE_HALF_COURT_BUTTON);
        shooterPitchHalfCourtTrigger.whenPressed(new ShooterSetShootPositionRelative(ShooterPitchAngle.SHOOT_HALF_COURT_RELATIVE_ANGLE));

        JoystickButton shooterPitchBackPyramidTrigger = new JoystickButton(m_xboxController.getJoyStick(), RobotMap.XBOX_SHOOTER_PITCH_ANGLE_PYRAMID_BACK_BUTTON);
//        shooterPitchBackPyramidTrigger.whenPressed(new ShooterPitchSetToShoot(-0.9));
        shooterPitchBackPyramidTrigger.whenPressed(new ShooterSetShootPosition(ShooterPitchSelector.SHOOTER_SELECTOR_ANGLE_CENTER));
//        shooterPitchBackPyramidTrigger.whenPressed(new ShooterPitchSetSelectorAngle(ShooterPitchSelector.SHOOTER_SELECTOR_ANGLE_CENTER));
       
        JoystickButton shooterLoadFourTrigger = new JoystickButton(m_xboxController.getJoyStick(), RobotMap.XBOX_SHOOTER_INTAKE_LOAD_FOUR_BUTTON);
        shooterLoadFourTrigger.whenPressed(new ShooterIntakeLoad4Frisbees(ShooterIntake.SHOOTER_INTAKE_LOAD_SPEED));

        XBoxTriggerButton shooterShootAllTrigger = new XBoxTriggerButton(m_xboxController, XBoxTriggerButton.RIGHT_TRIGGER);
        shooterShootAllTrigger.whenPressed(new ShooterShoot4FrisbeesWaitRPM());
        
        XBoxDPadTriggerButton pitchPosTrimTrigger = new XBoxDPadTriggerButton(m_xboxController, XBoxDPadTriggerButton.RIGHT_TRIGGER);
        pitchPosTrimTrigger.whenPressed(new ShooterPitchSetTrim(-1.0));
        
        XBoxDPadTriggerButton pitchNegTrimTrigger = new XBoxDPadTriggerButton(m_xboxController, XBoxDPadTriggerButton.LEFT_TRIGGER);
        pitchNegTrimTrigger.whenPressed(new ShooterPitchSetTrim(1.0));
        
        XBoxTriggerButton climb10PtHangarTrigger = new XBoxTriggerButton(m_xboxController, XBoxTriggerButton.LEFT_TRIGGER);
        climb10PtHangarTrigger.whenPressed(new Climb10PtHangerSetPosition(PneumaticSubsystem.EXTEND));
        climb10PtHangarTrigger.whenReleased(new Climb10PtHangerSetPosition(PneumaticSubsystem.RETRACT));
        
//        JoystickButton climbArmDownTrigger = new JoystickButton(m_joystick1, RobotMap.JOYSTICK_1_CLIMB_ARM_DOWN_BUTTON);
//        climbArmDownTrigger.whileHeld(new ClimbArmRotate(-0.2));
//        climbArmDownTrigger.whenReleased(new ClimbArmRotate(0.0));
//
//        JoystickButton climbArmUpTrigger = new JoystickButton(m_joystick1, RobotMap.JOYSTICK_1_CLIMB_ARM_UP_BUTTON);
//        climbArmUpTrigger.whileHeld(new ClimbArmRotate(0.2));
//        climbArmUpTrigger.whenReleased(new ClimbArmRotate(0.0));
//
//        JoystickButton winchDownTrigger = new JoystickButton(m_joystick2, RobotMap.JOYSTICK_2_CLIMB_WINCH_DOWN_BUTTON);
//        winchDownTrigger.whileHeld(new ClimbWinchRotate(-0.5));
//        winchDownTrigger.whenReleased(new ClimbWinchRotate(0.0));
//
//        JoystickButton winchUpTrigger = new JoystickButton(m_joystick2, RobotMap.JOYSTICK_2_CLIMB_WINCH_UP_BUTTON);
//        winchUpTrigger.whileHeld(new ClimbWinchRotate(0.5));
//        winchUpTrigger.whenReleased(new ClimbWinchRotate(0.0));

        JoystickButton floorIntakeExtendTrigger = new JoystickButton(m_joystick1, RobotMap.JOYSTICK_1_FLOOR_INTAKE_EXTEND_BUTTON);
        floorIntakeExtendTrigger.whenPressed(new FloorIntakeSetPosition(PneumaticSubsystem.EXTEND));

        JoystickButton floorIntakeRetractTrigger = new JoystickButton(m_joystick1, RobotMap.JOYSTICK_1_FLOOR_INTAKE_RETRACT_BUTTON);
        floorIntakeRetractTrigger.whenPressed(new FloorIntakeSetPosition(PneumaticSubsystem.RETRACT));

        JoystickButton floorIntakeExtendAndLowerTrigger = new JoystickButton(m_joystick1, RobotMap.JOYSTICK_1_FLOOR_INTAKE_EXTEND_AND_LOWER_BUTTON);
        floorIntakeExtendAndLowerTrigger.whenPressed(new FloorIntakeExtendAndLower());

        JoystickButton floorIntakeRaiseAndRetractTrigger = new JoystickButton(m_joystick1, RobotMap.JOYSTICK_1_FLOOR_INTAKE_RAISE_AND_RETRACT_BUTTON);
        floorIntakeRaiseAndRetractTrigger.whenPressed(new FloorIntakeRaiseAndRetract());

//        JoystickButton shootSevenAutonTrigger = new JoystickButton(m_joystick1, RobotMap.JOYSTICK_1_CHASSIS_MOVE_BUTTON);
//        shootSevenAutonTrigger.whenPressed(new ShooterShootSevenAutonomous());

        JoystickButton floorIntakeOnTrigger = new JoystickButton(m_joystick1, RobotMap.JOYSTICK_1_FLOOR_INTAKE_ON_BUTTON);
        floorIntakeOnTrigger.whileHeld(new FloorIntakeSetRollerSpeed(-0.9));
        floorIntakeOnTrigger.whenReleased(new FloorIntakeSetRollerSpeed(0.0));

        JoystickButton shooterIntakeEjectTrigger = new JoystickButton(m_xboxController.getJoyStick(), RobotMap.XBOX_SHOOTER_INTAKE_EJECT_BUTTON);
        shooterIntakeEjectTrigger.whileHeld(new ShooterIntakeEject(-0.7));
        shooterIntakeEjectTrigger.whenReleased(new ShooterIntakeEject(0.0));

        JoystickButton shooterIntakeFrontEjectTrigger = new JoystickButton(m_joystick2, RobotMap.JOYSTICK_2_SHOOTER_INTAKE_FRONT_EJECT_BUTTON);
        shooterIntakeFrontEjectTrigger.whileHeld(new ShooterIntakeSetFrontRollerSpeed(-0.5));
        shooterIntakeFrontEjectTrigger.whenReleased(new ShooterIntakeSetFrontRollerSpeed(0.0));

        JoystickButton shooterIntakeRearEjectTrigger = new JoystickButton(m_joystick2, RobotMap.JOYSTICK_2_SHOOTER_INTAKE_REAR_EJECT_BUTTON);
        shooterIntakeRearEjectTrigger.whileHeld(new ShooterIntakeSetRearRollerSpeed(-0.5));
        shooterIntakeRearEjectTrigger.whenReleased(new ShooterIntakeSetRearRollerSpeed(0.0));

        JoystickButton shooterIntakeFrontOnTrigger = new JoystickButton(m_joystick1, RobotMap.JOYSTICK_1_SHOOTER_INTAKE_FRONT_ON_BUTTON);
        shooterIntakeFrontOnTrigger.whileHeld(new ShooterIntakeSetFrontRollerSpeed(0.7));
        shooterIntakeFrontOnTrigger.whenReleased(new ShooterIntakeSetFrontRollerSpeed(0.0));

        JoystickButton shooterIntakeRearOnTrigger = new JoystickButton(m_joystick1, RobotMap.JOYSTICK_1_SHOOTER_INTAKE_REAR_ON_BUTTON);
        shooterIntakeRearOnTrigger.whileHeld(new ShooterIntakeSetRearRollerSpeed(0.7));
        shooterIntakeRearOnTrigger.whenReleased(new ShooterIntakeSetRearRollerSpeed(0.0));

//        JoystickButton climbFootExtendTrigger = new JoystickButton(m_joystick1, RobotMap.JOYSTICK_1_CLIMB_FOOT_EXTEND_BUTTON);
//        climbFootExtendTrigger.whileHeld(new ClimbFootSetPosition(PneumaticSubsystem.EXTEND));
//        climbFootExtendTrigger.whenReleased(new ClimbFootSetPosition(PneumaticSubsystem.RETRACT));
         
        JoystickButton shooterRPMPlusTrigger = new JoystickButton(m_joystick2, RobotMap.JOYSTICK_2_SHOOTER_WHEEL_PLUS_RPM_BUTTON);
        shooterRPMPlusTrigger.whenPressed(new ShooterWheelSetRPM(3000));
        
        JoystickButton shooterRPMMinusTrigger = new JoystickButton(m_joystick2, RobotMap.JOYSTICK_2_SHOOTER_WHEEL_MINUS_RPM_BUTTON);
        shooterRPMMinusTrigger.whenPressed(new ShooterWheelSetSpeed(-1.0));
        
        JoystickButton shooterRPMStopTrigger = new JoystickButton(m_joystick2, RobotMap.JOYSTICK_2_SHOOTER_WHEEL_STOP_RPM_BUTTON);
        shooterRPMStopTrigger.whenPressed(new ShooterWheelSetSpeed(0));
        
        JoystickButton shooterPitchDownTrigger = new JoystickButton(m_joystick2, RobotMap.JOYSTICK_2_SHOOTER_PITCH_ANGLE_DOWN_BUTTON);
        shooterPitchDownTrigger.whileHeld(new ShooterPitchRotate(-0.3));
        shooterPitchDownTrigger.whenReleased(new ShooterPitchRotate(0.0));

        JoystickButton shooterPitchUpTrigger = new JoystickButton(m_joystick2, RobotMap.JOYSTICK_2_SHOOTER_PITCH_ANGLE_UP_BUTTON);
        shooterPitchUpTrigger.whileHeld(new ShooterPitchRotate(0.2));
        shooterPitchUpTrigger.whenReleased(new ShooterPitchRotate(0.0));

        JoystickButton shooterKickerTrigger = new JoystickButton(m_joystick2, RobotMap.JOYSTICK_2_SHOOTER_KICKER_BUTTON);
        shooterKickerTrigger.whileHeld(new ShooterKickerSetPosition(PneumaticSubsystem.EXTEND));
        shooterKickerTrigger.whenReleased(new ShooterKickerSetPosition(PneumaticSubsystem.RETRACT));

        JoystickButton shooterLoaderTrigger = new JoystickButton(m_joystick2, RobotMap.JOYSTICK_2_SHOOTER_LOADER_BUTTON);
        shooterLoaderTrigger.whileHeld(new ShooterLoaderSetPosition(PneumaticSubsystem.EXTEND));
        shooterLoaderTrigger.whenReleased(new ShooterLoaderSetPosition(PneumaticSubsystem.RETRACT));
                 
        // SmartDashboard buttons
        InternalButton moveNonLinearPos = new InternalButton();
        moveNonLinearPos.whenReleased(new ChassisSetup(ChassisSetup.MOVE_NONLINEAR, 1));
        SmartDashboard.putData("+ MNL", moveNonLinearPos);

        InternalButton moveNonLinearNeg = new InternalButton();
        moveNonLinearNeg.whenReleased(new ChassisSetup(ChassisSetup.MOVE_NONLINEAR, -1));
        SmartDashboard.putData("- MNL", moveNonLinearNeg);

        InternalButton steeringNonLinearPos = new InternalButton();
        steeringNonLinearPos.whenReleased(new ChassisSetup(ChassisSetup.STEER_NONLINEAR, 1));
        SmartDashboard.putData("+ SNL", steeringNonLinearPos);

        InternalButton steeringNonLinearNeg = new InternalButton();
        steeringNonLinearNeg.whenReleased(new ChassisSetup(ChassisSetup.STEER_NONLINEAR, -1));
        SmartDashboard.putData("- SNL", steeringNonLinearNeg);

        InternalButton moveTrimPos = new InternalButton();
        moveTrimPos.whenReleased(new ChassisSetup(ChassisSetup.MOVE_TRIM, 0.05));
        SmartDashboard.putData("+ MT", moveTrimPos);

        InternalButton moveTrimNeg = new InternalButton();
        moveTrimNeg.whenReleased(new ChassisSetup(ChassisSetup.MOVE_TRIM, -0.05));
        SmartDashboard.putData("- MT", moveTrimNeg);

        InternalButton steeringTrimPos = new InternalButton();
        steeringTrimPos.whenReleased(new ChassisSetup(ChassisSetup.STEER_TRIM, 0.05));
        SmartDashboard.putData("+ ST", steeringTrimPos);

        InternalButton steeringTrimNeg = new InternalButton();
        steeringTrimNeg.whenReleased(new ChassisSetup(ChassisSetup.STEER_TRIM, -0.05));
        SmartDashboard.putData("- ST", steeringTrimNeg);
        
        InternalButton moveScalePos = new InternalButton();
        moveScalePos.whenReleased(new ChassisSetup(ChassisSetup.MOVE_SCALE, 0.05));
        SmartDashboard.putData("+ MS", moveScalePos);

        InternalButton moveScaleNeg = new InternalButton();
        moveScaleNeg.whenReleased(new ChassisSetup(ChassisSetup.MOVE_SCALE, -0.05));
        SmartDashboard.putData("- MS", moveScaleNeg);

        InternalButton steeringScalePos = new InternalButton();
        steeringScalePos.whenReleased(new ChassisSetup(ChassisSetup.STEER_SCALE, 0.05));
        SmartDashboard.putData("+ SS", steeringScalePos);

        InternalButton steeringScaleNeg = new InternalButton();
        steeringScaleNeg.whenReleased(new ChassisSetup(ChassisSetup.STEER_SCALE, -0.05));
        SmartDashboard.putData("- SS", steeringScaleNeg);
        
        InternalButton shooterPitchTrimPos = new InternalButton();
        shooterPitchTrimPos.whenReleased(new ShooterPitchSetTrim(1.0));
        SmartDashboard.putData("+ Pitch", shooterPitchTrimPos);

        InternalButton shooterPitchTrimNeg = new InternalButton();
        shooterPitchTrimNeg.whenReleased(new ShooterPitchSetTrim(-1.0));
        SmartDashboard.putData("- Pitch", shooterPitchTrimNeg);
        
        InternalButton shooterRPMTrimPos = new InternalButton();
        shooterRPMTrimPos.whenReleased(new ShooterWheelIncrementRPM(100.0));
        SmartDashboard.putData("+ RPM", shooterRPMTrimPos);

        InternalButton shooterRPMTrimNeg = new InternalButton();
        shooterRPMTrimNeg.whenReleased(new ShooterWheelIncrementRPM(-100.0));
        SmartDashboard.putData("- RPM", shooterRPMTrimNeg);
        
        InternalButton frisbeeCountReset = new InternalButton();
        frisbeeCountReset.whenReleased(new ShooterIntakeFrisbeeCountReset());
        SmartDashboard.putData("Frisbee Count Reset", frisbeeCountReset);
        
        InternalButton load1Frisbee = new InternalButton();
        load1Frisbee.whenReleased(new ShooterIntakeLoad1Frisbee(ShooterIntake.SHOOTER_INTAKE_LOAD_SPEED));
        SmartDashboard.putData("Load One Frisbee", load1Frisbee);
        
        InternalButton shoot1Frisbee = new InternalButton();
        shoot1Frisbee.whenReleased(new ShooterShoot1FrisbeeWaitRPM());
        SmartDashboard.putData("Shoot One Frisbee", shoot1Frisbee);
        
//        InternalButton turnAngle = new InternalButton();
//        turnAngle.whenReleased(new ChassisTurn(45, 0.8, 0));
//        SmartDashboard.putData("Turn 45 deg", turnAngle);
//
//        InternalButton turnAngleNeg = new InternalButton();
//        turnAngleNeg.whenReleased(new ChassisTurn(-45, 0.8, 0));
//        SmartDashboard.putData("Turn -45 deg", turnAngleNeg);
    }  

    public Joystick getJoystick1() {
        return m_joystick1;
    }
    
    public Joystick getJoystick2() {
        return m_joystick2;
    }
    
//    public Joystick getSteeringWheel() {
//        return m_steeringWheel;
//    }
    
    public XboxController getXBoxController() {
        return m_xboxController;
    }
    
    public static OI getInstance() {
        if (instance == null) {
            instance = new OI();
        }
        return instance;
    }
}

