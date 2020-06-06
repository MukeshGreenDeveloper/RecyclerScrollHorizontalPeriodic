package lanec.slidepager;

import android.content.Context;
import android.graphics.PointF;

import androidx.recyclerview.widget.LinearSmoothScroller;

public class SmoothScroller extends LinearSmoothScroller {
    private final float distanceInPixels;
    private final float duration;

    public SmoothScroller(Context context, int distanceInPixels, int duration) {
        super(context);
        this.distanceInPixels = distanceInPixels;
        this.duration = duration;
    }

    @Override
    public PointF computeScrollVectorForPosition(int targetPosition) {
        return super
                .computeScrollVectorForPosition(targetPosition);
    }

    @Override
    protected int calculateTimeForScrolling(int dx) {
        float proportion = (float) dx / distanceInPixels;
        return (int) (duration * proportion);
    }
}