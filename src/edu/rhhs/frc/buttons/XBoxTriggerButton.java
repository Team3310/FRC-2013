/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.rhhs.frc.buttons;

import edu.rhhs.frc.controller.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;

/**
 *
 * @author bselle
 */
public class XBoxTriggerButton extends Button {

    public static final int RIGHT_TRIGGER = 0;
    public static final int LEFT_TRIGGER = 1;
    public static final int RIGHT_AXIS_UP_TRIGGER = 2;
    public static final int RIGHT_AXIS_DOWN_TRIGGER = 3;
    public static final int RIGHT_AXIS_RIGHT_TRIGGER = 4;
    public static final int RIGHT_AXIS_LEFT_TRIGGER = 5;
    
    private XboxController m_controller;
    private int m_trigger;
    
    public XBoxTriggerButton(XboxController controller, int trigger) {
        m_controller = controller;
        m_trigger = trigger;
    }
    
    public boolean get() {
        if (m_trigger == RIGHT_TRIGGER) {
            return m_controller.getRightTrigger();
        }
        else if (m_trigger == LEFT_TRIGGER) {
            return m_controller.getLeftTrigger();
        }
        else if (m_trigger == RIGHT_AXIS_UP_TRIGGER) {
            return m_controller.getRightAxisUpTrigger();
        }
        else if (m_trigger == RIGHT_AXIS_DOWN_TRIGGER) {
            return m_controller.getRightAxisDownTrigger();
        }
        else if (m_trigger == RIGHT_AXIS_RIGHT_TRIGGER) {
            return m_controller.getRightAxisRightTrigger();
        }
        else if (m_trigger == RIGHT_AXIS_LEFT_TRIGGER) {
            return m_controller.getRightAxisLeftTrigger();
        }
        return false;
    }
    
}
