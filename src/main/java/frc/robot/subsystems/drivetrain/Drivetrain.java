package frc.robot.subsystems.drivetrain;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Ports;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Drivetrain extends SubsystemBase {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    TalonFX motorRightFront = new TalonFX(Ports.Drivetrain.MOTOR_RIGHT_FRONT);
    TalonFX motorRightBack = new TalonFX(Ports.Drivetrain.MOTOR_RIGHT_BACK);
    TalonFX motorLeftFront = new TalonFX(Ports.Drivetrain.MOTOR_LEFT_FRONT);
    TalonFX motorLeftBack = new TalonFX(Ports.Drivetrain.MOTOR_LEFT_BACK);



    public Drivetrain(){

    }

    @Override
    public void periodic() {

    }
}