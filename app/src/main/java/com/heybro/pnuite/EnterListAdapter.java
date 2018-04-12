package com.heybro.pnuite;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.List;

/**
 * Created by hjune08 on 2017-12-06.
 */

public class EnterListAdapter extends BaseAdapter{

    private Context context;
    private List<Enter> userList;

    public EnterListAdapter(Context context, List<Enter> userList){
        this.context=context;
        this.userList=userList;
    }

    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public Object getItem(int i) {
        return userList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        View v = View.inflate(context, R.layout.enter, null);
        final TextView enterPosition = (TextView) v.findViewById(R.id.enterPosition);
        TextView enterLocation = (TextView) v.findViewById(R.id.enterLocation);
        TextView enterDate = (TextView) v.findViewById(R.id.enterDate);

        enterPosition.setText(userList.get(i).getEnterPosition());
        enterLocation.setText(userList.get(i).getEnterLocation());
        enterDate.setText(userList.get(i).getEnterDate());

        v.setTag(userList.get(i).getEnterPosition());

        return v;
    }
}
