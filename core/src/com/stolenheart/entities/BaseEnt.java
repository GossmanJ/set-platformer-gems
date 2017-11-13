package com.stolenheart.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

public abstract class BaseEnt extends Sprite {

    private TiledMapTileLayer collisionLayer;

    public BaseEnt(Sprite sprite){
        super(sprite);
    }

    public TiledMapTileLayer getCollisionLayer(TiledMapTileLayer collisionLayer){
        return collisionLayer;
    }
}