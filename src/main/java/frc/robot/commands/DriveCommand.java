/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

	/**
	 * An example command.  You can replace me with your own command.
	 */
	public class DriveCommand extends Command {
		public DriveCommand() {
			requires(Robot.driveTrain);
		}

		protected void initialize() {
		}

	@Override
	protected void execute() {
		//Robot.driveTrain.drive() ---
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
		System.out.println("FATAL ERROR!!! Drive Train has been interrupted.");
	}
}
