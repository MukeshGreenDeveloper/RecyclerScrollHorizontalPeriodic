package lanec.slidepager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    BannerAdapter adapter;
    RecyclerView bannerView;
    SwipeTask swipeTask;
    Timer swipeTimer;
    ScrollingLinearLayoutManager scrollManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<String> list=new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        adapter=new BannerAdapter(this,list);
        bannerView=((RecyclerView)findViewById(R.id.bannerView));
        scrollManager = new ScrollingLinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false, 100);
        bannerView.setLayoutManager(scrollManager);
        bannerView.setAdapter(adapter);
        startTimer();
    }
    class SwipeTask extends TimerTask {
        public void run() {
            bannerView.post(()->{
                int nextPage = (scrollManager.findFirstVisibleItemPosition() + 1) % adapter.getItemCount();
                bannerView.smoothScrollToPosition(nextPage);
            });
        }
    }
    private void stopScrollTimer() {
        if (null != swipeTimer) {
            swipeTimer.cancel();
        }
        if (null != swipeTask) {
            swipeTask.cancel();
        }
    }

    private void startTimer() {
        stopScrollTimer();
        swipeTask = new SwipeTask();
        swipeTimer = new Timer();
        swipeTimer.schedule(swipeTask,0, 300);
    }
}
