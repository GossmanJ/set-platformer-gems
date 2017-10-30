package com.stolenheart.game.objects;

import java.awt.Point;

import com.stolenheart.game.objects.Block;

public class Collision {

    public static boolean playerBlock(Point p, Block b){
        return b.contains(p);
    }
}
