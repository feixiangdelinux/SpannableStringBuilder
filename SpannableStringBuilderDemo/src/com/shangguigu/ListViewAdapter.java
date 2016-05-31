package com.shangguigu;

import java.util.List;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListViewAdapter extends BaseAdapter {

	private Context context;
	private List<SpannableStringBuilder> list;
	private TextView tvShowText;

	public ListViewAdapter(Context context, List<SpannableStringBuilder> list) {
		this.context = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = View.inflate(context, R.layout.item_listview, null);
		tvShowText = (TextView) view.findViewById(R.id.tvShowText);
		tvShowText.append(position + ": ");
		tvShowText.append(list.get(position));
		tvShowText.setMovementMethod(LinkMovementMethod.getInstance());// �����ӵĵ���¼���Ӧ�ı�Ҫһ�����
		return view;
	}

}
