import org.powerbot.script.ClientAccessor;
import org.powerbot.script.ClientContext;

/**
 * Created by Thomas.Straetmans on 22/11/2016.
 */
public abstract class Task<C extends ClientContext> extends ClientAccessor<C>{
    public Task(C ctx) {
        super(ctx);
    }

    public abstract boolean activate();
    public abstract void execute();
}
