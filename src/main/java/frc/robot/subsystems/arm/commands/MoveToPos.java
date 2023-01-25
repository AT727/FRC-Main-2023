package frc.robot.subsystems.arm.commands;

import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsystems.Arm;
import frc.robot.Constants.Arms;
import frc.robot.subsystems.arm.*;
public class MoveToPos extends SequentialCommandGroup {

    private Arm arm;
    
    public MoveToPos(Arm arm, double desiredAnchor, double desiredFloating){
        this.arm = arm;
        addCommands(
            new SequentialCommandGroup(
                new MoveAnchorJoint(Math.PI / 2, arm), new MoveFloatingJoint(desiredFloating, arm),
                new MoveAnchorJoint(desiredAnchor, arm)
            )       
        );
    }
}
