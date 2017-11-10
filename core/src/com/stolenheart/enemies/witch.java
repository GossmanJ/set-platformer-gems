package com.stolenheart.enemies;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;
import com.stolenheart.entities.BaseEnt;
import com.stolenheart.util.Collision;
import com.stolenheart.util.Gravity;


public class witch extends BaseEnt {
    private TiledMapTileLayer collisionLayer;
    Vector2 vel = new Vector2();
    float oldX, oldY;
    boolean movingLeft;
    float sideSpeed = -20;
    boolean wasColliding;

    public witch(Sprite sprite, TiledMapTileLayer collisionLayer){
        super(sprite);
        this.collisionLayer = collisionLayer;
        wasColliding = false;

    }

    @Override
    public void draw(Batch batch){
        update(Gdx.graphics.getDeltaTime());
        super.draw(batch);
    }

    public void update(float delta){
        float speed = 60, gravity = 60*2f;
        Collision collision = new Collision(this, collisionLayer);
        new Gravity(vel, speed, gravity, delta);
        float oldX = getX(), oldY = getY();
        this.oldX = oldX;
        this.oldY = oldY;

        vel.x = sideSpeed;

        if(vel.x == 0){
            for(int i = 0; i < 1; i++) {
                vel.y = speed;
            }
        }
        setX(getX() + vel.x * delta);
        if (vel.x < 0 || vel.x > 0) { //moving left
            collision.collideX = collision.collisionXDetect();
        }

        // If first frame of collision
        if (collision.collideX && !wasColliding) {
            setX(getX() + -vel.x * delta);
            if(!wasColliding){
                sideSpeed = -sideSpeed;
                wasColliding = true;
            }
        }
        // If not colliding, but was previously
        if (!collision.collideX && wasColliding){
            wasColliding = false;
        }

        setY(getY() + vel.y * delta);

        if (vel.y < 0 || vel.y > 0) { //falling
            collision.collideY = collision.collisionYDetect();
        }

        if (collision.collideY){
            setY(oldY);
            vel.y = 0;
        }

    }

    public TiledMapTileLayer getCollisionLayer() {
        return collisionLayer;
    }
