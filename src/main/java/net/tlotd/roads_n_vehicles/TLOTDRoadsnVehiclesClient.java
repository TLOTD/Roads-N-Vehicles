package net.tlotd.roads_n_vehicles;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.tlotd.roads_n_vehicles.block.ModBlocks;

public class TLOTDRoadsnVehiclesClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		BlockRenderLayerMap.putBlocks(
				ChunkSectionLayer.CUTOUT,
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
	}
}
