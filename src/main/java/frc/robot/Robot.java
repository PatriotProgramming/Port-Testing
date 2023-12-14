// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot; //inverse 9 in code, 

import javax.lang.model.util.ElementScanner14;
import javax.security.auth.x500.X500Principal;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot 
{
  
  private CANSparkMax lowerArmL, lowerArmR, topArm, motor1, motorA;

  private XboxController xbox;

  private Compressor comp;



  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() 
  {
    // motor1 = new CANSparkMax(3, MotorType.kBrushless);
    lowerArmL = new CANSparkMax(11, MotorType.kBrushless);
    lowerArmR = new CANSparkMax(12, MotorType.kBrushless);
    topArm = new CANSparkMax(9, MotorType.kBrushless);

    // motorA = new CANSparkMax(7, MotorType.kBrushless);

    xbox = new XboxController(0);

    lowerArmL.setInverted(true);
    lowerArmR.setInverted(false);

    lowerArmL.setIdleMode(IdleMode.kBrake);
    lowerArmR.setIdleMode(IdleMode.kBrake);
    topArm.setIdleMode(IdleMode.kBrake);

    // motorA.setIdleMode(IdleMode.kBrake);
  }

  /**
   * This function is called every 20 ms, no matter the mode. Use this for items like diagnostics
   * that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() 
  {
    //Lower Arm Left
    // if(xbox.getRawButton(1))
    // {
    //   motor1.set(0.1);
    // }
    // else if(xbox.getRawButton(2))
    // {
    //   motor1.set(-0.1);
    // }
    // else 
    // {
    //   motor1.stopMotor();
    // }


    // Lower Arm Right
    // if(xbox.getRawButton(1))
    // {
    //   motorA.set(0.2);
    // }
    // else if(xbox.getRawButton(2))
    // {
    //   motorA.set(-0.2);
    // }
    // else
    // {
    //   motorA.set(0);
    // }
    if(xbox.getRawButton(1))
    {
      lowerArmR.set(0.2);
      lowerArmL.set(0.2);
    }
    else if(xbox.getRawButton(2))
    {
      
      lowerArmR.set(-0.2);
      lowerArmL.set(-0.2);
    }
    else 
    {
      lowerArmR.stopMotor();
      lowerArmL.stopMotor();
    }


  //   // Top Arm
    if(xbox.getRawButton(3))
    {
      topArm.set(-0.2);
    }
    else if(xbox.getRawButton(4))
    {
      topArm.set(0.2);
    }
    else 
    {
      topArm.stopMotor();
    }
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select between different
   * autonomous modes using the dashboard. The sendable chooser code works with the Java
   * SmartDashboard. If you prefer the LabVIEW Dashboard, remove all of the chooser code and
   * uncomment the getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to the switch structure
   * below with additional strings. If using the SendableChooser make sure to add them to the
   * chooser code above as well.
   */
  @Override
  public void autonomousInit() {}

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {}

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {}

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {}

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {}

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {}

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {}

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {}
}
