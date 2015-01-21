package com.example.addr_book;

import java.util.ArrayList;
import java.util.Arrays;
import java.io.InputStream;  

import android.app.Activity;
import android.content.ContentResolver;  
import android.content.ContentUris;  
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;  
import android.graphics.Bitmap;  
import android.graphics.BitmapFactory;  
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;  
import android.provider.ContactsContract.CommonDataKinds.Phone;  
import android.provider.ContactsContract.CommonDataKinds.Photo;  
import android.text.TextUtils;  
//import android.view.LayoutInflater;  
//import android.view.View;
//import android.view.ViewGroup;  
import android.view.View.OnClickListener;
import android.widget.AdapterView;
//import android.widget.BaseAdapter;  
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
//import android.widget.TextView; 
//import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity {
	    Context mContext = null;  
	 
	    private static final String[] PHONES_PROJECTION = new String[] {  
	        Phone.DISPLAY_NAME, Phone.NUMBER, Phone.PHOTO_ID,Phone.CONTACT_ID };  
 
	    private static final int PHONES_DISPLAY_NAME_INDEX = 0;  
 
	    private static final int PHONES_NUMBER_INDEX = 1;  

	    private static final int PHONES_PHOTO_ID_INDEX = 2;  
 
	    private static final int PHONES_CONTACT_ID_INDEX = 3;  
 
	    private ArrayList<String> mContactsName = new ArrayList<String>();  

	    private ArrayList<String> mContactsNumber = new ArrayList<String>();  
 
	    private ArrayList<Bitmap> mContactsPhonto = new ArrayList<Bitmap>();  
	  
	    /**get the contacts information in the phone**/  
	   private void getPhoneContacts() {  
	    ContentResolver resolver = mContext.getContentResolver();  
	    Cursor phoneCursor = resolver.query(Phone.CONTENT_URI,PHONES_PROJECTION, null, null, null);  
	    
	    if (phoneCursor != null) {  
	        while (phoneCursor.moveToNext()) {  
	        String phoneNumber = phoneCursor.getString(PHONES_NUMBER_INDEX);  
	      
	        if (TextUtils.isEmpty(phoneNumber))  
	            continue;  
	        String contactName = phoneCursor.getString(PHONES_DISPLAY_NAME_INDEX);  
	          
	        Long contactid = phoneCursor.getLong(PHONES_CONTACT_ID_INDEX);  
	   
	        Long photoid = phoneCursor.getLong(PHONES_PHOTO_ID_INDEX);  
	         
	        Bitmap contactPhoto = null;  
	 
	        if(photoid > 0 ) {  
	            Uri uri =ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI,contactid);  
	            InputStream input = ContactsContract.Contacts.openContactPhotoInputStream(resolver, uri);  
	            contactPhoto = BitmapFactory.decodeStream(input);  
	        }else {  
	            contactPhoto = BitmapFactory.decodeResource(getResources(), R.drawable.photo);  
	        }  
	          
	        mContactsName.add(contactName);  
	        mContactsNumber.add(phoneNumber);  
	        mContactsPhonto.add(contactPhoto);  
	        }  
	 
	        phoneCursor.close();  
	    }  
	    }  
	     
	 
	    private ArrayList<contactInfo> infoBeans = new ArrayList<contactInfo>();
		private ListView listView;
		private Adapter adapter;
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	    	mContext = this;
	    	super.onCreate(savedInstanceState);
	        getPhoneContacts();
	        setContentView(R.layout.activity_main);
	        listView = (ListView) findViewById(R.id.mainview);
	        
	        /*thansform the arraylist to array*/
	        String[] value1 = new String[mContactsName.size()];
	        String[] value2 = new String[mContactsName.size()];
	        value1 = (String[]) mContactsName.toArray(new String[mContactsName.size()]);
	        value2 = (String[]) mContactsNumber.toArray(new String[mContactsName.size()]);
	        
	        contactInfo[] bean = new contactInfo[mContactsName.size()];
	        for(int i=0;i<mContactsName.size();i++){
	        	bean[i] = new contactInfo();
	        	bean[i].setContactName(value1[i]);
	        	bean[i].setPhoneNumber(value2[i]);
	        	infoBeans.add(bean[i]);
	        	
	        }
	        /*the adapter*/
			 adapter = new Adapter(this, infoBeans);
		     listView.setAdapter(adapter);
	    }
	    
	     
}