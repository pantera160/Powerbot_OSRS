import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;
import org.powerbot.script.rt4.ClientContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Thomas.Straetmans on 21/11/2016.
 */
@Script.Manifest(name="Fishing AIO", description="Fishes whatever and drops")
public class FishingAIO extends PollingScript<ClientContext> {

    private List<Task> taskList = new ArrayList<>();

    @Override
    public void start(){
        taskList.addAll(Arrays.asList(new FindSpot(ctx), new DropTarFishTask(ctx)));
    }


    @Override
    public void poll() {
        for(Task task:taskList ){
            if(task.activate()){
                task.execute();
            }
        }
    }
}
