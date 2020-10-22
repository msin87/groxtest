import com.groupon.grox.Store;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import rx.subscriptions.CompositeSubscription;
import java.awt.*;
import java.util.Random;

public class Test {
    private static final int SEED = 7;
    public static final int MAX_COLOR = 256;
    private Store<State> store = new Store<>(State.empty());
    private Random random = new Random(SEED);
    private final CompositeSubscription subscription = new CompositeSubscription();
    private void updateUI(State newState) {
        if (newState.isRefreshing) {
            System.out.println("↺");
        } else if (newState.error != null) {
            System.out.println(newState.error);
        } else if (newState.color != State.INVALID_COLOR) {
            System.out.println("Color: " + newState.color);
        }
    }

    public void changeColor() {
        Color color = new Color(random.nextInt(MAX_COLOR), random.nextInt(MAX_COLOR), random.nextInt(MAX_COLOR));
        final int rgb =
                color.getRGB();
        store.dispatch(new ChangeColorAction(rgb));
    }
    Test(){
        store.subscribe(this::updateUI);

    }
}
