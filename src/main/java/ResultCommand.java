import com.groupon.grox.Action;
import com.groupon.grox.commands.rxjava2.Command;
import io.reactivex.Observable;

public class ResultCommand implements Command {
    @Override
    public Observable<? extends Action> actions() {
        return null;
    }
}
