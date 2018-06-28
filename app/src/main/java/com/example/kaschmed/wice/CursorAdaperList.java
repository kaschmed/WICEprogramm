package com.example.kaschmed.wice;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;

/**
 * Created by Manu on 30.05.18.
 */

public class CursorAdaperList extends CursorAdapter {

    public CursorAdaperList(final Context context, final Cursor cursor) {
        super(context, cursor, 0);
    }
    @Override
    public View newView(final Context context, final Cursor cursor, final ViewGroup viewGroup){
        return LayoutInflater.from(context()).inflate(R.layout.)
        )
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

    }
}
