
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.stolenheart.entities.BaseEnt;
import com.stolenheart.player.PlayerM;



public class Player extends BaseEnt {

    private PlayerM movement = new PlayerM();
    private TiledMapTileLayer collisionLayer;

    public float oldX, oldY;

    public Player(Sprite sprite, TiledMapTileLayer collisionLayer) {
        super(sprite);
        this.collisionLayer = collisionLayer;
        setScale(2);
        setSize((float)(getWidth() * 1.5), getHeight() * 2);
        Gdx.input.setInputProcessor(movement);
    }

    @Override
    public void draw(Batch batch) {
        update(Gdx.graphics.getDeltaTime());
        super.draw(batch);
    }

    public void update(float delta) {
/*        Collision collision = new Collision(this, collisionLayer);
        new Gravity(movement.velocity, movement.speed, movement.gravity, delta);

        float oldX = getX(), oldY = getY();
        this.oldX = oldX;
        this.oldY = oldY;

        //move on x axis
        setX(getX() + movement.velocity.x * delta);
        if (movement.velocity.x < 0 || movement.velocity.x > 0) { //moving left
            collision.collideX = collision.collisionXDetect();
        }

        if (collision.collideX) {
            setX(oldX);
            movement.velocity.x = 0;
        }

        //move on y axis
        setY(getY() + movement.velocity.y * delta);
        if (movement.velocity.y < 0 || movement.velocity.y > 0) { //falling
            movement.canJump = collision.collideY = collision.collisionYDetect();
        }

        if (collision.collideY){
            setY(oldY);
            movement.velocity.y = 0;
        }
*/
    }

    public TiledMapTileLayer getCollisionLayer() {
        return collisionLayer;
    }

    public PlayerM getM(){
        return movement;
    }
}