package com.brokenheart.game.world;

import com.badlogic.gdx.maps.tiled.TiledMap;

import java.util.HashMap;

public enum TileType {

    GRASS(1, true, "Grass"),
    DIRT(2, true, "Dirt"),
    SKY(3, false, "Sky"),
    LAVA(4, true, "Lava"),
    CLOUD(5, true, "Cloud"),
    STONE(6, true, "Stone");

    public static final int TILE_SIZE = 16;

    private int id;
    private boolean collidable;
    private String name;
    private float damage;

    private TileType(int id, boolean collidable, String name) {
        this(id, collidable, name, 0);
    }

    private TileType(int id, boolean collidable, String name, float damage) {
        this.id = id;
        this.collidable = collidable;
        this.name = name;
        this.damage = damage;
    }

    public int getId() {
        return id;
    }

    public boolean isCollidable(){
        return collidable;
    }

    public String getName() {
        return name;
    }

    public float getDamage() {
        return damage;
    }

    private static HashMap <Integer, TileType> tilemap;

    static {
        tilemap = new HashMap<Integer, TileType>();
        for (TileType tileType : TileType.values()) {
            tilemap.put(tileType.getId(), tileType);
        }
    }


        public static TileType getTileTypeById(int id) {
        return tilemap.get(id);
    }

}
