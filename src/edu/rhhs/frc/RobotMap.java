package edu.rhhs.frc;

import edu.rhhs.frc.controller.XboxController;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    
    // USB Port IDs
    public static final int JOYSTICK_1_USB_ID = 1;
    public static final int JOYSTICK_2_USB_ID = 2;
    public static final int XBOX_USB_ID = 3;
    public static final int STEERING_WHEEL_USB_ID = 4;

    // Joystick 1 Buttons
    public static final int JOYSTICK_1_SHIFT_BUTTON = 1;
    public static final int JOYSTICK_1_FLOOR_INTAKE_ON_BUTTON = 3;
    public static final int JOYSTICK_1_FLOOR_INTAKE_EXTEND_AND_LOWER_BUTTON = 4;
    public static final int JOYSTICK_1_FLOOR_INTAKE_RAISE_AND_RETRACT_BUTTON = 5;
    public static final int JOYSTICK_1_FLOOR_INTAKE_EXTEND_BUTTON = 11;
    public static final int JOYSTICK_1_FLOOR_INTAKE_RETRACT_BUTTON = 10;
    public static final int JOYSTICK_1_SHOOTER_INTAKE_FRONT_ON_BUTTON = 6;
    public static final int JOYSTICK_1_SHOOTER_INTAKE_REAR_ON_BUTTON = 7;
//    public static final int JOYSTICK_1_CLIMB_FOOT_EXTEND_BUTTON = 2;
    public static final int JOYSTICK_1_CHASSIS_MOVE_BUTTON = 2;
    public static final int JOYSTICK_1_CLIMB_ARM_UP_BUTTON = 8;
    public static final int JOYSTICK_1_CLIMB_ARM_DOWN_BUTTON = 9;
  
    // Joystick 2 Buttons
    public static final int JOYSTICK_2_SHOOTER_WHEEL_PLUS_RPM_BUTTON = 4;
    public static final int JOYSTICK_2_SHOOTER_WHEEL_MINUS_RPM_BUTTON = 5;
    public static final int JOYSTICK_2_SHOOTER_WHEEL_STOP_RPM_BUTTON = 3;
    public static final int JOYSTICK_2_SHOOTER_LOADER_BUTTON = 2;
    public static final int JOYSTICK_2_SHOOTER_KICKER_BUTTON = 1;
    public static final int JOYSTICK_2_SHOOTER_PITCH_ANGLE_UP_BUTTON = 6;
    public static final int JOYSTICK_2_SHOOTER_PITCH_ANGLE_DOWN_BUTTON = 7;
    public static final int JOYSTICK_2_CLIMB_WINCH_UP_BUTTON = 11;
    public static final int JOYSTICK_2_CLIMB_WINCH_DOWN_BUTTON = 10;
    public static final int JOYSTICK_2_SHOOTER_INTAKE_REAR_EJECT_BUTTON = 8;
    public static final int JOYSTICK_2_SHOOTER_INTAKE_FRONT_EJECT_BUTTON = 9;
    
    // XBox Controller Buttons
    public static final int XBOX_SHOOTER_PITCH_ANGLE_LOAD_BUTTON = XboxController.B_BUTTON;
    public static final int XBOX_SHOOTER_PITCH_ANGLE_HALF_COURT_BUTTON = XboxController.Y_BUTTON;
    public static final int XBOX_SHOOTER_PITCH_ANGLE_PYRAMID_BACK_BUTTON = XboxController.A_BUTTON;
    public static final int XBOX_SHOOTER_INTAKE_LOAD_FOUR_BUTTON = XboxController.RIGHT_BUMPER_BUTTON;
    public static final int XBOX_SHOOTER_INTAKE_EJECT_BUTTON = XboxController.LEFT_BUMPER_BUTTON;
    public static final int XBOX_LIGHTS_GOLD_BUTTON = XboxController.Y_BUTTON;
    public static final int XBOX_LIGHTS_OFF_BUTTON = XboxController.X_BUTTON;

    // DSC PWM Port IDs 
    public static final int DRIVE_LEFT_FRONT_DSC_SLOT_ID = 1;
    public static final int DRIVE_LEFT_FRONT_DSC_PWM_ID = 1;
    
    public static final int DRIVE_LEFT_REAR_DSC_SLOT_ID = 1;
    public static final int DRIVE_LEFT_REAR_DSC_PWM_ID = 2;

    public static final int DRIVE_RIGHT_FRONT_DSC_SLOT_ID = 1;
    public static final int DRIVE_RIGHT_FRONT_DSC_PWM_ID = 3;
    
    public static final int DRIVE_RIGHT_REAR_DSC_SLOT_ID = 1;
    public static final int DRIVE_RIGHT_REAR_DSC_PWM_ID = 4;
    
    public static final int CLIMB_WINCH_DSC_SLOT_ID = 1;
    public static final int CLIMB_WINCH_DSC_PWM_ID = 5;
    
    public static final int SHOOTER_RPM_DSC_SLOT_ID = 2; 
    public static final int SHOOTER_RPM_DSC_PWM_ID = 2;  

    public static final int SHOOTER_INTAKE_REAR_DSC_SLOT_ID = 1;
    public static final int SHOOTER_INTAKE_REAR_DSC_PWM_ID = 10;
    
    public static final int SHOOTER_INTAKE_FRONT_DSC_SLOT_ID = 1;
    public static final int SHOOTER_INTAKE_FRONT_DSC_PWM_ID = 9;

    public static final int SHOOTER_PITCH_DSC_SLOT_ID = 2;
    public static final int SHOOTER_PITCH_DSC_PWM_ID = 6;

    public static final int SHOOTER_PITCH_SELECTOR_DSC_SLOT_ID = 2;
    public static final int SHOOTER_PITCH_SELECTOR_DSC_PWM_ID = 4;

    public static final int CLIMB_ARM_DSC_SLOT_ID = 2;
    public static final int CLIMB_ARM_DSC_PWM_ID = 8;
    
    public static final int BLOCKER_DSC_SLOT_ID = 1;
    public static final int BLOCKER_DSC_PWM_ID = 6;
    
    public static final int FLOOR_INTAKE_DSC_SLOT_ID = 2;
    public static final int FLOOR_INTAKE_DSC_PWM_ID = 3;
    
    // DSC Digial IO Port IDs 
    public static final int COMPRESSOR_SWITCH_DSC_SLOT_ID = 1;
    public static final int COMPRESSOR_SWITCH_DSC_DIO_ID = 13;
    
    public static final int FRISBEE_COUNT_SWITCH_DSC_SLOT_ID = 1;
    public static final int FRISBEE_COUNT_SWITCH_DSC_DIO_ID = 14;
    
    public static final int LED_LIGHTS_NOT_NEEDED_DSC_SLOT_ID = 1;
    public static final int LED_LIGHTS_NOT_NEEDED_DSC_DIO_ID = 3;

    public static final int LED_LIGHTS_CS_NOT_NEEDED_DSC_SLOT_ID = 1;
    public static final int LED_LIGHTS_CS_NOT_NEEDED_DSC_DIO_ID = 4;
    
    public static final int LED_LIGHTS_CLK_DSC_SLOT_ID = 2;
    public static final int LED_LIGHTS_CLK_DSC_DIO_ID = 8;

    public static final int LED_LIGHTS_DATA_DSC_SLOT_ID = 2;
    public static final int LED_LIGHTS_DATA_DSC_DIO_ID = 9;

    public static final int RIGHT_DRIVE_ENCODER_A_DSC_SLOT_ID = 2;
    public static final int RIGHT_DRIVE_ENCODER_A_DSC_DIO_ID = 2;
 
    public static final int RIGHT_DRIVE_ENCODER_B_DSC_SLOT_ID = 2;
    public static final int RIGHT_DRIVE_ENCODER_B_DSC_DIO_ID = 3;

    public static final int LEFT_DRIVE_ENCODER_A_DSC_SLOT_ID = 2;
    public static final int LEFT_DRIVE_ENCODER_A_DSC_DIO_ID = 6;

    public static final int LEFT_DRIVE_ENCODER_B_DSC_SLOT_ID = 2;
    public static final int LEFT_DRIVE_ENCODER_B_DSC_DIO_ID = 7;

    public static final int SHOOTER_RPM_ENCODER_A_DSC_SLOT_ID = 2;
    public static final int SHOOTER_RPM_ENCODER_A_DSC_DIO_ID = 4;

    public static final int SHOOTER_RPM_ENCODER_B_DSC_SLOT_ID = 2;
    public static final int SHOOTER_RPM_ENCODER_B_DSC_DIO_ID = 5;
    
    public static final int BLOCKER_ENCODER_A_DSC_SLOT_ID = 2;
    public static final int BLOCKER_ENCODER_A_DSC_DIO_ID = 11;

    public static final int BLOCKER_ENCODER_B_DSC_SLOT_ID = 2;
    public static final int BLOCKER_ENCODER_B_DSC_DIO_ID = 12;
    
    public static final int FRISBEE_LOADER_OPTICAL_SWITCH_DSC_SLOT_ID = 2;
    public static final int FRISBEE_LOADER_OPTICAL_SWITCH_DSC_DIO_ID = 10;
    
    public static final int SHOOTER_INTAKE_OPTICAL_1_DSC_SLOT_ID = 1;
    public static final int SHOOTER_INTAKE_OPTICAL_1_DSC_DIO_ID = 11;

    public static final int SHOOTER_INTAKE_OPTICAL_2_DSC_SLOT_ID = 1;
    public static final int SHOOTER_INTAKE_OPTICAL_2_DSC_DIO_ID = 12;

    public static final int SHOOTER_INTAKE_OPTICAL_3_DSC_SLOT_ID = 1;
    public static final int SHOOTER_INTAKE_OPTICAL_3_DSC_DIO_ID = 13;

    public static final int SHOOTER_PITCH_LIMIT_SWITCH_DSC_SLOT_ID = 2;
    public static final int SHOOTER_PITCH_LIMIT_SWITCH_DSC_DIO_ID = 1;

    // DSC Relay Port IDs 
    public static final int COMPRESSOR_DSC_SLOT_ID = 1;
    public static final int COMPRESSOR_DSC_RELAY_ID = 1;
    
    public static final int CLIMB_FOOT_PNEUMATIC_VALVE_DSC_SLOT_ID = 1;
    public static final int CLIMB_FOOT_PNEUMATIC_VALVE_DSC_RELAY_ID = 4;
    
    public static final int CLIMB_10PT_HANGER_RETRACT_PNEUMATIC_VALVE_DSC_SLOT_ID = 1;
    public static final int CLIMB_10PT_HANGER_RETRACT_PNEUMATIC_VALVE_DSC_RELAY_ID = 2;
    
    public static final int CLIMB_10PT_HANGER_EXTEND_PNEUMATIC_VALVE_DSC_SLOT_ID = 1;
    public static final int CLIMB_10PT_HANGER_EXTEND_PNEUMATIC_VALVE_DSC_RELAY_ID = 3;
    
    // Analog Breakout Port IDs
    public static final int CLIMB_ARM_POTENTIOMETER_ANALOG_BREAKOUT_PORT = 4; 
    public static final int CLIMB_WINCH_POTENTIOMETER_ANALOG_BREAKOUT_PORT = 3; 
    public static final int SHOOTER_PITCH_POTENTIOMETER_ANALOG_BREAKOUT_PORT = 2; 
    public static final int CHASSIS_YAW_RATE_ANALOG_BREAKOUT_PORT = 1; 

    // Solenoid Breakout Relay Port IDs
    public static final int SHIFT_EXTEND_PNEUMATIC_RELAY_ID = 1;
    public static final int SHIFT_RETRACT_PNEUMATIC_RELAY_ID = 2;
    public static final int FLOOR_INTAKE_RETRACT_PNEUMATIC_RELAY_ID = 3;
    public static final int FLOOR_INTAKE_EXTEND_PNEUMATIC_RELAY_ID = 4;
    public static final int SHOOTER_KICKER_EXTEND_PNEUMATIC_RELAY_ID = 5;
    public static final int SHOOTER_KICKER_RETRACT_PNEUMATIC_RELAY_ID = 6;
    public static final int SHOOTER_LOADER_EXTEND_PNEUMATIC_RELAY_ID = 7;
    public static final int SHOOTER_LOADER_RETRACT_PNEUMATIC_RELAY_ID = 8;
}
