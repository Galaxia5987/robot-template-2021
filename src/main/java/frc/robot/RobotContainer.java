/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.ExampleSubsystem.ExampleSubsystem;
import frc.robot.subsystems.drivetrain.Commands.driveCommand;
import frc.robot.subsystems.drivetrain.Drivetrain;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  public Drivetrain drivetrain = new Drivetrain();
  public static XboxController xbox = new XboxController(2);
  public JoystickButton a = new JoystickButton(xbox, XboxController.Button.kA.value);
  public JoystickButton b = new JoystickButton(xbox, XboxController.Button.kB.value);
  // The robot's subsystems and commands are defined here...
  public static Joystick left = new Joystick(0);
  public static Joystick right = new Joystick(1);

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    drivetrain.setDefaultCommand(new driveCommand(1, drivetrain));
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {

    // An ExampleCommand will run in autonomous
    return null;
  }

  public static double getLeftJoystick(){
    return -left.getY();
  }

  public static double getRightJoystick(){
    return -right.getY();
  }

  public static  double getYLeftXbox(){
    return -xbox.getRawAxis(XboxController.Axis.kLeftY.value);
  }

  public static  double getYRightXbox(){
    return -xbox.getRawAxis(XboxController.Axis.kRightY.value);
  }

  public static  double getXRightXbox(){
    return -xbox.getRawAxis(XboxController.Axis.kRightX.value);
  }

  public static double getXboxRT() { return xbox.getTriggerAxis(GenericHID.Hand.kRight);}

  public static double getXboxLT() {
    return xbox.getTriggerAxis(GenericHID.Hand.kLeft);
  }
}
