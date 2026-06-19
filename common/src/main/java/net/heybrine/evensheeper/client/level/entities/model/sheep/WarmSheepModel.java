package net.heybrine.evensheeper.client.level.entities.model.sheep;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.SheepModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.animal.Sheep;


@Environment(EnvType.CLIENT)
public class WarmSheepModel<T extends Sheep> extends SheepModel<T> {
    public WarmSheepModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = SheepModel.createBodyMesh(6, CubeDeformation.NONE);
        PartDefinition root = mesh.getRoot();
        root.addOrReplaceChild(
                "head",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-3.0F, -4.0F, -6.0F, 6.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
                        .texOffs(0, 32)
                        .addBox(1.0F, -6.0F, -2.75F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                        .texOffs(0, 42)
                        .addBox(4.0F, -3.0F, -4.75F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                        .texOffs(0, 32)
                        .mirror()
                        .addBox(-5.0F, -6.0F, -2.75F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                        .mirror(false)
                        .texOffs(0, 42)
                        .mirror()
                        .addBox(-5.0F, -3.0F, -4.75F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                        .mirror(false),
                PartPose.offset(0.0F, 6.0F, -8.0F)
        );

        return LayerDefinition.create(mesh, 64, 64);
    }
}