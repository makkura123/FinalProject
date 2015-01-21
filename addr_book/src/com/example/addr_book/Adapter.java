package com.example.addr_book;

import java.util.ArrayList;

import com.example.addr_book.contactInfo;
import com.example.addr_book.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class Adapter extends BaseAdapter{
	private Context context;
	private ArrayList<contactInfo> contactInfo;
	private LayoutInflater inflater;
	private ViewHolder holder;

	public Adapter(Context context,ArrayList<contactInfo> contactInfo) {
		this.context = context;
		this.contactInfo = contactInfo;
		inflater = LayoutInflater.from(context);
	}	

	public int getCount() {
		return contactInfo.size();
	}
	public Object getItem(int position) {
		return null;
	}
	public long getItemId(int position) {
		return 0;
	}

	public View getView(int position, View convertView, ViewGroup parent) {

		if(convertView == null){
			convertView = inflater.inflate(R.layout.layout_adapter, null);
			holder = new ViewHolder();

			//holder.contactPhotoView = (ImageView) convertView.findViewById(R.id.contactPhoto);
			holder.contactNameView = (TextView) convertView.findViewById(R.id.contactName);
			holder.phoneNumberView = (TextView) convertView.findViewById(R.id.phoneNumber);
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		 contactInfo infoBean = contactInfo.get(position);
		 /*to set the content*/
		//holder.contactPhotoView.setImageBitmap(infoBean.getContactPhoto());
		holder.contactNameView.setText(infoBean.getContactName());
		holder.phoneNumberView.setText(infoBean.getPhoneNumber());

		return convertView;
	}

	private final class ViewHolder{
	//	private ImageView contactPhotoView;
		private TextView contactNameView;
		private TextView phoneNumberView;
	}

}
