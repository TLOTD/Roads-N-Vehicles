package net.tlotd.roads_n_vehicles;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.renderer.RenderType;
import net.tlotd.roads_n_vehicles.block.ModBlocks;
import net.tlotd.roads_n_vehicles.block.custom.entity.ModBlockEntities;
import net.tlotd.roads_n_vehicles.block.custom.entity.renderer.LicensePlateRenderer;
import net.tlotd.roads_n_vehicles.block.custom.entity.renderer.TownSignRenderer;
import net.tlotd.roads_n_vehicles.entity.ModEntities;
import net.tlotd.roads_n_vehicles.entity.client.*;

public class TLOTDRoadsnVehiclesClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(
                RenderType.cutout(),
                ModBlocks.IRON_ROD_CORNER,
                ModBlocks.IRON_ROD_CORNER_DECOR,
                ModBlocks.TOWN_SIGN,
                ModBlocks.TRAFFIC_LIGHT,
                ModBlocks.TRAFFIC_LIGHT_LEFT,
                ModBlocks.TRAFFIC_LIGHT_RIGHT,
                ModBlocks.TRAFFIC_LIGHT_STRAIGHT,
                ModBlocks.TRAFFIC_LIGHT_STRAIGHT_LEFT,
                ModBlocks.TRAFFIC_LIGHT_STRAIGHT_RIGHT,
                ModBlocks.TRAFFIC_LIGHT_GREEN_ARROW_LEFT,
                ModBlocks.TRAFFIC_LIGHT_GREEN_ARROW_RIGHT,
                ModBlocks.HORIZONTAL_TRAFFIC_LIGHT,
                ModBlocks.SMALL_TRAFFIC_LIGHT,
                ModBlocks.PEDESTRIAN_SIGNAL,
                ModBlocks.YELLOW_TRAFFIC_LIGHT,
                ModBlocks.YELLOW_TRAFFIC_LIGHT_LEFT,
                ModBlocks.YELLOW_TRAFFIC_LIGHT_RIGHT,
                ModBlocks.YELLOW_TRAFFIC_LIGHT_STRAIGHT,
                ModBlocks.YELLOW_TRAFFIC_LIGHT_STRAIGHT_LEFT,
                ModBlocks.YELLOW_TRAFFIC_LIGHT_STRAIGHT_RIGHT,
                ModBlocks.YELLOW_HORIZONTAL_TRAFFIC_LIGHT,
                ModBlocks.JAPANESE_HORIZONTAL_TRAFFIC_LIGHT
        );

        BlockEntityRendererRegistry.register(
                ModBlockEntities.LICENSE_PLATE,
                LicensePlateRenderer::new
        );
        BlockEntityRendererRegistry.register(
                ModBlockEntities.TOWN_SIGN,
                TownSignRenderer::new
        );

        EntityRendererRegistry.register(
                ModEntities.MUSCLE_CAR_FIRECHARGE,
                MuscleCarFirechargeRenderer::new
        );
        EntityRendererRegistry.register(
                ModEntities.MUSCLE_CAR_STALLION,
                MuscleCarStallionRenderer::new
        );
        EntityModelLayerRegistry.registerModelLayer(
                ModModelLayers.MUSCLE_CAR_FIRECHARGE,
                MuscleCarFirechargeModel::createBodyLayer
        );
        EntityModelLayerRegistry.registerModelLayer(
                ModModelLayers.MUSCLE_CAR_STALLION,
                MuscleCarStallionModel::createBodyLayer
        );
    }
}
