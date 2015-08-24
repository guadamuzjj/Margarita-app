package com.stormcoders.margarita_app.exercises.drag_and_sort;

import android.content.Context;

import com.h6ah4i.android.widget.advrecyclerview.swipeable.RecyclerViewSwipeManager;
import com.stormcoders.margarita_app.R;

import java.util.LinkedList;
import java.util.List;

public class ExampleDataProvider extends AbstractDataProvider {
    private List<ConcreteData> mData;
    private int mLastRemovedPosition = -1;

    public ExampleDataProvider(Context c) {

        mData = new LinkedList<>();

        String[] elements = c.getResources().getStringArray(R.array.drag_and_sort);

        for (String element : elements) {
            final long id = mData.size();
            final int viewType = 0;
            final int swipeReaction = RecyclerViewSwipeManager.REACTION_CAN_SWIPE_LEFT | RecyclerViewSwipeManager.REACTION_CAN_SWIPE_RIGHT;
            mData.add(new ConcreteData(id, viewType, element, swipeReaction));
        }
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Data getItem(int index) {
        if (index < 0 || index >= getCount()) {
            throw new IndexOutOfBoundsException("index = " + index);
        }

        return mData.get(index);
    }

    @Override
    public void moveItem(int fromPosition, int toPosition) {
        if (fromPosition == toPosition) {
            return;
        }

        final ConcreteData item = mData.remove(fromPosition);

        mData.add(toPosition, item);
        mLastRemovedPosition = -1;
    }

    public static final class ConcreteData extends Data {

        private final long mId;
        private final String mText;
        private final int mViewType;
        private final int mSwipeReaction;
        private boolean mPinnedToSwipeLeft;

        ConcreteData(long id, int viewType, String text, int swipeReaction) {
            mId = id;
            mViewType = viewType;
            mText = makeText(id, text, swipeReaction);
            mSwipeReaction = swipeReaction;
        }

        private static String makeText(long id, String text, int swipeReaction) {

            return text;
        }

        @Override
        public int getViewType() {
            return mViewType;
        }

        @Override
        public long getId() {
            return mId;
        }

        @Override
        public String toString() {
            return mText;
        }

        @Override
        public String getText() {
            return mText;
        }
    }
}
