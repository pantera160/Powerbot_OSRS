import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;

/**
 * Created by Thomas.Straetmans on 23/11/2016.
 */
public class FindSpot extends Task<ClientContext> {
    public FindSpot(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return ctx.players.local().animation() == -1;
    }

    @Override
    public void execute() {
        GameObject fishspot = ctx.objects.nearest().poll();

        if(fishspot.inViewport()){
            fishspot.interact("Use-Rod");
        } else {
            ctx.movement.step(fishspot);
            ctx.camera.turnTo(fishspot);
        }
    }
}
