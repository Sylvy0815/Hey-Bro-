package com.heybro.pnuite;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.List;

/**
 * Created by hjune08 on 2017-12-06.
 */

public class TeamListAdapter extends BaseAdapter{

    private Context context;
    private List<Team> teamList;

    public TeamListAdapter(Context context, List<Team> teamList){
        this.context=context;
        this.teamList=teamList;
    }

    @Override
    public int getCount() {
        return teamList.size();
    }

    @Override
    public Object getItem(int i) {
        return teamList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        View v = View.inflate(context, R.layout.team, null);
        ImageView teamIcon = (ImageView) v.findViewById(R.id.teamIcon);
        final TextView teamName = (TextView) v.findViewById(R.id.teamName);
        TextView teamLevel = (TextView) v.findViewById(R.id.teamLevel);
        TextView teamLocation = (TextView) v.findViewById(R.id.teamLocation);

        //teamIcon.setImageDrawable(R.drawable.(teamList.get(i).getTeamIcon()).toString());
        teamName.setText(teamList.get(i).getTeamName());
        teamLevel.setText(teamList.get(i).getTeamLevel());
        teamLocation.setText(teamList.get(i).getTeamLocation());

        v.setTag(teamList.get(i).getTeamName());

        return v;
    }
}
