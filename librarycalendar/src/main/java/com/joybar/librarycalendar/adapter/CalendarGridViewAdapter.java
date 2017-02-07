package com.joybar.librarycalendar.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.joybar.librarycalendar.R;
import com.joybar.librarycalendar.data.CalendarDate;
import com.joybar.librarycalendar.utils.DateUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by joybar on 2/24/16.
 */
public class CalendarGridViewAdapter extends BaseAdapter {

    private List<CalendarDate> mListData = new ArrayList<>();

    private Context context;

    public CalendarGridViewAdapter(List<CalendarDate> mListData,Context context) {
        this.mListData = mListData;
        this.context=context;
    }

    public List<CalendarDate> getListData() {
        return mListData;
    }


    public int getCount() {
        return mListData.size();
    }


    public Object getItem(int position) {
        return position;
    }



    public long getItemId(int position) {
        return position;
    }


    public View getView(final int position, View convertView, final ViewGroup parent) {
        ViewHolder viewHolder = null;
        CalendarDate calendarDate = mListData.get(position);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) parent.getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_calendar, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tv_day.setText((calendarDate.getSolar().solarDay)+"");

        String str;

        if(!TextUtils.isEmpty(calendarDate.getSolar().solar24Term)){
            str =  calendarDate.getSolar().solar24Term;
        }else if(!TextUtils.isEmpty(calendarDate.getSolar().solarFestivalName)){
            str = calendarDate.getSolar().solarFestivalName;
        }else{
            str = calendarDate.getLunar().getChinaDayString(mListData.get(position).getLunar().lunarDay);
        }

        viewHolder.tv_lunar_day.setText(str);
        if(mListData.get(position).isInThisMonth()){
            viewHolder.tv_day.setTextColor(Color.parseColor("#000000"));
        }else{
            viewHolder.tv_day.setTextColor(Color.parseColor("#D7D7D7"));
            viewHolder.tv_lunar_day.setTextColor(Color.parseColor("#D7D7D7"));

        }
        if(DateUtils.getDay()==calendarDate.getSolar().solarDay)
        {
            viewHolder.tv_day.setTextColor(context.getResources().getColor(R.color.color_red));
            viewHolder.tv_lunar_day.setTextColor(context.getResources().getColor(R.color.color_red));
        }
        return convertView;
    }


    public static class ViewHolder {
        private TextView tv_day;
        private TextView tv_lunar_day;
        public ViewHolder(View itemView) {
            tv_day = (TextView) itemView.findViewById(R.id.tv_day);
            tv_lunar_day = (TextView) itemView.findViewById(R.id.tv_lunar_day);
        }

    }



}

