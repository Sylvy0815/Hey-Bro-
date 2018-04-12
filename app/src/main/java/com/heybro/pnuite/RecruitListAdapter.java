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

public class RecruitListAdapter extends BaseAdapter{

    private Context context;
    private List<Recruit> userList;

    public RecruitListAdapter(Context context, List<Recruit> userList){
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
        View v = View.inflate(context, R.layout.recruit, null);
        final TextView recruitPosition = (TextView) v.findViewById(R.id.recruitPosition);
        TextView recruitLocation = (TextView) v.findViewById(R.id.recruitLocation);
        TextView recruitDate = (TextView) v.findViewById(R.id.recruitDate);

        recruitPosition.setText(userList.get(i).getRecruitPosition());
        recruitLocation.setText(userList.get(i).getRecruitLocation());
        recruitDate.setText(userList.get(i).getRecruitDate());

        v.setTag(userList.get(i).getRecruitPosition());

        return v;
    }
}
