import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;

/**
 * Created by Thomas.Straetmans on 23/11/2016.
 */
public class DropTarFishTask extends Task<ClientContext> {
    public DropTarFishTask(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return ctx.inventory.itemAt(0).valid();
    }

    @Override
    public void execute() {
        ctx.inventory.itemAt(0).interact("Drop");
        ctx.inventory.itemAt(4).interact("Use");
        ctx.inventory.itemAt(8).interact("Use");
        GameObject fishingSpot = ctx.objects.nearest().poll();
        fishingSpot.interact("Use-Rod");
    }
}
